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
                for(x in i-1 downTo 0){
                    if(lines[x][j] == '#'){
                        occupiedCounter++
                        break
                    }
                    if(lines[x][j] == 'L'){
                        break
                    }
                }

                //down
                for(x in i+1 until lines.size){
                    if(lines[x][j] == '#'){
                        occupiedCounter++
                        break
                    }
                    if(lines[x][j] == 'L'){
                        break
                    }
                }

                //left
                for(x in j-1 downTo  0){
                    if(lines[i][x] == '#'){
                        occupiedCounter++
                        break
                    }
                    if(lines[i][x] == 'L'){
                        break
                    }
                }

                //right
                for(x in j+1 until  lines[i].size){
                    if(lines[i][x] == '#'){
                        occupiedCounter++
                        break
                    }
                    if(lines[i][x] == 'L'){
                        break
                    }
                }

                //diagonal
                //upright
                var tempj = j+1
                for(x in i-1 downTo 0){
                    if(tempj>= lines[x].size) break
                    if(lines[x][tempj] == '#'){
                        occupiedCounter++
                        break
                    }
                    if(lines[x][tempj] == 'L'){
                        break
                    }
                    tempj++
                }

                //upleft
                tempj = j-1
                for(x in i-1 downTo 0){
                    if(tempj<0) break
                    if(lines[x][tempj] == '#'){
                        occupiedCounter++
                        break
                    }
                    if(lines[x][tempj] == 'L'){
                        break
                    }
                    tempj--
                }

                //downleft

                tempj = j-1
                for(x in i+1 until lines.size){
                    if(tempj<0) break
                    if(lines[x][tempj] == '#'){
                        occupiedCounter++
                        break
                    }
                    if(lines[x][tempj] == 'L'){
                        break
                    }
                    tempj--
                }
                //downright
                tempj = j+1
                for(x in i+1 until lines.size){
                    if(tempj>= lines[x].size) break
                    if(lines[x][tempj] == '#'){
                        occupiedCounter++
                        break
                    }
                    if(lines[x][tempj] == 'L'){
                        break
                    }
                    tempj++
                }

                if (lines[i][j] == 'L' && occupiedCounter == 0) {
                    futureState[i][j] = '#'
                    occupiedSeats++
                }
                if (lines[i][j] == '#' && occupiedCounter >= 5) {
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
