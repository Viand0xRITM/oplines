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
public class ThreadControleur extends Thread{
    ArrayList<ThreadChaine> Tchaines = new ArrayList();
    Commande commande;
    
    public ThreadControleur(Commande commande, ArrayList<Chaine> chaines)
    {
        this.commande = commande;
        ArrayList<CommandeLigne> contenuCommande = commande.getContenuCommande();
        ArrayList<Produit> produits = new ArrayList();
        
        for(int i = 0; i < contenuCommande.size(); i++)
        {
            CommandeLigne ligne = contenuCommande.get(i);
            for(int j = 0; j < ligne.getQuantiteAProduire(); j++)
            {
                produits.add(ligne.getProduit());
            }
        }
        
        for(int i = 0; i < chaines.size(); i++)
        {
            Tchaines.add(new ThreadChaine(chaines.get(i), commande, produits));
        }
    }
    
    @Override
    public void run()
    {
        System.out.println("a produire : " + commande.getUnitesAProduire());
        lauchSimulation();
        
        boolean commandeTraitee = false;
        while(!commandeTraitee)
        {
            if(commande.getUnitesProduites() >= commande.getUnitesAProduire())
            {
                commandeTraitee = true;
            }
        }
    }
    
    public void lauchSimulation()
    {
        for (ThreadChaine Tchaine : Tchaines) {
            Tchaine.start();
        }
    }
    
    public float getProgression()
    {
        float progress = ((commande.getUnitesProduites() + commande.getUnitesAProduire()) * 100 / commande.getUnitesAProduire()) - 100;
        return progress;
    }
}
