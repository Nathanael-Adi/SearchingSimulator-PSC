/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchingsimulator;

/**
 *
 * @author CEN
 */
public class Node {
    int nodeNr;
    String nodeLabel;
    int posX;
    int posY;
    public double pathCost;
    public Node parent;
    
    Node(int nr, String nL, int px, int py){
        nodeNr = nr;
        nodeLabel = nL;
        posX = px;
        posY = py;
    }
    
    void printNode(){
        System.out.println("("+nodeNr+","+nodeLabel+","+posX+","+posY+")");
    }
}
