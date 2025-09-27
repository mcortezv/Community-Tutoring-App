/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.formsDialog;
import controllers.MainController;
import models.Tutoria;
import view.MainFrame;
import view.styles.Button;
import view.styles.TextField;
import view.styles.Dialog;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Cortez Manuel;
 */
public final class TutoriaFormDialog extends Dialog {
    private JPanel centerPanel;
    private JPanel southPanel;
    private MainFrame mainFrame;
    private TextField idField;
    private TextField fechaField;
    private TextField horaField;
    private TextField estadoField;
    private TextField idTutorField;
    private TextField idEstudianteField;
    private TextField idMateriaField;
    private MainController controller;

    public TutoriaFormDialog(MainFrame owner, MainController controller, int option) {
        super(owner, " ", true);
        setResizable(false);
        mainFrame = owner;
        centerPanel = new JPanel();
        southPanel = new JPanel();
        this.controller = controller;
        switch (option) {
            case 0 -> {
                setTitle("Agregar Tutoria");
                createTutoria();
            }
            case 1 -> {
                setTitle("Buscar Tutoria");
                readTutoria();
            }
            case 2 -> {
                setTitle("Actualizar Tutoria");
                updateTutoria();
            }
            case 3 -> {
                setTitle("Eliminar Tutoria");
                deleteTutoria();
            }
            case 4 -> {
                setTitle("Listar Tutorias");
                readAllTutorias();
            }
            default -> {}
        }
    }

    public void createTutoria() {
        setSize(660, 560);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel fechaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fechaPanel.add(new JLabel("Fecha:        "));
        fechaField = new TextField(20);
        fechaPanel.add(fechaField);
        fechaPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel horaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        horaPanel.add(new JLabel("Hora:               "));
        horaField = new TextField(20);
        horaPanel.add(horaField);
        horaPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel estadoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        estadoPanel.add(new JLabel("Estado:                                "));
        estadoField = new TextField(20);
        estadoPanel.add(estadoField);
        estadoPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel idTutorPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idTutorPanel.add(new JLabel("ID del Tutor:                         "));
        idTutorField = new TextField(20);
        idTutorPanel.add(idTutorField);
        idTutorPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel idEstudiantePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idEstudiantePanel.add(new JLabel("ID del Estudiante:                         "));
        idEstudianteField = new TextField(20);
        idEstudiantePanel.add(idEstudianteField);
        idEstudiantePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel idMateriaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idMateriaPanel.add(new JLabel("ID de la Materia"));
        idMateriaField = new TextField(20);
        idMateriaPanel.add(idMateriaField);
        idMateriaPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        Button btnCreate = new Button("Agregar");
        btnCreate.addActionListener(e -> {
            if (!controller.getTutoriaController().create(fechaField.getText().trim(),
                    horaField.getText().trim(),
                    estadoField.getText().trim(),
                    controller.getTutorController().read(Integer.parseInt(idTutorField.getText().trim())),
                    controller.getEstudianteController().read(Integer.parseInt(idEstudianteField.getText().trim())),
                    controller.getMateriaController().read(Integer.parseInt(idMateriaField.getText().trim())))) {
                JOptionPane.showMessageDialog(centerPanel, "Tutoria agregada con exito");
            }
            dispose();
        });

        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(fechaPanel);
        centerPanel.add(horaPanel);
        centerPanel.add(estadoPanel);
        centerPanel.add(idTutorPanel);
        centerPanel.add(idEstudiantePanel);
        centerPanel.add(idMateriaPanel);
        southPanel.add(btnCreate);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void readTutoria() {
        setSize(400, 200);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idPanel.add(new JLabel("ID de la Tutoria:   "));
        idField = new TextField(12);
        idPanel.add(idField);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        Button btnSearch = new Button("Buscar");
        btnSearch.addActionListener(e -> {
            Tutoria tutoria = controller.getTutoriaController().read(Integer.parseInt(idField.getText().trim()));
            if (tutoria != null) {
                JOptionPane.showMessageDialog(centerPanel, tutoria.toString());
            }
            dispose();
        });

        centerPanel.add(idPanel);
        southPanel.add(btnSearch);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void updateTutoria() {
        setSize(660, 600);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idPanel.add(new JLabel("ID de la Tutoria:   "));
        idField = new TextField(20);
        idPanel.add(idField);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel fechaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fechaPanel.add(new JLabel("Fecha:        "));
        fechaField = new TextField(20);
        fechaPanel.add(fechaField);
        fechaPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel horaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        horaPanel.add(new JLabel("Hora:               "));
        horaField = new TextField(20);
        horaPanel.add(horaField);
        horaPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel estadoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        estadoPanel.add(new JLabel("Estado:                                "));
        estadoField = new TextField(20);
        estadoPanel.add(estadoField);
        estadoPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel idTutorPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idTutorPanel.add(new JLabel("ID del Tutor:                         "));
        idTutorField = new TextField(20);
        idTutorPanel.add(idTutorField);
        idTutorPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel idEstudiantePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idEstudiantePanel.add(new JLabel("ID del Estudiante:                         "));
        idEstudianteField = new TextField(20);
        idEstudiantePanel.add(idEstudianteField);
        idEstudiantePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel idMateriaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idMateriaPanel.add(new JLabel("ID de la Materia"));
        idMateriaField = new TextField(20);
        idMateriaPanel.add(idMateriaField);
        idMateriaPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        Button btnUpdate = new Button("Actualizar");
        btnUpdate.addActionListener(e -> {
            if (!controller.getTutoriaController().update(Integer.parseInt(idField.getText().trim()),
                    fechaField.getText().trim(),
                    horaField.getText().trim(),
                    estadoField.getText().trim(),
                    controller.getTutorController().read(Integer.parseInt(idTutorField.getText().trim())),
                    controller.getEstudianteController().read(Integer.parseInt(idEstudianteField.getText().trim())),
                    controller.getMateriaController().read(Integer.parseInt(idMateriaField.getText().trim())))) {
                JOptionPane.showMessageDialog(centerPanel, "Tutoria actualizada con exito");
            }
            dispose();
        });

        centerPanel.add(idPanel);
        centerPanel.add(fechaPanel);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(horaPanel);
        centerPanel.add(estadoPanel);
        centerPanel.add(idTutorPanel);
        centerPanel.add(idEstudiantePanel);
        centerPanel.add(idMateriaPanel);
        southPanel.add(btnUpdate);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void deleteTutoria() {
        setSize(400, 200);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idPanel.add(new JLabel("ID de la Tutoria:   "));
        idField = new TextField(12);
        idPanel.add(idField);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        Button btnDelete = new Button("Eliminar");
        btnDelete.addActionListener(e -> {
            if (!controller.getTutoriaController().delete(Integer.parseInt(idField.getText().trim()))) {
                JOptionPane.showMessageDialog(centerPanel, "Tutoria eliminada con exito");
            }
            dispose();
        });

        centerPanel.add(idPanel);
        southPanel.add(btnDelete);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void readAllTutorias() {
        controller.getTutoriaController().readAll();
    }
}