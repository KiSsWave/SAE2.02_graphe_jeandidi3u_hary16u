import java.io.*;
import java.util.ArrayList;


public class GrapheListe implements Graphe {
    private ArrayList<String> ensNom;
    private ArrayList<Noeud> ensNoeuds;

    public GrapheListe() {
        this.ensNom = new ArrayList<>();
        this.ensNoeuds = new ArrayList<>();
    }

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

                if (!this.ensNom.contains(noeud1)) {
                    this.ensNom.add(noeud1);
                    this.ensNoeuds.add(new Noeud(noeud1));
                }
                if (!this.ensNom.contains(noeud2)) {
                    this.ensNom.add(noeud2);
                    this.ensNoeuds.add(new Noeud(noeud2));
                }
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

    public ArrayList<Noeud> getNoeuds(){
        return this.ensNoeuds;
    }

}
