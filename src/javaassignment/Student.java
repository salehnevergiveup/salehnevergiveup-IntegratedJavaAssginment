/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment;

import Messages.Message;
import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;

/**
 *
 * @author User
 */
public class Student extends User {
    
    private String tPNumber;
    public Student(){}
    public Student(String userName) { 
        super(userName);
    }
    //constrctor
//    public Student(String name,String userName , String password, String email,String address,String role,String tpNumber){ 
//        super(name, userName, password, email, address, role);
//        this.tPNumber = tpNumber;
//        
//    } 
//    
    
    //getter
    public String getTPNumber() { 
        return this.tPNumber;
    }
    


    
    
    //methods 
    public  boolean validateAccountInfo(JPanel panel,String name,String userName,String email, String password, String confirmPassword, String role, String address , String tpNumber) { 
       if(!super.validateAccountInfo(panel, name,userName, email, password, confirmPassword, address,role)) return false;
       if(!Validation.pattrenValidation(tpNumber,"tpNumber")) return false;
       this.tPNumber = tpNumber;
        return true;  
    }
    
    
    //Display inforamtion
    public void diplay(String file,String key,Component...values) { 
        ArrayList<HashMap> stack = new ArrayList<HashMap>(); 
        stack =  fileHandling.search(file, key); 
        for(Object keys:  stack.get(0).keySet()) { 
            for(Component com:   values) { 
            if(com instanceof JLabel) { 
                   if(((JLabel) com).getText().equalsIgnoreCase(keys.toString())) { 
                       ((JLabel) com).setText(stack.get(0).get(keys).toString()); 
                   } 
             }

             if( com instanceof JTextArea) {  
                   if(((JTextArea) com).getText().equalsIgnoreCase(keys.toString())) { 
                       ((JTextArea) com).setText(stack.get(0).get(keys).toString()); 
                   } 
             }

              if(com instanceof JTextField ) { 
                    if(((JTextField) com).getText().equalsIgnoreCase(keys.toString())) { 
                       ((JTextField) com).setText(stack.get(0).get(keys).toString()); 
                    } 
                }
            }
        }
    }

        
    public  void  UpdateDetails(String id, HashMap data) { 
     try { 
          new Utility().modify(fileHandling.UserFile,id ,data);
     }catch(Exception e) { 
          new  Message("Oops, Somthing Went  Wrong  Please  Try Again Later", fileHandling.messageIcon("error")).setVisible(true);

         
     }
     }    
    
    //return student  details
    public Student passStudentDetails(String userName) { 
         HashMap data = (HashMap)fileHandling.search( fileHandling.UserFile,userName).get(0);
                
                Student st = new  Student(userName);
                st.setAddreaa(data.get("address").toString());
                st.setEmail(data.get("email").toString());
                st.setName(data.get("name").toString());
                st.setgender(data.get("gender").toString()); 
                st.setRole(data.get("role").toString());
                return st;
    }
        
    @Override
    public HashMap<String , String> getInfo() { 
        HashMap<String, String> data = new  HashMap <String, String>(); 
        data = super.getInfo(); 
        data.put("tpnumber", this.tPNumber.toLowerCase());
        return data;
    }
    
    
    
    
    
}