/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;
import models.Tutor;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public interface ITutorDAO {
    boolean insertar(Tutor tutor);

    Tutor obtenerPorId(int idTutor);

    List<Tutor> obtenerTodos();

    boolean actualizar(Tutor tutor);

    boolean eliminar(int idTutor);
}
