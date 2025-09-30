package ControllerTest;

/**
 *
 * @author alfre
 */

import controllers.HorarioController;
import interfaces.IHorarioDAO;
import models.Horario;
import models.Tutor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.*;

public class HorarioControllerTest {

    private HorarioController horarioController;
    private DAOFalso daoFalso;

    /**
     * Nuestra version falsa del IHorarioDAO para controlar las pruebas.
     */
    class DAOFalso implements IHorarioDAO {
        boolean operacionExitosa = true;
        boolean seLlamoACreate = false;

        @Override
        public boolean create(Horario horario) {
            seLlamoACreate = true;
            System.out.println("-> [DAO Falso] Se llamo a CREATE. Devolviendo: " + operacionExitosa);
            return operacionExitosa;
        }

        // No necesitamos implementar los otros metodos para estos tests
        @Override
        public Horario read(int idHorario) { return null; }
        @Override
        public boolean update(Horario horario) { return true; }
        @Override
        public boolean delete(int idHorario) { return true; }
        @Override
        public java.util.List<Horario> readAll() { return new java.util.ArrayList<>(); }
    }

    @BeforeEach
    void setUp(TestInfo testInfo) {
        System.out.println("\n=======================================================");
        System.out.println("--- Ejecutando Test Simple: " + testInfo.getDisplayName() + " ---");
        System.out.println("=======================================================");
        daoFalso = new DAOFalso();
        horarioController = new HorarioController(daoFalso);
    }

    @Test
    @DisplayName("CREATE: Debe retornar true con datos validos")
    void create_conDatosValidos_debeRetornarTrue() {
        daoFalso.operacionExitosa = true;
        boolean respuestaEsperada = true;
        System.out.println("-> Escenario: Crear un horario con todos los datos correctos.");
        System.out.println("-> Respuesta Esperada: " + respuestaEsperada);

        // Creamos un Tutor falso solo para pasarlo como parametro, sus datos no importan.
        Tutor tutorFalso = new Tutor(); 
        boolean respuestaObtenida = horarioController.create("Lunes", "10:00", "12:00", tutorFalso);

        System.out.println("-> Respuesta Obtenida: " + respuestaObtenida);
        assertEquals(respuestaEsperada, respuestaObtenida);
        assertTrue(daoFalso.seLlamoACreate, "El metodo create del DAO debio ser llamado.");
        System.out.println("-> Resultado: APROBADO.");
    }

    @Test
    @DisplayName("VALIDACION: Debe retornar false si el dia es invalido")
    void create_conDiaInvalido_debeRetornarFalse() {
        boolean respuestaEsperada = false;
        System.out.println("-> Escenario: Crear un horario con un dia que no existe.");
        System.out.println("-> Respuesta Esperada: " + respuestaEsperada);

        Tutor tutorFalso = new Tutor();
        boolean respuestaObtenida = horarioController.create("Sol", "10:00", "12:00", tutorFalso);

        System.out.println("-> Respuesta Obtenida: " + respuestaObtenida);
        assertEquals(respuestaEsperada, respuestaObtenida);
        assertFalse(daoFalso.seLlamoACreate, "El metodo create del DAO NO debio ser llamado.");
        System.out.println("-> Resultado: APROBADO.");
    }

    @Test
    @DisplayName("VALIDACION: Debe retornar false si la hora de inicio es posterior a la de fin")
    void create_conHoraInicioDespuesDeFin_debeRetornarFalse() {
        boolean respuestaEsperada = false;
        System.out.println("-> Escenario: Crear un horario donde la hora de inicio es mas tarde que la de fin.");
        System.out.println("-> Respuesta Esperada: " + respuestaEsperada);

        Tutor tutorFalso = new Tutor();
        boolean respuestaObtenida = horarioController.create("Martes", "14:00", "12:00", tutorFalso);

        System.out.println("-> Respuesta Obtenida: " + respuestaObtenida);
        assertEquals(respuestaEsperada, respuestaObtenida);
        assertFalse(daoFalso.seLlamoACreate, "El metodo create del DAO NO debio ser llamado.");
        System.out.println("-> Resultado: APROBADO.");
    }
}