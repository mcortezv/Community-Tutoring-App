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

    void create(Tutoria tutoria);

    Tutoria read(int idTutoria);

    void update(Tutoria tutoria);

    void delete(int idTutoria);

    List<Tutoria> readAll();
}
