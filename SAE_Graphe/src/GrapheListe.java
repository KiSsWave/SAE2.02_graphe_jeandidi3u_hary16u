import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Classe représentant un graphe sous forme de liste d'adjacence.
 */
public class GrapheListe implements Graphe {
    private ArrayList<String> ensNom;
    private ArrayList<Noeud> ensNoeuds;

    /**
     * Constructeur par défaut de la classe GrapheListe.
     */
    public GrapheListe() {
        this.ensNom = new ArrayList<>();
        this.ensNoeuds = new ArrayList<>();
    }

    /**
     * Constructeur de la classe GrapheListe qui charge un graphe à partir d'un fichier.
     *
     * @param nomFichier le nom du fichier contenant le graphe
     */
    public GrapheListe(String nomFichier) {
        this.ensNom = new ArrayList<>();
        this.ensNoeuds = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nomFichier))) {
            String ligne = br.readLine();
            while (ligne != null) {
                String[] partie = ligne.split("\t");
                String noeud1 = partie[0];
                String noeud2 = partie[1];
                double cost = Double.parseDouble(partie[2]);

                // Vérifie si les nœuds existent déjà dans la liste d'adjacence, sinon les ajoute
                if (!this.ensNom.contains(noeud1)) {
                    this.ensNom.add(noeud1);
                    this.ensNoeuds.add(new Noeud(noeud1));
                }
                if (!this.ensNom.contains(noeud2)) {
                    this.ensNom.add(noeud2);
                    this.ensNoeuds.add(new Noeud(noeud2));
                }

                // Ajoute l'arc entre les nœuds dans la liste d'adjacence
                int index = this.ensNom.indexOf(noeud1);
                this.ensNoeuds.get(index).ajouterArc(noeud2, cost);

                ligne = br.readLine();
            }
        } catch(FileNotFoundException e) {
            System.out.println("Fichier introuvable.");
        } catch (IOException e) {
            System.out.println("Erreur dans la lecture du fichier.");
        }
    }

    @Override
/**
 * Retourne la liste des nœuds présents dans le graphe.
 *
 * @return la liste des nœuds du graphe
 */
    public ArrayList<String> listeNoeuds() {
        return this.ensNom;
    }

    @Override
/**
 * Retourne la liste des arcs sortants du nœud spécifié dans le graphe.
 *
 * @param n le nom du nœud dont on souhaite obtenir les arcs sortants
 * @return la liste des arcs sortants du nœud spécifié, ou null si le nœud n'est pas présent dans le graphe
 */
    public ArrayList<Arc> suivants(String n) {
        for (int i = 0; i < ensNoeuds.size(); i++) {
            if (ensNoeuds.get(i).getNom().equals(n)) {
                return ensNoeuds.get(i).getAdj();
            }
        }
        return null;
    }

    /**
     * Ajoute un arc entre deux nœuds avec un coût spécifié.
     *
     * @param depart      le nœud de départ de l'arc
     * @param destination le nœud de destination de l'arc
     * @param cout        le coût de l'arc
     */
    public void ajouterArc(String depart, String destination, double cout) {
        if (!ensNom.contains(depart)) { //Si le nœud n'existe pas dans le graphe -> création du nœud
            ensNom.add(depart);
            ensNoeuds.add(new Noeud(depart));
        }
        if (!ensNom.contains(destination)) { //Si la destination n'existe pas dans le graphe -> création de la destination
            ensNom.add(destination);
            ensNoeuds.add(new Noeud(destination));
        }
        for (Noeud ensNoeud : ensNoeuds) { //Ajout de l'arc partant du depart et arrivant à la destination dans le graphe
            if (ensNoeud.getNom().equals(depart)) {
                ensNoeud.ajouterArc(destination, cout);
            }
        }
    }

    /**
     * Retourne un affichage textuel du graphe.
     *
     * @return un affichage textuel du graphe
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Noeud noeud : ensNoeuds) {
            sb.append(noeud.getNom()).append(" -> ");
            for (Arc arc : noeud.getAdj()) {
                sb.append(arc.getDest()).append("(").append((int)arc.getCout()).append(") ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Retourne une représentation du graphe au format Graphviz.
     *
     * @return la représentation du graphe au format Graphviz
     */
    public String toGraphviz() {
        StringBuilder sb = new StringBuilder("digraph G {\n");
        for (Noeud noeud : ensNoeuds) {
            for (Arc arc : noeud.getAdj()){
                sb.append(noeud.getNom()).append(" -> ");
                sb.append(arc.getDest()).append(" [label = ").append((int)arc.getCout()).append("]\n");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    /**
     * Génère un fichier d'arcs à partir d'un fichier de matrice.
     *
     * @param matriceFichier le nom du fichier de matrice
     * @param arcFichier     le nom du fichier d'arcs à générer
     */
    public static void fichierMatrice(String matriceFichier, String arcFichier) {
        try (BufferedReader br = new BufferedReader(new FileReader(matriceFichier));
             BufferedWriter bw = new BufferedWriter(new FileWriter(arcFichier))) {

            // Lire la première ligne du fichier qui contient les noms des noeuds.
            String[] noeuds = br.readLine().split("\\s+");

            String ligne;
            while ((ligne = br.readLine()) != null) {
                // diviser la ligne en un tableau de chaînes.
                String[] partie = ligne.split("\\s+");

                // L'indice du noeud source dans le tableau noeuds.
                int index = -1;
                for (int i = 0; i < noeuds.length; i++) {
                    if (noeuds[i].equals(partie[0])) {
                        index = i;
                        break;
                    }
                }
                // Écrire les arcs dans le fichier de sortie.
                for (int i = 1; i < partie.length; i++) {
                    // Si le coût n'est pas 0, écrire l'arc dans le fichier de sortie.
                    double cout = Double.parseDouble(partie[i]);
                    if (cout != 0) {
                        bw.write(noeuds[index] + " " + noeuds[i] + " " + cout + "\n");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fichier non trouvé");
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture/écriture du fichier: ");
        }
    }

    /**
     * Génère un graphe aléatoire avec un nombre de nœud précis.
     *
     * @param taille   la taille du graphe à générer (le nombre de nœuds)
     * @param depart   le nom du nœud de départ
     * @param arrivee  le nom du nœud d'arrivée
     * @return le graphe généré
     */
    public static GrapheListe genererGraphe(int taille, String depart, String arrivee) {
        // Création d'un graphe vide
        GrapheListe graphe = new GrapheListe();

        // Création d'une variable aléatoire
        Random random = new Random();

        // Création de l'arc entre le noeud de départ et celui d'arrivée avec un coût aléatoire
        double cout = 1 + random.nextInt(25);
        graphe.ajouterArc(depart, arrivee, cout);
        if (random.nextBoolean()) {
            graphe.ajouterArc(arrivee, depart, cout); // Arc dans la direction opposée
        }

        // Ajout des nœuds restants
        for (int i = 2; i < taille; i++) {
            String nouveauNoeud = String.valueOf(i);

            // Assurer qu'au moins un noeud existant pointe vers le nouveau noeud
            String noeudExistant = graphe.getNoeuds().get(random.nextInt(graphe.getNoeuds().size())).getNom();
            cout = 1 + random.nextInt(25);
            graphe.ajouterArc(noeudExistant, nouveauNoeud, cout);
            if (random.nextBoolean()) {
                graphe.ajouterArc(nouveauNoeud, noeudExistant, cout); // Arc dans la direction opposée
            }

            // Assurer qu'au moins le nouveau noeud pointe vers un noeud existant
            noeudExistant = graphe.getNoeuds().get(random.nextInt(graphe.getNoeuds().size())).getNom();
            while (noeudExistant.equals(nouveauNoeud)) {
                noeudExistant = graphe.getNoeuds().get(random.nextInt(graphe.getNoeuds().size())).getNom();
            }
            cout = 1 + random.nextInt(25);
            graphe.ajouterArc(nouveauNoeud, noeudExistant, cout);
            if (random.nextBoolean()) {
                graphe.ajouterArc(noeudExistant, nouveauNoeud, cout); // Arc dans la direction opposée
            }
        }

        return graphe;
    }

    /**
     * Retourne la liste des nœuds du graphe.
     *
     * @return la liste des nœuds du graphe
     */
    public ArrayList<Noeud> getNoeuds() {
        return this.ensNoeuds;
    }
}
