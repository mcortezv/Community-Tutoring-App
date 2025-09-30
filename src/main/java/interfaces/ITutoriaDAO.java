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

    boolean create(Tutoria tutoria);

    Tutoria read(int idTutoria);

    boolean update(Tutoria tutoria);

    boolean delete(int idTutoria);

    List<Tutoria> readAll();
}
