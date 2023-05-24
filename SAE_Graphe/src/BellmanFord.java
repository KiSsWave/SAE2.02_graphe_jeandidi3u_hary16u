public class BellmanFord implements Algorithme{
    public  Valeur resoudre(Graphe g, String depart) {
        //Initialisation de la valeur
        Valeur val = new Valeur();
        //Initialiser le compteur d'iteration
        //int iteration = 0;
        for (Noeud n : g.getNoeuds()) {
            val.setValeur(n.getNom(), Double.MAX_VALUE);
        }
        val.setValeur(depart, 0.0);
        boolean changer = true;
        while (changer) {
            //Afficher la nouvelle itération
            //iteration++;
            //System.out.println("Itération " + iteration + ": \n" + val);
            changer = false;
            for (Noeud n : g.getNoeuds()) {
                for (Arc arc : n.getAdj()) {
                    String destination = arc.getDest();
                    double cout = arc.getCout();
                    double estimation = val.getValeur(n.getNom()) + cout;
                    if (estimation < val.getValeur(destination)) {
                        val.setValeur(destination, estimation);
                        val.setParent(destination, n.getNom());
                        changer = true;
                    }
                }
            }
        }
        return val;
    }
}



