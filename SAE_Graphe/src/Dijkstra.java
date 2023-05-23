import java.util.ArrayList;
public class Dijkstra {

    public Valeur resoudre(GrapheListe graphe, String depart) {
        // Initialiser la structure de valeur
        Valeur v = new Valeur();

        // Initialiser la liste des noeuds à traiter
        ArrayList<Noeud> noeudsATraiter = new ArrayList<>(graphe.getNoeuds());

        // Initialiser la distance de chaque noeud à Infini et son parent à Indéfini
        for (Noeud noeud : noeudsATraiter) {
            v.setValeur(noeud.getNom(), Double.POSITIVE_INFINITY);
            v.setParent(noeud.getNom(), null);
        }

        // La distance du noeud de départ à lui-même est 0
        v.setValeur(depart, 0);

        // Tant que la liste des noeuds à traiter n'est pas vide
        while (!noeudsATraiter.isEmpty()) {
            // Trouver le noeud u dont la distance est minimale
            Noeud u = noeudsATraiter.get(0);
            for (Noeud noeud : noeudsATraiter) {
                if (v.getValeur(noeud.getNom()) < v.getValeur(u.getNom())) {
                    u = noeud;
                }
            }
            // Enlever le noeud u de la liste des noeuds à traiter
            noeudsATraiter.remove(u);

            // Pour chaque arc (u, v) existant
            for (Arc arc : u.getAdj()) {
                // Si le noeud destination v est encore dans la liste des noeuds à traiter
                if (noeudsATraiter.stream().anyMatch(noeud -> noeud.getNom().equals(arc.getDest()))) {
                    double d = v.getValeur(u.getNom()) + arc.getCout();
                    if (d < v.getValeur(arc.getDest())) {
                        v.setValeur(arc.getDest(), d);
                        v.setParent(arc.getDest(), u.getNom());
                    }
                }
            }
        }
        return v;
    }

}





