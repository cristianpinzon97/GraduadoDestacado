/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import java.util.ArrayList;


/**
 *
 * @author crist
 */
public class Aptitud {
    private ArrayList<Tupla> validaciones;
    private ArrayList<Tupla> conocimientoSector;
    private ArrayList<Tupla> herramientas;
    private ArrayList<Tupla> otros;
    private ArrayList<Tupla> interpersonales;


    public ArrayList<Tupla> getValidaciones() {
        return validaciones;
    }

    public void setValidaciones(ArrayList<Tupla> validaciones) {
        this.validaciones = validaciones;
    }

    public ArrayList<Tupla> getConocimientoSector() {
        return conocimientoSector;
    }

    public void setConocimientoSector(ArrayList<Tupla> conocimientoSector) {
        this.conocimientoSector = conocimientoSector;
    }

    public ArrayList<Tupla> getHerramientas() {
        return herramientas;
    }

    public void setHerramientas(ArrayList<Tupla> herramientas) {
        this.herramientas = herramientas;
    }

    public ArrayList<Tupla> getOtros() {
        return otros;
    }

    public void setOtros(ArrayList<Tupla> otros) {
        this.otros = otros;
    }

    public ArrayList<Tupla> getInterpersonales() {
        return interpersonales;
    }

    public void setInterpersonales(ArrayList<Tupla> interpersonales) {
        this.interpersonales = interpersonales;
    }

    
    
    
    
}
