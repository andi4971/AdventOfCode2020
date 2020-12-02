import java.io.File

fun main(args: Array<String>) {
    val lines = File("src/main/resources/input.txt").readLines()
    var correctPasswords = 0
    lines.forEach { line ->
        val split = line.split(':')
        val policyParts = split[0].split(' ')
        val policyOccurrence = policyParts[0].split('-').map { it.trim().toInt() }
        val policyLetter = policyParts[1][0]
        val content = split[1].trimStart()
        //9-10 m: mmmmnxmmmwm

        var count = 0
        if(content[policyOccurrence[0]-1]==policyLetter) count++
        if(content[policyOccurrence[1]-1]==policyLetter) count++

        if(count==1) correctPasswords++
    }
    println(correctPasswords)

}


