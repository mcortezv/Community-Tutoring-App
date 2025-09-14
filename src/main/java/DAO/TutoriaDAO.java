/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import interfaces.ITutoriaDAO;
import models.Tutoria;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public class TutoriaDAO implements ITutoriaDAO {

    @Override
    public boolean insertar(Tutoria tutoria) {
        return false;
    }

    @Override
    public Tutoria obtenerPorId(int idTutoria) {
        return null;
    }

    @Override
    public List<Tutoria> obtenerTodos() {
        return List.of();
    }

    @Override
    public boolean actualizar(Tutoria tutoria) {
        return false;
    }

    @Override
    public boolean eliminar(int idTutoria) {
        return false;
    }
}
