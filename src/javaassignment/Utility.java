/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment;

import CellButton.TableActionCellEditor;
import CellButton.TableActionCellRender;
import CellButton.TableActionEvent;
import java.awt.*; 
import java.util.*;
import javax.swing.*; 
import javax.swing.table.DefaultTableModel;
import Interface.*;
import static javaassignment.fileHandling.UserFile;


/**
 *
 * @author User
 */
public class Utility {
    private  String  id; //id of the  user/ room / recod /payment 
    private String fileName;//any file  name 
    private  String  category; // user/ room/recod/payment
    private  JTable table ;  //the target JTable
    private  JPanel parentPanel; // parent panel
    private  JPanel childPanel; // child panel
    private  String  role; // Admin / Student 
    private  String type;// type of the rooms or the recod 
    private  ArrayList<String> columnNames;// the column name  need to display in the tabel 
    // columns name  should match the  keys of the  entity in the text file
    private String []searchData;
    private JFrame currentjframe;
    private JFrame newjframe;
    
    public Utility() { 
        
    }
    public Utility(JPanel parent , JPanel child) { 
        this.parentPanel = parent; 
        this.childPanel = child;
    }
    
    public Utility(String id, String  category,ArrayList<String> columnNames, String fileName, JTable table,JPanel parentPanel, JPanel childPanel, String  role, String type ) { 
        this.id = id;// 
        this.fileName  = fileName; 
        this.table = table; 
        this.parentPanel = parentPanel; 
        this.childPanel = childPanel;
        this.role  = role; 
        this.type = type;
        this.category = category;
        this.columnNames = columnNames;
        

        
        
    }
    //getters
    public String getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public String getCategory() {
        return category;
    }

    public JTable getTable() {
        return table;
    }

    public JPanel getParentPanel() {
        return parentPanel;
    }

    public JPanel getChildPanel() {
        return childPanel;
    }

    public String getRole() {
        return role;
    }

    public String getType() {
        return type;
    }

    public ArrayList<String> getColumnNames() {
        return columnNames;
    }
    // setters 
    public void setId(String id) {
        this.id = id;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public void setParentPanel(JPanel parentPanel) {
        this.parentPanel = parentPanel;
    }

    public void setChildPanel(JPanel childPanel) {
        this.childPanel = childPanel;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setColumnNames(ArrayList<String> columnNames) {
        this.columnNames = columnNames;
    }
    
    public void setNewJframe(JFrame aa){
        
            this.newjframe = aa; 
    }
    
    public void setOldJframe(JFrame aa){
        
            this.currentjframe = aa; 
    }
    
    //Get data from the file
    // getting the  matched components 
    //it will used when we display the file data on the  compnent  
    // the  component should have inside the  text that match the  keys
    // in the  file
    public HashMap findMatchedComponents(JPanel panel ) {
        HashMap<String, Component> com = new  HashMap<String,Component>();
        for(Component c : panel.getComponents()) { 
            
            if(c instanceof JPanel)  { 
                com.putAll(findMatchedComponents((JPanel)c)); 
                
            }
            if(c instanceof JLabel) { 
                 com.put(((JLabel) c).getText(), c);
            }
            if(c instanceof JTextArea) { 
                 com.put(((JTextArea) c).getText(), c);
            }
            if(c instanceof JTextField){ 
                 com.put(((JTextField) c).getText(), c);
            }

            
        }
        
        return com;
    }
    
    //Display part-------------------------------------------------------------------------------------------------
    //Display information the panel components 
    public void  displayOnPanel (JPanel panel) { 
        //since  this will always fetch one  entiry I assign it to the  HashMap instad of ArrayList
       HashMap<String, String> entity = (HashMap)fileHandling.search(fileName, id).get(0); 
        
        
        HashMap<String, Component> cm = findMatchedComponents(panel); 
        
        for(Object Key: cm.keySet()) {  
           
            //the componets should have a taxt in them that match the key in the  file 
            if(entity.containsKey(Key)) { 
                if(cm.get(Key) instanceof JLabel) { // if the element  is label
                     ((JLabel)cm.get(Key)).setText(entity.get(Key)); //take the 
                }
                if(cm.get(Key) instanceof JTextArea) { // if the element is atextArea
                     ((JTextArea)cm.get(Key)).setText(entity.get(Key)); 
                }
                if(cm.get(Key) instanceof JTextField){ //if the  element  is text field
                     ((JTextField)cm.get(Key)).setText(entity.get(Key)); //use key with both  components and the file  data to ensure matching
                }
              
            }
        }
    }
        
    public void  displayOnPanelwithmultivalue (JPanel panel) { 
        //since  this will always fetch one  entiry I assign it to the  HashMap instad of ArrayList
       HashMap<String, String> entity = (HashMap)fileHandling.search(fileName, id,"accepted").get(0); 
        
        HashMap<String, Component> cm = findMatchedComponents(panel); 
        
        for(Object Key: cm.keySet()) {  
           
            //the componets should have a taxt in them that match the key in the  file 
            if(entity.containsKey(Key)) { 
                if(cm.get(Key) instanceof JLabel) { // if the element  is label
                     ((JLabel)cm.get(Key)).setText(entity.get(Key)); //take the 
                }
                if(cm.get(Key) instanceof JTextArea) { // if the element is atextArea
                     ((JTextArea)cm.get(Key)).setText(entity.get(Key)); 
                }
                if(cm.get(Key) instanceof JTextField){ //if the  element  is text field
                     ((JTextField)cm.get(Key)).setText(entity.get(Key)); //use key with both  components and the file  data to ensure matching
                }
                if (cm.get(Key) instanceof JComboBox) { // if the element is a JComboBox
                ((JComboBox) cm.get(Key)).setSelectedItem(entity.get(Key));
                }
              
            }
        }
    }
     //extract data 
    // it will extect the need data from the  target file according to 
    // role / category (hostal,recod , user..) / type the  types of the  category/
    //at the ed will return ArrayList with the  data
     public ArrayList<HashMap> extractInfo() { 
         ArrayList<HashMap> stack = new  ArrayList<HashMap>();
     
         if(role.equalsIgnoreCase("student")) { 
             switch(this.category) { 
                case "hostal": 
                    if(type.equalsIgnoreCase("single")) {
                        stack =fileHandling.search(fileHandling.HostelFile, "single", "available");
                        return stack;
                    }
                    else if(type.equalsIgnoreCase("master")) {
                        stack =fileHandling.search(fileHandling.HostelFile, "master", "available");
                        return stack;
                    }
                    else if(type.equalsIgnoreCase("double")) {
                        stack =fileHandling.search(fileHandling.HostelFile, "doubleroom", "available");
                        return stack;
                    }
                    else if(type.equalsIgnoreCase("unit")) { 
                        stack =fileHandling.search(fileHandling.HostelFile, "unit", "available");
                        return stack;
                    }
                    else  {
                        JOptionPane.showMessageDialog(null, "Hostal can be either single, master, double or unit");
                    }   return stack;
                    
                case "record": 
                    if(type.equalsIgnoreCase("refund")) { 
                        stack = fileHandling.search(fileHandling.paymentFile, id, "refund");
                        return stack;
                        
                    }
                      if(type.equalsIgnoreCase("payment")){
                           stack = fileHandling.search(fileHandling.paymentFile, id); 
                          for(int  i = 0; i < stack.size(); i++)  { 
                              if(stack.get(i).containsValue("outstanding") || stack.get(i).containsValue("refund")) { 
                                   
                              stack.remove(stack.get(i));
                            }
                          }
                          
                          return stack;
                      }
                    else if(type.equalsIgnoreCase("application")) {
                        stack =fileHandling.search(fileHandling.appFile, id);
                        return stack;
                    }
                    else if(type.equalsIgnoreCase("login")) {
                        stack =fileHandling.search(fileHandling.LoginFile, id);
                        return stack;
                    }
                    else  {
                        JOptionPane.showMessageDialog(null, "Records can be either payment, appliction, or login");
                        return  stack;
                    }
                  
               case "Payment": 
                   
                    stack = fileHandling.search(fileHandling.paymentFile, id, "outstanding");
                    return stack;
                  
               case "viewstudent":
                   if(type.equalsIgnoreCase("payment")){
                          stack =fileHandling.search(fileHandling.paymentFile, id);
                          return stack;
                      }
                    else if(type.equalsIgnoreCase("application")) {
                        stack =fileHandling.search(fileHandling.appFile, id);
                        return stack;
                    }
                    else if(type.equalsIgnoreCase("login")) {
                        JOptionPane.showMessageDialog(null, id);

                        stack =fileHandling.search(fileHandling.LoginFile, id);
                        JOptionPane.showMessageDialog(null, stack);
                        return stack;
                    }
                    else  {
                        JOptionPane.showMessageDialog(null, "Records can be either payment, appliction, or login");
                        return  stack;
                    }
                   
             
             
         }

     }
           
     stack = fileHandling.search(fileName);
     return stack; 
  

    }
    //Display the information in the  table 
     //used to display the  inofmation on the tables and 
     // add the button to it
    public void  displayOnJTable() { 
    table.setModel(createTableModel());
   
  if(columnNames.get(columnNames.size()-1).equalsIgnoreCase("view")) {
   table.getColumnModel().getColumn(columnNames.size()-1).setCellRenderer(new TableActionCellRender());
   table.getColumnModel().getColumn(columnNames.size()-1).setCellEditor(new TableActionCellEditor(viewDataOnPanel())); 
   } else  displayPanel();
   
                
          
        
        
        
    }
    
 //click to veiw 
    
 private  TableActionEvent viewDataOnPanel() { 
    
      TableActionEvent event  = new TableActionEvent(){  
            @Override
            public void onView(int row) {
               setId(table.getModel().getValueAt(row, 0).toString());
                if(!id.equalsIgnoreCase("")){
          
                setId(table.getModel().getValueAt(row, 0).toString());
                if(role.equalsIgnoreCase("student")){
                displayPanel();
                displayOnPanel (childPanel);}
                else{
                   if(type.equalsIgnoreCase("application")){
                   UpdateApplication ac =   new UpdateApplication(getId());
                       ac.setLocationRelativeTo(null);
                       ac.setVisible(true);
                   }else {
                       setType(table.getModel().getValueAt(row, 1).toString());
                       UpdateHostelInformation aa=new UpdateHostelInformation(getId(),getType());
                       aa.setLocationRelativeTo(null);
                       aa.setVisible(true);
                   }
                }
                
                }
            }
      };
 
              return event;
     
 }
 

 // this method used to shift between the models of the  jframe
 public  void  displayPanel() { 
        parentPanel.removeAll();
        parentPanel.add(childPanel);
        parentPanel.repaint();
        parentPanel.revalidate();
 }
 
// Method create table model  
// this wil uesd to create a model for the  jtable 
 //it required the  existance of the  columns name should match the  keys in the  file (important)
 //role  
public DefaultTableModel createTableModel() { 
    ArrayList<HashMap> stack = extractInfo(); 
    
      DefaultTableModel newTableModel = new  DefaultTableModel();  
     
          newTableModel = new DefaultTableModel(new Object[0][columnNames.size()], columnNames.toArray()){ 
            
           @Override
         //make the  last column editable
            public boolean isCellEditable(int row, int column) {
                if(columnNames.get(columnNames.size()-1).equalsIgnoreCase("view")){ 
            return column == getColumnCount() - 1; }
            return false;
        }

        }; 
    
      
    
      for(HashMap data : stack) { 
          ArrayList<String> sortedData = new ArrayList(); 
          for(String key: columnNames) { 
              //to make sure that the data will display same  order as the column in the table
              //the  order of the data insde the  columnNames is important 
              if(key.equalsIgnoreCase("View")) continue;// ignore the  last column view  button column
              sortedData.add(data.get(key.toLowerCase()).toString());
      }
    
    Object[] row;
            row = sortedData.toArray(new  Object[sortedData.size()]);// push the sorted array to the row  object
      
      newTableModel.addRow(row);
}      
      
   return newTableModel;     
}


//Modify Part --------------------------------------------------------------------------------------
public boolean  modify(String fileName,String id,HashMap info) { 
    boolean flag =  fileHandling.modify(fileName, id,info);
    return flag;
}

    
 // get the  current  month , year 
public  String[] getYearMonth(){ 
    Calendar calendar = new GregorianCalendar(); 
       //get the  current  date
       String [] date = new  String[3]; 
        date[0] =  String.valueOf(calendar.get(Calendar.YEAR)); 
        date[1]  =  String.valueOf(calendar.get(Calendar.MONTH)+1); 
        date[2]  =  String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)); 
       return date;
}

 public boolean updateInformation(String filename,String labelid,HashMap info){
    
       fileHandling.ModfiyEntity(filename,labelid, info);
       return true;
    };
 
public boolean comfirmmessage(String message){

    int result = JOptionPane.showConfirmDialog(null, message, "Confirmation", JOptionPane.YES_NO_OPTION);
    return result == JOptionPane.YES_OPTION;
}
    
 
}
