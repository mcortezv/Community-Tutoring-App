/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import config.ConnectionDB;
import interfaces.ITutorDAO;
import models.Tutor;
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
public class TutorDAO implements ITutorDAO {

    @Override
    public void create(Tutor tutor) {
        String insert = "INSERT INTO Tutor(idTutor, nombreTutor, telefonoTutor, correo, especialidad) VALUES(?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(insert)) {
            ps.setInt(1, tutor.getId());
            ps.setString(2, tutor.getNombre());
            ps.setString(3, tutor.getTelefono());
            ps.setString(4, tutor.getCorreo());
            ps.setString(5, tutor.getEspecialidad());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Tutor read(int idTutor) {
        String read = "SELECT * FROM Tutor WHERE idTutor = ?";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(read)) {
            ps.setInt(1, idTutor);
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    Tutor tutor = new Tutor();
                    tutor.setId(rs.getInt("idTutor"));
                    tutor.setNombre(rs.getString("nombreTutor"));
                    tutor.setTelefono(rs.getString("telefonoTutor"));
                    tutor.setCorreo(rs.getString("correo"));
                    tutor.setEspecialidad(rs.getString("especialidad"));
                    return tutor;
                }
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Tutor tutor) {
        String update = "UPDATE Tutor SET nombreTutor = ?, telefonoTutor = ?, correo = ?, especialidad = ? WHERE idTutor = ?";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(update)){
            ps.setString(1, tutor.getNombre());
            ps.setString(2, tutor.getTelefono());
            ps.setString(3, tutor.getCorreo());
            ps.setString(4, tutor.getEspecialidad());
            ps.setInt(5, tutor.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(int idTutor) {
        String delete = "DELETE FROM Tutor WHERE idTutor = ?";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(delete);) {
            ps.setInt(1, idTutor);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Tutor> readAll() {
        List<Tutor> lista = new ArrayList<>();
        String read = "SELECT * FROM Tutor";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(read)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Tutor tutor = new Tutor();
                tutor.setId(rs.getInt("idTutor"));
                tutor.setNombre(rs.getString("nombreTutor"));
                tutor.setTelefono(rs.getString("telefonoTutor"));
                tutor.setCorreo(rs.getString("correo"));
                tutor.setEspecialidad(rs.getString("especialidad"));
                lista.add(tutor);
            }
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
