/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package op.modele;

/**
 *
 * @author steph
 */
public class CommandeLigne{
    Produit produit;
    int quantiteAProduire;
    int quantiteProduite;
    
    public CommandeLigne(Produit produit, int quantite)
    { 
        this.produit = produit;
        this.quantiteAProduire = quantite;
    }

    public Produit fabriquerProduit() {
        quantiteProduite++;
        return produit;
    }

    public int getQuantiteAProduire() {
        return quantiteAProduire;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getQuantiteProduite() {
        return quantiteProduite;
    }

    public void setQuantiteProduite(int quantiteProduite) {
        this.quantiteProduite = quantiteProduite;
    }
}
