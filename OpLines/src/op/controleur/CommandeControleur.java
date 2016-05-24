/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package op.controleur;

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
    
    public void addProduit(Produit produit)
    {
        commande.addProduct(produit);
    }
    
    public void removeProduit(int index)
    {
        commande.deleteProduct(index);
    }
    
    public Commande getCommande()
    {
        return this.commande;
    }
}
