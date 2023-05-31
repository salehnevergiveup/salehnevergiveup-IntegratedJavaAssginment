/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment;

import customeExceptions.DataTypeException;
import customeExceptions.InvalidInputException;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public abstract class Room extends Hostel{
     private  double bathroomSize; 
    
     public Room(){};
      
     public Room(String location, String description, String status, String  gender, double  BathroomSize ) {
        super(location, description, status, gender);
         setBathroomSize(String.valueOf(BathroomSize));
        
        
        
    }
     
     //setters 
        public  boolean setBathroomSize(String bathroomSize) { 
        try  {
        Validation.isDouble(bathroomSize);
        double  bathSize = Double.parseDouble(bathroomSize);
        Validation.checkRange(bathSize, 54 , 144);
        this.bathroomSize  = bathSize;
        return true;
   
    }catch(DataTypeException  e) { 
        JOptionPane.showMessageDialog(null, "Only Double values allowed for the Bathroom size");
        
    }catch(InvalidInputException e) { 
         JOptionPane.showMessageDialog(null, "bathroom size should be between  54 and 144");
    }
          return false;
    }
        
     
     
     //getters 
     public double getBathroomSize() { 
         return this.bathroomSize; 
     }
     
     @Override
      public double getMontlyRent() { 
      return (this.size + this.bathroomSize)* 2.5;
    }
     
     //
     public boolean checkData(String location, String status, String description, String  gender, String bathroomSize){ 
      if(!super.checkData(location, status, description, gender)) return false; 
      if(!setBathroomSize(bathroomSize)) return false;
     return true; 
    } 
     
     
     //getInfo 
     @Override
     public HashMap getInfo() { 
         HashMap <String, String> data = new HashMap<String, String>(); 
         data = super.getInfo();
         data.put("bathroom Size", String.valueOf(bathroomSize).toLowerCase()); 

         return  data;
     }
}
