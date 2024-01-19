/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni.taller.dto;

/**
 *
 * @author Alumno
 */
public class Linea {
    //atributos

    private int idLinea;
    private String nombre;
    //constructor

    public Linea() {
    }

    public Linea(int idLinea, String nombre) {
        this.idLinea = idLinea;
        this.nombre = nombre;
    }

    //metodos get y set
    public int getIdLinea() {
        return idLinea;
    }

    public void setIdLinea(int idLinea) {
        this.idLinea = idLinea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
