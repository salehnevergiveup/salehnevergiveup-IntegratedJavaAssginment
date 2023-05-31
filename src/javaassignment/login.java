/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment;


import Interface.Login;
import Messages.Message;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.*;


/**
 *
 * @author User
 */
public class login {
   private  String userName;  
   private  String role; 
   private  String address; 
   private String name;
   private String email;
   private  String  type;
   private String category;
   
   
   public String  getuserName() { 
       return this.userName;
   }
   
   
   public String getrole() { 
       return this.role;
   }
   
   //login to the  system
   public boolean loginToAccount(String userName , String password){ 
       //check if the user is correct 
       // recived from the  interFace
       userName = userName.toLowerCase(); 
       password = password.toLowerCase();
       
       //check the  pattern of the  user name  frist
       if(!Validation.pattrenValidation(userName , "userName")) { 
           JOptionPane.showMessageDialog(null, "un acceptable username format");
           return false;
       }

       //check the userName and the  password in the  file 
       if(fileHandling.search( fileHandling.UserFile,userName,  password).size() == 0)  { 
           new Message("Icorrect UserName or Password",fileHandling.messageIcon("warning")).setVisible(true);
          return false;
       }
       
       //check if the account stoped 
        if(fileHandling.search( fileHandling.UserFile,userName,  password, "locked").size() == 1)  { 
           new Message("This Account is suspending contact the  admin for farther information",fileHandling.messageIcon("stoped")).setVisible(true);
          return false;
       }
       //record login information
       this.userName = userName;
       //get the  role of the user name based on the  user name.
       ArrayList <HashMap> stack = fileHandling.search( fileHandling.UserFile , userName); 
       
       try { 
           if(stack.size()== 1) { 
               this.role = stack.get(0).get("role").toString();
               this.name = stack.get(0).get("name").toString();
               this.address = stack.get(0).get("address").toString();
               this.email  = stack.get(0).get("email").toString();
           }else { 
                throw new IllegalArgumentException("");
           }
           
       } catch(IllegalArgumentException e) { 
           new Message("Oops, Messing information",fileHandling.messageIcon("error")).setVisible(true);
           return false;
                   
        }
        
       // store the login information in the  login file.
       fileHandling.writeToTheFile( fileHandling.LoginFile, getInfo());
       
    return true;     
   }
   
  
   
   public void logout(JFrame frame) { 
       new  Login().setVisible(true);
       frame.setVisible(false);
   }
   
   //return the login informaton that will be stored  
   public HashMap getInfo() { 
       
       HashMap<String, String> data =  new HashMap<String, String>(); 
        LocalTime time = LocalTime.now();
        // Define the desired format
        DateTimeFormatter f = DateTimeFormatter.ofPattern("HH|mm|ss");

       
       //push the login data to the hashMap 
       data.put("username", this.userName); 
       data.put("role", this.role);
       data.put("name", this.name);
       data.put("address", this.address);
       data.put("email", this.email);
       data.put("year",  new Utility().getYearMonth()[0]);
       data.put("month",  new Utility().getYearMonth()[1]);
       data.put("day",  new Utility().getYearMonth()[2]);
       data.put("time", time.format(f));

       
       //return the hashMap
       return data;
   }
    //Display the  login  information 
   public void displayLoginDatails(JTable table,String role,String id, JPanel parentPanel, JPanel ChildPanel) { 
       Utility lg = new  Utility();  
     lg.setTable(table);
     lg.setRole(role);
     lg.setCategory("record");
     lg.setType("login");
     lg.setFileName(fileHandling.LoginFile);
     lg.setId(id);
     lg.setParentPanel(parentPanel);
     lg.setChildPanel(ChildPanel);
     ArrayList<String> columnNames = new ArrayList<>(Arrays.asList("name", "username",  "time","year","month", "address" ,"role"));
     lg.setColumnNames(columnNames);
        
        lg.displayOnJTable();
       
   }
}
