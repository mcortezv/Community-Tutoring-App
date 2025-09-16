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

    void create(Estudiante estudiante);

    Estudiante read(int idEstudiante);

    void update(Estudiante estudiante);

    void delete(int idEstudiante);

    List<Estudiante> readAll();
}
