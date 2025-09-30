/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.panels;
import controllers.MainController;
import utils.TableModel;
import view.MainFrame;
import view.formsDialog.MateriaFormDialog;
import view.styles.Panel;
import view.styles.Button;
import java.awt.Dimension;

/**
 *
 * @author Cortez, Manuel;
 */
public class MateriaPanel extends Panel {
    private Button btnCreateMateria;
    private Button btnReadMateria;
    private Button btnUpdateMateria;
    private Button btnDeleteMateria;
    private TablePanel tablePanel;
    private MainController controller;

    public MateriaPanel(MainFrame frame, NorthPanel northPanel, MainController controller) {
        super(frame, northPanel);
        this.controller = controller;
        tablePanel.setFullModel(TableModel.listToTableModelMaterias(controller.getMateriaController().readAll()));
    }

    @Override
    public void startComponents() {
        btnCreateMateria =  new Button("Agregar Materia");
        btnReadMateria =  new Button("Buscar Materia");
        btnUpdateMateria =  new Button("Actualizar Materia");
        btnDeleteMateria =  new Button("Eliminar Materia");
        tablePanel = new TablePanel();
        btnCreateMateria.setPreferredSize(new Dimension(230, 40));
        btnReadMateria.setPreferredSize(new Dimension(230, 40));
        btnUpdateMateria.setPreferredSize(new Dimension(230, 40));
        btnDeleteMateria.setPreferredSize(new Dimension(230, 40));

        btnCreateMateria.addActionListener(e -> {
            new MateriaFormDialog(mainFrame, controller, 0).setVisible(true);
            updateTable();
        });

        btnReadMateria.addActionListener(e -> {
            new MateriaFormDialog(mainFrame, controller, 1).setVisible(true);
        });

        btnUpdateMateria.addActionListener(e -> {
            new MateriaFormDialog(mainFrame, controller, 2).setVisible(true);
            updateTable();
        });

        btnDeleteMateria.addActionListener(e -> {
            new MateriaFormDialog(mainFrame, controller, 3).setVisible(true);
            updateTable();
        });

        leftPanel.add(btnCreateMateria);
        leftPanel.add(btnReadMateria);
        leftPanel.add(btnUpdateMateria);
        leftPanel.add(btnDeleteMateria);
        rightPanel.add(tablePanel);
    }

    public void updateTable() {
        tablePanel.setFullModel(TableModel.listToTableModelMaterias(controller.getMateriaController().readAll()));
    }
}
