package op.lanceur;

import java.util.ArrayList;
import op.controleur.MenuControleur;
import op.controleur.ProduitControleur;
import op.controleur.SimulateurControleur;

//TEST
import op.modele.Produit;
import op.modele.Commande;
import op.modele.Chaine;
import op.controleur.thread.ThreadControleur;


/**
 *
 * @author Antoine
 */
public class Main {
    
    @SuppressWarnings("empty-statement")
    public static void main(String [ ] args) throws InterruptedException{
        System.out.println("Main de PrgParra");
        ProduitControleur mProduitControleur;
        mProduitControleur = new ProduitControleur();
        SimulateurControleur mSimulateurControleur = new SimulateurControleur();
        MenuControleur mControleur = new MenuControleur(mProduitControleur,mSimulateurControleur);    
        
        
        /**************
        *TEST UNITAIRE*
        **************/
        
        //création produits
        /*ArrayList<Produit> produits = new ArrayList();
        produits.add(new Produit(1,5));
        produits.add(new Produit(2,10));
        produits.add(new Produit(3,3));
        
        //création commande
        Commande commande = new Commande();
        for(int i = 0; i < produits.size(); i++){
            commande.addProduct(produits.get(i), i+5); // on ajoute les produits à la commande
        }
       
        //création des chaines
        ArrayList<Chaine> chaines = new ArrayList();
        chaines.add(new Chaine(1,4));
        chaines.add(new Chaine(2,10));
        chaines.add(new Chaine(3,7));
        chaines.add(new Chaine(4,3));
        
        //création du controleur de thread
        ThreadControleur tControleur = new ThreadControleur(commande,chaines);
        tControleur.start(); // lancement du traitement de la commande
        
        long startTime = System.currentTimeMillis(); // utile pour le calcul du temps de production
        
        //tant que le thread controleur est alive c'est que la production de la commande n'est pas finie
        while(tControleur.isAlive())
        {
            Thread.sleep(1000);
            System.out.println("progression : " + tControleur.getProgression() + "%"); // avec getProgression, on obient la progression de la production de la commande en %
        }
        
        long time = System.currentTimeMillis() - startTime; // utile pour le calcul du temps de production 
        System.out.println("Production finie en : "  + (time/1000) + "s"); // utile pour le calcul du temps de production*/
    }
}
