/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;
import models.Tutoria;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public interface ITutoriaDAO {

    boolean insertar(Tutoria tutoria);

    Tutoria obtenerPorId(int idTutoria);

    List<Tutoria> obtenerTodos();

    boolean actualizar(Tutoria tutoria);

    boolean eliminar(int idTutoria);
}
