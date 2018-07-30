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
public class TablaEducacion {
    public void verTablaEducacion(JTable tabla) {

        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel d = new DefaultTableModel(
                new Object[][]{{"NOMBRE DEL LUGAR", "NOMBRE DEEL CURSO", "PERIODO","ACTIVIDADES","DETALLES EXTRA"}, {"NOMBRE DEL LUGAR", "NOMBRE DEEL CURSO", "PERIODO","ACTIVIDADES","DETALLES EXTRA"}, {"NOMBRE DEL LUGAR", "NOMBRE DEEL CURSO", "PERIODO","ACTIVIDADES","DETALLES EXTRA"}},
                new Object[]{"NOMBRE DEL LUGAR", "NOMBRE DEEL CURSO", "PERIODO","ACTIVIDADES","DETALLES EXTRA"}
        ) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabla.setModel(d);
        tabla.setRowHeight(50);
    }
}
