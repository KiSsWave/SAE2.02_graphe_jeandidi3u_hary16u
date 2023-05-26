/**
 * Classe représentant un arc reliant deux nœuds dans un graphe.
 */
class Arc {
    private String dest;
    private double cout;

    /**
     * Constructeur de la classe Arc.
     *
     * @param d la destination de l'arc
     * @param c le coût de l'arc
     * @throws IllegalArgumentException si le coût est inférieur ou égal à zéro
     */
    public Arc(String d, double c) {
        if (c <= 0) {
            throw new IllegalArgumentException("Le cout doit être positif");
        }
        this.dest = d;
        this.cout = c;
    }

    /**
     * Obtient la destination de l'arc.
     *
     * @return la destination de l'arc
     */
    public String getDest() {
        return dest;
    }

    /**
     * Obtient le coût de l'arc.
     *
     * @return le coût de l'arc
     */
    public double getCout() {
        return cout;
    }
}