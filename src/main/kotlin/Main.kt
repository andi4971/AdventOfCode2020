import java.io.File

fun main(args: Array<String>) {
    val lines = File("src/main/resources/input.txt").readLines()
    val seatIds = mutableListOf<Int>()
    lines.forEach { line ->
        val row = Integer.parseInt(line.substring(0,7).replace("F","0").replace("B","1"),2)
        val seat = Integer.parseInt(line.substring(7).toString().replace("L","0").replace("R","1"),2)
        val seatId = row * 8 + seat
       seatIds.add(seatId)
    }
    seatIds.sort()
    for(i in 0..seatIds.size-2)
    {
        if(seatIds[i+1]-seatIds[i] > 1) {
            println(seatIds[i + 1])
            println(seatIds[i])
        }
    }

}


