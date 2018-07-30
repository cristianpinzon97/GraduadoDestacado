/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion.modificaciones;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author crist
 */
public class TablaLogros {
    public void verTablaLogros(JTable tabla) {

        tabla.setDefaultRenderer(Object.class, new Render());
        
          JButton sublogros = new JButton("Ver Sublogros");

        DefaultTableModel d = new DefaultTableModel(
                new Object[][]{{"Llave", "Valor",sublogros}, {"Llave", "Valor",sublogros}, {"Llave", "Valor",sublogros}, {"Llave", "Valor",sublogros}},
                new Object[]{"NOMBRE LOGRO", "NUMERO TIPO LOGROS","SUBLOGROS"}
        ) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabla.setModel(d);
        tabla.setRowHeight(50);
    }
}
