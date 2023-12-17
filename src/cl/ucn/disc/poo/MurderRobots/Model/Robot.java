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

    public Material getBrazos() {
        return brazos;
    }

    public Material getPiernas() {
        return piernas;
    }

    public Robot setCabeza(Material cabeza) {
        this.cabeza = cabeza;
        return this;
    }

    public Robot setCuerpo(Material cuerpo) {
        this.cuerpo = cuerpo;
        return this;
    }

    public Robot setBrazos(Material brazos) {
        this.brazos = brazos;
        return this;
    }

    public Robot setPiernas(Material piernas) {
        this.piernas = piernas;
        return this;
    }

    public int getPuntosDefensaTotal() {
        return cabeza.getPuntoDefensa() + cuerpo.getPuntoDefensa() + brazos.getPuntoDefensa() + piernas.getPuntoDefensa();
    }

    public int getDanioAtaqueTotal() {
        return cabeza.getDanioAtaque() + cuerpo.getDanioAtaque() + brazos.getDanioAtaque() + piernas.getDanioAtaque();
    }

    public int getPuntosVidaTotal() {
        return cabeza.getPuntosVidaBase() + cuerpo.getPuntosVidaBase() + brazos.getPuntosVidaBase() + piernas.getPuntosVidaBase();
    }
}
