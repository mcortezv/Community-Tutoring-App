/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.panels;
import view.styles.Style;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Cortez, Manuel;
 */
public class MainPanel extends JPanel {
    private JPanel centerPanel;
    private JPanel soutPanel;
    //private final Image imagen;

    public MainPanel() {
        //this.imagen = new ImageIcon("").getImage(); Imagen Principal
        setLayout(new BorderLayout());

        centerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        centerPanel.setPreferredSize(new Dimension(1200, 550));
        centerPanel.setOpaque(false);

        soutPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        soutPanel.setBackground(Style.PANEL_COLOR);
        soutPanel.setOpaque(false);
        add(centerPanel, BorderLayout.CENTER);
        add(soutPanel, BorderLayout.SOUTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
    }
}
