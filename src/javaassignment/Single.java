/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment;


import Interface.UpdateApplication;
import Interface.*;
import CellButton.TableActionCellEditor;
import CellButton.TableActionCellRender;
import CellButton.TableActionEvent;
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
import Interface.*;
/**
 *
 * @author User
 */
public class Single extends Room {
    
   private int numberOfUsers; 
   private String typeOfBathroom;
   
   public Single() {
       setType();};
   
    public Single(String location, double size, String description, String status,String  gender, double bathroomSize,int numberofusers ) {
        super(location ,description, status, gender ,bathroomSize);
        setType();
        setNumberOfUsers(String.valueOf(numberofusers));
        setTypeOfTheBathroom();
        setSize(String.valueOf(size));
        
        
        
    }
    
    
    //getters
    public int getNumberOfUsers() { 
        return numberOfUsers;
    }
    
    
    public String getTypeOfTheBathroom() { 
     return this.typeOfBathroom;
    }
    
    
    
    
    //setters 
    public boolean setNumberOfUsers(String users) { 

        try  {
            Validation.isInt(users);
             int bathroomUsers = Integer.parseInt(users);
            Validation.checkRange(Double.parseDouble(users), 1 , 3);
            this.numberOfUsers  = bathroomUsers;
            return true;

        }catch(DataTypeException  e) { 
            JOptionPane.showMessageDialog(null, "Only Integer values allowed for the bathroom users number");


        }catch(InvalidInputException e) { 
             JOptionPane.showMessageDialog(null, "the  nunber of the bathroom users should be between 1 to 3 ");
        }        

        return false; 
  }
     
    public void setTypeOfTheBathroom() { 
       
        if(this.numberOfUsers > 1) { 
            this.typeOfBathroom = "Shared";
        }else { 
            this.typeOfBathroom = "individual";
        }
    }
    
   @Override
    public void setType () {
        String type = (this.getClass().getSimpleName());
        this.type = type;
    }
 
   @Override
    public boolean setSize(String tolalSize) { 
         try  {
        Validation.isDouble(tolalSize);
        double  size = Double.parseDouble(tolalSize);
        Validation.checkRange(size, 100 ,  200);
                    this.size = size;
                    return true;
              
         }catch(DataTypeException  e) { 
        JOptionPane.showMessageDialog(null, "Only Double values allowed for the size");
        
    }catch(InvalidInputException e) { 
         JOptionPane.showMessageDialog(null, "Sing room size should be between 100 to 200");
    }
        return false;
        
 }
        
    //Display 
   @Override
      public Utility  displayHostal(JTable table,String role,String Id, JPanel parentPanel, JPanel ChildPanel) { 
        Utility ds =new Utility();
        ds = super.displayHostal(table,role,Id,parentPanel,ChildPanel);
        ArrayList<String> columnNames = new ArrayList<>(Arrays.asList("Roomid", "Type", "location", "Size", "Monthly rent", "Deposit", "gender", "Status","type of bathroom", "View"));
         ds.setColumnNames(columnNames);
         if(role.equalsIgnoreCase("admin")) { 
          columnNames = new ArrayList<>(Arrays.asList("roomid", "type", "location", "size", "monthly rent", "gender", "status","View"));
         ds.setColumnNames(columnNames); 
         ds.setType("hostel");
         ds.setNewJframe((new UpdateHostelInformation()));
     } 
        ds.setType("single");
        ds.displayOnJTable();
        return ds;
   }
        
        
        
   // checking data 
    public boolean checkData(String location, String status,String description,String  gender ,String bathroomSize, String numberOfUsers, String size){ 
      if(!super.checkData(location, status, description, gender,bathroomSize)) return false;     
      if(!setNumberOfUsers(numberOfUsers)) return false; 
      if(!setSize(size)) return false; 
      setTypeOfTheBathroom();
     return true; 
    } 
       
    
    
    //getInfo 
   @Override
       public HashMap getInfo() { 
         HashMap <String, String> data = new HashMap<String, String>(); 
         data = super.getInfo();
         data.put("bathroom users", String.valueOf(numberOfUsers).toLowerCase()); 
         data.put("type of bathroom", this.typeOfBathroom.toLowerCase()); 
         return  data;
     }

}

