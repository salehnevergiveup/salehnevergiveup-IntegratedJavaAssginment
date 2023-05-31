/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package adminpart;
import javaassignment.report;
import Interface.*;
import Interface.CreateHostel;
import javax.swing.UIManager;
import javaassignment.*;
/**
 *
 * @author gohyanxi
 */
public class AdminPart {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Set the Look and Feel to Metal
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // TODO code application logic here
       Login aa = new Login();
       aa.setVisible(true);
       
        
    }
    
}
