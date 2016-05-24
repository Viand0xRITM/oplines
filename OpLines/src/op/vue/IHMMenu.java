package op.vue;

import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Antoine
 */
public class IHMMenu extends JFrame {
    
    private JPanel conteneur;
    
    private JPanel titrePanel;
    private JLabel titreLabel;
    
    private JPanel panelBoutons;
    private JButton boutonLancerSimu;
    
    private JPanel panelRecap;
    private JPanel panelChaine;
    private JPanel panelCommande;
    private JTable tableChaine;
    private JTable tableCommande;
    
    public IHMMenu() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        conteneur = new JPanel();
        conteneur.setLayout(new BoxLayout(conteneur, BoxLayout.Y_AXIS));
        
        //titre
        titrePanel = new JPanel();
        titreLabel = new JLabel("Menu");
        titrePanel.add(titreLabel);
        
        //recap
        panelRecap = new JPanel();
        panelRecap.setLayout(new BoxLayout(panelRecap, BoxLayout.X_AXIS));
        panelChaine = new JPanel();
        panelChaine.setLayout(new BoxLayout(panelChaine, BoxLayout.Y_AXIS));
        panelCommande = new JPanel();
        panelCommande.setLayout(new BoxLayout(panelCommande, BoxLayout.Y_AXIS));
        tableChaine = new JTable();
        panelChaine.add(new JScrollPane(tableChaine));
        tableCommande = new JTable();
        panelCommande.add(new JScrollPane(tableCommande));
        panelRecap.add(panelChaine);
        panelRecap.add(panelCommande);
        
        // Panel de boutons
        panelBoutons = new JPanel();
        panelBoutons.setLayout(new BoxLayout(panelBoutons, BoxLayout.X_AXIS));
        boutonLancerSimu = new JButton();
        boutonLancerSimu.setText("Lancer simulation");
        panelBoutons.add(boutonLancerSimu);
        
        conteneur.add(titrePanel);
        conteneur.add(panelRecap);
        conteneur.add(panelBoutons);
        add(conteneur);
        pack();
    }
    
    /*public void putCommandes(ArrayList<Commande> listeCommandes){
        //créer un tableau pour chaque commande
        //puis créer un tableau où stocker chacun des tableaux créés précédemment
        //Object [];
                
       // tableCommande
    }*/
}
