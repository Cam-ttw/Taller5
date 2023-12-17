package cl.ucn.disc.poo.MurderRobots.service;

import cl.ucn.disc.poo.MurderRobots.Model.Material;
import cl.ucn.disc.poo.MurderRobots.Model.Robot;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class FabricaDeRobots {
    private static FabricaDeRobots instanciaUnica;
    private Map<String, Robot> robots;

    private FabricaDeRobots() {

        robots = new HashMap<>();
    }

    public static FabricaDeRobots getInstance() {
        if (instanciaUnica == null) {
            instanciaUnica = new FabricaDeRobots();
        }
        return instanciaUnica;
    }

    public Robot ensamblarRobot(Material cabeza, Material cuerpo, Material brazos, Material piernas) {
        String numeroSerie = generarNumeroSerieAleatorio();
        Robot robot = new Robot(numeroSerie, cabeza, cuerpo, brazos, piernas);
        robots.put(numeroSerie, robot);
        return robot;
    }

    public void reemplazarParte(String numeroSerie, Material nuevaCabeza, Material nuevoCuerpo, Material nuevosBrazos, Material nuevasPiernas) {
        Robot robot = robots.get(numeroSerie);
        if (robot != null) {
            // Actualizar las partes del robot
            robot.setCabeza(nuevaCabeza);
            robot.setCuerpo(nuevoCuerpo);
            robot.setBrazos(nuevosBrazos);
            robot.setPiernas(nuevasPiernas);
        } else {
            JOptionPane.showMessageDialog(null, "Robot no encontrado");
        }
    }

    public String getRobots() {
        StringBuilder infoRobots = new StringBuilder();

        for (Robot robot : robots.values()) {
            infoRobots.append("[Serie]: ").append(robot.getNumeroSerie()).append("\n");
            infoRobots.append("[Cabeza]: ").append(robot.getCabeza().getNombre()).append("\n");
            infoRobots.append("[Cuerpo]: ").append(robot.getCuerpo().getNombre()).append("\n");
            infoRobots.append("[Brazos]: ").append(robot.getBrazos().getNombre()).append("\n");
            infoRobots.append("[Piernas]: ").append(robot.getPiernas().getNombre()).append("\n\n");
        }

        return infoRobots.toString();
    }

    public void destruirDatos() {
        // Limpiar la lista de robots
        robots.clear();
    }

    public boolean existeRobot(String numeroSerie) {
        return robots.containsKey(numeroSerie);
    }

    public Robot getRobot(String numeroSerie) {
        return robots.get(numeroSerie);
    }

    private String generarNumeroSerieAleatorio() {
        // Generar un número de serie aleatorio de 4 letras y 2 números
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            char letra = letras.charAt((int) (Math.random() * letras.length()));
            sb.append(letra);
        }
        for (int i = 0; i < 2; i++) {
            sb.append((int) (Math.random() * 10));
        }
        return sb.toString();
    }

}
