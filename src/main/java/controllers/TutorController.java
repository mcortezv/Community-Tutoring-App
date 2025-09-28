/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import DAO.TutorDAO;
import models.Tutor;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author Cortez, Manuel;
 */
public class TutorController {
    
    private final TutorDAO tutorDAO;

    public TutorController() {
        tutorDAO = new TutorDAO();
    }

    public boolean create(String nombre, String telefono, String correo, String especialidad) {
        // Valida que los objetos no sean nulos
        if (nombre == null || telefono == null || correo == null || especialidad == null) {
            System.out.println("Ningún campo puede ser nulo.");
            return false;
        }

        // Valida que las cadenas no estén vacías o contengan solo espacios en blanco.
        if (nombre.trim().isEmpty() || telefono.trim().isEmpty() || correo.trim().isEmpty() || especialidad.trim().isEmpty()) {
            System.out.println("Ningún campo puede estar vacío.");
            return false;
        }

        // Valida que el nombre solo contenga letras y espacios.
        if (!Pattern.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$", nombre)) {
            System.out.println("El nombre solo puede contener letras y espacios.");
            return false;
        }

        // Valida que el teléfono contenga 10 dígitos numéricos.
        if (!Pattern.matches("\\d{10}", telefono)) {
            System.out.println("El teléfono debe contener exactamente 10 dígitos numéricos.");
            return false;
        }
        
        // Valida un formato de correo electrónico estándar.
        if (!Pattern.matches("^[\\w._%+-]+@[\\w.-]+\\.[A-Za-z]{2,6}$", correo)) {
            System.out.println("El formato del correo electrónico no es válido.");
            return false;
        }

        // Valida una longitud razonable para la especialidad.
        if (especialidad.trim().length() < 5 || especialidad.trim().length() > 100) {
            System.out.println("La especialidad debe tener entre 5 y 100 caracteres.");
            return false;
        }

        Tutor tutor = new Tutor(nombre, telefono, correo, especialidad);
        return tutorDAO.create(tutor);
    }

    public Tutor read(int idTutor) {
        if (idTutor <= 0) {
            System.out.println("El ID del tutor no puede ser negativo o cero.");
            return null; // Evita una consulta innecesaria a la BD.
        }
        return tutorDAO.read(idTutor);
    }

    public boolean update(int idTutor, String nombre, String telefono, String correo, String especialidad) {
        // Valida el ID primero.
        if (idTutor <= 0) {
            System.out.println("El ID del tutor no puede ser negativo o cero.");
            return false;
        }

        if (tutorDAO.read(idTutor) == null) {
            System.out.println("El tutor que intenta actualizar no existe.");
            return false;
        }

        // Valida que los demás campos no sean nulos.
        if (nombre == null || telefono == null || correo == null || especialidad == null) {
            System.out.println("Ningún campo puede ser nulo.");
            return false;
        }
        
        // Valida que las cadenas no estén vacías.
        if (nombre.trim().isEmpty() || telefono.trim().isEmpty() || correo.trim().isEmpty() || especialidad.trim().isEmpty()) {
            System.out.println("Ningún campo puede estar vacío.");
            return false;
        }

        // Reutiliza las mismas validaciones del método create.
        if (!Pattern.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$", nombre)) {
            System.out.println("El nombre solo puede contener letras y espacios.");
            return false;
        }

        if (!Pattern.matches("\\d{10}", telefono)) {
            System.out.println("El teléfono debe contener exactamente 10 dígitos numéricos.");
            return false;
        }

        if (!Pattern.matches("^[\\w._%+-]+@[\\w.-]+\\.[A-Za-z]{2,6}$", correo)) {
            System.out.println("El formato del correo electrónico no es válido.");
            return false;
        }
        
        if (especialidad.trim().length() < 5 || especialidad.trim().length() > 100) {
            System.out.println("La especialidad debe tener entre 5 y 100 caracteres.");
            return false;
        }

        Tutor tutor = new Tutor(idTutor, nombre, telefono, correo, especialidad);
        return tutorDAO.update(tutor);
    }

    public boolean delete(int idTutor) {
        if (idTutor <= 0) {
            System.out.println("El ID del tutor no puede ser negativo o cero.");
            return false;
        }
        if (tutorDAO.read(idTutor) == null) {
            System.out.println("El tutor que intenta eliminar no existe.");
            return false;
        }
        return tutorDAO.delete(idTutor);
    }

    public List<Tutor> readAll() {
        return tutorDAO.readAll();
    }
}