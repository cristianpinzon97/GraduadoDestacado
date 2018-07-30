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
public class Graduado {
    private Perfil perfil;
    private Aptitud aptitud;
    private ArrayList<Educacion> educacion;
    private ArrayList<Experiencia> experiencia;
    private ArrayList<Logro> logros;

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Aptitud getAptitud() {
        return aptitud;
    }

    public void setAptitud(Aptitud aptitud) {
        this.aptitud = aptitud;
    }

    public ArrayList<Educacion> getEducacion() {
        return educacion;
    }

    public void setEducacion(ArrayList<Educacion> educacion) {
        this.educacion = educacion;
    }

    public ArrayList<Experiencia> getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(ArrayList<Experiencia> experiencia) {
        this.experiencia = experiencia;
    }

    public ArrayList<Logro> getLogros() {
        return logros;
    }

    public void setLogros(ArrayList<Logro> logros) {
        this.logros = logros;
    }
    

}
