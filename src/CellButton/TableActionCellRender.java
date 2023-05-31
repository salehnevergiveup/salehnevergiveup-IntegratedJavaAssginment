/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CellButton;

//import CellButton.ActionButton;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Component;

/**
 *
 * @author User
 */
public class TableActionCellRender  extends DefaultTableCellRenderer {
 
    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean isSelected, boolean bln1, int row, int column) { 
    Component com = super.getTableCellRendererComponent(jtable, o, isSelected, bln1, row, column);
    PanelAction action=new PanelAction();
    //to custom the the panel based on of the  rwo not  selected
    if(isSelected == false && row %2 ==0 ) { 
        action.setBackground(Color.white);
    }else { 
        action.setBackground(com.getBackground());
        
    }
     return action;
    }
}
