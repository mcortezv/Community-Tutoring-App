/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;
import DAO.TutorDAO;
import interfaces.ITutorDAO;
import models.Tutor;
import javax.swing.*;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author Angel Beltran;
 * @author Cortez, Manuel (Modificado por Angel);
 */

/**
 * Esta clase es el "cerebro" que maneja todo lo relacionado con los Tutores.
 * Funciona como un intermediario entre la vista (lo que el usuario ve) y
 * los datos (el DAO). Su trabajo principal es aplicar las reglas del negocio,
 * como validar que los datos sean correctos antes de mandarlos a guardar.
 */
public class TutorController {
    
    /**
     * Esta variable guardara nuestro objeto de acceso a datos (DAO).
     * La declaramos como la INTERFAZ (ITutorDAO) en lugar de la clase real (TutorDAO).
     * Esto es un truco genial que nos permite usar un DAO real en la aplicacion
     * y un DAO falso en las pruebas, haciendo el codigo mas flexible y profesional.
     */
    private final ITutorDAO tutorDAO;

    /**
     * Este es el constructor que usa la aplicacion real.
     * Cuando la vista crea un TutorController, este constructor se encarga
     * de crear el DAO real que se conecta a la base de datos.
     */
    public TutorController() {
        this.tutorDAO = new TutorDAO();
    }

    /**
     * Este metodo se encarga de crear un nuevo tutor.
     * Recibe los datos desde la vista, los revisa uno por uno (validacion),
     * y si todo esta en orden, crea un objeto Tutor y se lo pasa al DAO para que lo guarde.
     * @return Devuelve 'true' si todo salio bien, o 'false' si algun dato era incorrecto.
     */
    public boolean create(String nombre, String telefono, String correo, String especialidad) {
        // --- SECCION DE VALIDACIONES ---
        // Primero, nos aseguramos de que ningun dato venga nulo (vacio).
        if (nombre == null || telefono == null || correo == null || especialidad == null) {
            return false; // Si algo es nulo, detenemos todo y devolvemos false.
        }
        
        // Luego, revisamos que los textos no esten vacios (puros espacios en blanco).
        if (nombre.trim().isEmpty() || telefono.trim().isEmpty() || correo.trim().isEmpty() || especialidad.trim().isEmpty()) {
            return false;
        }

        // Usamos "expresiones regulares" para aplicar reglas mas complejas.
        // Esta regla dice: el nombre solo puede contener letras (mayusculas o minusculas) y espacios.
        if (!Pattern.matches("^[a-zA-Z\\s]+$", nombre)) {
            return false;
        }
        
        // Esta regla dice: el telefono debe contener exactamente 10 digitos numericos.
        if (!Pattern.matches("\\d{10}", telefono)) {
            return false;
        }
        
        // Esta regla verifica que el correo tenga un formato valido (ej. usuario@dominio.com).
        if (!Pattern.matches("^[\\w._%+-]+@[\\w.-]+\\.[A-Za-z]{2,6}$", correo)) {
            return false;
        }
        
        // Finalmente, una validacion de longitud para la especialidad.
        if (especialidad.trim().length() < 5 || especialidad.trim().length() > 100) {
            return false;
        }
        
        // --- FIN DE VALIDACIONES ---

        // Si pasamos todas las validaciones, creamos el objeto Tutor.
        Tutor tutor = new Tutor(nombre, telefono, correo, especialidad);
        
        // Le pasamos el nuevo objeto al DAO para que lo guarde en la base de datos.
        return tutorDAO.create(tutor);
    }

    /**
     * Busca un tutor en la base de datos usando su ID.
     * @param idTutor El ID del tutor que queremos encontrar.
     * @return Devuelve el objeto Tutor si lo encuentra, o 'null' si no existe o el ID es invalido.
     */
    public Tutor read(int idTutor) {
        // Validacion rapida: no tiene sentido buscar un ID de 0 o negativo.
        if (idTutor <= 0) {
            return null; 
        }
        // Le pedimos al DAO que busque al tutor.
        return tutorDAO.read(idTutor);
    }

    /**
     * Actualiza los datos de un tutor que ya existe.
     * Primero se asegura de que el tutor exista y luego aplica las mismas
     * validaciones que el metodo 'create'.
     * @return Devuelve 'true' si la actualizacion fue exitosa, o 'false' en caso contrario.
     */
    public boolean update(int idTutor, String nombre, String telefono, String correo, String especialidad) {
        // Validamos el ID.
        if (idTutor <= 0) {
            return false;
        }
        
        // ¡Importante! Verificamos que el tutor realmente exista antes de intentar actualizarlo.
        if (tutorDAO.read(idTutor) == null) {
            return false;
        }

        // Reutilizamos exactamente las mismas validaciones del metodo 'create'.
        if (nombre == null || telefono == null || correo == null || especialidad == null) {
            return false;
        }
        if (nombre.trim().isEmpty() || telefono.trim().isEmpty() || correo.trim().isEmpty() || especialidad.trim().isEmpty()) {
            return false;
        }
        if (!Pattern.matches("^[a-zA-Z\\s]+$", nombre)) {
            return false;
        }
        if (!Pattern.matches("\\d{10}", telefono)) {
            return false;
        }
        if (!Pattern.matches("^[\\w._%+-]+@[\\w.-]+\\.[A-Za-z]{2,6}$", correo)) {
            return false;
        }
        if (especialidad.trim().length() < 5 || especialidad.trim().length() > 100) {
            return false;
        }
        
        // Si todo es correcto, creamos el objeto Tutor (esta vez con el ID)
        Tutor tutor = new Tutor(idTutor, nombre, telefono, correo, especialidad);
        
        // y se lo pasamos al DAO para que lo actualice.
        return tutorDAO.update(tutor);
    }

    /**
     * Elimina un tutor de la base de datos.
     * @param idTutor El ID del tutor a eliminar.
     * @return Devuelve 'true' si se elimino correctamente, o 'false' si no.
     */
    public boolean delete(int idTutor) {
        // Validamos el ID.
        if (idTutor <= 0) {
            return false;
        }
        
        // Verificamos que el tutor exista antes de intentar borrarlo.
        if (tutorDAO.read(idTutor) == null) {
            return false;
        }
        
        // Si existe, le pedimos al DAO que lo elimine.
        return tutorDAO.delete(idTutor);
    }

    /**
     * Pide al DAO la lista completa de todos los tutores.
     * @return Una lista de objetos Tutor.
     */
    public List<Tutor> readAll() {
        return tutorDAO.readAll();
    }
    
    /**
     * Este es un constructor especial solo para nuestras pruebas.
     * Nos permite "inyectar" o pasarle un DAO falso desde afuera.
     * Asi podemos probar la logica del controlador sin tocar la base de datos.
     */
    public TutorController(ITutorDAO tutorDAO) {
        this.tutorDAO = tutorDAO;
    }
}