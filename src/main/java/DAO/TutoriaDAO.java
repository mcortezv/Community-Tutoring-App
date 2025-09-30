/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import config.ConnectionDB;
import interfaces.ITutoriaDAO;
import models.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public class TutoriaDAO implements ITutoriaDAO {

    @Override
    public boolean create(Tutoria tutoria) {
        String insert = "INSERT INTO Tutoria(fecha, hora, estado, idTutor, idEstudiante, idMateria) VALUES(?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(insert)) {
            ps.setString(1, tutoria.getFecha());
            ps.setString(2, tutoria.getHora());
            ps.setString(3, tutoria.getEstado());
            ps.setInt(4, tutoria.getTutor().getId());
            ps.setInt(5, tutoria.getEstudiante().getId());
            ps.setInt(6, tutoria.getMateria().getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Tutoria read(int idTutoria) {
        String read = "SELECT * FROM Tutoria INNER JOIN Tutor ON Tutoria.idTutor = Tutor.idTutor " +
                "INNER JOIN Estudiante ON Tutoria.idEstudiante = Estudiante.idEstudiante " +
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
                    tutoria.setTutor(new Tutor(rs.getInt("idTutor"),
                            rs.getString("nombreTutor"),
                            rs.getString("telefonoTutor"),
                            rs.getString("correo"),
                            rs.getString("especialidad")));
                    tutoria.setEstudiante(new Estudiante(rs.getInt("idEstudiante"),
                            rs.getString("nombreEstudiante"),
                            rs.getString("gradoEscolar"),
                            rs.getInt("edad"),
                            rs.getString("telefonoEstudiante"),
                            rs.getString("escuelaProcedencia")));
                    tutoria.setMateria(new Materia(rs.getInt("idMateria"),
                            rs.getString("nombreMateria"),
                            rs.getString("nivel"),
                            rs.getString("descripcion")));
                    return tutoria;
                }
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Tutoria tutoria) {
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
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int idTutoria) {
        String delete = "DELETE FROM Tutoria WHERE idTutoria = ?";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(delete);) {
            ps.setInt(1, idTutoria);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Tutoria> readAll() {
        List<Tutoria> lista = new ArrayList<>();
        String read = "SELECT * FROM Tutoria INNER JOIN Tutor ON Tutoria.idTutor = Tutor.idTutor " +
                "INNER JOIN Estudiante ON Tutoria.idEstudiante = Estudiante.idEstudiante " +
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
                tutoria.setTutor(new Tutor(rs.getInt("idTutor"),
                        rs.getString("nombreTutor"),
                        rs.getString("telefonoTutor"),
                        rs.getString("correo"),
                        rs.getString("especialidad")));
                tutoria.setEstudiante(new Estudiante(rs.getInt("idEstudiante"),
                        rs.getString("nombreEstudiante"),
                        rs.getString("gradoEscolar"),
                        rs.getInt("edad"),
                        rs.getString("telefonoEstudiante"),
                        rs.getString("escuelaProcedencia")));
                tutoria.setMateria(new Materia(rs.getInt("idMateria"),
                        rs.getString("nombreMateria"),
                        rs.getString("nivel"),
                        rs.getString("descripcion")));
                lista.add(tutoria);
            }
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
