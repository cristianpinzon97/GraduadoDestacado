/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion.modificaciones;

import Aplicacion.Logro;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author crist
 */
public class TablaLogros {
    public void verTablaLogros(JTable tabla, ArrayList<Logro> log) {

        tabla.setDefaultRenderer(Object.class, new Render());
        Object[][] logros = new Object[log.size()][3];
        JButton sublogros = new JButton("Ver Sublogros");

        for (int i = 0; i < log.size(); i++) {
            logros[i][0]=log.get(i).getTipo();
            logros[i][1]=log.get(i).getNumeroTipoLogros();
            logros[i][2]=sublogros;
            
        }
        
        DefaultTableModel d = new DefaultTableModel() {
            // make first cell uneditable
            public boolean isCellEditable(int row, int column) {
                return !(column==2);
            }
        };
        d.setDataVector(
                logros,
                new Object[]{"NOMBRE LOGRO", "NUMERO TIPO LOGROS","SUBLOGROS"}
        );

        tabla.setModel(d);
        tabla.getColumn("NOMBRE LOGRO").setCellRenderer(new TextAreaRenderer());
        tabla.getColumn("NOMBRE LOGRO").setCellEditor(new TextAreaEditor());
        tabla.getColumn("NUMERO TIPO LOGROS").setCellRenderer(new TextAreaRenderer());
        tabla.getColumn("NUMERO TIPO LOGROS").setCellEditor(new TextAreaEditor());
        
        tabla.setRowHeight(120);
    }
}
