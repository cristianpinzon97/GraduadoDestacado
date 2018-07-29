/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

/**
 *
 * @author crist
 */
public class Sublogro {
    private String nombreSublogro, fecha, descripcion;

    public String getNombreSublogro() {
        return nombreSublogro;
    }

    public void setNombreSublogro(String nombreSublogro) {
        this.nombreSublogro = nombreSublogro;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Sublogro(String nombreSublogro, String fecha, String descripcion) {
        this.nombreSublogro = nombreSublogro;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
    
    
    
    
    
}
