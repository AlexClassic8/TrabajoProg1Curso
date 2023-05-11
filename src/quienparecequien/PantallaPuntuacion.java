/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quienparecequien;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alex
 */
public class PantallaPuntuacion extends javax.swing.JFrame {

    /**
     * Creates new form PantallaPuntuacion
     */
    //Creamos el modelo de la tabla para poder introducir los datos mediante codigo exactamente como yo quiero.
    DefaultTableModel modeloT;
    //Y creamos tambien el array list para guardar la lista de usuarios ganadores y sus puntos.
    ArrayList<Users> listaPuntos ;
    public PantallaPuntuacion() throws IOException, FileNotFoundException, ClassNotFoundException {
       initComponents();
       //Inicializamos el arraylist, leemos el archivo con los puntos y usamos el metodo tabla llena que solo actua si
       //el arrayList tiene mas de 10 puntuaciones en cual caso elimina la ultima.
        listaPuntos = new ArrayList<Users>();
           Users.obtenerUser("listaUsuarios.dat", listaPuntos);
           
           //Por ultimo creamos el modelo y le pasamos el metodo que coje el jtable y le pasa el modelo que diseñemos con los datos que diseñemos para cada columna.
           Collections.sort(listaPuntos);
           tablaLlena(listaPuntos);
           modeloT= new DefaultTableModel();
           listarTabla();
        
        
    }
    public void tablaLlena(ArrayList<Users> U){
        while(U.size()>10){
           int last= U.size()-1;
            U.remove(last);
            }
        
    }
    public void listarTabla(){
        modeloT= (DefaultTableModel) TablaPuntos.getModel();
           Object[] ob = new Object[3];
           for(int i = 0; i<listaPuntos.size(); i++){
               ob[0]= (listaPuntos.indexOf(listaPuntos.get(i))+1);
               ob[1]= listaPuntos.get(i).getNombre();
               ob[2]= listaPuntos.get(i).getPuntuacion();
               modeloT.addRow(ob);
           }
           TablaPuntos.setModel(modeloT);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jNewGame = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPuntos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());

        jNewGame.setBackground(new java.awt.Color(51, 204, 0));
        jNewGame.setForeground(new java.awt.Color(0, 0, 0));
        jNewGame.setText("Nueva Partida");
        jNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNewGameActionPerformed(evt);
            }
        });
        jPanel2.add(jNewGame, java.awt.BorderLayout.PAGE_START);

        jBSalir.setBackground(new java.awt.Color(255, 51, 51));
        jBSalir.setForeground(new java.awt.Color(0, 0, 0));
        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });
        jPanel2.add(jBSalir, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_END);
        jPanel2.getAccessibleContext().setAccessibleDescription("");

        jScrollPane1.setBackground(new java.awt.Color(102, 204, 0));

        TablaPuntos.setBackground(new java.awt.Color(0, 153, 153));
        TablaPuntos.setForeground(new java.awt.Color(0, 0, 0));
        TablaPuntos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Posicion", "Nombre", "Puntuacion"
            }
        ));
        jScrollPane1.setViewportView(TablaPuntos);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.PAGE_START);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Zilla Slab Medium", 2, 36)); // NOI18N
        jLabel1.setText("Enhorabuena, me has encontrado!!!!");
        jPanel3.add(jLabel1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.LINE_START);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNewGameActionPerformed
        this.setVisible(false);
        PrimeraScreen nuevoGame = null;
        nuevoGame= new PrimeraScreen();
        nuevoGame.setVisible(true);
    }//GEN-LAST:event_jNewGameActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaPuntuacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPuntuacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPuntuacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPuntuacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new PantallaPuntuacion().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(PantallaPuntuacion.class.getName()).log(Level.SEVERE, "no puede leer", ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PantallaPuntuacion.class.getName()).log(Level.SEVERE, "no encuentra la clase", ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaPuntos;
    private javax.swing.JButton jBSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jNewGame;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
