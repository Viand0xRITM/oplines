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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import op.modele.CommandeLigne;
import op.modele.CommandeProduite;
import op.modele.Produit;

/**
 *
 * @author antoine
 */
public class PanelCommandeSimulation extends JPanel {
    protected JLabel titre;
    private JTextArea text;
    
    public PanelCommandeSimulation(ArrayList<CommandeLigne> listeCL) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.titre = new JLabel("Récapitulatif");
        this.text = new JTextArea();
        this.text.setEditable(false);
        refreshCommandeAffiche(listeCL,null);
        this.add(titre);
        this.add(text);
    }
    
    public void refreshCommandeAffiche(ArrayList<CommandeLigne> listeCL,ArrayList<CommandeProduite> cp){
        String toDisplay="";
        
        if (cp ==null){
            for (CommandeLigne cl : listeCL){
                toDisplay+="Produit "+cl.getProduit().getId()+": "+cl.getQuantiteProduite()+"/"+cl.getQuantiteAProduire()+"\n";
            }
        } else {
            for (CommandeLigne cl : listeCL){
                int qteprod = 0;
                for (CommandeProduite c:cp){
                    for (Produit p:c.getListeProduit()){
                        if (p.getId() == cl.getProduit().getId()){
                            qteprod++;
                        }
                    }
                }
                toDisplay+="Produit "+cl.getProduit().getId()+": "+qteprod+"/"+cl.getQuantiteAProduire()+"\n";
            }
        }
        this.text.setText(toDisplay);
    }
}
