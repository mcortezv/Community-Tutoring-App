/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;
import models.Materia;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public interface IMateriaDAO {

    boolean create(Materia materia);

    Materia read(int idMateria);

    boolean update(Materia materia);

    boolean delete(int idMateria);

    List<Materia> readAll();
}
