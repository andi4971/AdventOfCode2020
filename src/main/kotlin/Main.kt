import java.io.File

fun main(args: Array<String>) {
    val lines = File("src/main/resources/input.txt").readLines()
            .joinToString { it }
            .split(" ,")
            .map { it.replace(",", "") }
    var count = 0
    lines.forEach { line ->
        val answers = line.trimStart().split(" ")
        answers[0].forEach { answer ->
            var contains = true;
            answers.forEach { singleAnswers ->
                if (!singleAnswers.contains(answer)) contains = false;
            }
            if (contains) count++
        }
    }
    println(count)
}