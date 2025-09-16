/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;
import DAO.MateriaDAO;
import interfaces.IMateriaDAO;
import models.Materia;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public class MateriaController {
    private final IMateriaDAO materiaDAO;

    public MateriaController() {
        materiaDAO = new MateriaDAO();
    }

    public boolean create(String nombre, String nivel, String descripcion){
        if (nombre == null  || nivel == null || descripcion == null) {
            System.out.println("Ningun dato no puede estar vacio");
            return false;
        }
        Materia materia = new Materia(nombre, nivel, descripcion);
        return materiaDAO.create(materia);
    }

    public Materia read(int idMateria){
        if (idMateria <= 0){
            System.out.println("El ID no puede ser negativa");
        }
        return materiaDAO.read(idMateria);
    }

    public boolean update(int idMateria, String nombre, String nivel, String descripcion){
        if (idMateria <= 0){
            System.out.println("El ID no puede ser negativa");
        }
        if (materiaDAO.read(idMateria) == null) {
            System.out.println("La materia no existe");
            return false;
        }
        if (nombre == null  || nivel == null || descripcion == null) {
            System.out.println("Ningun dato no puede estar vacio");
            return false;
        }
        Materia materia = new Materia(idMateria, nombre, nivel, descripcion);
        return materiaDAO.update(materia);
    }

    public boolean delete(int idMateria){
        if (idMateria <= 0){
            System.out.println("El ID no puede ser negativa");
        }
        if (materiaDAO.read(idMateria) == null) {
            System.out.println("La materia no existe");
            return false;
        }
        return materiaDAO.delete(idMateria);
    }

    public List<Materia> readAll(){
        return materiaDAO.readAll();
    }
}
