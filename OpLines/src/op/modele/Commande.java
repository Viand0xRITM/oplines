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
        unitesProduites = 0;
    }
    
    /*
        calcule le nombre d'unité total de production de la commande
    */
    public void calculUnitesAProduire()
    {
        int result = 0;
        for(int i = 0; i < contenuCommande.size(); i++)
            result += contenuCommande.get(i).getQuantiteAProduire();
         
        this.unitesAProduire = result;
    }
    
    public void setUnitesProduites(int unitesProduites)
    {       
        this.unitesProduites = unitesProduites;
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

    public ArrayList<CommandeLigne> getContenuCommande() 
    {
        return contenuCommande;
    }
    
    public int getUnitesAProduire()
    {
        return unitesAProduire;
    }

    public int getUnitesProduites() 
    {
        return unitesProduites;
    }    
}
