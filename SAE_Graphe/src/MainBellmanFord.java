import java.util.ArrayList;
import java.util.List;

public class MainBellmanFord {
    public static void main(String[] args) {

        //Creation d'un graphe à partir d'un fichier
        GrapheListe g = new GrapheListe("Graphes/GrapheExemple.txt");

        // Créer une instance de BellmanFord
        BellmanFord bf = new BellmanFord();

        // Résoudre le graphe en partant du noeud 1
        Valeur resultat = bf.resoudre(g, "A");

        // Afficher les valeurs pour chaque noeud
        for (Noeud n : g.getNoeuds()) {
            System.out.println("Noeud: " + n.getNom());
            System.out.println("Distance: " + resultat.getValeur(n.getNom()));
            System.out.println("Parent: " + resultat.getParent(n.getNom()));
            System.out.println("----------------");
        }

    }
}
