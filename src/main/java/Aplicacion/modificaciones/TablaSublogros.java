/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion.modificaciones;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author crist
 */
public class TablaSublogros {
    public void verTablaSublogros(JTable tabla) {

        tabla.setDefaultRenderer(Object.class, new Render());

        JTextArea textArea = new JTextArea("asdasdasdasdasd");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane descripcion = new JScrollPane(textArea);
        DefaultTableModel d = new DefaultTableModel(
                new Object[][]{{"Llave", "Valor",descripcion}, {"Llave", "Valor",descripcion}, {"Llave", "Valor",descripcion}, {"Llave", "Valor",descripcion}},
                new Object[]{"NOMBRE SUBLOGRO", "FECHA DEL SUBLOGRO","DESCRIPCION"}
        ) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabla.setModel(d);
        tabla.setRowHeight(50);
    }
}
