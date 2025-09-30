package ControllerTest;

/**
 *
 * @author alfre
 */

import controllers.TutorController;
import interfaces.ITutorDAO;
import models.Tutor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.*;

public class TutorControllerTest {

    private TutorController tutorController;
    private DAOFalso daoFalso;

    /**
     * Nuestra version falsa del ITutorDAO para controlar las pruebas.
     */
    class DAOFalso implements ITutorDAO {
        boolean operacionExitosa = true;
        boolean seLlamoACreate = false;

        @Override
        public boolean create(Tutor tutor) {
            seLlamoACreate = true;
            System.out.println("-> [DAO Falso] Se llamo a CREATE. Devolviendo: " + operacionExitosa);
            return operacionExitosa;
        }

        // No necesitamos implementar los otros metodos para estos tests
        @Override
        public Tutor read(int idTutor) { return null; }
        @Override
        public boolean update(Tutor tutor) { return true; }
        @Override
        public boolean delete(int idTutor) { return true; }
        @Override
        public java.util.List<Tutor> readAll() { return new java.util.ArrayList<>(); }
    }
    
    @BeforeEach
    void setUp(TestInfo testInfo) {
        System.out.println("\n=======================================================");
        System.out.println("--- Ejecutando Test Simple: " + testInfo.getDisplayName() + " ---");
        System.out.println("=======================================================");
        daoFalso = new DAOFalso();
        tutorController = new TutorController(daoFalso);
    }

    @Test
    @DisplayName("CREATE: Debe retornar true con datos validos")
    void create_conDatosValidos_debeRetornarTrue() {
        daoFalso.operacionExitosa = true;
        boolean respuestaEsperada = true;
        System.out.println("-> Escenario: Crear un tutor con todos los datos correctos.");
        System.out.println("-> Respuesta Esperada: " + respuestaEsperada);

        boolean respuestaObtenida = tutorController.create("Luis Alonso", "5512345678", "luis@mail.com", "Matematicas");

        System.out.println("-> Respuesta Obtenida: " + respuestaObtenida);
        assertEquals(respuestaEsperada, respuestaObtenida);
        assertTrue(daoFalso.seLlamoACreate, "El metodo create del DAO debio ser llamado.");
        System.out.println("-> Resultado: APROBADO.");
    }

    @Test
    @DisplayName("VALIDACION: Debe retornar false si el email es invalido")
    void create_conEmailInvalido_debeRetornarFalse() {
        boolean respuestaEsperada = false;
        System.out.println("-> Escenario: Crear un tutor con un formato de email incorrecto.");
        System.out.println("-> Respuesta Esperada: " + respuestaEsperada);

        boolean respuestaObtenida = tutorController.create("Luis Alonso", "5512345678", "luis-mail-com", "Matematicas");

        System.out.println("-> Respuesta Obtenida: " + respuestaObtenida);
        assertEquals(respuestaEsperada, respuestaObtenida);
        assertFalse(daoFalso.seLlamoACreate, "El metodo create del DAO NO debio ser llamado.");
        System.out.println("-> Resultado: APROBADO.");
    }

    @Test
    @DisplayName("VALIDACION: Debe retornar false si el nombre contiene numeros")
    void create_conNombreConNumeros_debeRetornarFalse() {
        boolean respuestaEsperada = false;
        System.out.println("-> Escenario: Crear un tutor con numeros en el nombre.");
        System.out.println("-> Respuesta Esperada: " + respuestaEsperada);

        boolean respuestaObtenida = tutorController.create("Luis Alonso 123", "5512345678", "luis@mail.com", "Matematicas");

        System.out.println("-> Respuesta Obtenida: " + respuestaObtenida);
        assertEquals(respuestaEsperada, respuestaObtenida);
        assertFalse(daoFalso.seLlamoACreate, "El metodo create del DAO NO debio ser llamado.");
        System.out.println("-> Resultado: APROBADO.");
    }
}