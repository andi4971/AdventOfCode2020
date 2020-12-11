import java.io.File

fun main(args: Array<String>) {
    var lines = File("src/main/resources/input.txt").readLines().map { it.toCharArray() }

    var futureState: List<Array<Char>>
    var previousOccupiedSeats = -1
    var occupiedSeats = 0
    while (occupiedSeats != previousOccupiedSeats) {
        futureState = lines.map { it.toList().toTypedArray() }
        previousOccupiedSeats = occupiedSeats
        for (i in lines.indices) {

            for (j in lines[i].indices) {
                var occupiedCounter = 0
                //up
                if (i - 1 >= 0 && lines[i - 1][j] == '#') {
                    occupiedCounter++
                }

                //down
                if (i + 1 < lines.size && lines[i + 1][j] == '#') {
                    occupiedCounter++
                }

                //left
                if (j - 1 >= 0 && lines[i][j - 1] == '#') {
                    occupiedCounter++
                }
                //right
                if (j + 1 < lines[i].size && lines[i][j + 1] == '#') {
                    occupiedCounter++
                }
                //diagonal
                //upright
                if (j + 1 < lines[i].size && i - 1 >= 0 && lines[i - 1][j + 1] == '#') occupiedCounter++

                //upleft
                if (j - 1 >= 0 && i - 1 >= 0 && lines[i - 1][j - 1] == '#') occupiedCounter++
                //downleft
                if (j - 1 >= 0 && i + 1 < lines.size && lines[i + 1][j - 1] == '#') occupiedCounter++
                //downright
                if (j + 1 < lines[i].size && i + 1 < lines.size && lines[i + 1][j + 1] == '#') occupiedCounter++

                if (lines[i][j] == 'L' && occupiedCounter == 0) {
                    futureState[i][j] = '#'
                    occupiedSeats++
                }
                if (lines[i][j] == '#' && occupiedCounter >= 4) {
                    futureState[i][j] = 'L'
                    occupiedSeats--
                }
            }
        }
        lines = futureState.map { it.toCharArray() }

        lines.forEach {
            println(it.joinToString(""))
        }
        println()

    }

    println(occupiedSeats)
}
