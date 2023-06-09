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
public class ApplicationRecord extends javax.swing.JFrame {

    /**
     * Creates new form ApplicationRecord
     */
    private String id;
    private String username;
    public ApplicationRecord() {
        initComponents();
    }
    
    public ApplicationRecord(String id,String username) {
        initComponents();
        this.id = id;
        this.username = username;
        lblStudent.setText(username);
        lblStudent1.setText(id);
        Utility utttt = new Utility();
        utttt.setId(id);
        Application py = new Application();
        py.displayApplicationDetails(tableApplicationRecord ,id,"student",jPanel5, jPanel6);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        PnlHeader4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnARback = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableApplicationRecord = new javax.swing.JTable();
        cbARStartMonth = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnARFilter = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lblStudent = new javax.swing.JLabel();
        cbARStatus = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cbARstartYear = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbARstartYear1 = new javax.swing.JComboBox<>();
        cbARStartMonth1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnARSearch = new javax.swing.JButton();
        btnARFilter1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lblStudent1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(158, 206, 255));

        jPanel6.setBackground(new java.awt.Color(158, 206, 255));

        PnlHeader4.setBackground(new java.awt.Color(23, 118, 221));

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Application Record");

        javax.swing.GroupLayout PnlHeader4Layout = new javax.swing.GroupLayout(PnlHeader4);
        PnlHeader4.setLayout(PnlHeader4Layout);
        PnlHeader4Layout.setHorizontalGroup(
            PnlHeader4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlHeader4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(470, 470, 470))
        );
        PnlHeader4Layout.setVerticalGroup(
            PnlHeader4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlHeader4Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap())
        );

        btnARback.setBackground(new java.awt.Color(23, 118, 221));
        btnARback.setForeground(new java.awt.Color(255, 255, 255));
        btnARback.setText("Back");
        btnARback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnARbackActionPerformed(evt);
            }
        });

        tableApplicationRecord.setModel(new javax.swing.table.DefaultTableModel(
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
        tableApplicationRecord.setRowHeight(40);
        jScrollPane1.setViewportView(tableApplicationRecord);

        cbARStartMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select Month-", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbARStartMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbARStartMonthActionPerformed(evt);
            }
        });

        jLabel10.setText("From");

        jLabel4.setText("To");

        btnARFilter.setBackground(new java.awt.Color(23, 118, 221));
        btnARFilter.setForeground(new java.awt.Color(255, 255, 255));
        btnARFilter.setText("Filter");
        btnARFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnARFilterActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel5.setText("Student ID:");

        lblStudent.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        lblStudent.setText("XX");

        cbARStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select status-", "pending", "accepted", "rejected", "cancelled" }));
        cbARStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbARStatusActionPerformed(evt);
            }
        });

        jLabel1.setText("Select Status");

        cbARstartYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select Year-", "2023", "2024", "2025" }));
        cbARstartYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbARstartYearActionPerformed(evt);
            }
        });

        jLabel2.setText("-");

        cbARstartYear1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select year-", "2023", "2024", "2025" }));

        cbARStartMonth1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select month-", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbARStartMonth1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbARStartMonth1ActionPerformed(evt);
            }
        });

        jLabel3.setText("-");

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        btnARSearch.setBackground(new java.awt.Color(23, 118, 221));
        btnARSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnARSearch.setText("Search");
        btnARSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnARSearchActionPerformed(evt);
            }
        });

        btnARFilter1.setBackground(new java.awt.Color(23, 118, 221));
        btnARFilter1.setForeground(new java.awt.Color(255, 255, 255));
        btnARFilter1.setText("Reset Table");
        btnARFilter1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnARFilter1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel6.setText("Student Username:");

        lblStudent1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        lblStudent1.setText("XX");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlHeader4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnARback, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbARstartYear, 0, 1, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbARStartMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addGap(16, 16, 16))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cbARStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(89, 89, 89)
                                        .addComponent(lblStudent1))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(89, 89, 89)
                                        .addComponent(lblStudent)))
                                .addGap(67, 67, 67)))
                        .addGap(39, 39, 39))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(cbARstartYear1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbARStartMonth1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnARSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(btnARFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnARFilter1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(PnlHeader4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStudent)
                            .addComponent(btnARback, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(lblStudent1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbARStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnARSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbARStartMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbARstartYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cbARstartYear1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbARStartMonth1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnARFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnARFilter1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbARStartMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbARStartMonthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbARStartMonthActionPerformed

    private void cbARStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbARStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbARStatusActionPerformed

    private void cbARStartMonth1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbARStartMonth1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbARStartMonth1ActionPerformed

    private void btnARbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnARbackActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnARbackActionPerformed

    private void btnARFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnARFilterActionPerformed
        // TODO add your handling code here:
        if (cbARStatus.getSelectedIndex() != 0 && cbARStartMonth.getSelectedIndex() != 0 && cbARstartYear.getSelectedIndex() != 0 && cbARstartYear1.getSelectedIndex() != 0 && cbARStartMonth1.getSelectedIndex() != 0) {
        int year = Integer.parseInt(cbARstartYear.getSelectedItem().toString());
        int month = Integer.parseInt(cbARStartMonth.getSelectedItem().toString());
        int year2 = Integer.parseInt(cbARstartYear1.getSelectedItem().toString());
        int month2 = Integer.parseInt(cbARStartMonth1.getSelectedItem().toString());
    
    String status = cbARStatus.getSelectedItem().toString();
    Mainpage ma = new Mainpage();
    ma.filterTable(tableApplicationRecord, year, year2, month, month2, 4, 5, 11, status);
    } else {
        JOptionPane.showMessageDialog(null, "Please select full date details and status");
    }
    }//GEN-LAST:event_btnARFilterActionPerformed

    private void cbARstartYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbARstartYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbARstartYearActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnARFilter1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnARFilter1ActionPerformed
        // TODO add your handling code here:
        Mainpage ma = new Mainpage();
        ma.reset(tableApplicationRecord,txtSearch);
    }//GEN-LAST:event_btnARFilter1ActionPerformed

    private void btnARSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnARSearchActionPerformed
        // TODO add your handling code here:\
        Mainpage ma = new Mainpage();
        ma.searchInTable( tableApplicationRecord, txtSearch.getText()) ;
        txtSearch.setText("");
    }//GEN-LAST:event_btnARSearchActionPerformed

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
            java.util.logging.Logger.getLogger(ApplicationRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApplicationRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApplicationRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApplicationRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ApplicationRecord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PnlHeader4;
    private javax.swing.JButton btnARFilter;
    private javax.swing.JButton btnARFilter1;
    private javax.swing.JButton btnARSearch;
    private javax.swing.JButton btnARback;
    private javax.swing.JComboBox<String> cbARStartMonth;
    private javax.swing.JComboBox<String> cbARStartMonth1;
    private javax.swing.JComboBox<String> cbARStatus;
    private javax.swing.JComboBox<String> cbARstartYear;
    private javax.swing.JComboBox<String> cbARstartYear1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblStudent;
    private javax.swing.JLabel lblStudent1;
    private javax.swing.JTable tableApplicationRecord;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
