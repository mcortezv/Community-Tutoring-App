/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import controllers.MainController;
import view.MainFrame;

/**
 *  Clase main que contiene el metodo que iniciará la logica contenida en el sistema.
 *
 * @author Cortez, Manuel;
 */
public class Main {

    /**
     * Metodo main que ejecutará la lógica contenida en el sistema.
     */
    public static void main(String[] args) {
        MainFrame mainMenu = new MainFrame(createMainController());
        mainMenu.show();
    }

    public static MainController createMainController(){
        return new MainController();
    }
}
