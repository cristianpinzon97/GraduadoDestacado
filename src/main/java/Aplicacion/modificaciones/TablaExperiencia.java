/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion.modificaciones;

import Aplicacion.Experiencia;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author crist
 */
public class TablaExperiencia {
    public void verTablaExperiencia(JTable tabla,ArrayList<Experiencia> exp) {

        tabla.setDefaultRenderer(Object.class, new Render());
        Object[][] experiencia = new Object[exp.size()][5];
        
        for (int i = 0; i < exp.size(); i++) {
            experiencia[i][0]=exp.get(i).getNombre();
            experiencia[i][1]=exp.get(i).getLugar();
            experiencia[i][2]=exp.get(i).getFecha();
            experiencia[i][3]=exp.get(i).getUbicacion();
            experiencia[i][4]=exp.get(i).getDescripcion();
        }
        
        DefaultTableModel d = new DefaultTableModel() {
            // make first cell uneditable
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        };
        d.setDataVector(
                experiencia,
                new Object[]{"NOMBRE", "LUGAR","FECHA","UBICACION","DESCRIPCION"}
        );

        tabla.setModel(d);
        tabla.getColumn("NOMBRE").setCellRenderer(new TextAreaRenderer());
        tabla.getColumn("NOMBRE").setCellEditor(new TextAreaEditor());
        tabla.getColumn("LUGAR").setCellRenderer(new TextAreaRenderer());
        tabla.getColumn("LUGAR").setCellEditor(new TextAreaEditor());
        tabla.getColumn("FECHA").setCellRenderer(new TextAreaRenderer());
        tabla.getColumn("FECHA").setCellEditor(new TextAreaEditor());
        tabla.getColumn("UBICACION").setCellRenderer(new TextAreaRenderer());
        tabla.getColumn("UBICACION").setCellEditor(new TextAreaEditor());
        tabla.getColumn("DESCRIPCION").setCellRenderer(new TextAreaRenderer());
        tabla.getColumn("DESCRIPCION").setCellEditor(new TextAreaEditor());
        
        tabla.setRowHeight(120);
    }
}
