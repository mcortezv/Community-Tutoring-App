/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import config.ConnectionDB;
import interfaces.ITutorDAO;
import models.Tutor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public class TutorDAO implements ITutorDAO {

    @Override
    public boolean create(Tutor tutor) {
        String insert = "INSERT INTO Tutor(nombreTutor, telefonoTutor, correo, especialidad) VALUES(?, ?, ?, ?)";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(insert)) {
            ps.setString(1, tutor.getNombre());
            ps.setString(2, tutor.getTelefono());
            ps.setString(3, tutor.getCorreo());
            ps.setString(4, tutor.getEspecialidad());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
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
    public boolean update(Tutor tutor) {
        String update = "UPDATE Tutor SET nombreTutor = ?, telefonoTutor = ?, correo = ?, especialidad = ? WHERE idTutor = ?";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(update)){
            ps.setString(1, tutor.getNombre());
            ps.setString(2, tutor.getTelefono());
            ps.setString(3, tutor.getCorreo());
            ps.setString(4, tutor.getEspecialidad());
            ps.setInt(5, tutor.getId());
            ps.executeUpdate();
            return  true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int idTutor) {
        String delete = "DELETE FROM Tutor WHERE idTutor = ?";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(delete);) {
            ps.setInt(1, idTutor);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
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
