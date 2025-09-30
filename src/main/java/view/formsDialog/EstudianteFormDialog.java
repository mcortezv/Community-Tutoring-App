/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.formsDialog;
import controllers.EstudianteController;
import controllers.MainController;
import models.Estudiante;
import view.MainFrame;
import view.styles.Button;
import view.styles.Style;
import view.styles.TextField;
import view.styles.Dialog;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Cortez Manuel;
 */
public final class EstudianteFormDialog extends Dialog {
    private JPanel centerPanel;
    private JPanel southPanel;
    private MainFrame mainFrame;
    private TextField idField;
    private TextField nombreField;
    private JComboBox gradoEscolarCombo;
    private TextField edadField;
    private TextField telefonoField;
    private TextField escuelaField;
    private EstudianteController controller;

    public EstudianteFormDialog(MainFrame owner, MainController controller, int option) {
        super(owner, " ", true);
        setResizable(false);
        mainFrame = owner;
        centerPanel = new JPanel();
        southPanel = new JPanel();
        this.controller = controller.getEstudianteController();
        switch (option) {
            case 0 -> {
                setTitle("Agregar Estudiante");
                createEstudiante();
            }
            case 1 -> {
                setTitle("Buscar Estudiante");
                readEstudiante();
            }
            case 2 -> {
                setTitle("Actualizar Estudiante");
                updateEstudiante();
            }
            case 3 -> {
                setTitle("Eliminar Estudiante");
                deleteEstudiante();
            }
            default -> {}
        }
    }

    public void createEstudiante() {
        setSize(500, 480);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel nombrePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        nombrePanel.add(new JLabel("Nombre Completo:        "));
        nombreField = new TextField(20);
        nombrePanel.add(nombreField);
        nombrePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel gradoEscolarPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        gradoEscolarPanel.add(new JLabel("Grado Escolar:                        "));
        gradoEscolarCombo = new JComboBox();
        gradoEscolarCombo.setBackground(Style.INPUT_COLOR);
        gradoEscolarCombo.setForeground(Color.WHITE);
        gradoEscolarCombo.addItem("General");
        gradoEscolarCombo.addItem("Primaria");
        gradoEscolarCombo.addItem("Secundaria");
        gradoEscolarCombo.addItem("Preparatoria");
        gradoEscolarCombo.addItem("Universidad");
        gradoEscolarPanel.add(gradoEscolarCombo);
        gradoEscolarPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel edadPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        edadPanel.add(new JLabel("Edad:                                "));
        edadField = new TextField(20);
        edadPanel.add(edadField);
        edadPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel telefonoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        telefonoPanel.add(new JLabel("Telefono:                         "));
        telefonoField = new TextField(20);
        telefonoPanel.add(telefonoField);
        telefonoPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel escuelaPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        escuelaPanel.add(new JLabel("Escuela Procedencia:  "));
        escuelaField = new TextField(20);
        escuelaPanel.add(escuelaField);
        escuelaPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        Button btnCreate = new Button("Agregar");
        btnCreate.addActionListener(e -> {
            try {
                if (controller.create(nombreField.getText().trim(),
                        (String) gradoEscolarCombo.getSelectedItem(),
                        Integer.parseInt(edadField.getText().trim()),
                        telefonoField.getText().trim(),
                        escuelaField.getText().trim())) {
                    JOptionPane.showMessageDialog(centerPanel, "Estudiante agregado con exito");
                } else {
                    JOptionPane.showMessageDialog(centerPanel, "El Estudiante no se pudo agregar");
                }
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(centerPanel, "Todos los campos son obligatorios");
            }
        });

        centerPanel.add(nombrePanel);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(gradoEscolarPanel);
        centerPanel.add(edadPanel);
        centerPanel.add(telefonoPanel);
        centerPanel.add(escuelaPanel);
        southPanel.add(btnCreate);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void readEstudiante() {
        setSize(400, 200);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        idPanel.add(new JLabel("Matricula del Estudiante:   "));
        idField = new TextField(12);
        idPanel.add(idField);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        Button btnSearch = new Button("Buscar");
        btnSearch.addActionListener(e -> {
            try {
                Estudiante estudiante = controller.read(Integer.parseInt(idField.getText().trim()));
                if (estudiante != null) {
                    JOptionPane.showMessageDialog(centerPanel, estudiante.toString());
                } else {
                    JOptionPane.showMessageDialog(centerPanel, "Estudiante no encontrado");
                }
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(centerPanel, "Todos los campos son obligatorios");
            }
        });

        centerPanel.add(idPanel);
        southPanel.add(btnSearch);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void updateEstudiante() {
        setSize(500, 520);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        idPanel.add(new JLabel("Matricula Estudiante:   "));
        idField = new TextField(20);
        idPanel.add(idField);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel nombrePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        nombrePanel.add(new JLabel("Nombre Completo:        "));
        nombreField = new TextField(20);
        nombrePanel.add(nombreField);
        nombrePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel gradoEscolarPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        gradoEscolarPanel.add(new JLabel("Grado Escolar:               "));
        gradoEscolarCombo = new JComboBox();
        gradoEscolarCombo.setBackground(Style.INPUT_COLOR);
        gradoEscolarCombo.setForeground(Color.WHITE);
        gradoEscolarCombo.addItem("General");
        gradoEscolarCombo.addItem("Primaria");
        gradoEscolarCombo.addItem("Secundaria");
        gradoEscolarCombo.addItem("Preparatoria");
        gradoEscolarCombo.addItem("Universidad");
        gradoEscolarPanel.add(gradoEscolarCombo);
        gradoEscolarPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel edadPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        edadPanel.add(new JLabel("Edad:                                "));
        edadField = new TextField(20);
        edadPanel.add(edadField);
        edadPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel telefonoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        telefonoPanel.add(new JLabel("Telefono:                         "));
        telefonoField = new TextField(20);
        telefonoPanel.add(telefonoField);
        telefonoPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel escuelaPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        escuelaPanel.add(new JLabel("Escuela Procedencia:  "));
        escuelaField = new TextField(20);
        escuelaPanel.add(escuelaField);
        escuelaPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        Button btnUpdate = new Button("Actualizar");
        btnUpdate.addActionListener(e -> {
            try {
                if (controller.update(Integer.parseInt(idField.getText().trim()),
                        nombreField.getText().trim(),
                        (String) gradoEscolarCombo.getSelectedItem(),
                        Integer.parseInt(edadField.getText().trim()),
                        telefonoField.getText().trim(),
                        escuelaField.getText().trim())) {
                    JOptionPane.showMessageDialog(centerPanel, "Estudiante actualizado con exito");
                } else {
                    JOptionPane.showMessageDialog(centerPanel, "El Estudiante no se pudo actualizar");
                }
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(centerPanel, "Todos los campos son obligatorios");
            }
        });

        centerPanel.add(idPanel);
        centerPanel.add(nombrePanel);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(gradoEscolarPanel);
        centerPanel.add(edadPanel);
        centerPanel.add(telefonoPanel);
        centerPanel.add(escuelaPanel);
        southPanel.add(btnUpdate);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void deleteEstudiante() {
        setSize(400, 200);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        idPanel.add(new JLabel("Matricula del Estudiante:   "));
        idField = new TextField(12);
        idPanel.add(idField);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        Button btnDelete = new Button("Eliminar");
        btnDelete.addActionListener(e -> {
            try {
                if (controller.delete(Integer.parseInt(idField.getText().trim()))) {
                    JOptionPane.showMessageDialog(centerPanel, "Estudiante eliminado con exito");
                } else {
                    JOptionPane.showMessageDialog(centerPanel, "El Estudiante no se pudo eliminar");
                }
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(centerPanel, "Todos los campos son obligatorios");
            }
        });

        centerPanel.add(idPanel);
        southPanel.add(btnDelete);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }
}
