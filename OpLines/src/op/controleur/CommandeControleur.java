/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package op.controleur;

import java.util.ArrayList;
import op.modele.Commande;
import op.modele.Produit;

/**
 *
 * @author steph
 */
public class CommandeControleur {
    Commande commande;
    
    public CommandeControleur()
    {
    }
    
    public void createCommande(ArrayList<Produit> listeProduits)
    {
        commande = new Commande();
        commande.setListeProduits(listeProduits);
    }
    
    public Commande getCommande()
    {
        return this.commande;
    }
}
