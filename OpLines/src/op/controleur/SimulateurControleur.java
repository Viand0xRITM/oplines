/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package op.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import op.controleur.thread.ThreadControleur;
import op.modele.Chaine;
import op.modele.Commande;
import op.modele.CommandeLigne;
import op.modele.CommandeProduite;
import op.vue.IHMSimulateur;
/**
 *
 * @author Antoine
 */
public class SimulateurControleur implements ActionListener{
    private IHMSimulateur ihm;
    
    private ThreadControleur tControleur;
    private Commande commande;
    private ArrayList<Chaine> listeChaines;
    
    public SimulateurControleur(){
        
    }
    public void start(ArrayList<Chaine> listeChaines, Commande commande) {
        this.commande = commande;
        this.listeChaines = listeChaines;
        
        this.ihm = new IHMSimulateur(this,this.listeChaines,this.commande.getContenuCommande());
        this.ihm.setVisible(true);
        this.tControleur = new ThreadControleur(commande,listeChaines, this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        if (command.equals("Lancer la simulation")) {
            System.out.println("DEBUG> Lancement de la simulation");
            ihm.changerStatutBouton(false);
            tControleur.start();
        }
        
    }
    
    public void avancement() {
        this.ihm.refreshIHM(commande.getContenuCommande(), tControleur.getProgression(), (ArrayList<CommandeProduite>)tControleur.getProduitsFabriqueParChaine().clone());
    }

    public void terminerProduction() {
        
    }
}
