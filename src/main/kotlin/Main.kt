import java.io.File
import java.util.*
import kotlin.collections.ArrayDeque

fun main(args: Array<String>) {
    val lines = File("src/main/resources/input.txt").readLines().map { it.toLong() }
    val queue = ArrayDeque<Long>()
    val initialLines = 25
    val invalidNumber = 57195069
    queue.addAll(lines.take(initialLines))

    for (i in initialLines..lines.size) {
        var currentNumber = lines[i]
        val possibleProducts = mutableListOf<Long>()
        queue.forEach { ele1 ->
            queue.forEach { ele2 ->
                if (ele1 != ele2) {
                  val sum = ele1+ele2
                    if(!possibleProducts.contains(sum))
                    {
                        possibleProducts.add(sum)
                    }
                }
            }
        }
        if(possibleProducts.contains(currentNumber)){
            queue.add(currentNumber)
            queue.removeFirst()
        }else{
            println(currentNumber)
        }
    }
}
