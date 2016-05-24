package op.vue;

import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import op.vue.panel.PanelChaine;
import op.vue.panel.PanelCommande;
import op.controleur.MenuControleur;
import op.modele.Produit;

/**
 *
 * @author Antoine
 */
public class IHMMenu extends JFrame {
    
    private MenuControleur monControleur;
    
    private JPanel conteneur;
    
    private JPanel titrePanel;
    private JLabel titreLabel;
    
    private JPanel panelBoutons;
    private JButton boutonLancerSimu;
    
    private JPanel panelRecap;
    private PanelChaine panelChaine;
    private PanelCommande panelCommande;
    
    public IHMMenu(MenuControleur controleur) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        monControleur = controleur;
        conteneur = new JPanel();
        conteneur.setLayout(new BoxLayout(conteneur, BoxLayout.Y_AXIS));
        
        //titre
        titrePanel = new JPanel();
        titreLabel = new JLabel("Menu");
        titrePanel.add(titreLabel);
        
        //recap
        panelRecap = new JPanel();
        panelRecap.setLayout(new BoxLayout(panelRecap, BoxLayout.X_AXIS));
        panelChaine = new PanelChaine("Liste des Chaines de production", controleur);
        panelChaine.setLayout(new BoxLayout(panelChaine, BoxLayout.Y_AXIS));
        panelCommande = new PanelCommande("Liste des Commandes", controleur);
        panelCommande.setLayout(new BoxLayout(panelCommande, BoxLayout.Y_AXIS));
        
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
    public void ajoutChaine(){
        
    }
    public void ajoutChaines(){
        
    }
    public void setProduits(ArrayList<Produit> liste){
        panelCommande.setListeProduit(liste);
    }
    public String getQuantite(){
        return panelCommande.getQuantite();
    }
    public int getProduitId(){
        return panelCommande.getProduitId();
    }
    public void addCommande(String id, String qte, String vit){
        this.panelCommande.addCommande(id,qte,vit);
    }
    public String getVitesse(){
        return panelChaine.getVitesse();
    }
    public int getNbChaines(){
        return panelChaine.getNbChaines();
    }
    public void addChaine(int id,int vit){
        
    }
}
