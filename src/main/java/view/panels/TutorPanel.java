/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.panels;
import controllers.TutorController;
import view.formsDialog.TutorFormDialog;
import view.MainFrame;
import view.styles.Panel;
import view.styles.Button;
import java.awt.*;

/**
 *
 * @author Cortez, Manuel;
 */
public class TutorPanel extends Panel {
    private Button btnCreateTutor;
    private Button btnReadTutor;
    private Button btnUpdateTutor;
    private Button btnDeleteTutor;
    private Button btnReadAllTutores;
    private TutorController tutorController;

    public TutorPanel(MainFrame frame, NorthPanel northPanel, TutorController tutorController) {
        super(frame, northPanel);
        this.tutorController = tutorController;
    }

    @Override
    public void startComponents() {
        btnCreateTutor = new Button("Agregar Tutor");
        btnReadTutor = new Button("Buscar Tutor");
        btnUpdateTutor = new Button("Actualizar Tutor");
        btnDeleteTutor = new Button("Eliminar Tutor");
        btnReadAllTutores = new Button("Listar Tutores");


        //Buttons
        btnCreateTutor.setPreferredSize(new Dimension(230, 40));
        btnReadTutor.setPreferredSize(new Dimension(230, 40));
        btnUpdateTutor.setPreferredSize(new Dimension(230, 40));
        btnDeleteTutor.setPreferredSize(new Dimension(230, 40));
        btnReadAllTutores.setPreferredSize(new Dimension(230, 40));


        btnCreateTutor.addActionListener(e -> {
            //new TutorFormDialog(mainFrame, 0, tutorController).setVisible(true);
        });

        btnReadTutor.addActionListener(e -> {
            //new TutorFormDialog(mainFrame, 1, tutorController).setVisible(true);
        });

        btnUpdateTutor.addActionListener(e -> {
            //new TutorFormDialog(mainFrame, 2, tutorController).setVisible(true);

        });

        btnDeleteTutor.addActionListener(e -> {
            //new TutorFormDialog(mainFrame, 3, tutorController).setVisible(true);
        });

        centralPanel.add(btnCreateTutor);
        centralPanel.add(btnReadTutor);
        centralPanel.add(btnUpdateTutor);
        centralPanel.add(btnDeleteTutor);
        centralPanel.add(btnReadAllTutores);
    }
}
