package cl.ucn.disc.poo.MurderRobots.Model;

public enum Material {
    METAL_COMUN("metal común", 25, 30, 400),
    ACERO("acero", 50, 60, 150),
    GRAFENO("grafeno", 10, 120, 500),
    VIBRANIUM("vibranium", 100, 20, 250);

    private String nombre;
    private int puntoDefensa;
    private int danioAtaque;
    private int puntosVidaBase;

    Material(String nombre, int puntoDefensa, int danioAtaque, int puntosVidaBase) {
        this.nombre = nombre;
        this.puntoDefensa = puntoDefensa;
        this.danioAtaque = danioAtaque;
        this.puntosVidaBase = puntosVidaBase;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntoDefensa() {
        return puntoDefensa;
    }

    public int getDanioAtaque() {
        return danioAtaque;
    }

    public int getPuntosVidaBase() {
        return puntosVidaBase;
    }


}