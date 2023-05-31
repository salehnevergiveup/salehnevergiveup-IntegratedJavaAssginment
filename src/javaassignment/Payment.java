/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment;

import Messages.*;
import java.util.*;
import javax.swing.*;
import Interface.*;

/**
 *
 * @author User
 */
public class Payment {
    private  String paymentMethod;
    private String  amount; 
    private String paymentId; 
    private  String  userName; 
    private  String name; 
    private  String roomid; 
    private  String status; 
    private  int  issuedMonth; 
    private int  issuedyear;
    private  String  type;
    private double amount1;
    private int duration;
    private String applicationid;
          
    public Payment(double amount,String username, String name,String roomid,int issuemonth,int issueyear,int duration,String applicationid ){
    
            this.amount1 = amount;
            this.userName = username;
            this.name= name;
            this.roomid= roomid;
            this.issuedMonth= issuemonth;
            this.issuedyear = issueyear;
            this.duration = duration;
            paymentId=Validation.generateID(5, 8, fileHandling.paymentFile, "py");
            this.applicationid = applicationid;
    }
    
    public Payment(){};
    
    
    //settters 
     public  void setType(String  type) { 
         this.type = type;
     }
    
    public void setStatus(String status){
        this.status = status;
    }
    //getters 
      public double getamount(){
       if(this.type.equalsIgnoreCase("deposit")){
        return this.amount1* 2;}
       else{return this.amount1;}
    }
     
     
        public  boolean  displayPaymentDetailsPanel(JPanel panel, String paymentId) { 

       try{ 
        Utility ut = new  Utility();
        ut.setId(paymentId);
        ut.setFileName(fileHandling.paymentFile);
        ut.displayOnPanel(panel);
        return true;
      

       
       }catch(Exception e) { 
          
       }
      return false;
    }
    
    
    
    public  boolean  CheckCarddetails(String card, String CCV , String  YY_MM){ 
        boolean flag = true;
        flag =  !(Validation.pattrenValidation(card, "card"))? false: (!Validation.pattrenValidation(CCV, "ccv"))? false : 
                (!Validation.pattrenValidation(YY_MM, "YY/MM"))? false: true; 
        return flag;
        
    }
    //
    public  boolean checkValidCard(String  YYMM) { 
        String [] cardDate = YYMM.split("/"); 
        Utility ut = new  Utility();  
         int  cardYear = Integer.parseInt(cardDate[1]);
         int  cardMonth = Integer.parseInt(cardDate[0]);
         String[]  currentY = ut.getYearMonth()[0].split("");
         int  currentYear = Integer.parseInt((currentY[currentY.length-2] + currentY[currentY.length-1]));
         int  currentMonth = Integer.parseInt(ut.getYearMonth()[1]);
         boolean flag  = true; 
        if(currentYear == cardYear && currentMonth > cardMonth) flag = false;
        else if(currentYear > cardYear ) flag = false;
        
        return flag;
    }
    
    
    //
    public  void  timeConstraint(String  applicationId, int[] info,String userName, JFrame frame) {
    //monthly *duration  + depoist 
    //add paid based on applicationid and  userName
    int duration = info[0];
    int  remainTime = info[1];
    double deposit = 0;
    double payedDeposit = 0;
    double TimePercentage =  (remainTime * 100)/duration;
    double totalPayment= 0; 
    double  monthlyRent = 0;
    String name = "";
     ArrayList <HashMap> paymentData  =  fileHandling.search(fileHandling.paymentFile,applicationId, userName); 
      
     for(HashMap data : paymentData) { 
         if(data.containsValue("deposit")) {
             deposit = Double.parseDouble(data.get("amount").toString());
             if(data.containsValue("paid"))  payedDeposit = deposit;
         }
         else {
         if(data.containsValue("paid")) totalPayment +=  Double.parseDouble(data.get("amount").toString());
         monthlyRent = Double.parseDouble(data.get("amount").toString());    
         
         }
        name  = data.get("name").toString();
     }
       double paymentPercentage  = ((totalPayment + payedDeposit) *100)/ ((monthlyRent + deposit) * duration );
     if(TimePercentage <= 20 && paymentPercentage < 70){ 
         if(remainTime == 0) { new Message("Dear " + name+", Please, complete payment Additional month granted.", fileHandling.messageIcon("waring")).setVisible(true); return;}
        if(remainTime == -1) { 
            new Message("Account suspended. Contact admin to reactivate by completing payment.", fileHandling.messageIcon("stoped")).setVisible(true);
                  HashMap <String , String> lock = new  HashMap<String, String>(); 
                    lock.put("accountstatus", "locked");
                     new  Student().UpdateDetails(userName, lock);
                    new login().logout(frame);
                    return;
        }
        new  Message("Dear " + name + ", please complete the payment to avoid account suspension.",fileHandling.messageIcon("warning")).setVisible(true);
        
     }
    
    
    }
     public  void  UpdateDetails(String id, HashMap data) { 
     try { 
          new Utility().modify(fileHandling.paymentFile,id ,data);
     }catch(Exception e) { 
          new  Message("Oops, Somthing Went  Wrong  Please  Try Again Later", fileHandling.messageIcon("error")).setVisible(true);

 
     }
     }
     
     
     
     ///make  payment  
     public void  makePayment(JTable table,String paymentId,String userName,JRadioButton button , String cardNumber,String ccv, String expairedDate,JPanel parent , JPanel child1 , JPanel child2  ) { 
         Utility ut = new Utility();
         String currentYear = ut.getYearMonth()[0];
         String currentMonth = ut.getYearMonth()[1];
         if(button.isSelected()) {   

           if(CheckCarddetails(cardNumber,  ccv, expairedDate)) { 
               if(checkValidCard(expairedDate)) {
                HashMap <String , String> data = new HashMap(); 
                data.put("status", "paid");
                data.put("payment-year", currentYear);
                data.put("payment-month", currentMonth);
                UpdateDetails(paymentId, data);
                displayPaymentDetailRecord(table, userName, "student", "Payment",parent, child2 );
                new  Utility(parent , child1).displayPanel();
                new MessagePayment(new Receipt(paymentId)).setVisible(true);


                }else { 
                    new Message("Expaired Card Date!!, please  Try With another Card", fileHandling.messageIcon("warning")).setVisible(true);
                }
            }else { 
                 new Message("unValid Card Detial, Please Try Again", fileHandling.messageIcon("warning")).setVisible(true);
        } 
     }else { 
            HashMap<String, String> data = new HashMap();
            data.put("status", "paid");
            data.put("payment-year", currentYear);
            data.put("payment-month", currentMonth);
            UpdateDetails(paymentId, data);
            displayPaymentDetailRecord(table, userName, "student", "Payment", parent, child2);
            new Utility(parent, child1).displayPanel();
            new MessagePayment(new Receipt(paymentId)).setVisible(true);
        }  
    }
      public void adddeposit() { 
        setType("deposit");
        fileHandling.updateFile(fileHandling.paymentFile,getInfo());

    }
      
    public void addAllpayment(){
       adddeposit();
       
       for (int i = 0; i <= this.duration; i++) {
           paymentId=Validation.generateID(5, 8, fileHandling.paymentFile, "py");
           setType("rent");
           fileHandling.updateFile(fileHandling.paymentFile,getInfo());
    if (i == duration) {
        break; 
    }
}
          
      
          
      
      }
    public void deleteoutstandingpayment(String fileName, String...info){
      fileHandling.deleteEntity(fileName, info);
    }
      
      
      public HashMap getInfo() { 
       HashMap<String, String> data = new HashMap<String, String>(); 
      data.put("roomid", roomid.toLowerCase()); 
      data.put("type", type.toLowerCase()); 
      data.put("name", name.toLowerCase()); 
      data.put("username",  this.userName.toLowerCase());
      data.put("payment id",  paymentId.toLowerCase());
      data.put("status", "outstanding");
      data.put("amount", String.valueOf(getamount()));
      data.put("applicationid",applicationid.toLowerCase());
      return data;
   }
   public  void  displayPaymentDetailRecord(JTable table,String Id, String role,String category,JPanel parentPanel, JPanel ChildPanel) { 
     Utility lg = new  Utility();  
     lg.setTable(table);
     
     
     lg.setCategory(category);
     if(!(this.type == null) )  lg.setType(this.type) ;
     else lg.setType("payment");//payment

     
     lg.setFileName(fileHandling.paymentFile);
     lg.setId(Id);
     lg.setRole(role);
     lg.setParentPanel(parentPanel);
     lg.setChildPanel(ChildPanel);
     ArrayList<String> columnNames = new ArrayList<>(Arrays.asList("payment id", "name","username", "type","amount","status", "issue-year" ,"issue-month","view"));
     if(category.equalsIgnoreCase("record") ) {
                columnNames = new ArrayList<>(Arrays.asList("payment id", "name","username", "type","amount", "status", "issue-year" ,"issue-month","payment-year","payment-month"));
     }
     if(category.equalsIgnoreCase("viewstudent") ) {
                columnNames = new ArrayList<>(Arrays.asList("payment id", "name","username", "type","amount", "status", "issue-year" ,"issue-month","payment-year","payment-month"));
     }
     
     lg.setColumnNames(columnNames);
        
        lg.displayOnJTable();
        
    }
}
