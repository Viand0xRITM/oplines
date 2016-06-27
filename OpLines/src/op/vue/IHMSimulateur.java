package op.vue;

import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import op.controleur.SimulateurControleur;
import op.modele.Chaine;
import op.modele.CommandeLigne;
import op.modele.CommandeProduite;
import op.vue.panel.PanelChaineSimulation;
import op.vue.panel.PanelCommandeSimulation;

public class IHMSimulateur extends JFrame{
    
    private SimulateurControleur monControleur;
    
    private JPanel conteneur;
    //titre
    private JPanel titrePanel;
    private JLabel titreLabel;
    private JButton startButton;
    //Progress Bar
    private JPanel pbarPanel;
    private JLabel pbarLabel;
    private JProgressBar pbar;
    
    private PanelCommandeSimulation panelCommande;
   
    //temp
    private JPanel chainesPanel;
    private ArrayList<PanelChaineSimulation> listeChaines;
    
    public IHMSimulateur(SimulateurControleur monControleur, ArrayList<Chaine> listeC, ArrayList<CommandeLigne> listeCommande){
        this.monControleur = monControleur;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        conteneur = new JPanel();
        conteneur.setLayout(new BoxLayout(conteneur, BoxLayout.Y_AXIS));
        
        //titre
        titrePanel = new JPanel();
        titreLabel = new JLabel("Simulateur");
        titrePanel.add(titreLabel);
        //Bouton de lancement
        startButton = new JButton("Lancer la simulation");
        startButton.addActionListener(this.monControleur);
        
        //Progress Bar
        pbarPanel = new JPanel();
        pbarLabel = new JLabel("Avancement total");
        pbar = new JProgressBar(0, 100);
        pbar.setStringPainted(true);
        pbarPanel.add(pbarLabel);
        pbarPanel.add(pbar);
        
        //Ajout des conteneur
        this.conteneur.add(titrePanel);
        this.conteneur.add(startButton);
        this.conteneur.add(pbarPanel);
        
        this.chainesPanel = new JPanel();
        this.chainesPanel.setLayout(new BoxLayout(this.chainesPanel, BoxLayout.X_AXIS));
        this.listeChaines = new ArrayList();
        for (Chaine ch:  listeC){
            this.listeChaines.add(new PanelChaineSimulation( String.valueOf(ch.getIdChaine()) ));
            this.chainesPanel.add(this.listeChaines.get(this.listeChaines.size()-1));
        }
        
        this.panelCommande = new PanelCommandeSimulation(listeCommande);
        this.conteneur.add(this.panelCommande);
        this.conteneur.add(this.chainesPanel);
        //ajout du conteneur
        add(this.conteneur);
        pack();
    }
    
    public void changerStatutBouton(boolean statut){
        startButton.setEnabled(statut);
    }

    public void refreshIHM(ArrayList<CommandeLigne> liste, float progress, ArrayList<CommandeProduite> cp) {
        
        this.panelCommande.refreshCommandeAffiche(liste,cp);
        this.pbar.setValue((int)progress);
    }

    public void init() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
