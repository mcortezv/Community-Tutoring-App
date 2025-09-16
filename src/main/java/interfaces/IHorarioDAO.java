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

    void create(Horario horario);

    Horario read(int idHorario);

    void update(Horario horario);

    void delete(int idHorario);

    List<Horario> readAll();
}
