/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;
import models.Horario;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IHorarioDAO {

    boolean insertar(Horario horario);

    Horario obtenerPorId(int idHorario);

    List<Horario> obtenerTodos();

    boolean actualizar(Horario horario);

    boolean eliminar(int idHorario);
}
