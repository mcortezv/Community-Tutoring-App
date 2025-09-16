/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Cortez, Manuel;
 */
public class Estudiante {
    private static int contador = 1;
    private int id;
    private String nombre;
    private String gradoEscolar;
    private int edad;
    private String telefono;
    private String escuelaProcedencia;

    public Estudiante() {}

    public Estudiante(int id, String nombre, String gradoEscolar, int edad, String telefono, String escuelaProcedencia) {
        this.id = id;
        this.nombre = nombre;
        this.gradoEscolar = gradoEscolar;
        this.edad = edad;
        this.telefono = telefono;
        this.escuelaProcedencia = escuelaProcedencia;
    }

    public Estudiante(String nombre, String gradoEscolar, int edad, String telefono, String escuelaProcedencia) {
        this.id = contador++;
        this.nombre = nombre;
        this.gradoEscolar = gradoEscolar;
        this.edad = edad;
        this.telefono = telefono;
        this.escuelaProcedencia = escuelaProcedencia;
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

    public String getGradoEscolar() {
        return gradoEscolar;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setGradoEscolar(String gradoEscolar) {
        this.gradoEscolar = gradoEscolar;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEscuelaProcedencia() {
        return escuelaProcedencia;
    }

    public void setEscuelaProcedencia(String escuelaProcedencia) {
        this.escuelaProcedencia = escuelaProcedencia;
    }

    @Override
    public String toString() {
        return String.format("\n%-20s -->  %d \n%-20s -->  %s \n%-20s -->  %s \n%-20s -->  %d \n%-20s -->  %s \n%-20s -->  %s \n",
                "Estudiante", this.getId(), "Nombre", this.getNombre(), "Grado Escolar", this.getGradoEscolar(), "Edad",
                this.getEdad(), "Telefono", this.getTelefono(), "Escuela Procedencia", this.getEscuelaProcedencia());
    }
}
