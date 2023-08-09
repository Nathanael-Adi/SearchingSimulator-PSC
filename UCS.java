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
    drawGraph dGraph; // Mendeklarasikan variabel dGraph bertipe drawGraph
    
    UCS(drawGraph dg){ // Konstruktor kelas UCS yang menerima parameter dg bertipe drawGraph
        dGraph = dg; // Menginisialisasi variabel dGraph dengan nilai parameter dg
    }
    
    void doSearch(){ // Mendefinisikan metode doSearch yang akan menjalankan algoritma UCS
        dGraph.dg_nodes = new ArrayList<Node>(); // Menginisialisasi dg_nodes sebagai ArrayList<Node>
        for (Node n : dGraph.graph.nodes) { // Mengulang melalui setiap Node dalam graph yang ada di dGraph
            dGraph.dg_nodes.add(n); // Menambahkan Node n ke dalam dg_nodes
        }

        boolean found = false; // Mendeklarasikan variabel boolean found yang menandakan apakah tujuan telah ditemukan
        PriorityQueue<Node> openPriorityQueue = new PriorityQueue<>((n1, n2) ->
            Double.compare(n1.pathCost, n2.pathCost)); // Membuat PriorityQueue dengan pembanding berdasarkan pathCost

        dGraph.closedList = new ArrayList<Node>(); // Menginisialisasi closedList sebagai ArrayList<Node>
        
        Node initialNode = dGraph.graph.nodes.get(dGraph.initNode); // Mendapatkan Node awal dari graph dalam dGraph
        initialNode.pathCost = 0.0; // Mengatur pathCost dari initialNode menjadi 0
        openPriorityQueue.add(initialNode); // Menambahkan initialNode ke dalam openPriorityQueue
        dGraph.dg_nodes.remove(initialNode); // Menghapus initialNode dari dg_nodes
        
        while (!openPriorityQueue.isEmpty() && !found) { // Melakukan loop selama openPriorityQueue tidak kosong dan tujuan belum ditemukan
            Node currentNode = openPriorityQueue.poll(); // Menghapus dan mengambil Node dengan pathCost terendah dari openPriorityQueue
            dGraph.closedList.add(currentNode); // Menambahkan currentNode ke dalam closedList
            dGraph.delay(1000); // Memberikan penundaan selama 1 detik
            
            if (currentNode.nodeNr != dGraph.goalNode) { // Jika currentNode belum merupakan tujuan
                for (Node child : dGraph.graph.nodes) { // Melalui setiap Node dalam graph yang ada di dGraph
                    if (dGraph.dg_nodes.contains(child) && // Jika child belum dikunjungi
                        dGraph.graph.adjMatrix[currentNode.nodeNr][child.nodeNr] < 1000000.0) { // Dan terdapat koneksi antara currentNode dan child
                        double newPathCost = currentNode.pathCost +
                                            dGraph.graph.adjMatrix[currentNode.nodeNr][child.nodeNr]; // Menghitung biaya jalur baru
                        if (newPathCost < child.pathCost) { // Jika jalur baru lebih murah
                            child.pathCost = newPathCost; // Mengatur pathCost dari child dengan yang baru
                            child.parent = currentNode; // Mengatur parent dari child
                        }
                        openPriorityQueue.add(child); // Menambahkan child ke dalam openPriorityQueue
                        dGraph.dg_nodes.remove(child); // Menghapus child dari dg_nodes
                    }
                }
            } else {
                found = true; // Jika currentNode adalah tujuan, mengubah found menjadi true
            }
            dGraph.paint(dGraph.getGraphics()); // Memanggil metode paint pada dGraph untuk menggambar grafik
            dGraph.delay(1000); // Memberikan penundaan selama 1 detik
        }
    }
}
