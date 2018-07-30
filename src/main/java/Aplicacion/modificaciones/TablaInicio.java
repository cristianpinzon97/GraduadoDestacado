/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion.modificaciones;

import Aplicacion.Extractor;
import Aplicacion.Graduado;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
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

    ArrayList<Graduado> graduados;

    public void verTablaInicio(JTable tabla, ArrayList<Graduado> g) {

        tabla.setDefaultRenderer(Object.class, new Render());

        graduados = g;

        Object[][] tablaGraduados = new Object[graduados.size()][9];

        JButton aptitud = new JButton("Ver aptitudes");
        JButton educacion = new JButton("Ver educacion");
        JButton experiencia = new JButton("Ver experiencia");
        JButton logro = new JButton("Ver logros");

        for (int i = 0; i < graduados.size(); i++) {
            tablaGraduados[i][0] = graduados.get(i).getPerfil().getNombre();
            Image image = null;
            try {
                image = ImageIO.read(new URL(graduados.get(i).getPerfil().getPhoto())).getScaledInstance(128, 158, Image.SCALE_DEFAULT);
            } catch (MalformedURLException ex) {
                Logger.getLogger(TablaInicio.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(TablaInicio.class.getName()).log(Level.SEVERE, null, ex);
            }
            JLabel foto = new JLabel(new ImageIcon(image));
            tablaGraduados[i][1] = foto;
            tablaGraduados[i][2] = graduados.get(i).getPerfil().getCargoActual();
            JTextArea textArea = new JTextArea(graduados.get(i).getPerfil().getDescripcion());
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            JScrollPane descripcion = new JScrollPane(textArea);
            tablaGraduados[i][3] = descripcion;
            tablaGraduados[i][4] = graduados.get(i).getPerfil().getPais();
            tablaGraduados[i][5] = aptitud;
            tablaGraduados[i][6] = educacion;
            tablaGraduados[i][7] = experiencia;
            tablaGraduados[i][8] = logro;
        }

        DefaultTableModel d = new DefaultTableModel(
                tablaGraduados,
                new Object[]{"Nombre Graduado", "Foto", "Cargo Actual", "Descripcion", "Pais", "Aptitudes", "Educacion", "Experiencia", "Logros"}
        ) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabla.setModel(d);
        tabla.setRowHeight(158);
    }
}
