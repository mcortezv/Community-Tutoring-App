/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;
import models.Estudiante;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IEstudianteDAO {

    boolean insertar(Estudiante estudiante);

    Estudiante obtenerPorId(int idEstudiante);

    List<Estudiante> obtenerTodos();

    boolean actualizar(Estudiante estudiante);

    boolean eliminar(int idEstudiante);
}
