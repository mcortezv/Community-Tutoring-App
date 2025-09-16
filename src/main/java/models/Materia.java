/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Cortez, Manuel;
 */
public class Materia {
    private static int contador = 1;
    private int id;
    private String nombre;
    private String nivel;
    private String descripcion;

    public Materia(){}

    public Materia(int id, String nombre, String nivel, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
        this.descripcion = descripcion;
    }

    public Materia(String nombre, String nivel, String descripcion) {
        this.id = contador++;
        this.nombre = nombre;
        this.nivel = nivel;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return String.format("\n%-13s -->  %d \n%-13s -->  %s \n%-13s -->  %s \n%-13s -->  \n%s \n",
                "Materia", this.getId(), "Nombre", this.getNombre(), "Nivel", this.getNivel(), "Descripcion", this.getDescripcion());
    }
}
