import kotlinx.html.js.onClickFunction
import kotlinx.browser.window
import react.*
import react.dom.*

external interface VideoListProps : Props{
    var videos: List<Video>
}

val videoList = fc<VideoListProps> { props ->
    for (video in props.videos){
        p {
            key = video.id.toString() //react optimization for lists, identify the key
            +"${video.speaker}: ${video.title}"
        }
    }
}
