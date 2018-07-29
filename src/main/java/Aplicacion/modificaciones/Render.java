/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion.modificaciones;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author crist
 */
public class Render  extends  DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, int row, int column) {
        
        if(value instanceof JButton){
            JButton btn = (JButton) value;
            return btn;
        }else if(value instanceof JScrollPane){
            JScrollPane textArea = (JScrollPane) value;
            return textArea;
        }else if(value instanceof JLabel){
            JLabel label = (JLabel) value;
            return label;
        }
        
        
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
    }
    
}
