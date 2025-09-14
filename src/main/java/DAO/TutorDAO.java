/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import interfaces.ITutorDAO;
import models.Tutor;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public class TutorDAO implements ITutorDAO {

    @Override
    public boolean insertar(Tutor tutor) {
        return false;
    }

    @Override
    public Tutor obtenerPorId(int idTutor) {
        return null;
    }

    @Override
    public List<Tutor> obtenerTodos() {
        return List.of();
    }

    @Override
    public boolean actualizar(Tutor tutor) {
        return false;
    }

    @Override
    public boolean eliminar(int idTutor) {
        return false;
    }
}
