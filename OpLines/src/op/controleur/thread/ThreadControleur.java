/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package op.controleur.thread;

import java.util.ArrayList;
import op.controleur.SimulateurControleur;
import op.modele.Chaine;
import op.modele.Commande;
import op.modele.CommandeLigne;
import op.modele.CommandeProduite;
import op.modele.Produit;

/**
 *
 * @author steph
 */
public class ThreadControleur extends Thread{
    ArrayList<ThreadChaine> Tchaines = new ArrayList();
    Commande commande;
    private SimulateurControleur sc;
    public ThreadControleur(Commande commande, ArrayList<Chaine> chaines, SimulateurControleur simu)
    {
        this.sc = simu;
        this.commande = commande;
        ArrayList<CommandeLigne> contenuCommande = this.commande.getContenuCommande();
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
            sc.avancement();
        }
        boolean sorti = false;
        while (!sorti){
            int i= 0;
            while (i< Tchaines.size() && ! Tchaines.get(i).isAlive()){
                i++;
            }
            if (i ==Tchaines.size() ){
                sorti =true;
            }
        }
        sc.terminerProduction();
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
    
    public ArrayList<CommandeProduite> getProduitsFabriqueParChaine(){
        ArrayList<CommandeProduite> cp = new ArrayList();
        for (ThreadChaine tc:Tchaines){
            cp.add(new CommandeProduite(tc.getIdChaine(),tc.getProduitFab()));
        }
        return cp;
    }
}
