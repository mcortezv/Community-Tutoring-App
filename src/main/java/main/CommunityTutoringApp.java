package main;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
import controllers.*;
import models.*;
import java.util.List;

public class CommunityTutoringApp {
    private static EstudianteController estudianteController;
    private static TutorController tutorController;
    private static MateriaController materiaController;
    private static HorarioController horarioController;
    private static TutoriaController tutoriaController;

    public static void main(String[] args) {
        // Inicializacion de clases de control
        estudianteController = new EstudianteController();
        tutorController = new TutorController();
        materiaController = new MateriaController();
        horarioController = new HorarioController();
        tutoriaController = new TutoriaController();

        System.out.println("\n---------- Pruebas de Consola ---------- \n");

        // --- ESTUDIANTES ---
        System.out.println("--- ESTUDIANTES ---");
        System.out.println("\nCreando estudiantes...");
        estudianteController.create("Manuel Cortez", "Secundaria", 15, "5512345678", "Escuela Uno");
        estudianteController.create("Sebastian Escalante", "Preparatoria", 17, "5598765432", "Escuela Dos");
        estudianteController.create("Ana Garcia", "Universidad", 20, "5555550000", "Universidad Central");
        estudianteController.create("Sofia Lopez", "Primaria", 10, "5511112222", "Escuela Tres");

        List<Estudiante> estudiantes = estudianteController.readAll();
        estudiantes.forEach(System.out::println);

        System.out.println("\nActualizando estudiante con ID = 1...");
        estudianteController.update(1, "Manuel Cortez", "Secundaria", 16, "5512345678", "Escuela Nacional Uno");
        System.out.println(estudianteController.read(1));

        System.out.println("\nEliminando estudiante con ID = 2...");
        estudianteController.delete(2);
        estudiantes = estudianteController.readAll();
        estudiantes.forEach(System.out::println);

        // --- TUTORES ---
        System.out.println("\n--- TUTORES ---");
        System.out.println("\nCreando tutores...");
        tutorController.create("Luis Alonso", "5511122233", "luis@mail.com", "Matematicas");
        tutorController.create("Cristian Devora", "5522233344", "cris@mail.com", "Historia");
        tutorController.create("Laura Torres", "5533344455", "laura@mail.com", "Ciencias");
        tutorController.create("Carlos Mendoza", "5544455566", "carlos@mail.com", "Fisica");
        
        List<Tutor> tutores = tutorController.readAll();
        tutores.forEach(System.out::println);

        System.out.println("\nActualizando tutor con ID = 1...");
        tutorController.update(1, "Luis Alonso", "5511122233", "luis.alonso@mail.com", "Algebra y Calculo");
        System.out.println(tutorController.read(1));
        
        System.out.println("\nEliminando tutor con ID = 2...");
        tutorController.delete(2);
        tutores = tutorController.readAll();
        tutores.forEach(System.out::println);

        // --- MATERIAS ---
        System.out.println("\n--- MATERIAS ---");
        System.out.println("\nCreando materias...");
        materiaController.create("Calculo", "Universidad", "Calculo diferencial e integral");
        materiaController.create("Historia de Mexico", "Preparatoria", "Historia de la nacion mexicana");
        materiaController.create("Biologia", "Secundaria", "Conceptos basicos de biologia celular");
        materiaController.create("Fisica I", "Preparatoria", "Mecanica clasica y cinematica");
        
        List<Materia> materias = materiaController.readAll();
        materias.forEach(System.out::println);
        
        System.out.println("\nActualizando materia con ID = 1...");
        materiaController.update(1, "Calculo Avanzado", "Universidad", "Calculo diferencial, integral y multivariable");
        System.out.println(materiaController.read(1));
        
        System.out.println("\nEliminando materia con ID = 2...");
        materiaController.delete(2);
        materias = materiaController.readAll();
        materias.forEach(System.out::println);
        
        // --- HORARIOS ---
        System.out.println("\n--- HORARIOS ---");
        System.out.println("\nCreando horarios...");
        Tutor tutorParaHorario1 = tutorController.read(1); // Luis A. Alonso
        Tutor tutorParaHorario2 = tutorController.read(3); // Laura Torres

        if (tutorParaHorario1 != null) {
            horarioController.create("Lunes", "08:00", "10:00", tutorParaHorario1);
            horarioController.create("Miercoles", "08:00", "10:00", tutorParaHorario1);
        }
        if (tutorParaHorario2 != null) {
            horarioController.create("Martes", "14:00", "16:00", tutorParaHorario2);
            horarioController.create("Jueves", "14:00", "16:00", tutorParaHorario2);
        }
        
        List<Horario> horarios = horarioController.readAll();
        horarios.forEach(System.out::println);
        
        System.out.println("\nActualizando horario con ID = 1...");
        horarioController.update(1, "Lunes", "09:00", "11:00", tutorParaHorario1);
        System.out.println(horarioController.read(1));
        
        System.out.println("\nEliminando horario con ID = 2...");
        horarioController.delete(2);
        horarios = horarioController.readAll();
        horarios.forEach(System.out::println);
        
        // --- TUTORIAS ---
        System.out.println("\n--- TUTORIAS ---");
        System.out.println("\nCreando tutorias...");
        
        // Obteniendo objetos para crear tutorias. Nos aseguramos de que no sean nulos.
        Tutor tutorParaTutoria = tutorController.read(3); // Laura Torres
        Estudiante estudianteParaTutoria1 = estudianteController.read(3); // Ana Garcia
        Estudiante estudianteParaTutoria2 = estudianteController.read(4); // Sofia Lopez
        Materia materiaParaTutoria = materiaController.read(3); // Biologia

        if (tutorParaTutoria != null && estudianteParaTutoria1 != null && materiaParaTutoria != null) {
            tutoriaController.create("2025-10-01", "15:00", "Programada", tutorParaTutoria, estudianteParaTutoria1, materiaParaTutoria);
        }
        if (tutorParaTutoria != null && estudianteParaTutoria2 != null && materiaParaTutoria != null) {
            tutoriaController.create("2025-10-02", "15:00", "Programada", tutorParaTutoria, estudianteParaTutoria2, materiaParaTutoria);
        }
        
        // Ejemplo adicional con otro tutor y materia
        Tutor tutorAdicional = tutorController.read(4); // Carlos Mendoza
        Materia materiaAdicional = materiaController.read(4); // Fisica I
        if (tutorAdicional != null && estudianteParaTutoria1 != null && materiaAdicional != null) {
            tutoriaController.create("2025-11-05", "12:00", "Programada", tutorAdicional, estudianteParaTutoria1, materiaAdicional);
        }
        
        List<Tutoria> tutorias = tutoriaController.readAll();
        tutorias.forEach(System.out::println);
        
        System.out.println("\nActualizando tutoria con ID = 1...");
        tutoriaController.update(1, "2025-10-01", "15:00", "En curso", tutorParaTutoria, estudianteParaTutoria1, materiaParaTutoria);
        System.out.println(tutoriaController.read(1));
        
        System.out.println("\nEliminando tutoria con ID = 2...");
        tutoriaController.delete(2);
        tutorias = tutoriaController.readAll();
        tutorias.forEach(System.out::println);
    }
}