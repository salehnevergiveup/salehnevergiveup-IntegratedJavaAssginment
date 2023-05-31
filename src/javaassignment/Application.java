/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment;
import Messages.Message;
import java.lang.reflect.Array;
import customeExceptions.DataTypeException;
import javax.swing.*; 
import java.util.*;
import Interface.*;

/**
 *
 * @author User
 */
public class Application {
    private String userName; 
    private String  applicationId; 
    private String name; 
    private String email; 
    private String status; 
    private  int  duration; 
    //----------------------
    private  String roomid; 
    private String roomType; 
    private  double  monthlyRent; 
    private  double  deposit;
    private int year;
    private int month;
    
    
   
    
    public  Application() { 
        
        status = "pending"; 
        applicationId = Validation.generateID(5, 8,  fileHandling.appFile, "app"); 
    }
    
    public Application(String applicationid,String username,String name,String email,String roomid,String type,double montlyrent,double deposit,int duration,int year,int month){
        this.userName = username;
        this.applicationId = applicationid;
        this.name = name;
        this.email = email;
        this.roomid = roomid;
        this.roomType = type;
        this.monthlyRent = montlyrent;
        this.deposit = deposit;
        this.duration = duration;
        this.year = year;
        this.month = month;
    
    }

    //settres 
    public boolean  setUserName(String userName) { 
         if(!Validation.pattrenValidation(userName, "userName")) return false; 
         this.userName = userName;
         return true;
        
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean setEmail(String email) {
         if(!Validation.pattrenValidation(email, "email")) return false;
         this.email = email;
         return true;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setMonthlyRent(double monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }
     
    //getters 
    public String getYear() {
        Calendar calendar = new GregorianCalendar(); 
       //get the  current  date
       String year  =  String.valueOf(calendar.get(Calendar.YEAR)); 
        return year;
    }
    
    public String getStatus(){
        return this.status;
    }
    public String getMonth() {
        Calendar calendar = new GregorianCalendar(); 
       //get the  current  date
       String month  =  String.valueOf(calendar.get(Calendar.MONTH)); 
        return month;
    } 
    public int getDuration() {
        return duration;
    }

    public double getMonthlyRent() {
        return monthlyRent;
    }

    public double getDeposit() {
        return deposit;
    }
    
    public void displayApplicationDetails(JTable  table, String id, String role, JPanel paretnPanel, JPanel childPanel) {
        Utility ut = new  Utility();
        ut.setCategory("record");
        ut.setType("application");
        ut.setTable(table);
        ut.setRole(role);
        ut.setChildPanel(childPanel);
        ut.setParentPanel(paretnPanel);
        ut.setId(id);
        ut.setFileName(fileHandling.appFile); 
        ArrayList<String> columnNames =  new ArrayList<String>(Arrays.asList("application id","name","username","email", "year", "month","status","duration","roomid","type","monthly rent","deposit"));
        if(role.equalsIgnoreCase("admin")){
           columnNames =  new ArrayList<String>(Arrays.asList("application id","name","username", "year", "month","status","duration","roomid","type","View"));
        }
        ut.setColumnNames(columnNames);
        ut.displayOnJTable();
    }
    
     public  boolean  displayApplicationDetailsPanel(JPanel panel, String  userName) { 
       String fileName = fileHandling.appFile;
       try{ 
       ArrayList<HashMap> application = new ArrayList <HashMap>();
       application = fileHandling.search(fileName, userName); 
       for(HashMap map : application) { 
       if(map.get("status").equals("pending") || map.get("status").equals("accepted")  ) { 
        Utility ut = new  Utility();
        ut.setId(map.get("application id").toString());
        ut.setFileName(fileHandling.appFile);
        ut.displayOnPanel(panel);
        return true;
       } 
       }
       
       }catch(Exception e) { 
           
       }
      return false;
    }
     
    public boolean checkData(String name, String  userName, String email,int duration,String roomid,double  monthlyRent,String roomType ,double  deposit) { 
        if(!Validation.pattrenValidation(userName, "userName")) return false; 
        if(!Validation.pattrenValidation(email, "email")) return false; 
        setName(name); 
        setUserName(userName);
        setEmail(email);
        setDuration(duration);
        setRoomid(roomid); 
        setMonthlyRent(monthlyRent);
        setRoomType(roomType);
        setDeposit(deposit);
        
        return true;
    }
    //got issue
    public boolean addApplication(boolean application) { 
        if(application) return (fileHandling.updateFile(fileHandling.appFile, getInfo()));

        return false; 
        
    }
    public  int[] applicationCounter(String userName) { 
        int [] info= {0,0};
        try { 
            
            HashMap<String, String> app = (HashMap)fileHandling.search(fileHandling.appFile, userName, "accepted").get(0); 
            
            Validation.isInt(app.get("year")); 
            Validation.isInt(app.get("month")); 
            Validation.isInt(app.get("duration")); 
            int  appYear = Integer.parseInt(app.get("year"));
            int  appMonth = Integer.parseInt(app.get("month"));
            int  duration  = Integer.parseInt(app.get("duration"));
            int  currentYear = Integer.parseInt( new Utility().getYearMonth()[0]); 
            int  currentMonth = Integer.parseInt( new Utility().getYearMonth()[1]); 
             info[0] = duration;  
             info[1] = duration - ((((currentYear - appYear )* 12) + currentMonth)  - appMonth ) ;
             
            
        }catch(DataTypeException e) { 
            
        }catch(ArrayIndexOutOfBoundsException e){}
        
        return info;
    }
    
    public void acceptapplication(String filename,String filename2,String labelid,String roomid,String status){
        
       
       this.applicationId = labelid;
       this.status = "accepted";
       Utility na = new Utility();
      
       
       if(na.updateInformation(filename, labelid, getInfo())){
            ArrayList <HashMap> stack =fileHandling.fileReader(filename2);
            System.out.println(stack);
            fileHandling.clearFile(filename2);
             for (int i = 0 ; i < stack.size(); i++) {
            if (stack.get(i).containsValue(roomid)) {
                // Modify the status key of the matching hashmap
                stack.get(i).put("status", "notavailable");
            }
            fileHandling.writeToTheFile(filename2, stack.get(i));
        }
            
            JOptionPane.showMessageDialog(null, "application accepted");
            return;
       }JOptionPane.showMessageDialog(null, "application failed to be accepted");
   
}
    
    public void rejectapplication(String filename,String labelid,String status){
       
       
       this.applicationId = labelid;
       this.status = "rejected";
       Utility na = new Utility();
      
       
       if(na.updateInformation(filename, labelid, getInfo())){
            JOptionPane.showMessageDialog(null, "application rejected");
            return;
       }JOptionPane.showMessageDialog(null, "application failed to be rejected");
    
}

public void cancelapplication(String filename,String labelid){
    
       this.applicationId = labelid;
       this.status = "cancelled";
       Utility na = new Utility();
       
       
       
       if(na.updateInformation(filename, labelid, getInfo())){
            JOptionPane.showMessageDialog(null, "application cancelled");
            return;
       }JOptionPane.showMessageDialog(null, "application failed to be cancelled");
}
    
    public void displayedroomdetails(String filename , String word, JPanel panel){
    
        Utility uttt = new Utility();
        uttt.setFileName(filename);
        uttt.setId(word);
        uttt.displayOnPanelwithmultivalue(panel);
    }
    
    public  HashMap getInfo() { 
        HashMap <String , String> data = new  HashMap<String ,String>(); 
        data.put("name", name.toLowerCase()); 
        data.put("username", userName.toLowerCase());
        data.put("email",  email.toLowerCase()); 
        data.put("application id",  applicationId.toLowerCase());
        data.put("status",  status.toLowerCase()); 
        data.put("duration",   String.valueOf(duration).toLowerCase()); 
        data.put("roomid", roomid.toLowerCase()); 
        data.put("monthly rent", String.valueOf(monthlyRent)); 
        data.put("type", roomType.toLowerCase()); 
        data.put("deposit", String.valueOf(deposit));
        data.put("year", getYear());
        data.put("month", getMonth());
        return data; 

    }
    
    public  boolean makeApplication(String roomId, String userName, String  email, String name, int  duration , double monthlyRent, String type, double deposit){ 
        try{
            Application app = new  Application(); 
            boolean flage=  app.checkData(name, userName, email,duration , roomId, monthlyRent, type, deposit);
       
       if(flage) { 
            if(app.addApplication(flage)){                 
            HashMap data = new  HashMap();
            data.put("status", "not avaliable");
            new Single().modifyRoomDetails(roomId,data);
            new  Message(" Congratulations! Your application has been completed successfully!", fileHandling.messageIcon("done")).setVisible(true);
               return true;
            }
       } else { 
            new  Message("invalid information provided" , fileHandling.messageIcon("warning")).setVisible(true);
            }
        } 
       catch(Exception e) { 
           new  Message("Oops, Somthing Went  Wrong  Please  Try Again Later", fileHandling.messageIcon("error")).setVisible(true);
        }
          return false;
     }
    
}
