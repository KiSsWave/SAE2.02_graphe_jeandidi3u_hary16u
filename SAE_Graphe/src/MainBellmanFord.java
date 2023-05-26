import java.util.ArrayList;
import java.util.List;

/**
 * Classe principale pour l'exécution de l'algorithme de Bellman-Ford.
 */
public class MainBellmanFord {
    /**
     * Méthode principale du programme.
     *
     * @param args les arguments de la ligne de commande
     */
    public static void main(String[] args) {

        // Création d'un graphe à partir d'un fichier
        GrapheListe g = new GrapheListe("Graphes/GrapheExemple.txt");

        // Créer une instance de BellmanFord
        BellmanFord bf = new BellmanFord();

        // Résoudre le graphe en partant du noeud "A"
        Valeur resultat = bf.resoudre(g, "A");

        // Afficher les valeurs pour chaque noeud
        for (Noeud n : g.getNoeuds()) {
            System.out.println("Noeud: " + n.getNom());
            System.out.println("Parent: " + resultat.getParent(n.getNom()));
            System.out.println("Distance: " + resultat.getValeur(n.getNom()));
            System.out.println("----------------");
        }
    }
}
