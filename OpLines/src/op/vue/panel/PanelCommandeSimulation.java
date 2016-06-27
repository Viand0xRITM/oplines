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
            for (int i=0;i<listeCL.size();i++){
                toDisplay+="Produit "+listeCL.get(i).getProduit().getId()+": "+listeCL.get(i).getQuantiteProduite()+"/"+listeCL.get(i).getQuantiteAProduire()+"\n";
            }
        } else {
            for (int i=0;i<listeCL.size();i++){
                int qteprod = 0;
                for (int j=0;j<cp.size();j++){
                    for (int k=0;k<cp.get(j).getListeProduit().size();k++){//Produit p:cp.getListeProduit().clone()){
                        if (cp.get(j).getListeProduit().get(k).getId() == listeCL.get(i).getProduit().getId()){
                            qteprod++;
                        }
                    }
                }
                toDisplay+="Produit "+listeCL.get(i).getProduit().getId()+": "+qteprod+"/"+listeCL.get(i).getQuantiteAProduire()+"\n";
            }
        }
        this.text.setText(toDisplay);
    }
}
