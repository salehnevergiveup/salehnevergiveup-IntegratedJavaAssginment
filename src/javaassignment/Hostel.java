/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment;


import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import Messages.*;

/**
 *
 * @author User
 */
//  Single
//Double
//Master
//Whole unit
  
  
//  //so  rent based on the  size  =   size  * 2.5 
//each type of room has a specific size range
//type of the rooms  
//Single
//Double
//Master
//Whole unit 





public abstract class Hostel {
  protected String type; 
  protected  double size; 
  private String roomID; 
  private String location;
  private  String description;
  private String status;
  private  String gender; 
  private double monthlyrent;
  private double deposit;
  
  
  public Hostel(){
      roomID = Validation.generateID(3, 5, fileHandling.HostelFile, "RM");
  }
  public Hostel(String location, String description, String status, String gender)
  { 
      roomID = Validation.generateID(5, 8, fileHandling.HostelFile, "RM");
      this.description = description;
      setLocation(location);
      setStatus(status);   
      setGender(gender); 
  }
  
  //getters 
  public String getType() { 
      return this.type;
  }
  
  public String  getLocation() { 
      return this.location;
  }
  
  public String getStatus() { 
      
      return this.status;
  }

  public String getGander() { 
      return this.gender;
  }
    
  public double getSize() { 
      return this.size;
  }
  
  public double getDeposite() { 
      if(deposit > 0){
          return deposit;
      }
      return getMontlyRent() * 2;  
  }
  
  public double getMontlyRent() { 
      
      if(monthlyrent > 0){
          return monthlyrent;
      }return this.size * 2.5;
  }
  
  public String getDescription() { 
      return this.description;
  }
   
  
  ///setters 
public abstract void setType(); 
  
 public abstract boolean  setSize(String size);
 
  public  void   setGender(String gender) { 
      this.gender = gender;
  }
  public  void   setMonthlyRent(String number) { 
      try{
          Validation.isDouble(number);
          this.monthlyrent= Double.parseDouble(number);
      }catch(NumberFormatException e){
          JOptionPane.showMessageDialog(null, "Invalid monthly rent data");
      }
  }
  public boolean setLocation(String location) { 
       /*if(Validation.checkUserNameEmailPattren(location,"room number")) { */
           this.location = location; 
           return true ;
      //}
       // return false;
  }
 
 public void setDescription(String description) { 
      this.description  = description; 
 }

 public void  setStatus(String status) { 
     
 
        Validation.checkCorrectValue(status , "available" , "not available");
        this.status = status; 
    
 }
 public void setDeposit(double deposit){

          this.deposit= deposit * 2;
 }
 //Display
     //Display 
    public Utility  displayHostal(JTable table,String role,String Id, JPanel parentPanel, JPanel ChildPanel  ) { 
     Utility ds = new  Utility();
     ds.setTable(table);
     ds.setRole(role);
     ds.setCategory("hostel");
     ds.setFileName(fileHandling.HostelFile);
     ds.setId(Id);
     ds.setParentPanel(parentPanel);
     ds.setChildPanel(ChildPanel);
     return ds;
 }
 
 
 // Search 
    
public  void  modifyRoomDetails(String id, HashMap data) { 
     try { 
          new Utility().modify(fileHandling.HostelFile,id ,data);
     }catch(Exception e) { 
          new  Message("Oops, Somthing Went  Wrong  Please  Try Again Later", fileHandling.messageIcon("error")).setVisible(true);

         
     }
}
 
 //check the interface recived data 
 public boolean checkData(String location, String status, String description, String  gender){ 
      //checking the  floor
     
      if(!setLocation(location)) return  false ; 
       
      this.status = status;
      this.description = description;
      this.gender = gender;
   return true; 
}  
     
 public boolean AddHostel(boolean hostel) { 
   
        if(hostel) { 
           return fileHandling.updateFile(fileHandling.HostelFile,getInfo());
        }
           return false;
          }
 
 
 
 
public void bupdateHostelinformation(String filename,String labelid){
       this.roomID = labelid;
       Utility ut = new Utility();
       
       
       
       if(ut.updateInformation(filename, labelid, getInfo())){
            JOptionPane.showMessageDialog(null, "information modified Successfully");
            return;
       }JOptionPane.showMessageDialog(null, "information failed to modify");
}
 
 
   //getInfo function
   public HashMap getInfo() { 
       HashMap<String, String> data = new HashMap<String, String>(); 
      data.put("roomid", roomID.toLowerCase()); 
      data.put("type", type.toLowerCase()); 
      data.put("location", location.toLowerCase()); 
      data.put("description",  this.description.toLowerCase());
      if(this.monthlyrent > 0){
                data.put("monthly rent", String.valueOf(this.monthlyrent));
      }else{
             data.put("monthly rent", String.valueOf(getMontlyRent()));

      }
      data.put("status", status.toLowerCase());
      data.put("size", String.valueOf(size));
      if(this.deposit > 0){
          data.put("deposit", String.valueOf(this.deposit));
      }else{
          data.put("deposit", String.valueOf(getDeposite()));
      }
      
      data.put("gender", this.gender);
       
      return data;
   }
   
}

