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
public class Logro {
    private String tipo,numeroTipoLogros;
    private ArrayList<Sublogro> sublogros;


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumeroTipoLogros() {
        return numeroTipoLogros;
    }

    public void setNumeroTipoLogros(String numeroTipoLogros) {
        this.numeroTipoLogros = numeroTipoLogros;
    }

    public ArrayList<Sublogro> getSublogros() {
        return sublogros;
    }

    public void setSublogros(ArrayList<Sublogro> sublogros) {
        this.sublogros = sublogros;
    }

    public Logro(String tipo, String numeroTipoLogros, ArrayList<Sublogro> sublogros) {
        this.tipo = tipo;
        this.numeroTipoLogros = numeroTipoLogros;
        this.sublogros = sublogros;
    }

    public Logro() {
    }
    
    

}
