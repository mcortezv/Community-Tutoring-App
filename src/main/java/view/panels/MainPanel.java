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
    private final Image imagen;

    public MainPanel() {
        this.imagen = new ImageIcon(
                new ImageIcon("src/main/java/assets/start.jpg")
                        .getImage()
                        .getScaledInstance(901, 600, Image.SCALE_SMOOTH)
        ).getImage();
        setLayout(new BorderLayout());

        centerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        centerPanel.setPreferredSize(new Dimension(901, 600));
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
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        g2d.dispose();
    }
}
