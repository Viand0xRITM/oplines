package op.lanceur;

import op.controleur.MenuControleur;
import op.controleur.ProduitControleur;
import op.controleur.SimulateurControleur;

/**
 *
 * @author Antoine
 */
public class Main {
    
    public static void main(String [ ] args){
        System.out.println("Main de PrgParra");
        ProduitControleur mProduitControleur;
        mProduitControleur = new ProduitControleur();
        SimulateurControleur mSimulateurControleur = new SimulateurControleur();
        MenuControleur mControleur = new MenuControleur(mProduitControleur,mSimulateurControleur);        
    }
}
