/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.styles;
import view.MainFrame;
import view.panels.NorthPanel;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Cortez, Manuel;
 */
public abstract class Panel extends JPanel {
    protected MainFrame mainFrame;
    protected JPanel leftPanel;
    protected JPanel rightPanel;
    protected JPanel southPanel;
    protected Button btnBack;
    protected NorthPanel northPanel;

    public Panel(MainFrame frame, NorthPanel northPanel) {
        setBackground(Style.BACKGROUND_COLOR);
        mainFrame = frame;
        this.northPanel = northPanel;
        btnBack = new Button("←");
        setLayout(new BorderLayout());
        leftPanel = new JPanel();
        rightPanel = new JPanel();
        southPanel = new JPanel();
        leftPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        leftPanel.setPreferredSize(new Dimension(350, 500));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(120, 0, 0, 0));
        rightPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        rightPanel.setPreferredSize(new Dimension(850, 500));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
        southPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        southPanel.setPreferredSize(new Dimension(500, 50));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 60, 20, 0));
        leftPanel.setBackground(Color.WHITE);
        rightPanel.setBackground(Color.WHITE);
        southPanel.setBackground(Color.WHITE);
        startComponents();
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);
        add(southPanel, BorderLayout.SOUTH);
        southPanel.add(btnBack);

        btnBack.addActionListener(e -> frame.showMainPanel());
        btnBack.addActionListener(e -> {
            this.northPanel.erraseRectangle();
        });
    }

    public abstract void startComponents();
}
