/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import config.ConnectionDB;
import interfaces.IHorarioDAO;
import models.Horario;
import models.Tutor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public class HorarioDAO implements IHorarioDAO {

    @Override
    public boolean create(Horario horario) {
        String insert = "INSERT INTO Horario(dia, horaInicio, horaFin, idTutor) VALUES(?, ?, ?, ?)";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(insert)){
            ps.setString(1, horario.getDia());
            ps.setString(2, horario.getHoraInicio());
            ps.setString(3, horario.getHoraFin());
            ps.setInt(4, horario.getTutor().getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Horario read(int idHorario) {
        String read = "SELECT * FROM Horario INNER JOIN Tutor ON Horario.idTutor = Tutor.idTutor WHERE idHorario = ?";
        try (Connection connection = ConnectionDB.getConnection();
            PreparedStatement ps = connection.prepareStatement(read)){
            ps.setInt(1, idHorario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                Horario horario = new Horario();
                horario.setId(rs.getInt("idHorario"));
                horario.setDia(rs.getString("dia"));
                horario.setHoraInicio(rs.getString("horaInicio"));
                horario.setHoraFin(rs.getString("horaFin"));
                horario.setTutor(new Tutor(rs.getInt("idTutor"),
                        rs.getString("nombreTutor"),
                        rs.getString("telefonoTutor"),
                        rs.getString("correo"),
                        rs.getString("especialidad")));
                return horario;
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Horario horario) {
        String update = "UPDATE Horario SET dia = ?, horaInicio = ?, horaFin = ?, idTutor = ? WHERE idHorario = ?";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(update)){
            ps.setString(1, horario.getDia());
            ps.setString(2, horario.getHoraInicio());
            ps.setString(3, horario.getHoraFin());
            ps.setInt(4, horario.getTutor().getId());
            ps.setInt(5, horario.getId());
            ps.executeUpdate();
            return  true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int idHorario) {
        String delete = "DELETE FROM Horario WHERE idHorario = ?";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(delete);) {
            ps.setInt(1, idHorario);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Horario> readAll() {
        List<Horario> lista = new ArrayList<>();
        String read = "SELECT * FROM Horario INNER JOIN Tutor ON Horario.idTutor = Tutor.idTutor";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(read)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Horario horario = new Horario();
                horario.setId(rs.getInt("idHorario"));
                horario.setDia(rs.getString("dia"));
                horario.setHoraInicio(rs.getString("horaInicio"));
                horario.setHoraFin(rs.getString("horaFin"));
                horario.setTutor(new Tutor(rs.getInt("idTutor"),
                        rs.getString("nombreTutor"),
                        rs.getString("telefonoTutor"),
                        rs.getString("correo"),
                        rs.getString("especialidad")));
                lista.add(horario);
            }
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
