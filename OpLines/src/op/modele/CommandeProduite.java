package op.modele;

import java.util.ArrayList;

public class CommandeProduite {
    int idChaine;
    ArrayList<Produit> listeProduit;

    public CommandeProduite(int idChaine, ArrayList<Produit> listeProduit) {
        this.idChaine = idChaine;
        this.listeProduit = listeProduit;
    }

    public int getIdChaine() {
        return idChaine;
    }

    public void setIdChaine(int idChaine) {
        this.idChaine = idChaine;
    }

    public ArrayList<Produit> getListeProduit() {
        return listeProduit;
    }

    public void setListeProduit(ArrayList<Produit> listeProduit) {
        this.listeProduit = listeProduit;
    }
    
    
}
