/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.panels;
import controllers.MateriaController;
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
    private Button btnReadAllMaterias;
    private MateriaController materiaController;

    public MateriaPanel(MainFrame frame, NorthPanel northPanel, MateriaController materiaController) {
        super(frame, northPanel);
        this.materiaController = materiaController;
    }

    @Override
    public void startComponents() {
        btnCreateMateria =  new Button("Agregar Materia");
        btnReadMateria =  new Button("Buscar Materia");
        btnUpdateMateria =  new Button("Actualizar Materia");
        btnDeleteMateria =  new Button("Eliminar Materia");
        btnReadAllMaterias =  new Button("Listar Materias");

        //Botones
        btnCreateMateria.setPreferredSize(new Dimension(230, 40));
        btnReadMateria.setPreferredSize(new Dimension(230, 40));
        btnUpdateMateria.setPreferredSize(new Dimension(230, 40));
        btnDeleteMateria.setPreferredSize(new Dimension(230, 40));
        btnReadAllMaterias.setPreferredSize(new Dimension(230, 40));

        //button
        btnCreateMateria.addActionListener(e -> {
            //new MateriaFormDialog(mainFrame, 0, materiaController, this).setVisible(true);
        });

        btnReadMateria.addActionListener(e -> {
            //new MateriaFormDialog(mainFrame, 1, materiaController, this).setVisible(true);
        });

        btnUpdateMateria.addActionListener(e -> {
            //new MateriaFormDialog(mainFrame, 2, materiaController, this).setVisible(true);
        });

        btnDeleteMateria.addActionListener(e -> {
            //new MateriaFormDialog(mainFrame, 3, materiaController, this).setVisible(true);
        });

        btnReadAllMaterias.addActionListener(e -> {
            //new MateriaFormDialog(mainFrame, 4, materiaController, this).setVisible(true);
        });

        centralPanel.add(btnCreateMateria);
        centralPanel.add(btnReadMateria);
        centralPanel.add(btnUpdateMateria);
        centralPanel.add(btnDeleteMateria);
        centralPanel.add(btnReadAllMaterias);
    }
}
