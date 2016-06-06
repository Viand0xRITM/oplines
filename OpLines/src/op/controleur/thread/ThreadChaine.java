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

/**
 *
 * @author steph
 */
public class ThreadChaine extends Thread {
    Chaine chaine;
    Commande commande;
    ArrayList<CommandeLigne> contenuProduit;
    
    public ThreadChaine(Chaine chaine, Commande commande)
    {
        this.chaine = chaine;
        this.commande = commande;
        contenuProduit = new ArrayList();
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
    public boolean commandeTraitee()
    { 
        return commande.getUnitesAProduire() == commande.getUnitesProduites();
    }
    
    public ArrayList<CommandeLigne> getProductionCourante()
    {
        return contenuProduit;
    }
    
    private void traiterProduit()
    {
        /*
        lock commande
            obtenir 1 unité d'un produit
            incrémenter unité produite
        
        traiter unité
        ajouter unité aux unités traitées       
       */
        
        CommandeLigne ligne = commande.getListeProduits().get(0);
        ligne.fabriquerProduit();
        try {
            sleep(chaine.getVitesse() * 100 * ligne.getProduit().getTempsProduction());
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadChaine.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Chaine" + chaine.getIdChaine() + " a traité : " + ligne.getProduit().getId());
        
    }
}
