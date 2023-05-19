import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe {
    private ArrayList<String> ensNom;
    private ArrayList<Noeud> ensNoeuds;

    public GrapheListe() {
        this.ensNom = new ArrayList<>();
        this.ensNoeuds = new ArrayList<>();
    }

    @Override
    public ArrayList<String> listeNoeuds() {
        return this.ensNom;
    }

    @Override
    public ArrayList<Arc> suivants(String n) {
        for (int i = 0; i < ensNoeuds.size(); i++) {
            if (ensNoeuds.get(i).getNom().equals(n)) {
                return ensNoeuds.get(i).getAdj();
            }
        }
        return null;
    }

    public void ajouterArc(String depart, String destination, double cout) {
        if (!ensNom.contains(depart)) {
            ensNom.add(depart);
            ensNoeuds.add(new Noeud(depart));
        }
        if (!ensNom.contains(destination)) {
            ensNom.add(destination);
            ensNoeuds.add(new Noeud(destination));
        }
        for (int i = 0; i < ensNoeuds.size(); i++) {
            if (ensNoeuds.get(i).getNom().equals(depart)) {
                ensNoeuds.get(i).ajouterArc(destination, cout);
            }
        }
    }
}
