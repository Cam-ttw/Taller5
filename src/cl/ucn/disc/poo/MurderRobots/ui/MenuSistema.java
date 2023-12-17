package cl.ucn.disc.poo.MurderRobots.ui;

import cl.ucn.disc.poo.MurderRobots.service.FabricaDeRobots;
import cl.ucn.disc.poo.MurderRobots.Model.Material;
import cl.ucn.disc.poo.MurderRobots.Model.Robot;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class MenuSistema {
    private JButton ensamblarRobotButton;
    private JButton editarRobotButton;
    private JButton mostrarRobotButton;
    private JButton salirButton;
    private JPanel PanelPrincipal;

    public MenuSistema() {
        // Asignar manejadores de eventos a los botones
        ensamblarRobotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ensamblarRobot();
            }
        });

        editarRobotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                editarRobot();
            }
        });

        mostrarRobotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mostrarRobots();
            }
        });

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                salir();
            }
        });

        // Crear el marco principal
        JFrame frame = new JFrame("Menú del Sistema");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(PanelPrincipal); // Establecer el panel principal en el marco
        frame.pack();
        frame.setVisible(true);
    }

    // Métodos para la lógica detrás de cada botón
    private void ensamblarRobot() {
        FabricaDeRobots fabrica = FabricaDeRobots.getInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Ensamblaje de Robot ===");
        System.out.println("Ingrese los materiales para construir el robot:");

        System.out.print("Material para la cabeza (Metal común, Acero, Grafeno, Vibranium): ");
        Material cabezaMaterial = obtenerMaterial(scanner.nextLine());

        System.out.print("Material para el cuerpo (Metal común, Acero, Grafeno, Vibranium): ");
        Material cuerpoMaterial = obtenerMaterial(scanner.nextLine());

        System.out.print("Material para los brazos (Metal común, Acero, Grafeno, Vibranium): ");
        Material brazosMaterial = obtenerMaterial(scanner.nextLine());

        System.out.print("Material para las piernas (Metal común, Acero, Grafeno, Vibranium): ");
        Material piernasMaterial = obtenerMaterial(scanner.nextLine());

        // Llamar a la fábrica para ensamblar el robot
        Robot robot = fabrica.ensamblarRobot(cabezaMaterial, cuerpoMaterial, brazosMaterial, piernasMaterial);

        System.out.println("\n¡Robot ensamblado con éxito!");
        System.out.println("Número de serie: " + robot.getNumeroSerie());
    }

    private void editarRobot() {
        FabricaDeRobots fabrica = FabricaDeRobots.getInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Edición de Robot ===");

        // Solicitar el número de serie del robot a editar
        System.out.print("Ingrese el número de serie del robot a editar: ");
        String numeroSerie = scanner.nextLine();

        // Verificar si el robot existe
        if (!fabrica.existeRobot(numeroSerie)) {
            System.out.println("No se encontró un robot con el número de serie proporcionado.");
            return;
        }

        // Obtener el robot actual
        Robot robotActual = fabrica.getRobot(numeroSerie);

        // Mostrar la información del robot actual
        System.out.println("\nRobot actual:");
        System.out.println("[Serie]: " + robotActual.getNumeroSerie());
        System.out.println("[Cabeza]: " + robotActual.getCabeza().getNombre());
        System.out.println("[Cuerpo]: " + robotActual.getCuerpo().getNombre());
        System.out.println("[Brazos]: " + robotActual.getBrazos().getNombre());
        System.out.println("[Piernas]: " + robotActual.getPiernas().getNombre());

        // Solicitar nuevos materiales para cada parte
        System.out.println("\nIngrese los nuevos materiales para el robot:");

        System.out.print("Nuevo material para la cabeza: ");
        Material nuevaCabeza = obtenerMaterial(scanner.nextLine());

        System.out.print("Nuevo material para el cuerpo: ");
        Material nuevoCuerpo = obtenerMaterial(scanner.nextLine());

        System.out.print("Nuevo material para los brazos: ");
        Material nuevosBrazos = obtenerMaterial(scanner.nextLine());

        System.out.print("Nuevo material para las piernas: ");
        Material nuevasPiernas = obtenerMaterial(scanner.nextLine());

        // Llamar a la fábrica para reemplazar la parte del robot
        fabrica.reemplazarParte(numeroSerie, nuevaCabeza, nuevoCuerpo, nuevosBrazos, nuevasPiernas);

        // Imprimir estadísticas después de la edición
        imprimirEstadisticas(robotActual);

        System.out.println("\n¡Robot editado con éxito!");
    }

    private void imprimirEstadisticas(Robot robot) {
        // Mostrar las estadísticas del robot
        System.out.println("\nEstadísticas del Robot:");
        System.out.println("Defensa: " + robot.getPuntosDefensaTotal());
        System.out.println("Daño: " + robot.getDanioAtaqueTotal());
        System.out.println("Vida: " + robot.getPuntosVidaTotal());
    }

    private void mostrarRobots() {
        FabricaDeRobots fabrica = FabricaDeRobots.getInstance();

        // Obtener la información de los robots desde FabricaDeRobots
        String infoRobots = fabrica.getRobots();

        if (infoRobots.isEmpty()) {
            System.out.println("No hay robots para mostrar.");
        } else {
            // Imprimir la información de los robots en la consola con un formato mejorado
            System.out.println("Lista de Robots:\n");

            String[] robotsInfoArray = infoRobots.split("\n\n");
            for (String robotInfo : robotsInfoArray) {
                System.out.println("------------------------------");
                System.out.println(robotInfo.trim());

                // Obtener el número de serie del robot
                String numeroSerie = obtenerNumeroSerie(robotInfo);

                // Obtener el robot actual
                Robot robotActual = fabrica.getRobot(numeroSerie);

                // Imprimir estadísticas del robot
                imprimirEstadisticas(robotActual);

                System.out.println("------------------------------\n");
            }
        }
    }

    private String obtenerNumeroSerie(String robotInfo) {
        // Extraer el número de serie del texto del robot
        String[] lines = robotInfo.split("\n");
        for (String line : lines) {
            if (line.startsWith("[Serie]: ")) {
                return line.substring("[Serie]: ".length());
            }
        }
        return "";
    }



    private void salir() {
        FabricaDeRobots fabrica = FabricaDeRobots.getInstance();

        // Llamar al método destruirDatos de FabricaDeRobots
        fabrica.destruirDatos();

        // Mostrar mensaje de éxito
        JOptionPane.showMessageDialog(null, "Datos de robots destruidos");
        System.exit(0);
    }

    private Material obtenerMaterial(String materialInput) {
        switch (materialInput.toLowerCase()) {
            case "metal comun":
                return Material.METAL_COMUN;
            case "acero":
                return Material.ACERO;
            case "grafeno":
                return Material.GRAFENO;
            case "vibranium":
                return Material.VIBRANIUM;
            default:
                System.out.println("Material no válido. Se utilizará Metal común por defecto.");
                return Material.METAL_COMUN;
        }
    }

}

