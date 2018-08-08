/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion.modificaciones;

import Aplicacion.Sublogro;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author crist
 */
public class TablaSublogros {

    public void verTablaSublogros(JTable tabla, ArrayList<Sublogro> sublog) {

        tabla.setDefaultRenderer(Object.class, new Render());
        Object[][] sublogros = new Object[sublog.size()][3];
        for (int i = 0; i < sublog.size(); i++) {
            sublogros[i][0] = sublog.get(i).getNombreSublogro();
            sublogros[i][1] = sublog.get(i).getFecha();
            sublogros[i][2] = sublog.get(i).getDescripcion();

        }
        
        DefaultTableModel d = new DefaultTableModel() {
            // make first cell uneditable
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        };
        d.setDataVector(
                sublogros,
                new Object[]{"NOMBRE SUBLOGRO", "FECHA DEL SUBLOGRO", "DESCRIPCION"}
        );

        tabla.setModel(d);
        tabla.getColumn("NOMBRE SUBLOGRO").setCellRenderer(new TextAreaRenderer());
        tabla.getColumn("NOMBRE SUBLOGRO").setCellEditor(new TextAreaEditor());
        tabla.getColumn("FECHA DEL SUBLOGRO").setCellRenderer(new TextAreaRenderer());
        tabla.getColumn("FECHA DEL SUBLOGRO").setCellEditor(new TextAreaEditor());
        tabla.getColumn("DESCRIPCION").setCellRenderer(new TextAreaRenderer());
        tabla.getColumn("DESCRIPCION").setCellEditor(new TextAreaEditor());
        tabla.setModel(d);
        tabla.setRowHeight(120);
    }
}
