import java.util.*;

/**
 * Classe de l'algorithme Dijkstra
 */
public class Dijkstra implements Algorithme {

    /**
     * Méthode pour résoudre le problème du plus court chemin en utilisant l'algorithme de Dijkstra.
     *
     * @param g Le graphe où on va appliquer l'algorithme.
     * @param depart Le noeud de départ pour le chemin.
     * @return L'objet Valeur qui contient les distances minimales et les parents pour chaque noeud.
     */
    public Valeur resoudre(Graphe g, String depart) {
        // Initialiser la structure qui stocke les distances minimales et les parents pour chaque noeud
        Valeur v = new Valeur();

        // Créer une liste pour stocker les noeuds qui restent à traiter
        ArrayList<Noeud> noeudsATraiter = new ArrayList<>(g.getNoeuds());

        // Initialiser la map pour faciliter l'accès aux nœuds par leurs noms
        Map<String, Noeud> noeuds = new HashMap<>();

        // Initialiser la distance de chaque noeud à l'infini et le parent à null
        // Enregistrer également chaque noeud dans la map
        for (Noeud noeud : noeudsATraiter) {
            v.setValeur(noeud.getNom(), Double.POSITIVE_INFINITY);
            v.setParent(noeud.getNom(), null);
            noeuds.put(noeud.getNom(), noeud);
        }

        // La distance du noeud de départ à lui-même est 0
        v.setValeur(depart, 0);

        // Trier la liste des nœuds à traiter en fonction de leur distance
        noeudsATraiter.sort(Comparator.comparing(n -> v.getValeur(n.getNom())));

        // Tant qu'il reste des noeuds à traiter
        while (!noeudsATraiter.isEmpty()) {
            // Trouver le noeud avec la distance la plus courte dans la liste des noeuds à traiter
            // Après le tri, ce noeud est toujours en tête de la liste
            Noeud u = noeudsATraiter.remove(0);

            // Pour chaque voisin v du noeud u
            for (Arc arc : u.getAdj()) {
                // Si le noeud voisin v est encore dans la liste des noeuds à traiter
                if (noeuds.containsKey(arc.getDest())) {
                    // Calculer la distance potentielle à travers le noeud u
                    double d = v.getValeur(u.getNom()) + arc.getCout();

                    // Si cette distance est plus courte, mettre à jour la distance et le parent du noeud v
                    if (d < v.getValeur(arc.getDest())) {
                        v.setValeur(arc.getDest(), d);
                        v.setParent(arc.getDest(), u.getNom());

                        // Trier la liste des nœuds à traiter après la mise à jour de la distance
                        noeudsATraiter.sort(Comparator.comparing(n -> v.getValeur(n.getNom())));
                    }
                }
            }

            // Supprimer le noeud u de la map car il a été traité
            noeuds.remove(u.getNom());
        }

        return v;
    }
}
