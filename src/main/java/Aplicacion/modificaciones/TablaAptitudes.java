/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion.modificaciones;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Aplicacion.Tupla;

/**
 *
 * @author crist
 */
public class TablaAptitudes {
    public void verTablaAptitudes(JTable tabla,ArrayList<Tupla> tablaX) {

        tabla.setDefaultRenderer(Object.class, new Render());
        Object[][] tablaY = new Object[tablaX.size()][2];
        
        for (int i = 0; i < tablaX.size(); i++) {
            tablaY[i][0]=tablaX.get(i).getNombre();
            tablaY[i][1]=tablaX.get(i).getCantidad();
            
        }
        DefaultTableModel d = new DefaultTableModel(
                tablaY,
                new Object[]{"Titulo", "Valor Titulo"}
        ) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabla.setModel(d);
        tabla.setRowHeight(50);
    }
}
