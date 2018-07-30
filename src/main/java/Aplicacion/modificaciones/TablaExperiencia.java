/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion.modificaciones;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author crist
 */
public class TablaExperiencia {
    public void verTablaExperiencia(JTable tabla) {

        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel d = new DefaultTableModel(
                new Object[][]{{"NOMBRE", "LUGAR","UBICACION","DESCRIPCION"}, {"NOMBRE", "LUGAR","UBICACION","DESCRIPCION"}, {"NOMBRE", "LUGAR","UBICACION","DESCRIPCION"}},
                new Object[]{"NOMBRE", "LUGAR","UBICACION","DESCRIPCION"}
        ) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabla.setModel(d);
        tabla.setRowHeight(50);
    }
}
