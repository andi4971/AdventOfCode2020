import java.io.File
import java.util.*
import kotlin.collections.ArrayDeque

fun main(args: Array<String>) {
    val lines = File("src/main/resources/input.txt").readLines().map { it.toLong() }
    val invalidNumber = 57195069L

    for (i in lines.indices) {
        var sum = 0L
        val elements = mutableListOf<Long>()
        for (j in i..lines.size-1) {
            sum += lines[j]
            elements.add(lines[j])
            if (sum == invalidNumber) {
                println(elements.minOrNull()!!.plus(elements.maxOrNull()!!))
            }
        }
    }
}
