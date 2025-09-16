/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import config.ConnectionDB;
import interfaces.ITutoriaDAO;
import models.Estudiante;
import models.Materia;
import models.Tutor;
import models.Tutoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public class TutoriaDAO implements ITutoriaDAO {

    @Override
    public void create(Tutoria tutoria) {
        String insert = "INSERT INTO Tutoria(idTutoria, fecha, hora, estado, idTutor, idEstudiante, idMateria) VALUES(?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(insert)) {
            ps.setInt(1, tutoria.getId());
            ps.setString(2, tutoria.getFecha());
            ps.setString(3, tutoria.getHora());
            ps.setString(4, tutoria.getEstado());
            ps.setInt(5, tutoria.getTutor().getId());
            ps.setInt(6, tutoria.getEstudiante().getId());
            ps.setInt(7, tutoria.getMateria().getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Tutoria read(int idTutoria) {
        String read = "SELECT * FROM Tutoria INNER JOIN Tutor ON Tutoria.idTutor = Tutor.idTutor " +
                "INNER JOIN ESTUDIANTE ON Tutoria.idEstudiante = Estudiante.idEstudiante " +
                "INNER JOIN Materia ON Tutoria.idMateria = Materia.idMateria WHERE idTutoria = ?";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(read)) {
            ps.setInt(1, idTutoria);
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    Tutoria tutoria = new Tutoria();
                    tutoria.setId(rs.getInt("idTutoria"));
                    tutoria.setFecha(rs.getString("fecha"));
                    tutoria.setHora(rs.getString("hora"));
                    tutoria.setEstado(rs.getString("estado"));
                    Tutor tutor = new Tutor();
                    tutor.setId(rs.getInt("idTutor"));
                    tutor.setNombre(rs.getString("nombreTutor"));
                    tutor.setTelefono(rs.getString("telefonoTutor"));
                    tutor.setCorreo(rs.getString("correo"));
                    tutor.setEspecialidad(rs.getString("especialidad"));
                    tutoria.setTutor(tutor);
                    Estudiante estudiante = new Estudiante();
                    estudiante.setId(rs.getInt("idEstudiante"));
                    estudiante.setNombre(rs.getString("nombreEstudiante"));
                    estudiante.setGradoEscolar(rs.getString("gradoEscolar"));
                    estudiante.setEdad(rs.getInt("edad"));
                    estudiante.setTelefono(rs.getString("telefonoEstudiante"));
                    estudiante.setEscuelaProcedencia(rs.getString("escuelaProcedencia"));
                    tutoria.setEstudiante(estudiante);
                    Materia materia = new Materia();
                    materia.setId(rs.getInt("idMateria"));
                    materia.setNombre(rs.getString("nombreMateria"));
                    materia.setNivel(rs.getString("nivel"));
                    materia.setDescripcion(rs.getString("descripcion"));
                    tutoria.setMateria(materia);
                    return tutoria;
                }
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Tutoria tutoria) {
        String update = "UPDATE Tutoria SET fecha = ?, hora = ?, estado = ?, idTutor = ?, idEstudiante = ?, idMateria = ? WHERE idTutoria = ?";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(update)){
            ps.setString(1, tutoria.getFecha());
            ps.setString(2, tutoria.getHora());
            ps.setString(3, tutoria.getEstado());
            ps.setInt(4, tutoria.getTutor().getId());
            ps.setInt(5, tutoria.getEstudiante().getId());
            ps.setInt(6, tutoria.getMateria().getId());
            ps.setInt(7, tutoria.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(int idTutoria) {
        String delete = "DELETE FROM Tutoria WHERE idTutoria = ?";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(delete);) {
            ps.setInt(1, idTutoria);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Tutoria> readAll() {
        List<Tutoria> lista = new ArrayList<>();
        String read = "SELECT * FROM Tutoria INNER JOIN Tutor ON Tutoria.idTutor = Tutor.idTutor" +
                "INNER JOIN Estudiante ON Tutoria.idEstudiante = Estudiante.idEstudiante" +
                "INNER JOIN Materia ON Tutoria.idMateria = Materia.idMateria";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(read)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Tutoria tutoria = new Tutoria();
                tutoria.setId(rs.getInt("idTutoria"));
                tutoria.setFecha(rs.getString("fecha"));
                tutoria.setHora(rs.getString("hora"));
                tutoria.setEstado(rs.getString("estado"));
                Tutor tutor = new Tutor();
                tutor.setId(rs.getInt("idTutor"));
                tutor.setNombre(rs.getString("nombreTutor"));
                tutor.setTelefono(rs.getString("telefonoTutor"));
                tutor.setCorreo(rs.getString("correo"));
                tutor.setEspecialidad(rs.getString("especialidad"));
                tutoria.setTutor(tutor);
                Estudiante estudiante = new Estudiante();
                estudiante.setId(rs.getInt("idEstudiante"));
                estudiante.setNombre(rs.getString("nombreEstudiante"));
                estudiante.setGradoEscolar(rs.getString("gradoEscolar"));
                estudiante.setEdad(rs.getInt("edad"));
                estudiante.setTelefono(rs.getString("telefonoEstudiante"));
                estudiante.setEscuelaProcedencia(rs.getString("escuelaProcedencia"));
                tutoria.setEstudiante(estudiante);
                Materia materia = new Materia();
                materia.setId(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombreMateria"));
                materia.setNivel(rs.getString("nivel"));
                materia.setDescripcion(rs.getString("descripcion"));
                tutoria.setMateria(materia);
                lista.add(tutoria);
            }
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
