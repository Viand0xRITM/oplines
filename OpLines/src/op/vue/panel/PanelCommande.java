package op.vue.panel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import op.modele.Produit;

/**
 *
 * @author Antoine
 */
public class PanelCommande extends AbstractPanel{
    private JComboBox produitComboBox;
    private DefaultComboBoxModel defaultCBModel;
    private JTextField quantiteText;
    
    public PanelCommande(String name, ActionListener al){
        super();
        init();
        this.titre.setText(name);
        this.ajouter.setText("Ajouter Commande");
        this.ajouter.addActionListener(al);
        
        this.supprimer.setText("Supprimer Commande");
        this.supprimer.addActionListener(al);
        
        this.defaultCBModel = new DefaultComboBoxModel();
        this.produitComboBox = new JComboBox(this.defaultCBModel);
        this.quantiteText = new JTextField();

        this.defaultTableModel.addColumn("Id Produit");
        this.defaultTableModel.addColumn("Quantite");
        this.defaultTableModel.addColumn("Vitesse");
        
        this.boutonPanel.add(this.produitComboBox,0);
        this.boutonPanel.add(this.quantiteText,1);
    }
    
    public void setListeProduit(ArrayList<Produit> liste){
        this.defaultCBModel.removeAllElements();
        for (int i=0;i<liste.size();i++){
            this.defaultCBModel.addElement(String.valueOf(liste.get(i).getId()));
        }
        this.produitComboBox.setModel(this.defaultCBModel);
    }
    
    public String getQuantite(){
        return this.quantiteText.getText();
    }
    public int getProduitId(){
        return Integer.parseInt(this.produitComboBox.getSelectedItem().toString());
    }
    public void addCommande(String id, String qte, String vit){
        this.defaultCBModel.removeElement(id);
        this.defaultTableModel.addRow(new Object[]{id,qte,vit});
        this.table.setModel(this.defaultTableModel);
    }
    public int deleteSelectedCommande(){
        int selectedRow = this.table.getSelectedRow();
        if (selectedRow ==-1){
            return selectedRow;
        }
        this.defaultCBModel.addElement(this.defaultTableModel.getValueAt(selectedRow, 0));
        this.defaultTableModel.removeRow(selectedRow);
        return selectedRow;
    }
}
