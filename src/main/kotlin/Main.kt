import java.io.File

fun main(args: Array<String>) {
    var lines = File("src/main/resources/input.txt").readLines()

    val fields = lines.takeWhile { it != "" }.associate {
        val split = it.split(": ")
        val name = split[0]
        val ranges = split[1].split(" or ").map { rng ->
            val range = rng.split("-")
            return@map IntRange(range[0].toInt(), range[1].toInt())
        }
        name to (ranges[0] to ranges[1])
    }


    val myTicket = lines[fields.size + 2]

    val nearbyTickets = lines.subList(fields.size + 5, lines.size).map { it.split(",").map { i -> i.toInt() } }
    val removableTickets = mutableSetOf<List<Int>>()
    nearbyTickets.forEach { ticket ->

        for (i in ticket.indices) {
            var validFields = 0
            fields.forEach { field ->
                if (field.value.first.contains(ticket[i]) || field.value.second.contains(ticket[i])) validFields++
            }
            if(validFields == 0){
                removableTickets.add(ticket)
            }
        }
    }
    val validTickets = nearbyTickets - removableTickets
    println(validTickets.size)
}
