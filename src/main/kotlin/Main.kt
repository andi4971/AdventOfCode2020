import java.io.File
import java.math.BigDecimal
import java.math.BigInteger
import java.math.RoundingMode
import kotlin.math.ceil

fun main(args: Array<String>) {
    var lines = File("src/main/resources/input.txt").readLines()
    val arrTime = lines[0].toBigInteger()
    val numbers = lines[1].split(',')
    var startVal: BigInteger
    var multiplier = BigInteger.valueOf(5263157894736L)
    while (true) {
        var prevVal = numbers[0].toBigInteger() * multiplier
        startVal = numbers[0].toBigInteger() * multiplier
        println(startVal.toString())
        var found = true
        for (i in 1 until numbers.size) {
            if (numbers[i] == "x") {
                prevVal++
                continue
            }
            val numb = numbers[i].toBigInteger()
            //if ((prevVal + BigInteger.valueOf(1)) % numb == BigInteger.valueOf(0))
            /*val multi = prevVal.div(numb).setScale(0, RoundingMode.CEILING)
            val calc = (numb * multi) - prevVal*/
            /*if (calc == BigInteger.valueOf(1L))*/
            if ((prevVal + BigInteger.valueOf(1)) % numb == BigInteger.valueOf(0)) {
                prevVal++
                continue
            } else {
                found = false
                break
            }
        }
        if (found) break


        multiplier++
    }
    println(startVal)

}
