/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;
import DAO.MateriaDAO;
import interfaces.IMateriaDAO;
import models.Materia;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Angel Beltran;
 * @author Cortez, Manuel (Modificado por Angel);
 */
public class MateriaController {
    private final IMateriaDAO materiaDAO;
    // Lista de niveles permitidos para estandarizar la entrada de datos.
    private static final List<String> NIVELES_PERMITIDOS = Arrays.asList("Primaria", "Secundaria", "Preparatoria", "Universidad");


    public MateriaController() {
        materiaDAO = new MateriaDAO();
    }

    public boolean create(String nombre, String nivel, String descripcion) {
        // Valida que los objetos no sean nulos
        if (nombre == null || nivel == null || descripcion == null) {
            System.out.println("Ningún campo puede ser nulo.");
            return false;
        }

        // Valida que las cadenas no estén vacías o contengan solo espacios en blanco.
        if (nombre.trim().isEmpty() || nivel.trim().isEmpty() || descripcion.trim().isEmpty()) {
            System.out.println("Ningún campo puede estar vacío.");
            return false;
        }
        // Valida que el nivel pertenezca a la lista de niveles permitidos (insensible a mayúsculas).
        if (NIVELES_PERMITIDOS.stream().noneMatch(n -> n.equalsIgnoreCase(nivel))) {
            System.out.println("El nivel educativo no es válido. Opciones: Primaria, Secundaria, Preparatoria, Universidad.");
            return false;
        }
        // Valida una longitud razonable para el nombre de la materia.
        if (nombre.trim().length() < 3 || nombre.trim().length() > 50) {
            System.out.println("El nombre de la materia debe tener entre 3 y 50 caracteres.");
            return false;
        }

        // Valida una longitud máxima para la descripción.
        if (descripcion.trim().length() > 255) {
            System.out.println("La descripción no puede exceder los 255 caracteres.");
            return false;
        }

        Materia materia = new Materia(nombre, nivel, descripcion);
        return materiaDAO.create(materia);
    }

    public Materia read(int idMateria) {
        if (idMateria <= 0) {
            System.out.println("El ID de la materia no puede ser negativo o cero.");
            return null; // Devuelve null para evitar una búsqueda innecesaria con un ID inválido.
        }
        return materiaDAO.read(idMateria);
    }

    public boolean update(int idMateria, String nombre, String nivel, String descripcion) {
        // Valida el ID primero.
        if (idMateria <= 0) {
            System.out.println("El ID de la materia no puede ser negativo o cero.");
            return false;
        }

        if (materiaDAO.read(idMateria) == null) {
            System.out.println("La materia que intenta actualizar no existe.");
            return false;
        }

        // Valida que los demás campos no sean nulos.
        if (nombre == null || nivel == null || descripcion == null) {
            System.out.println("Ningún campo puede ser nulo.");
            return false;
        }

        // Valida que las cadenas no estén vacías.
        if (nombre.trim().isEmpty() || nivel.trim().isEmpty() || descripcion.trim().isEmpty()) {
            System.out.println("Ningún campo puede estar vacío.");
            return false;
        }

        // Valida que el nivel sea uno de los permitidos.
        if (NIVELES_PERMITIDOS.stream().noneMatch(n -> n.equalsIgnoreCase(nivel))) {
            System.out.println("El nivel educativo no es válido. Opciones: Primaria, Secundaria, Preparatoria, Universidad.");
            return false;
        }
        if (nombre.trim().length() < 3 || nombre.trim().length() > 50) {
            System.out.println("El nombre de la materia debe tener entre 3 y 50 caracteres.");
            return false;
        }

        // Valida la longitud de la descripción.
        if (descripcion.trim().length() > 255) {
            System.out.println("La descripción no puede exceder los 255 caracteres.");
            return false;
        }

        Materia materia = new Materia(idMateria, nombre, nivel, descripcion);
        return materiaDAO.update(materia);
    }

    public boolean delete(int idMateria) {
        if (idMateria <= 0) {
            System.out.println("El ID de la materia no puede ser negativo o cero.");
            return false;
        }
        if (materiaDAO.read(idMateria) == null) {
            System.out.println("La materia que intenta eliminar no existe.");
            return false;
        }
        return materiaDAO.delete(idMateria);
    }

    public List<Materia> readAll() {
        return materiaDAO.readAll();
    }
}