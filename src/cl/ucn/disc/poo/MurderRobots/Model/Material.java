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

    /**
     * Constructor Material
     *
     * @param nombre
     * @param puntoDefensa
     * @param danioAtaque
     * @param puntosVidaBase
     */
    Material(String nombre, int puntoDefensa, int danioAtaque, int puntosVidaBase) {
        this.nombre = nombre;
        this.puntoDefensa = puntoDefensa;
        this.danioAtaque = danioAtaque;
        this.puntosVidaBase = puntosVidaBase;
    }

    /**
     * getter Nombre
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * getter Puntos Defensa
     *
     * @return puntosDefensa
     */
    public int getPuntoDefensa() {
        return puntoDefensa;
    }

    /**
     * getter Daño de Ataque
     *
     * @return danioAtaque
     */
    public int getDanioAtaque() {
        return danioAtaque;
    }

    /**
     * getter Puntos De Vida Base
     *
     * @return puntosVidaBase
     */
    public int getPuntosVidaBase() {
        return puntosVidaBase;
    }


}