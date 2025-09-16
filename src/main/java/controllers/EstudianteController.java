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
 * @author Cortez, Manuel;
 */
public class EstudianteController {
    private final IEstudianteDAO estudianteDAO;

    public EstudianteController() {
        estudianteDAO = new EstudianteDAO();
    }

    public boolean createEstudiante(String nombre, String gradoEscolar, int edad, String telefono, String escuelaProcedencia) {
        if (nombre == null  || gradoEscolar == null || telefono == null || escuelaProcedencia == null) {
            System.out.println("Ningun dato no puede estar vacio");
            return false;
        }
        if (edad <= 0) {
            System.out.println("La edad no puede ser negativa");
            return false;
        }
        if (!Pattern.matches("\\d{10}", telefono)){
            System.out.println("La telefono no es de 10 digitos");
            return false;
        }
        Estudiante estudiante = new Estudiante(nombre, gradoEscolar, edad, telefono, escuelaProcedencia);
        return estudianteDAO.create(estudiante);
    }

    public Estudiante readEstudiante(int idEstudiante){
        if (idEstudiante <= 0){
            System.out.println("El ID no puede ser negativa");
        }
        return estudianteDAO.read(idEstudiante);
    }

    public boolean updateEstudiante(int idEstudiante, String nombre, String gradoEscolar, int edad, String telefono, String escuelaProcedencia){
        if (nombre == null  || gradoEscolar == null || telefono == null || escuelaProcedencia == null) {
            System.out.println("Ningun dato no puede estar vacio");
            return false;
        }
        if (idEstudiante <= 0) {
            System.out.println("El ID no puede ser negativa");
            return false;
        }
        if (estudianteDAO.read(idEstudiante) == null) {
            System.out.println("El estudiante no existe");
            return false;
        }
        if (edad <= 0) {
            System.out.println("La edad no puede ser negativa");
            return false;
        }
        if (!Pattern.matches("\\d{10}", telefono)){
            System.out.println("La telefono no es de 10 digitos");
            return false;
        }
        Estudiante estudiante = new Estudiante(idEstudiante, nombre, gradoEscolar, edad, telefono, escuelaProcedencia);
        return estudianteDAO.update(estudiante);
    }

    public boolean deleteEstudiante(int idEstudiante){
        if (idEstudiante <= 0) {
            System.out.println("El ID no puede ser negativa");
            return false;
        }
        if (estudianteDAO.read(idEstudiante) == null) {
            System.out.println("El estudiante no existe");
            return false;
        }
        return estudianteDAO.delete(idEstudiante);
    }

    public List<Estudiante> readAllEstudiantes(){
        return estudianteDAO.readAll();
    }
}
