package op.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import op.modele.Produit;
import op.vue.IHMMenu;

public class MenuControleur implements ActionListener {
    private IHMMenu ihm;
    private ProduitControleur mProduitControleur;
    private SimulateurControleur mSimulateurControleur;
    
    public MenuControleur(ProduitControleur mProduitControleur, SimulateurControleur mSimulateurControleur){
        this.ihm = new IHMMenu(this);
        this.ihm.setVisible(true);
        this.mProduitControleur = mProduitControleur;
        this.mSimulateurControleur = mSimulateurControleur;
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
                //get Item Selected
                int id = ihm.getProduitId();
                //get Vitesse
                ArrayList<Produit> list = mProduitControleur.getListeProduits();
                int i=0;
                //System.out.println(id);
                while (list.get(i).getId() != id){
                    //System.out.println(list.get(i).getId());
                    i++;
                }
                // On injecte dans la vue
                this.ihm.addCommande(String.valueOf(id), String.valueOf(qte),String.valueOf(list.get(i).getTempsProduction()));
                System.out.println("Commande ajoutée");
            }catch(NumberFormatException | NullPointerException e1) {}
        }else if (command.equals("Ajouter Chaine")) {
            try{
                int vit = Integer.parseInt(ihm.getVitesse());
                this.ihm.addChaine(vit);
            }catch(NumberFormatException | NullPointerException e1) {}
        } else if (command.equals("Supprimer Chaine")){
            this.ihm.deleteSelectedChaine();
        } else if (command.equals("Supprimer Commande")){
            this.ihm.deleteSelectedCommande();
        } else if (command.equals("Lancer simulation")){
            mSimulateurControleur.start();
            this.ihm.setVisible(false);
        } else {
            System.out.println("Inconnue au bataillon");
        }
    }
}
