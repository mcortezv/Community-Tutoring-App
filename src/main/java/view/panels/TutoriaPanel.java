/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.panels;
import controllers.MainController;
import utils.TableModel;
import view.formsDialog.TutoriaFormDialog;
import view.MainFrame;
import view.styles.Panel;
import view.styles.Button;
import java.awt.*;

/**
 *
 * @author Cortez, Manuel;
 */
public class TutoriaPanel extends Panel {
    private Button btnCreateTutoria;
    private Button btnReadTutoria;
    private Button btnUpdateTutoria;
    private Button btnDeleteTutoria;
    private TablePanel tablePanel;
    private MainController controller;

    public TutoriaPanel(MainFrame frame, NorthPanel northPanel, MainController controller) {
        super(frame, northPanel);
        this.controller = controller;
        tablePanel.setFullModel(TableModel.listToTableModelTutoria(controller.getTutoriaController().readAll()));
    }

    @Override
    public void startComponents() {
        btnCreateTutoria = new Button("Agregar Tutoria");
        btnReadTutoria = new Button("Buscar Tutoria");
        btnUpdateTutoria = new Button("Actualizar Tutoria");
        btnDeleteTutoria = new Button("Eliminar Tutoria");
        tablePanel = new TablePanel();
        btnCreateTutoria.setPreferredSize(new Dimension(230, 40));
        btnReadTutoria.setPreferredSize(new Dimension(230, 40));
        btnUpdateTutoria.setPreferredSize(new Dimension(230, 40));
        btnDeleteTutoria.setPreferredSize(new Dimension(230, 40));

        btnCreateTutoria.addActionListener(e -> {
            new TutoriaFormDialog(mainFrame, controller, 0).setVisible(true);
            tablePanel.setFullModel(TableModel.listToTableModelTutoria(controller.getTutoriaController().readAll()));
        });

        btnReadTutoria.addActionListener(e -> {
            new TutoriaFormDialog(mainFrame, controller, 1).setVisible(true);
        });

        btnUpdateTutoria.addActionListener(e -> {
            new TutoriaFormDialog(mainFrame, controller, 2).setVisible(true);
            tablePanel.setFullModel(TableModel.listToTableModelTutoria(controller.getTutoriaController().readAll()));
        });

        btnDeleteTutoria.addActionListener(e -> {
            new TutoriaFormDialog(mainFrame, controller, 3).setVisible(true);
            tablePanel.setFullModel(TableModel.listToTableModelTutoria(controller.getTutoriaController().readAll()));
        });

        leftPanel.add(btnCreateTutoria);
        leftPanel.add(btnReadTutoria);
        leftPanel.add(btnUpdateTutoria);
        leftPanel.add(btnDeleteTutoria);
        rightPanel.add(tablePanel);
    }
}
