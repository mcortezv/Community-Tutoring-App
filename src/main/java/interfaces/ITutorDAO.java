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

    boolean create(Tutor tutor);

    Tutor read(int idTutor);

    boolean update(Tutor tutor);

    boolean delete(int idTutor);

    List<Tutor> readAll();
}
