package cl.ucn.disc.poo.MurderRobots.javax.swing;

import cl.ucn.disc.poo.MurderRobots.ui.MenuSistema;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Ejemplo de uso
        SwingUtilities.invokeLater(MenuSistema::new);
    }
}