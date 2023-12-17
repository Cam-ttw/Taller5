package cl.ucn.disc.poo.MurderRobots.Model;

public class Robot {
    private String numeroSerie;
    private Material cabeza;
    private Material cuerpo;
    private Material brazos;
    private Material piernas;

    /**
     * Constructor robot
     *
     * @param numeroSerie
     * @param cabeza
     * @param cuerpo
     * @param brazos
     * @param piernas
     */
    public Robot(String numeroSerie, Material cabeza, Material cuerpo, Material brazos, Material piernas) {
        this.numeroSerie = numeroSerie;
        this.cabeza = cabeza;
        this.cuerpo = cuerpo;
        this.brazos = brazos;
        this.piernas = piernas;
    }

    /**
     * getter Numero de Serie
     *
     * @return numeroSerie
     */
    public String getNumeroSerie() {
        return numeroSerie;
    }

    /**
     * getter Cabeza
     *
     * @return cabeza
     */
    public Material getCabeza() {
        return cabeza;
    }

    /**
     * getter Cuerpo
     *
     * @return cuerpo
     */
    public Material getCuerpo() {
        return cuerpo;
    }

    /**
     * getter Brazos
     *
     * @return brazps
     */
    public Material getBrazos() {
        return brazos;
    }

    /**
     * getter Piernas
     *
     * @return piernas
     */
    public Material getPiernas() {
        return piernas;
    }

    /**
     * Setter cabeza
     *
     * @param cabeza
     * @return this.cabeza
     */
    public Robot setCabeza(Material cabeza) {
        this.cabeza = cabeza;
        return this;
    }

    /**
     * Setter Cuerpo
     *
     * @param cuerpo
     * @return this.cuerpo
     */
    public Robot setCuerpo(Material cuerpo) {
        this.cuerpo = cuerpo;
        return this;
    }

    /**
     * setter Brazos
     *
     * @param brazos
     * @return this.brazos
     */
    public Robot setBrazos(Material brazos) {
        this.brazos = brazos;
        return this;
    }

    /**
     * setter Piernas
     *
     * @param piernas
     * @return this.piernas
     */
    public Robot setPiernas(Material piernas) {
        this.piernas = piernas;
        return this;
    }

    /**
     * getter Puntos De Defensa Total
     *
     * @return PuntosDefensaTotal
     */
    public int getPuntosDefensaTotal() {
        return cabeza.getPuntoDefensa() + cuerpo.getPuntoDefensa() + brazos.getPuntoDefensa() + piernas.getPuntoDefensa();
    }

    /**
     * getter Daño De Ataque Total
     *
      * @return DanioTotal
     */
    public int getDanioAtaqueTotal() {
        return cabeza.getDanioAtaque() + cuerpo.getDanioAtaque() + brazos.getDanioAtaque() + piernas.getDanioAtaque();
    }

    /**
     * getter Puntos De Vida Total
     *
     * @return PuntosVidaTotal
     */
    public int getPuntosVidaTotal() {
        return cabeza.getPuntosVidaBase() + cuerpo.getPuntosVidaBase() + brazos.getPuntosVidaBase() + piernas.getPuntosVidaBase();
    }

}
