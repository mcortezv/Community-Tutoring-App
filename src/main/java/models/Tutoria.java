/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Cortez, Manuel;
 */
public class Tutoria {
    private static int contador = 1;
    private int id;
    private String fecha;
    private String hora;
    private String estado;
    private Tutor tutor;
    private Estudiante estudiante;
    private Materia materia;

    public Tutoria() {}

    public Tutoria(int id, String fecha, String hora, String estado, Tutor tutor, Estudiante estudiante, Materia materia) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.tutor = tutor;
        this.estudiante = estudiante;
        this.materia = materia;
    }

    public Tutoria(String fecha, String hora, String estado, Tutor tutor, Estudiante estudiante, Materia materia) {
        this.id = contador++;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.tutor = tutor;
        this.estudiante = estudiante;
        this.materia = materia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return String.format("\n%-12s -->  %d \n%-12s -->  %s \n%-12s -->  %s \n%-12s -->  %s \n%-12s -->  %s \n%-12s -->  %s \n%-12s -->  %s \n",
                "Tutoria", this.getId(), "Fecha", this.getFecha(), "Hora", this.getHora(), "Estado", this.getEstado(),
                "Tutor", this.getTutor().getNombre(), "Estudiante", this.getEstudiante().getNombre(), "Materia", this.getMateria().getNombre());
    }
}
