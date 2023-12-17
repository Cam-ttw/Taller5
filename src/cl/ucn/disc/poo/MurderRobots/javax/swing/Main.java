package cl.ucn.disc.poo.MurderRobots.javax.swing;

import cl.ucn.disc.poo.MurderRobots.ui.MenuSistema;

import javax.swing.*;

/**
 * Camilo Olmos 21499199-3
 * Matias Archiles 21.414.064-0
 *
 * iniciador del codigo Main
 */
public class Main {
    public static void main(String[] args) {
        // Ejemplo de uso
        SwingUtilities.invokeLater(MenuSistema::new);
    }
}