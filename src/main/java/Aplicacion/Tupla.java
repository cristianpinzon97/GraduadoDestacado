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
class Tupla {
    private String nombre;
    private String cantidad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public Tupla(String nombre, String cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }
    
    
    
}