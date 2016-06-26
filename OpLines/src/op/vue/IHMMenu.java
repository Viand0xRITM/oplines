package op.vue;

import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import op.vue.panel.PanelChaine;
import op.vue.panel.PanelCommande;
import op.controleur.MenuControleur;
import op.modele.Chaine;
import op.modele.Commande;
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
        panelChaine = new PanelChaine("Liste des Chaines de production", monControleur);
        panelChaine.setLayout(new BoxLayout(panelChaine, BoxLayout.Y_AXIS));
        panelCommande = new PanelCommande("Liste des Commandes", monControleur);
        panelCommande.setLayout(new BoxLayout(panelCommande, BoxLayout.Y_AXIS));
        
        panelRecap.add(panelChaine);
        panelRecap.add(panelCommande);
        
        // Panel de boutons
        panelBoutons = new JPanel();
        panelBoutons.setLayout(new BoxLayout(panelBoutons, BoxLayout.X_AXIS));
        boutonLancerSimu = new JButton();
        boutonLancerSimu.setText("Lancer simulation");
        boutonLancerSimu.addActionListener(monControleur);
        panelBoutons.add(boutonLancerSimu);
        
        conteneur.add(titrePanel);
        conteneur.add(panelRecap);
        conteneur.add(panelBoutons);
        add(conteneur);
        pack();
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
    public int addChaine(int vit){
        return this.panelChaine.addChaine(vit);
    }
    public int deleteSelectedChaine(){
        return this.panelChaine.deleteSelectedChaine();
    }
    public int deleteSelectedCommande(){
        return this.panelCommande.deleteSelectedCommande();
    }
    public ArrayList<Chaine> getChaines(){
        ArrayList<Chaine> result = new ArrayList();
        DefaultTableModel dtm = this.panelChaine.getTableModel();
        for (int i=0; i< dtm.getRowCount();i++){
            result.add(new Chaine(Integer.valueOf(dtm.getValueAt(i, 0).toString()),Integer.valueOf(dtm.getValueAt(i, 1).toString()) ));
        }
        return result;
    }
    
    public Commande getCommande() {
        Commande cmd = new Commande();
        DefaultTableModel dtm = this.panelCommande.getTableModel();
        for (int i=0; i< dtm.getRowCount();i++){
            int id = Integer.valueOf(dtm.getValueAt(i, 0).toString());
            int qte = Integer.valueOf(dtm.getValueAt(i, 1).toString());
            int vitesse = Integer.valueOf(dtm.getValueAt(i, 2).toString());
            Produit prd = new Produit(id, vitesse);
            cmd.addProduct(prd, qte);
        }
        return cmd;
    }
}
