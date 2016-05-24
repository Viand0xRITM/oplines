/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package op.controleur;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import op.modele.Connexion;
import op.modele.Produit;

/**
 *
 * @author steph
 */
public class ProduitControleur {
    ArrayList<Produit> listeProduits;
    Connexion bdd;
   
    public ProduitControleur()
    {
        listeProduits = new ArrayList();
        try {
            bdd = new Connexion("./bdd/produit.db");
            bdd.connect();
            
            //read product in db
            ResultSet result = bdd.query("SELECT * FROM produit");
            while(result.next())
            {
                int id, tempsFabrication;
                id = result.getInt("id_produit");
                tempsFabrication = result.getInt("temps_fabrication_produit");
                
                listeProduits.add(new Produit(id, tempsFabrication));
            }
            bdd.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProduitControleur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Produit> getListeProduits() {
        return listeProduits;
    }
}
