/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public abstract class fileHandling {
    
    public final static String UserFile = "/Users/gohyanxi/Library/CloudStorage/OneDrive-AsiaPacificUniversity/JAVA/AdminPart/src/Files/user.txt";
    public final static  String LoginFile = "/Users/gohyanxi/Library/CloudStorage/OneDrive-AsiaPacificUniversity/JAVA/AdminPart/src/Files/login.txt";
    public final static  String HostelFile = "/Users/gohyanxi/Library/CloudStorage/OneDrive-AsiaPacificUniversity/JAVA/AdminPart/src/Files/hostel.txt";
    public  final static String paymentFile=  "/Users/gohyanxi/Library/CloudStorage/OneDrive-AsiaPacificUniversity/JAVA/AdminPart/src/Files/Payment.txt"; 
    public final static String appFile = "/Users/gohyanxi/Library/CloudStorage/OneDrive-AsiaPacificUniversity/JAVA/AdminPart/src/Files/Application.txt";
     
//read file
    //return all the file data into 
    // Arraylist of hashMaps 
    
    
 //File  Reader  read the text File    
 public static ArrayList<HashMap> fileReader(String fileName) {
 HashMap<String, String>  data = new HashMap<String ,String>(); 
 ArrayList<HashMap> stack = new  ArrayList<HashMap>(); 
 try { 
    Scanner file = new Scanner(new FileReader(fileName));
     while(file.hasNext()) { //if there is line in the  file go inside the loop
          String str = file.nextLine();
          
         if(str.equals("}")) { 
             stack.add(new HashMap<> (data)); 
             continue;
         }
        
         String [] arr = str.toString().split(": *"); 
         if(arr.length > 1) {
         data.put(arr[0].trim().toLowerCase(),arr[1].trim().toLowerCase());
         }
     }     

 }  catch (Exception e) { 
     
     System.out.println("file not found");
        
 }
return stack;
}

 
//update file  
 
public static boolean updateFile(String fileName, HashMap data) {
    // udate the user file
    if(data.containsKey("username") && data.containsKey("password")) { 
        if(data.containsKey("tpnumber")) { 
            // will return the  prepated values
            //student
            if(repatedValues(fileName, data.get("username").toString(),data.get("tpnumber").toString()))   return false; 
            writeToTheFile(fileName, data); 
              
         }else { 
            //admin
             if(repatedValues(fileName, data.get("username").toString())) return false;
             writeToTheFile(fileName, data);     
        }
        
        //file of the  room
        }else if(data.containsKey("roomid") && !data.containsKey("paymentid")) { 
            if(repatedValues(fileName, data.get("location").toString())) return false;
            writeToTheFile(HostelFile, data); 
            
        }else if(data.containsKey("paymentid" )&&data.containsKey("username" )) { 
             //writeToTheFile(RecordFile, data); 
             writeToTheFile(paymentFile, data);
        }
    //complete for the  other files 

    return true;
}

//write to the  file  user infomation 
public static void writeToTheFile(String fileName, HashMap data) { 
     try { 
        
    PrintWriter update = new PrintWriter(new FileWriter(fileName, true)); 
    
    update.println("{");
    for(Object i : data.keySet()) {
        
        update.println(i.toString().toLowerCase() + ": " +  data.get(i).toString().toLowerCase());
    }
    update.println("}");
    update.flush();
    update.close();
    return;
    } catch(Exception e)  { 
        
        JOptionPane.showMessageDialog(null, "Failed to update the data" ); 
        return;
    }
     

    
}
 
 
// check file //return
//the  pupose is to know  if values exist in the  file or not
//returnin array of the  values existed
public static ArrayList checkFile(String fileName, String...values) { 
    ArrayList <String> info = new ArrayList<String>();
    ArrayList <HashMap> stack = new ArrayList<HashMap>();
    stack = fileReader(fileName);
    for(HashMap data : stack) { 
        for(String v : values) { //[Elton123]
            v = v.toLowerCase();
        
            if(data.containsValue(v) && !info.contains(v)) { 
                info.add(v);
            }
        }
        
    }
    return info;
}
//check repated values 
public static boolean repatedValues(String fileName,String...values) {
    ArrayList<String> info = checkFile(fileName, values);
    int lenght = info.size();
    //if Info > 0 that's mean there is a repeted data
    if(lenght > 0 ) { 
        String str = String.join(" and ", info.toString());
        str += (lenght > 1)? " are already existed with in the  system":  " is already existed with in the  system";
        JOptionPane.showMessageDialog(null, str );
        return true;
    } 
       
 return false;
    
}


 ///Search  
public static ArrayList search(String fileName , String...values) {
    ArrayList<HashMap> stack = fileReader(fileName);
    ArrayList<HashMap> matched = new  ArrayList<HashMap>();
    
    boolean containAll = true; 
    for(HashMap data : stack) { //each hashmap from the stack
        for(String v : values) { //each values in each hashmap
       
            v = v.toLowerCase();
            if(!data.containsValue(v)) { 
                containAll = false;
                break;
            }
           containAll = true; 
        }
        
        if(containAll) { 
            matched.add(data);//add the data that match with the datainput
           //JOptionPane.showMessageDialog(null, matched, "Error", JOptionPane.ERROR_MESSAGE);

        }
        
    }
    
    return matched;
}






// clear the  file 
//this  used to delete the  file componets
public static void clearFile(String fileName) { 
    try {
        PrintWriter clear = new   PrintWriter(new FileWriter(fileName, false) );  
        clear.print("");
        clear.flush();
        clear.close();
             
    }catch(Exception e) { 
        JOptionPane.showMessageDialog(null, "can not clear the  file!!!");
    }
}

/// modify function 
public static boolean modify(String fileName,String id,HashMap data) { 
    ArrayList<HashMap> stack = fileReader(fileName);
    boolean flag = false; 
    clearFile(fileName);
    for(HashMap oldData : stack) { 
        if(oldData.containsValue(id)) {
             for(Object keys : data.keySet()) { 
                oldData.put(keys, data.get(keys));
                flag = true;
             }
        }
              
             writeToTheFile(fileName, oldData);
        } 
      
        return flag;
    }

//public static void modifyFile(String fileName,HashMap oldData,HashMap data) { 
//    ArrayList<HashMap> stack = fileReader(fileName);
//    clearFile(fileName);
//    for(int i = 0 ; i < stack.size(); i++) { 
//        for(Object keys : data.keySet()) {
//            keys = keys.toString().toLowerCase();
//            if(!oldData.containsKey(keys)) { 
//                stack.get(i).put(keys, data.get(keys)); 
//                
//            }else  { 
//                if(oldData.get(keys).equals(stack.get(i).get(keys))) { 
//                    stack.get(i).put(keys, data.get(keys)); 
//                }
//            }
//        }
//        writeToTheFile(fileName, data);
//    }
//
//}


 
//////
public  static boolean ModfiyEntity(String fileName,String id,HashMap info) { 
    ArrayList<HashMap> stack = fileReader(fileName);
    int counter = 0;
    clearFile(fileName);
    for(int i = 0 ; i < stack.size(); i++) { 
        if(stack.get(i).containsValue(id.toLowerCase())) { 
            stack.remove(i); 
            stack.add(info);
            counter ++;
        }writeToTheFile( fileName , stack.get(i));
        
    }
    if (counter > 0)return true;
    return false;
    //
    
}
    









//Delete functions

/// used to delete an entity from the file 
public static void  deleteEntity(String fileName, String...info) { 
//    ArrayList<HashMap> stack = fileReader(fileName);

    ArrayList<HashMap> matched =  search(fileName , info);
    ArrayList<HashMap> stack = fileReader(fileName);
    clearFile(fileName); 
    for(int  i =0 ; i < stack.size(); i++)  { 
        if(matched.contains(stack.get(i))) { 
            stack.remove(i);
           JOptionPane.showMessageDialog(null, "record removed");
        }
        
        writeToTheFile( fileName , stack.get(i));
    }
    
    
    
}


public static void Delete(String fileName, HashMap info, boolean all ) { 
    ArrayList<HashMap> stack = fileReader(fileName); 
    
    for(int i = 0 ; i < stack.size() ; i++) { 
        if(all) { 
            for(Object keys : info.keySet()) { 
                 if(stack.get(i).get(i).equals(info.get(keys).toString().toLowerCase())) { 
                     stack.remove(i);
                     break; 
                 }
            }
           
            
        }else { 
            for(Object keys : info.keySet()) { 
                 if(stack.get(i).get(i).equals(info.get(keys).toString().toLowerCase())) { 
                     stack.get(i).put(keys, "");
                 }
            
        }
        
    }
  }
} 
   
public static  String messageIcon(String  messageType){ 
    String path = "C:\\Users\\User\\OneDrive - Asia Pacific University\\Desktop\\coures\\year Two\\Semester one\\Object Oriented Programming Java\\Assignments\\JavaAssignment\\JavaAssginment\\src\\Icons\\"; 
    switch(messageType) { 
    case "error": 
        return path+"error.png"; 
    case "greeting": 
        return path+ "hello.png"; 
    case  "warning": 
        return path+"Warning.png";
    case "done": 
        return path+"okay.png";
    case "stoped": 
        return path+"closed.png";
    default: 
        return path+"okay.png";
   } 
}
    
}



 