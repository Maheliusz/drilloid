package scaloid.example

import java.io.FileNotFoundException

/**
  * Created by Wojciech on 15.06.2017.
  */
class FileReader(val path : String) {
  val source = io.Source.fromFile(path)
  val lines = try {
    source.mkString
  } catch {
    case fnex  : FileNotFoundException => "ERR_NOT_FOUND"
  } finally source.close()
  val questions = lines.split("\n\n")

}
