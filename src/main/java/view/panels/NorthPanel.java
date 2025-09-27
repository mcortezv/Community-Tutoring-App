/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.panels;
import view.styles.*;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Cortez, Manuel;
 */
public class NorthPanel extends JPanel {
    private Button btnInUse;

    public NorthPanel() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        setBorder(new EmptyBorder(10, 0, 10, 0));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();

        g.setColor(Style.BACKGROUND_COLOR);
        g.fillRect(0, 0, width, height);
        Graphics2D g2 = (Graphics2D) g;

        if (btnInUse != null) {
            Rectangle r = btnInUse.getBounds();
            g2.setColor(Color.WHITE);
            g2.fillRoundRect(r.x - 5, r.y - 5, r.width + 10, r.height + 10, 15, 15);
        } else {
            g2.setColor(Style.PANEL_COLOR);

        }
    }

    public void setInUseButton(Button boton) {
        this.btnInUse = boton;
        repaint();
    }

    public void erraseRectangle() {
        btnInUse = null;
        repaint();
    }

}
