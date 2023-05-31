/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment;

import customeExceptions.*;
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
import javax.swing.*;

/**
 *
 * @author User
 */
public class Unit extends Hostel {
    private int roomsNumber; 
    private  int bathroomsNumber; 
   
   
    public Unit(String location, String  gender,double size,String status,String description, int roomsNumber , int bathroomsNumber) { 
        super(location, description, status,gender);
        setType();
        setRoomsNumber(String.valueOf(roomsNumber)); 
        setBathroomNumber(String.valueOf(bathroomsNumber));
        setSize(String.valueOf(size));
      
    }

    public Unit() {
        setType();
    }
    
    
    //getters 
    public int getBathroomsNumber() { 
        return this.bathroomsNumber; 
    }
    
    public int getRoomsNumber() { 
        return this.roomsNumber;
    }
    
    
    
    
    //setters 
    public boolean setBathroomNumber(String number) { 
        
         try  {
             Validation.isInt(number);
             int bathroomNumber = Integer.parseInt(number);
             Validation.checkRange(Double.parseDouble(number), 1);
             this.bathroomsNumber = bathroomNumber;
             return true;
              
          }catch(DataTypeException  e) { 
            JOptionPane.showMessageDialog(null, "Only Integer values allowed for the Bathroom size");


        }catch(InvalidInputException e) { 
             JOptionPane.showMessageDialog(null, "bathroom number should be greater theb zero");
        }  
         
         return false;
    }
    
        public  boolean  setRoomsNumber(String number) { 
            
            try  {
             Validation.isInt(number);
             int roomsNumber = Integer.parseInt(number);
             Validation.checkRange(Double.parseDouble(number), 1);
             this.roomsNumber = roomsNumber ;
             return true;
              
          }catch(DataTypeException  e) { 
            JOptionPane.showMessageDialog(null, "Only Integer values allowed for the Bathroom size");


        }catch(InvalidInputException e) { 
             JOptionPane.showMessageDialog(null, "rooms number should be greater theb zero");
        }  
         
        return false;
        
    }
   
        
        //
        
    @Override
    public void setType () {
        String type =(this.getClass().getSimpleName());
        this.type = type;
    }
    
 
    @Override
    public boolean  setSize(String totalSize) { 
        
        try {
            Validation.isDouble(totalSize);
            double  size = Double.parseDouble(totalSize);
            Validation.checkRange(size, 700);
            this.size = size;
            return true;
        }catch(DataTypeException  e) { 
             JOptionPane.showMessageDialog(null, "Only Double values allowed for the size");

        }catch(InvalidInputException e) { 
         JOptionPane.showMessageDialog(null, "unit size should be from  700 and above");
        }
        
        return false;
    }
    
//
@Override
public Utility  displayHostal(JTable table,String role,String Id, JPanel parentPanel, JPanel ChildPanel) { 
    Utility ds =new Utility();
    ds = super.displayHostal(table,role,Id,parentPanel,ChildPanel);
    ArrayList<String> columnNames = new ArrayList<>(Arrays.asList("Roomid", "Type", "location", "Size", "Monthly rent", "Deposit", "gender", "Status", "Rooms number", "Bathrooms number", "View"));
    ds.setColumnNames(columnNames);
    ds.setType("unit");
    ds.displayOnJTable();
    return ds;
}

   //Sera
      
      
   public boolean checkData(String location, String status,String description,String  gender ,String getRoomsNumber, String getBathroomsNumber, String size){ 
      if(!super.checkData(location, status, description, gender)) return false;     
      if(!setSize(size)) return false; 
      if(!setBathroomNumber(getBathroomsNumber)) return false; 
      if(!setRoomsNumber(getRoomsNumber)) return false;   
     return true; 
    } 

    
    //getInfo 
    @Override
   public HashMap getInfo() { 
      HashMap<String, String> data = super.getInfo();
      data.put("rooms number",  String.valueOf(this.roomsNumber));
      data.put("bathrooms number",  String.valueOf(this.bathroomsNumber));
      return data;
        
    }

}
