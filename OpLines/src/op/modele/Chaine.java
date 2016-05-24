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
public class Chaine {
    private int idChaine;
    private int vitesse;
    private Commande commande;
    
    public Chaine(int idChaine, int vitesse)
    {
        this.idChaine = idChaine;
        this.vitesse = vitesse;
    }

    public int getIdChaine() {
        return idChaine;
    }

    public void setIdChaine(int idChaine) {
        this.idChaine = idChaine;
    }

    public int getVitesse() {
        return vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }
    
}
