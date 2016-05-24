package op.vue.panel;

import java.awt.event.ActionListener;
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

    public void addChaine(int id, int vit) {
        this.defaultTableModel.addRow(new Object[]{id,vit});
        this.table.setModel(defaultTableModel);

    }
    
}
