/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchingsimulator;

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author CEN
 */
public class SimulatorFrame extends javax.swing.JFrame {
    drawGraph dgraph;
    /**
     * Creates new form SimulatorFrame
     */
    public SimulatorFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        menuBar = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuLoadGraph = new javax.swing.JMenuItem();
        menuCloseGraph = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuExit = new javax.swing.JMenuItem();
        menuAlgorithm = new javax.swing.JMenu();
        menuBFS = new javax.swing.JMenuItem();
        menuDFS = new javax.swing.JMenuItem();
        menuUCS = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu5.setText("jMenu5");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Searching Simulator");

        menuFile.setText("File");

        menuLoadGraph.setText("Load Graph");
        menuLoadGraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLoadGraphActionPerformed(evt);
            }
        });
        menuFile.add(menuLoadGraph);

        menuCloseGraph.setText("Close Graph");
        menuCloseGraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCloseGraphActionPerformed(evt);
            }
        });
        menuFile.add(menuCloseGraph);
        menuFile.add(jSeparator1);

        menuExit.setText("Exit");
        menuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExitActionPerformed(evt);
            }
        });
        menuFile.add(menuExit);

        menuBar.add(menuFile);

        menuAlgorithm.setText("Algorithm");

        menuBFS.setText("BFS");
        menuBFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBFSActionPerformed(evt);
            }
        });
        menuAlgorithm.add(menuBFS);

        menuDFS.setText("DFS");
        menuDFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDFSActionPerformed(evt);
            }
        });
        menuAlgorithm.add(menuDFS);

        menuUCS.setText("UCS");
        menuUCS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUCSActionPerformed(evt);
            }
        });
        menuAlgorithm.add(menuUCS);

        menuBar.add(menuAlgorithm);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_menuExitActionPerformed

    private void menuUCSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUCSActionPerformed
        // TODO add your handling code here:
        UCS ucs = new UCS(dgraph);
        ucs.doSearch();
    }//GEN-LAST:event_menuUCSActionPerformed

    private void menuLoadGraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLoadGraphActionPerformed
        // TODO add your handling code here:
        JFileChooser OpenFile = new JFileChooser();

        int pFile = OpenFile.showOpenDialog(this);
        if (pFile == JFileChooser.APPROVE_OPTION) {
            File file = OpenFile.getSelectedFile();
            try {
                dgraph = new drawGraph(file);
                dgraph.setSize(600,400);
		dgraph.setVisible(true);
            } catch (Exception e) {
                System.out.println("");
            }
        }
    }//GEN-LAST:event_menuLoadGraphActionPerformed

    private void menuCloseGraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCloseGraphActionPerformed
        // TODO add your handling code here:
        dgraph.setVisible(false);
    }//GEN-LAST:event_menuCloseGraphActionPerformed

    private void menuBFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBFSActionPerformed
        // TODO add your handling code here:
        BFS bfs = new BFS(dgraph);
        bfs.doSearch();
    }//GEN-LAST:event_menuBFSActionPerformed

    private void menuDFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDFSActionPerformed
        // TODO add your handling code here:
        DFS dfs = new DFS(dgraph);
        dfs.doSearch();
    }//GEN-LAST:event_menuDFSActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SimulatorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SimulatorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SimulatorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SimulatorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SimulatorFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu menuAlgorithm;
    private javax.swing.JMenuItem menuBFS;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuCloseGraph;
    private javax.swing.JMenuItem menuDFS;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenuItem menuLoadGraph;
    private javax.swing.JMenuItem menuUCS;
    // End of variables declaration//GEN-END:variables
}
