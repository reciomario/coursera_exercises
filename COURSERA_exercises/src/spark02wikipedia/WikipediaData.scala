package src.spark02wikipedia

import java.io.File

object WikipediaData {

  private[spark02wikipedia] def filePath = {
    val resource = this.getClass.getClassLoader.getResource("wikipedia/wikipedia.dat")
   // if (resource == null) sys.error("Please download the dataset as explained in the assignment instructions")
    new File("resources/wikipedia.dat").getPath
  }

  private[spark02wikipedia] def parse(line: String): WikipediaArticle = {
    val subs = "</title><text>"
    val i = line.indexOf(subs)
    val title = line.substring(14, i)
    val text  = line.substring(i + subs.length, line.length-16)
    WikipediaArticle(title, text)
  }
}
