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
                // TODO
                //get Item Selected
                int id = ihm.getProduitId();
                        
                // On injecte
                this.ihm.addCommande(String.valueOf(id), String.valueOf(qte),"10");
                System.out.println("Commande ajoutée");
                // Ajouter la fonction dans le controleur
            }catch(NumberFormatException | NullPointerException e1) {}
        }else if (command.equals("Ajouter Chaine")) {
            try{
                int vit = Integer.parseInt(ihm.getVitesse());
                int nbChaine = this.ihm.getNbChaines();
                this.ihm.addChaine(nbChaine+1,vit);
            }catch(NumberFormatException | NullPointerException e1) {}
        } else {
            System.out.println("Inconnue au bataillon");
        }
    }
}
