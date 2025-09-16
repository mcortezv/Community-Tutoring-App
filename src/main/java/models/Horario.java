/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Cortez, Manuel;
 */
public class Horario {
    private static int contador = 1;
    private int id;
    private String dia;
    private String horaInicio;
    private String horaFin;
    private Tutor tutor;

    public Horario(){}

    public Horario(int id, String dia, String horaInicio, String horaFin, Tutor tutor) {
        this.id = id;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.tutor = tutor;
    }

    public Horario(String dia, String horaInicio, String horaFin, Tutor tutor) {
        this.id = contador++;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.tutor = tutor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    @Override
    public String toString() {
        return String.format("\n%-13s -->  %d \n%-13s -->  %s \n%-13s -->  %s \n%-13s -->  %s \n%-13s -->  %s \n",
                "Horario", this.getId(), "Dia", this.getDia(), "Hora Inicio", this.getHoraInicio(),
                "Hora Fin", this.getHoraFin(), "ID Tutor", this.getTutor().getNombre());
    }
}
