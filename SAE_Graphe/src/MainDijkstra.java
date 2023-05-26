import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe principale pour l'exécution de l'algorithme de Dijkstra.
 */
public class MainDijkstra {

    /**
     * Méthode principale du programme.
     *
     * @param args les arguments de la ligne de commande
     */
    public static void main(String[] args) {

        // Initialisation du scanner pour lire l'input utilisateur
        Scanner scanner = new Scanner(System.in);

        // Demande à l'utilisateur le nom du fichier
        System.out.print("Veuillez entrer le nom du fichier: ");
        String nomFichier = scanner.nextLine();

        // Création du graphe à partir du fichier
        GrapheListe graphe = new GrapheListe(nomFichier);

        // Demande à l'utilisateur le noeud de départ
        System.out.print("Veuillez entrer le nom du noeud de départ: ");
        String depart = scanner.nextLine();

        // Calcul des chemins les plus courts à partir du noeud de départ
        Dijkstra dijkstra = new Dijkstra();
        Valeur valeur = dijkstra.resoudre(graphe, depart);

        // Demande à l'utilisateur le noeud de destination
        System.out.print("Veuillez entrer le nom du noeud de destination: ");
        String destination = scanner.nextLine();

        // Calcul et affichage du chemin le plus court
        ArrayList<String> chemin = valeur.calculerChemin(destination);
        System.out.println("Le chemin le plus court de " + depart + " à " + destination + " est : " + chemin);

        // Fermeture du scanner
        scanner.close();
    }
}
