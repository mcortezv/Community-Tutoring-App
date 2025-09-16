/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import interfaces.IEstudianteDAO;
import models.Estudiante;
import config.ConnectionDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public class EstudianteDAO implements IEstudianteDAO {

    @Override
    public boolean create(Estudiante estudiante) {
        String insert = "INSERT INTO Estudiante(idEstudiante, nombreEstudiante, gradoEscolar, edad, telefonoEstudiante, escuelaProcedencia) VALUES(?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionDB.getConnection();
            PreparedStatement ps = connection.prepareStatement(insert)) {
            ps.setInt(1, estudiante.getId());
            ps.setString(2, estudiante.getNombre());
            ps.setString(3, estudiante.getGradoEscolar());
            ps.setInt(4, estudiante.getEdad());
            ps.setString(5, estudiante.getTelefono());
            ps.setString(6, estudiante.getEscuelaProcedencia());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Estudiante read(int idEstudiante) {
        String read = "SELECT * FROM Estudiante WHERE idEstudiante = ?";
        try (Connection connection = ConnectionDB.getConnection();
            PreparedStatement ps = connection.prepareStatement(read)) {
            ps.setInt(1, idEstudiante);
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    Estudiante estudiante = new Estudiante();
                    estudiante.setId(rs.getInt("idEstudiante"));
                    estudiante.setNombre(rs.getString("nombreEstudiante"));
                    estudiante.setGradoEscolar(rs.getString("gradoEscolar"));
                    estudiante.setEdad(rs.getInt("edad"));
                    estudiante.setTelefono(rs.getString("telefonoEstudiante"));
                    estudiante.setEscuelaProcedencia(rs.getString("escuelaProcedencia"));
                    return estudiante;
                }
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Estudiante estudiante) {
        String update = "UPDATE Estudiante SET nombreEstudiante = ?, gradoEscolar = ?, edad = ?, telefonoEstudiante = ?, escuelaProcedencia = ? WHERE idEstudiante = ?";
        try (Connection connection = ConnectionDB.getConnection();
            PreparedStatement ps = connection.prepareStatement(update)){
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getGradoEscolar());
            ps.setInt(3, estudiante.getEdad());
            ps.setString(4, estudiante.getTelefono());
            ps.setString(5, estudiante.getEscuelaProcedencia());
            ps.setInt(6, estudiante.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int idEstudiante) {
        String delete = "DELETE FROM Estudiante WHERE idEstudiante = ?";
        try (Connection connection = ConnectionDB.getConnection();
            PreparedStatement ps = connection.prepareStatement(delete);) {
            ps.setInt(1, idEstudiante);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Estudiante> readAll() {
        List<Estudiante> lista = new ArrayList<>();
        String read = "SELECT * FROM Estudiante";
        try (Connection connection = ConnectionDB.getConnection();
            PreparedStatement ps = connection.prepareStatement(read)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Estudiante estudiante = new Estudiante();
                estudiante.setId(rs.getInt("idEstudiante"));
                estudiante.setNombre(rs.getString("nombreEstudiante"));
                estudiante.setGradoEscolar(rs.getString("gradoEscolar"));
                estudiante.setEdad(rs.getInt("edad"));
                estudiante.setTelefono(rs.getString("telefonoEstudiante"));
                estudiante.setEscuelaProcedencia(rs.getString("escuelaProcedencia"));
                lista.add(estudiante);
            }
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
