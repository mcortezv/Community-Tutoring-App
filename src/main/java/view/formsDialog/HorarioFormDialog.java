/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.formsDialog;
import controllers.MainController;
import models.Horario;
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
public final class HorarioFormDialog extends Dialog {
    private JPanel centerPanel;
    private JPanel southPanel;
    private MainFrame mainFrame;
    private TextField idField;
    private TextField diaField;
    private TextField horaInicioField;
    private TextField horaFinField;
    private TextField idTutorField;
    private MainController controller;

    public HorarioFormDialog(MainFrame owner, MainController controller, int option) {
        super(owner, " ", true);
        setResizable(false);
        mainFrame = owner;
        centerPanel = new JPanel();
        southPanel = new JPanel();
        this.controller = controller;
        switch (option) {
            case 0 -> {
                setTitle("Agregar Horario");
                createHorario();
            }
            case 1 -> {
                setTitle("Buscar Horario");
                readHorario();
            }
            case 2 -> {
                setTitle("Actualizar Horario");
                updateHorario();
            }
            case 3 -> {
                setTitle("Eliminar Horario");
                deleteHorario();
            }
            default -> {}
        }
    }

    public void createHorario() {
        setSize(500, 460);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel diaPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        diaPanel.add(new JLabel("Dia:                       "));
        diaField = new TextField(20);
        diaPanel.add(diaField);
        diaPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel horaInicioPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        horaInicioPanel.add(new JLabel("Hora Inicio:         "));
        horaInicioField = new TextField(20);
        horaInicioPanel.add(horaInicioField);
        horaInicioPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel horaFinPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        horaFinPanel.add(new JLabel("Hora Fin:              "));
        horaFinField = new TextField(20);
        horaFinPanel.add(horaFinField);
        horaFinPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel idTutorPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        idTutorPanel.add(new JLabel("Id Tutor:                "));
        idTutorField = new TextField(20);
        idTutorPanel.add(idTutorField);
        idTutorPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        Button btnCreate = new Button("Agregar");
        btnCreate.addActionListener(e -> {
            try {
                if (controller.getHorarioController().create(diaField.getText().trim(),
                        horaInicioField.getText().trim(),
                        horaFinField.getText().trim(),
                        controller.getTutorController().read(Integer.parseInt(idTutorField.getText().trim())))) {
                    JOptionPane.showMessageDialog(centerPanel, "Horario agregado con exito");
                } else {
                    JOptionPane.showMessageDialog(centerPanel, "El Horario no pudo agregarse");
                }
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(centerPanel, "Todos los campos son obligatorios");
            }
        });

        centerPanel.add(diaPanel);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(horaInicioPanel);
        centerPanel.add(horaFinPanel);
        centerPanel.add(idTutorPanel);
        southPanel.add(btnCreate);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void readHorario() {
        setSize(400, 200);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        idPanel.add(new JLabel("Horario ID:   "));
        idField = new TextField(20);
        idPanel.add(idField);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        Button btnSearch = new Button("Buscar");
        btnSearch.addActionListener(e -> {
            try {
                Horario horario = controller.getHorarioController().read(Integer.parseInt(idField.getText().trim()));
                if (horario != null) {
                    JOptionPane.showMessageDialog(centerPanel, horario.toString());
                } else {
                    JOptionPane.showMessageDialog(centerPanel, "Horario no encontrado");
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

    public void updateHorario() {
        setSize(500, 460);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        idPanel.add(new JLabel("Horario ID:         "));
        idField = new TextField(20);
        idPanel.add(idField);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel diaPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        diaPanel.add(new JLabel("Dia:                     "));
        diaField = new TextField(20);
        diaPanel.add(diaField);
        diaPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel horaInicioPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        horaInicioPanel.add(new JLabel("Hora Inicio:       "));
        horaInicioField = new TextField(20);
        horaInicioPanel.add(horaInicioField);
        horaInicioPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel horaFinPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        horaFinPanel.add(new JLabel("Hora Fin:            "));
        horaFinField = new TextField(20);
        horaFinPanel.add(horaFinField);
        horaFinPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        JPanel idTutorPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        idTutorPanel.add(new JLabel("Id Tutor:             "));
        idTutorField = new TextField(20);
        idTutorPanel.add(idTutorField);
        idTutorPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        Button btnUpdate = new Button("Actualizar");
        btnUpdate.addActionListener(e -> {
            try {
                if (controller.getHorarioController().update(Integer.parseInt(idField.getText().trim()),
                        diaField.getText().trim(),
                        horaInicioField.getText().trim(),
                        horaFinField.getText().trim(),
                        controller.getTutorController().read(Integer.parseInt(idTutorField.getText().trim())))) {
                    JOptionPane.showMessageDialog(centerPanel, "Horario actualizado con exito");
                } else {
                    JOptionPane.showMessageDialog(centerPanel, "El Horario no se pudo actualizar");
                }
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(centerPanel, "Todos los campos son obligatorios");
            }
        });

        centerPanel.add(idPanel);
        centerPanel.add(diaPanel);
        centerPanel.add(horaInicioPanel);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(horaFinPanel);
        centerPanel.add(idTutorPanel);
        southPanel.add(btnUpdate);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    public void deleteHorario() {
        setSize(400, 200);
        setLocationRelativeTo(mainFrame);
        setLayout(new BorderLayout());
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        idPanel.add(new JLabel("Horario ID:   "));
        idField = new TextField(20);
        idPanel.add(idField);
        idPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, -15, 0));

        Button btnDelete = new Button("Eliminar");
        btnDelete.addActionListener(e -> {
            try {
                if (controller.getHorarioController().delete(Integer.parseInt(idField.getText().trim()))) {
                    JOptionPane.showMessageDialog(centerPanel, "Horario eliminado con exito");
                } else {
                    JOptionPane.showMessageDialog(centerPanel, "El Horario no se pudo eliminar");
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