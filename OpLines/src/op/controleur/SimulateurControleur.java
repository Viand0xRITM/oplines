/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package op.controleur;

import op.vue.IHMSimulateur;
/**
 *
 * @author Antoine
 */
public class SimulateurControleur {
    private IHMSimulateur ihm;
    
    public SimulateurControleur(){
        
    }

    public void start() {
        this.ihm = new IHMSimulateur(this);
        this.ihm.setVisible(true);
        boolean over = false;
        /*while (!over){
            
        }*/
    }
}
