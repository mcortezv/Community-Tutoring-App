/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.styles;
import java.awt.*;

/**
 *
 * @author Cortez, Manuel;
 */
public class Style {
    public static boolean DARK_MODE = false;
    public static final Color PANEL_COLOR = DARK_MODE ? new Color( 23, 23, 23) : new Color(250, 250, 252);
    public static final Color BACKGROUND_COLOR = DARK_MODE ? new Color(60, 60, 60) : new Color(8, 58, 96);
    public static final Color BUTTON_COLOR = DARK_MODE ? new Color(19, 21, 26) : new Color(36, 110, 185);
    public static final Color BUTTON_COLOR_HOVER = DARK_MODE ? new Color(23, 23, 23) : new Color(60, 141, 218);
    public static final Color TEXT_COLOR = DARK_MODE ? new Color(235, 235, 235) : new Color(255, 255, 255);
    public static final Color INPUT_COLOR = DARK_MODE ? new Color(55, 55, 58) : new Color(70, 70, 70);

    public static final java.awt.Font TITLE_FONT = new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16);
    public static final java.awt.Font LABEL_FONT = new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 11);
    public static final java.awt.Font INPUT_FONT = new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 14);
    public static final java.awt.Font BUTTON_FONT = new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14);
}
