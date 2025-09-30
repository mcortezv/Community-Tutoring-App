/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import config.ConnectionDB;
import interfaces.IMateriaDAO;
import models.Materia;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public class MateriaDAO implements IMateriaDAO {

    @Override
    public boolean create(Materia materia) {
        String insert = "INSERT INTO Materia(nombreMateria, nivel, descripcion) VALUES(?, ?, ?)";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(insert)) {
            ps.setString(1, materia.getNombre());
            ps.setString(2, materia.getNivel());
            ps.setString(3, materia.getDescripcion());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Materia read(int idMateria) {
        String read = "SELECT * FROM Materia WHERE idMateria = ?";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(read)) {
            ps.setInt(1, idMateria);
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    Materia materia = new Materia();
                    materia.setId(rs.getInt("idMateria"));
                    materia.setNombre(rs.getString("nombreMateria"));
                    materia.setNivel(rs.getString("nivel"));
                    materia.setDescripcion(rs.getString("descripcion"));
                    return materia;
                }
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Materia materia) {
        String update = "UPDATE Materia SET nombreMateria = ?, nivel = ?, descripcion = ? WHERE idMateria = ?";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(update)){
            ps.setString(1, materia.getNombre());
            ps.setString(2, materia.getNivel());
            ps.setString(3, materia.getDescripcion());
            ps.setInt(4, materia.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int idMateria) {
        String delete = "DELETE FROM Materia WHERE idMateria = ?";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(delete);) {
            ps.setInt(1, idMateria);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Materia> readAll() {
        List<Materia> lista = new ArrayList<>();
        String read = "SELECT * FROM Materia";
        try (Connection connection = ConnectionDB.getConnection();
             PreparedStatement ps = connection.prepareStatement(read)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Materia materia = new Materia();
                materia.setId(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombreMateria"));
                materia.setNivel(rs.getString("nivel"));
                materia.setDescripcion(rs.getString("descripcion"));
                lista.add(materia);
            }
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
