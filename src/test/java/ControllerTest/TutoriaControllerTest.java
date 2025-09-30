package ControllerTest;

/**
 *
 * @author alfre
 */

import controllers.TutoriaController;
import interfaces.ITutoriaDAO;
import models.Estudiante;
import models.Materia;
import models.Tutor;
import models.Tutoria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.*;

public class TutoriaControllerTest {

    private TutoriaController tutoriaController;
    private DAOFalso daoFalso;

    /**
     * Nuestra version falsa del ITutoriaDAO.
     */
    class DAOFalso implements ITutoriaDAO {
        boolean operacionExitosa = true;
        boolean seLlamoACreate = false;

        @Override
        public boolean create(Tutoria tutoria) {
            seLlamoACreate = true;
            System.out.println("-> [DAO Falso] Se llamo a CREATE. Devolviendo: " + operacionExitosa);
            return operacionExitosa;
        }

        // No implementamos los otros metodos para simplificar
        @Override
        public Tutoria read(int idTutoria) { return null; }
        @Override
        public boolean update(Tutoria tutoria) { return true; }
        @Override
        public boolean delete(int idTutoria) { return true; }
        @Override
        public java.util.List<Tutoria> readAll() { return new java.util.ArrayList<>(); }
    }

    @BeforeEach
    void setUp(TestInfo testInfo) {
        System.out.println("\n=======================================================");
        System.out.println("--- Ejecutando Test Simple: " + testInfo.getDisplayName() + " ---");
        System.out.println("=======================================================");
        daoFalso = new DAOFalso();
        tutoriaController = new TutoriaController(daoFalso);
    }

    @Test
    @DisplayName("CREATE: Debe retornar true con datos validos")
    void create_conDatosValidos_debeRetornarTrue() {
        daoFalso.operacionExitosa = true;
        boolean respuestaEsperada = true;
        System.out.println("-> Escenario: Crear una tutoria con todos los datos correctos.");
        System.out.println("-> Respuesta Esperada: " + respuestaEsperada);

        // Creamos objetos falsos para pasar como argumentos
        Tutor tutor = new Tutor();
        Estudiante estudiante = new Estudiante();
        Materia materia = new Materia();

        boolean respuestaObtenida = tutoriaController.create("2025-10-20", "10:00", "Programada", tutor, estudiante, materia);

        System.out.println("-> Respuesta Obtenida: " + respuestaObtenida);
        assertEquals(respuestaEsperada, respuestaObtenida);
        assertTrue(daoFalso.seLlamoACreate, "El metodo create del DAO debio ser llamado.");
        System.out.println("-> Resultado: APROBADO.");
    }

    @Test
    @DisplayName("VALIDACION: Debe retornar false si el formato de fecha es invalido")
    void create_conFechaInvalida_debeRetornarFalse() {
        boolean respuestaEsperada = false;
        System.out.println("-> Escenario: Crear una tutoria con un formato de fecha incorrecto.");
        System.out.println("-> Respuesta Esperada: " + respuestaEsperada);
        
        Tutor tutor = new Tutor();
        Estudiante estudiante = new Estudiante();
        Materia materia = new Materia();

        boolean respuestaObtenida = tutoriaController.create("20-10-2025", "10:00", "Programada", tutor, estudiante, materia);

        System.out.println("-> Respuesta Obtenida: " + respuestaObtenida);
        assertEquals(respuestaEsperada, respuestaObtenida);
        assertFalse(daoFalso.seLlamoACreate, "El metodo create del DAO NO debio ser llamado.");
        System.out.println("-> Resultado: APROBADO.");
    }
    
    @Test
    @DisplayName("VALIDACION: Debe retornar false si el estado es invalido")
    void create_conEstadoInvalido_debeRetornarFalse() {
        boolean respuestaEsperada = false;
        System.out.println("-> Escenario: Crear una tutoria con un estado que no existe.");
        System.out.println("-> Respuesta Esperada: " + respuestaEsperada);
        
        Tutor tutor = new Tutor();
        Estudiante estudiante = new Estudiante();
        Materia materia = new Materia();

        boolean respuestaObtenida = tutoriaController.create("2025-10-20", "10:00", "Pospuesta", tutor, estudiante, materia);

        System.out.println("-> Respuesta Obtenida: " + respuestaObtenida);
        assertEquals(respuestaEsperada, respuestaObtenida);
        assertFalse(daoFalso.seLlamoACreate, "El metodo create del DAO NO debio ser llamado.");
        System.out.println("-> Resultado: APROBADO.");
    }
}