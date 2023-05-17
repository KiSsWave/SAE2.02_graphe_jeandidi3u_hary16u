import java.util.ArrayList;

public class Noeud {

    private String nom;

    private ArrayList<Arc> adj;

    public Noeud(String n){
        this.nom = n;
        this.adj = new ArrayList<Arc>();
    }

    public boolean equals(String o){
        return this.nom == o;
    }

    public void ajouterArc(String destination, double cout) {
        this.adj.add(new Arc(destination, cout));
    }

    public String getNom(){
        return this.nom;
    }

    public ArrayList<Arc> getAdj(){
        return this.adj;
    }
}
