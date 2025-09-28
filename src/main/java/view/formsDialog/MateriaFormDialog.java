/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.formsDialog;
import controllers.MainController;
import controllers.MateriaController;
import models.Materia;
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
public final class MateriaFormDialog extends Dialog {
    private JPanel centerPanel;
    private JPanel southPanel;
    private MainFrame mainFrame;
    private TextField idField;
    private TextField nombreField;
    private TextField nivelField;
    private TextField descripcionField;
    private MateriaController controller;

    public MateriaFormDialog(MainFrame owner, MainController controller, int option) {
        super(owner, " ", true);
        setResizable(false);
        mainFrame = owner;
        centerPanel = new JPanel();
        southPanel = new JPanel();
        this.controller = controller.getMateriaController();
        switch (option) {
            case 0 -> {
                setTitle("Agregar Materia");
                createMateria();
            }
            case 1 -> {
                setTitle("Buscar Materia");
                readMateria();
            }
            case 2 -> {
                setTitle("Actualizar Materia");
                updateMateria();
            }
            case 3 -> {
                setTitle("Eliminar Materia");
                deleteMateria();
            }
            default -> {}
        }
    }

    public void createMateria() {
        setSize(660, 400);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel nombrePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        nombrePanel.add(new JLabel("Nombre:        "));
        nombreField = new TextField(20);
        nombrePanel.add(nombreField);
        nombrePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel nivelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        nivelPanel.add(new JLabel("Nivel:               "));
        nivelField = new TextField(20);
        nivelPanel.add(nivelField);
        nivelPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel descripcionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        descripcionPanel.add(new JLabel("Descripcion:                                "));
        descripcionField = new TextField(20);
        descripcionPanel.add(descripcionField);
        descripcionPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        Button btnCreate = new Button("Agregar");
        btnCreate.addActionListener(e -> {
            if (controller.create(nombreField.getText().trim(),
                    nivelField.getText().trim(),
                    descripcionField.getText().trim())) {
                JOptionPane.showMessageDialog(centerPanel, "Materia agregada con exito");
            } else {
                JOptionPane.showMessageDialog(centerPanel, "La Materia no se pudo agregar");
            }
            dispose();
        });

        centerPanel.add(nombrePanel);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(nivelPanel);
        centerPanel.add(descripcionPanel);
        southPanel.add(btnCreate);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void readMateria() {
        setSize(400, 200);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idPanel.add(new JLabel("ID de la Materia:   "));
        idField = new TextField(12);
        idPanel.add(idField);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        Button btnSearch = new Button("Buscar");
        btnSearch.addActionListener(e -> {
            Materia materia = controller.read(Integer.parseInt(idField.getText().trim()));
            if (materia != null) {
                JOptionPane.showMessageDialog(centerPanel, materia.toString());
            } else {
                JOptionPane.showMessageDialog(centerPanel, "Materia no encontrada");
            }
            dispose();
        });

        centerPanel.add(idPanel);
        southPanel.add(btnSearch);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void updateMateria() {
        setSize(660, 460);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idPanel.add(new JLabel("Materia ID:   "));
        idField = new TextField(20);
        idPanel.add(idField);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel nombrePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        nombrePanel.add(new JLabel("Nombre:        "));
        nombreField = new TextField(20);
        nombrePanel.add(nombreField);
        nombrePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel nivelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        nivelPanel.add(new JLabel("Nivel:               "));
        nivelField = new TextField(20);
        nivelPanel.add(nivelField);
        nivelPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel descripcionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        descripcionPanel.add(new JLabel("Descripcion:                                "));
        descripcionField = new TextField(20);
        descripcionPanel.add(descripcionField);
        descripcionPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        Button btnUpdate = new Button("Actualizar");
        btnUpdate.addActionListener(e -> {
            if (controller.update(Integer.parseInt(idField.getText().trim()),
                    nombreField.getText().trim(),
                    nivelField.getText().trim(),
                    descripcionField.getText().trim())) {
                JOptionPane.showMessageDialog(centerPanel, "Materia actualizada con exito");
            } else {
                JOptionPane.showMessageDialog(centerPanel, "La Materia no se pudo actualizar");
            }
            dispose();
        });

        centerPanel.add(idPanel);
        centerPanel.add(nombrePanel);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(nivelPanel);
        centerPanel.add(descripcionPanel);
        southPanel.add(btnUpdate);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void deleteMateria() {
        setSize(400, 200);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idPanel.add(new JLabel("ID de la Materia:   "));
        idField = new TextField(12);
        idPanel.add(idField);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        Button btnDelete = new Button("Eliminar");
        btnDelete.addActionListener(e -> {
            if (controller.delete(Integer.parseInt(idField.getText().trim()))) {
                JOptionPane.showMessageDialog(centerPanel, "Materia eliminada con exito");
            } else {
                JOptionPane.showMessageDialog(centerPanel, "La Materia no se pudo eliminar");
            }
            dispose();
        });

        centerPanel.add(idPanel);
        southPanel.add(btnDelete);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

}
