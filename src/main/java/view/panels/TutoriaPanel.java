/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.panels;
import controllers.TutoriaController;
import view.formsDialog.TutorFormDialog;
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
    private Button btnReadAllTutorias;
    private TutoriaController tutoriaController;

    public TutoriaPanel(MainFrame frame, NorthPanel northPanel, TutoriaController tutoriaController) {
        super(frame, northPanel);
        this.tutoriaController = tutoriaController;
    }

    @Override
    public void startComponents() {
        btnCreateTutoria = new Button("Agregar Tutoria");
        btnReadTutoria = new Button("Buscar Tutoria");
        btnUpdateTutoria = new Button("Actualizar Tutoria");
        btnDeleteTutoria = new Button("Eliminar Tutoria");
        btnReadAllTutorias = new Button("Listar Tutorias");


        //Buttons
        btnCreateTutoria.setPreferredSize(new Dimension(230, 40));
        btnReadTutoria.setPreferredSize(new Dimension(230, 40));
        btnUpdateTutoria.setPreferredSize(new Dimension(230, 40));
        btnDeleteTutoria.setPreferredSize(new Dimension(230, 40));
        btnReadAllTutorias.setPreferredSize(new Dimension(230, 40));


        btnCreateTutoria.addActionListener(e -> {
            //new TutorFormDialog(mainFrame, 0,tutoriaController).setVisible(true);
        });

        btnReadTutoria.addActionListener(e -> {
            //new TutorFormDialog(mainFrame, 1,tutoriaController).setVisible(true);
        });

        btnUpdateTutoria.addActionListener(e -> {
            //new TutorFormDialog(2, tutoriaController);

        });

        btnDeleteTutoria.addActionListener(e -> {
            //new TutorFormDialog(mainFrame, 3,tutoriaController).setVisible(true);
        });

        centralPanel.add(btnCreateTutoria);
        centralPanel.add(btnReadTutoria);
        centralPanel.add(btnUpdateTutoria);
        centralPanel.add(btnDeleteTutoria);
        centralPanel.add(btnReadAllTutorias);
    }
}
