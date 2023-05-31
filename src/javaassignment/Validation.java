///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
package javaassignment;

import customeExceptions.*;
import java.awt.Component;
import java.util.HashMap;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/**
 *
 * @author User
 */
public abstract class Validation  {
    //valtdation class 
    //validate the  password
     public static boolean checkPassword(String password , String password2) { 
      if(password.equals(password2) && password.length() > 8) {
          return true; }
   JOptionPane.showMessageDialog(null, "both passwords should be the same and the password lenght should be larger then 7 chars " , "Warning", JOptionPane.WARNING_MESSAGE);

    return false;  
  }
     
 // chech gender 
     public static boolean gender(String  gender) { 
         if(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")|| gender.equalsIgnoreCase("none")) { 
             return true; 
         }
         return false;
     }
     
 // check userName  pattern 
  public static  boolean  pattrenValidation(String input , String type) { 
      
     // strat with letter  consits of letters and numbers
     String pattern = (type.equalsIgnoreCase("userName"))? "^[A-Za-z]+[A-Za-z0-9_]*$" :(type.equalsIgnoreCase("email"))?"^[a-zA-Z0-9._%+-]+"
             + "@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$":(type.equalsIgnoreCase("location"))? "^[1-9]-[1-9]$" : (type.equalsIgnoreCase("card"))? "^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14}|6(?:011|5[0-9]{2})[0-9]{12}|3"
             + "[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\\d{3})\\d{11})$" : (type.equalsIgnoreCase("YY/MM"))?"^(0[1-9]|1[0-2])\\/(\\d{2})$":(type.equalsIgnoreCase("CCV"))? "^[0-9]{3,4}$" : "^([tT][pP]\\d{6})$";
     String str = input;
     Pattern regex = Pattern.compile(pattern); // create pattren object 
     Matcher match =  regex.matcher(str);//create a matcher object
     

     boolean flag = true; 
     if(!match.matches()) { 
         if( (type  == "userName" || type == "Email") && str.length() < 5) { 
        JOptionPane.showMessageDialog(null, "invaled " + type.toUpperCase(), "Warning", JOptionPane.WARNING_MESSAGE);
        flag  = false; } else { 
              JOptionPane.showMessageDialog(null, "invaled " + type.toUpperCase(), "Warning", JOptionPane.WARNING_MESSAGE);
        flag  = false;
         }
     }
    
     
      return flag;
  }
  


  //existance of empty fields 
  public static boolean checkEmptyFields(JPanel panel) {
      
    
    for (Component i : panel.getComponents()) {
        if (i instanceof JPanel) {
            boolean result = checkEmptyFields((JPanel) i);
            if (!result) {
                return false;
            }
        }

        if (i instanceof JTextField) {
            if (((JTextField) i).getText().trim().isEmpty()) {
                return false;
            }
        }
    }
    return true;
}
     
  
  /// genrate a random useranme 
  public static String generateID(int minLenght , int maxLength, String fileName, String ID) { 
       Random rand = new Random(); 
       int interval = (maxLength > minLenght)? maxLength - minLenght: minLenght - maxLength;
       int length =  minLenght + rand.nextInt(interval);
       String str = ID;
       for(int i = 0 ; i <= length; i++) str += rand.nextInt(9);
       return (fileHandling.checkFile(fileName, str.toLowerCase()).size() > 0) ? generateID(minLenght,maxLength,fileName, ID) : str;

}
  


//datatype 

//integer 
public static boolean isInt(String str) { 
     try { 
         Integer.parseInt(str);
         return true;
         
     }catch(Exception e) {
        throw new DataTypeException("Invalid data type: " + str);
         
     }
     
}
//double 
public static void isDouble(String str) { 
      try {
            Double.parseDouble(str);
        } catch (NumberFormatException e) {
            throw new DataTypeException("Invalid data type: " + str);
            
        }
     
}
//Alphpatic String 
public static void isAlpha(String str) {
    String regex = "^[a-zA-Z\\s]+$"; 
    if(!str.matches(regex))  { 
        throw new IllegalArgumentException("Invalid String value: ");
    }
}
  
//range 
public static void checkRange(double value, double... range){
    if (range.length > 1) {
        if  (value < range[0] || value > range[1]) { 
         throw new InvalidInputException("Invalid value: "); }
    }
    else if (value < range[0])  {
        throw new InvalidInputException("Invalid value: ");
    } 
    return;
}



public static void checkCorrectValue(String value , String...values){ 
    boolean flage = false;
    for(String st : values) { 
        if(st.equalsIgnoreCase(value) ) { 
            flage = true;
            return;
        }
    }
    throw new DataTypeException("Invalid data type: ");
}

  
}


