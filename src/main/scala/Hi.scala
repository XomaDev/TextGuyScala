import scala.io.StdIn
import scala.util.control.Breaks.{break, breakable}

@main def hello(): Unit = {
  val trash = "\uD83D\uDDD1"
  val happyRight = "(> ^_^)>"
  val happyLeft = "<(^_^ <)"
  val interval = 500

  print("> ")
  var text = StdIn.readLine()
  val textSize = text.length

  for (i <- 1 to textSize) {
    val l = text.charAt(0).toString
    var goingRight = true

    var leftSpace = 0
    var rightSpace = 10 + i

    for (j <- 1 to 21 + (i * 2)) {
      println(
        trash +
          (" " * leftSpace) +
          (if (goingRight) happyRight else l + happyLeft) +
          (" " * rightSpace) +
          text
      )

      Console.flush()
      Thread.sleep(interval)

      if (goingRight && leftSpace >= 10 + i) {
        goingRight = false
        leftSpace = 10 + i
        rightSpace = 0

        text = text.substring(1)
      } else if (!goingRight && rightSpace >= 10 + i) {
        println(
          trash +
            happyLeft +
            (" " * (10 + i + 1)) +
            text
        )
        Console.flush()
        Thread.sleep(interval)
      }
      if (goingRight) {
        leftSpace += 1
        rightSpace -= 1
      } else {
        leftSpace -= 1
        rightSpace += 1
      }
    }
  }
}