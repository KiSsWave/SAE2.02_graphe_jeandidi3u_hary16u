import java.util.ArrayList;

public class MainComparaisonAlgorithme {
    public static void main(String[] args) {
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

        GrapheListe[] tabGraphe = {graphe1,graphe2,graphe3,graphe4,graphe5,graphe6,graphe7,graphe8,graphe9,graphe10,graphe11,graphe12,graphe13,graphe14,graphe15};
        String[] tabNbNoeud = {"3","10","20","30","40","50","100","200","300","400","500","600","700","800","900"};
        for (int i = 0; i < tabGraphe.length; i++) {
            System.out.println("<<< Graphe de " + tabNbNoeud[i] + " noeuds >>>");
            BellmanFord bf = new BellmanFord();
            long debut = System.currentTimeMillis();
            Valeur valeurBellmanFord = bf.resoudre(tabGraphe[i], depart);
            long fin = System.currentTimeMillis();
            long tempsBellmanFord = fin - debut;
            System.out.println("Temps d'exécution (BellmanFord) : " + tempsBellmanFord + " ms");

            Dijkstra dj = new Dijkstra();
            debut = System.currentTimeMillis();
            Valeur valeurDijkstra = dj.resoudre(tabGraphe[i], depart);
            fin = System.currentTimeMillis();
            long tempsDijkstra = fin - debut;
            System.out.println("Temps d'exécution (Dijkstra) : " + tempsDijkstra + " ms");
            System.out.println(' ');
        }
    }
}


