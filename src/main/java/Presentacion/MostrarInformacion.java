/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Aplicacion.Extractor;
import Aplicacion.Graduado;
import Aplicacion.modificaciones.TablaInicio;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author crist
 */
public class MostrarInformacion extends javax.swing.JFrame {

    /**
     * Creates new form MostrarInformacion
     */
    ArrayList<Graduado> graduados;
    TablaInicio tablaIni = new TablaInicio();
    private Extractor extractor = new Extractor();
    
    public MostrarInformacion(ArrayList<Graduado> graduados) {
        initComponents();
        this.graduados=graduados;
        tablaIni.verTablaInicio(tablaInicio,graduados);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInicio = new javax.swing.JTable();
        ordenarButton = new javax.swing.JButton();
        ordenarLista = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaInicio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaInicio.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                tablaInicioMouseWheelMoved(evt);
            }
        });
        tablaInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaInicioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaInicio);

        ordenarButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ordenarButton.setText("Ordenar Información");
        ordenarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordenarButtonActionPerformed(evt);
            }
        });

        ordenarLista.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ordenarLista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin Ordenar", "Nombres", "Cantidad de Logros", "Cantidad de Aptitudes", "Cantidad de Experiencia" }));
        ordenarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordenarListaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Ordenar Información por: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1202, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ordenarLista, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ordenarButton)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ordenarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ordenarLista, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaInicioMouseClicked
        
        int column = tablaInicio.getColumnModel().getColumnIndexAtX(evt.getX());
        int row =evt.getY()/tablaInicio.getRowHeight();
        if(row < tablaInicio.getRowCount() && row>=0 && column < tablaInicio.getColumnCount() && column>=0 ){
            Object value = tablaInicio.getValueAt(row, column);
            if (value instanceof JButton){
                ((JButton)value).doClick();
                JButton boton = (JButton) value;
                if(column==5){
                    Aptitudes aptitudesGui = new Aptitudes(graduados.get(row));
                    aptitudesGui.setVisible(true);
                } 
                if(column==6){
                    Educacion educacionGui = new Educacion(graduados.get(row));
                    educacionGui.setVisible(true);
                } 
                if(column==7){
                    Experiencia experienciaGui = new Experiencia(graduados.get(row));
                    experienciaGui.setVisible(true);
                } 
                if(column==8){
                    Logros logrosGui = new Logros(graduados.get(row));
                    logrosGui.setVisible(true);
                } 
                
                
            }
        }
        
    }//GEN-LAST:event_tablaInicioMouseClicked

    private void tablaInicioMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_tablaInicioMouseWheelMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaInicioMouseWheelMoved

    private void ordenarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordenarButtonActionPerformed
        String ordenarPor = (String) ordenarLista.getSelectedItem();
        this.graduados=extractor.filtrarGraduadosPor(ordenarPor, graduados);
        tablaIni.verTablaInicio(tablaInicio,graduados);
        
    }//GEN-LAST:event_ordenarButtonActionPerformed

    private void ordenarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordenarListaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ordenarListaActionPerformed

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
            java.util.logging.Logger.getLogger(MostrarInformacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MostrarInformacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MostrarInformacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MostrarInformacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MostrarInformacion().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton ordenarButton;
    private javax.swing.JComboBox<String> ordenarLista;
    private javax.swing.JTable tablaInicio;
    // End of variables declaration//GEN-END:variables
}
