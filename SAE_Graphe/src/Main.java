import java.io.IOException;

public class Main {
    /**
     * Méthode principale du programme.
     *
     * @param args les arguments de la ligne de commande
     * @throws IOException en cas d'erreur d'entrée/sortie
     */
    public static void main(String[] args) throws IOException {

        // Création d'un graphe et ajout d'arcs
        GrapheListe gr = new GrapheListe();
        gr.ajouterArc("A", "B", 12);
        gr.ajouterArc("A", "D", 87);
        gr.ajouterArc("B", "E", 11);
        gr.ajouterArc("C", "A", 19);
        gr.ajouterArc("D", "B", 23);
        gr.ajouterArc("D", "C", 10);
        gr.ajouterArc("E", "D", 43);

        // Affichage du graphe
        System.out.println(gr.toString());

        System.out.println("------------------------");

        // Affichage du graphe au format Graphviz
        System.out.println(gr.toGraphviz());

        System.out.println("------------------------");

        // Chargement d'un graphe à partir d'un fichier et affichage
        GrapheListe grFichier = new GrapheListe("Graphes/Graphe15.txt");
        System.out.println(grFichier.toString());

        System.out.println("------------------------");

        // Génération d'un fichier d'arcs à partir d'un fichier de matrice
        GrapheListe.fichierMatrice("GrapheMatrice/fichierMatrice.txt", "GrapheMatrice/ecritureFichier.txt");

        // Génération d'un graphe aléatoire avec 3 nœuds
        System.out.println(GrapheListe.genererGraphe(3, "1", "3").toGraphviz());
        System.out.println("-------------------");

        // Génération d'un graphe aléatoire avec 8 nœuds
        System.out.println(GrapheListe.genererGraphe(8, "1", "8").toGraphviz());
        System.out.println("-------------------");

        // Génération d'un graphe aléatoire avec 15 nœuds
        System.out.println(GrapheListe.genererGraphe(15, "1", "15").toGraphviz());
    }
}

