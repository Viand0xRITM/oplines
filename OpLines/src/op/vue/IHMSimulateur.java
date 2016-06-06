package op.vue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import op.controleur.SimulateurControleur;

public class IHMSimulateur extends JFrame{
    
    private SimulateurControleur monControleur;
    
    private JPanel conteneur;
    //titre
    private JPanel titrePanel;
    private JLabel titreLabel;
    //Progress Bar
    private JPanel pbarPanel;
    private JLabel pbarLabel;
    private JProgressBar pbar;
    
    public IHMSimulateur(SimulateurControleur monControleur){
        this.monControleur = monControleur;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        conteneur = new JPanel();
        conteneur.setLayout(new BoxLayout(conteneur, BoxLayout.Y_AXIS));
        
        //titre
        titrePanel = new JPanel();
        titreLabel = new JLabel("Simulateur");
        titrePanel.add(titreLabel);
        
        //Progress Bar
        pbarPanel = new JPanel();
        pbarLabel = new JLabel("Avancement total");
        pbar = new JProgressBar(0, 100);
        pbarPanel.add(pbarLabel);
        pbarPanel.add(pbar);
        
        //Ajout des conteneur
        this.conteneur.add(titrePanel);
        this.conteneur.add(pbarPanel);
        
        //ajout DU conteneur
        add(conteneur);
        pack();
    }
}
