package ControllerTest;

/**
 *
 * @author alfre
 */

import controllers.EstudianteController;
import interfaces.IEstudianteDAO;
import models.Estudiante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.*;

public class EstudianteControllerTest {

    private EstudianteController estudianteController;
    private DAOFalso daoFalso;

    /**
     * Esta clase interna simula ser un DAO para poder controlar las pruebas.
     */
    class DAOFalso implements IEstudianteDAO {
        // Variables para controlar el comportamiento del DAO Falso
        boolean operacionExitosa = true;
        Estudiante estudianteEncontrado = null;
        boolean seLlamoACreate = false;
        boolean seLlamoARead = false;
        boolean seLlamoAUpdate = false;
        boolean seLlamoADelete = false;

        @Override
        public boolean create(Estudiante estudiante) {
            seLlamoACreate = true;
            System.out.println("-> [DAO Falso] Se llamo a CREATE. Devolviendo: " + operacionExitosa);
            return operacionExitosa;
        }

        @Override
        public Estudiante read(int idEstudiante) {
            seLlamoARead = true;
            System.out.println("-> [DAO Falso] Se llamo a READ. Devolviendo estudiante: " + (estudianteEncontrado != null));
            return estudianteEncontrado;
        }

        @Override
        public boolean update(Estudiante estudiante) {
            seLlamoAUpdate = true;
            System.out.println("-> [DAO Falso] Se llamo a UPDATE. Devolviendo: " + operacionExitosa);
            return operacionExitosa;
        }

        @Override
        public boolean delete(int idEstudiante) {
            seLlamoADelete = true;
            System.out.println("-> [DAO Falso] Se llamo a DELETE. Devolviendo: " + operacionExitosa);
            return operacionExitosa;
        }

        @Override
        public java.util.List<Estudiante> readAll() {
            return new java.util.ArrayList<>();
        }
    }

    @BeforeEach
    void setUp(TestInfo testInfo) {
        System.out.println("\n=======================================================");
        System.out.println("--- Ejecutando Test Simple: " + testInfo.getDisplayName() + " ---");
        System.out.println("=======================================================");
        daoFalso = new DAOFalso();
        estudianteController = new EstudianteController(daoFalso);
    }

    // --- Pruebas para CREATE ---
    @Test
    @DisplayName("CREATE: Debe retornar true con datos validos")
    void create_conDatosValidos_debeRetornarTrue() {
        daoFalso.operacionExitosa = true;
        boolean respuestaEsperada = true;
        System.out.println("-> Escenario: Crear un estudiante con datos validos.");
        System.out.println("-> Respuesta Esperada: " + respuestaEsperada);

        boolean respuestaObtenida = estudianteController.create("Ana", "Prepa", 17, "0987654321", "Escuela B");

        System.out.println("-> Respuesta Obtenida: " + respuestaObtenida);
        assertEquals(respuestaEsperada, respuestaObtenida);
        assertTrue(daoFalso.seLlamoACreate, "El metodo create del DAO debio ser llamado.");
        System.out.println("-> Resultado: APROBADO.");
    }

    @Test
    @DisplayName("CREATE: Debe retornar false si el telefono es invalido")
    void create_conTelefonoInvalido_debeRetornarFalse() {
        boolean respuestaEsperada = false;
        System.out.println("-> Escenario: Crear un estudiante con telefono invalido.");
        System.out.println("-> Respuesta Esperada: " + respuestaEsperada);

        boolean respuestaObtenida = estudianteController.create("Ana", "Prepa", 17, "123", "Escuela B");

        System.out.println("-> Respuesta Obtenida: " + respuestaObtenida);
        assertEquals(respuestaEsperada, respuestaObtenida);
        assertFalse(daoFalso.seLlamoACreate, "El metodo create del DAO NO debio ser llamado.");
        System.out.println("-> Resultado: APROBADO.");
    }

    // --- Pruebas para READ ---
    @Test
    @DisplayName("READ: Debe retornar un estudiante si el ID existe")
    void read_conIdExistente_debeRetornarEstudiante() {
        daoFalso.estudianteEncontrado = new Estudiante(1, "Juan", "Secundaria", 15, "1234567890", "Escuela A");
        String respuestaEsperada = "Estudiante encontrado";
        System.out.println("-> Escenario: Buscar un estudiante que si existe.");
        System.out.println("-> Respuesta Esperada: " + respuestaEsperada);

        Estudiante estudianteObtenido = estudianteController.read(1);

        String respuestaObtenida = estudianteObtenido != null ? "Estudiante encontrado" : "null";
        System.out.println("-> Respuesta Obtenida: " + respuestaObtenida);
        assertEquals(respuestaEsperada, respuestaObtenida);
        assertTrue(daoFalso.seLlamoARead, "El metodo read del DAO debio ser llamado.");
        System.out.println("-> Resultado: APROBADO.");
    }

    @Test
    @DisplayName("READ: Debe retornar null si el ID es invalido (cero)")
    void read_conIdInvalido_debeRetornarNull() {
        String respuestaEsperada = "null";
        System.out.println("-> Escenario: Buscar un estudiante con ID invalido (0).");
        System.out.println("-> Respuesta Esperada: " + respuestaEsperada);

        Estudiante estudianteObtenido = estudianteController.read(0);

        String respuestaObtenida = estudianteObtenido == null ? "null" : "Estudiante encontrado";
        System.out.println("-> Respuesta Obtenida: " + respuestaObtenida);
        assertEquals(respuestaEsperada, respuestaObtenida);
        assertFalse(daoFalso.seLlamoARead, "El metodo read del DAO NO debio ser llamado.");
        System.out.println("-> Resultado: APROBADO.");
    }
    
    // --- Pruebas para UPDATE ---
    @Test
    @DisplayName("UPDATE: Debe retornar true si el estudiante existe y los datos son validos")
    void update_conEstudianteExistenteYDatosValidos_debeRetornarTrue() {
        daoFalso.estudianteEncontrado = new Estudiante(); // Simulamos que el estudiante existe
        daoFalso.operacionExitosa = true;
        boolean respuestaEsperada = true;
        System.out.println("-> Escenario: Actualizar un estudiante existente con datos validos.");
        System.out.println("-> Respuesta Esperada: " + respuestaEsperada);

        boolean respuestaObtenida = estudianteController.update(1, "Nombre Nuevo", "Prepa", 18, "1112223333", "Escuela C");
        
        System.out.println("-> Respuesta Obtenida: " + respuestaObtenida);
        assertEquals(respuestaEsperada, respuestaObtenida);
        assertTrue(daoFalso.seLlamoARead, "El metodo read del DAO debio ser llamado para verificar.");
        assertTrue(daoFalso.seLlamoAUpdate, "El metodo update del DAO debio ser llamado.");
        System.out.println("-> Resultado: APROBADO.");
    }

    @Test
    @DisplayName("UPDATE: Debe retornar false si el estudiante NO existe")
    void update_conEstudianteInexistente_debeRetornarFalse() {
        daoFalso.estudianteEncontrado = null; // Simulamos que el estudiante NO existe
        boolean respuestaEsperada = false;
        System.out.println("-> Escenario: Intentar actualizar un estudiante que no existe.");
        System.out.println("-> Respuesta Esperada: " + respuestaEsperada);

        boolean respuestaObtenida = estudianteController.update(99, "Nombre Nuevo", "Prepa", 18, "1112223333", "Escuela C");

        System.out.println("-> Respuesta Obtenida: " + respuestaObtenida);
        assertEquals(respuestaEsperada, respuestaObtenida);
        assertTrue(daoFalso.seLlamoARead, "El metodo read del DAO debio ser llamado para verificar.");
        assertFalse(daoFalso.seLlamoAUpdate, "El metodo update del DAO NO debio ser llamado.");
        System.out.println("-> Resultado: APROBADO.");
    }
    
    // --- Pruebas para DELETE ---
    @Test
    @DisplayName("DELETE: Debe retornar true si el estudiante existe")
    void delete_conEstudianteExistente_debeRetornarTrue() {
        daoFalso.estudianteEncontrado = new Estudiante(); // Simulamos que el estudiante existe
        daoFalso.operacionExitosa = true;
        boolean respuestaEsperada = true;
        System.out.println("-> Escenario: Eliminar un estudiante que si existe.");
        System.out.println("-> Respuesta Esperada: " + respuestaEsperada);

        boolean respuestaObtenida = estudianteController.delete(1);

        System.out.println("-> Respuesta Obtenida: " + respuestaObtenida);
        assertEquals(respuestaEsperada, respuestaObtenida);
        assertTrue(daoFalso.seLlamoARead, "El metodo read del DAO debio ser llamado para verificar.");
        assertTrue(daoFalso.seLlamoADelete, "El metodo delete del DAO debio ser llamado.");
        System.out.println("-> Resultado: APROBADO.");
    }

    @Test
    @DisplayName("DELETE: Debe retornar false si el estudiante NO existe")
    void delete_conEstudianteInexistente_debeRetornarFalse() {
        daoFalso.estudianteEncontrado = null; // Simulamos que el estudiante NO existe
        boolean respuestaEsperada = false;
        System.out.println("-> Escenario: Intentar eliminar un estudiante que no existe.");
        System.out.println("-> Respuesta Esperada: " + respuestaEsperada);

        boolean respuestaObtenida = estudianteController.delete(99);

        System.out.println("-> Respuesta Obtenida: " + respuestaObtenida);
        assertEquals(respuestaEsperada, respuestaObtenida);
        assertTrue(daoFalso.seLlamoARead, "El metodo read del DAO debio ser llamado para verificar.");
        assertFalse(daoFalso.seLlamoADelete, "El metodo delete del DAO NO debio ser llamado.");
        System.out.println("-> Resultado: APROBADO.");
    }
}