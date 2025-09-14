/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import interfaces.IEstudianteDAO;
import models.Estudiante;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public class EstudianteDAO implements IEstudianteDAO {

    @Override
    public boolean insertar(Estudiante estudiante) {
        return false;
    }

    @Override
    public Estudiante obtenerPorId(int idEstudiante) {
        return null;
    }

    @Override
    public List<Estudiante> obtenerTodos() {
        return List.of();
    }

    @Override
    public boolean actualizar(Estudiante estudiante) {
        return false;
    }

    @Override
    public boolean eliminar(int idEstudiante) {
        return false;
    }
}
