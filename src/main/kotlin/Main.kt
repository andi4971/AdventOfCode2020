import org.jgrapht.Graph
import org.jgrapht.GraphPath
import org.jgrapht.alg.shortestpath.DijkstraShortestPath
import org.jgrapht.graph.*
import java.io.File

fun main(args: Array<String>) {
    val lines = File("src/main/resources/input.txt").readLines()
    val graph = SimpleDirectedWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge::class.java)

    //wavy green bags contain 1 posh black bags, 1 faded green bags, 4 wavy red bags

    lines.forEach { line ->
        val split = line.split("contain")
        val mainVertexName = split[0].trim()
        if (!graph.vertexSet().contains(mainVertexName)) {
            graph.addVertex(mainVertexName)
        }
        if (!split[1].contains("no other bags")) {
            val otherVertexes = split[1].split(",")
            otherVertexes
                    .map { it.trimStart() }
                    .forEach {
                        val cost = it.substring(0, 1).toDouble()
                        val name = it.substring(1).trim()
                        if (!graph.vertexSet().contains(name)) {
                            graph.addVertex(name)
                        }
                        val edge = graph.addEdge(mainVertexName, name)
                        graph.setEdgeWeight(edge, cost)
                    }
        }
    }
    var count = 0
    graph.vertexSet().toList().forEach {
        if (it != "shiny gold bags") {
            if (DijkstraShortestPath.findPathBetween(graph, it, "shiny gold bags") != null) count++
        }
    }
    println(count)


    println(calcWeight("shiny gold bags", graph))

}

fun calcWeight(vertex: String, graph: Graph<String, DefaultWeightedEdge>): Double {
    var weight = 0.0
    graph.outgoingEdgesOf(vertex).forEach {
        weight += graph.getEdgeWeight(it)
        weight +=  graph.getEdgeWeight(it)* calcWeight(graph.getEdgeTarget(it), graph)
    }
    return weight
}
