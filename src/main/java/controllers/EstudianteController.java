/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;
import DAO.EstudianteDAO;
import interfaces.IEstudianteDAO;
import models.Estudiante;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author Angel Beltran;
 * @author Cortez, Manuel (Modificado por Angel);
 */
public class EstudianteController {
    private final IEstudianteDAO estudianteDAO;

    public EstudianteController() {
        estudianteDAO = new EstudianteDAO();
    }

    public boolean create(String nombre, String gradoEscolar, int edad, String telefono, String escuelaProcedencia) {
        // Valida que los objetos no sean nulos
        if (nombre == null || gradoEscolar == null || telefono == null || escuelaProcedencia == null) {
            System.out.println("Ningun dato puede ser nulo.");
            return false;
        }

        // Valida que las cadenas de texto no estén vacías o solo contengan espacios
        if (nombre.trim().isEmpty() || gradoEscolar.trim().isEmpty() || telefono.trim().isEmpty() || escuelaProcedencia.trim().isEmpty()) {
            System.out.println("Ningun campo de texto puede estar vacío.");
            return false;
        }

        // Valida el rango de edad 
        if (edad <= 2 || edad > 100) {
            System.out.println("La edad debe estar en un rango válido (ej. 3-100).");
            return false;
        }


        // Valida que el teléfono tenga 10 dígitos numéricos
        if (!Pattern.matches("\\d{10}", telefono)) {
            System.out.println("El teléfono debe contener exactamente 10 dígitos numéricos.");
            return false;
        }

        Estudiante estudiante = new Estudiante(nombre, gradoEscolar, edad, telefono, escuelaProcedencia);
        return estudianteDAO.create(estudiante);
    }

    public Estudiante read(int idEstudiante) {
        if (idEstudiante <= 0) {
            System.out.println("El ID no puede ser negativo o cero.");
            return null; // Devuelve null si el ID es inválido 
        }
        return estudianteDAO.read(idEstudiante);
    }

    public boolean update(int idEstudiante, String nombre, String gradoEscolar, int edad, String telefono, String escuelaProcedencia) {
        // Valida el ID primero
        if (idEstudiante <= 0) {
            System.out.println("El ID no puede ser negativo o cero.");
            return false;
        }

        // Valida que los objetos no sean nulos
        if (nombre == null || gradoEscolar == null || telefono == null || escuelaProcedencia == null) {
            System.out.println("Ningun dato puede ser nulo.");
            return false;
        }

        // Valida que las cadenas de texto no estén vacías o solo contengan espacios
        if (nombre.trim().isEmpty() || gradoEscolar.trim().isEmpty() || telefono.trim().isEmpty() || escuelaProcedencia.trim().isEmpty()) {
            System.out.println("Ningun campo de texto puede estar vacío.");
            return false;
        }
        // Verifica que no sea null el ID
        if (estudianteDAO.read(idEstudiante) == null) {
            System.out.println("El estudiante con el ID proporcionado no existe.");
            return false;
        }

        // Valida un rango de edad sdfsfsfsdfsdfsfs
        if (edad <= 2 || edad > 100) {
            System.out.println("La edad debe estar en un rango válido (ej. 3-100).");
            return false;
        }


        // Valida que el teléfono tenga 10 dígitos numéricos
        if (!Pattern.matches("\\d{10}", telefono)) {
            System.out.println("El teléfono debe contener exactamente 10 dígitos numéricos.");
            return false;
        }

        Estudiante estudiante = new Estudiante(idEstudiante, nombre, gradoEscolar, edad, telefono, escuelaProcedencia);
        return estudianteDAO.update(estudiante);
    }

    public boolean delete(int idEstudiante) {
        if (idEstudiante <= 0) {
            System.out.println("El ID no puede ser negativo o cero.");
            return false;
        }
        if (estudianteDAO.read(idEstudiante) == null) {
            System.out.println("El estudiante que intenta eliminar no existe.");
            return false;
        }
        return estudianteDAO.delete(idEstudiante);
    }

    public List<Estudiante> readAllEstudiantes() {
        System.out.println("El estudiante que intenta eliminar no existe.");
        return estudianteDAO.readAll();
    }

}
