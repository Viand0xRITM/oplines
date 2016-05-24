/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package op.modele;

import java.util.ArrayList;

/**
 *
 * @author steph
 */
public class Chaine {
    private int idChaine;
    private int vitesse;
    private ArrayList<Commande> commandes;
    
    public Chaine(int idChaine, int vitesse)
    {
        this.idChaine = idChaine;
        this.vitesse = vitesse;
    }
    
    public void ajoutCommande(Commande commande)
    {
        commandes.add(commande);
    }
    
    public boolean commandesTraitees()
    {
        return commandes.isEmpty();
    }
}
