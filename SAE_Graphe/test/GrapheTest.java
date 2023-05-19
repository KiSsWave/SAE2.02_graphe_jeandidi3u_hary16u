import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GrapheTest {

    @Test
    public void testAjouterArc() {
        GrapheListe gr = new GrapheListe();
        gr.ajouterArc("A", "B", 10);
        assertTrue(gr.listeNoeuds().contains("A"));
        assertTrue(gr.listeNoeuds().contains("B"));
    }

    @Test
    public void testSuivants() {
        GrapheListe gr = new GrapheListe();
        gr.ajouterArc("A", "B", 15);
        ArrayList<Arc> arcs = gr.suivants("A");
        assertEquals(1, arcs.size());
        assertEquals("B", arcs.get(0).getDest());
        assertEquals(15, arcs.get(0).getCout());
    }

    @Test
    public void testListeNoeuds() {
        GrapheListe gr = new GrapheListe();
        gr.ajouterArc("A", "B", 12);
        gr.ajouterArc("B", "C", 23);
        gr.ajouterArc("C", "D", 34);
        ArrayList<String> noeud = gr.listeNoeuds();
        assertEquals(4, noeud.size());
        assertTrue(noeud.contains("A"));
        assertTrue(noeud.contains("B"));
        assertTrue(noeud.contains("C"));
        assertTrue(noeud.contains("D"));

    }

}










