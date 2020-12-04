import java.io.File

fun main(args: Array<String>) {
    val lines = File("src/main/resources/input.txt")
            .readLines()
            .joinToString { it }
            .split(" ,")
            .map { it.replace(",", "") }

    val regex = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid", "cid")
            .associateWith { Regex("(?<key>${it}):(?<value>\\S*)") }


    var parsedLines = mutableListOf<String>()
    lines.forEach { line ->
        var fieldsFound = 0
        regex.forEach { if (it.value.containsMatchIn(line)) fieldsFound++ }
        if (fieldsFound == 8) {
            parsedLines.add(line)
        } else if (fieldsFound == 7) {
            if (!regex["cid"]!!.containsMatchIn(line)) {
                parsedLines.add(line)
            }
        }
    }
    var validLines = 0
    val validEcls = listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
    parsedLines.forEach { line ->

        var validFields = 0
        var year = regex.getValue("byr").find(line)!!.groupValues[2].toInt()
        if (year in 1920..2002) validFields++

        year = regex.getValue("iyr").find(line)!!.groupValues[2].toInt()
        if (year in 2010..2020) validFields++

        year = regex.getValue("eyr").find(line)!!.groupValues[2].toInt()
        if (year in 2020..2030) validFields++

        val hgt = regex.getValue("hgt").find(line)!!.groupValues[2]
        if (hgt.contains("cm")) {
            if (hgt.replace("cm", "").toInt() in 150..193) validFields++
        } else {
            if (hgt.replace("in", "").toInt() in 59..76) validFields++
        }

        if(Regex("(?<key>${"hcl"}):(?<value>#(\\d|[a-z]){6})").containsMatchIn(line))validFields++

        val ecl = regex.getValue("ecl").find(line)!!.groupValues[2]
        if(validEcls.contains(ecl))validFields++

        if(regex.getValue("pid").find(line)!!.groupValues[2].matches(Regex("\\A\\d{9}\\Z")))validFields++

        if (validFields == 7) validLines++
    }
    println(validLines)
}


