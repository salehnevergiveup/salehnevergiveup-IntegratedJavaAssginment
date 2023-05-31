/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment;
import java.util.HashMap;
import Messages.Message;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author User
 */

//inherit by the student and admin class;
public abstract class User {
    private  String userName; 
    private  String password;
    private String name; 
    private  String gender;
    private  String  address;   
    private  String email;
    private String role;

public User() {}
public User(String userName) { 
    this.userName = userName;
}

    
    //setters 
    public void setName(String name) { 
        this.name = name;
    }
    
    public void  setPassword(String password) { 
        this.password = password;
    }
    
    public void  setAddreaa(String address) { 
        this.address = address;
    }
    
    public void  setEmail(String email) { 
        this.email = email;
    }
    
    public  void setgender(String gender) { 
        this.gender = gender; 
    }
    
    public  void setRole(String role) { 
        this.role = role; 
    }
    
    //getters 
    public String getUserName() { 
        return this.userName;
    }
    
    public String getName() { 
        return this.name;
    }
    
    public String getPassword() { 
        return this.password;
    }
    
    public String getEmail(){ 
        return this.email;
    }
    
    public  String getAddress() { 
        return this.address;
    }
    
    public String  getGender() { 
        return this.gender;
    }
    
    public  String getRole(){ 
        return this.role;
    }
    
    //check user information before creating account.
    public  boolean validateAccountInfo(JPanel panel,String name,String userName,String email, String password, String confirmPassword, String role, String address) {  
        //check there is no empty fields in the program
        if(!Validation.checkEmptyFields(panel)) { 
         JOptionPane.showMessageDialog(null, "Please fill up all the fields", "Warning", JOptionPane.WARNING_MESSAGE);
         return false;
    }  
        
        //Check the username pattren   
    if (!Validation.pattrenValidation( userName,  "userName"))  {  
       //generate a random userName. 
        new Message("Usernames should begin with a letter,with length > 5", fileHandling.messageIcon("warning")).setVisible(true);
     
     return false;
   }
   
    //validate email
   if (!Validation.pattrenValidation(email,  "email")) return false;

   //checking the  password 
   if(!Validation.checkPassword(password  ,confirmPassword)) return false;
       
    //check if the userName exsit 
    if(fileHandling.repatedValues(fileHandling.UserFile,userName.toLowerCase()) ) { 
        
    }   
       
       
       this.name =name.toLowerCase(); 
       this.userName = userName.toLowerCase();
       this.email = email.toLowerCase(); 
       this.password = password.toLowerCase(); 
       this.role = role.toLowerCase();
       this.address = address.toLowerCase();
        
        return true;
        
    }
    
    //create account of all the  data vaild
    public boolean createAccount(boolean createAccount) { 
        if(createAccount) { 
            fileHandling.updateFile(fileHandling.UserFile,getInfo());
            return true;
        }
        return false;
    }
    
  
    public void displayeddetails(String filename , String word, JPanel panel){
    
        Utility uttt = new Utility();
        uttt.setFileName(filename);
        uttt.setId(word);
        uttt.displayOnPanel(panel);
    }
    
    ///get info  
    //HashMap  with all the informations 
    public HashMap<String , String> getInfo() { 
        HashMap<String, String> data = new  HashMap <String, String>(); 
        
        data.put("username", this.userName.toLowerCase());
        data.put("name", this.name.toLowerCase());
        data.put("password", this.password.toLowerCase());
        data.put("email", this.email.toLowerCase());
        data.put("address", this.address.toLowerCase());
        data.put("role", this.role.toLowerCase());
        data.put("gender", this.gender.toLowerCase());
        return data;   
    }
    
}
