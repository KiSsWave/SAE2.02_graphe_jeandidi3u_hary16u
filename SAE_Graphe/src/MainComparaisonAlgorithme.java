import java.util.ArrayList;

/**
 * Classe de programme principal
 */
public class MainComparaisonAlgorithme {
    /**
     * Classe main qui compare les deux algorithmes (Bellman-Ford et Dijkstra)
     * @param args arguments en ligne de commande
     */
    public static void main(String[] args) {
    // Création des graphes avec un fichier
        // Création d'un graphe avec 3 noeuds
        GrapheListe graphe1 = new GrapheListe("Graphes/Graphe5.txt");

        // Création d'un graphe avec 10 noeuds
        GrapheListe graphe2 = new GrapheListe("Graphes/Graphe15.txt");

        // Création d'un graphe avec 20 noeuds
        GrapheListe graphe3 = new GrapheListe("Graphes/Graphe25.txt");

        // Création d'un graphe avec 30 noeuds
        GrapheListe graphe4 = new GrapheListe("Graphes/Graphe35.txt");

        // Création d'un graphe avec 40 noeuds
        GrapheListe graphe5 = new GrapheListe("Graphes/Graphe45.txt");

        // Création d'un graphe avec 50 noeuds
        GrapheListe graphe6 = new GrapheListe("Graphes/Graphe55.txt");

        // Création d'un graphe avec 100 noeuds
        GrapheListe graphe7 = new GrapheListe("Graphes/Graphe105.txt");

        // Création d'un graphe avec 200 noeuds
        GrapheListe graphe8 = new GrapheListe("Graphes/Graphe205.txt");

        // Création d'un graphe avec 300 noeuds
        GrapheListe graphe9 = new GrapheListe("Graphes/Graphe305.txt");

        // Création d'un graphe avec 400 noeuds
        GrapheListe graphe10 = new GrapheListe("Graphes/Graphe405.txt");

        // Création d'un graphe avec 500 noeuds
        GrapheListe graphe11 = new GrapheListe("Graphes/Graphe505.txt");

        // Création d'un graphe avec 600 noeuds
        GrapheListe graphe12 = new GrapheListe("Graphes/Graphe605.txt");

        // Création d'un graphe avec 700 noeuds
        GrapheListe graphe13 = new GrapheListe("Graphes/Graphe705.txt");

        // Création d'un graphe avec 800 noeuds
        GrapheListe graphe14 = new GrapheListe("Graphes/Graphe805.txt");

        // Création d'un graphe avec 900 noeuds
        GrapheListe graphe15 = new GrapheListe("Graphes/Graphe905.txt");

        //Initialisation de la valeur de départ
        String depart = "1";

        //Mise en place des graphes dans un tableau
        GrapheListe[] tabGraphe = {graphe1,graphe2,graphe3,graphe4,graphe5,graphe6,graphe7,graphe8,graphe9,graphe10,graphe11,graphe12,graphe13,graphe14,graphe15};
        String[] tabNbNoeud = {"3","10","20","30","40","50","100","200","300","400","500","600","700","800","900"};
        //Mise en place des variables de temps
        long debut;
        long fin;
        //Boucle d'affichage des temps d'execution
        for (int i = 0; i < tabGraphe.length; i++) {
            System.out.println("<<< Graphe de " + tabNbNoeud[i] + " noeuds >>>");
            BellmanFord bf = new BellmanFord();
            //Mesure du temps d'execution de l'algorithme de BellmanFord sur les différents graphes
            debut = System.nanoTime();
            Valeur valeurBellmanFord = bf.resoudre(tabGraphe[i], depart);
            fin = System.nanoTime();
            long tempsBellmanFord = fin - debut;
            System.out.println("Temps d'exécution (BellmanFord) : " + tempsBellmanFord + " ns");

            Dijkstra dj = new Dijkstra();
            //Mesure du temps d'execution de l'algorithme de Dijkstra sur les différents graphes
            debut = System.nanoTime();
            Valeur valeurDijkstra = dj.resoudre(tabGraphe[i], depart);
            fin = System.nanoTime();
            long tempsDijkstra = fin - debut;
            System.out.println("Temps d'exécution (Dijkstra) : " + tempsDijkstra + " ns");
            System.out.println(' ');
        }

        // Création des graphes avec la méthode pour générer des graphes aléatoires
        GrapheListe grapheA1 = GrapheListe.genererGraphe(3,"1","3");
        GrapheListe grapheA2 = GrapheListe.genererGraphe(5,"1","5");
        GrapheListe grapheA3 = GrapheListe.genererGraphe(7,"1","7");
        GrapheListe grapheA4 = GrapheListe.genererGraphe(20,"1","20");
        GrapheListe grapheA5 = GrapheListe.genererGraphe(100,"1","100");
        GrapheListe grapheA6 = GrapheListe.genererGraphe(200,"1","200");
        GrapheListe[] tabGrapheA = {grapheA1,grapheA2,grapheA3,grapheA4,grapheA5};
        String[] tabNomA = {"3","5","7","20","100","200"};
        for (int i = 0; i < tabGrapheA.length; i++) {
            System.out.println("<<< Graphe de " + tabNomA[i] + " noeuds >>>");
            BellmanFord bf = new BellmanFord();
            //Mesure du temps d'execution de l'algorithme de BellmanFord sur les différents graphes
            debut = System.nanoTime();
            Valeur valeurBellmanFord = bf.resoudre(tabGrapheA[i], depart);
            fin = System.nanoTime();
            long tempsBellmanFord = fin - debut;
            System.out.println("Temps d'exécution (BellmanFord) : " + tempsBellmanFord + " ns");

            Dijkstra dj = new Dijkstra();
            //Mesure du temps d'execution de l'algorithme de Dijkstra sur les différents graphes
            debut = System.nanoTime();
            Valeur valeurDijkstra = dj.resoudre(tabGrapheA[i], depart);
            fin = System.nanoTime();
            long tempsDijkstra = fin - debut;
            System.out.println("Temps d'exécution (Dijkstra) : " + tempsDijkstra + " ns");
            System.out.println(' ');
        }

    }
}


