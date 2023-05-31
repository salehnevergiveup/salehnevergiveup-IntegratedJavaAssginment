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
public class CreateHostel extends javax.swing.JFrame {

    /**
     * Creates new form CreateHostel
     */
    public CreateHostel() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnSaveh = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbroomtype = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtLocation = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        pnlsingleroom = new javax.swing.JPanel();
        txtBathroomsize = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cbSGNumberofrbathroomuser = new javax.swing.JComboBox<>();
        pnldoubleroom = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtDBBathroomsize = new javax.swing.JTextField();
        cbnumofResidents = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        pnlMasterRoom = new javax.swing.JPanel();
        txtMRBathroomsize = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        pnlwholeunit = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtCRHwholeunitroom = new javax.swing.JTextField();
        txtCRHwholeunitbathroom = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtRoomSize = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbGender = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtDescription = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(158, 206, 255));

        btnSaveh.setBackground(new java.awt.Color(23, 118, 221));
        btnSaveh.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveh.setText("Save");
        btnSaveh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSavehActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(23, 118, 221));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Create Hostel Information");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(272, 272, 272))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Room Type:");

        cbroomtype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single Room", "Double Room", "Master Room", "Whole Unit" }));
        cbroomtype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbroomtypeActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Location:");

        txtLocation.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLocationActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(203, 228, 255));
        jPanel3.setLayout(new java.awt.CardLayout());

        pnlsingleroom.setBackground(new java.awt.Color(204, 229, 255));

        txtBathroomsize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBathroomsizeActionPerformed(evt);
            }
        });

        jLabel12.setText("Bathroom Size:");

        jLabel13.setText("Number of Bathroom User:");

        cbSGNumberofrbathroomuser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));

        javax.swing.GroupLayout pnlsingleroomLayout = new javax.swing.GroupLayout(pnlsingleroom);
        pnlsingleroom.setLayout(pnlsingleroomLayout);
        pnlsingleroomLayout.setHorizontalGroup(
            pnlsingleroomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlsingleroomLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(pnlsingleroomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12))
                .addGap(31, 31, 31)
                .addGroup(pnlsingleroomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtBathroomsize, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSGNumberofrbathroomuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(272, Short.MAX_VALUE))
        );
        pnlsingleroomLayout.setVerticalGroup(
            pnlsingleroomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlsingleroomLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlsingleroomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBathroomsize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlsingleroomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cbSGNumberofrbathroomuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel3.add(pnlsingleroom, "card2");

        pnldoubleroom.setBackground(new java.awt.Color(204, 229, 255));

        jLabel14.setText("Bathroom SIze");

        txtDBBathroomsize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDBBathroomsizeActionPerformed(evt);
            }
        });

        cbnumofResidents.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2" }));

        jLabel3.setText("Number of Residents");

        javax.swing.GroupLayout pnldoubleroomLayout = new javax.swing.GroupLayout(pnldoubleroom);
        pnldoubleroom.setLayout(pnldoubleroomLayout);
        pnldoubleroomLayout.setHorizontalGroup(
            pnldoubleroomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnldoubleroomLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(pnldoubleroomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel3))
                .addGap(37, 37, 37)
                .addGroup(pnldoubleroomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDBBathroomsize, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbnumofResidents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(273, Short.MAX_VALUE))
        );
        pnldoubleroomLayout.setVerticalGroup(
            pnldoubleroomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnldoubleroomLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(pnldoubleroomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtDBBathroomsize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnldoubleroomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbnumofResidents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel3.add(pnldoubleroom, "card3");

        pnlMasterRoom.setBackground(new java.awt.Color(204, 229, 255));

        txtMRBathroomsize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMRBathroomsizeActionPerformed(evt);
            }
        });

        jLabel15.setText("Bathroom SIze");

        javax.swing.GroupLayout pnlMasterRoomLayout = new javax.swing.GroupLayout(pnlMasterRoom);
        pnlMasterRoom.setLayout(pnlMasterRoomLayout);
        pnlMasterRoomLayout.setHorizontalGroup(
            pnlMasterRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMasterRoomLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel15)
                .addGap(37, 37, 37)
                .addComponent(txtMRBathroomsize, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(313, Short.MAX_VALUE))
        );
        pnlMasterRoomLayout.setVerticalGroup(
            pnlMasterRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMasterRoomLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(pnlMasterRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtMRBathroomsize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jPanel3.add(pnlMasterRoom, "card4");

        pnlwholeunit.setBackground(new java.awt.Color(226, 240, 255));

        jLabel16.setText("Number of bathroom");

        jLabel17.setText("Number of room:");

        txtCRHwholeunitroom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCRHwholeunitroomActionPerformed(evt);
            }
        });

        txtCRHwholeunitbathroom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCRHwholeunitbathroomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlwholeunitLayout = new javax.swing.GroupLayout(pnlwholeunit);
        pnlwholeunit.setLayout(pnlwholeunitLayout);
        pnlwholeunitLayout.setHorizontalGroup(
            pnlwholeunitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlwholeunitLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(pnlwholeunitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(pnlwholeunitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCRHwholeunitroom, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCRHwholeunitbathroom, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(338, Short.MAX_VALUE))
        );
        pnlwholeunitLayout.setVerticalGroup(
            pnlwholeunitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlwholeunitLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(pnlwholeunitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtCRHwholeunitroom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlwholeunitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtCRHwholeunitbathroom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jPanel3.add(pnlwholeunit, "card5");

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Room Size:");

        txtRoomSize.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRoomSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRoomSizeActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Gender Preference:");

        cbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "none", "female", "male" }));

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("sqft");

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Details");

        btnCancel.setBackground(new java.awt.Color(23, 118, 221));
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Description:");

        txtDescription.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDescription.setText("Enter Description");
        txtDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescriptionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel7)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel8))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbroomtype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRoomSize, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(55, 55, 55)
                        .addComponent(cbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSaveh, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtLocation)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtDescription)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbroomtype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtRoomSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveh, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescriptionActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtRoomSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRoomSizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRoomSizeActionPerformed

    private void txtCRHwholeunitbathroomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCRHwholeunitbathroomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCRHwholeunitbathroomActionPerformed

    private void txtCRHwholeunitroomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCRHwholeunitroomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCRHwholeunitroomActionPerformed

    private void txtMRBathroomsizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMRBathroomsizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMRBathroomsizeActionPerformed

    private void txtDBBathroomsizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDBBathroomsizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDBBathroomsizeActionPerformed

    private void txtBathroomsizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBathroomsizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBathroomsizeActionPerformed

    private void txtLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLocationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLocationActionPerformed

    private void btnSavehActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSavehActionPerformed
        // TODO add your handling code here:
        if(cbroomtype.getSelectedItem().toString().equalsIgnoreCase("single room")){
            Single sin = new Single();
            
            boolean yes = sin.checkData(txtLocation.getText(), "available", txtDescription.getText(), cbGender.getSelectedItem().toString(), txtBathroomsize.getText(), cbSGNumberofrbathroomuser.getSelectedItem().toString(), txtRoomSize.getText());
            sin.AddHostel(yes);
            JOptionPane.showMessageDialog(null, "Hostel created successfully");
        }else if (cbroomtype.getSelectedItem().toString().equalsIgnoreCase("double room")){
            DoubleRoom doub = new DoubleRoom();
           boolean yes2 = doub.checkData(txtLocation.getText(), "available", txtDescription.getText(), cbGender.getSelectedItem().toString(), txtDBBathroomsize.getText(), txtRoomSize.getText(),cbnumofResidents.getSelectedItem().toString());
           doub.AddHostel(yes2);
           JOptionPane.showMessageDialog(null, "Hostel created successfully");
        }else if (cbroomtype.getSelectedItem().toString().equalsIgnoreCase("master room")){
            Master mas = new Master();
           boolean yes3 = mas.checkData(txtLocation.getText(), "available", txtDescription.getText(), cbGender.getSelectedItem().toString(), txtMRBathroomsize.getText(), txtRoomSize.getText());
           mas.AddHostel(yes3);
           JOptionPane.showMessageDialog(null, "Hostel created successfully");
        }else{
            Unit un = new Unit();
           boolean yes4 = un.checkData(txtLocation.getText(), "available", txtDescription.getText(), cbGender.getSelectedItem().toString(), txtCRHwholeunitroom.getText(),txtCRHwholeunitbathroom.getText(), txtRoomSize.getText());
            if(un.AddHostel(yes4)){
               JOptionPane.showMessageDialog(null, "Hostel created successfully");
            }
        }
        
    }//GEN-LAST:event_btnSavehActionPerformed

    private void cbroomtypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbroomtypeActionPerformed
        if(cbroomtype.getSelectedItem().toString().equalsIgnoreCase("single room")){
            jPanel3.removeAll();
            jPanel3.add(pnlsingleroom);
            jPanel3.repaint();
            jPanel3.revalidate();
        }
        else if(cbroomtype.getSelectedItem().toString().equalsIgnoreCase("double room")){
            jPanel3.removeAll();
            jPanel3.add(pnldoubleroom);
            jPanel3.repaint();
            jPanel3.revalidate();
        }
        else if(cbroomtype.getSelectedItem().toString().equalsIgnoreCase("master room")){
            jPanel3.removeAll();
            jPanel3.add(pnlMasterRoom);
            jPanel3.repaint();
            jPanel3.revalidate();
        }
        else {
            jPanel3.removeAll();
            jPanel3.add(pnlwholeunit);
            jPanel3.repaint();
            jPanel3.revalidate();
        }
    }//GEN-LAST:event_cbroomtypeActionPerformed

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
            java.util.logging.Logger.getLogger(CreateHostel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateHostel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateHostel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateHostel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateHostel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSaveh;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbGender;
    private javax.swing.JComboBox<String> cbSGNumberofrbathroomuser;
    private javax.swing.JComboBox<String> cbnumofResidents;
    private javax.swing.JComboBox<String> cbroomtype;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel pnlMasterRoom;
    private javax.swing.JPanel pnldoubleroom;
    private javax.swing.JPanel pnlsingleroom;
    private javax.swing.JPanel pnlwholeunit;
    private javax.swing.JTextField txtBathroomsize;
    private javax.swing.JTextField txtCRHwholeunitbathroom;
    private javax.swing.JTextField txtCRHwholeunitroom;
    private javax.swing.JTextField txtDBBathroomsize;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextField txtMRBathroomsize;
    private javax.swing.JTextField txtRoomSize;
    // End of variables declaration//GEN-END:variables
}