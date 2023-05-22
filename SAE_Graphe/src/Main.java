import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        GrapheListe gr = new GrapheListe();
        gr.ajouterArc("A", "B", 12);
        gr.ajouterArc("A", "D", 87);
        gr.ajouterArc("B", "E", 11);
        gr.ajouterArc("C", "A", 19);
        gr.ajouterArc("D", "B", 23);
        gr.ajouterArc("D", "C", 10);
        gr.ajouterArc("E", "D", 43);
        System.out.println(gr.toString());

        System.out.println("------------------------");
        System.out.println(gr.toGraphviz());

        System.out.println("------------------------");
        GrapheListe grFichier = new GrapheListe("Graphes/Graphe15.txt");
        System.out.println(grFichier.toString());

        //
        GrapheListe.fichierMatrice("GrapheMatrice/fichierMatrice.txt","GrapheMatrice/ecritureFichier.txt");

    }
}

