public class Main {
    public static void main(String[] args) {
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
    }
}

