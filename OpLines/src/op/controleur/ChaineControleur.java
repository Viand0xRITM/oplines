/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package op.controleur;

import java.util.ArrayList;
import op.modele.Chaine;

/**
 *
 * @author steph
 */
public class ChaineControleur{
    ArrayList<Chaine> chaines;
    
    public void ChaineControleur()
    {
    }
    
    public void addChaine(Chaine chaine)
    {
        chaines.add(chaine);
    }
    
    public void deleteChaine(int index)
    {
        chaines.remove(index);
    }
    
    public ArrayList<Chaine> getChaines()
    {
        return chaines;
    }
}
