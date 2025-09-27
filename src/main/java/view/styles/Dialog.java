/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.styles;
import view.MainFrame;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author Cortez, Manuel;
 */
public abstract class Dialog extends JDialog {
    protected JPanel centerPanel;
    protected JPanel southPanel;
    protected MainFrame mainFrame;

    public Dialog(MainFrame owner, String title, boolean modal) {
        super(owner, title, modal);
        mainFrame = owner;
        centerPanel = new JPanel();
        southPanel = new JPanel();
    }
}
