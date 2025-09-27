/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.panels;
import controllers.EstudianteController;
import view.formsDialog.EstudianteFormDialog;
import view.MainFrame;
import view.styles.Panel;
import view.styles.Button;
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
    private Button btnReadAllEstudiantes;
    private EstudianteController estudianteController;

    public EstudiantePanel(MainFrame frame, NorthPanel northPanel, EstudianteController estudianteController) {
        super(frame, northPanel);
        this.estudianteController = estudianteController;
    }

    @Override
    public void startComponents() {
        btnCreateEstudiante = new Button("Agregar Estudiante");
        btnReadEstudiante = new Button("Buscar Estudiante");
        btnUpdateEstudiante = new Button("Actualizar Estudiante");
        btnDeleteEstudiante = new Button("Eliminar Estudiante");
        btnReadAllEstudiantes = new Button("Listar Estudiantes");

        btnCreateEstudiante.setPreferredSize(new Dimension(230, 40));
        btnReadEstudiante.setPreferredSize(new Dimension(230, 40));
        btnUpdateEstudiante.setPreferredSize(new Dimension(230, 40));
        btnDeleteEstudiante.setPreferredSize(new Dimension(230, 40));
        btnReadAllEstudiantes.setPreferredSize(new Dimension(230, 40));
        btnCreateEstudiante.addActionListener(e -> {
            //new StudentFormDialog(mainFrame, estudianteController, 0).setVisible(true);
        });
        btnReadEstudiante.addActionListener(e -> {
            //new StudentFormDialog(mainFrame, estudianteController, 1).setVisible(true);
        });
        btnUpdateEstudiante.addActionListener(e -> {
            //new StudentFormDialog(mainFrame, estudianteController, 2).setVisible(true);
        });
        btnDeleteEstudiante.addActionListener(e -> {
            //new StudentFormDialog(mainFrame, estudianteController, 3).setVisible(true);
        });
        btnReadAllEstudiantes.addActionListener(e -> {
            //new StudentFormDialog(mainFrame, estudianteController, 4).setVisible(true);
        });

        centralPanel.add(btnCreateEstudiante);
        centralPanel.add(btnReadEstudiante);
        centralPanel.add(btnUpdateEstudiante);
        centralPanel.add(btnDeleteEstudiante);
        centralPanel.add(btnReadAllEstudiantes);
    }
}
