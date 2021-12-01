import java.io.File

fun main(args: Array<String>) {
    val lines = File("src/main/resources/input.txt").readLines()
        .map { it.toInt() }
    val sums = mutableListOf<Int>()
    for(i in lines.indices) {
        if(i+2 < lines.size)
        sums += lines.subList(i, i+3).sum()
    }
    var count = 0
    for( i in 1 until sums.size) {
        if(sums[i-1]<sums[i])
            count ++;
    }
    println(count)

}
