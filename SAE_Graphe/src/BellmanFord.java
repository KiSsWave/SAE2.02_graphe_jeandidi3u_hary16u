/**
 * La classe BellmanFord représente l'implémentation de l'algorithme de Bellman-Ford.
 * Cette classe implémente l'interface Algorithme.
 */
public class BellmanFord implements Algorithme {

    /**
     * Résout le problème du chemin le plus court en utilisant l'algorithme de Bellman-Ford.
     *
     * @param g Le graphe sur lequel l'algorithme est appliqué.
     * @param depart Le noeud de départ pour le chemin.
     * @return La valeur qui contient le chemin le plus court et les coûts des noeuds.
     */
    public Valeur resoudre(Graphe g, String depart) {
        // Initialiser la structure qui stocke les distances minimales et les parents pour chaque noeud
        Valeur v = new Valeur();

        // Initialiser la distance de chaque noeud à l'infini et le parent à null
        for (Noeud noeud : g.getNoeuds()) {
            v.setValeur(noeud.getNom(), Double.POSITIVE_INFINITY);
            v.setParent(noeud.getNom(), null);
        }

        // La distance du noeud de départ à lui-même est 0
        v.setValeur(depart, 0);

        for (int i = 0; i < g.getNoeuds().size() - 1; i++) {
            for (Noeud noeud : g.getNoeuds()) {
                for (Arc arc : noeud.getAdj()) {
                    // Si la distance à travers le noeud est plus petite, mettre à jour la distance et le parent
                    double d = v.getValeur(noeud.getNom()) + arc.getCout();
                    if (d < v.getValeur(arc.getDest())) {
                        v.setValeur(arc.getDest(), d);
                        v.setParent(arc.getDest(), noeud.getNom());
                    }
                }
            }
        }
        return v;
    }
}




