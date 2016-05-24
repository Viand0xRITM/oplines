/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package op.vue.panel;

import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Antoine
 */
public class PanelChaine extends AbstractPanel{
    
    public PanelChaine(String name, ActionListener al){
        super();
        init();
        this.titre.setText(name);
        this.ajouter.setText("Ajouter Chaine");
        this.ajouter.addActionListener(al);
    }
    
    
}
