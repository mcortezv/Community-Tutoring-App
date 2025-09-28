/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import DAO.TutoriaDAO;
import models.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author Cortez, Manuel;
 */
public class TutoriaController {
    private final TutoriaDAO tutoriaDAO;
    // Lista estática y final para los estados permitidos.
    private static final List<String> ESTADOS_PERMITIDOS = Arrays.asList("Programada", "En curso", "Completada", "Cancelada");

    public TutoriaController() {
        tutoriaDAO = new TutoriaDAO();
    }

    public boolean create(String fecha, String hora, String estado, Tutor tutor, Estudiante estudiante, Materia materia) {
        // Valida que ningún objeto sea nulo.
        if (fecha == null || hora == null || estado == null || tutor == null || estudiante == null || materia == null) {
            System.out.println("Ningún dato puede ser nulo.");
            return false;
        }

        // Valida que los campos de texto no estén vacíos.
        if (fecha.trim().isEmpty() || hora.trim().isEmpty() || estado.trim().isEmpty()) {
            System.out.println("Los campos de fecha, hora y estado no pueden estar vacíos.");
            return false;
        }
        
        
        // Valida el formato de fecha 
        if (!Pattern.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$", fecha)) {
            System.out.println("La fecha no cumple con el formato AAAA-MM-DD.");
            return false;
        }
        
        // Valida que la fecha no sea en el pasado.
        try {
            LocalDate fechaTutoria = LocalDate.parse(fecha);
            if (fechaTutoria.isBefore(LocalDate.now())) {
                System.out.println("No se puede programar una tutoría en una fecha pasada.");
                return false;
            }
        } catch (DateTimeParseException e) {
            System.out.println("La fecha proporcionada no es una fecha válida (ej. 2023-02-30).");
            return false;
        }

        // Valida el formato de hora HH:mm.
        if (!Pattern.matches("^([01]\\d|2[0-3]):[0-5]\\d$", hora)) {
            System.out.println("La hora no cumple con el formato HH:mm.");
            return false;
        }

        // Valida que el estado esté dentro de los permitidos (insensible a mayúsculas).
        if (ESTADOS_PERMITIDOS.stream().noneMatch(e -> e.equalsIgnoreCase(estado))) {
            System.out.println("Estado no válido. Opciones: Programada, En curso, Completada, Cancelada.");
            return false;
        }

        Tutoria tutoria = new Tutoria(fecha, hora, estado, tutor, estudiante, materia);
        return tutoriaDAO.create(tutoria);
    }

    public Tutoria read(int idTutoria) {
        if (idTutoria <= 0) {
            System.out.println("El ID de la tutoría no puede ser negativo o cero.");
            return null;
        }
        return tutoriaDAO.read(idTutoria);
    }

    public boolean update(int idTutoria, String fecha, String hora, String estado, Tutor tutor, Estudiante estudiante, Materia materia) {
        // Valida el ID de la tutoría.
        if (idTutoria <= 0) {
            System.out.println("El ID de la tutoría no puede ser negativo o cero.");
            return false;
        }

        if (tutoriaDAO.read(idTutoria) == null) {
            System.out.println("La tutoría que intenta actualizar no existe.");
            return false;
        }

        // Valida que ningún dato sea nulo.
        if (fecha == null || hora == null || estado == null || tutor == null || estudiante == null || materia == null) {
            System.out.println("Ningún dato puede ser nulo.");
            return false;
        }
        
        
        // Aquí se podrían omitir validaciones de fecha/hora pasadas si se permite modificar registros históricos.
       

        if (!Pattern.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$", fecha) || !Pattern.matches("^([01]\\d|2[0-3]):[0-5]\\d$", hora)) {
            System.out.println("El formato de fecha (AAAA-MM-DD) u hora (HH:mm) es incorrecto.");
            return false;
        }
        
        if (ESTADOS_PERMITIDOS.stream().noneMatch(e -> e.equalsIgnoreCase(estado))) {
            System.out.println("Estado no válido. Opciones: Programada, En curso, Completada, Cancelada.");
            return false;
        }

        Tutoria tutoria = new Tutoria(idTutoria, fecha, hora, estado, tutor, estudiante, materia);
        return tutoriaDAO.update(tutoria);
    }

    public boolean delete(int idTutoria) {
        if (idTutoria <= 0) {
            System.out.println("El ID de la tutoría no puede ser negativo o cero.");
            return false;
        }
        if (tutoriaDAO.read(idTutoria) == null) {
            System.out.println("La tutoría que intenta eliminar no existe.");
            return false;
        }
        return tutoriaDAO.delete(idTutoria);
    }

    public List<Tutoria> readAll() {
        return tutoriaDAO.readAll();
    }
}