/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment;

import customeExceptions.DataTypeException;
import customeExceptions.InvalidInputException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *s
 * @author User
 */
public class Master extends Room{
    
    public Master(){setType();};
    
    public Master(String  location, double size, String description, String status, String gender, double bathroomSize) {
        super(location, description, status,gender ,bathroomSize);
        setType();
        setSize(String.valueOf(size));
        
    }
    
    
    //setters
     @Override
    public void setType () {
        String type = (this.getClass().getSimpleName());
        this.type = type;
        
    }
    
    
    
    
    
    @Override
     public boolean setSize(String totalSize) { 
         
         try { 
          Validation.isDouble(totalSize);
          double  size = Double.parseDouble(totalSize);
          Validation.checkRange(size, 350 ,  550);
            
                  this.size = size;
                  return true;
         }catch(DataTypeException  e) { 
        JOptionPane.showMessageDialog(null, "Only Double values allowed for the size");
        
    }catch(InvalidInputException e) { 
         JOptionPane.showMessageDialog(null, "Master room size should be between 350 to 550");
    }
        return false;
    } 
     
     
        @Override
      public Utility  displayHostal(JTable table,String role,String Id, JPanel parentPanel, JPanel ChildPanel) { 
        Utility ds =new Utility();
        ds = super.displayHostal(table,role,Id,parentPanel,ChildPanel);
        ArrayList<String> columnNames = new ArrayList<>(Arrays.asList("Roomid", "Type", "location", "Size", "Monthly rent", "Deposit", "gender", "Status","View"));
         ds.setColumnNames(columnNames);
        ds.setType("master");
        ds.displayOnJTable();
        return ds;
   }
     
     
     
          
    public boolean checkData(String location, String status, String description, String  gender,String bathroomSize, String size){ 
      if(!super.checkData(location, status,description,gender ,bathroomSize)) return false;     
      if(!setSize(size)) return false; 
     return true; 
    } 

}
