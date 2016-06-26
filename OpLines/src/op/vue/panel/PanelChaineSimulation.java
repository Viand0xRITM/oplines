/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package op.vue.panel;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author antoine
 */
public class PanelChaineSimulation extends JPanel {
    protected JLabel titre;
    protected JTable table;
    
    protected DefaultTableModel defaultTableModel;
    
    public PanelChaineSimulation(String nom) {
        this.titre = new JLabel("Chaine " + nom);
        this.table = new JTable(defaultTableModel);
        this.defaultTableModel = new DefaultTableModel();
        
        this.table     = new JTable(this.defaultTableModel){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };
        this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.add(titre);
        this.add(new JScrollPane(table));
    }
    
}
