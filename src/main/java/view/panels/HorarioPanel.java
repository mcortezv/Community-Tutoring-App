/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.panels;
import controllers.MainController;
import utils.TableModel;
import view.MainFrame;
import view.formsDialog.HorarioFormDialog;
import view.styles.Panel;
import view.styles.Button;
import java.awt.*;

/**
 *
 * @author Cortez, Manuel;
 */
public class HorarioPanel extends Panel {
    private Button btnCreateHorario;
    private Button btnReadHorario;
    private Button btnUpdateHorario;
    private Button btnDeleteHorario;
    private TablePanel tablePanel;
    private MainController controller;

    public HorarioPanel(MainFrame frame, NorthPanel northPanel, MainController controller) {
        super(frame, northPanel);
        this.controller = controller;
        updateTable();
    }

    @Override
    public void startComponents() {
        btnCreateHorario =  new Button("Agregar Horario");
        btnReadHorario =  new Button("Busar Horario");
        btnUpdateHorario =  new Button("Actualizar Horario");
        btnDeleteHorario =  new Button("Eliminar Horario");
        tablePanel = new TablePanel();
        btnCreateHorario.setPreferredSize(new Dimension(230, 40));
        btnReadHorario.setPreferredSize(new Dimension(230, 40));
        btnUpdateHorario.setPreferredSize(new Dimension(230, 40));
        btnDeleteHorario.setPreferredSize(new Dimension(230, 40));

        btnCreateHorario.addActionListener(e -> {
            new HorarioFormDialog(mainFrame, controller, 0).setVisible(true);
            updateTable();
        });

        btnReadHorario.addActionListener(e -> {
            new HorarioFormDialog(mainFrame, controller, 1).setVisible(true);
        });

        btnUpdateHorario.addActionListener(e -> {
            new HorarioFormDialog(mainFrame, controller, 2).setVisible(true);
            updateTable();
        });

        btnDeleteHorario.addActionListener(e -> {
            new HorarioFormDialog(mainFrame, controller, 3).setVisible(true);
            updateTable();
        });

        leftPanel.add(btnCreateHorario);
        leftPanel.add(btnReadHorario);
        leftPanel.add(btnUpdateHorario);
        leftPanel.add(btnDeleteHorario);
        rightPanel.add(tablePanel);
    }

    public void updateTable() {
        tablePanel.setFullModel(TableModel.listToTableModelHorarios(controller.getHorarioController().readAll()));
    }
}
