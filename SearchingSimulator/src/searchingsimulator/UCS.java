/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchingsimulator;

/**
 *
 * @author Nathanael Adi Trianto - 6181901041
 */
import java.util.ArrayList;
import java.util.PriorityQueue;

public class UCS {
    drawGraph dGraph;
    
    UCS(drawGraph dg){
        dGraph = dg;
    }
    
    void doSearch(){
        dGraph.dg_nodes = new ArrayList<Node>();
        for (Node n : dGraph.graph.nodes) {
            dGraph.dg_nodes.add(n);
        }

        boolean found = false;
        PriorityQueue<Node> openPriorityQueue = new PriorityQueue<>((n1, n2) ->
            Double.compare(n1.pathCost, n2.pathCost));

        dGraph.closedList = new ArrayList<Node>();
        
        Node initialNode = dGraph.graph.nodes.get(dGraph.initNode);
        initialNode.pathCost = 0.0;
        openPriorityQueue.add(initialNode);
        dGraph.dg_nodes.remove(initialNode);
        
        while (!openPriorityQueue.isEmpty() && !found) {
            Node currentNode = openPriorityQueue.poll(); // remove node with lowest path cost
            dGraph.closedList.add(currentNode);
            dGraph.delay(1000);
            
            if (currentNode.nodeNr != dGraph.goalNode) {
                for (Node child : dGraph.graph.nodes) {
                    if (dGraph.dg_nodes.contains(child) && // not visited yet
                        dGraph.graph.adjMatrix[currentNode.nodeNr][child.nodeNr] < 1000000.0) {
                        double newPathCost = currentNode.pathCost +
                                            dGraph.graph.adjMatrix[currentNode.nodeNr][child.nodeNr];
                        if (newPathCost < child.pathCost) {
                            child.pathCost = newPathCost;
                            child.parent = currentNode;
                        }
                        openPriorityQueue.add(child);
                        dGraph.dg_nodes.remove(child);
                    }
                }
            } else {
                found = true;
            }
            dGraph.paint(dGraph.getGraphics());
            dGraph.delay(1000);
        }
    }
}
