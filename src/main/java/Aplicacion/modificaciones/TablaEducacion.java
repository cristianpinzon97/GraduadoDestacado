/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion.modificaciones;

import Aplicacion.Educacion;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author crist
 */
public class TablaEducacion {
    public void verTablaEducacion(JTable tabla,ArrayList<Educacion> edu) {

        tabla.setDefaultRenderer(Object.class, new Render());
        Object[][] educacion = new Object[edu.size()][5];
        
        for (int i = 0; i < edu.size(); i++) {
            educacion[i][0]=edu.get(i).getNombreLugar();
            educacion[i][1]=edu.get(i).getNombreCurso();
            educacion[i][2]=edu.get(i).getPeriodo();
            educacion[i][3]=edu.get(i).getActividades();
            educacion[i][4]=edu.get(i).getDetallesExtra();
            
        }
        
        DefaultTableModel d = new DefaultTableModel() {
            // make first cell uneditable
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        };
        d.setDataVector(
                educacion,
                new Object[]{"NOMBRE DEL LUGAR", "NOMBRE DEL CURSO", "PERIODO","ACTIVIDADES","DETALLES EXTRA"}
        );

        tabla.setModel(d);
        tabla.getColumn("NOMBRE DEL LUGAR").setCellRenderer(new TextAreaRenderer());
        tabla.getColumn("NOMBRE DEL LUGAR").setCellEditor(new TextAreaEditor());
        tabla.getColumn("NOMBRE DEL CURSO").setCellRenderer(new TextAreaRenderer());
        tabla.getColumn("NOMBRE DEL CURSO").setCellEditor(new TextAreaEditor());
        tabla.getColumn("PERIODO").setCellRenderer(new TextAreaRenderer());
        tabla.getColumn("PERIODO").setCellEditor(new TextAreaEditor());
        tabla.getColumn("ACTIVIDADES").setCellRenderer(new TextAreaRenderer());
        tabla.getColumn("ACTIVIDADES").setCellEditor(new TextAreaEditor());
        tabla.getColumn("DETALLES EXTRA").setCellRenderer(new TextAreaRenderer());
        tabla.getColumn("DETALLES EXTRA").setCellEditor(new TextAreaEditor());
        
        tabla.setRowHeight(120);
    }
}
