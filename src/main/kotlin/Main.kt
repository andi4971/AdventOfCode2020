import java.io.File

fun main(args: Array<String>) {
    val lines = File("src/main/resources/input.txt").readLines().map { it.toCharArray() }
    var xOffsets = arrayOf(1,3,5,7,1)
    var yOffsets = arrayOf(1,1,1,1,2)
    val treeCounters = mutableListOf<Int>()
    for (i in xOffsets.indices)
    {
        var treeCounter = 0
        var x = 0

        for(line in 0..lines.size -(1+yOffsets[i]) step yOffsets[i]) {
            x+=xOffsets[i]
            if(x >= lines[0].size)
            {
                x -= lines[0].size
            }
            if(lines[line+yOffsets[i]][x] == '#') treeCounter++
        }
        treeCounters.add(treeCounter)
    }

    println(treeCounters.reduce{acc, i -> acc * i})
}


