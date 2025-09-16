/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Cortez, Manuel;
 */
public class Tutor {
    private static int contador = 1;
    private int id;
    private String nombre;
    private String telefono;
    private String email;
    private String especialidad;

    public Tutor(){
        this.id = contador++;
    }

    public Tutor(String nombre, String telefono, String email, String especialidad) {
        this.id = contador++;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.especialidad = especialidad;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return String.format("\n%-14s -->  %d \n%-14s -->  %s \n%-14s -->  %s \n%-14s -->  %s \n%-14s -->  %s \n",
                "Tutor", this.getId(), "Nombre", this.getNombre(), "Telefono", this.getTelefono(),
                "Correo", this.getEmail(), "Especialidad", this.getEspecialidad());
    }
}
