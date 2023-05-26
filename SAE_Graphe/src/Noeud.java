import java.util.ArrayList;

/**
 * Classe représentant un nœud dans un graphe.
 */
public class Noeud {

    private String nom;
    private ArrayList<Arc> adj;

    /**
     * Constructeur de la classe Noeud.
     *
     * @param n le nom du nœud
     */
    public Noeud(String n) {
        this.nom = n;
        this.adj = new ArrayList<Arc>();
    }

    /**
     * Vérifie si le nœud est égal à un autre objet de type String.
     *
     * @param o l'objet à comparer avec le nœud
     * @return true si le nœud est égal à l'objet spécifié, false sinon
     */
    public boolean equals(String o) {
        return this.nom == o;
    }

    /**
     * Ajoute un arc sortant du nœud vers une destination avec un coût spécifié.
     *
     * @param destination la destination de l'arc
     * @param cout        le coût de l'arc
     */
    public void ajouterArc(String destination, double cout) {
        this.adj.add(new Arc(destination, cout));
    }

    /**
     * Obtient le nom du nœud.
     *
     * @return le nom du nœud
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Obtient la liste des arcs adjacents au nœud.
     *
     * @return la liste des arcs adjacents
     */
    public ArrayList<Arc> getAdj() {
        return this.adj;
    }
}
