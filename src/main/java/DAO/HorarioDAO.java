/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import interfaces.IHorarioDAO;
import models.Horario;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public class HorarioDAO implements IHorarioDAO {

    @Override
    public boolean insertar(Horario horario) {
        return false;
    }

    @Override
    public Horario obtenerPorId(int idHorario) {
        return null;
    }

    @Override
    public List<Horario> obtenerTodos() {
        return List.of();
    }

    @Override
    public boolean actualizar(Horario horario) {
        return false;
    }

    @Override
    public boolean eliminar(int idHorario) {
        return false;
    }
}
