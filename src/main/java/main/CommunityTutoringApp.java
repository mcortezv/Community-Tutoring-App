/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package main;
import controllers.*;
import models.*;

import java.util.List;

/**
 *
 * @author Cortez, Manuel;
 */
public class CommunityTutoringApp {
    private static EstudianteController estudianteController;
    private static TutorController tutorController;
    private static MateriaController materiaController;
    private static HorarioController horarioController;
    private static TutoriaController tutoriaController;

    public static void main(String[] args) {
        // Inicializacion de clases control
        estudianteController = new EstudianteController();
        tutorController = new TutorController();
        materiaController = new MateriaController();
        horarioController = new HorarioController();
        tutoriaController = new TutoriaController();

        System.out.println("\n---------- Pruebas ---------- \n");

        // ESTUDIANTES -------------------------------------------------------------------------------------------------
        System.out.println("--- ESTUDIANTES ---");
        estudianteController.createEstudiante("Manuel Cortez", "Secundaria", 15, "5512345678", "Escuela Uno");
        estudianteController.createEstudiante("Sebastian Escalante", "Preparatoria", 17, "5598765432", "Escuela Dos");
        List<Estudiante> estudiantes = estudianteController.readAllEstudiantes();
        for (Estudiante estudiante : estudiantes){
            System.out.println(estudiante);
        }

        System.out.println("\nActualizar estudiante con ID = 1");
        estudianteController.updateEstudiante(1, "Manuel Cortez Modificado", "Secundaria", 16, "5512345678", "Escuela Uno");
        System.out.println(estudianteController.readEstudiante(1));

        System.out.println("\nEliminar estudiante con ID = 2");
        estudianteController.deleteEstudiante(2);
        estudiantes = estudianteController.readAllEstudiantes();
        for (Estudiante estudiante : estudiantes){
            System.out.println(estudiante);
        }

        // TUTORES -----------------------------------------------------------------------------------------------------
        System.out.println("\n--- TUTORES ---");
        tutorController.create("Luis Alonso", "5511122233", "luis@mail.com", "Matematicas");
        tutorController.create("Cristian Devora", "5522233344", "cris@mail.com", "Historia");
        List<Tutor> tutores = tutorController.readAll();
        for (Tutor tutor : tutores){
            System.out.println(tutor);
        }

        System.out.println("\nActualizar tutor con ID = 1");
        tutorController.update(1, "Luis Alonso", "5511122233", "luis@mail.com", "Algebra");
        System.out.println(tutorController.read(1));

        System.out.println("\nEliminar tutor con ID = 2");
        tutorController.delete(2);
        tutores = tutorController.readAll();
        for (Tutor tutor : tutores){
            System.out.println(tutor);
        }

        // MATERIAS ----------------------------------------------------------------------------------------------------
        System.out.println("\n--- MATERIAS ---");
        materiaController.create("Matematicas", "Avanzado", "Algebra y geometria");
        materiaController.create("Historia", "Basico", "Historia universal");
        List<Materia> materias = materiaController.readAll();
        for (Materia materia : materias){
            System.out.println(materia);
        }

        System.out.println("\nActualizar materia con ID = 1");
        materiaController.update(1, "Matematicas II", "Avanzado", "Algebra lineal y geometria analitica");
        System.out.println(materiaController.read(1));

        System.out.println("\nEliminar materia con ID = 2");
        materiaController.delete(2);
        materias = materiaController.readAll();
        for (Materia materia : materias){
            System.out.println(materia);
        }

        // HORARIOS ----------------------------------------------------------------------------------------------------
        System.out.println("\n--- HORARIOS ---");
        Tutor tutor = tutorController.read(1);
        horarioController.create("Lunes", "08:00", "10:00", tutor);
        horarioController.create("Martes", "10:00", "12:00", tutor);
        List<Horario> horarios = horarioController.readAll();
        for (Horario horario : horarios){
            System.out.println(horario);
        }

        System.out.println("\nActualizar horario con ID = 1");
        horarioController.update(1, "Lunes", "09:00", "11:00", tutor);
        System.out.println(horarioController.read(1));

        System.out.println("\nEliminar horario con ID = 2");
        horarioController.delete(2);
        horarios = horarioController.readAll();
        for (Horario horario : horarios){
            System.out.println(horario);
        }

        // TUTORIAS ----------------------------------------------------------------------------------------------------
        System.out.println("\n--- TUTORIAS ---");
        Estudiante est = estudianteController.readEstudiante(1);
        Materia mat = materiaController.read(1);
        tutoriaController.create("2025-09-20", "09:30", "Programada", tutor, est, mat);
        tutoriaController.create("2025-09-21", "11:00", "Programada", tutor, est, mat);
        List<Tutoria> tutorias = tutoriaController.readAll();
        for (Tutoria tutoria : tutorias){
            System.out.println(tutoria);
        }

        System.out.println("\nActualizar tutoría con ID = 1");
        tutoriaController.update(1, "2025-09-20", "10:00", "En curso", tutor, est, mat);
        System.out.println(tutoriaController.read(1));

        System.out.println("\nEliminar tutoria con ID = 2");
        tutoriaController.delete(2);
        tutorias = tutoriaController.readAll();
        for (Tutoria tutoria : tutorias){
            System.out.println(tutoria);
        }
    }

}
