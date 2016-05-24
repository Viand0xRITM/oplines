package op.lanceur;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import op.controleur.MenuControleur;
import op.controleur.ProduitControleur;
import op.vue.*;

/**
 *
 * @author Antoine
 */
public class Main {
    
    public static void main(String [ ] args){
        System.out.println("Main de PrgParra");
        ProduitControleur mProduitControleur;
        try {
            mProduitControleur = new ProduitControleur();
            MenuControleur mControleur = new MenuControleur(mProduitControleur);
            
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        
    }
}
