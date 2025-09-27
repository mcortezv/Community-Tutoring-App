/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

/**
 *
 * @author Cortez, Manuel;
 */
public class MainController {
    private final EstudianteController estudianteController;
    private final HorarioController horarioController;
    private final MateriaController materiaController;
    private final TutorController tutorController;
    private final TutoriaController tutoriaController;

    public MainController(){
        estudianteController = new EstudianteController();
        horarioController = new HorarioController();
        materiaController = new MateriaController();
        tutorController = new TutorController();
        tutoriaController = new TutoriaController();
    }

    public EstudianteController getEstudianteController() {
        return estudianteController;
    }

    public HorarioController getHorarioController() {
        return horarioController;
    }

    public MateriaController getMateriaController() {
        return materiaController;
    }

    public TutorController getTutorController() {
        return tutorController;
    }

    public TutoriaController getTutoriaController() {
        return tutoriaController;
    }
}
