/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.panels;
import controllers.HorarioController;
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
    private Button btnReadAllHorarios;
    private HorarioController horarioController;

    public HorarioPanel(MainFrame frame, NorthPanel northPanel, HorarioController horarioController) {
        super(frame, northPanel);
        this.horarioController = horarioController;
    }

    @Override
    public void startComponents() {
        btnCreateHorario =  new Button("Agregar Horario");
        btnReadHorario =  new Button("Busar Horario");
        btnUpdateHorario =  new Button("Actualizar Horario");
        btnDeleteHorario =  new Button("Eliminar Horario");
        btnReadAllHorarios =  new Button("Listar Horarios");

        btnCreateHorario.setPreferredSize(new Dimension(230, 40));
        btnReadHorario.setPreferredSize(new Dimension(230, 40));
        btnUpdateHorario.setPreferredSize(new Dimension(230, 40));
        btnDeleteHorario.setPreferredSize(new Dimension(230, 40));
        btnReadAllHorarios.setPreferredSize(new Dimension(230, 40));

        btnCreateHorario.addActionListener(e -> {
            //new HorarioFormDialog(mainFrame, 0, horarioController, this).setVisible(true);
        });

        btnReadHorario.addActionListener(e -> {
            //new HorarioFormDialog(mainFrame, 1, horarioController, this).setVisible(true);
        });

        btnUpdateHorario.addActionListener(e -> {
            //new HorarioFormDialog(mainFrame, 2, horarioController, this).setVisible(true);
        });

        centralPanel.add(btnCreateHorario);
        centralPanel.add(btnReadHorario);
        centralPanel.add(btnUpdateHorario);
        centralPanel.add(btnDeleteHorario);
        centralPanel.add(btnReadAllHorarios);
    }
}
