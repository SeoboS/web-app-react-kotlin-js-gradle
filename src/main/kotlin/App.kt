import kotlinx.browser.document
import kotlinx.coroutines.async
import kotlinx.css.*
import react.*
import react.dom.*
import kotlinx.browser.window
import kotlinx.coroutines.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import styled.css
import styled.styledDiv
import styled.styledH1

suspend fun fetchVideo(id: Int): Video{
    val response = window
        .fetch("https://my-json-server.typicode.com/kotlin-hands-on/kotlinconf-json/videos/$id")
        .await()
        .text()
        .await()
    return Json.decodeFromString(response)
}

suspend fun fetchVideos(): List<Video> = coroutineScope {
    (1..25).map { id ->
        async {
            fetchVideo(id)
        }
    }.awaitAll()
}
var mainScope = MainScope()

val app = fc<Props> {
    var currentVideo: Video? by useState(null)
    var unwatchedVideos: List<Video> by useState(emptyList())
    var watchedVideos: List<Video> by useState(emptyList())
    useEffectOnce {
        mainScope.launch {
            unwatchedVideos = fetchVideos()
        }
    }
//        styledH1{
//            css{
//                fontFamily = "sans-serif"
//            }
//            +"KotlinConf Explorer!"
//        }
        h1{
            +"KotlinConf Explorer!"
        }
        div{
            h3{
                +"Videos to Watch"
            }
            child(videoList){
                attrs {
                    videos = unwatchedVideos
                }
            }
            h3{
                +"Videos Watched"
            }
            child(videoList){
                attrs {
                    videos = watchedVideos
                }
            }
        }
        img{
            attrs{
                src = "https://www.looper.com/img/gallery/craziest-nicolas-cage-performances/vampires-kiss-1988.jpg"
            }
        }

//        styledDiv{
//            css{
//                position = Position.absolute
//                top = 10.px
//                right = 10.px
//            }
            div{
            h3{
                +"John Doe"
            }
            img{
                attrs{
                    src = "https://via.placeholder.com/640x360.png?text=Video+Player+Placeholder"
                }
            }
        }
}