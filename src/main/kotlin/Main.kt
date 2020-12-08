import java.io.File

fun main(args: Array<String>) {
    val lines = File("src/main/resources/input.txt").readLines()
        .map { it.split(" ") }
    for (outerLoopCounter in lines.indices) {
        if(lines[outerLoopCounter][0] == "acc") continue

        val copyList = lines.toMutableList()
        var changed = false

        if (lines[outerLoopCounter][0] == "jmp") {
            copyList[outerLoopCounter] = listOf("nop", lines[outerLoopCounter][1])
            changed = true
        }
        if(!changed && lines[outerLoopCounter][0] == "nop"){
            copyList[outerLoopCounter] = listOf("jmp", lines[outerLoopCounter][1])
        }
        val erg = runProgram(copyList)
        erg?.let { println(it) }
    }
}

fun runProgram(lines: List<List<String>>): Int? {
    var accumulator = 0
    var i = 0
    val visitedInstructions = mutableListOf<String>()
    while (true) {
        if(i==lines.size) return accumulator
        var currLine = "$i ${lines[i][0]} ${lines[i][1]}"
        if (visitedInstructions.contains(currLine)) {
            return null
        }
        visitedInstructions.add(currLine)
        when (lines[i][0]) {
            "acc" -> {
                val accInc = lines[i][1].toInt()
                accumulator += accInc
                i++
            }
            "jmp" -> {
                val jumper = lines[i][1].toInt()
                i += jumper
            }
            "nop" -> {
                i++
            }
        }
    }
}
