/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CellButton;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author User
 */
public class TableActionCellEditor extends DefaultCellEditor{
    
    private TableActionEvent event;
    // the object of the event  will passed to this method
    public TableActionCellEditor(TableActionEvent  event) {
     super(new JCheckBox());
     //adding the  new  button event 
     this.event = event;
    }

@Override
public Component getTableCellEditorComponent (JTable jtable, Object o, boolean bln, int row, int column) {
     PanelAction action=new PanelAction();

     action.initEvent(event ,row);
     action.setBackground(Color.white);
     return action;  
        
        }
    }