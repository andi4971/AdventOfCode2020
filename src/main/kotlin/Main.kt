import java.io.File

fun main(args: Array<String>) {
    var lines = File("src/main/resources/input.txt").readLines().first().split(',').map { it.toInt() }.toMutableList()

    var currentNumber = 0
    var previousNumber = 0
    val numberMap = hashMapOf<Int, Int>()

    val calledNumbers = mutableListOf<Int>()
    for (turn in 1..30000000) {
        previousNumber = currentNumber
        if (lines.isNotEmpty()) {
            currentNumber = lines.removeFirst()
            numberMap[currentNumber] = turn
            calledNumbers.add(currentNumber)
            continue
        }
        if(calledNumbers.count { it == previousNumber } == 1){
            //first time called
            currentNumber = 0
            calledNumbers.add(currentNumber)
        }else{
            currentNumber = turn -1 - numberMap[previousNumber]!!
            calledNumbers.add(currentNumber)
        }
        numberMap[previousNumber] = turn-1
        println((turn.toDouble()/30000000.0)*100)
    }
    println(currentNumber)
}
