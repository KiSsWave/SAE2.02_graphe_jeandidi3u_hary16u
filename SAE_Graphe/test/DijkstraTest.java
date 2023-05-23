import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class DijkstraTest {

    @Test
    public void testDijkstra() {

        // Création d'un graphe de test
        GrapheListe grapheTest = new GrapheListe("Graphes/GrapheExemple.txt");

        // Test de l'algorithme Dijkstra
        Dijkstra dijkstra = new Dijkstra();
        Valeur valeur = dijkstra.resoudre(grapheTest, "A");

        ArrayList<String> chemin = valeur.calculerChemin("B");

        // Vérification que le chemin le plus court de A à B est celui attendu
        ArrayList<String> cheminAttendu = new ArrayList<>();
        cheminAttendu.add("A");
        cheminAttendu.add("B");
        assertEquals(cheminAttendu, chemin);

        // Teste le chemin le plus court de A à D.
        chemin = valeur.calculerChemin("D");

        // Vérification que le chemin le plus court de A à D est celui attendu
        cheminAttendu = new ArrayList<>();
        cheminAttendu.add("A");
        cheminAttendu.add("B");
        cheminAttendu.add("E");
        cheminAttendu.add("D");
        assertEquals(cheminAttendu, chemin);

        // Teste le chemin le plus court de C à D.
        valeur = dijkstra.resoudre(grapheTest, "E");
        chemin = valeur.calculerChemin("B");

        // Vérification que le chemin le plus court de E à B est celui attendu
        cheminAttendu = new ArrayList<>();
        cheminAttendu.add("E");
        cheminAttendu.add("D");
        cheminAttendu.add("B");
        assertEquals(cheminAttendu, chemin);
    }
}

