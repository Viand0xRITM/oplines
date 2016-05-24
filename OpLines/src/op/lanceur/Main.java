package op.lanceur;

import op.controleur.MenuControleur;
import op.controleur.ProduitControleur;

/**
 *
 * @author Antoine
 */
public class Main {
    
    public static void main(String [ ] args){
        System.out.println("Main de PrgParra");
        ProduitControleur mProduitControleur;
        mProduitControleur = new ProduitControleur();
        MenuControleur mControleur = new MenuControleur(mProduitControleur);        
    }
}
