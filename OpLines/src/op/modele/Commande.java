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
    ArrayList<Produit> listeProduits;
    int tempsProduction;
    
    public Commande()
    {
    }
    
    /*
        calcule le temps total de production de la commande
    */
    private void calculTempsProduction()
    {
        int result = 0;
        for(int i = 0; i < listeProduits.size(); i++)
            tempsProduction += listeProduits.get(i).getTempsProduction();
         
        this.tempsProduction = result;
    }
    
    public void addProduct(Produit prod)
    {
        listeProduits.add(prod);
        calculTempsProduction();
    }
    
    public void deleteProduct(int index)
    {
        listeProduits.remove(index);
        calculTempsProduction();
    }

    public ArrayList<Produit> getListeProduits() {
        return listeProduits;
    }

    public void setListeProduits(ArrayList<Produit> listeProduits) {
        this.listeProduits = listeProduits;
        calculTempsProduction();
    }
}
