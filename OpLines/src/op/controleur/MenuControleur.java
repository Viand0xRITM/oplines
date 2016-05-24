package op.controleur;

import op.vue.IHMMenu;

public class MenuControleur {
    private IHMMenu ihm;
    
    public MenuControleur(){
        this.ihm = new IHMMenu();
    }
    public MenuControleur(IHMMenu ihm){
        this.ihm = ihm;
    }
    public void afficherEcran(){
        this.ihm.setVisible(true);
    }
}
