import java.io.File

fun main(args: Array<String>) {
    val lines = File("src/main/resources/input.txt").readLines().map { it.toInt() }
    lines.forEach { nrOne ->
        val multipliers1 = lines.filter { it !=nrOne  }
        multipliers1.forEach{ nrTwo ->
            val multipliers2 = multipliers1.filter {it != nrTwo}
            multipliers2.forEach {
                if(nrOne+nrTwo+it == 2020) println(nrOne*nrTwo*it)
            }
        }
    }

}


