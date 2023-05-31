/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import CellButton.TableActionCellRender;
import java.awt.*;
import java.util.*;
import javaassignment.*;
import javax.swing.*;
import CellButton.*;
import customeExceptions.*;
import javaassginment.*;
import javax.swing.table.*;
import Messages.*;



/**
 *
 * @author User
 */
public class StudentHostel extends javax.swing.JFrame  {

    private static Student  st;
    private JPanel currentRoom; 
    
    
    public StudentHostel(Student st) {
        initComponents();
        this.st = st;
        Utility ds = new  Utility(Parent, Profile);
        ds.setId(st.getUserName());
        ds.setFileName(fileHandling.UserFile);
        ds.displayPanel();
        ds.displayOnPanel(personalInfo); 

       Application app = new  Application();
       Payment  py = new  Payment();
       try {
        app.displayApplicationDetailsPanel(viewApplicationInfo, st.getUserName());
        py.displayPaymentDetailRecord(paymentTable, st.getUserName(), st.getRole(), "Payment",BodyApplication, viewPaymentDetail );
        
        py.timeConstraint(appApplicationId.getText().toString(), app.applicationCounter(st.getUserName()), st.getUserName(), this);
       
       }catch(Exception e) { 
                new  Message("Oops, Somthing Went  Wrong  Please  Try Again Later", fileHandling.messageIcon("error")).setVisible(true);
       }
    }
    
    
    
    public StudentHostel() {}
    
    
    //filter method one
    public void filterRoomTable(JTable table, double minPrice, double maxPrice, int priceColumn, int columnNumber, String... keywords) {
        RowFilter<Object, Object> rf = new RowFilter<Object, Object>() {
            @Override
            public boolean include(RowFilter.Entry<?, ?> entry) {
                double price = Double.parseDouble(entry.getStringValue(priceColumn));
                if (price < minPrice || price > maxPrice) {
                    return false;
                }

                ArrayList<String> keywordValues = new ArrayList<>();
                for (int column = 0; column < columnNumber; column++) {
                    String value = entry.getStringValue(column);
                    if (value != null) {
                        keywordValues.add(value.toLowerCase());
                    }
                }

                for (String keyword : keywords) {
                    boolean matchesKeyword = keywordValues.stream().anyMatch(value -> {
                        String[] words = value.toLowerCase().split("\\s+");
                        for (String word : words) {
                            if (word.equals(keyword.toLowerCase())) {
                                return true;
                            }
                        }
                        return false;
                    });
                    if (!matchesKeyword) {
                        return false;
                    }
                }

                return true;
            }
        };

        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        sorter.setRowFilter(rf);
        table.setRowSorter(sorter);
    }
    
    //filter method two
    public void filterTable(JTable table, int minYear, int maxYear, int minMonth, int maxMonth, int yearColumn, int monthColumn, int columnNumber, String... keywords) {

        RowFilter<Object, Object> rf = new RowFilter<Object, Object>() {
            @Override

            public boolean include(RowFilter.Entry<?, ?> entry) {

                int year = Integer.parseInt(entry.getStringValue(yearColumn));
                int month = Integer.parseInt(entry.getStringValue(monthColumn));

                if (year < minYear || year > maxYear) {
                    return false;
                }

                if (year == minYear && month < minMonth) {
                    return false;
                }

                if (year == maxYear && month > maxMonth) {
                    return false;
                }

                ArrayList<String> keywordValues = new ArrayList<>();
                for (int column = 0; column < columnNumber; column++) {
                    String value = entry.getStringValue(column);
                    if (value != null) {
                        keywordValues.add(value.toLowerCase());
                    }
                }
                for (String keyword : keywords) {
                    final String finalKeyword = keyword.toLowerCase();
                    boolean matchesKeyword = keywordValues.stream().anyMatch(value -> value.contains(finalKeyword));
                    if (!matchesKeyword) {
                        return false;
                    }
                }

                return true;
            }
        };
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        sorter.setRowFilter(rf);
        table.setRowSorter(sorter);
    }
     
    //Search in table 
    private void searchInTable(JTable table, String... values) {
        DefaultTableModel newTableModel = (DefaultTableModel) table.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter(newTableModel);
        table.setRowSorter(sorter);
        for (String filter : values) {
            sorter.setRowFilter(RowFilter.regexFilter(filter));
        }

    }
    
    //reset table  method 
    public void reset(JTable currentTable, JTextField clickedButton) {
        try {
            TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) currentTable.getRowSorter();
            sorter.setRowFilter(null);
        } catch (Exception e) {
        }

        searchInTable(currentTable, clickedButton.getText());
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        Sidebar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnProfile = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnProperties = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnApplication = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnRecord = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Parent = new javax.swing.JPanel();
        Profile = new javax.swing.JPanel();
        Header1 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        welcoming = new javax.swing.JLabel();
        ProfileBody = new javax.swing.JPanel();
        personalInfo = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        Header2 = new javax.swing.JPanel();
        profileName = new javax.swing.JLabel();
        ProfileAddress = new javax.swing.JLabel();
        ProfileTPNumber = new javax.swing.JLabel();
        ProfileUserName = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        profileEmail = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        ProfileGender = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        ProfileRole = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        Properties = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        Body = new javax.swing.JPanel();
        SelectProperite = new javax.swing.JPanel();
        SingleRoomPanel = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        btnSingle = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        UnitPanel = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        btnMaster = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        MasterPane = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        btnUnit = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        DoubleRoomPane = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        btnDouble = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        ViewSingleRoom = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        singleRoomTable = new javax.swing.JTable();
        Footer = new javax.swing.JPanel();
        singleMinPrice = new javax.swing.JTextField();
        singleRoomReset = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        singleRoomSearchField = new javax.swing.JTextField();
        singleMaxPrice = new javax.swing.JTextField();
        singleRoomSearchButton = new javax.swing.JButton();
        singleRoomFilter = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        filterCompnents = new javax.swing.JPanel();
        filterCom1 = new javax.swing.JPanel();
        singleBathroomType = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        filterCom2 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        bathroomNumber = new javax.swing.JSpinner();
        jLabel32 = new javax.swing.JLabel();
        roomsNumber = new javax.swing.JSpinner();
        jLabel31 = new javax.swing.JLabel();
        singleRadioMale = new javax.swing.JRadioButton();
        singleRadioFemale = new javax.swing.JRadioButton();
        jLabel33 = new javax.swing.JLabel();
        radioNone = new javax.swing.JRadioButton();
        viewRoomDetails = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        propStatus = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        propDeposit = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        propGender = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        propLocation = new javax.swing.JLabel();
        propSize = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        propType = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel46 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        propDescription = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel54 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        propMonthly = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        propRoomId = new javax.swing.JLabel();
        viewMasterRoom = new javax.swing.JPanel();
        masterBackButton = new javax.swing.JLabel();
        masterRoomSearchField = new javax.swing.JTextField();
        mastersRoomSearchButton = new javax.swing.JButton();
        masterRadioMale = new javax.swing.JRadioButton();
        jLabel76 = new javax.swing.JLabel();
        radioNone1 = new javax.swing.JRadioButton();
        masterRadioFemale = new javax.swing.JRadioButton();
        jLabel77 = new javax.swing.JLabel();
        masterRoomMinPrice = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        masterRoomMaxPrice = new javax.swing.JTextField();
        masterRoomFilter = new javax.swing.JButton();
        masterRoomReset = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        masterRoomTable = new javax.swing.JTable();
        viewUnit = new javax.swing.JPanel();
        unitRoomSearchField = new javax.swing.JTextField();
        unitRoomSearchButton1 = new javax.swing.JButton();
        unitRadioMale = new javax.swing.JRadioButton();
        unitRadioFemale = new javax.swing.JRadioButton();
        radioNone2 = new javax.swing.JRadioButton();
        unitRoomMinPrice = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        unitRoomMaxPrice = new javax.swing.JTextField();
        unitRoomReset = new javax.swing.JButton();
        unitRoomFilter = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        unitRoomTable = new javax.swing.JTable();
        unitBackButton = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        filterCom4 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        unitRoomsNumber = new javax.swing.JComboBox<>();
        unitBathroomsNumber = new javax.swing.JComboBox<>();
        makeApplication = new javax.swing.JPanel();
        jLabel94 = new javax.swing.JLabel();
        propName1 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        jLabel95 = new javax.swing.JLabel();
        propUserName1 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        propEmail1 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        propRoomId1 = new javax.swing.JLabel();
        jSeparator14 = new javax.swing.JSeparator();
        jLabel100 = new javax.swing.JLabel();
        propMonthlyRent1 = new javax.swing.JLabel();
        jSeparator15 = new javax.swing.JSeparator();
        propDeposit1 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        propType1 = new javax.swing.JLabel();
        propDeposit3 = new javax.swing.JLabel();
        propDeposit4 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jSeparator16 = new javax.swing.JSeparator();
        propDeposit5 = new javax.swing.JLabel();
        propDuration1 = new javax.swing.JComboBox<>();
        propDeposit6 = new javax.swing.JLabel();
        propDeposit7 = new javax.swing.JLabel();
        propDeposit8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        viewDoubleRoom = new javax.swing.JPanel();
        jLabel91 = new javax.swing.JLabel();
        doubleRoomMaxPrice = new javax.swing.JTextField();
        doubleRoomMinPrice = new javax.swing.JTextField();
        radioNone3 = new javax.swing.JRadioButton();
        doubleRadioMale = new javax.swing.JRadioButton();
        doubleRadioFemale = new javax.swing.JRadioButton();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        doubleRoomFilter = new javax.swing.JButton();
        doubleRoomReset = new javax.swing.JButton();
        doubleRoomSearchField = new javax.swing.JTextField();
        doubleRoommSearchButton2 = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        doubleRoomTable = new javax.swing.JTable();
        doubleBackButton = new javax.swing.JLabel();
        doubleRoomsNumber = new javax.swing.JComboBox<>();
        Application = new javax.swing.JPanel();
        Header5 = new javax.swing.JPanel();
        jLabel103 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        Foorter = new javax.swing.JPanel();
        BodyApplication = new javax.swing.JPanel();
        viewApplicationInfo = new javax.swing.JPanel();
        appApplicationId = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        appName = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        appStatus = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        appMonthly = new javax.swing.JLabel();
        appRoomId = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        paymentTable = new javax.swing.JTable();
        appDuration = new javax.swing.JLabel();
        jSeparator17 = new javax.swing.JSeparator();
        jSeparator18 = new javax.swing.JSeparator();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        appEmail = new javax.swing.JLabel();
        appCost = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        refundList = new javax.swing.JButton();
        Refresh = new javax.swing.JButton();
        RefreshTextFiled = new javax.swing.JTextField();
        viewPaymentDetail = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        appApplicationId1 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        appName1 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        appRoomId1 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        appRoomId2 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        paymentid = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        appRoomId4 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        appRoomId5 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        appRoomId6 = new javax.swing.JLabel();
        jSeparator19 = new javax.swing.JSeparator();
        jSeparator20 = new javax.swing.JSeparator();
        jSeparator21 = new javax.swing.JSeparator();
        jSeparator22 = new javax.swing.JSeparator();
        jLabel128 = new javax.swing.JLabel();
        PaymentPayButton = new javax.swing.JToggleButton();
        paymentCancelButton = new javax.swing.JToggleButton();
        paymentContainer = new javax.swing.JPanel();
        paymentCashPanel = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        paymentCardPanel = new javax.swing.JPanel();
        paymentCardNumber = new javax.swing.JTextField();
        paymentCCV = new javax.swing.JTextField();
        paymentExpairationDate = new javax.swing.JTextField();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        paymentCard = new javax.swing.JRadioButton();
        paymentCash1 = new javax.swing.JRadioButton();
        jSeparator23 = new javax.swing.JSeparator();
        jSeparator24 = new javax.swing.JSeparator();
        jSeparator25 = new javax.swing.JSeparator();
        jLabel131 = new javax.swing.JLabel();
        appRoomId7 = new javax.swing.JLabel();
        appRefundList = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        refundTable = new javax.swing.JTable();
        refundSearchField = new javax.swing.JTextField();
        paymentRefundSearchButton = new javax.swing.JButton();
        refundFillterButton = new javax.swing.JButton();
        PanelDate2 = new javax.swing.JPanel();
        refundMinYear = new javax.swing.JComboBox<>();
        jLabel110 = new javax.swing.JLabel();
        refundMinMonth = new javax.swing.JComboBox<>();
        jLabel112 = new javax.swing.JLabel();
        refundMaxYear = new javax.swing.JComboBox<>();
        jLabel113 = new javax.swing.JLabel();
        refundMaxMonth = new javax.swing.JComboBox<>();
        jLabel115 = new javax.swing.JLabel();
        viewrefundBack = new javax.swing.JLabel();
        refundRestButton = new javax.swing.JButton();
        Records = new javax.swing.JPanel();
        Header3 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        Header4 = new javax.swing.JPanel();
        DisplayRecord = new javax.swing.JPanel();
        SelelctRecord = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        loginRecord = new javax.swing.JButton();
        paymentRecord = new javax.swing.JButton();
        applicationRecord = new javax.swing.JButton();
        jLabel64 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        viewPaymentRecord = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        PaymetRecordTabel = new javax.swing.JTable();
        paymentRecordSearchField = new javax.swing.JTextField();
        paymentFillterButton = new javax.swing.JButton();
        paymentrRecordSearchButton = new javax.swing.JButton();
        PanelDate = new javax.swing.JPanel();
        paymentMinYear = new javax.swing.JComboBox<>();
        jLabel71 = new javax.swing.JLabel();
        paymentMinMonth = new javax.swing.JComboBox<>();
        jLabel70 = new javax.swing.JLabel();
        paymentMaxYear = new javax.swing.JComboBox<>();
        jLabel69 = new javax.swing.JLabel();
        paymentMaxMonth = new javax.swing.JComboBox<>();
        jLabel67 = new javax.swing.JLabel();
        paymentRecordBack = new javax.swing.JLabel();
        viewApplicationRecord1 = new javax.swing.JPanel();
        applicationRecordSearchField = new javax.swing.JTextField();
        applicationRecordSearchButton = new javax.swing.JButton();
        applicationStatus = new javax.swing.JComboBox<>();
        applicationFillterButton = new javax.swing.JButton();
        lbStatus6 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        applicationRecordTable = new javax.swing.JTable();
        viewApplicationRecord = new javax.swing.JPanel();
        applicationMinYear = new javax.swing.JComboBox<>();
        jLabel79 = new javax.swing.JLabel();
        applicationMinMonth = new javax.swing.JComboBox<>();
        jLabel80 = new javax.swing.JLabel();
        applicationMaxYear = new javax.swing.JComboBox<>();
        jLabel81 = new javax.swing.JLabel();
        applicationMaxMonth = new javax.swing.JComboBox<>();
        jLabel82 = new javax.swing.JLabel();
        viewApplicationRecord2 = new javax.swing.JPanel();
        recordSearchField4 = new javax.swing.JTextField();
        recordFilterButton4 = new javax.swing.JButton();
        cmbStatus7 = new javax.swing.JComboBox<>();
        RecordFillterButton4 = new javax.swing.JButton();
        lbStatus7 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        applicationRecordTable1 = new javax.swing.JTable();
        viewApplicationRecord3 = new javax.swing.JPanel();
        StartYear5 = new javax.swing.JComboBox<>();
        jLabel83 = new javax.swing.JLabel();
        StartMonth4 = new javax.swing.JComboBox<>();
        jLabel84 = new javax.swing.JLabel();
        EndYear4 = new javax.swing.JComboBox<>();
        jLabel85 = new javax.swing.JLabel();
        EndMonth4 = new javax.swing.JComboBox<>();
        jLabel86 = new javax.swing.JLabel();
        applicationBackButton = new javax.swing.JLabel();
        viewLoginRecord = new javax.swing.JPanel();
        loginRecordSearchField = new javax.swing.JTextField();
        loginRecordSearchButton1 = new javax.swing.JButton();
        loginRecordBack = new javax.swing.JLabel();
        PanelDate1 = new javax.swing.JPanel();
        loginMinYear = new javax.swing.JComboBox<>();
        jLabel72 = new javax.swing.JLabel();
        loginMinMonth = new javax.swing.JComboBox<>();
        jLabel73 = new javax.swing.JLabel();
        loginMaxYear = new javax.swing.JComboBox<>();
        jLabel74 = new javax.swing.JLabel();
        loginMaxMonth = new javax.swing.JComboBox<>();
        jLabel68 = new javax.swing.JLabel();
        loginFillterButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        loginRecordTabel = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Sidebar.setBackground(new java.awt.Color(25, 118, 221));
        Sidebar.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("RoommateMatch");
        Sidebar.add(jLabel2);
        jLabel2.setBounds(10, 20, 130, 30);

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        Sidebar.add(jSeparator1);
        jSeparator1.setBounds(10, 50, 150, 20);

        btnProfile.setBackground(new java.awt.Color(25, 118, 185));
        btnProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProfileMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Profile");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/profile30px.png"))); // NOI18N

        javax.swing.GroupLayout btnProfileLayout = new javax.swing.GroupLayout(btnProfile);
        btnProfile.setLayout(btnProfileLayout);
        btnProfileLayout.setHorizontalGroup(
            btnProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnProfileLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnProfileLayout.setVerticalGroup(
            btnProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnProfileLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Sidebar.add(btnProfile);
        btnProfile.setBounds(0, 90, 200, 40);

        btnProperties.setBackground(new java.awt.Color(25, 118, 185));
        btnProperties.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPropertiesMouseClicked(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/home_30px.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Properties");

        javax.swing.GroupLayout btnPropertiesLayout = new javax.swing.GroupLayout(btnProperties);
        btnProperties.setLayout(btnPropertiesLayout);
        btnPropertiesLayout.setHorizontalGroup(
            btnPropertiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPropertiesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel8)
                .addGap(30, 30, 30)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnPropertiesLayout.setVerticalGroup(
            btnPropertiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Sidebar.add(btnProperties);
        btnProperties.setBounds(0, 160, 200, 40);

        btnApplication.setBackground(new java.awt.Color(25, 118, 185));
        btnApplication.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnApplicationMouseClicked(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/record_30px.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Record");

        javax.swing.GroupLayout btnApplicationLayout = new javax.swing.GroupLayout(btnApplication);
        btnApplication.setLayout(btnApplicationLayout);
        btnApplicationLayout.setHorizontalGroup(
            btnApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnApplicationLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addGap(30, 30, 30)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        btnApplicationLayout.setVerticalGroup(
            btnApplicationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Sidebar.add(btnApplication);
        btnApplication.setBounds(0, 230, 200, 40);

        btnRecord.setBackground(new java.awt.Color(25, 118, 185));
        btnRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRecordMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Application");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/application_30px.png"))); // NOI18N

        javax.swing.GroupLayout btnRecordLayout = new javax.swing.GroupLayout(btnRecord);
        btnRecord.setLayout(btnRecordLayout);
        btnRecordLayout.setHorizontalGroup(
            btnRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnRecordLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(842, 842, 842))
        );
        btnRecordLayout.setVerticalGroup(
            btnRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnRecordLayout.createSequentialGroup()
                .addGroup(btnRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(276, 276, 276))
        );

        Sidebar.add(btnRecord);
        btnRecord.setBounds(0, 300, 200, 40);

        btnLogout.setBackground(new java.awt.Color(25, 118, 185));
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMouseClicked(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/logout30px.png"))); // NOI18N

        jLabel11.setBackground(new java.awt.Color(25, 118, 185));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Logout");

        javax.swing.GroupLayout btnLogoutLayout = new javax.swing.GroupLayout(btnLogout);
        btnLogout.setLayout(btnLogoutLayout);
        btnLogoutLayout.setHorizontalGroup(
            btnLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnLogoutLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        btnLogoutLayout.setVerticalGroup(
            btnLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnLogoutLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(btnLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        Sidebar.add(btnLogout);
        btnLogout.setBounds(0, 370, 200, 40);

        getContentPane().add(Sidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 470));

        Parent.setBackground(new java.awt.Color(255, 255, 255));
        Parent.setMaximumSize(new java.awt.Dimension(630, 430));
        Parent.setMinimumSize(new java.awt.Dimension(630, 430));
        Parent.setPreferredSize(new java.awt.Dimension(630, 430));
        Parent.setLayout(new java.awt.CardLayout());

        Header1.setBackground(new java.awt.Color(25, 118, 185));

        jLabel37.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("X");
        jLabel37.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel37MouseClicked(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Malgun Gothic", 0, 30)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Profile");

        welcoming.setBackground(new java.awt.Color(255, 255, 255));
        welcoming.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        welcoming.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout Header1Layout = new javax.swing.GroupLayout(Header1);
        Header1.setLayout(Header1Layout);
        Header1Layout.setHorizontalGroup(
            Header1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Header1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(welcoming, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 233, Short.MAX_VALUE)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        Header1Layout.setVerticalGroup(
            Header1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Header1Layout.createSequentialGroup()
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Header1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(Header1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(welcoming, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ProfileBody.setBackground(new java.awt.Color(255, 255, 255));
        ProfileBody.setLayout(new java.awt.CardLayout());

        personalInfo.setBackground(new java.awt.Color(255, 255, 255));
        personalInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/user_500px.png"))); // NOI18N
        personalInfo.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 430, 275));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel39.setText("Name :");
        personalInfo.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 60, -1));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel40.setText("UserName: ");
        personalInfo.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 80, -1));

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel41.setText("Address: ");
        personalInfo.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 65, -1));

        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel42.setText("TP Number :");
        personalInfo.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 80, -1));

        Header2.setBackground(new java.awt.Color(25, 118, 185));

        javax.swing.GroupLayout Header2Layout = new javax.swing.GroupLayout(Header2);
        Header2.setLayout(Header2Layout);
        Header2Layout.setHorizontalGroup(
            Header2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
        );
        Header2Layout.setVerticalGroup(
            Header2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        personalInfo.add(Header2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 369, 830, 60));

        profileName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        profileName.setText("name");
        personalInfo.add(profileName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 67, -1));

        ProfileAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ProfileAddress.setText("address");
        personalInfo.add(ProfileAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 280, -1));

        ProfileTPNumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ProfileTPNumber.setText("tpnumber");
        personalInfo.add(ProfileTPNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 110, -1));

        ProfileUserName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ProfileUserName.setText("username");
        personalInfo.add(ProfileUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 130, -1));

        jLabel47.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel47.setText("Email:");
        personalInfo.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 40, -1));

        profileEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        profileEmail.setText("email");
        personalInfo.add(profileEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 130, -1));

        jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel49.setText("Gender: ");
        personalInfo.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, -1, -1));

        ProfileGender.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ProfileGender.setText("gender");
        personalInfo.add(ProfileGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 76, -1));

        jLabel51.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel51.setText("Role :");
        personalInfo.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, -1, -1));

        ProfileRole.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ProfileRole.setText("role");
        personalInfo.add(ProfileRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 110, -1));
        personalInfo.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 390, 10));
        personalInfo.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 390, 10));
        personalInfo.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 390, 10));
        personalInfo.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 390, 10));

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        personalInfo.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 10, 40));

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        personalInfo.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 10, 40));

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);
        personalInfo.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 10, 40));

        ProfileBody.add(personalInfo, "card2");

        javax.swing.GroupLayout ProfileLayout = new javax.swing.GroupLayout(Profile);
        Profile.setLayout(ProfileLayout);
        ProfileLayout.setHorizontalGroup(
            ProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProfileLayout.createSequentialGroup()
                .addComponent(Header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 55, Short.MAX_VALUE))
            .addGroup(ProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ProfileBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ProfileLayout.setVerticalGroup(
            ProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProfileLayout.createSequentialGroup()
                .addComponent(Header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 412, Short.MAX_VALUE))
            .addGroup(ProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProfileLayout.createSequentialGroup()
                    .addGap(0, 55, Short.MAX_VALUE)
                    .addComponent(ProfileBody, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        Parent.add(Profile, "card3");

        Properties.setBackground(new java.awt.Color(255, 255, 255));
        Properties.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setBackground(new java.awt.Color(25, 118, 185));

        jLabel15.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("X");
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Malgun Gothic", 0, 30)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Properties");

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Properties.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 50));

        Body.setBackground(new java.awt.Color(255, 255, 255));
        Body.setLayout(new java.awt.CardLayout());

        SelectProperite.setBackground(new java.awt.Color(255, 255, 255));
        SelectProperite.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SingleRoomPanel.setBackground(new java.awt.Color(25, 118, 221));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Single Room");

        btnSingle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSingle.setForeground(new java.awt.Color(25, 118, 221));
        btnSingle.setText("View");
        btnSingle.setBorder(null);
        btnSingle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSingleActionPerformed(evt);
            }
        });

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Single  room.jpg"))); // NOI18N

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Display all avaliable single  rooms ");

        javax.swing.GroupLayout SingleRoomPanelLayout = new javax.swing.GroupLayout(SingleRoomPanel);
        SingleRoomPanel.setLayout(SingleRoomPanelLayout);
        SingleRoomPanelLayout.setHorizontalGroup(
            SingleRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SingleRoomPanelLayout.createSequentialGroup()
                .addGroup(SingleRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SingleRoomPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(SingleRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(btnSingle, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(SingleRoomPanelLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel17)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SingleRoomPanelLayout.setVerticalGroup(
            SingleRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SingleRoomPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addGroup(SingleRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, SingleRoomPanelLayout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSingle, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        SelectProperite.add(SingleRoomPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 390, 180));

        UnitPanel.setBackground(new java.awt.Color(25, 118, 221));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Master Room");

        btnMaster.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMaster.setForeground(new java.awt.Color(25, 118, 221));
        btnMaster.setText("View");
        btnMaster.setBorder(null);
        btnMaster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasterActionPerformed(evt);
            }
        });

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Master (1).jpg"))); // NOI18N

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Display all avaliable Master rooms ");

        javax.swing.GroupLayout UnitPanelLayout = new javax.swing.GroupLayout(UnitPanel);
        UnitPanel.setLayout(UnitPanelLayout);
        UnitPanelLayout.setHorizontalGroup(
            UnitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UnitPanelLayout.createSequentialGroup()
                .addGroup(UnitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UnitPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(UnitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(btnMaster, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(UnitPanelLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel18)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        UnitPanelLayout.setVerticalGroup(
            UnitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UnitPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(UnitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UnitPanelLayout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnMaster, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        SelectProperite.add(UnitPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 390, 160));

        MasterPane.setBackground(new java.awt.Color(25, 118, 221));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Unit");

        btnUnit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUnit.setForeground(new java.awt.Color(25, 118, 221));
        btnUnit.setText("View");
        btnUnit.setBorder(null);
        btnUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnitActionPerformed(evt);
            }
        });

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Unit (1).png"))); // NOI18N

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Display all avaliable Units ");

        javax.swing.GroupLayout MasterPaneLayout = new javax.swing.GroupLayout(MasterPane);
        MasterPane.setLayout(MasterPaneLayout);
        MasterPaneLayout.setHorizontalGroup(
            MasterPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MasterPaneLayout.createSequentialGroup()
                .addGroup(MasterPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MasterPaneLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(MasterPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MasterPaneLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(MasterPaneLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel25))))
                    .addGroup(MasterPaneLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel23)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        MasterPaneLayout.setVerticalGroup(
            MasterPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MasterPaneLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MasterPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MasterPaneLayout.createSequentialGroup()
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        SelectProperite.add(MasterPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 390, 180));

        DoubleRoomPane.setBackground(new java.awt.Color(25, 118, 221));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Double");

        btnDouble.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDouble.setForeground(new java.awt.Color(25, 118, 221));
        btnDouble.setText("View");
        btnDouble.setBorder(null);
        btnDouble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoubleActionPerformed(evt);
            }
        });

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Master (1).jpg"))); // NOI18N

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Display all avaliable Double rooms ");

        javax.swing.GroupLayout DoubleRoomPaneLayout = new javax.swing.GroupLayout(DoubleRoomPane);
        DoubleRoomPane.setLayout(DoubleRoomPaneLayout);
        DoubleRoomPaneLayout.setHorizontalGroup(
            DoubleRoomPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DoubleRoomPaneLayout.createSequentialGroup()
                .addGroup(DoubleRoomPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DoubleRoomPaneLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(DoubleRoomPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36)
                            .addComponent(btnDouble, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(DoubleRoomPaneLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel34)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        DoubleRoomPaneLayout.setVerticalGroup(
            DoubleRoomPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DoubleRoomPaneLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DoubleRoomPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DoubleRoomPaneLayout.createSequentialGroup()
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDouble, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        SelectProperite.add(DoubleRoomPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, -1, -1));

        Body.add(SelectProperite, "card2");

        ViewSingleRoom.setBackground(new java.awt.Color(255, 255, 255));
        ViewSingleRoom.setAutoscrolls(true);
        ViewSingleRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ViewSingleRoomMouseClicked(evt);
            }
        });
        ViewSingleRoom.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        singleRoomTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Type", "Size", "Monthly rent", "Deposit", "Status", "View"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        singleRoomTable.setAlignmentX(0.0F);
        singleRoomTable.setAlignmentY(0.0F);
        singleRoomTable.setGridColor(new java.awt.Color(236, 236, 236));
        singleRoomTable.setName(""); // NOI18N
        singleRoomTable.setRequestFocusEnabled(false);
        singleRoomTable.setRowHeight(40);
        singleRoomTable.setSelectionBackground(new java.awt.Color(232, 57, 95));
        singleRoomTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        singleRoomTable.setShowHorizontalLines(true);
        singleRoomTable.setShowVerticalLines(true);
        singleRoomTable.getTableHeader().setResizingAllowed(false);
        singleRoomTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(singleRoomTable);
        singleRoomTable.getAccessibleContext().setAccessibleName("");
        singleRoomTable.getAccessibleContext().setAccessibleDescription("");

        ViewSingleRoom.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 830, 310));

        Footer.setBackground(new java.awt.Color(25, 118, 185));

        javax.swing.GroupLayout FooterLayout = new javax.swing.GroupLayout(Footer);
        Footer.setLayout(FooterLayout);
        FooterLayout.setHorizontalGroup(
            FooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        FooterLayout.setVerticalGroup(
            FooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        ViewSingleRoom.add(Footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 780, -1));

        singleMinPrice.setText("Min");
        singleMinPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singleMinPriceActionPerformed(evt);
            }
        });
        ViewSingleRoom.add(singleMinPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 60, 30));

        singleRoomReset.setText("Reset");
        singleRoomReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singleRoomResetActionPerformed(evt);
            }
        });
        ViewSingleRoom.add(singleRoomReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, -1, -1));

        jLabel27.setText("_");
        ViewSingleRoom.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 10, 20));

        singleRoomSearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singleRoomSearchFieldActionPerformed(evt);
            }
        });
        singleRoomSearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                singleRoomSearchFieldKeyReleased(evt);
            }
        });
        ViewSingleRoom.add(singleRoomSearchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 190, 30));

        singleMaxPrice.setText("Max");
        singleMaxPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singleMaxPriceActionPerformed(evt);
            }
        });
        ViewSingleRoom.add(singleMaxPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 60, 30));

        singleRoomSearchButton.setText("Search");
        singleRoomSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singleRoomSearchButtonActionPerformed(evt);
            }
        });
        ViewSingleRoom.add(singleRoomSearchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, -1, 30));

        singleRoomFilter.setText("Filter");
        singleRoomFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singleRoomFilterActionPerformed(evt);
            }
        });
        ViewSingleRoom.add(singleRoomFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, -1, -1));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/arrow.png"))); // NOI18N
        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel30MouseClicked(evt);
            }
        });
        ViewSingleRoom.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, -1));

        filterCompnents.setOpaque(false);
        filterCompnents.setLayout(new java.awt.CardLayout());

        filterCom1.setOpaque(false);

        singleBathroomType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Shared", "Independent" }));

        jLabel29.setText("BathRoom Type :");

        javax.swing.GroupLayout filterCom1Layout = new javax.swing.GroupLayout(filterCom1);
        filterCom1.setLayout(filterCom1Layout);
        filterCom1Layout.setHorizontalGroup(
            filterCom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filterCom1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel29)
                .addGap(18, 18, 18)
                .addComponent(singleBathroomType, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        filterCom1Layout.setVerticalGroup(
            filterCom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filterCom1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(filterCom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(singleBathroomType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        filterCompnents.add(filterCom1, "card2");

        filterCom2.setOpaque(false);

        jLabel28.setText("Rooms Number:");

        bathroomNumber.setModel(new javax.swing.SpinnerNumberModel(1, 1, 3, 1));

        jLabel32.setText("Bathrooms Number:");

        roomsNumber.setModel(new javax.swing.SpinnerNumberModel(1, 1, 4, 1));

        javax.swing.GroupLayout filterCom2Layout = new javax.swing.GroupLayout(filterCom2);
        filterCom2.setLayout(filterCom2Layout);
        filterCom2Layout.setHorizontalGroup(
            filterCom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filterCom2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roomsNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bathroomNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        filterCom2Layout.setVerticalGroup(
            filterCom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filterCom2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(filterCom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(bathroomNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32)
                    .addComponent(roomsNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        filterCompnents.add(filterCom2, "card3");

        ViewSingleRoom.add(filterCompnents, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 370, 50));

        jLabel31.setText("Gender preference");
        ViewSingleRoom.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 110, 20));

        buttonGroup2.add(singleRadioMale);
        singleRadioMale.setText("Male");
        singleRadioMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singleRadioMaleActionPerformed(evt);
            }
        });
        ViewSingleRoom.add(singleRadioMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        buttonGroup2.add(singleRadioFemale);
        singleRadioFemale.setText("Female");
        ViewSingleRoom.add(singleRadioFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, -1, -1));

        jLabel33.setText("Price:  ");
        ViewSingleRoom.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, -1, -1));

        buttonGroup2.add(radioNone);
        radioNone.setSelected(true);
        radioNone.setText("none");
        radioNone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNoneActionPerformed(evt);
            }
        });
        ViewSingleRoom.add(radioNone, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, -1, 20));

        Body.add(ViewSingleRoom, "card3");

        viewRoomDetails.setBackground(new java.awt.Color(255, 255, 255));
        viewRoomDetails.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Double_room.jpg"))); // NOI18N
        viewRoomDetails.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 220, 240));

        jLabel55.setText("Deposit :  ");
        viewRoomDetails.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 60, -1));

        propStatus.setText("status");
        viewRoomDetails.add(propStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 100, -1));

        jLabel48.setText("Status: ");
        viewRoomDetails.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 50, -1));

        jLabel58.setText("RM");
        viewRoomDetails.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 170, 40, -1));

        propDeposit.setText("deposit");
        viewRoomDetails.add(propDeposit, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 50, -1));

        jLabel50.setText("RM");
        viewRoomDetails.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 40, -1));

        propGender.setText("gender");
        viewRoomDetails.add(propGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 50, -1));

        jLabel52.setText("Gender prefernce : ");
        viewRoomDetails.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 110, -1));

        propLocation.setText("location");
        viewRoomDetails.add(propLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 130, 100, -1));

        propSize.setText("size");
        viewRoomDetails.add(propSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 90, 30, -1));

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/arrow.png"))); // NOI18N
        jLabel44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel44MouseClicked(evt);
            }
        });
        viewRoomDetails.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, -1));

        jLabel45.setText("Type :");
        viewRoomDetails.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 40, -1));

        propType.setText("type");
        viewRoomDetails.add(propType, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 100, -1));
        viewRoomDetails.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 450, 10));

        jLabel46.setText("Location :");
        viewRoomDetails.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, 60, -1));

        jLabel56.setText("Size: ");
        viewRoomDetails.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 40, -1));

        jLabel57.setText("sq ft");
        viewRoomDetails.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, 40, -1));
        viewRoomDetails.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 450, 10));
        viewRoomDetails.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 450, 10));
        viewRoomDetails.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 450, 10));

        propDescription.setColumns(20);
        propDescription.setRows(5);
        propDescription.setText("description");
        jScrollPane2.setViewportView(propDescription);

        viewRoomDetails.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, 460, 130));

        jButton1.setBackground(new java.awt.Color(25, 118, 221));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Make Application");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        viewRoomDetails.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 220, 40));

        jLabel54.setText(" Description:");
        viewRoomDetails.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 90, -1));

        jLabel97.setText("Monthly Rent:  ");
        viewRoomDetails.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, 90, -1));

        propMonthly.setText("monthly rent");
        viewRoomDetails.add(propMonthly, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 170, 60, -1));

        jLabel98.setText("RM");
        viewRoomDetails.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 170, 40, -1));

        jLabel101.setText("Room ID:");
        viewRoomDetails.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 60, -1));

        propRoomId.setText("roomid");
        viewRoomDetails.add(propRoomId, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, 100, -1));

        Body.add(viewRoomDetails, "card4");

        viewMasterRoom.setBackground(new java.awt.Color(255, 255, 255));
        viewMasterRoom.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        masterBackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/arrow.png"))); // NOI18N
        masterBackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                masterBackButtonMouseClicked(evt);
            }
        });
        viewMasterRoom.add(masterBackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, -1));

        masterRoomSearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masterRoomSearchFieldActionPerformed(evt);
            }
        });
        masterRoomSearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                masterRoomSearchFieldKeyReleased(evt);
            }
        });
        viewMasterRoom.add(masterRoomSearchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 190, 30));

        mastersRoomSearchButton.setText("Search");
        mastersRoomSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mastersRoomSearchButtonActionPerformed(evt);
            }
        });
        viewMasterRoom.add(mastersRoomSearchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, -1, 30));

        buttonGroup1.add(masterRadioMale);
        masterRadioMale.setText("Male");
        masterRadioMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masterRadioMaleActionPerformed(evt);
            }
        });
        viewMasterRoom.add(masterRadioMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, -1, -1));

        jLabel76.setText("Gender preference");
        viewMasterRoom.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 110, 20));

        buttonGroup1.add(radioNone1);
        radioNone1.setSelected(true);
        radioNone1.setText("none");
        radioNone1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNone1ActionPerformed(evt);
            }
        });
        viewMasterRoom.add(radioNone1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, -1, 20));

        buttonGroup1.add(masterRadioFemale);
        masterRadioFemale.setText("Female");
        viewMasterRoom.add(masterRadioFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, -1, -1));

        jLabel77.setText("Price:  ");
        viewMasterRoom.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, -1, -1));

        masterRoomMinPrice.setText("Min");
        masterRoomMinPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masterRoomMinPriceActionPerformed(evt);
            }
        });
        viewMasterRoom.add(masterRoomMinPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 60, 30));

        jLabel78.setText("_");
        viewMasterRoom.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, 10, 20));

        masterRoomMaxPrice.setText("Max");
        masterRoomMaxPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masterRoomMaxPriceActionPerformed(evt);
            }
        });
        viewMasterRoom.add(masterRoomMaxPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 60, 30));

        masterRoomFilter.setText("Filter");
        masterRoomFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masterRoomFilterActionPerformed(evt);
            }
        });
        viewMasterRoom.add(masterRoomFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, -1, -1));

        masterRoomReset.setText("Reset");
        masterRoomReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masterRoomResetActionPerformed(evt);
            }
        });
        viewMasterRoom.add(masterRoomReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, -1, -1));

        jScrollPane8.setBackground(new java.awt.Color(255, 255, 255));

        masterRoomTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        masterRoomTable.setAlignmentX(0.0F);
        masterRoomTable.setAlignmentY(0.0F);
        masterRoomTable.setGridColor(new java.awt.Color(236, 236, 236));
        masterRoomTable.setName(""); // NOI18N
        masterRoomTable.setRequestFocusEnabled(false);
        masterRoomTable.setRowHeight(40);
        masterRoomTable.setSelectionBackground(new java.awt.Color(232, 57, 95));
        masterRoomTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        masterRoomTable.setShowHorizontalLines(true);
        masterRoomTable.setShowVerticalLines(true);
        masterRoomTable.getTableHeader().setResizingAllowed(false);
        masterRoomTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane8.setViewportView(masterRoomTable);

        viewMasterRoom.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 830, 310));

        Body.add(viewMasterRoom, "card5");

        viewUnit.setBackground(new java.awt.Color(255, 255, 255));
        viewUnit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        unitRoomSearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unitRoomSearchFieldActionPerformed(evt);
            }
        });
        unitRoomSearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                unitRoomSearchFieldKeyReleased(evt);
            }
        });
        viewUnit.add(unitRoomSearchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 190, 30));

        unitRoomSearchButton1.setText("Search");
        unitRoomSearchButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unitRoomSearchButton1ActionPerformed(evt);
            }
        });
        viewUnit.add(unitRoomSearchButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, -1, 30));

        buttonGroup3.add(unitRadioMale);
        unitRadioMale.setText("Male");
        unitRadioMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unitRadioMaleActionPerformed(evt);
            }
        });
        viewUnit.add(unitRadioMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        buttonGroup3.add(unitRadioFemale);
        unitRadioFemale.setText("Female");
        viewUnit.add(unitRadioFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, -1, -1));

        buttonGroup3.add(radioNone2);
        radioNone2.setSelected(true);
        radioNone2.setText("none");
        radioNone2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNone2ActionPerformed(evt);
            }
        });
        viewUnit.add(radioNone2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, -1, 20));

        unitRoomMinPrice.setText("Min");
        unitRoomMinPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unitRoomMinPriceActionPerformed(evt);
            }
        });
        viewUnit.add(unitRoomMinPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 60, 30));

        jLabel87.setText("Price:  ");
        viewUnit.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, -1, -1));

        jLabel88.setText("_");
        viewUnit.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 10, 20));

        unitRoomMaxPrice.setText("Max");
        unitRoomMaxPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unitRoomMaxPriceActionPerformed(evt);
            }
        });
        viewUnit.add(unitRoomMaxPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 60, 30));

        unitRoomReset.setText("Reset");
        unitRoomReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unitRoomResetActionPerformed(evt);
            }
        });
        viewUnit.add(unitRoomReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, -1, -1));

        unitRoomFilter.setText("Filter");
        unitRoomFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unitRoomFilterActionPerformed(evt);
            }
        });
        viewUnit.add(unitRoomFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, -1, -1));

        jScrollPane9.setBackground(new java.awt.Color(255, 255, 255));

        unitRoomTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Type", "Size", "Monthly rent", "Deposit", "Status", "View"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        unitRoomTable.setAlignmentX(0.0F);
        unitRoomTable.setAlignmentY(0.0F);
        unitRoomTable.setGridColor(new java.awt.Color(236, 236, 236));
        unitRoomTable.setName(""); // NOI18N
        unitRoomTable.setRequestFocusEnabled(false);
        unitRoomTable.setRowHeight(40);
        unitRoomTable.setSelectionBackground(new java.awt.Color(232, 57, 95));
        unitRoomTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        unitRoomTable.setShowHorizontalLines(true);
        unitRoomTable.setShowVerticalLines(true);
        unitRoomTable.getTableHeader().setResizingAllowed(false);
        unitRoomTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane9.setViewportView(unitRoomTable);

        viewUnit.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 830, 310));

        unitBackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/arrow.png"))); // NOI18N
        unitBackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                unitBackButtonMouseClicked(evt);
            }
        });
        viewUnit.add(unitBackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, -1));

        jLabel89.setText("Gender preference");
        viewUnit.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 110, 20));

        filterCom4.setOpaque(false);

        jLabel75.setText("Room number");

        jLabel90.setText("BathRooms number");

        unitRoomsNumber.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));

        unitBathroomsNumber.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));

        javax.swing.GroupLayout filterCom4Layout = new javax.swing.GroupLayout(filterCom4);
        filterCom4.setLayout(filterCom4Layout);
        filterCom4Layout.setHorizontalGroup(
            filterCom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filterCom4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel75)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(unitRoomsNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(unitBathroomsNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        filterCom4Layout.setVerticalGroup(
            filterCom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filterCom4Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(filterCom4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel75)
                    .addComponent(jLabel90)
                    .addComponent(unitRoomsNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(unitBathroomsNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        viewUnit.add(filterCom4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, -1, -1));

        Body.add(viewUnit, "card6");

        makeApplication.setBackground(new java.awt.Color(255, 255, 255));
        makeApplication.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel94.setText("Name :");
        makeApplication.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 40, -1));

        propName1.setText("name");
        makeApplication.add(propName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 100, -1));
        makeApplication.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 450, 10));

        jLabel95.setText("UserName :");
        makeApplication.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 70, -1));

        propUserName1.setText("username");
        makeApplication.add(propUserName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 50, 100, -1));

        jLabel96.setText("Email : ");
        makeApplication.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 50, -1));

        propEmail1.setText("email");
        makeApplication.add(propEmail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 100, -1));

        jLabel99.setText("Room ID:");
        makeApplication.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, 60, -1));

        propRoomId1.setText("roomid");
        makeApplication.add(propRoomId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, 60, -1));
        makeApplication.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 450, 10));
        makeApplication.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 60, -1));

        propMonthlyRent1.setText("monthly rent");
        makeApplication.add(propMonthlyRent1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 150, 100, -1));
        makeApplication.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, 450, 30));

        propDeposit1.setText("deposit");
        makeApplication.add(propDeposit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, 60, -1));

        jLabel102.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Double_room.jpg"))); // NOI18N
        makeApplication.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 220, 240));

        propType1.setText("type");
        makeApplication.add(propType1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, 50, -1));

        propDeposit3.setText("Type :");
        makeApplication.add(propDeposit3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 50, -1));

        propDeposit4.setText("RM");
        makeApplication.add(propDeposit4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, 60, -1));

        jLabel104.setText("Deposit:");
        makeApplication.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 60, -1));
        makeApplication.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 450, 20));

        propDeposit5.setText("Monthly Renatal : ");
        makeApplication.add(propDeposit5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 100, -1));

        propDuration1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "6", "12", "24" }));
        makeApplication.add(propDuration1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 210, -1, -1));

        propDeposit6.setText("Duration: ");
        makeApplication.add(propDeposit6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, 60, -1));

        propDeposit7.setText("Months");
        makeApplication.add(propDeposit7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 210, 60, -1));

        propDeposit8.setText("RM");
        makeApplication.add(propDeposit8, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 150, 60, -1));

        jButton3.setBackground(new java.awt.Color(25, 118, 221));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Apply");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        makeApplication.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, 220, 40));

        jButton4.setBackground(new java.awt.Color(255, 0, 0));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Cancel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        makeApplication.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 340, 220, 40));

        Body.add(makeApplication, "card3");

        viewDoubleRoom.setBackground(new java.awt.Color(255, 255, 255));
        viewDoubleRoom.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel91.setText("number of residents");
        viewDoubleRoom.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 120, 40));

        doubleRoomMaxPrice.setText("Max");
        doubleRoomMaxPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doubleRoomMaxPriceActionPerformed(evt);
            }
        });
        viewDoubleRoom.add(doubleRoomMaxPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 60, 30));

        doubleRoomMinPrice.setText("Min");
        doubleRoomMinPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doubleRoomMinPriceActionPerformed(evt);
            }
        });
        viewDoubleRoom.add(doubleRoomMinPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 60, 30));

        buttonGroup4.add(radioNone3);
        radioNone3.setSelected(true);
        radioNone3.setText("none");
        radioNone3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNone3ActionPerformed(evt);
            }
        });
        viewDoubleRoom.add(radioNone3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, -1, 20));

        buttonGroup4.add(doubleRadioMale);
        doubleRadioMale.setText("Male");
        doubleRadioMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doubleRadioMaleActionPerformed(evt);
            }
        });
        viewDoubleRoom.add(doubleRadioMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, -1, -1));

        buttonGroup4.add(doubleRadioFemale);
        doubleRadioFemale.setText("Female");
        viewDoubleRoom.add(doubleRadioFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, -1, -1));

        jLabel92.setText("Gender preference");
        viewDoubleRoom.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 110, 20));

        jLabel93.setText("Price:  ");
        viewDoubleRoom.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, -1, -1));

        doubleRoomFilter.setText("Filter");
        doubleRoomFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doubleRoomFilterActionPerformed(evt);
            }
        });
        viewDoubleRoom.add(doubleRoomFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, -1, -1));

        doubleRoomReset.setText("Reset");
        doubleRoomReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doubleRoomResetActionPerformed(evt);
            }
        });
        viewDoubleRoom.add(doubleRoomReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, -1, -1));

        doubleRoomSearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doubleRoomSearchFieldActionPerformed(evt);
            }
        });
        doubleRoomSearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                doubleRoomSearchFieldKeyReleased(evt);
            }
        });
        viewDoubleRoom.add(doubleRoomSearchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 190, 30));

        doubleRoommSearchButton2.setText("Search");
        doubleRoommSearchButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doubleRoommSearchButton2ActionPerformed(evt);
            }
        });
        viewDoubleRoom.add(doubleRoommSearchButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, -1, 30));

        jScrollPane10.setBackground(new java.awt.Color(255, 255, 255));

        doubleRoomTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Type", "Size", "Monthly rent", "Deposit", "Status", "View"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        doubleRoomTable.setAlignmentX(0.0F);
        doubleRoomTable.setAlignmentY(0.0F);
        doubleRoomTable.setGridColor(new java.awt.Color(236, 236, 236));
        doubleRoomTable.setName(""); // NOI18N
        doubleRoomTable.setRequestFocusEnabled(false);
        doubleRoomTable.setRowHeight(40);
        doubleRoomTable.setSelectionBackground(new java.awt.Color(232, 57, 95));
        doubleRoomTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        doubleRoomTable.setShowHorizontalLines(true);
        doubleRoomTable.setShowVerticalLines(true);
        doubleRoomTable.getTableHeader().setResizingAllowed(false);
        doubleRoomTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane10.setViewportView(doubleRoomTable);

        viewDoubleRoom.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 830, 310));

        doubleBackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/arrow.png"))); // NOI18N
        doubleBackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                doubleBackButtonMouseClicked(evt);
            }
        });
        viewDoubleRoom.add(doubleBackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, -1));

        doubleRoomsNumber.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1" }));
        viewDoubleRoom.add(doubleRoomsNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, -1, -1));

        Body.add(viewDoubleRoom, "card7");

        Properties.add(Body, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 54, -1, 420));

        Parent.add(Properties, "card2");

        Application.setBackground(new java.awt.Color(255, 255, 255));
        Application.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header5.setBackground(new java.awt.Color(25, 118, 185));

        jLabel103.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(255, 255, 255));
        jLabel103.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel103.setText("X");
        jLabel103.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel103.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel103MouseClicked(evt);
            }
        });

        jLabel105.setFont(new java.awt.Font("Malgun Gothic", 0, 30)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(255, 255, 255));
        jLabel105.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel105.setText("Application");

        javax.swing.GroupLayout Header5Layout = new javax.swing.GroupLayout(Header5);
        Header5.setLayout(Header5Layout);
        Header5Layout.setHorizontalGroup(
            Header5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Header5Layout.createSequentialGroup()
                .addContainerGap(252, Short.MAX_VALUE)
                .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(205, 205, 205)
                .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        Header5Layout.setVerticalGroup(
            Header5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Header5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Header5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Application.add(Header5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 50));

        Foorter.setBackground(new java.awt.Color(25, 118, 185));

        javax.swing.GroupLayout FoorterLayout = new javax.swing.GroupLayout(Foorter);
        Foorter.setLayout(FoorterLayout);
        FoorterLayout.setHorizontalGroup(
            FoorterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
        );
        FoorterLayout.setVerticalGroup(
            FoorterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        Application.add(Foorter, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, -1, 40));

        BodyApplication.setBackground(new java.awt.Color(255, 255, 255));
        BodyApplication.setLayout(new java.awt.CardLayout());

        viewApplicationInfo.setBackground(new java.awt.Color(255, 255, 255));
        viewApplicationInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        appApplicationId.setText("application id");
        viewApplicationInfo.add(appApplicationId, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 17, 149, -1));

        jLabel26.setText("Application ID: ");
        viewApplicationInfo.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 17, -1, -1));

        appName.setText("name");
        viewApplicationInfo.add(appName, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, 155, -1));

        jLabel106.setText("Name:");
        viewApplicationInfo.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 40, -1));

        jLabel107.setText("Email : ");
        viewApplicationInfo.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, -1));

        jLabel108.setText("RM");
        viewApplicationInfo.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 30, -1));

        jLabel109.setText("Appication Total Cost: ");
        viewApplicationInfo.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, -1, -1));

        appStatus.setText("status");
        viewApplicationInfo.add(appStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 114, -1));

        jLabel111.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel111.setText("Payment ");
        viewApplicationInfo.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 120, -1));

        appMonthly.setText("monthly rent");
        viewApplicationInfo.add(appMonthly, new org.netbeans.lib.awtextra.AbsoluteConstraints(443, 51, 70, -1));

        appRoomId.setText("roomid");
        viewApplicationInfo.add(appRoomId, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, 145, -1));

        jLabel114.setText("Room ID: ");
        viewApplicationInfo.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, -1, -1));

        jScrollPane11.setBackground(new java.awt.Color(255, 255, 255));

        paymentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Type", "Size", "Monthly rent", "Deposit", "Status", "View"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        paymentTable.setAlignmentX(0.0F);
        paymentTable.setAlignmentY(0.0F);
        paymentTable.setGridColor(new java.awt.Color(236, 236, 236));
        paymentTable.setName(""); // NOI18N
        paymentTable.setRequestFocusEnabled(false);
        paymentTable.setRowHeight(40);
        paymentTable.setSelectionBackground(new java.awt.Color(232, 57, 95));
        paymentTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        paymentTable.setShowHorizontalLines(true);
        paymentTable.setShowVerticalLines(true);
        paymentTable.getTableHeader().setResizingAllowed(false);
        paymentTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane11.setViewportView(paymentTable);

        viewApplicationInfo.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 830, 230));

        appDuration.setText("duration");
        viewApplicationInfo.add(appDuration, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, -1, -1));
        viewApplicationInfo.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 830, 10));
        viewApplicationInfo.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 110, 10));

        jLabel116.setText("Appication Status: ");
        viewApplicationInfo.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 51, -1, -1));

        jLabel117.setText("Duration: ");
        viewApplicationInfo.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));

        jLabel118.setText("Montly rent: ");
        viewApplicationInfo.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, -1, -1));

        appEmail.setText("email");
        viewApplicationInfo.add(appEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 145, -1));

        appCost.setText("cost");
        viewApplicationInfo.add(appCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 80, -1));

        jLabel121.setText("RM");
        viewApplicationInfo.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 30, -1));

        refundList.setBackground(new java.awt.Color(25, 118, 221));
        refundList.setForeground(new java.awt.Color(255, 255, 255));
        refundList.setText("Refund List");
        refundList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refundListActionPerformed(evt);
            }
        });
        viewApplicationInfo.add(refundList, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 120, -1, -1));

        Refresh.setBackground(new java.awt.Color(25, 118, 221));
        Refresh.setForeground(new java.awt.Color(255, 255, 255));
        Refresh.setText("Refresh");
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });
        viewApplicationInfo.add(Refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 120, -1, -1));
        viewApplicationInfo.add(RefreshTextFiled, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 122, -1, 20));

        BodyApplication.add(viewApplicationInfo, "card2");

        viewPaymentDetail.setBackground(new java.awt.Color(255, 255, 255));
        viewPaymentDetail.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel53.setText("Application ID: ");
        viewPaymentDetail.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 17, -1, -1));

        appApplicationId1.setText("application id");
        viewPaymentDetail.add(appApplicationId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 17, 149, -1));

        jLabel119.setText("Name:");
        viewPaymentDetail.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 40, -1));

        appName1.setText("name");
        viewPaymentDetail.add(appName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 120, 90, -1));

        jLabel120.setText("Room ID: ");
        viewPaymentDetail.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        appRoomId1.setText("roomid");
        viewPaymentDetail.add(appRoomId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 145, -1));

        jLabel122.setText("UserName: ");
        viewPaymentDetail.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, -1, -1));

        appRoomId2.setText("username");
        viewPaymentDetail.add(appRoomId2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, 145, -1));

        jLabel123.setText("Payment number ");
        viewPaymentDetail.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, -1, -1));

        paymentid.setText("payment id");
        viewPaymentDetail.add(paymentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 70, -1));

        jLabel124.setText("Year: ");
        viewPaymentDetail.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, -1, -1));

        appRoomId4.setText("issue-year");
        viewPaymentDetail.add(appRoomId4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 110, -1));

        jLabel125.setText("Month:");
        viewPaymentDetail.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));

        appRoomId5.setText("issue-month");
        viewPaymentDetail.add(appRoomId5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 120, -1));

        jLabel126.setText("amount:");
        viewPaymentDetail.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        appRoomId6.setText("amount");
        viewPaymentDetail.add(appRoomId6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 130, -1));
        viewPaymentDetail.add(jSeparator19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 43, 760, 0));

        jSeparator20.setOrientation(javax.swing.SwingConstants.VERTICAL);
        viewPaymentDetail.add(jSeparator20, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 20, 140));
        viewPaymentDetail.add(jSeparator21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 660, 10));
        viewPaymentDetail.add(jSeparator22, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 660, 10));

        jLabel128.setText("payment method:");
        viewPaymentDetail.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, -1));

        PaymentPayButton.setBackground(new java.awt.Color(41, 141, 221));
        PaymentPayButton.setForeground(new java.awt.Color(255, 255, 255));
        PaymentPayButton.setText("Pay");
        PaymentPayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymentPayButtonActionPerformed(evt);
            }
        });
        viewPaymentDetail.add(PaymentPayButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, 110, 30));

        paymentCancelButton.setBackground(new java.awt.Color(255, 0, 0));
        paymentCancelButton.setForeground(new java.awt.Color(255, 255, 255));
        paymentCancelButton.setText("Cancel");
        paymentCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentCancelButtonActionPerformed(evt);
            }
        });
        viewPaymentDetail.add(paymentCancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 350, 100, 30));

        paymentContainer.setOpaque(false);
        paymentContainer.setLayout(new java.awt.CardLayout());

        paymentCashPanel.setOpaque(false);
        paymentCashPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/fotor_2023-5-20_2_9_44.png"))); // NOI18N
        paymentCashPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 110, 100));

        paymentContainer.add(paymentCashPanel, "card3");

        paymentCardPanel.setBackground(new java.awt.Color(41, 141, 221));
        paymentCardPanel.setForeground(new java.awt.Color(255, 255, 255));
        paymentCardPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        paymentCardNumber.setText("0000 - 0000  - 0000  - 0000");
        paymentCardPanel.add(paymentCardNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 320, -1));

        paymentCCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentCCVActionPerformed(evt);
            }
        });
        paymentCardPanel.add(paymentCCV, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 93, -1));

        paymentExpairationDate.setText("MM/YY");
        paymentExpairationDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentExpairationDateActionPerformed(evt);
            }
        });
        paymentCardPanel.add(paymentExpairationDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 150, -1));

        jLabel129.setForeground(new java.awt.Color(255, 255, 255));
        jLabel129.setText("payment method:");
        paymentCardPanel.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel130.setForeground(new java.awt.Color(255, 255, 255));
        jLabel130.setText("Expairation Date");
        paymentCardPanel.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 80, -1));

        jLabel127.setForeground(new java.awt.Color(255, 255, 255));
        jLabel127.setText("CVC");
        paymentCardPanel.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, -1, -1));

        paymentContainer.add(paymentCardPanel, "card2");

        viewPaymentDetail.add(paymentContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 400, 120));

        buttonGroup5.add(paymentCard);
        paymentCard.setText("Card");
        paymentCard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paymentCardMouseClicked(evt);
            }
        });
        paymentCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentCardActionPerformed(evt);
            }
        });
        viewPaymentDetail.add(paymentCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 70, -1));

        buttonGroup5.add(paymentCash1);
        paymentCash1.setSelected(true);
        paymentCash1.setText("Cash");
        paymentCash1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paymentCash1MouseClicked(evt);
            }
        });
        paymentCash1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentCash1ActionPerformed(evt);
            }
        });
        viewPaymentDetail.add(paymentCash1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, -1, -1));
        viewPaymentDetail.add(jSeparator23, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 660, 10));

        jSeparator24.setOrientation(javax.swing.SwingConstants.VERTICAL);
        viewPaymentDetail.add(jSeparator24, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 20, 140));
        viewPaymentDetail.add(jSeparator25, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 660, 10));

        jLabel131.setText("Room Type:");
        viewPaymentDetail.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, -1, -1));

        appRoomId7.setText("type");
        viewPaymentDetail.add(appRoomId7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 110, -1));

        BodyApplication.add(viewPaymentDetail, "card3");

        appRefundList.setBackground(new java.awt.Color(255, 255, 255));
        appRefundList.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane12.setBackground(new java.awt.Color(255, 255, 255));

        refundTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Type", "Size", "Monthly rent", "Deposit", "Status", "View"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        refundTable.setAlignmentX(0.0F);
        refundTable.setAlignmentY(0.0F);
        refundTable.setGridColor(new java.awt.Color(236, 236, 236));
        refundTable.setName(""); // NOI18N
        refundTable.setRequestFocusEnabled(false);
        refundTable.setRowHeight(40);
        refundTable.setSelectionBackground(new java.awt.Color(232, 57, 95));
        refundTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        refundTable.setShowHorizontalLines(true);
        refundTable.setShowVerticalLines(true);
        refundTable.getTableHeader().setResizingAllowed(false);
        refundTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane12.setViewportView(refundTable);

        appRefundList.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 830, 270));

        refundSearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refundSearchFieldActionPerformed(evt);
            }
        });
        refundSearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                refundSearchFieldKeyReleased(evt);
            }
        });
        appRefundList.add(refundSearchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 190, 30));

        paymentRefundSearchButton.setText("Search");
        paymentRefundSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentRefundSearchButtonActionPerformed(evt);
            }
        });
        appRefundList.add(paymentRefundSearchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, -1, 30));

        refundFillterButton.setText("Filter");
        refundFillterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refundFillterButtonActionPerformed(evt);
            }
        });
        appRefundList.add(refundFillterButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, -1, -1));

        PanelDate2.setOpaque(false);
        PanelDate2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        refundMinYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2023", "2024", "2025", " " }));
        PanelDate2.add(refundMinYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jLabel110.setText("FROM:");
        PanelDate2.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        refundMinMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        PanelDate2.add(refundMinMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        jLabel112.setText(" -");
        PanelDate2.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 20, 20));

        refundMaxYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2023", "2024", "2025", " ", " " }));
        refundMaxYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refundMaxYearActionPerformed(evt);
            }
        });
        PanelDate2.add(refundMaxYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        jLabel113.setText("   TO:");
        PanelDate2.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, 20));

        refundMaxMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        PanelDate2.add(refundMaxMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, -1));

        jLabel115.setText("_");
        PanelDate2.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 20, 20));

        appRefundList.add(PanelDate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 440, 50));

        viewrefundBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/arrow.png"))); // NOI18N
        viewrefundBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewrefundBackMouseClicked(evt);
            }
        });
        appRefundList.add(viewrefundBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        refundRestButton.setText("Reset");
        refundRestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refundRestButtonActionPerformed(evt);
            }
        });
        appRefundList.add(refundRestButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 80, -1, -1));

        BodyApplication.add(appRefundList, "card4");

        Application.add(BodyApplication, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 830, 390));

        Parent.add(Application, "card4");

        Records.setBackground(new java.awt.Color(255, 255, 255));
        Records.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header3.setBackground(new java.awt.Color(25, 118, 185));

        jLabel59.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("X");
        jLabel59.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel59.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel59MouseClicked(evt);
            }
        });

        jLabel60.setFont(new java.awt.Font("Malgun Gothic", 0, 30)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setText("Records");

        javax.swing.GroupLayout Header3Layout = new javax.swing.GroupLayout(Header3);
        Header3.setLayout(Header3Layout);
        Header3Layout.setHorizontalGroup(
            Header3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Header3Layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        Header3Layout.setVerticalGroup(
            Header3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Header3Layout.createSequentialGroup()
                .addGroup(Header3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        Records.add(Header3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, -1));

        Header4.setBackground(new java.awt.Color(25, 118, 185));

        javax.swing.GroupLayout Header4Layout = new javax.swing.GroupLayout(Header4);
        Header4.setLayout(Header4Layout);
        Header4Layout.setHorizontalGroup(
            Header4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
        );
        Header4Layout.setVerticalGroup(
            Header4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        Records.add(Header4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, -1, 50));

        DisplayRecord.setBackground(new java.awt.Color(255, 255, 255));
        DisplayRecord.setLayout(new java.awt.CardLayout());

        SelelctRecord.setBackground(new java.awt.Color(255, 255, 255));
        SelelctRecord.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(25, 118, 185));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/fotor_2023-5-12_13_58_52.png"))); // NOI18N
        SelelctRecord.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 200, 180));

        jLabel61.setBackground(new java.awt.Color(25, 118, 185));
        jLabel61.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(25, 118, 185));
        jLabel61.setText("Application History");
        SelelctRecord.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 180, -1));

        jLabel62.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(25, 118, 185));
        jLabel62.setText("Payment  History");
        SelelctRecord.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 220, -1, -1));

        loginRecord.setBackground(new java.awt.Color(25, 118, 221));
        loginRecord.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        loginRecord.setForeground(new java.awt.Color(255, 255, 255));
        loginRecord.setText("View  Record");
        loginRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginRecordActionPerformed(evt);
            }
        });
        SelelctRecord.add(loginRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 220, 40));

        paymentRecord.setBackground(new java.awt.Color(25, 118, 221));
        paymentRecord.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        paymentRecord.setForeground(new java.awt.Color(255, 255, 255));
        paymentRecord.setText("View  Record");
        paymentRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentRecordActionPerformed(evt);
            }
        });
        SelelctRecord.add(paymentRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 260, 220, 40));

        applicationRecord.setBackground(new java.awt.Color(25, 118, 221));
        applicationRecord.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        applicationRecord.setForeground(new java.awt.Color(255, 255, 255));
        applicationRecord.setText("View  Record");
        applicationRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applicationRecordActionPerformed(evt);
            }
        });
        SelelctRecord.add(applicationRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 220, 40));

        jLabel64.setBackground(new java.awt.Color(25, 118, 185));
        jLabel64.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(25, 118, 185));
        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/fotor_2023-5-12_14_0_9.png"))); // NOI18N
        SelelctRecord.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, -1, 177));

        jLabel63.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(25, 118, 185));
        SelelctRecord.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 168, -1, -1));

        jLabel65.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(25, 118, 185));
        jLabel65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/fotor_2023-5-12_14_0_51.png"))); // NOI18N
        SelelctRecord.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 164, 167));

        jLabel66.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(25, 118, 185));
        jLabel66.setText("Login History");
        SelelctRecord.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, -1, -1));

        DisplayRecord.add(SelelctRecord, "card2");

        viewPaymentRecord.setBackground(new java.awt.Color(255, 255, 255));
        viewPaymentRecord.setOpaque(false);
        viewPaymentRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewPaymentRecordMouseClicked(evt);
            }
        });
        viewPaymentRecord.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));

        PaymetRecordTabel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        PaymetRecordTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Type", "Size", "Monthly rent", "Deposit", "Status", "View"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        PaymetRecordTabel.setAlignmentX(0.0F);
        PaymetRecordTabel.setAlignmentY(0.0F);
        PaymetRecordTabel.setGridColor(new java.awt.Color(236, 236, 236));
        PaymetRecordTabel.setName(""); // NOI18N
        PaymetRecordTabel.setOpaque(false);
        PaymetRecordTabel.setRequestFocusEnabled(false);
        PaymetRecordTabel.setRowHeight(30);
        PaymetRecordTabel.setSelectionBackground(new java.awt.Color(232, 57, 95));
        PaymetRecordTabel.setSelectionForeground(new java.awt.Color(255, 255, 255));
        PaymetRecordTabel.setShowHorizontalLines(true);
        PaymetRecordTabel.setShowVerticalLines(true);
        PaymetRecordTabel.getTableHeader().setResizingAllowed(false);
        PaymetRecordTabel.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(PaymetRecordTabel);

        viewPaymentRecord.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 830, 260));

        paymentRecordSearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentRecordSearchFieldActionPerformed(evt);
            }
        });
        paymentRecordSearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                paymentRecordSearchFieldKeyReleased(evt);
            }
        });
        viewPaymentRecord.add(paymentRecordSearchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 190, 30));

        paymentFillterButton.setText("Filter");
        paymentFillterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentFillterButtonActionPerformed(evt);
            }
        });
        viewPaymentRecord.add(paymentFillterButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, -1, -1));

        paymentrRecordSearchButton.setText("Search");
        paymentrRecordSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentrRecordSearchButtonActionPerformed(evt);
            }
        });
        viewPaymentRecord.add(paymentrRecordSearchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, -1, 30));

        PanelDate.setOpaque(false);
        PanelDate.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        paymentMinYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2023", "2024", "2025", " " }));
        PanelDate.add(paymentMinYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jLabel71.setText("FROM:");
        PanelDate.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        paymentMinMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        PanelDate.add(paymentMinMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        jLabel70.setText(" -");
        PanelDate.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 20, 20));

        paymentMaxYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2023", "2024", "2025", " ", " " }));
        paymentMaxYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentMaxYearActionPerformed(evt);
            }
        });
        PanelDate.add(paymentMaxYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        jLabel69.setText("   TO:");
        PanelDate.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, 20));

        paymentMaxMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        PanelDate.add(paymentMaxMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, -1));

        jLabel67.setText("_");
        PanelDate.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 20, 20));

        viewPaymentRecord.add(PanelDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 440, 50));

        paymentRecordBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/arrow.png"))); // NOI18N
        paymentRecordBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paymentRecordBackMouseClicked(evt);
            }
        });
        viewPaymentRecord.add(paymentRecordBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, -1));

        DisplayRecord.add(viewPaymentRecord, "card3");

        viewApplicationRecord1.setBackground(new java.awt.Color(255, 255, 255));
        viewApplicationRecord1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        applicationRecordSearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applicationRecordSearchFieldActionPerformed(evt);
            }
        });
        applicationRecordSearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                applicationRecordSearchFieldKeyReleased(evt);
            }
        });
        viewApplicationRecord1.add(applicationRecordSearchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 190, 30));

        applicationRecordSearchButton.setText("Search");
        applicationRecordSearchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                applicationRecordSearchButtonMouseClicked(evt);
            }
        });
        applicationRecordSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applicationRecordSearchButtonActionPerformed(evt);
            }
        });
        viewApplicationRecord1.add(applicationRecordSearchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, -1, 30));

        applicationStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "accepted ", "rejected", "terminated", "cancelled" }));
        viewApplicationRecord1.add(applicationStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, 250, -1));

        applicationFillterButton.setText("Filter");
        applicationFillterButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                applicationFillterButtonMouseClicked(evt);
            }
        });
        applicationFillterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applicationFillterButtonActionPerformed(evt);
            }
        });
        viewApplicationRecord1.add(applicationFillterButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, -1, -1));

        lbStatus6.setText("Status");
        viewApplicationRecord1.add(lbStatus6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, -1, -1));

        jScrollPane6.setBackground(new java.awt.Color(255, 255, 255));

        applicationRecordTable.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        applicationRecordTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Type", "Size", "Monthly rent", "Deposit", "Status", "View"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        applicationRecordTable.setAlignmentX(0.0F);
        applicationRecordTable.setAlignmentY(0.0F);
        applicationRecordTable.setGridColor(new java.awt.Color(236, 236, 236));
        applicationRecordTable.setName(""); // NOI18N
        applicationRecordTable.setOpaque(false);
        applicationRecordTable.setRequestFocusEnabled(false);
        applicationRecordTable.setRowHeight(30);
        applicationRecordTable.setSelectionBackground(new java.awt.Color(232, 57, 95));
        applicationRecordTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        applicationRecordTable.setShowHorizontalLines(true);
        applicationRecordTable.setShowVerticalLines(true);
        applicationRecordTable.getTableHeader().setResizingAllowed(false);
        applicationRecordTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(applicationRecordTable);

        viewApplicationRecord1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 830, 260));

        viewApplicationRecord.setOpaque(false);
        viewApplicationRecord.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        applicationMinYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2023", "2024", "2025", " " }));
        viewApplicationRecord.add(applicationMinYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jLabel79.setText("FROM:");
        viewApplicationRecord.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        applicationMinMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        viewApplicationRecord.add(applicationMinMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        jLabel80.setText(" -");
        viewApplicationRecord.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 20, 20));

        applicationMaxYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2023", "2024", "2025", " ", " " }));
        applicationMaxYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applicationMaxYearActionPerformed(evt);
            }
        });
        viewApplicationRecord.add(applicationMaxYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        jLabel81.setText("   TO:");
        viewApplicationRecord.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, 20));

        applicationMaxMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        viewApplicationRecord.add(applicationMaxMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, -1));

        jLabel82.setText("_");
        viewApplicationRecord.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 20, 20));

        viewApplicationRecord1.add(viewApplicationRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 440, 50));

        viewApplicationRecord2.setBackground(new java.awt.Color(255, 255, 255));
        viewApplicationRecord2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        recordSearchField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recordSearchField4ActionPerformed(evt);
            }
        });
        recordSearchField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                recordSearchField4KeyReleased(evt);
            }
        });
        viewApplicationRecord2.add(recordSearchField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 190, 30));

        recordFilterButton4.setText("Search");
        recordFilterButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recordFilterButton4ActionPerformed(evt);
            }
        });
        viewApplicationRecord2.add(recordFilterButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, -1, 30));

        cmbStatus7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Pending", "Accepted ", "Rejected", "Terminated" }));
        viewApplicationRecord2.add(cmbStatus7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, 250, -1));

        RecordFillterButton4.setText("Filter");
        RecordFillterButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecordFillterButton4ActionPerformed(evt);
            }
        });
        viewApplicationRecord2.add(RecordFillterButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, -1, -1));

        lbStatus7.setText("Status");
        viewApplicationRecord2.add(lbStatus7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, -1, -1));

        jScrollPane7.setBackground(new java.awt.Color(255, 255, 255));

        applicationRecordTable1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        applicationRecordTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Type", "Size", "Monthly rent", "Deposit", "Status", "View"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        applicationRecordTable1.setAlignmentX(0.0F);
        applicationRecordTable1.setAlignmentY(0.0F);
        applicationRecordTable1.setGridColor(new java.awt.Color(236, 236, 236));
        applicationRecordTable1.setName(""); // NOI18N
        applicationRecordTable1.setOpaque(false);
        applicationRecordTable1.setRequestFocusEnabled(false);
        applicationRecordTable1.setRowHeight(30);
        applicationRecordTable1.setSelectionBackground(new java.awt.Color(232, 57, 95));
        applicationRecordTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        applicationRecordTable1.setShowHorizontalLines(true);
        applicationRecordTable1.setShowVerticalLines(true);
        applicationRecordTable1.getTableHeader().setResizingAllowed(false);
        applicationRecordTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(applicationRecordTable1);

        viewApplicationRecord2.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 830, 260));

        viewApplicationRecord3.setOpaque(false);
        viewApplicationRecord3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        StartYear5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2023", "2024", "2025", " " }));
        viewApplicationRecord3.add(StartYear5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jLabel83.setText("FROM:");
        viewApplicationRecord3.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        StartMonth4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        viewApplicationRecord3.add(StartMonth4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        jLabel84.setText(" -");
        viewApplicationRecord3.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 20, 20));

        EndYear4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2023", "2024", "2025", " ", " " }));
        EndYear4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EndYear4ActionPerformed(evt);
            }
        });
        viewApplicationRecord3.add(EndYear4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        jLabel85.setText("   TO:");
        viewApplicationRecord3.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, 20));

        EndMonth4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        viewApplicationRecord3.add(EndMonth4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, -1));

        jLabel86.setText("_");
        viewApplicationRecord3.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 20, 20));

        viewApplicationRecord2.add(viewApplicationRecord3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 440, 50));

        applicationBackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/arrow.png"))); // NOI18N
        applicationBackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                applicationBackButtonMouseClicked(evt);
            }
        });
        viewApplicationRecord2.add(applicationBackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        viewApplicationRecord1.add(viewApplicationRecord2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        DisplayRecord.add(viewApplicationRecord1, "card6");

        viewLoginRecord.setBackground(new java.awt.Color(255, 255, 255));

        loginRecordSearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginRecordSearchFieldActionPerformed(evt);
            }
        });
        loginRecordSearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                loginRecordSearchFieldKeyReleased(evt);
            }
        });

        loginRecordSearchButton1.setText("Search");
        loginRecordSearchButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginRecordSearchButton1MouseClicked(evt);
            }
        });
        loginRecordSearchButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginRecordSearchButton1ActionPerformed(evt);
            }
        });

        loginRecordBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/arrow.png"))); // NOI18N
        loginRecordBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginRecordBackMouseClicked(evt);
            }
        });

        PanelDate1.setOpaque(false);
        PanelDate1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginMinYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2023", "2024", "2025", " " }));
        PanelDate1.add(loginMinYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jLabel72.setText("FROM:");
        PanelDate1.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        loginMinMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        PanelDate1.add(loginMinMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        jLabel73.setText(" -");
        PanelDate1.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 20, 20));

        loginMaxYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2023", "2024", "2025", " ", " " }));
        loginMaxYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginMaxYearActionPerformed(evt);
            }
        });
        PanelDate1.add(loginMaxYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        jLabel74.setText("   TO:");
        PanelDate1.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, 20));

        loginMaxMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        PanelDate1.add(loginMaxMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, -1));

        jLabel68.setText("_");
        PanelDate1.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 20, 20));

        loginFillterButton.setText("Filter");
        loginFillterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginFillterButtonActionPerformed(evt);
            }
        });

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));

        loginRecordTabel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        loginRecordTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Type", "Size", "Monthly rent", "Deposit", "Status", "View"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        loginRecordTabel.setAlignmentX(0.0F);
        loginRecordTabel.setAlignmentY(0.0F);
        loginRecordTabel.setGridColor(new java.awt.Color(236, 236, 236));
        loginRecordTabel.setName(""); // NOI18N
        loginRecordTabel.setOpaque(false);
        loginRecordTabel.setRequestFocusEnabled(false);
        loginRecordTabel.setRowHeight(30);
        loginRecordTabel.setSelectionBackground(new java.awt.Color(232, 57, 95));
        loginRecordTabel.setSelectionForeground(new java.awt.Color(255, 255, 255));
        loginRecordTabel.setShowHorizontalLines(true);
        loginRecordTabel.setShowVerticalLines(true);
        loginRecordTabel.getTableHeader().setResizingAllowed(false);
        loginRecordTabel.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(loginRecordTabel);

        javax.swing.GroupLayout viewLoginRecordLayout = new javax.swing.GroupLayout(viewLoginRecord);
        viewLoginRecord.setLayout(viewLoginRecordLayout);
        viewLoginRecordLayout.setHorizontalGroup(
            viewLoginRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewLoginRecordLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(loginRecordBack, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(779, Short.MAX_VALUE))
            .addGroup(viewLoginRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(viewLoginRecordLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(viewLoginRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(viewLoginRecordLayout.createSequentialGroup()
                            .addGap(60, 60, 60)
                            .addComponent(loginRecordSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(loginRecordSearchButton1)
                            .addGap(48, 48, 48)
                            .addComponent(PanelDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(viewLoginRecordLayout.createSequentialGroup()
                            .addGap(600, 600, 600)
                            .addComponent(loginFillterButton))
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        viewLoginRecordLayout.setVerticalGroup(
            viewLoginRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewLoginRecordLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginRecordBack)
                .addContainerGap(340, Short.MAX_VALUE))
            .addGroup(viewLoginRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(viewLoginRecordLayout.createSequentialGroup()
                    .addContainerGap(17, Short.MAX_VALUE)
                    .addGroup(viewLoginRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(loginRecordSearchField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(loginRecordSearchButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PanelDate1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addComponent(loginFillterButton)
                    .addGap(7, 7, 7)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 3, Short.MAX_VALUE)))
        );

        DisplayRecord.add(viewLoginRecord, "card5");

        Records.add(DisplayRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 830, 370));

        Parent.add(Records, "card5");

        getContentPane().add(Parent, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, -4, 830, 474));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void btnProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProfileMouseClicked
        // TODO add your handling code here:
        new Utility(Parent, Profile).displayPanel();

    }//GEN-LAST:event_btnProfileMouseClicked

    private void btnPropertiesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPropertiesMouseClicked
        // TODO add your handling code here:
        new Utility(Parent, Properties).displayPanel();
 

    }//GEN-LAST:event_btnPropertiesMouseClicked

    private void btnApplicationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnApplicationMouseClicked
        // TODO add your handling code here:
         new Utility(Parent, Records).displayPanel();
    }//GEN-LAST:event_btnApplicationMouseClicked

    private void btnRecordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRecordMouseClicked
        // TODO add your handling code here:
        if( (new  Application().displayApplicationDetailsPanel(viewApplicationInfo, st.getUserName()))) { 
        appApplicationId.setText("application id");
        appStatus.setText("status");
         appDuration.setText("duration");
        appEmail.setText("email");
        appMonthly.setText("monthly rent");
        appName.setText("name");
        appRoomId.setText("roomid");
        new  Application().displayApplicationDetailsPanel(viewApplicationInfo, st.getUserName());
        new Utility(Parent, Application).displayPanel();

        }else { 
        appApplicationId.setText("application id");
        appStatus.setText("status");
        appDuration.setText("duration");
        appEmail.setText("email");
        appMonthly.setText("monthly rent");
        appName.setText("name");
        appRoomId.setText("roomid");
             new  Message("Apologies, you haven't made any applications yet", fileHandling.messageIcon("warning")).setVisible(true);

        }
    }//GEN-LAST:event_btnRecordMouseClicked

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        // TODO add your handling code here:
        new login().logout(this);
    }//GEN-LAST:event_btnLogoutMouseClicked

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked
        // TODO add your handling code here:
        new Utility(Body, SelectProperite).displayPanel();

 
    }//GEN-LAST:event_jLabel30MouseClicked
 

      
    private void singleRoomSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singleRoomSearchButtonActionPerformed
        // TODO add your handling code here:
        searchInTable(singleRoomTable,singleRoomSearchField.getText());
    }//GEN-LAST:event_singleRoomSearchButtonActionPerformed

    private void singleMaxPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singleMaxPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_singleMaxPriceActionPerformed

    private void singleMinPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singleMinPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_singleMinPriceActionPerformed
  
    //unit  section
    private void btnUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnitActionPerformed
       try {
        new Unit().displayHostal(unitRoomTable, st.getRole(),st.getUserName(),  Body,viewRoomDetails); 
        new  Utility(Body,viewUnit).displayPanel(); 
        currentRoom = viewUnit;
           } catch(Exception e) { 
            new  Message("Oops, Somthing Went  Wrong  Please  Try Again Later", fileHandling.messageIcon("error")).setVisible(true);
            new  Utility(Body,SelectProperite).displayPanel();
           }

    }//GEN-LAST:event_btnUnitActionPerformed

    //Master section
    private void btnMasterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasterActionPerformed
        try {
        new Master().displayHostal(masterRoomTable, st.getRole(), st.getUserName(), Body, viewRoomDetails);
        new Utility(Body, viewMasterRoom).displayPanel();
        } catch(Exception e) { 
            new  Message("Oops, Somthing Went  Wrong  Please  Try Again Later", fileHandling.messageIcon("error")).setVisible(true);
            new  Utility(Body,SelectProperite).displayPanel();
        }
    }//GEN-LAST:event_btnMasterActionPerformed

    private void btnSingleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSingleActionPerformed
        // TODO add your handling code here:
        try{ 
        new Single().displayHostal(singleRoomTable, st.getRole(), st.getUserName(),  Body,viewRoomDetails); 
        new Utility(Body, ViewSingleRoom).displayPanel();
        currentRoom = ViewSingleRoom;
        } catch(Exception e) { 
            new  Message("Oops, Somthing Went  Wrong  Please  Try Again Later", fileHandling.messageIcon("error")).setVisible(true);
            new  Utility(Body,SelectProperite).displayPanel();
        }

    }//GEN-LAST:event_btnSingleActionPerformed

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel15MouseClicked

    private void btnDoubleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoubleActionPerformed

        try {
         new DoubleRoom().displayHostal(doubleRoomTable, st.getRole(), st.getUserName(),  Body,viewRoomDetails); 
         new Utility(Body, viewDoubleRoom).displayPanel();
         currentRoom = viewDoubleRoom;
        } catch(Exception e) { 
            new  Message("Oops, Somthing Went  Wrong  Please  Try Again Later", fileHandling.messageIcon("error")).setVisible(true);
            new  Utility(Body,SelectProperite).displayPanel();
        }
      
    }//GEN-LAST:event_btnDoubleActionPerformed

    private void singleRoomSearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singleRoomSearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_singleRoomSearchFieldActionPerformed

    private void singleRoomSearchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_singleRoomSearchFieldKeyReleased
        // TODO add your handling code here:
          if (singleRoomSearchField.getText().isEmpty())  {
              searchInTable(singleRoomTable,"");
          }
        
    }//GEN-LAST:event_singleRoomSearchFieldKeyReleased

    private void singleRoomFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singleRoomFilterActionPerformed
        // TODO add your handling code here:
   
       double minPrice = Double.parseDouble(singleMinPrice.getText().toString()); 
       double maxPrice = Double.parseDouble(singleMaxPrice.getText().toString()); 
       String gender = (singleRadioMale.isSelected())? singleRadioMale.getText().toString().toLowerCase(): (masterRadioFemale.isSelected())? masterRadioFemale.getText().toString().toLowerCase():"";
       String bathType = singleBathroomType.getSelectedItem().toString();
        try {       
        filterRoomTable(singleRoomTable, minPrice, maxPrice,4 ,10, bathType,gender);
        } catch(Exception e) { 
            new Message("Oops, Somthing Went  Wrong  Please  Try Again Later", fileHandling.messageIcon("error")).setVisible(true);
        }
      
    
    }//GEN-LAST:event_singleRoomFilterActionPerformed
         
     
    private void singleRoomResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singleRoomResetActionPerformed
        // TODO add your handling code here:
        reset(singleRoomTable, singleRoomSearchField);
    }//GEN-LAST:event_singleRoomResetActionPerformed

    private void singleRadioMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singleRadioMaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_singleRadioMaleActionPerformed

    private void jLabel37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseClicked
        // TODO add your handling code here:
         System.exit(0);
    }//GEN-LAST:event_jLabel37MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
     
        Utility ds = new  Utility(Body, makeApplication); 
         ds.displayPanel();
         
         ds.setId(propRoomId.getText().toString());
         ds.setFileName(fileHandling.HostelFile);
         ds.displayOnPanel(makeApplication);
         
         ds.setId(st.getUserName());
         ds.setFileName(fileHandling.UserFile);
         ds.displayOnPanel(makeApplication);
         
        propType.setText("type");
        propRoomId.setText("roomid");
        propLocation.setText("location");
        propStatus.setText("status");
        propSize.setText("size");
        propGender.setText("gender");
        propMonthly.setText("monthly rent");
        propDeposit.setText("deposit");
        propDescription.setText("description");
        /// 
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel44MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel44MouseClicked
           // TODO add your handling code here:
        Utility ds = new  Utility(Body,currentRoom); 
        propType.setText("type");
        propLocation.setText("location");
        propStatus.setText("status");
        propSize.setText("size");
        propGender.setText("gender");
        propMonthly.setText("monthly rent");
        propDeposit.setText("deposit");
        propDescription.setText("description");
        ds.displayPanel();
    }//GEN-LAST:event_jLabel44MouseClicked

    private void radioNoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioNoneActionPerformed

    private void jLabel59MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel59MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel59MouseClicked
    
    
    private void loginRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginRecordActionPerformed
        try { 
            new login().displayLoginDatails(loginRecordTabel, st.getRole(), st.getUserName(), DisplayRecord, viewLoginRecord);
            new Utility(DisplayRecord, viewLoginRecord).displayPanel();
        }catch(Exception e) { 
            new  Message("Oops, Somthing Went  Wrong  Please  Try Again Later", fileHandling.messageIcon("error")).setVisible(true);
            new  Utility(DisplayRecord,SelelctRecord).displayPanel();
        } 
    }//GEN-LAST:event_loginRecordActionPerformed

    private void paymentRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentRecordActionPerformed

        try{ 
            new Payment().displayPaymentDetailRecord(PaymetRecordTabel, st.getUserName(),st.getRole(),"record",DisplayRecord, viewPaymentRecord);
            new  Utility(DisplayRecord,viewPaymentRecord).displayPanel();
        }catch(Exception e) { 
            new  Message("Oops, Somthing Went  Wrong  Please  Try Again Later", fileHandling.messageIcon("error")).setVisible(true);
            new  Utility(DisplayRecord,SelelctRecord).displayPanel();
        }
        
        ////////////////////////////////////////////////////////////////////////////////////////////
        
    }//GEN-LAST:event_paymentRecordActionPerformed

    private void applicationRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applicationRecordActionPerformed
        // TODO add your handling code here:
        try{ 
        new  Application().displayApplicationDetails(applicationRecordTable, st.getUserName(),st.getRole(), DisplayRecord, viewApplicationRecord1);
        new  Utility(DisplayRecord,viewApplicationRecord1).displayPanel();
        
        }catch(Exception e) { 
            new  Message("Oops, Somthing Went  Wrong  Please  Try Again Later", fileHandling.messageIcon("error")).setVisible(true);
            new  Utility(DisplayRecord,SelelctRecord).displayPanel();
        }
        
    }//GEN-LAST:event_applicationRecordActionPerformed

    private void paymentrRecordSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentrRecordSearchButtonActionPerformed
        // TODO add your handling code here:adsasds
        /////////////////////////////////////////////////////////////////////////////////////////////////////
        searchInTable(PaymetRecordTabel,paymentRecordSearchField.getText());
    }//GEN-LAST:event_paymentrRecordSearchButtonActionPerformed

    private void paymentMaxYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentMaxYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paymentMaxYearActionPerformed

    private void paymentFillterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentFillterButtonActionPerformed
        // TODO add your handling code here:
        int minYear =   Integer.parseInt(paymentMinYear.getSelectedItem().toString());
        int minMonth = Integer.parseInt(paymentMinMonth.getSelectedItem().toString());
        int maxYear=  Integer.parseInt(paymentMaxYear.getSelectedItem().toString());
        int maxMonth=  Integer.parseInt(paymentMaxMonth.getSelectedItem().toString());

        try {       
            filterTable(PaymetRecordTabel, minYear, maxYear, minMonth, maxMonth, 6, 7, 9, "");
        } catch(Exception e) { 
            new Message("Oops, Somthing Went  Wrong  Please  Try Again Later", fileHandling.messageIcon("error")).setVisible(true);
        }
        
    }//GEN-LAST:event_paymentFillterButtonActionPerformed

    private void paymentRecordSearchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paymentRecordSearchFieldKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_paymentRecordSearchFieldKeyReleased

    private void paymentRecordSearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentRecordSearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paymentRecordSearchFieldActionPerformed

    private void paymentRecordBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentRecordBackMouseClicked
        // TODO add your handling code here:
       new  Utility(DisplayRecord,SelelctRecord).displayPanel(); 
    }//GEN-LAST:event_paymentRecordBackMouseClicked

   

    private void ViewSingleRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewSingleRoomMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ViewSingleRoomMouseClicked

    private void applicationRecordSearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applicationRecordSearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_applicationRecordSearchFieldActionPerformed

    private void applicationRecordSearchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_applicationRecordSearchFieldKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_applicationRecordSearchFieldKeyReleased

    private void applicationRecordSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applicationRecordSearchButtonActionPerformed
        // TODO add your handling code here:zdsasd
        searchInTable(applicationRecordTable, applicationRecordSearchField.getText().toString());
    }//GEN-LAST:event_applicationRecordSearchButtonActionPerformed

    private void applicationFillterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applicationFillterButtonActionPerformed
        // TODO add your handling code here:
        int minYear =   Integer.parseInt(applicationMinYear.getSelectedItem().toString());
        int minMonth = Integer.parseInt(applicationMinMonth.getSelectedItem().toString());
        int maxYear=  Integer.parseInt(applicationMaxYear.getSelectedItem().toString());
        int maxMonth=  Integer.parseInt(applicationMaxMonth.getSelectedItem().toString());
        String status = applicationStatus.getSelectedItem().toString();
        try {       
            filterTable(applicationRecordTable, minYear, maxYear, minMonth, maxMonth, 4, 5, 12, status);

        } catch(Exception e) { 
            new Message("Oops, Somthing Went  Wrong  Please  Try Again Later", fileHandling.messageIcon("error")).setVisible(true);
        }
        

    }//GEN-LAST:event_applicationFillterButtonActionPerformed

    private void recordSearchField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recordSearchField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_recordSearchField4ActionPerformed

    private void recordSearchField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_recordSearchField4KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_recordSearchField4KeyReleased

    private void recordFilterButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recordFilterButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_recordFilterButton4ActionPerformed

    private void RecordFillterButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecordFillterButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RecordFillterButton4ActionPerformed

    private void EndYear4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EndYear4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EndYear4ActionPerformed

    private void applicationMaxYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applicationMaxYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_applicationMaxYearActionPerformed

    private void applicationRecordSearchButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_applicationRecordSearchButtonMouseClicked
        // TODO add your handling code here:
        searchInTable(applicationRecordTable,applicationRecordSearchField.getText().toString());
    }//GEN-LAST:event_applicationRecordSearchButtonMouseClicked

    private void viewPaymentRecordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewPaymentRecordMouseClicked
        // TODO add your handling code here:
    
        searchInTable(PaymetRecordTabel,paymentRecordSearchField.getText().toString());
    }//GEN-LAST:event_viewPaymentRecordMouseClicked

    private void applicationBackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_applicationBackButtonMouseClicked
          // TODO add your handling code here:
          new  Utility(DisplayRecord, SelelctRecord).displayPanel();
    }//GEN-LAST:event_applicationBackButtonMouseClicked

    private void loginRecordSearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginRecordSearchFieldActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_loginRecordSearchFieldActionPerformed

    private void loginRecordSearchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginRecordSearchFieldKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_loginRecordSearchFieldKeyReleased

    private void loginRecordSearchButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginRecordSearchButton1ActionPerformed
        // TODO add your handling code here:
         searchInTable(loginRecordTabel,loginRecordSearchField.getText().toString());
    }//GEN-LAST:event_loginRecordSearchButton1ActionPerformed

    private void loginRecordBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginRecordBackMouseClicked
        // TODO add your handling code here:
        new Utility(DisplayRecord, SelelctRecord).displayPanel();
    }//GEN-LAST:event_loginRecordBackMouseClicked

    private void loginMaxYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginMaxYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginMaxYearActionPerformed

    private void loginFillterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginFillterButtonActionPerformed
        // TODO add your handling code here:
        int minYear =   Integer.parseInt(loginMinYear.getSelectedItem().toString());
        int minMonth = Integer.parseInt(loginMinMonth.getSelectedItem().toString());
        int maxYear=  Integer.parseInt(loginMaxYear.getSelectedItem().toString());
        int maxMonth=  Integer.parseInt(loginMaxMonth.getSelectedItem().toString());
        try {       
            filterTable(loginRecordTabel, minYear, maxYear, minMonth, maxMonth, 5, 6, 9);
        } catch(Exception e) { 
            new Message("Oops, Somthing Went  Wrong  Please  Try Again Later", fileHandling.messageIcon("error")).setVisible(true);
        }

    }//GEN-LAST:event_loginFillterButtonActionPerformed

    private void loginRecordSearchButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginRecordSearchButton1MouseClicked
        // TODO add your handling code here:
  
    }//GEN-LAST:event_loginRecordSearchButton1MouseClicked

    private void applicationFillterButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_applicationFillterButtonMouseClicked
        // TODO add your handling code here:
        int minYear =   Integer.parseInt(applicationMinYear.getSelectedItem().toString());
        int minMonth = Integer.parseInt(applicationMinMonth.getSelectedItem().toString());
        int maxYear=  Integer.parseInt(applicationMaxYear.getSelectedItem().toString());
        int maxMonth=  Integer.parseInt(applicationMaxMonth.getSelectedItem().toString());
        String status = applicationStatus.getSelectedItem().toString();
        try {
            filterTable(applicationRecordTable, minYear, maxYear, minMonth, maxMonth, 3, 4, 11, status);
        } catch (Exception e) {
            new Message("Oops, Somthing Went  Wrong  Please  Try Again Later", fileHandling.messageIcon("error")).setVisible(true);
        }
    }//GEN-LAST:event_applicationFillterButtonMouseClicked

    private void masterBackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterBackButtonMouseClicked
        // TODO add your handling code here:
        new  Utility(Body, SelectProperite).displayPanel();
    }//GEN-LAST:event_masterBackButtonMouseClicked

    private void masterRoomSearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masterRoomSearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_masterRoomSearchFieldActionPerformed

    private void masterRoomSearchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_masterRoomSearchFieldKeyReleased
        // TODO add your handling code here:
              if (masterRoomSearchField.getText().isEmpty())  {
              searchInTable(masterRoomTable,"");
          }
    }//GEN-LAST:event_masterRoomSearchFieldKeyReleased

    private void mastersRoomSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mastersRoomSearchButtonActionPerformed
        // TODO add your handling code here: 
          searchInTable(masterRoomTable,masterRoomSearchField.getText().toString());
    }//GEN-LAST:event_mastersRoomSearchButtonActionPerformed

    private void masterRadioMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masterRadioMaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_masterRadioMaleActionPerformed

    private void radioNone1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNone1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioNone1ActionPerformed

    private void masterRoomMinPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masterRoomMinPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_masterRoomMinPriceActionPerformed

    private void masterRoomMaxPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masterRoomMaxPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_masterRoomMaxPriceActionPerformed

    private void masterRoomFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masterRoomFilterActionPerformed
       // TODO add your handling code here:
       
       double minPrice = Double.parseDouble(masterRoomMinPrice.getText().toString()); 
       double maxPrice = Double.parseDouble(masterRoomMaxPrice.getText().toString()); 
       String gender = (masterRadioMale.isSelected())? masterRadioMale.getText().toString().toLowerCase(): (masterRadioFemale.isSelected())? masterRadioFemale.getText().toString().toLowerCase():"";
         try {    
             filterRoomTable(masterRoomTable, minPrice, maxPrice, 4, 9, gender);
        } catch(Exception e) { 
            new Message("Oops, Somthing Went  Wrong  Please  Try Again Later", fileHandling.messageIcon("error")).setVisible(true);
        }

       //filter
       
    }//GEN-LAST:event_masterRoomFilterActionPerformed

    private void masterRoomResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masterRoomResetActionPerformed
        // TODO add your handling code here:
         reset(masterRoomTable, masterRoomSearchField);
    }//GEN-LAST:event_masterRoomResetActionPerformed

    private void unitRoomSearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unitRoomSearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unitRoomSearchFieldActionPerformed

    private void unitRoomSearchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_unitRoomSearchFieldKeyReleased
        // TODO add your handling code here:
              if (unitRoomSearchField.getText().isEmpty())  {
              searchInTable(unitRoomTable,"");
          }
    }//GEN-LAST:event_unitRoomSearchFieldKeyReleased

    private void unitRoomSearchButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unitRoomSearchButton1ActionPerformed
        // TODO add your handling code here:
        searchInTable(unitRoomTable,unitRoomSearchField.getText().toString());
    }//GEN-LAST:event_unitRoomSearchButton1ActionPerformed

    private void unitRadioMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unitRadioMaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unitRadioMaleActionPerformed

    private void radioNone2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNone2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioNone2ActionPerformed

    private void unitRoomMinPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unitRoomMinPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unitRoomMinPriceActionPerformed

    private void unitRoomMaxPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unitRoomMaxPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unitRoomMaxPriceActionPerformed

    private void unitRoomResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unitRoomResetActionPerformed
        // TODO add your handling code here:
         reset(unitRoomTable, unitRoomSearchField);
    }//GEN-LAST:event_unitRoomResetActionPerformed

    private void unitRoomFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unitRoomFilterActionPerformed
        // TODO add your handling code here:
       double minPrice = Double.parseDouble(unitRoomMinPrice.getText().toString()); 
       double maxPrice = Double.parseDouble(unitRoomMaxPrice.getText().toString()); 
       String unitRooms =  unitRoomsNumber.getSelectedItem().toString();
       String unitBathrooms = unitBathroomsNumber.getSelectedItem().toString();
       
         try { 
             String gender = (unitRadioMale.isSelected())? unitRadioMale.getText().toString().toLowerCase(): (unitRadioFemale.isSelected())? unitRadioFemale.getText().toString().toLowerCase():"";
             filterRoomTable(unitRoomTable, minPrice, maxPrice,4,11,unitBathrooms, unitRooms  ,gender);
        } catch(Exception e) { 
            new Message("Oops, Somthing Went  Wrong  Please  Try Again Later", fileHandling.messageIcon("error")).setVisible(true);
        }
       
    }//GEN-LAST:event_unitRoomFilterActionPerformed

    private void unitBackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_unitBackButtonMouseClicked
        // TODO add your handling code here:
        new  Utility(Body,SelectProperite).displayPanel(); 
    }//GEN-LAST:event_unitBackButtonMouseClicked

    private void doubleRoomMaxPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doubleRoomMaxPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_doubleRoomMaxPriceActionPerformed

    private void doubleRoomMinPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doubleRoomMinPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_doubleRoomMinPriceActionPerformed

    private void radioNone3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNone3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioNone3ActionPerformed

    private void doubleRadioMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doubleRadioMaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_doubleRadioMaleActionPerformed

    private void doubleRoomFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doubleRoomFilterActionPerformed
        // TODO add your handling code here:
       double minPrice = Double.parseDouble(doubleRoomMinPrice.getText().toString()); 
       double maxPrice = Double.parseDouble(doubleRoomMaxPrice.getText().toString()); 
       String doubleRoomsNumberOfResidents =  doubleRoomsNumber.getSelectedItem().toString();
       
        try { 
            String gender = (doubleRadioMale.isSelected()) ? doubleRadioMale.getText().toString().toLowerCase() : (doubleRadioFemale.isSelected()) ? doubleRadioFemale.getText().toString().toLowerCase() : "";
            filterRoomTable(doubleRoomTable, minPrice, maxPrice, 4, 10, doubleRoomsNumberOfResidents, gender);
        } catch(Exception e) { 
            new Message("Oops, Somthing Went  Wrong  Please  Try Again Later", fileHandling.messageIcon("error")).setVisible(true);
        }
 
    }//GEN-LAST:event_doubleRoomFilterActionPerformed

    private void doubleRoomResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doubleRoomResetActionPerformed
        // TODO add your handling code here:as
        reset(doubleRoomTable,doubleRoomSearchField);
    }//GEN-LAST:event_doubleRoomResetActionPerformed

    private void doubleRoomSearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doubleRoomSearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_doubleRoomSearchFieldActionPerformed

    private void doubleRoomSearchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_doubleRoomSearchFieldKeyReleased
        // TODO add your handling code here:
           if (doubleRoomSearchField.getText().isEmpty())  {
              searchInTable(doubleRoomTable,"");
          }
    }//GEN-LAST:event_doubleRoomSearchFieldKeyReleased

    private void doubleRoommSearchButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doubleRoommSearchButton2ActionPerformed
        // TODO add your handling code here:
       searchInTable(   doubleRoomTable,doubleRoomSearchField.getText().toString());
    }//GEN-LAST:event_doubleRoommSearchButton2ActionPerformed

    private void doubleBackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doubleBackButtonMouseClicked
      // TODO add your handling code here:\
       new  Utility(Body,SelectProperite).displayPanel();
    }//GEN-LAST:event_doubleBackButtonMouseClicked

    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Application app = new  Application();
        boolean flag = app.makeApplication(propRoomId1.getText().toString(), propUserName1.getText().toString(), propEmail1.getText().toString(), propName1.getText().toString(), Integer.parseInt(propDuration1.getSelectedItem().toString()), Double.parseDouble(propMonthlyRent1.getText().toString()),propType1.getText().toString(), Double.parseDouble( propDeposit1.getText().toString()));
       if(flag) { 

        //open new panel
        new  Utility(Body,SelectProperite).displayPanel(); 
        new  Utility(Parent,Application).displayPanel(); 
        
        //
        appApplicationId.setText("application id");
        appStatus.setText("status");
        appDuration.setText("duration");
        appEmail.setText("email");
        appMonthly.setText("monthly rent");
        appName.setText("name");
        appRoomId.setText("roomid");
     try{
           app.displayApplicationDetailsPanel(Application, st.getUserName());
     } 
     catch(Exception e){
                     new Message("Oops, Somthing Went  Wrong  Please  Try Again Later", fileHandling.messageIcon("error")).setVisible(true);

        }
     }       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    new  Utility(Body,currentRoom).displayPanel(); 

    propName1.setText(st.getName());
    propUserName1.setText(st.getUserName());
    propEmail1.setText(st.getEmail());
    propRoomId1.setText("roomid");
    propType1.setText("type");
    propMonthlyRent1.setText("monthly rent");
    propDeposit1.setText("deposit");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jLabel103MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel103MouseClicked
        // TODO add your handling code here:
         System.exit(0);
    }//GEN-LAST:event_jLabel103MouseClicked

    private void refundListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refundListActionPerformed
        // TODO add your handling code here:
        Payment  py = new  Payment(); 
        py.setType( "refund");
        
        
    try { 
        py.displayPaymentDetailRecord(refundTable, st.getUserName(), st.getRole(), "record", BodyApplication, appRefundList);
        new  Utility(BodyApplication,appRefundList).displayPanel(); 
    } catch(Exception e) { 
            new Message("Oops, Somthing Went  Wrong  Please  Try Again Later", fileHandling.messageIcon("error")).setVisible(true);
        }
    }//GEN-LAST:event_refundListActionPerformed

    private void refundSearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refundSearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_refundSearchFieldActionPerformed

    private void refundSearchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_refundSearchFieldKeyReleased
        // TODO add your handling code here:
 
       searchInTable(refundTable ,refundSearchField.getText());
    }//GEN-LAST:event_refundSearchFieldKeyReleased

    private void paymentRefundSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentRefundSearchButtonActionPerformed
       // TODO add your handling code here:
        searchInTable(refundTable, refundSearchField.getText());
    }//GEN-LAST:event_paymentRefundSearchButtonActionPerformed

    private void refundFillterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refundFillterButtonActionPerformed
   // TODO add your handling code here:
     int minYear =   Integer.parseInt(refundMinYear.getSelectedItem().toString());
        int minMonth = Integer.parseInt(refundMinMonth.getSelectedItem().toString());
        int maxYear=  Integer.parseInt(refundMaxYear.getSelectedItem().toString());
        int maxMonth=  Integer.parseInt(refundMaxMonth.getSelectedItem().toString());
        
        try { 
            filterTable(refundTable, minYear, maxYear, minMonth, maxMonth,6 , 7, 9);
        } catch(Exception e) { 
            new Message("Oops, Somthing Went  Wrong  Please  Try Again Later", fileHandling.messageIcon("error")).setVisible(true);
        }
           
    }//GEN-LAST:event_refundFillterButtonActionPerformed

    private void refundMaxYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refundMaxYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_refundMaxYearActionPerformed

    private void viewrefundBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewrefundBackMouseClicked
        // TODO add your handling code here:
        new  Utility(BodyApplication,viewApplicationInfo).displayPanel(); 
    }//GEN-LAST:event_viewrefundBackMouseClicked

    private void refundRestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refundRestButtonActionPerformed
        // TODO add your handling code here: 
       searchInTable(refundTable ,refundSearchField.getText());
    }//GEN-LAST:event_refundRestButtonActionPerformed

    private void paymentExpairationDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentExpairationDateActionPerformed
        // TODO add your handling code here:
      
                         
    }//GEN-LAST:event_paymentExpairationDateActionPerformed

    private void paymentCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentCardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paymentCardActionPerformed

    private void paymentCash1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentCash1ActionPerformed
        // TODO add your handling code here:
     
    }//GEN-LAST:event_paymentCash1ActionPerformed

    private void paymentCash1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentCash1MouseClicked
        // TODO add your handling code here:
        new  Utility(paymentContainer,paymentCashPanel).displayPanel(); 
    }//GEN-LAST:event_paymentCash1MouseClicked

    private void paymentCardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentCardMouseClicked
        // TODO add your handling code here:
        new  Utility(paymentContainer,paymentCardPanel).displayPanel(); 
    }//GEN-LAST:event_paymentCardMouseClicked

    private void paymentCCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentCCVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paymentCCVActionPerformed

    private void PaymentPayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaymentPayButtonActionPerformed
      // TODO add your handling code here:
      try {
      new Payment().makePayment(paymentTable, paymentid.getText(), st.getUserName(), paymentCard, paymentCardNumber.getText(), paymentCCV.getText(), paymentExpairationDate.getText(), BodyApplication, viewApplicationInfo, viewPaymentDetail);  
      }catch(Exception e) { 
            new Message("Oops, Somthing Went  Wrong  Please  Try Again Later", fileHandling.messageIcon("error")).setVisible(true);
        }
    }//GEN-LAST:event_PaymentPayButtonActionPerformed

    private void paymentCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentCancelButtonActionPerformed
        // TODO add your handling code here:
       new  Utility(BodyApplication,viewApplicationInfo).displayPanel(); 
    }//GEN-LAST:event_paymentCancelButtonActionPerformed

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        // TODO add your handling code here:
        reset(paymentTable,RefreshTextFiled);
    }//GEN-LAST:event_RefreshActionPerformed
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
            java.util.logging.Logger.getLogger(StudentHostel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentHostel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentHostel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentHostel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentHostel(st).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Application;
    private javax.swing.JPanel Body;
    private javax.swing.JPanel BodyApplication;
    private javax.swing.JPanel DisplayRecord;
    private javax.swing.JPanel DoubleRoomPane;
    private javax.swing.JComboBox<String> EndMonth4;
    private javax.swing.JComboBox<String> EndYear4;
    private javax.swing.JPanel Foorter;
    private javax.swing.JPanel Footer;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Header1;
    private javax.swing.JPanel Header2;
    private javax.swing.JPanel Header3;
    private javax.swing.JPanel Header4;
    private javax.swing.JPanel Header5;
    private javax.swing.JPanel MasterPane;
    private javax.swing.JPanel PanelDate;
    private javax.swing.JPanel PanelDate1;
    private javax.swing.JPanel PanelDate2;
    public javax.swing.JPanel Parent;
    private javax.swing.JToggleButton PaymentPayButton;
    private javax.swing.JTable PaymetRecordTabel;
    private javax.swing.JPanel Profile;
    private javax.swing.JLabel ProfileAddress;
    private javax.swing.JPanel ProfileBody;
    private javax.swing.JLabel ProfileGender;
    private javax.swing.JLabel ProfileRole;
    private javax.swing.JLabel ProfileTPNumber;
    private javax.swing.JLabel ProfileUserName;
    private javax.swing.JPanel Properties;
    private javax.swing.JButton RecordFillterButton4;
    private javax.swing.JPanel Records;
    private javax.swing.JButton Refresh;
    private javax.swing.JTextField RefreshTextFiled;
    private javax.swing.JPanel SelectProperite;
    private javax.swing.JPanel SelelctRecord;
    private javax.swing.JPanel Sidebar;
    private javax.swing.JPanel SingleRoomPanel;
    private javax.swing.JComboBox<String> StartMonth4;
    private javax.swing.JComboBox<String> StartYear5;
    private javax.swing.JPanel UnitPanel;
    private javax.swing.JPanel ViewSingleRoom;
    private javax.swing.JLabel appApplicationId;
    private javax.swing.JLabel appApplicationId1;
    private javax.swing.JLabel appCost;
    private javax.swing.JLabel appDuration;
    private javax.swing.JLabel appEmail;
    private javax.swing.JLabel appMonthly;
    private javax.swing.JLabel appName;
    private javax.swing.JLabel appName1;
    private javax.swing.JPanel appRefundList;
    private javax.swing.JLabel appRoomId;
    private javax.swing.JLabel appRoomId1;
    private javax.swing.JLabel appRoomId2;
    private javax.swing.JLabel appRoomId4;
    private javax.swing.JLabel appRoomId5;
    private javax.swing.JLabel appRoomId6;
    private javax.swing.JLabel appRoomId7;
    private javax.swing.JLabel appStatus;
    private javax.swing.JLabel applicationBackButton;
    private javax.swing.JButton applicationFillterButton;
    private javax.swing.JComboBox<String> applicationMaxMonth;
    private javax.swing.JComboBox<String> applicationMaxYear;
    private javax.swing.JComboBox<String> applicationMinMonth;
    private javax.swing.JComboBox<String> applicationMinYear;
    private javax.swing.JButton applicationRecord;
    private javax.swing.JButton applicationRecordSearchButton;
    private javax.swing.JTextField applicationRecordSearchField;
    private javax.swing.JTable applicationRecordTable;
    private javax.swing.JTable applicationRecordTable1;
    private javax.swing.JComboBox<String> applicationStatus;
    private javax.swing.JSpinner bathroomNumber;
    private javax.swing.JPanel btnApplication;
    private javax.swing.JButton btnDouble;
    private javax.swing.JPanel btnLogout;
    private javax.swing.JButton btnMaster;
    private javax.swing.JPanel btnProfile;
    private javax.swing.JPanel btnProperties;
    private javax.swing.JPanel btnRecord;
    private javax.swing.JButton btnSingle;
    private javax.swing.JButton btnUnit;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JComboBox<String> cmbStatus7;
    private javax.swing.JLabel doubleBackButton;
    private javax.swing.JRadioButton doubleRadioFemale;
    private javax.swing.JRadioButton doubleRadioMale;
    private javax.swing.JButton doubleRoomFilter;
    private javax.swing.JTextField doubleRoomMaxPrice;
    private javax.swing.JTextField doubleRoomMinPrice;
    private javax.swing.JButton doubleRoomReset;
    private javax.swing.JTextField doubleRoomSearchField;
    private javax.swing.JTable doubleRoomTable;
    private javax.swing.JButton doubleRoommSearchButton2;
    private javax.swing.JComboBox<String> doubleRoomsNumber;
    private javax.swing.JPanel filterCom1;
    private javax.swing.JPanel filterCom2;
    private javax.swing.JPanel filterCom4;
    private javax.swing.JPanel filterCompnents;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JSeparator jSeparator25;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel lbStatus6;
    private javax.swing.JLabel lbStatus7;
    private javax.swing.JButton loginFillterButton;
    private javax.swing.JComboBox<String> loginMaxMonth;
    private javax.swing.JComboBox<String> loginMaxYear;
    private javax.swing.JComboBox<String> loginMinMonth;
    private javax.swing.JComboBox<String> loginMinYear;
    private javax.swing.JButton loginRecord;
    private javax.swing.JLabel loginRecordBack;
    private javax.swing.JButton loginRecordSearchButton1;
    private javax.swing.JTextField loginRecordSearchField;
    private javax.swing.JTable loginRecordTabel;
    private javax.swing.JPanel makeApplication;
    private javax.swing.JLabel masterBackButton;
    private javax.swing.JRadioButton masterRadioFemale;
    private javax.swing.JRadioButton masterRadioMale;
    private javax.swing.JButton masterRoomFilter;
    private javax.swing.JTextField masterRoomMaxPrice;
    private javax.swing.JTextField masterRoomMinPrice;
    private javax.swing.JButton masterRoomReset;
    private javax.swing.JTextField masterRoomSearchField;
    private javax.swing.JTable masterRoomTable;
    private javax.swing.JButton mastersRoomSearchButton;
    private javax.swing.JTextField paymentCCV;
    private javax.swing.JToggleButton paymentCancelButton;
    private javax.swing.JRadioButton paymentCard;
    private javax.swing.JTextField paymentCardNumber;
    private javax.swing.JPanel paymentCardPanel;
    private javax.swing.JRadioButton paymentCash1;
    private javax.swing.JPanel paymentCashPanel;
    private javax.swing.JPanel paymentContainer;
    private javax.swing.JTextField paymentExpairationDate;
    private javax.swing.JButton paymentFillterButton;
    private javax.swing.JComboBox<String> paymentMaxMonth;
    private javax.swing.JComboBox<String> paymentMaxYear;
    private javax.swing.JComboBox<String> paymentMinMonth;
    private javax.swing.JComboBox<String> paymentMinYear;
    private javax.swing.JButton paymentRecord;
    private javax.swing.JLabel paymentRecordBack;
    private javax.swing.JTextField paymentRecordSearchField;
    private javax.swing.JButton paymentRefundSearchButton;
    private javax.swing.JTable paymentTable;
    private javax.swing.JLabel paymentid;
    private javax.swing.JButton paymentrRecordSearchButton;
    private javax.swing.JPanel personalInfo;
    private javax.swing.JLabel profileEmail;
    private javax.swing.JLabel profileName;
    private javax.swing.JLabel propDeposit;
    private javax.swing.JLabel propDeposit1;
    private javax.swing.JLabel propDeposit3;
    private javax.swing.JLabel propDeposit4;
    private javax.swing.JLabel propDeposit5;
    private javax.swing.JLabel propDeposit6;
    private javax.swing.JLabel propDeposit7;
    private javax.swing.JLabel propDeposit8;
    private javax.swing.JTextArea propDescription;
    private javax.swing.JComboBox<String> propDuration1;
    private javax.swing.JLabel propEmail1;
    private javax.swing.JLabel propGender;
    private javax.swing.JLabel propLocation;
    private javax.swing.JLabel propMonthly;
    private javax.swing.JLabel propMonthlyRent1;
    private javax.swing.JLabel propName1;
    private javax.swing.JLabel propRoomId;
    private javax.swing.JLabel propRoomId1;
    private javax.swing.JLabel propSize;
    private javax.swing.JLabel propStatus;
    private javax.swing.JLabel propType;
    private javax.swing.JLabel propType1;
    private javax.swing.JLabel propUserName1;
    private javax.swing.JRadioButton radioNone;
    private javax.swing.JRadioButton radioNone1;
    private javax.swing.JRadioButton radioNone2;
    private javax.swing.JRadioButton radioNone3;
    private javax.swing.JButton recordFilterButton4;
    private javax.swing.JTextField recordSearchField4;
    private javax.swing.JButton refundFillterButton;
    private javax.swing.JButton refundList;
    private javax.swing.JComboBox<String> refundMaxMonth;
    private javax.swing.JComboBox<String> refundMaxYear;
    private javax.swing.JComboBox<String> refundMinMonth;
    private javax.swing.JComboBox<String> refundMinYear;
    private javax.swing.JButton refundRestButton;
    private javax.swing.JTextField refundSearchField;
    private javax.swing.JTable refundTable;
    private javax.swing.JSpinner roomsNumber;
    private javax.swing.JComboBox<String> singleBathroomType;
    private javax.swing.JTextField singleMaxPrice;
    private javax.swing.JTextField singleMinPrice;
    private javax.swing.JRadioButton singleRadioFemale;
    private javax.swing.JRadioButton singleRadioMale;
    private javax.swing.JButton singleRoomFilter;
    private javax.swing.JButton singleRoomReset;
    private javax.swing.JButton singleRoomSearchButton;
    private javax.swing.JTextField singleRoomSearchField;
    private javax.swing.JTable singleRoomTable;
    private javax.swing.JLabel unitBackButton;
    private javax.swing.JComboBox<String> unitBathroomsNumber;
    private javax.swing.JRadioButton unitRadioFemale;
    private javax.swing.JRadioButton unitRadioMale;
    private javax.swing.JButton unitRoomFilter;
    private javax.swing.JTextField unitRoomMaxPrice;
    private javax.swing.JTextField unitRoomMinPrice;
    private javax.swing.JButton unitRoomReset;
    private javax.swing.JButton unitRoomSearchButton1;
    private javax.swing.JTextField unitRoomSearchField;
    private javax.swing.JTable unitRoomTable;
    private javax.swing.JComboBox<String> unitRoomsNumber;
    private javax.swing.JPanel viewApplicationInfo;
    private javax.swing.JPanel viewApplicationRecord;
    private javax.swing.JPanel viewApplicationRecord1;
    private javax.swing.JPanel viewApplicationRecord2;
    private javax.swing.JPanel viewApplicationRecord3;
    private javax.swing.JPanel viewDoubleRoom;
    private javax.swing.JPanel viewLoginRecord;
    private javax.swing.JPanel viewMasterRoom;
    private javax.swing.JPanel viewPaymentDetail;
    private javax.swing.JPanel viewPaymentRecord;
    private javax.swing.JPanel viewRoomDetails;
    private javax.swing.JPanel viewUnit;
    private javax.swing.JLabel viewrefundBack;
    private javax.swing.JLabel welcoming;
    // End of variables declaration//GEN-END:variables
}
