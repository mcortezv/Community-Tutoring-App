/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;
import DAO.TutoriaDAO;
import models.*;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author Cortez, Manuel;
 */
public class TutoriaController {
    private final TutoriaDAO tutoriaDAO;
    private final String[] estados = {"Programada", "En curso", "Completada"};

    public TutoriaController() {
        tutoriaDAO = new TutoriaDAO();
    }

    public boolean create(String fecha, String hora, String estado, Tutor tutor, Estudiante estudiante, Materia materia){
        if (fecha == null  || hora == null || estado == null || tutor == null || estudiante == null || materia == null) {
            System.out.println("Ningun dato no puede estar vacio");
            return false;
        }
        if (!Pattern.matches("^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$", fecha)){
            System.out.println("La fecha no cumple con el formato");
            return false;
        }
        if (!Pattern.matches("^([01]\\d|2[0-3]):[0-5]\\d$", hora)){
            System.out.println("La hora no cumple con el formato");
            return false;
        }
        if (!Arrays.asList(estados).contains(estado)) {
            System.out.println("Estado inexistente (Programada, En curso, Completada)");
            return false;
        }
        Tutoria tutoria = new Tutoria(fecha, hora, estado, tutor, estudiante, materia);
        return tutoriaDAO.create(tutoria);
    }

    public Tutoria read(int idTutoria){
        if (idTutoria <= 0){
            System.out.println("El ID no puede ser negativa");
        }
        return tutoriaDAO.read(idTutoria);
    }

    public boolean update(int idTutoria, String fecha, String hora, String estado, Tutor tutor, Estudiante estudiante, Materia materia){
        if (idTutoria <= 0){
            System.out.println("El ID no puede ser negativa");
        }
        if (fecha == null  || hora == null || estado == null || tutor == null || estudiante == null || materia == null) {
            System.out.println("Ningun dato no puede estar vacio");
            return false;
        }
        if (tutoriaDAO.read(idTutoria) == null) {
            System.out.println("El estudiante no existe");
            return false;
        }
        if (!Pattern.matches("^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$", fecha)){
            System.out.println("La fecha no cumple con el formato");
            return false;
        }
        if (!Pattern.matches("^([01]\\d|2[0-3]):[0-5]\\d$", hora)){
            System.out.println("La hora no cumple con el formato");
            return false;
        }
        if (!Arrays.asList(estados).contains(estado)) {
            System.out.println("Estado inexistente (Programada, En curso, Completada)");
            return false;
        }
        Tutoria tutoria = new Tutoria(idTutoria, fecha, hora, estado, tutor, estudiante, materia);
        return tutoriaDAO.update(tutoria);
    }

    public boolean delete(int idTutoria){
        if (idTutoria <= 0){
            System.out.println("El ID no puede ser negativa");
        }
        if (tutoriaDAO.read(idTutoria) == null) {
            System.out.println("El estudiante no existe");
            return false;
        }
        return  tutoriaDAO.delete(idTutoria);
    }

    public List<Tutoria> readAll(){
        return tutoriaDAO.readAll();
    }
}
