/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;
import DAO.HorarioDAO;
import interfaces.IHorarioDAO;
import models.Horario;
import models.Tutor;
import javax.swing.*;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author Angel Beltran;
 * @author Cortez, Manuel (Modificado por Angel);
 */
public class HorarioController {
    private final IHorarioDAO horarioDAO;
    private static final List<String> DIAS_SEMANA = Arrays.asList("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo");

    public HorarioController() {
        horarioDAO = new HorarioDAO();
    }

    public boolean create(String dia, String horaInicio, String horaFin, Tutor tutor) {
        // Valida que los objetos no sean nulos
        if (dia == null || horaInicio == null || horaFin == null || tutor == null) {
            JOptionPane.showMessageDialog(null, "Ningún dato puede ser nulo.");
            return false;
        }

        // Valida que las cadenas no estén vacías
        if (dia.trim().isEmpty() || horaInicio.trim().isEmpty() || horaFin.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Los campos de día y hora no pueden estar vacíos.");
            return false;
        }

        if (DIAS_SEMANA.stream().noneMatch(d -> d.equalsIgnoreCase(dia))) {
            JOptionPane.showMessageDialog(null, "El día no corresponde a ningún día de la semana o no cumple el formato (Lunes, Martes, etc).");
            return false;
        }

        String formatoHora = "^([01]\\d|2[0-3]):[0-5]\\d$";
        if (!Pattern.matches(formatoHora, horaInicio) || !Pattern.matches(formatoHora, horaFin)) {
            JOptionPane.showMessageDialog(null, "La hora de inicio o fin no cumple con el formato de 24 horas (HH:mm).");
            return false;
        }

        // Valida que la hora de inicio sea antes que la hora de fin
        if (LocalTime.parse(horaInicio).isAfter(LocalTime.parse(horaFin))) {
            JOptionPane.showMessageDialog(null, "La hora de inicio no puede ser posterior a la hora de fin.");
            return false;
        }

        // Valida que la hora de inicio y fin no sean la misma
        if (horaInicio.equals(horaFin)) {
            JOptionPane.showMessageDialog(null, "La hora de inicio y la hora de fin no pueden ser iguales.");
            return false;
        }

        Horario horario = new Horario(dia, horaInicio, horaFin, tutor);
        return horarioDAO.create(horario);
    }

    public Horario read(int idHorario) {
        if (idHorario <= 0) {
            JOptionPane.showMessageDialog(null, "El ID del horario no puede ser negativo o cero.");
            return null; // Devuelve null si el ID es inválido
        }
        return horarioDAO.read(idHorario);
    }

    public boolean update(int idHorario, String dia, String horaInicio, String horaFin, Tutor tutor) {
        // Valida el ID primero
        if (idHorario <= 0) {
            JOptionPane.showMessageDialog(null, "El ID del horario no puede ser negativo o cero.");
            return false;
        }

        // Valida que los objetos no sean nulos
        if (dia == null || horaInicio == null || horaFin == null || tutor == null) {
            JOptionPane.showMessageDialog(null, "Ningún dato puede ser nulo.");
            return false;
        }

        // Valida que las cadenas no estén vacías
        if (dia.trim().isEmpty() || horaInicio.trim().isEmpty() || horaFin.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Los campos de día y hora no pueden estar vacíos.");
            return false;
        }

        if (horarioDAO.read(idHorario) == null) {
            JOptionPane.showMessageDialog(null, "El horario que intenta actualizar no existe.");
            return false;
        }

        String formatoHora = "^([01]\\d|2[0-3]):[0-5]\\d$";
        if (!Pattern.matches(formatoHora, horaInicio) || !Pattern.matches(formatoHora, horaFin)) {
            JOptionPane.showMessageDialog(null, "La hora de inicio o fin no cumple con el formato de 24 horas (HH:mm).");
            return false;
        }

        // Valida que la hora de inicio sea antes que la hora de fin
        if (LocalTime.parse(horaInicio).isAfter(LocalTime.parse(horaFin))) {
            JOptionPane.showMessageDialog(null, "La hora de inicio no puede ser posterior a la hora de fin.");
            return false;
        }

        Horario horario = new Horario(idHorario, dia, horaInicio, horaFin, tutor);
        return horarioDAO.update(horario);
    }

    public boolean delete(int idHorario) {
        if (idHorario <= 0) {
            JOptionPane.showMessageDialog(null, "El ID del horario no puede ser negativo o cero.");
            return false;
        }
        if (horarioDAO.read(idHorario) == null) {
            JOptionPane.showMessageDialog(null, "El horario que intenta eliminar no existe.");
            return false;
        }
        return horarioDAO.delete(idHorario);
    }

    public List<Horario> readAll() {
        return horarioDAO.readAll();
    }
}