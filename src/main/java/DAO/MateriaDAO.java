/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import interfaces.IMateriaDAO;
import models.Materia;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public class MateriaDAO implements IMateriaDAO {

    @Override
    public boolean insertar(Materia materia) {
        return false;
    }

    @Override
    public Materia obtenerPorId(int idMateria) {
        return null;
    }

    @Override
    public List<Materia> obtenerTodos() {
        return List.of();
    }

    @Override
    public boolean actualizar(Materia materia) {
        return false;
    }

    @Override
    public boolean eliminar(int idMateria) {
        return false;
    }
}
