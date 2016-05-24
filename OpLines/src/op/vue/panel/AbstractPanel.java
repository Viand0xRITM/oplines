/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package op.vue.panel;

import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Antoine
 */
public abstract class AbstractPanel extends JPanel{
    protected JLabel titre;
    protected JPanel boutonPanel;
    protected JButton ajouter;
    protected JButton supprimer;
    protected JTable table;
    
    protected DefaultTableModel defaultTableModel;
    
    protected void init(){
        this.titre = new JLabel();
        this.boutonPanel = new JPanel();
        this.ajouter   = new JButton("ajouter");
        this.supprimer = new JButton("supprimer");
        this.defaultTableModel = new DefaultTableModel();
        this.table     = new JTable(defaultTableModel);
        
        
        this.boutonPanel.setLayout(new BoxLayout(boutonPanel, BoxLayout.X_AXIS));
        
        this.add(titre);
        this.add(new JScrollPane(table));
        
        this.boutonPanel.add(this.ajouter);
        this.boutonPanel.add(this.supprimer);
        this.add(boutonPanel);       
    }
    
}
