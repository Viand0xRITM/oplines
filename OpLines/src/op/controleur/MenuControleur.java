package op.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import op.modele.Produit;
import op.vue.IHMMenu;

public class MenuControleur implements ActionListener {
    private IHMMenu ihm;
    private ProduitControleur mProduitControleur;
    
    public MenuControleur(ProduitControleur mProduitControleur){
        this.ihm = new IHMMenu(this);
        this.ihm.setVisible(true);
        this.mProduitControleur = mProduitControleur;
        ArrayList<Produit> list = mProduitControleur.getListeProduits();
        this.ihm.setProduits(list);
    }
    public MenuControleur(IHMMenu ihm){
        this.ihm = ihm;
    }
    public void afficherEcran(){
        this.ihm.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        if (command.equals("Ajouter Commande")) {
            // vérification de paramètres
            try{
                //is Integer
                int qte = Integer.parseInt(ihm.getQuantite());
                //get Vitesse
                int id = ihm.getProduitId();
                this.ihm.addCommande(String.valueOf(id), String.valueOf(qte),"10");
                System.out.println("Commande ajoutée");
            }catch(NumberFormatException | NullPointerException e1) {
                
            }
// ajout de la commande
            
// ajout de la commande
        }else if (command.equals("Ajouter Chaine")) {
            System.out.println("AjouterCommande");
        } else {
            System.out.println("Inconnue au bataillon");
        }
    }
}
