/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;
import javaassignment.*;
import javax.swing.JOptionPane;

/**
 *
 * @author gohyanxi
 */
public class PaymentRecord extends javax.swing.JFrame {

    /**
     * Creates new form PaymentRecord
     */
    private String id;
    private String username;
    public PaymentRecord() {
        initComponents();
        
    }

    public PaymentRecord(String id,String username) {
        initComponents();
        this.username = username;
        this.id = id;
        lblStudent.setText(username);
        lblStudent1.setText(id);
        Utility utttt = new Utility();
        utttt.setId(id);
        Payment py = new Payment();
        py.displayPaymentDetailRecord(tablePaymentRecord ,id,"student","viewstudent",jPanel1, jPanel6);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        PnlHeader4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnARback = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePaymentRecord = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        lblStudent = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbPRstartYear = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbPRStartMonth = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbPRstartYear1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbPRStartMonth1 = new javax.swing.JComboBox<>();
        btnPRFilter = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        btnPRSearch = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lblStudent1 = new javax.swing.JLabel();
        cbPRstatus = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        btnPRreset = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(158, 206, 255));

        jPanel6.setBackground(new java.awt.Color(158, 206, 255));

        PnlHeader4.setBackground(new java.awt.Color(23, 118, 221));

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Payment Record");

        javax.swing.GroupLayout PnlHeader4Layout = new javax.swing.GroupLayout(PnlHeader4);
        PnlHeader4.setLayout(PnlHeader4Layout);
        PnlHeader4Layout.setHorizontalGroup(
            PnlHeader4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlHeader4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(397, 397, 397))
        );
        PnlHeader4Layout.setVerticalGroup(
            PnlHeader4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlHeader4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        btnARback.setBackground(new java.awt.Color(23, 118, 221));
        btnARback.setForeground(new java.awt.Color(255, 255, 255));
        btnARback.setText("Back");
        btnARback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnARbackActionPerformed(evt);
            }
        });

        tablePaymentRecord.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablePaymentRecord.setRowHeight(40);
        jScrollPane1.setViewportView(tablePaymentRecord);

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel5.setText("Student ID:");

        lblStudent.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        lblStudent.setText("tpnumber");

        jLabel10.setText("From");

        cbPRstartYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select Year-", "2023", "2024", "2025" }));

        jLabel2.setText("-");

        cbPRStartMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select Month-", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbPRStartMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPRStartMonthActionPerformed(evt);
            }
        });

        jLabel4.setText("To");

        cbPRstartYear1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select Year-", "2023", "2024", "2025" }));

        jLabel3.setText("-");

        cbPRStartMonth1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select Month-", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbPRStartMonth1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPRStartMonth1ActionPerformed(evt);
            }
        });

        btnPRFilter.setBackground(new java.awt.Color(23, 118, 221));
        btnPRFilter.setForeground(new java.awt.Color(255, 255, 255));
        btnPRFilter.setText("Filter");
        btnPRFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPRFilterActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        btnPRSearch.setBackground(new java.awt.Color(23, 118, 221));
        btnPRSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnPRSearch.setText("Search");
        btnPRSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPRSearchActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel6.setText("Student Username:");

        lblStudent1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        lblStudent1.setText("username");

        cbPRstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select Status-", "outstanding", "paid", "refund" }));

        jLabel11.setText("Status:");

        btnPRreset.setBackground(new java.awt.Color(23, 118, 221));
        btnPRreset.setForeground(new java.awt.Color(255, 255, 255));
        btnPRreset.setText("Reset table");
        btnPRreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPRresetActionPerformed(evt);
            }
        });

        jLabel12.setText("Isssued Date:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlHeader4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnARback, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(239, 239, 239)
                        .addComponent(jLabel5)))
                .addGap(95, 95, 95)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStudent)
                    .addComponent(lblStudent1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(cbPRstartYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(cbPRStartMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(cbPRstartYear1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbPRStartMonth1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(cbPRstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(270, 270, 270)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPRFilter, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                            .addComponent(btnPRSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPRreset, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                        .addGap(24, 24, 24))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(PnlHeader4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnARback, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(lblStudent)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblStudent1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPRSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPRstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPRStartMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPRFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPRstartYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cbPRstartYear1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPRStartMonth1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnPRreset, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbPRStartMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPRStartMonthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPRStartMonthActionPerformed

    private void cbPRStartMonth1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPRStartMonth1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPRStartMonth1ActionPerformed

    private void btnARbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnARbackActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnARbackActionPerformed

    private void btnPRFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPRFilterActionPerformed
        // TODO add your handling code here:
        if (cbPRStartMonth.getSelectedIndex() != 0 && cbPRStartMonth1.getSelectedIndex() != 0 && cbPRstartYear.getSelectedIndex() != 0 && cbPRstartYear1.getSelectedIndex() != 0 && cbPRstatus.getSelectedIndex() != 0) {
        int year = Integer.parseInt(cbPRstartYear.getSelectedItem().toString());
        int month = Integer.parseInt(cbPRStartMonth.getSelectedItem().toString());
        int year2 = Integer.parseInt(cbPRstartYear1.getSelectedItem().toString());
        int month2 = Integer.parseInt(cbPRStartMonth1.getSelectedItem().toString());
    
    String status = cbPRstatus.getSelectedItem().toString();
    Mainpage ma = new Mainpage();
    ma.filterTable(tablePaymentRecord, year, year2, month, month2, 6, 7, 9, status);
    } else {
        JOptionPane.showMessageDialog(null, "Please select full date details and status");
    }
    }//GEN-LAST:event_btnPRFilterActionPerformed

    private void btnPRresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPRresetActionPerformed
        // TODO add your handling code here:
        Mainpage ma = new Mainpage();
        ma.reset(tablePaymentRecord,jTextField1);
        
    }//GEN-LAST:event_btnPRresetActionPerformed

    private void btnPRSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPRSearchActionPerformed
        // TODO add your handling code here:
        Mainpage ma = new Mainpage();
        ma.searchInTable( tablePaymentRecord, jTextField1.getText()) ;
        jTextField1.setText("");
        
    }//GEN-LAST:event_btnPRSearchActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(PaymentRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaymentRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaymentRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaymentRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaymentRecord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PnlHeader4;
    private javax.swing.JButton btnARback;
    private javax.swing.JButton btnPRFilter;
    private javax.swing.JButton btnPRSearch;
    private javax.swing.JButton btnPRreset;
    private javax.swing.JComboBox<String> cbPRStartMonth;
    private javax.swing.JComboBox<String> cbPRStartMonth1;
    private javax.swing.JComboBox<String> cbPRstartYear;
    private javax.swing.JComboBox<String> cbPRstartYear1;
    private javax.swing.JComboBox<String> cbPRstatus;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblStudent;
    private javax.swing.JLabel lblStudent1;
    private javax.swing.JTable tablePaymentRecord;
    // End of variables declaration//GEN-END:variables
}
