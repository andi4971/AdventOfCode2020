import org.jgrapht.Graph
import org.jgrapht.alg.shortestpath.AllDirectedPaths
import org.jgrapht.graph.DefaultEdge
import org.jgrapht.graph.SimpleDirectedGraph
import java.io.File
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayDeque

fun main(args: Array<String>) {
    var lines = File("src/main/resources/input.txt").readLines().map { it.toLong() }.sorted().toMutableList()
    val z = 0L
    lines.add(0, z)
    lines.add(lines.maxOrNull()!! + 3)
    val max = lines.maxOrNull()!!
    val graph = SimpleDirectedGraph<Long,DefaultEdge>(DefaultEdge::class.java)
    for (i in 0..lines.size-2) {
        if(!graph.containsVertex(lines[i])){
            graph.addVertex(lines[i])
        }
        if(!graph.containsVertex(lines[i+1])){
            graph.addVertex(lines[i+1])
        }
        if(!graph.containsEdge(lines[i],lines[i+1]))
        {
            graph.addEdge(lines[i],lines[i+1])
        }

        if (lines[i]+1 == lines[i + 1]) {
        }
        if (lines[i]+2 == lines[i + 1]) {

        }
        if (lines[i]+3 == lines[i + 1]) {
        }
        try {
            if (lines[i]+2 == lines[i + 2]) {
                if(!graph.containsVertex(lines[i+2])){
                    graph.addVertex(lines[i+2])
                }
                if(!graph.containsEdge(lines[i],lines[i+2]))
                {
                    graph.addEdge(lines[i],lines[i+2])
                }
            }
            if (lines[i]+3 == lines[i + 3]) {
                if(!graph.containsVertex(lines[i+3])){
                    graph.addVertex(lines[i+3])
                }
                if(!graph.containsEdge(lines[i],lines[i+3]))
                {
                    graph.addEdge(lines[i],lines[i+3])
                }
            }
        }catch (e: Exception){

        }
    }
    println(AllDirectedPaths(graph).getAllPaths(z,max,true,null).size)
}
