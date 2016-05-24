/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package op.vue.panel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import op.modele.Commande;
import op.modele.Produit;

/**
 *
 * @author Antoine
 */
public class PanelCommande extends AbstractPanel{
    private JComboBox prodtuiComboBox;
    private JScrollPane scrollPanel;
    private DefaultComboBoxModel defaultCBModel;
    private JTextField quantiteText;
    
    public PanelCommande(String name, ActionListener al){
        super();
        init();
        this.titre.setText(name);
        this.ajouter.setText("Ajouter Commande");
        this.ajouter.addActionListener(al);
        
        defaultCBModel = new DefaultComboBoxModel();
        this.prodtuiComboBox = new JComboBox(defaultCBModel);
        this.quantiteText = new JTextField();
        defaultTableModel.addColumn("Id Produit");
        defaultTableModel.addColumn("Quantite");
        defaultTableModel.addColumn("Vitesse");
        scrollPanel = new JScrollPane(prodtuiComboBox);
        scrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.boutonPanel.add(this.scrollPanel,0);
        this.boutonPanel.add(this.quantiteText,1);
    }
    
    public void setListeProduit(ArrayList<Produit> liste){
        defaultCBModel.removeAllElements();
        for (int i=0;i<liste.size();i++){
            System.err.println("tata");
            defaultCBModel.addElement(String.valueOf(liste.get(i).getId()));
        }
        System.err.println("coucou");
        this.prodtuiComboBox.setModel(defaultCBModel);
        System.err.println("salut");
    }
    
    public String getQuantite(){
        return quantiteText.getText();
    }
    public int getProduitId(){
        System.out.println(prodtuiComboBox.getSelectedItem());
        return (int)prodtuiComboBox.getSelectedItem();
    }
    
    public void addCommande(String id, String qte, String vit){
        this.defaultTableModel.addRow(new Object[]{id,qte,vit});
        this.table.setModel(defaultTableModel);
    }
}
