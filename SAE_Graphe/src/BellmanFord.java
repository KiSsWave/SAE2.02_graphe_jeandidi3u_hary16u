public class BellmanFord implements Algorithme{

    public Valeur resoudre(Graphe g, String depart) {

        //Initialisation des valeurs
        Valeur val = new Valeur();
        for (Noeud n : g.getNoeuds()) {
            val.setValeur(n.getNom(), Double.POSITIVE_INFINITY);
        }
        val.setValeur(depart, 0.0);

        boolean changer = true;
        while (changer) {
            changer = false;
            for (Noeud n : g.getNoeuds()) {
                for (Arc arc : n.getAdj()) {
                    String destination = arc.getDest();
                    double cout = arc.getCout();
                    if (val.getValeur(n.getNom()) + cout < val.getValeur(destination)) {
                        val.setValeur(destination, val.getValeur(n.getNom()) + cout);
                        val.setParent(destination, n.getNom());
                        changer = true;
                    }
                }
            }
        }
        return val;
    }
}

