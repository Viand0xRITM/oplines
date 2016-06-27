/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package op.controleur.thread;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import op.modele.Chaine;
import op.modele.Commande;
import op.modele.CommandeLigne;
import op.modele.Produit;

/**
 *
 * @author steph
 */
public class ThreadChaine extends Thread {
    Chaine chaine;
    Commande commande;
    ArrayList<Produit> produits;
    //ArrayList<CommandeLigne> listeCL;
    ArrayList<Produit> produitsFabrique;
    private final Object lock = new Object();
    
    public ThreadChaine(Chaine chaine, Commande commande, ArrayList<Produit> produits)
    {
        this.chaine = chaine;
        this.commande = commande;
        this.produits = produits;
        this.produitsFabrique = new ArrayList();
        //listeCL = new ArrayList();
    }
    
    @Override
    public void run()
    {
        //vérifier que la commande n'est pas traitée entièrement
        while(!commandeTraitee())
        {
            traiterProduit();
        }
    }
    
    //renvoie vraie si la commande est traitée
    public synchronized boolean commandeTraitee()
    {
        return produits.isEmpty();
    }
    
    private synchronized void traiterProduit()
    {
        
        if(!commandeTraitee())
        {
            Produit produit = produits.remove(0);
            
            commande.setUnitesProduites(commande.getUnitesProduites() + 1);
            try {
                sleep(chaine.getVitesse() * 100 * produit.getTempsProduction());
                
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadChaine.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            produitsFabrique.add(produit);
        }
    }
    
    public ArrayList<Produit> getProduitFab()
    {
        return produitsFabrique;
    }
    public int getIdChaine()
    {
        return chaine.getIdChaine();
    }
}
