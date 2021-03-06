package epam.idobrovolskiy.wikipedia.trending.time


/**
  * Created by Igor_Dobrovolskiy on 04.08.2017.
  */
case class WikiDateRange
(
  since: WikiDate,
  until: WikiDate
) extends AnyRef with Serializable

object WikiDateRange {
  val NoDateRange = WikiDateRange(WikiDate.NoDate, WikiDate.NoDate)
}
