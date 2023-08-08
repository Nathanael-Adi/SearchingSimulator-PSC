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

public class DFS {
    drawGraph dGraph;
    
    DFS(drawGraph dg){
        dGraph = dg;
    }
    
    void doSearch(){
        dGraph.dg_nodes = new ArrayList<Node>();
        for (Node n : dGraph.graph.nodes) {
            dGraph.dg_nodes.add(n);
        }

        boolean found = false;
        dGraph.openList = new ArrayList<Node>();
        dGraph.closedList = new ArrayList<Node>();
        
        Node in = dGraph.graph.nodes.get(dGraph.initNode);
        dGraph.openList.add(in);
        dGraph.dg_nodes.remove(in);
        
        while (!dGraph.openList.isEmpty() && !found) {
            Node cn = dGraph.openList.remove(dGraph.openList.size() - 1); // pop last node
            dGraph.closedList.add(cn);
            dGraph.delay(1000);
            
            if (cn.nodeNr != dGraph.goalNode) {
                for (Node child : dGraph.graph.nodes) {
                    if (dGraph.dg_nodes.contains(child) && // not visited yet
                        dGraph.graph.adjMatrix[cn.nodeNr][child.nodeNr] < 1000000.0) {
                        dGraph.openList.add(child);
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
