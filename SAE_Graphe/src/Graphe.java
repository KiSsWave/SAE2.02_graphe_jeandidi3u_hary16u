import java.util.ArrayList;

public interface Graphe {

    public ArrayList<String> listeNoeuds();

    public ArrayList<Arc> suivants(String n);

    public ArrayList<Noeud> getNoeuds();






}
