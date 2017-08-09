package epam.idobrovolskiy.wikipedia.trending.time.extractor.stack

import epam.idobrovolskiy.wikipedia.trending.time.WikiDate

/**
  * Created by Igor_Dobrovolskiy on 08.08.2017.
  */
trait InYearExtractor extends BasicStackedDatesExtractor {

  private val re = """(?:[^\w]|^)[Ii]n\s{1,2}(\d{3,4})(?:[\s\.]|$)""".r //should "\?\!" be added as allowed ending?

  def extractInYearDates(id: Int, s: String): Iterator[WikiDateExtraction] =
    for {cMatch <- (re findAllIn s).matchData} yield
      WikiDateExtraction(
        WikiDate.AD(cMatch.group(1).toInt),
        cMatch.start(1),
        cMatch)

  abstract override protected def appendDates(id: Int, s: String, it: Iterator[WikiDateExtraction]) =
    super.appendDates(id, s, it ++ extractInYearDates(id, s))
}
