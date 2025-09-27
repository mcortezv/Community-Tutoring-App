/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.formsDialog;
import controllers.TutorController;
import models.Tutor;
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
public final class TutorFormDialog extends Dialog {
    private JPanel centerPanel;
    private JPanel southPanel;
    private MainFrame mainFrame;
    private TextField idField;
    private TextField nombreField;
    private TextField telefonoField;
    private TextField correoField;
    private TextField especialidadField;
    private TutorController controller;

    public TutorFormDialog(MainFrame owner, TutorController controller, int option) {
        super(owner, " ", true);
        setResizable(false);
        mainFrame = owner;
        centerPanel = new JPanel();
        southPanel = new JPanel();
        this.controller = controller;
        switch (option) {
            case 0 -> {
                setTitle("Agregar Tutor");
                createTutor();
            }
            case 1 -> {
                setTitle("Buscar Tutor");
                readTutor();
            }
            case 2 -> {
                setTitle("Actualizar Tutor");
                updateTutor();
            }
            case 3 -> {
                setTitle("Eliminar Tutor");
                deleteTutor();
            }
            case 4 -> {
                setTitle("Listar Tutor");
                readAllTutores();
            }
            default -> {}
        }
    }

    public void createTutor() {
        setSize(660, 460);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel nombrePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        nombrePanel.add(new JLabel("Nombre Completo:        "));
        nombreField = new TextField(20);
        nombrePanel.add(nombreField);
        nombrePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel telefonoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        telefonoPanel.add(new JLabel("Telefono:                         "));
        telefonoField = new TextField(20);
        telefonoPanel.add(telefonoField);
        telefonoPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel correoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        correoPanel.add(new JLabel("Correo:                                "));
        correoField = new TextField(20);
        correoPanel.add(correoField);
        correoPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel especialidadPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        especialidadPanel.add(new JLabel("Especialidad:  "));
        especialidadField = new TextField(20);
        especialidadPanel.add(especialidadField);
        especialidadPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        Button btnCreate = new Button("Agregar");
        btnCreate.addActionListener(e -> {
            if (!controller.create(nombreField.getText().trim(),
                    telefonoField.getText().trim(),
                    correoField.getText().trim(),
                    especialidadField.getText().trim())) {
                JOptionPane.showMessageDialog(centerPanel, "Tutor agregado con exito");
            }
            dispose();
        });

        centerPanel.add(nombrePanel);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(telefonoPanel);
        centerPanel.add(correoPanel);
        centerPanel.add(especialidadPanel);
        southPanel.add(btnCreate);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void readTutor() {
        setSize(400, 200);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idPanel.add(new JLabel("ID del Tutor:   "));
        idField = new TextField(12);
        idPanel.add(idField);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        Button btnSearch = new Button("Buscar");
        btnSearch.addActionListener(e -> {
            Tutor tutor = controller.read(Integer.parseInt(idField.getText().trim()));
            if (tutor != null) {
                JOptionPane.showMessageDialog(centerPanel, tutor.toString());
            }
            dispose();
        });

        centerPanel.add(idPanel);
        southPanel.add(btnSearch);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void updateTutor() {
        setSize(660, 460);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idPanel.add(new JLabel("ID del Tutor:   "));
        idField = new TextField(20);
        idPanel.add(idField);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel nombrePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        nombrePanel.add(new JLabel("Nombre Completo:        "));
        nombreField = new TextField(20);
        nombrePanel.add(nombreField);
        nombrePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel telefonoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        telefonoPanel.add(new JLabel("Telefono:                         "));
        telefonoField = new TextField(20);
        telefonoPanel.add(telefonoField);
        telefonoPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel correoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        correoPanel.add(new JLabel("Correo:                                "));
        correoField = new TextField(20);
        correoPanel.add(correoField);
        correoPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel especialidadPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        especialidadPanel.add(new JLabel("Especialidad:  "));
        especialidadField = new TextField(20);
        especialidadPanel.add(especialidadField);
        especialidadPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        Button btnUpdate = new Button("Actualizar");
        btnUpdate.addActionListener(e -> {
            if (!controller.update(Integer.parseInt(idField.getText().trim()),
                    nombreField.getText().trim(),
                    telefonoField.getText().trim(),
                    correoField.getText().trim(),
                    especialidadField.getText().trim())) {
                JOptionPane.showMessageDialog(centerPanel, "Tutor actualizado con exito");
            }
            dispose();
        });

        centerPanel.add(idPanel);
        centerPanel.add(nombrePanel);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(telefonoPanel);
        centerPanel.add(correoPanel);
        centerPanel.add(especialidadPanel);
        southPanel.add(btnUpdate);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void deleteTutor() {
        setSize(400, 200);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idPanel.add(new JLabel("ID del Tutor:   "));
        idField = new TextField(12);
        idPanel.add(idField);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        Button btnDelete = new Button("Eliminar");
        btnDelete.addActionListener(e -> {
            if (!controller.delete(Integer.parseInt(idField.getText().trim()))) {
                JOptionPane.showMessageDialog(centerPanel, "Tutor eliminado con exito");
            }
            dispose();
        });

        centerPanel.add(idPanel);
        southPanel.add(btnDelete);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void readAllTutores() {
        controller.readAll();
    }
}