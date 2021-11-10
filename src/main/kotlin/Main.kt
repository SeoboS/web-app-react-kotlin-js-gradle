import kotlinx.browser.document
import kotlinx.css.*
import react.dom.*
import styled.*

fun main() {
//    document.bgColor = "red"
    val unwatchedVideos = listOf(
        KotlinVideo(1, "Building and breaking things", "John Doe", "https://youtu.be/PsaFVLr8t4E"),
        KotlinVideo(2, "The development process", "Jane Smith", "https://youtu.be/PsaFVLr8t4E"),
        KotlinVideo(3, "The Web 7.0", "Matt Miller", "https://youtu.be/PsaFVLr8t4E")
    )
    val watchedVideos = listOf(
        KotlinVideo(4, "Mouseless development", "Tom Jerry", "https://youtu.be/PsaFVLr8t4E")
    )


    render(document.getElementById("root")){
        styledH1{
            css{
                fontFamily = "sans-serif"
            }
            +"KotlinConf Explorer!"
        }
        div{
            h3{
                +"Videos to Watch"
            }
            for (video in unwatchedVideos){
                p {
                    +"${video.speaker}: ${video.title}"
                }
            }
            h3{
                +"Vidoes Watched"
            }
            for(video in watchedVideos){
                p{
                    +"${video.speaker}: ${video.title}"
                }
            }
        }
        img{
            attrs{
                src = "https://www.looper.com/img/gallery/craziest-nicolas-cage-performances/vampires-kiss-1988.jpg"
            }
        }

        styledDiv{
            css{
                position = Position.absolute
                top = 10.px
                right = 10.px
            }
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
}