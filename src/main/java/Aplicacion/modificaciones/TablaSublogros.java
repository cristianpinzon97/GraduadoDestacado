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
            JTextArea textArea = new JTextArea(sublog.get(i).getDescripcion());
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            JScrollPane descripcion = new JScrollPane(textArea);
            sublogros[i][2] = descripcion;

        }

        DefaultTableModel d = new DefaultTableModel(
                sublogros,
                new Object[]{"NOMBRE SUBLOGRO", "FECHA DEL SUBLOGRO", "DESCRIPCION"}
        ) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabla.setModel(d);
        tabla.setRowHeight(50);
    }
}
