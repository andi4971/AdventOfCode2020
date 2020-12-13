import java.io.File
import kotlin.math.*

fun main(args: Array<String>) {
    var lines = File("src/main/resources/input.txt").readLines()
    val arrTime = lines[0].toDouble()
    val numbers = lines[1].split(',').mapNotNull { it.toDoubleOrNull() }

    var min = Double.MAX_VALUE
    var erg = 0.0
    numbers.forEach {
        val multiplier = ceil(arrTime / it)
        val calc = (it * multiplier) - arrTime
        if (calc < min) {
            min = calc
            erg = it * calc
        }
    }
    println(erg)

}
