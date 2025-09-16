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

    public boolean create(String nombre, String telefono, String correo, String especialidad){
        if (nombre == null  || telefono == null || correo == null || especialidad == null) {
            System.out.println("Ningun dato no puede estar vacio");
            return false;
        }
        if (!Pattern.matches("\\d{10}", telefono)){
            System.out.println("La telefono no es de 10 digitos");
            return false;
        }
        if (!Pattern.matches("^[\\w._%+-]+@[\\w.-]+\\.[A-Za-z]{2,6}$", correo)){
            System.out.println("El correo no cumple con el formato");
            return false;
        }
        Tutor tutor = new Tutor(nombre, telefono, correo, especialidad);
        return tutorDAO.create(tutor);
    }

    public Tutor read(int idTutor){
        if (idTutor <= 0){
            System.out.println("El ID no puede ser negativa");
        }
        return tutorDAO.read(idTutor);
    }

    public boolean update(int idTutor, String nombre, String telefono, String correo, String especialidad){
        if (idTutor <= 0){
            System.out.println("El ID no puede ser negativa");
        }
        if (nombre == null  || telefono == null || correo == null || especialidad == null) {
            System.out.println("Ningun dato no puede estar vacio");
            return false;
        }
        if (tutorDAO.read(idTutor) == null) {
            System.out.println("El Tutor no existe");
            return false;
        }
        if (!Pattern.matches("\\d{10}", telefono)){
            System.out.println("La telefono no es de 10 digitos");
            return false;
        }
        if (!Pattern.matches("^[\\w._%+-]+@[\\w.-]+\\.[A-Za-z]{2,6}$", correo)){
            System.out.println("El correo no cumple con el formato");
            return false;
        }
        Tutor tutor = new Tutor(idTutor, nombre, telefono, correo, especialidad);
        return tutorDAO.update(tutor);
    }

    public boolean delete(int idTutor){
        if (idTutor <= 0){
            System.out.println("El ID no puede ser negativa");
        }
        if (tutorDAO.read(idTutor) == null) {
            System.out.println("El Tutor no existe");
            return false;
        }
        return tutorDAO.delete(idTutor);
    }

    public List<Tutor> readAll(){
        return tutorDAO.readAll();
    }
}
