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
        DefaultTableModel d = new DefaultTableModel(
                educacion,
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
