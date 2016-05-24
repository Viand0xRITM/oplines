package op.vue.panel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author Antoine
 */
public class PanelChaine extends AbstractPanel{
    private JTextField vitesseText;
    
    public PanelChaine(String name, ActionListener al){
        super();
        init();
        this.titre.setText(name);
        
        this.ajouter.setText("Ajouter Chaine");
        this.ajouter.addActionListener(al);
        
        this.supprimer.setText("Supprimer Chaine");
        this.supprimer.addActionListener(al);
        
        this.vitesseText = new JTextField();
        
        this.defaultTableModel.addColumn("Identifiant");
        this.defaultTableModel.addColumn("Vitesse de production");
        
        this.boutonPanel.add(this.vitesseText,0);
    }
    
    public String getVitesse(){
        return vitesseText.getText();
    }
    
    public int getNbChaines(){
        return this.defaultTableModel.getRowCount();
    }
    
    public int addChaine(int vit) {
        int id = 0;
        for (int i=0; i< this.defaultTableModel.getRowCount();i++){
            if (id < Integer.valueOf(defaultTableModel.getValueAt(i, 0).toString())){
                id = Integer.valueOf(defaultTableModel.getValueAt(i, 0).toString());
            }
        }
        this.defaultTableModel.addRow(new Object[]{id+1,vit});
        this.table.setModel(defaultTableModel);
        return id+1;
    }
    
    public int deleteSelectedChaine(){
        int selectedRow = this.table.getSelectedRow();
        if (selectedRow == -1){
            return -1;
        }
        int idChaine = Integer.parseInt(this.defaultTableModel.getValueAt(selectedRow, 0).toString());
        this.defaultTableModel.removeRow(selectedRow);
        return idChaine;
    }
    
}
