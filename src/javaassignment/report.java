/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author gohyanxi
 */
public class report {
    private int startYear;
    private int endyear;
    private int startmonth;
    private int endmonth;
    
   
    public report(int syear, int smonth, int eyear, int emonth){
        this.startYear = syear;
        this.endyear =eyear;
        this.startmonth = smonth;
        this.endmonth = emonth;
    }
    public report(){
        
    }
     public double sumup(String filename,String status){
          double summ = 0;
           ArrayList<HashMap<String, String>> matchedList = new ArrayList<>();
         for (int year = startYear; year <= endyear; year++) {
                int endMonthOfYear = (year == endyear) ? endmonth : 12;
                int startMonthOfYear = (year == startYear) ? startmonth : 1;

                for (int month = startMonthOfYear; month <= endMonthOfYear; month++) {
                   ArrayList<HashMap>  originalList = fileHandling.fileReader(filename);
                   

                    String desiredYear = String.valueOf(year);
                    String desiredmonth = String.valueOf(month);
                    String desiredStatus = status;

                    for (HashMap<String, String> hashMap : originalList) {
                        if (hashMap.containsKey("issue-year") && hashMap.containsKey("status") && hashMap.containsKey("issue-month")) {
                            String yearValue = hashMap.get("issue-year");
                            String statusValue = hashMap.get("status");
                            String monthvalue = hashMap.get("issue-month");

                            if (yearValue.equals(desiredYear) && statusValue.equals(desiredStatus) && monthvalue.equals(desiredmonth)) {
                                matchedList.add(hashMap);
                            }
                        }
                    }

                }
            }
            for(int i= 0 ;i< matchedList.size();i++){
                        summ += Double.parseDouble(matchedList.get(i).get("amount").toString());
                        
          }
        return summ;
    }
     
     public int applicationcounter(String filename,String status){
          int summ = 0;
           ArrayList<HashMap<String, String>> matchedList = new ArrayList<>();
         for (int year = startYear; year <= endyear; year++) {
                int endMonthOfYear = (year == endyear) ? endmonth : 12;
                int startMonthOfYear = (year == startYear) ? startmonth : 1;

                for (int month = startMonthOfYear; month <= endMonthOfYear; month++) {
                   ArrayList<HashMap>  originalList = fileHandling.fileReader(filename);
                   

                    String desiredYear = String.valueOf(year);
                    String desiredmonth = String.valueOf(month);
                    String desiredStatus = status;

                    for (HashMap<String, String> hashMap : originalList) {
                        if (hashMap.containsKey("year") && hashMap.containsKey("status") && hashMap.containsKey("month")) {
                            String yearValue = hashMap.get("year");
                            String statusValue = hashMap.get("status");
                            String monthvalue = hashMap.get("month");

                            if (yearValue.equals(desiredYear) && statusValue.equals(desiredStatus) && monthvalue.equals(desiredmonth)) {
                                matchedList.add(hashMap);
                            }
                        }
                    }

                }
            }
            for(int i= 0 ;i< matchedList.size();i++){
                        summ +=1;
          }
        return summ;
    }
     
     public int roomcounter(String filename,String status,String roomtype){
          int summ = 0;
           ArrayList<HashMap<String, String>> matchedList = new ArrayList<>();
         
                   ArrayList<HashMap>  originalList = fileHandling.fileReader(filename);
                   
                    String desiredStatus = status;
                    String desiredroom = roomtype;

                    for (HashMap<String, String> hashMap : originalList) {
                        if (hashMap.containsKey("status") && hashMap.containsKey("type")) {
              
                            String statusValue = hashMap.get("status");
                            String typeValue = hashMap.get("type");

                            if ( statusValue.equals(desiredStatus)&&typeValue.equals(desiredroom)) {
                                matchedList.add(hashMap);
                            }
                        }
                    }
            for(int i= 0 ;i< matchedList.size();i++){
                        summ +=1;
          }
        return summ;
    }
     
     public void screenshot(String aa,String bb){
     
          int min = 50; // Minimum value of range
      int max = 9999999; // Maximum value of range
      // Print the min and max  
      
      // Generate random int value from min to max
      int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
        String screenshot= aa+""+random_int;
        try {
            // Create a Robot instance
            Robot robot = new Robot();

            // Capture the screen
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage screenImage = robot.createScreenCapture(screenRect);

            // Save the captured image to a file
            File output = new File("/Users/gohyanxi/Desktop/"+screenshot+"screnshot");
            ImageIO.write(screenImage, "png", output);

            JOptionPane.showMessageDialog(null,bb+" saved successfully.");
        } catch (AWTException | IOException ex) {
            ex.printStackTrace();
        }
     }
}
