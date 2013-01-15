package com.gmail.ikeike443.pivotool
import java.net.URLEncoder
import play.api.libs.ws._
import play.api.libs.concurrent._

object App {
  val pivo_api_url = "https://www.pivotaltracker.com/services/v3/"
  val pivo_pj = "projects/%s"
  val pivo_stories = """/stories"""
  val pivo_filter = """?filter="""
  val pivo_filter_label = "label:"
  val pivo_wquote = "\""
  val story = """<story>%s%s%s%s</story>"""

  def main(args: Array[String]) {
    import play.core.StaticApplication
    new StaticApplication(new java.io.File("."))

    val url_src = pivo_api_url + pivo_pj.format(args(0)) + pivo_stories + pivo_filter +
      URLEncoder.encode(pivo_filter_label + pivo_wquote) + args(1) + URLEncoder.encode(pivo_wquote)
    val url_to = pivo_api_url + pivo_pj.format(args(2)) + pivo_stories
    println(url_src)
    println(url_to)
    WS.url(url_src)
      .withHeaders("X-TrackerToken" -> args(3)).get.await.get.xml.child
      .foreach { x =>
        val body = story format ((x \ "story_type"), (x \ "name"), (x \ "requested_by"), (x \ "labels"))
        println(body)
        val res = WS.url(url_to)
          .withHeaders("X-TrackerToken" -> args(3), "Content-Type" -> "application/xml")
          .post(body).await.get
        println(res.xml)
      }
  }
}
