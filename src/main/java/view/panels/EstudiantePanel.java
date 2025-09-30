/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.panels;
import controllers.MainController;
import view.formsDialog.EstudianteFormDialog;
import view.MainFrame;
import view.styles.Panel;
import view.styles.Button;
import utils.TableModel;
import java.awt.Dimension;

/**
 *
 * @author Cortez, Manuel;
 */
public class EstudiantePanel extends Panel {
    private Button btnCreateEstudiante;
    private Button btnReadEstudiante;
    private Button btnUpdateEstudiante;
    private Button btnDeleteEstudiante;
    private TablePanel tablePanel;
    private MainController controller;

    public EstudiantePanel(MainFrame frame, NorthPanel northPanel, MainController controller) {
        super(frame, northPanel);
        this.controller = controller;
        updateTable();
    }

    @Override
    public void startComponents() {
        btnCreateEstudiante = new Button("Agregar Estudiante");
        btnReadEstudiante = new Button("Buscar Estudiante");
        btnUpdateEstudiante = new Button("Actualizar Estudiante");
        btnDeleteEstudiante = new Button("Eliminar Estudiante");
        tablePanel = new TablePanel();
        btnCreateEstudiante.setPreferredSize(new Dimension(230, 40));
        btnReadEstudiante.setPreferredSize(new Dimension(230, 40));
        btnUpdateEstudiante.setPreferredSize(new Dimension(230, 40));
        btnDeleteEstudiante.setPreferredSize(new Dimension(230, 40));
        btnCreateEstudiante.addActionListener(e -> {
            new EstudianteFormDialog(mainFrame, controller, 0).setVisible(true);
            updateTable();
        });
        btnReadEstudiante.addActionListener(e -> {
            new EstudianteFormDialog(mainFrame, controller, 1).setVisible(true);
        });
        btnUpdateEstudiante.addActionListener(e -> {
            new EstudianteFormDialog(mainFrame, controller, 2).setVisible(true);
            updateTable();
        });
        btnDeleteEstudiante.addActionListener(e -> {
            new EstudianteFormDialog(mainFrame, controller, 3).setVisible(true);
            updateTable();
        });

        leftPanel.add(btnCreateEstudiante);
        leftPanel.add(btnReadEstudiante);
        leftPanel.add(btnUpdateEstudiante);
        leftPanel.add(btnDeleteEstudiante);
        rightPanel.add(tablePanel);
    }

    public void updateTable() {
        tablePanel.setFullModel(TableModel.listToTableModelEstudiantes(controller.getEstudianteController().readAll()));
    }
}
