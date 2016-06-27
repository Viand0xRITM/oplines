/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package op.vue.panel;

import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import op.modele.Produit;

/**
 *
 * @author antoine
 */
public class PanelChaineSimulation extends JPanel {
    protected JLabel titre;
    private JTextArea text;
    
    private int id;
    
    public PanelChaineSimulation(String nom) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.id = Integer.valueOf(nom);
        this.titre = new JLabel("Chaine " + nom);
        this.text = new JTextArea("\n\n\n");
        this.add(titre);
        this.add(text);
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public void refreshIHM(ArrayList<Produit> liste){
        if (! liste.isEmpty()){
            String display = "";
            int qte = 0;
            int id=liste.get(0).getId();
            for (Produit prd: liste){
                if (id == prd.getId()){
                    qte++;
                } else {
                    display += "Produit "+id+": "+qte+"\n";
                    id = prd.getId();
                    qte=1;
                }
            }
            display += "Produit "+id+": "+qte;
            this.text.setText(display);
        }
    }
}
