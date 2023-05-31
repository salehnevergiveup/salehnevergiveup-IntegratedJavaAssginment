/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment;

import CellButton.TableActionCellEditor;
import CellButton.TableActionCellRender;
import CellButton.TableActionEvent;
import Interface.StudentHostel;
import customeExceptions.DataTypeException;
import customeExceptions.InvalidInputException;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


/**
 *
 * @author User
 */
public class DoubleRoom extends Room{
     private int residents; 
      public DoubleRoom(){setType();};   
      public DoubleRoom(String location, double size, String description, String status,String  gender, double bathroomSize, int residents ) {
        super(location, description, status, gender,bathroomSize);
        setType();
        setNumberOfResidents(status);
        setSize(String.valueOf(size));
        
     
    }
            public DoubleRoom(String location, double size, String description, String status,String  gender, double bathroomSize, String residents ) {
        super(location, description, status, gender,bathroomSize);
        setType();
        setSize(String.valueOf(size));
        
     
    }
      
      
      
     //getters
      public int  getNumberOfResidents() { 
          return this.residents;
      }
     public double getMontlyRent() { 
      return ((this.size + getBathroomSize())* 2.5)/2;
    }
     //setters
     @Override
    public void setType () {
        String type = (this.getClass().getSimpleName());
        this.type = type;
    }
    
    
     public boolean setNumberOfResidents(String residents) { 
         try { 
             Validation.isInt(residents); 
             Validation.checkRange(Integer.parseInt(residents), 0 ,  2);
             this.residents = Integer.parseInt(residents);
             return true;
         }catch(DataTypeException  e) { 
             JOptionPane.showMessageDialog(null, "Only Inetger  values allowed for the number of the beds");
         }catch(InvalidInputException e){ 
              JOptionPane.showMessageDialog(null, "Number of the  Residetns should be between 0 to 2");
         }
         return false;
     }
    //problem here
      public boolean  setStatus() { 
          try { 
          if(residents == 2) { 
              super.setStatus("not available"); 
              return true;
          }else { 
              super.setStatus("available");
              return true;
            
          }}catch(Exception e) { 
              JOptionPane.showMessageDialog(null , "you have  to set the number of the residents first!!");
          }
         return false;
     }
    
    
     //change
     @Override
    public boolean setSize(String totalSize) {  
            
        try {
            Validation.isDouble(totalSize);
            double  size = Double.parseDouble(totalSize);
            Validation.checkRange(size, 100 ,  350);
                   this.size = size/2;
                   return true;
        }catch(DataTypeException  e) { 
           JOptionPane.showMessageDialog(null, "Only Double values allowed for the size");

        }catch(InvalidInputException e) { 
            JOptionPane.showMessageDialog(null, "double room size should be between 250 to 350");
        }
        return true;
    }
    
    
    //Display

   @Override
    public Utility  displayHostal(JTable table,String role,String Id, JPanel parentPanel, JPanel ChildPanel) { 
        Utility ds =new Utility();
        ds = super.displayHostal(table,role,Id,parentPanel,ChildPanel);
        ArrayList<String> columnNames = new ArrayList<>(Arrays.asList("Roomid", "Type", "location", "Size", "Monthly rent", "Deposit", "gender", "Status","Residents Number" ,"View"));
         ds.setColumnNames(columnNames);
        ds.setType("double");
        ds.displayOnJTable();
        return ds;
 }
    
    //check info method 
       public boolean checkData(String location, String status, String description,String  gender,String bathroomSize, String size, String residents){ 
      if(!super.checkData(location, status,description ,bathroomSize)) return false;     
      if(!setSize(size)) return false; 
      if(!setNumberOfResidents(residents)) return false;
      if(!setStatus()) return false;
     return true; 
    } 
 
    @Override
   public HashMap getInfo() { 
      HashMap<String, String> data = super.getInfo();
      data.put("residents number",  String.valueOf(this.residents));
      return data;
        
    }
    
    
}
    
    
      
      
