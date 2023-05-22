import java.io.IOException;

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
        System.out.println(gr.toGraphviz());
        System.out.println("------------------------");
        GrapheListe grFichier = new GrapheListe("Graphes/Graphe15.txt");
        System.out.println(grFichier.toString());
        System.out.println("------------------------");
        String s = " A B C D E F G";
        String sTab[] = s.split(" ");
        for (String i : sTab) {
            System.out.println(i);
        }
        System.out.println("--------------------");
        GrapheListe.fichierMatrice("GrapheMatrice/fichierMatrice.txt","GrapheMatrice/ecritureFichier.txt");

    }
}

