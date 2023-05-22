import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class BellmanFordTest {
    @Test
    public void testResoudre() {
        // Créer un graphe
        GrapheListe gr = new GrapheListe();


        // Ajouter des noeuds et des arcs au graphe
        gr.ajouterArc("1","2",5);
        gr.ajouterArc("2","3",6);
        gr.ajouterArc("3","4",7);
        gr.ajouterArc("4","1",8);

        // Créer une instance de BellmanFord
        BellmanFord bf = new BellmanFord();

        // Résoudre le graphe en partant du noeud 1
        Valeur resultat = bf.resoudre(gr, "1");

        // Vérifier les valeurs pour chaque noeud
        assertEquals(0, resultat.getValeur("1"));
        assertEquals(5, resultat.getValeur("2"));
        assertEquals(11, resultat.getValeur("3"));
        assertEquals(18, resultat.getValeur("4"));

        // Vérifier les parents pour chaque noeud
        assertEquals(null, resultat.getParent("1"));
        assertEquals("1", resultat.getParent("2"));
        assertEquals("2", resultat.getParent("3"));
        assertEquals("3", resultat.getParent("4"));
    }
}
