package ControllerTest;

/**
 *
 * @author alfre
 */

import controllers.MateriaController;
import interfaces.IMateriaDAO;
import models.Materia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.*;

public class MateriaControllerTest {

    private MateriaController materiaController;
    private DAOFalso daoFalso;

    /**
     * Nuestra version falsa del IMateriaDAO para controlar las pruebas.
     */
    class DAOFalso implements IMateriaDAO {
        boolean operacionExitosa = true;
        boolean seLlamoACreate = false;

        @Override
        public boolean create(Materia materia) {
            seLlamoACreate = true;
            System.out.println("-> [DAO Falso] Se llamo a CREATE. Devolviendo: " + operacionExitosa);
            return operacionExitosa;
        }

        // No necesitamos implementar los otros metodos para estos tests
        @Override
        public Materia read(int idMateria) { return null; }
        @Override
        public boolean update(Materia materia) { return true; }
        @Override
        public boolean delete(int idMateria) { return true; }
        @Override
        public java.util.List<Materia> readAll() { return new java.util.ArrayList<>(); }
    }

    @BeforeEach
    void setUp(TestInfo testInfo) {
        System.out.println("\n=======================================================");
        System.out.println("--- Ejecutando Test Simple: " + testInfo.getDisplayName() + " ---");
        System.out.println("=======================================================");
        daoFalso = new DAOFalso();
        materiaController = new MateriaController(daoFalso);
    }

    @Test
    @DisplayName("CREATE: Debe retornar true con datos validos")
    void create_conDatosValidos_debeRetornarTrue() {
        daoFalso.operacionExitosa = true;
        boolean respuestaEsperada = true;
        System.out.println("-> Escenario: Crear una materia con todos los datos correctos.");
        System.out.println("-> Respuesta Esperada: " + respuestaEsperada);

        boolean respuestaObtenida = materiaController.create("Calculo", "Universidad", "Calculo Diferencial");

        System.out.println("-> Respuesta Obtenida: " + respuestaObtenida);
        assertEquals(respuestaEsperada, respuestaObtenida);
        assertTrue(daoFalso.seLlamoACreate, "El metodo create del DAO debio ser llamado.");
        System.out.println("-> Resultado: APROBADO.");
    }

    @Test
    @DisplayName("VALIDACION: Debe retornar false si el nivel es invalido")
    void create_conNivelInvalido_debeRetornarFalse() {
        boolean respuestaEsperada = false;
        System.out.println("-> Escenario: Crear una materia con un nivel educativo no permitido.");
        System.out.println("-> Respuesta Esperada: " + respuestaEsperada);

        boolean respuestaObtenida = materiaController.create("Calculo", "Doctorado", "Materia avanzada");

        System.out.println("-> Respuesta Obtenida: " + respuestaObtenida);
        assertEquals(respuestaEsperada, respuestaObtenida);
        assertFalse(daoFalso.seLlamoACreate, "El metodo create del DAO NO debio ser llamado.");
        System.out.println("-> Resultado: APROBADO.");
    }

    @Test
    @DisplayName("VALIDACION: Debe retornar false si el nombre es muy corto")
    void create_conNombreCorto_debeRetornarFalse() {
        boolean respuestaEsperada = false;
        System.out.println("-> Escenario: Crear una materia con un nombre demasiado corto.");
        System.out.println("-> Respuesta Esperada: " + respuestaEsperada);

        boolean respuestaObtenida = materiaController.create("A", "Universidad", "Descripcion");

        System.out.println("-> Respuesta Obtenida: " + respuestaObtenida);
        assertEquals(respuestaEsperada, respuestaObtenida);
        assertFalse(daoFalso.seLlamoACreate, "El metodo create del DAO NO debio ser llamado.");
        System.out.println("-> Resultado: APROBADO.");
    }
}