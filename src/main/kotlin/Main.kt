import java.io.File

fun main(args: Array<String>) {
    var lines = File("src/main/resources/input.txt").readLines()

    val inputMap = mutableListOf<Pair<String, List<String>>>()

    var currentMask = lines[0].substring(7)

    var currentMems = mutableListOf<String>()
    for (i in 1 until lines.size) {
        if (lines[i].startsWith("mask")) {
            inputMap.add(Pair(currentMask, currentMems))
            currentMask = lines[i].substring(7)
            currentMems = mutableListOf()
        } else {
            currentMems.add(lines[i])
        }
    }
    inputMap.add(Pair(currentMask, currentMems))

    val memMap = hashMapOf<Long, String>()
    var count = 0
    inputMap.forEach { input ->
        input.second.forEach {
            val split = it.split(" = ")
            val address =
                split[0].substring(4, split[0].length - 1).toLong().toString(2).padStart(36, '0').toCharArray()

            val tempVal = split[1].toLong().toString(2)
            val value = tempVal.padStart(36, '0').toCharArray()

            for (i in input.first.indices) {
                if (input.first[i] == '1') {
                    address[i] = '1'
                }
                if (input.first[i] == 'X') {
                    address[i] = 'X'
                }
            }
            val xCount = input.first.count { it == 'X' }
            val possibilities = Math.pow(2.0,input.first.count { it == 'X' }.toDouble())
            val possibleAddresses = mutableListOf<Long>()

            for(i in 0..possibilities.toLong()){

                val changeAddr = i.toString(2).padStart(xCount,'0')
                var tempAddr = address.concatToString()
                for(j in 0 until xCount){
                    tempAddr = tempAddr.replaceFirst('X',changeAddr[j])
                }
                possibleAddresses.add(tempAddr.toLong(2))
            }

            possibleAddresses.forEach { addr ->
                memMap[addr] = value.concatToString()
            }
        }
    }
    println(memMap.values.map { it.toLong(2) }.sum())

}
