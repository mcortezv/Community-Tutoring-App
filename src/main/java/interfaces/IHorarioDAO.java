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

    boolean create(Horario horario);

    Horario read(int idHorario);

    boolean update(Horario horario);

    boolean delete(int idHorario);

    List<Horario> readAll();
}
