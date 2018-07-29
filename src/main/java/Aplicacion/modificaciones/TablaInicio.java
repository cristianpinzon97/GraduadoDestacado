/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion.modificaciones;

import com.sun.prism.j2d.J2DPipeline;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author crist
 */
public class TablaInicio {

    public void verTablaInicio(JTable tabla) {

        tabla.setDefaultRenderer(Object.class, new Render());

        JButton aptitud = new JButton("Ver aptitudes");
        JButton educacion = new JButton("Ver educacion");
        JButton experiencia = new JButton("Ver experiencia");
        JButton logro = new JButton("Ver logros");
        JTextArea textArea = new JTextArea("Esta es una pequeasdasdasdasdasdasdasd asdasdasdkasldkasjdalskdjaslkd jlaksjdalskdjalskdjasldkajsdlksjd");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane descripcion = new JScrollPane(textArea);
        Image image = null;
        try {
            image = ImageIO.read(new URL("http://i.imgur.com/xiVXrCD.jpg")).getScaledInstance(100, 100, Image.SCALE_DEFAULT);;
        } catch (MalformedURLException ex) {
            Logger.getLogger(TablaInicio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TablaInicio.class.getName()).log(Level.SEVERE, null, ex);
        }

        JLabel foto = new JLabel(new ImageIcon(image));

        DefaultTableModel d = new DefaultTableModel(
                new Object[][]{{"1", foto, "1", descripcion, "1", aptitud, educacion, experiencia, logro}, {"1", foto, "1", descripcion, "1", aptitud, educacion, experiencia, logro}, {"1", foto, "1", descripcion, "1", aptitud, educacion, experiencia, logro}},
                new Object[]{"Nombre Graduado", "Foto", "Cargo Actual", "Descripcion", "Pais", "Aptitudes", "Educacion", "Experiencia", "Logros"}
        ) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabla.setModel(d);
        tabla.setRowHeight(100);
    }
}
