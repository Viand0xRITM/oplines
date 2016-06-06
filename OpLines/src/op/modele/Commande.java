/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package op.modele;

import java.util.ArrayList;

/**
 *
 * @author Antoine
 */
public class Commande {
    ArrayList<CommandeLigne> contenuCommande;
    int unitesAProduire;
    int unitesProduites;
    
    public Commande()
    {
        contenuCommande = new ArrayList();
    }
    
    /*
        calcule le temps total de production de la commande
    */
    public void calculUnitesAProduire()
    {
        int result = 0;
        for(int i = 0; i < contenuCommande.size(); i++)
            result += contenuCommande.get(i).getQuantiteAProduire();
         
        this.unitesAProduire = result;
    }
    
    public void calculUnitesProduite()
    {
        int result = 0;
        for(int i = 0; i < contenuCommande.size(); i++)
            result += contenuCommande.get(i).getQuantiteProduite();
         
        this.unitesProduites = result;
    }
    
    public void addProduct(Produit prod, int quantite)
    {
        CommandeLigne ligne = new CommandeLigne(prod, quantite);
        contenuCommande.add(ligne);
        calculUnitesAProduire();
    }
    
    public void deleteProduct(int index)
    {
        contenuCommande.remove(index);
        calculUnitesAProduire();
    }

    public ArrayList<CommandeLigne> getListeProduits() {
        return contenuCommande;
    }
    
    public int getUnitesAProduire()
    {
        return unitesAProduire;
    }

    public int getUnitesProduites() {
        return unitesProduites;
    }

    public void setUnitesProduites(int unitesProduites) {
        this.unitesProduites = unitesProduites;
    }
    
}
