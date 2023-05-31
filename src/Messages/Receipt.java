/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Messages;

import javaassignment.Payment;
import javax.swing.JOptionPane;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author User
 */
public class Receipt extends javax.swing.JFrame {

    /**
     * Creates new form Recipt
     */
    String  paymentID;
    public Receipt(String py) {
        initComponents();
        this.paymentID =  py;
        JOptionPane.showMessageDialog(null, py.getClass()); 
        new  Payment().displayPaymentDetailsPanel(receiptPanel, paymentID);
        
    }
    
    public Receipt() {
        initComponents();
            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        receiptPanel = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        appApplicationId1 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        appRoomId1 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        appName1 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        appRoomId4 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        appRoomId2 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        appRoomId6 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        appRoomId3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel54 = new javax.swing.JLabel();
        appRoomId7 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        appRoomId8 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        jLabel136 = new javax.swing.JLabel();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        jLabel137 = new javax.swing.JLabel();
        jSeparator16 = new javax.swing.JSeparator();
        jLabel138 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Recipt = new javax.swing.JButton();
        Recipt1 = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        receiptPanel.setBackground(new java.awt.Color(255, 255, 255));
        receiptPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel53.setText("Payment Number: ");
        receiptPanel.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        appApplicationId1.setText("application id");
        receiptPanel.add(appApplicationId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 140, -1));

        jLabel120.setText("Room ID: ");
        receiptPanel.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        appRoomId1.setText("roomid");
        receiptPanel.add(appRoomId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 145, -1));

        jLabel119.setText("Name:");
        receiptPanel.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 40, -1));

        appName1.setText("name");
        receiptPanel.add(appName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 40, -1));

        jLabel124.setText("issue-year");
        receiptPanel.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, -1, -1));

        appRoomId4.setText("Issue year:");
        receiptPanel.add(appRoomId4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 60, -1));

        jLabel122.setText("UserName: ");
        receiptPanel.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        appRoomId2.setText("payment id");
        receiptPanel.add(appRoomId2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 120, -1));

        jLabel126.setText("amount:");
        receiptPanel.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        appRoomId6.setText("amount");
        receiptPanel.add(appRoomId6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 110, -1));

        jLabel123.setText("Type:");
        receiptPanel.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, -1, -1));

        appRoomId3.setText("type");
        receiptPanel.add(appRoomId3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 130, -1));
        receiptPanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 510, -1));
        receiptPanel.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 510, 10));
        receiptPanel.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 510, 10));

        jSeparator5.setBackground(new java.awt.Color(25, 118, 221));
        jSeparator5.setForeground(new java.awt.Color(25, 118, 221));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        receiptPanel.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 10, 360));

        jLabel54.setText("Application ID: ");
        receiptPanel.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, -1, -1));

        appRoomId7.setText("username");
        receiptPanel.add(appRoomId7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 100, -1));

        jLabel127.setText("Payment Year:");
        receiptPanel.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 80, -1));

        appRoomId8.setText("payment-month");
        receiptPanel.add(appRoomId8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 100, -1));

        jLabel135.setText("status");
        receiptPanel.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 260, 80, -1));
        receiptPanel.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 510, 10));

        jLabel136.setText("Status payment: ");
        receiptPanel.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 90, -1));

        jSeparator14.setOrientation(javax.swing.SwingConstants.VERTICAL);
        receiptPanel.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 50, 240));
        receiptPanel.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 510, 10));

        jLabel137.setText("Issue Month:");
        receiptPanel.add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 70, -1));
        receiptPanel.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 510, 10));

        jLabel138.setText("issue-month");
        receiptPanel.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 80, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Receipt");
        receiptPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 70, -1));

        Recipt.setBackground(new java.awt.Color(25, 118, 221));
        Recipt.setForeground(new java.awt.Color(255, 255, 255));
        Recipt.setText("Print");
        Recipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReciptActionPerformed(evt);
            }
        });
        receiptPanel.add(Recipt, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 130, 30));

        Recipt1.setBackground(new java.awt.Color(255, 0, 0));
        Recipt1.setForeground(new java.awt.Color(255, 255, 255));
        Recipt1.setText("Close");
        Recipt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Recipt1ActionPerformed(evt);
            }
        });
        receiptPanel.add(Recipt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 130, 30));
        receiptPanel.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 510, 10));

        jSeparator7.setBackground(new java.awt.Color(25, 118, 221));
        jSeparator7.setForeground(new java.awt.Color(25, 118, 221));
        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        receiptPanel.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 20, 360));

        jSeparator8.setBackground(new java.awt.Color(25, 118, 221));
        jSeparator8.setForeground(new java.awt.Color(25, 118, 221));
        receiptPanel.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 10));

        jSeparator9.setBackground(new java.awt.Color(25, 118, 221));
        jSeparator9.setForeground(new java.awt.Color(25, 118, 221));
        receiptPanel.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 200, 10));

        jSeparator10.setBackground(new java.awt.Color(25, 118, 221));
        jSeparator10.setForeground(new java.awt.Color(25, 118, 221));
        receiptPanel.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 520, 10));

        jLabel139.setText("Payment Month:");
        receiptPanel.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 90, -1));

        jLabel140.setText("payment-year");
        receiptPanel.add(jLabel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 90, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(receiptPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(receiptPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Recipt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Recipt1ActionPerformed
        // TODO add your handling code here:
             dispose(); 
    }//GEN-LAST:event_Recipt1ActionPerformed

    private void ReciptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReciptActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_ReciptActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Receipt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Recipt;
    private javax.swing.JButton Recipt1;
    private javax.swing.JLabel appApplicationId1;
    private javax.swing.JLabel appName1;
    private javax.swing.JLabel appRoomId1;
    private javax.swing.JLabel appRoomId2;
    private javax.swing.JLabel appRoomId3;
    private javax.swing.JLabel appRoomId4;
    private javax.swing.JLabel appRoomId6;
    private javax.swing.JLabel appRoomId7;
    private javax.swing.JLabel appRoomId8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JPanel receiptPanel;
    // End of variables declaration//GEN-END:variables
}
