/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;
import DAO.HorarioDAO;
import interfaces.IHorarioDAO;
import models.Horario;
import models.Tutor;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author Cortez, Manuel;
 */
public class HorarioController {
    private final IHorarioDAO horarioDAO;
    private final String[] dias = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};

    public HorarioController() {
        horarioDAO = new HorarioDAO();
    }

    public boolean create(String dia, String horaInicio, String horaFin, Tutor tutor) {
        if (dia == null  || horaInicio == null || horaFin == null || tutor == null) {
            System.out.println("Ningun dato no puede estar vacio");
            return false;
        }
        if (!Arrays.asList(dias).contains(dia)) {
            System.out.println("El dia no corresponde a ningun dia de la semana o no cumple el formato (Lunes, Martes, etc)");
            return false;
        }
        if (!Pattern.matches("^([01]\\d|2[0-3]):[0-5]\\d$", horaInicio) || !Pattern.matches("^([01]\\d|2[0-3]):[0-5]\\d$", horaFin)){
            System.out.println("La hora no cumple con el formato (HH:mm)");
            return false;
        }
        Horario horario = new Horario(dia, horaInicio, horaFin, tutor);
        return horarioDAO.create(horario);
    }

    public Horario read(int idHorario){
        if (idHorario <= 0){
            System.out.println("El ID no puede ser negativa");
        }
        return horarioDAO.read(idHorario);
    }

    public boolean update(int idHorario, String dia, String horaInicio, String horaFin, Tutor tutor){
        if (dia == null  || horaInicio == null || horaFin == null || tutor == null) {
            System.out.println("Ningun dato no puede estar vacio");
            return false;
        }
        if (idHorario <= 0){
            System.out.println("El ID no puede ser negativa");
        }
        if (horarioDAO.read(idHorario) == null) {
            System.out.println("El horario no existe");
            return false;
        }
        if (!Pattern.matches("^([01]\\d|2[0-3]):[0-5]\\d$", horaInicio) || !Pattern.matches("^([01]\\d|2[0-3]):[0-5]\\d$", horaFin)){
            System.out.println("La hora no cumple con el formato (HH:mm)");
            return false;
        }
        Horario horario = new Horario(idHorario, dia, horaInicio, horaFin, tutor);
        return horarioDAO.update(horario);
    }

    public boolean delete(int idHorario){
        if (idHorario <= 0){
            System.out.println("El ID no puede ser negativa");
        }
        if (horarioDAO.read(idHorario) == null) {
            System.out.println("El horario no existe");
            return false;
        }
        return horarioDAO.delete(idHorario);
    }

    public List<Horario> readAll(){
        return horarioDAO.readAll();
    }
}
