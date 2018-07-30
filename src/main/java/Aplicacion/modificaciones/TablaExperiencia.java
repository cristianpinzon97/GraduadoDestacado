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
        Object[][] experiencia = new Object[exp.size()][3];
        
        for (int i = 0; i < exp.size(); i++) {
            experiencia[i][0]=exp.get(i).getNombre();
            experiencia[i][1]=exp.get(i).getLugar();
            experiencia[i][2]=exp.get(i).getDescripcion();
            
        }
        DefaultTableModel d = new DefaultTableModel(
                experiencia,
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
