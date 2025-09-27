/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import controllers.*;
import view.styles.Button;
import view.styles.Style;
import java.awt.*;
import javax.swing.*;
import view.panels.*;

/**
 *
 * @author Cortez, Manuel;
 */
public final class MainFrame extends JFrame {
    private JMenuBar menuBar;
    private Button btnEstudiantes;
    private Button btnTutores;
    private Button btnHorarios;
    private Button btnMaterias;
    private Button btnTutorias;
    private Button btnInUse;
    private MainPanel mainPanel;
    private JPanel centralPanel;
    private NorthPanel northPanel;
    private EstudiantePanel estudiantePanel;
    private TutorPanel tutorPanel;
    private HorarioPanel horarioPanel;
    private MateriaPanel materiaPanel;
    private TutoriaPanel tutoriaPanel;
    private final EstudianteController estudianteController;
    private final HorarioController horarioController;
    private final MateriaController materiaController;
    private final TutorController tutorController;
    private final TutoriaController tutoriaController;

    public MainFrame() {
        this.estudianteController = new EstudianteController();
        this.horarioController = new HorarioController();
        this.materiaController = new MateriaController();
        this.tutorController = new TutorController();
        this.tutoriaController = new TutoriaController();
        startComponents();
        setTitle("Tutorias Comunitarias");
        setSize(1280, 720);
        setJMenuBar(menuBar);
        add(centralPanel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void startComponents() {
        menuBar = new JMenuBar();
        btnEstudiantes = new Button("Estudiantes");
        btnTutores = new Button("Tutores");
        btnHorarios = new Button("Horarios");
        btnMaterias = new Button("Materias");
        btnTutorias = new Button("Tutorias");

        mainPanel = new MainPanel();

        northPanel = new NorthPanel();

        centralPanel = new JPanel();
        centralPanel.add(mainPanel);
        centralPanel.setBackground(Style.PANEL_COLOR);
        add(centralPanel, BorderLayout.CENTER);

        estudiantePanel = new EstudiantePanel(this, northPanel, estudianteController);
        tutorPanel = new TutorPanel(this, northPanel, tutorController);
        horarioPanel = new HorarioPanel(this, northPanel , horarioController);
        materiaPanel = new MateriaPanel(this, northPanel , materiaController);
        tutoriaPanel = new TutoriaPanel(this, northPanel, tutoriaController);

        add(northPanel, BorderLayout.NORTH);
        northPanel.add(btnEstudiantes);
        northPanel.add(btnTutores);
        northPanel.add(btnHorarios);
        northPanel.add(btnMaterias);
        northPanel.add(btnTutorias);

        btnEstudiantes.setPreferredSize(new Dimension(170, 40));
        btnTutores.setPreferredSize(new Dimension(170, 40));
        btnHorarios.setPreferredSize(new Dimension(170, 40));
        btnMaterias.setPreferredSize(new Dimension(170, 40));
        btnTutorias.setPreferredSize(new Dimension(170, 40));
        btnEstudiantes.addActionListener(e -> showPanel(estudiantePanel));
        btnEstudiantes.addActionListener(e -> {
            btnInUse = btnEstudiantes;
            northPanel.setInUseButton(btnInUse);
        });
        btnTutores.addActionListener(e -> showPanel(tutorPanel));
        btnTutores.addActionListener(e -> {
            btnInUse = btnTutores;
            northPanel.setInUseButton(btnInUse);
        });
        btnHorarios.addActionListener(e -> showPanel(horarioPanel));
        btnHorarios.addActionListener(e -> {
            btnInUse = btnHorarios;
            northPanel.setInUseButton(btnInUse);
        });
        btnMaterias.addActionListener(e -> showPanel(materiaPanel));
        btnMaterias.addActionListener(e -> {
            btnInUse = btnMaterias;
            northPanel.setInUseButton(btnInUse);
        });
        btnTutorias.addActionListener(e -> showPanel(tutoriaPanel));
        btnTutorias.addActionListener(e -> {
            btnInUse = btnTutorias;
            northPanel.setInUseButton(btnInUse);
        });

    }

    private void showPanel(JPanel nuevoPanel) {
        centralPanel.removeAll();
        centralPanel.add(nuevoPanel, BorderLayout.CENTER);
        centralPanel.revalidate();
        centralPanel.repaint();
    }

    public void showMainPanel() {
        showPanel(mainPanel);
    }

    public MainPanel getMainPanel(){
        return mainPanel;
    }

}
