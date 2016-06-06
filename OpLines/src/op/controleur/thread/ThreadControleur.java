/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package op.controleur.thread;

import java.util.ArrayList;
import op.modele.Chaine;
import op.modele.Commande;
import op.modele.CommandeLigne;

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
        for(int i = 0; i < chaines.size(); i++)
        {
            Tchaines.add(new ThreadChaine(chaines.get(i), commande));
        }
    }
    
    @Override
    public void run()
    {
        lauchSimulation();
    }
    
    public void lauchSimulation()
    {
        for(int i = 0; i < Tchaines.size(); i++)
        {
            Tchaines.get(i).start();
        }
    }
}
