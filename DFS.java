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
    drawGraph dGraph; // Deklarasi variabel untuk menyimpan objek drawGraph.
    
    DFS(drawGraph dg){ // Konstruktor untuk kelas DFS, menerima objek drawGraph sebagai argumen.
        dGraph = dg; // Inisialisasi variabel dGraph dengan objek drawGraph yang diterima sebagai argumen.
    }
    
    void doSearch(){ // Metode untuk menjalankan algoritma pencarian DFS.
        dGraph.dg_nodes = new ArrayList<Node>(); // Inisialisasi daftar dg_nodes dalam objek drawGraph.
        for (Node n : dGraph.graph.nodes) { // Loop melalui semua node dalam graf pada objek drawGraph.
            dGraph.dg_nodes.add(n); // Tambahkan setiap node ke dalam dg_nodes.
        }

        boolean found = false; // Inisialisasi variabel boolean found sebagai false.
        dGraph.openList = new ArrayList<Node>(); // Inisialisasi daftar openList dalam objek drawGraph.
        dGraph.closedList = new ArrayList<Node>(); // Inisialisasi daftar closedList dalam objek drawGraph.
        
        Node in = dGraph.graph.nodes.get(dGraph.initNode); // Dapatkan node awal dari objek graf pada objek drawGraph.
        dGraph.openList.add(in); // Tambahkan node awal ke dalam openList.
        dGraph.dg_nodes.remove(in); // Hapus node awal dari dg_nodes.
        
        while (!dGraph.openList.isEmpty() && !found) { // Selama openList tidak kosong dan 'found' masih false.
            Node cn = dGraph.openList.remove(dGraph.openList.size() - 1); // Pop (ambil dan hapus) node terakhir dari openList.
            dGraph.closedList.add(cn); // Tambahkan node yang di-pop ke dalam closedList.
            dGraph.delay(1000); // Tunda eksekusi selama 1000 milidetik (1 detik).
            
            if (cn.nodeNr != dGraph.goalNode) { // Jika nomor node saat ini bukanlah goalNode.
                for (Node child : dGraph.graph.nodes) { // Loop melalui semua node dalam graf pada objek drawGraph.
                    if (dGraph.dg_nodes.contains(child) && // Jika child belum dikunjungi (ada dalam dg_nodes) dan
                        dGraph.graph.adjMatrix[cn.nodeNr][child.nodeNr] < 1000000.0) { // Bobot edge antara cn dan child kurang dari 1000000.0.
                        dGraph.openList.add(child); // Tambahkan child ke dalam openList.
                        dGraph.dg_nodes.remove(child); // Hapus child dari dg_nodes.
                    }
                }
            } else { // Jika nomor node saat ini adalah goalNode.
                found = true; // Set 'found' menjadi true untuk menghentikan loop.
            }
            dGraph.paint(dGraph.getGraphics()); // Meminta objek drawGraph untuk menggambar grafik.
            dGraph.delay(1000); // Tunda eksekusi selama 1000 milidetik (1 detik).
        }
    }
}
