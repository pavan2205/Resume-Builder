/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package employee;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author prax and Pavan
 */
//imoporting tabbedpaneui
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.*;
import javax.swing.plaf.basic.*;
import javax.swing.text.View;
import javax.swing.border.Border;
import java.sql.*;




public class Homepage extends javax.swing.JFrame {

  private int id ;
  private int cvid;
  boolean redirect;
  private boolean chk1=false;
  private boolean chk2=false;
  private boolean chk3=false;
  private boolean chk4=false;
  private boolean chk5=false;
  private boolean chk6=false;
    /**
     * Creates new form NewJFrame
     */
  
    public Homepage(int id) {
        this.id=id;
        
        initComponents();
        
////        fetch from register fname,lname and email 
//        try{
//        Class.forName("com.mysql.cj.jdbc.Driver");
//           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resume?useSSL=false","root","pavan123");
//           
//           Statement ps11 = con.createStatement();
//            String query13="select * from register where rid="+id;
//               ResultSet rs12=ps11.executeQuery(query13);
//               if(rs12.next()){
//                   firstnameinput.setText(rs12.getString(2));
//                   lastnameinput.setText(rs12.getString(3));
//                   emailinput.setText(rs12.getString(5));
//               }
//               con.close();
//
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }
        
        
        
        
         //fetch  rid , cvid
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resume?useSSL=false","root","pavan123");
           String query="";
           PreparedStatement ps,ps2;
           Statement ps1 = con.createStatement();
           Statement ps3 = con.createStatement();
           Statement ps4=con.createStatement();
           String query1="select * from resumes where rid="+id;

           ResultSet rs=ps1.executeQuery(query1);
           if(rs.next()){
               cvid=rs.getInt(1);
           }

           int count=0;
           ResultSet rs2=ps3.executeQuery(query1);
           while(rs2.next()){
               count++;
           }
           
           if(count<1){
                   query="INSERT INTO resumes(rid)values(?)";
                   ps2=con.prepareStatement(query);
                   ps2.setInt(1,id);
                   if(ps2.executeUpdate()>0){
                       String query9="select * from resumes where rid="+id;

                        ResultSet rs8=ps4.executeQuery(query9);
                        if(rs8.next()){
               cvid=rs8.getInt(1);
           }
                   }
           }
           con.close();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }




        //personal data fetch

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resume?useSSL=false","root","pavan123");

           Statement ps2 = con.createStatement();
           Statement ps3=con.createStatement();
           String query2="select pid from personal where cvid="+cvid;

           ResultSet rs1=ps2.executeQuery(query2);
           int count=0;
           while(rs1.next()){
               count++;
           }
           boolean flag=false;
           if(count>0){
               flag=true;
           }

           if(flag){
               String query3="select * from personal where cvid="+cvid;
               ResultSet rs2=ps2.executeQuery(query3);
               if(rs2.next()){
                   firstnameinput.setText(rs2.getString(3));
                   lastnameinput.setText(rs2.getString(4));
                   emailinput.setText(rs2.getString(5));
                   githuburlinput.setText(rs2.getString(6));
                   linkdininput.setText(rs2.getString(7));
                   phoneinput.setText(rs2.getString(8));
               }
               
           }


        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        String check1=emailinput.getText();
        chk1=check1.isEmpty();



        //Academics data fetch

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resume?useSSL=false","root","pavan123");

           Statement ps4 = con.createStatement();
           Statement ps5=con.createStatement();
           String query2="select aid from academics where cvid="+cvid;

           ResultSet rs3=ps4.executeQuery(query2);
           int count2=0;
           while(rs3.next()){
               count2++;
           }
           boolean flag2=false;
           if(count2>0){
               flag2=true;
           }

           if(flag2){
               String query3="select * from academics where cvid="+cvid;
               ResultSet rs4=ps5.executeQuery(query3);
               if(rs4.next()){
                   puccollagenameinput.setText(rs4.getString(3));
                   pucboardinput.setText(rs4.getString(4));
                   pucpercentageinput.setText(rs4.getString(5));
                   puccourseinput.setText(rs4.getString(6));
                   pucyearinput.setText(rs4.getString(7));
                   degreecollageinput.setText(rs4.getString(8));
                   degreeboardinput.setText(rs4.getString(9));
                   degreecgpainput.setText(rs4.getString(10));
                   degreecourseinput.setText(rs4.getString(11));
                   degreeyearinput.setText(rs4.getString(12));
               }
           }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        String check2=puccollagenameinput.getText();
        chk2=check2.isEmpty();
       
        
        
        
        // Skills fetch 
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resume?useSSL=false","root","pavan123");

           Statement ps2 = con.createStatement();
           Statement ps3=con.createStatement();
           String query2="select sid from skills where cvid="+cvid;

           ResultSet rs1=ps2.executeQuery(query2);
           int count=0;
           while(rs1.next()){
               count++;
           }
           boolean flag=false;
           if(count>0){
               flag=true;
           }

           if(flag){
               String query3="select * from skills where cvid="+cvid;
               ResultSet rs2=ps2.executeQuery(query3);
               if(rs2.next()){
                   skillnameinput.setText(rs2.getString(3));
                   skilldescriptioninput.setText(rs2.getString(4));
               }
           }


        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        String check3=skillnameinput.getText();
        chk3=check3.isEmpty();
        
        
        
        // Projects fetch 
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resume?useSSL=false","root","pavan123");

           Statement ps2 = con.createStatement();
           Statement ps3=con.createStatement();
           String query2="select projectid from projects where cvid="+cvid;

           ResultSet rs1=ps2.executeQuery(query2);
           int count=0;
           while(rs1.next()){
               count++;
           }
           boolean flag=false;
           if(count>0){
               flag=true;
           }

           if(flag){
               String query3="select * from projects where cvid="+cvid;
               ResultSet rs2=ps2.executeQuery(query3);
               if(rs2.next()){
                   projectnameinput.setText(rs2.getString(3));
                   projectdescriptioninput.setText(rs2.getString(4));
               }
           }


        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        String check4=projectnameinput.getText();
        chk4=check4.isEmpty();
        
        
        
        
        //achievements fetch
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resume?useSSL=false","root","pavan123");

           Statement ps2 = con.createStatement();
           Statement ps3=con.createStatement();
           String query2="select achievementid from achievements where cvid="+cvid;

           ResultSet rs1=ps2.executeQuery(query2);
           int count=0;
           while(rs1.next()){
               count++;
           }
           boolean flag=false;
           if(count>0){
               flag=true;
           }

           if(flag){
               String query3="select * from achievements where cvid="+cvid;
               ResultSet rs2=ps2.executeQuery(query3);
               if(rs2.next()){
                   achivementnameinput.setText(rs2.getString(3));
                   achivementdescriptioninput.setText(rs2.getString(4));
               }
           }


        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        String check5=achivementnameinput.getText();
        chk5=check5.isEmpty();
        
        
        //experience fetch 
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resume?useSSL=false","root","pavan123");

           Statement ps2 = con.createStatement();
           Statement ps3=con.createStatement();
           String query2="select exid from experience where cvid="+cvid;

           ResultSet rs1=ps2.executeQuery(query2);
           int count=0;
           while(rs1.next()){
               count++;
           }
           boolean flag=false;
           if(count>0){
               flag=true;
           }

           if(flag){
               String query3="select * from experience where cvid="+cvid;
               ResultSet rs2=ps2.executeQuery(query3);
               if(rs2.next()){
                   companynameinput.setText(rs2.getString(3));
                   roledescriptioninput.setText(rs2.getString(4));
                   experiencedurationdropdown.setSelectedItem(rs2.getString(5));
               }
           }


        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        String check6=companynameinput.getText();
        chk6=check6.isEmpty();
        
        
    
         jTabbedPane1.setUI(new BasicTabbedPaneUI(){
             @Override
             protected int calculateTabAreaHeight(int tab_placement, int run_count, int max_tab_height) {  
//                if (jTabbedPane1.getTabCount() == 6)
//                    return super.calculateTabAreaHeight(tab_placement, run_count, max_tab_height);  
//                else  
                    return 1;  
                } 
           });
        
    }
     private Homepage() {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        canvas1 = new java.awt.Canvas();
        jButton12 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        createresumebutton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        PersonalPanel = new javax.swing.JPanel();
        PersonalLabel = new javax.swing.JLabel();
        AcademicsPanel = new javax.swing.JPanel();
        AcademicsLabel = new javax.swing.JLabel();
        SkillsPanel = new javax.swing.JPanel();
        SkillsLabel = new javax.swing.JLabel();
        ProjectsPanel = new javax.swing.JPanel();
        PrajectsLabel = new javax.swing.JLabel();
        Signoutbutton = new javax.swing.JButton();
        AchivementsPanel = new javax.swing.JPanel();
        AchivementsLabel = new javax.swing.JLabel();
        ExperiencePanel = new javax.swing.JPanel();
        ExperienceLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        PersonalContentPanel = new javax.swing.JPanel();
        firstnameinput = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lastnameinput = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        personalcontinuebutton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        emailinput = new javax.swing.JTextField();
        githuburlinput = new javax.swing.JTextField();
        linkdininput = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        phoneinput = new javax.swing.JTextField();
        AcademicContentPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        puccollagenameinput = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        pucpercentageinput = new javax.swing.JTextField();
        degreecgpainput = new javax.swing.JTextField();
        degreecollageinput = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        pucboardinput = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        degreeboardinput = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        puccourseinput = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        degreecourseinput = new javax.swing.JTextField();
        pucyearinput = new javax.swing.JTextField();
        degreeyearinput = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        academicscontinuebutton = new javax.swing.JButton();
        SkillsContentPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        skilladdonemorebutton = new javax.swing.JButton();
        skillscontinuebutton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        skillsearchtextbox = new javax.swing.JTextField();
        skillsearchbutton = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        skillnameinput = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        skilldescriptioninput = new javax.swing.JTextArea();
        skilldeletebutton = new javax.swing.JButton();
        skillsupdatebutton = new javax.swing.JButton();
        ProjectsContentPanel = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        projectaddonemorebutton = new javax.swing.JButton();
        projectupdatebutton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        projectsearchtextfield = new javax.swing.JTextField();
        Projectsearchbutton = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        projectnameinput = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        projectdescriptioninput = new javax.swing.JTextArea();
        projectdeletebutton = new javax.swing.JButton();
        projectcontinuebutton1 = new javax.swing.JButton();
        AchivementsContentPanel = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        achivementaddonemorebutton = new javax.swing.JButton();
        achivementcontinuebutton = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        achivementssearchtextbox = new javax.swing.JTextField();
        achivementssearchbutton = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        achivementnameinput = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        achivementdescriptioninput = new javax.swing.JTextArea();
        achivementdeletebutton = new javax.swing.JButton();
        achivementupdatebutton = new javax.swing.JButton();
        ExperienceContentPanel = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        experienceupdatebutton = new javax.swing.JButton();
        experienceaddonemorebutton = new javax.swing.JButton();
        experiencelist = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        companynameinput = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        experiencedeletebutton = new javax.swing.JButton();
        experiencedurationdropdown = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        roledescriptioninput = new javax.swing.JTextArea();
        experiencesearchtextbox = new javax.swing.JTextField();
        experiencesearchbutton = new javax.swing.JButton();
        experiencecontinuebutton = new javax.swing.JButton();

        jButton12.setBackground(new java.awt.Color(0, 153, 255));
        jButton12.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("Continue");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));
        setMaximumSize(new java.awt.Dimension(1920, 1080));

        jPanel1.setBackground(new java.awt.Color(51, 204, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 5, true));

        createresumebutton.setBackground(new java.awt.Color(153, 153, 255));
        createresumebutton.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        createresumebutton.setForeground(new java.awt.Color(255, 255, 255));
        createresumebutton.setText("create");
        createresumebutton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        createresumebutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        createresumebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createresumebuttonActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ResumeBuilder.io");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(createresumebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(createresumebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(51, 204, 255));

        PersonalPanel.setBackground(new java.awt.Color(102, 153, 255));
        PersonalPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 5, true));
        PersonalPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hover(evt);
            }
        });

        PersonalLabel.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        PersonalLabel.setText("personal");

        javax.swing.GroupLayout PersonalPanelLayout = new javax.swing.GroupLayout(PersonalPanel);
        PersonalPanel.setLayout(PersonalPanelLayout);
        PersonalPanelLayout.setHorizontalGroup(
            PersonalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PersonalPanelLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(PersonalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PersonalPanelLayout.setVerticalGroup(
            PersonalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PersonalPanelLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(PersonalLabel)
                .addGap(20, 20, 20))
        );

        AcademicsPanel.setBackground(new java.awt.Color(178, 229, 255));
        AcademicsPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 5, true));
        AcademicsPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hover(evt);
            }
        });

        AcademicsLabel.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        AcademicsLabel.setText("Academics");

        javax.swing.GroupLayout AcademicsPanelLayout = new javax.swing.GroupLayout(AcademicsPanel);
        AcademicsPanel.setLayout(AcademicsPanelLayout);
        AcademicsPanelLayout.setHorizontalGroup(
            AcademicsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AcademicsPanelLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(AcademicsLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AcademicsPanelLayout.setVerticalGroup(
            AcademicsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AcademicsPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(AcademicsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        SkillsPanel.setBackground(new java.awt.Color(178, 229, 255));
        SkillsPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 5, true));
        SkillsPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hover(evt);
            }
        });

        SkillsLabel.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        SkillsLabel.setText("Skills");

        javax.swing.GroupLayout SkillsPanelLayout = new javax.swing.GroupLayout(SkillsPanel);
        SkillsPanel.setLayout(SkillsPanelLayout);
        SkillsPanelLayout.setHorizontalGroup(
            SkillsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SkillsPanelLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(SkillsLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SkillsPanelLayout.setVerticalGroup(
            SkillsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SkillsPanelLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(SkillsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        ProjectsPanel.setBackground(new java.awt.Color(178, 229, 255));
        ProjectsPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 5, true));
        ProjectsPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hover(evt);
            }
        });

        PrajectsLabel.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        PrajectsLabel.setText("Projects");

        javax.swing.GroupLayout ProjectsPanelLayout = new javax.swing.GroupLayout(ProjectsPanel);
        ProjectsPanel.setLayout(ProjectsPanelLayout);
        ProjectsPanelLayout.setHorizontalGroup(
            ProjectsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProjectsPanelLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(PrajectsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ProjectsPanelLayout.setVerticalGroup(
            ProjectsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProjectsPanelLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(PrajectsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        Signoutbutton.setBackground(new java.awt.Color(153, 153, 255));
        Signoutbutton.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        Signoutbutton.setForeground(new java.awt.Color(255, 255, 255));
        Signoutbutton.setText("Back");
        Signoutbutton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Signoutbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignoutbuttonActionPerformed(evt);
            }
        });

        AchivementsPanel.setBackground(new java.awt.Color(178, 229, 255));
        AchivementsPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 5, true));
        AchivementsPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hover(evt);
            }
        });

        AchivementsLabel.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        AchivementsLabel.setText("Achievements");

        javax.swing.GroupLayout AchivementsPanelLayout = new javax.swing.GroupLayout(AchivementsPanel);
        AchivementsPanel.setLayout(AchivementsPanelLayout);
        AchivementsPanelLayout.setHorizontalGroup(
            AchivementsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AchivementsPanelLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(AchivementsLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AchivementsPanelLayout.setVerticalGroup(
            AchivementsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AchivementsPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(AchivementsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        ExperiencePanel.setBackground(new java.awt.Color(178, 229, 255));
        ExperiencePanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 5, true));
        ExperiencePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hover(evt);
            }
        });

        ExperienceLabel.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        ExperienceLabel.setText("Experience");

        javax.swing.GroupLayout ExperiencePanelLayout = new javax.swing.GroupLayout(ExperiencePanel);
        ExperiencePanel.setLayout(ExperiencePanelLayout);
        ExperiencePanelLayout.setHorizontalGroup(
            ExperiencePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExperiencePanelLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(ExperienceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ExperiencePanelLayout.setVerticalGroup(
            ExperiencePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ExperiencePanelLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(ExperienceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PersonalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SkillsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ProjectsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ExperiencePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AchivementsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AcademicsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(Signoutbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(PersonalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AcademicsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SkillsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProjectsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AchivementsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ExperiencePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Signoutbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        PersonalContentPanel.setBackground(new java.awt.Color(255, 255, 255));
        PersonalContentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        firstnameinput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        firstnameinput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstnameinputActionPerformed(evt);
            }
        });
        PersonalContentPanel.add(firstnameinput, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 380, 52));

        jLabel6.setText("First Name");
        PersonalContentPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 87, -1));

        jLabel8.setText("Last Name");
        PersonalContentPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, -1, -1));

        lastnameinput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PersonalContentPanel.add(lastnameinput, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, 380, 54));

        jLabel9.setFont(new java.awt.Font("Liberation Sans", 1, 48)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 255));
        jLabel9.setText("Add your name");
        PersonalContentPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, -1, -1));

        personalcontinuebutton.setBackground(new java.awt.Color(0, 153, 255));
        personalcontinuebutton.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        personalcontinuebutton.setForeground(new java.awt.Color(255, 255, 255));
        personalcontinuebutton.setText("Continue");
        personalcontinuebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personalcontinuebuttonActionPerformed(evt);
            }
        });
        PersonalContentPanel.add(personalcontinuebutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 610, 127, -1));

        jLabel10.setText("Now you are ready! now add your name and personal details!");
        PersonalContentPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 322, -1));

        jLabel11.setText("Email");
        PersonalContentPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, 50, -1));

        emailinput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        emailinput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailinputActionPerformed(evt);
            }
        });
        PersonalContentPanel.add(emailinput, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, 380, 51));

        githuburlinput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        PersonalContentPanel.add(githuburlinput, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 530, 410, 49));

        linkdininput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        PersonalContentPanel.add(linkdininput, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 530, 400, 49));

        jLabel12.setText("Github URL(Optional)");
        PersonalContentPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 510, 160, -1));

        jLabel13.setText("Linkdin URL(Optional)");
        PersonalContentPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 510, 170, -1));

        jLabel34.setText("Phone");
        PersonalContentPanel.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 420, 50, -1));

        phoneinput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        phoneinput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneinputActionPerformed(evt);
            }
        });
        PersonalContentPanel.add(phoneinput, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 440, 380, 51));

        jTabbedPane1.addTab("tab1", PersonalContentPanel);

        AcademicContentPanel.setBackground(new java.awt.Color(255, 255, 255));
        AcademicContentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 255));
        jLabel5.setText("Add your academic details");
        AcademicContentPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 469, -1));

        jLabel14.setText("You are done with personal details,now you can continue with your academic details!");
        AcademicContentPanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, -1, 21));

        puccollagenameinput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        AcademicContentPanel.add(puccollagenameinput, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 357, 45));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Degree Collage name");
        AcademicContentPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, -1, -1));

        pucpercentageinput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        AcademicContentPanel.add(pucpercentageinput, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 160, 145, 43));

        degreecgpainput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        AcademicContentPanel.add(degreecgpainput, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 420, 145, 43));

        degreecollageinput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        AcademicContentPanel.add(degreecollageinput, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, 357, 43));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("percentage%");
        AcademicContentPanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 140, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("PUC Collage name ");
        AcademicContentPanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("CGPA");
        AcademicContentPanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 400, -1, -1));

        pucboardinput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        AcademicContentPanel.add(pucboardinput, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 209, 45));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("Board");
        AcademicContentPanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, -1, -1));

        degreeboardinput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        AcademicContentPanel.add(degreeboardinput, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 420, 209, 45));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("Board");
        AcademicContentPanel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 400, -1, -1));

        puccourseinput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        AcademicContentPanel.add(puccourseinput, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 311, 48));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Course");
        AcademicContentPanel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, -1, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(102, 102, 102));
        jLabel22.setText("Year");
        AcademicContentPanel.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, -1, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("course");
        AcademicContentPanel.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 470, -1, 24));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 102, 102));
        jLabel24.setText("Year");
        AcademicContentPanel.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 480, -1, -1));

        degreecourseinput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        AcademicContentPanel.add(degreecourseinput, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 500, 311, 48));

        pucyearinput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        AcademicContentPanel.add(pucyearinput, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 158, 48));

        degreeyearinput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        AcademicContentPanel.add(degreeyearinput, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 500, 158, 48));

        jLabel25.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 153, 255));
        jLabel25.setText("PUC");
        AcademicContentPanel.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, 58));

        jLabel26.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 153, 255));
        jLabel26.setText("DEGREE");
        AcademicContentPanel.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, -1, -1));

        academicscontinuebutton.setBackground(new java.awt.Color(0, 153, 255));
        academicscontinuebutton.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        academicscontinuebutton.setForeground(new java.awt.Color(255, 255, 255));
        academicscontinuebutton.setText("Continue");
        academicscontinuebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                academicscontinuebuttonActionPerformed(evt);
            }
        });
        AcademicContentPanel.add(academicscontinuebutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 610, 127, -1));

        jTabbedPane1.addTab("tab2", AcademicContentPanel);

        SkillsContentPanel.setBackground(new java.awt.Color(255, 255, 255));
        SkillsContentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Take your resume to the next level! and add your skills!");
        SkillsContentPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, -1, -1));

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 153, 255));
        jLabel27.setText("Add your skills");
        SkillsContentPanel.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, -1, -1));

        skilladdonemorebutton.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        skilladdonemorebutton.setForeground(new java.awt.Color(0, 153, 255));
        skilladdonemorebutton.setText("Add one more +");
        skilladdonemorebutton.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        skilladdonemorebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skilladdonemorebuttonActionPerformed(evt);
            }
        });
        SkillsContentPanel.add(skilladdonemorebutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 510, 734, 54));

        skillscontinuebutton.setBackground(new java.awt.Color(0, 153, 255));
        skillscontinuebutton.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        skillscontinuebutton.setForeground(new java.awt.Color(255, 255, 255));
        skillscontinuebutton.setText("Continue");
        skillscontinuebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skillscontinuebuttonActionPerformed(evt);
            }
        });
        SkillsContentPanel.add(skillscontinuebutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 610, 195, 47));

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));

        skillsearchtextbox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        skillsearchtextbox.setText("Enter the skill name");

        skillsearchbutton.setBackground(new java.awt.Color(102, 153, 255));
        skillsearchbutton.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        skillsearchbutton.setForeground(new java.awt.Color(255, 255, 255));
        skillsearchbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/employee/search (1).png"))); // NOI18N
        skillsearchbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skillsearchbuttonActionPerformed(evt);
            }
        });

        jLabel28.setText("Skill Name");

        skillnameinput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel29.setText("Skill Description");

        skilldescriptioninput.setColumns(10);
        skilldescriptioninput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        skilldescriptioninput.setRows(5);
        jScrollPane2.setViewportView(skilldescriptioninput);

        skilldeletebutton.setBackground(new java.awt.Color(102, 153, 255));
        skilldeletebutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        skilldeletebutton.setForeground(new java.awt.Color(255, 255, 255));
        skilldeletebutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/employee/delete (1).png"))); // NOI18N
        skilldeletebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skilldeletebuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(skillsearchtextbox, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(skillsearchbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(skillnameinput, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(skilldeletebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(skillsearchtextbox, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(skillsearchbutton)
                        .addGap(29, 29, 29)))
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(skillnameinput, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(skilldeletebutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        SkillsContentPanel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, -1, -1));

        skillsupdatebutton.setBackground(new java.awt.Color(0, 153, 255));
        skillsupdatebutton.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        skillsupdatebutton.setForeground(new java.awt.Color(255, 255, 255));
        skillsupdatebutton.setText("Update");
        skillsupdatebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skillsupdatebuttonActionPerformed(evt);
            }
        });
        SkillsContentPanel.add(skillsupdatebutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 610, 195, 47));

        jTabbedPane1.addTab("tab3", SkillsContentPanel);

        ProjectsContentPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel32.setText("Take your resume to the next level! and add your Projects!");

        jLabel33.setBackground(new java.awt.Color(255, 255, 255));
        jLabel33.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 153, 255));
        jLabel33.setText("Add your projects");

        projectaddonemorebutton.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        projectaddonemorebutton.setForeground(new java.awt.Color(0, 153, 255));
        projectaddonemorebutton.setText("Add one more +");
        projectaddonemorebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectaddonemorebuttonActionPerformed(evt);
            }
        });

        projectupdatebutton.setBackground(new java.awt.Color(0, 153, 255));
        projectupdatebutton.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        projectupdatebutton.setForeground(new java.awt.Color(255, 255, 255));
        projectupdatebutton.setText("Update");
        projectupdatebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectupdatebuttonActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(153, 204, 255));

        projectsearchtextfield.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        projectsearchtextfield.setText("Enter the project name");

        Projectsearchbutton.setBackground(new java.awt.Color(102, 153, 255));
        Projectsearchbutton.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        Projectsearchbutton.setForeground(new java.awt.Color(255, 255, 255));
        Projectsearchbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/employee/search (1).png"))); // NOI18N
        Projectsearchbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProjectsearchbuttonActionPerformed(evt);
            }
        });

        jLabel30.setText("project name");

        projectnameinput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel31.setText("project description");

        projectdescriptioninput.setColumns(20);
        projectdescriptioninput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        projectdescriptioninput.setRows(5);
        jScrollPane3.setViewportView(projectdescriptioninput);

        projectdeletebutton.setBackground(new java.awt.Color(102, 153, 255));
        projectdeletebutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        projectdeletebutton.setForeground(new java.awt.Color(255, 255, 255));
        projectdeletebutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/employee/delete (1).png"))); // NOI18N
        projectdeletebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectdeletebuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addContainerGap(637, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(projectsearchtextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel31)
                                    .addGap(522, 522, 522))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane3)
                                        .addComponent(projectnameinput))
                                    .addGap(18, 18, 18))))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(projectdeletebutton, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                            .addComponent(Projectsearchbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(17, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(projectsearchtextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Projectsearchbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(projectnameinput, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(projectdeletebutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        projectcontinuebutton1.setBackground(new java.awt.Color(0, 153, 255));
        projectcontinuebutton1.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        projectcontinuebutton1.setForeground(new java.awt.Color(255, 255, 255));
        projectcontinuebutton1.setText("Continue");
        projectcontinuebutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectcontinuebutton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ProjectsContentPanelLayout = new javax.swing.GroupLayout(ProjectsContentPanel);
        ProjectsContentPanel.setLayout(ProjectsContentPanelLayout);
        ProjectsContentPanelLayout.setHorizontalGroup(
            ProjectsContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProjectsContentPanelLayout.createSequentialGroup()
                .addGroup(ProjectsContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ProjectsContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ProjectsContentPanelLayout.createSequentialGroup()
                            .addGap(503, 503, 503)
                            .addGroup(ProjectsContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel32)
                                .addComponent(jLabel33)))
                        .addGroup(ProjectsContentPanelLayout.createSequentialGroup()
                            .addGap(279, 279, 279)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ProjectsContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(ProjectsContentPanelLayout.createSequentialGroup()
                            .addComponent(projectupdatebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(projectcontinuebutton1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(projectaddonemorebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(2868, Short.MAX_VALUE))
        );
        ProjectsContentPanelLayout.setVerticalGroup(
            ProjectsContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProjectsContentPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32)
                .addGap(57, 57, 57)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(projectaddonemorebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(ProjectsContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(projectupdatebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(projectcontinuebutton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(1730, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab4", ProjectsContentPanel);

        AchivementsContentPanel.setBackground(new java.awt.Color(255, 255, 255));
        AchivementsContentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setText("Take your resume to the next level! and add your Achivements!");
        AchivementsContentPanel.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, -1, -1));

        jLabel37.setBackground(new java.awt.Color(255, 255, 255));
        jLabel37.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 153, 255));
        jLabel37.setText("Add your Achievements");
        AchivementsContentPanel.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, -1, -1));

        achivementaddonemorebutton.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        achivementaddonemorebutton.setForeground(new java.awt.Color(0, 153, 255));
        achivementaddonemorebutton.setText("Add one more +");
        achivementaddonemorebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                achivementaddonemorebuttonActionPerformed(evt);
            }
        });
        AchivementsContentPanel.add(achivementaddonemorebutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 488, 750, 54));

        achivementcontinuebutton.setBackground(new java.awt.Color(0, 153, 255));
        achivementcontinuebutton.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        achivementcontinuebutton.setForeground(new java.awt.Color(255, 255, 255));
        achivementcontinuebutton.setText("Continue");
        achivementcontinuebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                achivementcontinuebuttonActionPerformed(evt);
            }
        });
        AchivementsContentPanel.add(achivementcontinuebutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 600, 195, 47));

        jPanel6.setBackground(new java.awt.Color(153, 204, 255));

        achivementssearchtextbox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        achivementssearchtextbox.setText("Achivements");

        achivementssearchbutton.setBackground(new java.awt.Color(102, 153, 255));
        achivementssearchbutton.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        achivementssearchbutton.setForeground(new java.awt.Color(255, 255, 255));
        achivementssearchbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/employee/search (1).png"))); // NOI18N
        achivementssearchbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                achivementssearchbuttonActionPerformed(evt);
            }
        });

        jLabel38.setText("Achivement name");

        achivementnameinput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel39.setText("Achivement description");

        achivementdescriptioninput.setColumns(20);
        achivementdescriptioninput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        achivementdescriptioninput.setRows(5);
        jScrollPane5.setViewportView(achivementdescriptioninput);

        achivementdeletebutton.setBackground(new java.awt.Color(102, 153, 255));
        achivementdeletebutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        achivementdeletebutton.setForeground(new java.awt.Color(255, 255, 255));
        achivementdeletebutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/employee/delete (1).png"))); // NOI18N
        achivementdeletebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                achivementdeletebuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel39)
                                    .addGap(506, 506, 506))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane5)
                                        .addComponent(achivementnameinput))
                                    .addGap(27, 27, 27)))
                            .addComponent(achivementssearchtextbox, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(achivementssearchbutton, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                            .addComponent(achivementdeletebutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(achivementssearchtextbox, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(achivementssearchbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(achivementnameinput, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(achivementdeletebutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        AchivementsContentPanel.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 750, 330));

        achivementupdatebutton.setBackground(new java.awt.Color(0, 153, 255));
        achivementupdatebutton.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        achivementupdatebutton.setForeground(new java.awt.Color(255, 255, 255));
        achivementupdatebutton.setText("Update");
        achivementupdatebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                achivementupdatebuttonActionPerformed(evt);
            }
        });
        AchivementsContentPanel.add(achivementupdatebutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 600, 195, 47));

        jTabbedPane1.addTab("tab5", AchivementsContentPanel);

        ExperienceContentPanel.setBackground(new java.awt.Color(255, 255, 255));
        ExperienceContentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setText("Take your resume to the next level! and add your Experience!");
        ExperienceContentPanel.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, -1, -1));

        jLabel41.setBackground(new java.awt.Color(255, 255, 255));
        jLabel41.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 153, 255));
        jLabel41.setText("Add your Experience");
        ExperienceContentPanel.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, -1, -1));

        experienceupdatebutton.setBackground(new java.awt.Color(0, 153, 255));
        experienceupdatebutton.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        experienceupdatebutton.setForeground(new java.awt.Color(255, 255, 255));
        experienceupdatebutton.setText("Update");
        experienceupdatebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                experienceupdatebuttonActionPerformed(evt);
            }
        });
        ExperienceContentPanel.add(experienceupdatebutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 620, 195, 47));

        experienceaddonemorebutton.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        experienceaddonemorebutton.setForeground(new java.awt.Color(0, 153, 255));
        experienceaddonemorebutton.setText("Add one more +");
        experienceaddonemorebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                experienceaddonemorebuttonActionPerformed(evt);
            }
        });
        ExperienceContentPanel.add(experienceaddonemorebutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 510, 730, 54));

        experiencelist.setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setText("company");

        companynameinput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel2.setText("Role Description");

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel3.setText("Duration:");

        experiencedeletebutton.setBackground(new java.awt.Color(102, 153, 255));
        experiencedeletebutton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        experiencedeletebutton.setForeground(new java.awt.Color(255, 255, 255));
        experiencedeletebutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/employee/delete (1).png"))); // NOI18N
        experiencedeletebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                experiencedeletebuttonActionPerformed(evt);
            }
        });

        experiencedurationdropdown.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        experiencedurationdropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "1", "2", "3", "4", "5", "5+" }));
        experiencedurationdropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                experiencedurationdropdownActionPerformed(evt);
            }
        });

        roledescriptioninput.setColumns(20);
        roledescriptioninput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        roledescriptioninput.setRows(5);
        jScrollPane1.setViewportView(roledescriptioninput);

        experiencesearchtextbox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        experiencesearchtextbox.setText("search experience by company");

        experiencesearchbutton.setBackground(new java.awt.Color(102, 153, 255));
        experiencesearchbutton.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        experiencesearchbutton.setForeground(new java.awt.Color(255, 255, 255));
        experiencesearchbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/employee/search (1).png"))); // NOI18N
        experiencesearchbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                experiencesearchbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout experiencelistLayout = new javax.swing.GroupLayout(experiencelist);
        experiencelist.setLayout(experiencelistLayout);
        experiencelistLayout.setHorizontalGroup(
            experiencelistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, experiencelistLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(experiencelistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(experiencelistLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(experiencelistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(experiencelistLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel3)
                                .addGap(12, 12, 12)
                                .addComponent(experiencedurationdropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, experiencelistLayout.createSequentialGroup()
                                .addGroup(experiencelistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                                    .addComponent(companynameinput))
                                .addGap(24, 24, 24)))
                        .addComponent(experiencedeletebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, experiencelistLayout.createSequentialGroup()
                        .addComponent(experiencesearchtextbox)
                        .addGap(18, 18, 18)
                        .addComponent(experiencesearchbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        experiencelistLayout.setVerticalGroup(
            experiencelistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(experiencelistLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(experiencelistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(experiencesearchtextbox, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(experiencesearchbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(experiencelistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(experiencelistLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(companynameinput, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addGroup(experiencelistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(experiencelistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2))
                            .addComponent(experiencedurationdropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(experiencelistLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(experiencedeletebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );

        ExperienceContentPanel.add(experiencelist, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 171, 720, 330));

        experiencecontinuebutton.setBackground(new java.awt.Color(0, 153, 255));
        experiencecontinuebutton.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        experiencecontinuebutton.setForeground(new java.awt.Color(255, 255, 255));
        experiencecontinuebutton.setText("Save");
        experiencecontinuebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                experiencecontinuebuttonActionPerformed(evt);
            }
        });
        ExperienceContentPanel.add(experiencecontinuebutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 620, 195, 47));

        jTabbedPane1.addTab("tab6", ExperienceContentPanel);

        jPanel2.add(jTabbedPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void setActiveState(JPanel panel,int index){
        PersonalPanel.setBackground(new Color(178,229,255));
        AcademicsPanel.setBackground(new Color(178,229,255));
        SkillsPanel.setBackground(new Color(178,229,255));
        ExperiencePanel.setBackground(new Color(178,229,255));
        ProjectsPanel.setBackground(new Color(178,229,255));
        AchivementsPanel.setBackground(new Color(178,229,255));
        switch (index) {
            case 0 -> {
                panel.setBackground(new Color(102,153,255));
                jTabbedPane1.setSelectedIndex(index);
                
            }
            case 1 -> {
                panel.setBackground(new Color(102,153,255));
                jTabbedPane1.setSelectedIndex(index);
            }
            case 2 -> {
                panel.setBackground(new Color(102,153,255));
                jTabbedPane1.setSelectedIndex(index);
            }
            case 3 -> {
                panel.setBackground(new Color(102,153,255));
                jTabbedPane1.setSelectedIndex(index);
            }
            case 4 -> {
                panel.setBackground(new Color(102,153,255));
                jTabbedPane1.setSelectedIndex(index);
            }
            case 5 -> {
                panel.setBackground(new Color(102,153,255));
                jTabbedPane1.setSelectedIndex(index);
            }
            default -> System.out.println("not a valid option");
        }
        
        
    }
    
    private void hover(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hover
//         TODO add your handling code here:
    

        PersonalPanel.addMouseListener(new MouseAdapter(){
//            @Override
//            public void mouseEntered(MouseEvent e) {
////                PersonalPanel.setBackground(new Color(153,153,255));
//            }
//            @Override
//            public void mouseExited(MouseEvent e){
////                PersonalPanel.setBackground(new Color(255,255,255));
//            }
            @Override
            public void mousePressed(MouseEvent e) {
//               jTabbedPane1.setSelectedIndex(0);
               setActiveState(PersonalPanel,0);
                 
            }
        });
        AcademicsPanel.addMouseListener(new MouseAdapter(){
//            @Override
//            public void mouseEntered(MouseEvent e) {
////                AcademicsPanel.setBackground(new Color(153,153,255));
//                
//            }
//            @Override
//            public void mouseExited(MouseEvent e){
////                AcademicsPanel.setBackground(new Color(255,255,255));
//            }
            @Override
            public void mousePressed(MouseEvent e) {
//                jTabbedPane1.setSelectedIndex(1);
                setActiveState(AcademicsPanel,1);
            }
        });
        AchivementsPanel.addMouseListener(new MouseAdapter(){
//            @Override
//            public void mouseEntered(MouseEvent e) {
////                AchivementsPanel.setBackground(new Color(153,153,255));
//            }
//            @Override
//            public void mouseExited(MouseEvent e){
////                AchivementsPanel.setBackground(new Color(255,255,255));
//            }
            @Override
            public void mousePressed(MouseEvent e) {
//                jTabbedPane1.setSelectedIndex(4);
                setActiveState(AchivementsPanel,4);
            }
        });
        SkillsPanel.addMouseListener(new MouseAdapter(){
//            @Override
//            public void mouseEntered(MouseEvent e) {
////                SkillsPanel.setBackground(new Color(153,153,255));
//            }
//            @Override
//            public void mouseExited(MouseEvent e){
////                SkillsPanel.setBackground(new Color(255,255,255));
//            }
            @Override
            public void mousePressed(MouseEvent e) {
//                jTabbedPane1.setSelectedIndex(2);
                setActiveState(SkillsPanel,2);
            }
        });
        ProjectsPanel.addMouseListener(new MouseAdapter(){
//            @Override
//            public void mouseEntered(MouseEvent e) {
////                ProjectsPanel.setBackground(new Color(153,153,255));
//            }
//            @Override
//            public void mouseExited(MouseEvent e){
////                ProjectsPanel.setBackground(new Color(255,255,255));
//            }
            @Override
            public void mousePressed(MouseEvent e) {
//                 jTabbedPane1.setSelectedIndex();
                 setActiveState(ProjectsPanel,3);
            }
        });
        ExperiencePanel.addMouseListener(new MouseAdapter(){
//            @Override
//            public void mouseEntered(MouseEvent e) {
////                ExperiencePanel.setBackground(new Color(153,153,255));
//            }
//            @Override
//            public void mouseExited(MouseEvent e){
////                ExperiencePanel.setBackground(new Color(255,255,255));
//            }
            @Override
            public void mousePressed(MouseEvent e) {
//                jTabbedPane1.setSelectedIndex(5);
                setActiveState(ExperiencePanel,5);
            }
        });
        
    }//GEN-LAST:event_hover

    private void personalcontinuebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personalcontinuebuttonActionPerformed
        // TODO add your handling code here:
        if(chk1){

        try{
            String fname=firstnameinput.getText();
            String lname=lastnameinput.getText();
            String email=emailinput.getText();
            String github=githuburlinput.getText();
            String linkedin=linkdininput.getText();
            String phone=phoneinput.getText();

            Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resume?useSSL=false","root","pavan123");

           PreparedStatement ps;
           String query="insert into personal(cvid,fname,lname,email,github,linkedln,phone) values(?,?,?,?,?,?,?)";
           ps=con.prepareStatement(query);
           ps.setInt(1, cvid);
           ps.setString(2, fname);
           ps.setString(3, lname);
           ps.setString(4, email);
           ps.setString(5, github);
           ps.setString(6, linkedin);
           ps.setString(7, phone);


          int count =ps.executeUpdate();

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        }


        else{


            try{
                String fname=firstnameinput.getText();
                String lname=lastnameinput.getText();
                String email=emailinput.getText();
                String github=githuburlinput.getText();
                String linkedin=linkdininput.getText();
                String phone=phoneinput.getText();

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resume?useSSL=false","root","pavan123");

                //search for pid
               Statement ps1 = con.createStatement();
               String query1="select * from personal where cvid="+cvid;

               ResultSet rs=ps1.executeQuery(query1);
               int pid=0;
               if(rs.next()){
                    pid=rs.getInt(1);
               }

                PreparedStatement ps;
               // String query="update personal set(cvid,fname,lname,email,github,linkedln) values(?,?,?,?,?,?) where pid="+pid;
                String query="update personal set cvid=?,fname=?,lname=?,email=?,github=?,linkedln=?,phone=? where pid="+pid;
                ps=con.prepareStatement(query);
                ps.setInt(1, cvid);
                ps.setString(2, fname);
                ps.setString(3, lname);
                ps.setString(4, email);
                ps.setString(5, github);
                ps.setString(6, linkedin);
                ps.setString(7, phone);

                int count =ps.executeUpdate();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        setActiveState(AcademicsPanel,1);
    }//GEN-LAST:event_personalcontinuebuttonActionPerformed

    private void academicscontinuebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_academicscontinuebuttonActionPerformed
        // TODO add your handling code here:
        if(chk2){

        try{
            String pcname=puccollagenameinput.getText();
            String pcboard=pucboardinput.getText();
            String pcpercentage=pucpercentageinput.getText();
            String pccourse=puccourseinput.getText();
            String pcyear=pucyearinput.getText();
            String dcname=degreecollageinput.getText();
            String dcboard=degreeboardinput.getText();
            String dccgpa=degreecgpainput.getText();
            String dccourse=degreecourseinput.getText();
            String dcyear=degreeyearinput.getText();

            Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resume?useSSL=false","root","pavan123");

           PreparedStatement ps6;
           String query="insert into academics(cvid,pcname,pcboard,pcpercentage,pccourse,pcyear,dcname,dcboard,dccgpa,dccourse,dcyear) values(?,?,?,?,?,?,?,?,?,?,?)";
           ps6=con.prepareStatement(query);
           ps6.setInt(1, cvid);
           ps6.setString(2, pcname);
           ps6.setString(3, pcboard);
           ps6.setString(4, pcpercentage);
           ps6.setString(5, pccourse);
           ps6.setString(6, pcyear);
           ps6.setString(7, dcname);
           ps6.setString(8, dcboard);
           ps6.setString(9, dccgpa);
           ps6.setString(10, dccourse);
           ps6.setString(11, dcyear);


          int count =ps6.executeUpdate();

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        }


        else{


          try{
            String pcname=puccollagenameinput.getText();
            String pcboard=pucboardinput.getText();
            String pcpercentage=pucpercentageinput.getText();
            String pccourse=puccourseinput.getText();
            String pcyear=pucyearinput.getText();
            String dcname=degreecollageinput.getText();
            String dcboard=degreeboardinput.getText();
            String dccgpa=degreecgpainput.getText();
            String dccourse=degreecourseinput.getText();
            String dcyear=degreeyearinput.getText();

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resume?useSSL=false","root","pavan123");

                //search for aid
               Statement ps7 = con.createStatement();
               String query1="select * from academics where cvid="+cvid;

               ResultSet rs5=ps7.executeQuery(query1);
               int aid=0;
               if(rs5.next()){
                    aid=rs5.getInt(1);
               }

                PreparedStatement ps3;
               // String query="update personal set(cvid,fname,lname,email,github,linkedln) values(?,?,?,?,?,?) where pid="+aid;
                String query="update academics set cvid=?,pcname=?,pcboard=?,pcpercentage=?,pccourse=?,pcyear=? ,dcname=?,dcboard=?,dccgpa=?,dccourse=?,dcyear=? where aid="+aid;
                ps3=con.prepareStatement(query);
                ps3.setInt(1, cvid);
                ps3.setString(2, pcname);
                ps3.setString(3, pcboard);
                ps3.setString(4, pcpercentage);
                ps3.setString(5, pccourse);
                ps3.setString(6, pcyear);
                ps3.setString(7, dcname);
                ps3.setString(8, dcboard);
                ps3.setString(9, dccgpa);
                ps3.setString(10, dccourse);
                ps3.setString(11, dcyear);

                int count1 =ps3.executeUpdate();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }

        setActiveState(SkillsPanel,2);
        
    }//GEN-LAST:event_academicscontinuebuttonActionPerformed

    private void skillscontinuebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skillscontinuebuttonActionPerformed
        // TODO add your handling code here:
        String skillname=skillnameinput.getText();
        String skilldesc=skilldescriptioninput.getText();
            
        if(skillname==null && skilldesc==null){
                setActiveState(ProjectsPanel,3);
        }
        else if(chk3){

        try{
            
           

            Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resume?useSSL=false","root","pavan123");

           PreparedStatement ps7;
           String query="insert into skills(cvid,skillname,skilldesc) values(?,?,?)";
           ps7=con.prepareStatement(query);
           ps7.setInt(1, cvid);
           ps7.setString(2, skillname);
           ps7.setString(3, skilldesc);


          int count =ps7.executeUpdate();
          setActiveState(ProjectsPanel,3);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e);
        }
        finally{
            chk3=false;
        }
        }
        
        
        else{


          try{
            
         

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resume?useSSL=false","root","pavan123");

                //search for aid
               Statement ps7 = con.createStatement();
               String query1="select * from skills where cvid="+cvid+" and skillname='"+skillname+"'";

               ResultSet rs5=ps7.executeQuery(query1);
               int sid=0;
               if(rs5.next()){
                    sid=rs5.getInt(1);
               }

                PreparedStatement ps3;
               // String query="update personal set(cvid,fname,lname,email,github,linkedln) values(?,?,?,?,?,?) where pid="+aid;
                String query="update skills set cvid=?,skillname=?,skilldesc=? where sid="+sid;
                ps3=con.prepareStatement(query);
                ps3.setInt(1, cvid);
                ps3.setString(2, skillname);
                ps3.setString(3, skilldesc);
          

                int count1 =ps3.executeUpdate();
                setActiveState(ProjectsPanel,3);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }

        
    }//GEN-LAST:event_skillscontinuebuttonActionPerformed

    private void skillsearchbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skillsearchbuttonActionPerformed
        // TODO add your handling code here:
        String searchinput=skillsearchtextbox.getText();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resume?useSSL=false","root","pavan123");

           Statement ps8 = con.createStatement();
           String query2="select * from skills where skillname='"+searchinput+"'";
           ResultSet rs8=ps8.executeQuery(query2);
           if(rs8.next()){
               skillnameinput.setText(rs8.getString(3));
               skilldescriptioninput.setText(rs8.getString(4));
           }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_skillsearchbuttonActionPerformed

    private void skilladdonemorebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skilladdonemorebuttonActionPerformed
        // TODO add your handling code here:

        if(chk3){
        try{
            String skillname=skillnameinput.getText();
            String skilldesc=skilldescriptioninput.getText();
           

            Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resume?useSSL=false","root","pavan123");

           PreparedStatement ps7;
           String query="insert into skills(cvid,skillname,skilldesc) values(?,?,?)";
           ps7=con.prepareStatement(query);
           ps7.setInt(1, cvid);
           ps7.setString(2, skillname);
           ps7.setString(3, skilldesc);


          int count =ps7.executeUpdate();

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e);
        }
        
        
        skillnameinput.setText(null);
        skilldescriptioninput.setText(null);
        }
        else{
            skillnameinput.setText(null);
            skilldescriptioninput.setText(null);
            chk3=true;
        }
    }//GEN-LAST:event_skilladdonemorebuttonActionPerformed

    private void skillsupdatebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skillsupdatebuttonActionPerformed
        // TODO add your handling code here:
       
        if(!skillnameinput.getText().isEmpty()){
            try{
            String skillname=skillnameinput.getText();
            String skilldesc=skilldescriptioninput.getText();
         

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resume?useSSL=false","root","pavan123");

                //search for aid
               Statement ps7 = con.createStatement();
               String query1="select * from skills where cvid="+cvid+" and skillname='"+skillname+"'";

               ResultSet rs5=ps7.executeQuery(query1);
               int sid=0;
               if(rs5.next()){
                    sid=rs5.getInt(1);
               }

                PreparedStatement ps3;
               // String query="update personal set(cvid,fname,lname,email,github,linkedln) values(?,?,?,?,?,?) where pid="+aid;
                String query="update skills set cvid=?,skillname=?,skilldesc=? where sid="+sid;
                ps3=con.prepareStatement(query);
                ps3.setInt(1, cvid);
                ps3.setString(2, skillname);
                ps3.setString(3, skilldesc);
          

                int count1 =ps3.executeUpdate();     
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
            
        }
        else{
            JOptionPane.showMessageDialog(this,"There is nothing to Update");
        }
        skillnameinput.setText(null);
        skilldescriptioninput.setText(null);
    }//GEN-LAST:event_skillsupdatebuttonActionPerformed

    private void skilldeletebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skilldeletebuttonActionPerformed
        // TODO add your handling code here:
        try{
            String skillname=skillnameinput.getText();
            String skilldesc=skilldescriptioninput.getText();
         

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resume?useSSL=false","root","pavan123");

                //search for aid
               Statement ps7 = con.createStatement();
               String query1="select * from skills where skillname='"+skillname+"'";

               ResultSet rs5=ps7.executeQuery(query1);
               int sid=0;
               if(rs5.next()){
                    sid=rs5.getInt(1);
               }

                PreparedStatement ps3;
               // String query="update personal set(cvid,fname,lname,email,github,linkedln) values(?,?,?,?,?,?) where pid="+aid;
                String query="delete from skills where sid="+sid;
                ps3=con.prepareStatement(query);
                int count1 =ps3.executeUpdate();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        skillnameinput.setText(null);
        skilldescriptioninput.setText(null);
        
    }//GEN-LAST:event_skilldeletebuttonActionPerformed

    private void projectaddonemorebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectaddonemorebuttonActionPerformed
        // TODO add your handling code here:
        if(chk4){
        try{
            String projectname=projectnameinput.getText();
            String projectdesc=projectdescriptioninput.getText();
           

            Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resume?useSSL=false","root","pavan123");

           PreparedStatement ps7;
           String query="insert into projects(cvid,projectname,projectdesc) values(?,?,?)";
           ps7=con.prepareStatement(query);
           ps7.setInt(1, cvid);
           ps7.setString(2, projectname);
           ps7.setString(3, projectdesc);


          int count =ps7.executeUpdate();

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e);
        }
        
        projectnameinput.setText(null);
        projectdescriptioninput.setText(null);
        }
        else{
            projectnameinput.setText(null);
        projectdescriptioninput.setText(null);
        chk4=true;
        }
    }//GEN-LAST:event_projectaddonemorebuttonActionPerformed

    private void ProjectsearchbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProjectsearchbuttonActionPerformed
        // TODO add your handling code here:
        String searchinput=projectsearchtextfield.getText();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resume?useSSL=false","root","pavan123");

           Statement ps8 = con.createStatement();
           String query2="select * from projects where cvid="+cvid+" and projectname='"+searchinput+"'";
           ResultSet rs8=ps8.executeQuery(query2);
           if(rs8.next()){
               projectnameinput.setText(rs8.getString(3));
               projectdescriptioninput.setText(rs8.getString(4));
           }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_ProjectsearchbuttonActionPerformed

    private void projectdeletebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectdeletebuttonActionPerformed
        // TODO add your handling code here:
        try{
            String projectname=projectnameinput.getText();
            String projectdesc=projectdescriptioninput.getText();
         

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resume?useSSL=false","root","pavan123");

                //search for aid
               Statement ps7 = con.createStatement();
               String query1="select * from projects where projectname='"+projectname+"'";

               ResultSet rs5=ps7.executeQuery(query1);
               int projectid=0;
               if(rs5.next()){
                    projectid=rs5.getInt(1);
               }

                PreparedStatement ps3;
               // String query="update personal set(cvid,fname,lname,email,github,linkedln) values(?,?,?,?,?,?) where pid="+aid;
                String query="delete from projects where projectid="+projectid;
                ps3=con.prepareStatement(query);
                int count1 =ps3.executeUpdate();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        projectnameinput.setText(null);
        projectdescriptioninput.setText(null);
    }//GEN-LAST:event_projectdeletebuttonActionPerformed

    private void projectcontinuebutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectcontinuebutton1ActionPerformed
        // TODO add your handling code here:
          String projectname=projectnameinput.getText();
            String projectdesc=projectdescriptioninput.getText();
        if(projectname==null && projectdesc==null){
            setActiveState(AchivementsPanel,4);
        }
        
        else if(chk4){

        try{
         
           

            Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resume?useSSL=false","root","pavan123");

           PreparedStatement ps7;
           String query="insert into projects(cvid,projectname,projectdesc) values(?,?,?)";
           ps7=con.prepareStatement(query);
           ps7.setInt(1, cvid);
           ps7.setString(2, projectname);
           ps7.setString(3, projectdesc);


          int count =ps7.executeUpdate();
           setActiveState(AchivementsPanel,4);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e);
        }
        finally{
            chk4=false;
        }
        }


        else{


          try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resume?useSSL=false","root","pavan123");

                //search for aid
               Statement ps7 = con.createStatement();
               String query1="select * from projects where cvid="+cvid+" and projectname='"+projectname+"'";

               ResultSet rs5=ps7.executeQuery(query1);
               int projectid=0;
               if(rs5.next()){
                    projectid=rs5.getInt(1);
               }

                PreparedStatement ps3;
               // String query="update personal set(cvid,fname,lname,email,github,linkedln) values(?,?,?,?,?,?) where pid="+aid;
                String query="update projects set cvid=?,projectname=?,projectdesc=? where projectid="+projectid;
                ps3=con.prepareStatement(query);
                ps3.setInt(1, cvid);
                ps3.setString(2, projectname);
                ps3.setString(3, projectdesc);
          
                int count1 =ps3.executeUpdate(); 
                setActiveState(AchivementsPanel,4);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }

       
    }//GEN-LAST:event_projectcontinuebutton1ActionPerformed

    private void projectupdatebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectupdatebuttonActionPerformed
        // TODO add your handling code here:
        if(!projectnameinput.getText().isEmpty()){
            try{
            String projectname=projectnameinput.getText();
            String projectdesc=projectdescriptioninput.getText();
         

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resume?useSSL=false","root","pavan123");

                //search for aid
               Statement ps7 = con.createStatement();
               String query1="select * from projects where cvid="+cvid+" and projectname='"+projectname+"'";

               ResultSet rs5=ps7.executeQuery(query1);
               int projectid=0;
               if(rs5.next()){
                    projectid=rs5.getInt(1);
               }

                PreparedStatement ps3;
               // String query="update personal set(cvid,fname,lname,email,github,linkedln) values(?,?,?,?,?,?) where pid="+aid;
                String query="update projects set cvid=?,projectname=?,projectdesc=? where projectid="+projectid;
                ps3=con.prepareStatement(query);
                ps3.setInt(1, cvid);
                ps3.setString(2, projectname);
                ps3.setString(3, projectdesc);
          

                int count1 =ps3.executeUpdate();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"There is nothing to Update");
        }
        projectnameinput.setText(null);
        projectdescriptioninput.setText(null);
    }//GEN-LAST:event_projectupdatebuttonActionPerformed

    private void achivementupdatebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_achivementupdatebuttonActionPerformed
        // TODO add your handling code here:
        if(!achivementnameinput.getText().isEmpty()){
            try{
            String achivementname=achivementnameinput.getText();
            String achivementdesc=achivementdescriptioninput.getText();
         

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resume?useSSL=false","root","pavan123");

                //search for aid
               Statement ps7 = con.createStatement();
               String query1="select * from achievements where cvid="+cvid+" and achievementname='"+achivementname+"'";

               ResultSet rs5=ps7.executeQuery(query1);
               int achieveid=0;
               if(rs5.next()){
                    achieveid=rs5.getInt(1);
               }

                PreparedStatement ps3;
               // String query="update personal set(cvid,fname,lname,email,github,linkedln) values(?,?,?,?,?,?) where pid="+aid;
                String query="update achievements set cvid=?,achievementname=?,achievementdesc=? where achievementid="+achieveid;
                ps3=con.prepareStatement(query);
                ps3.setInt(1, cvid);
                ps3.setString(2, achivementname);
                ps3.setString(3, achivementdesc);
          

                int count1 =ps3.executeUpdate();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"There is nothing to Update");
        }
        achivementnameinput.setText(null);
        achivementdescriptioninput.setText(null);
    }//GEN-LAST:event_achivementupdatebuttonActionPerformed

    private void achivementcontinuebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_achivementcontinuebuttonActionPerformed
        // TODO add your handling code here
         String achivementname=achivementnameinput.getText();
         String achivementdesc=achivementdescriptioninput.getText();
        if(achivementname==null && achivementdesc==null){
            setActiveState(ExperiencePanel,5);
        }
        
        else if(chk5){

        try{
          
           

            Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resume?useSSL=false","root","pavan123");

           PreparedStatement ps7;
           String query="insert into achievements(cvid,achievementname,achievementdesc) values(?,?,?)";
           ps7=con.prepareStatement(query);
           ps7.setInt(1, cvid);
           ps7.setString(2, achivementname);
           ps7.setString(3, achivementdesc);


          int count =ps7.executeUpdate();
          setActiveState(ExperiencePanel,5);

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e);
        }
        finally{
            chk5=false;
        }
        }


        else{


          try{
          
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resume?useSSL=false","root","pavan123");

                //search for aid
               Statement ps7 = con.createStatement();
               String query1="select * from achievements where cvid="+cvid+" and achievementname='"+achivementname+"'";

               ResultSet rs5=ps7.executeQuery(query1);
               int achieveid=0;
               if(rs5.next()){
                    achieveid=rs5.getInt(1);
               }

                PreparedStatement ps3;
               // String query="update personal set(cvid,fname,lname,email,github,linkedln) values(?,?,?,?,?,?) where pid="+aid;
                String query="update achievements set cvid=?,achievementname=?,achievementdesc=? where achievementid="+achieveid;
                ps3=con.prepareStatement(query);
                ps3.setInt(1, cvid);
                ps3.setString(2, achivementname);
                ps3.setString(3, achivementdesc);
          

                int count1 =ps3.executeUpdate();
                setActiveState(ExperiencePanel,5);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }

        
    }//GEN-LAST:event_achivementcontinuebuttonActionPerformed

    private void achivementssearchbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_achivementssearchbuttonActionPerformed
        // TODO add your handling code here:
        String searchinput=achivementssearchtextbox.getText();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resume?useSSL=false","root","pavan123");

           Statement ps8 = con.createStatement();
           String query2="select * from achievements where cvid="+cvid+" and achievementname='"+searchinput+"'";
           ResultSet rs8=ps8.executeQuery(query2);
           if(rs8.next()){
               achivementnameinput.setText(rs8.getString(3));
               achivementdescriptioninput.setText(rs8.getString(4));
           }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_achivementssearchbuttonActionPerformed

    private void achivementdeletebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_achivementdeletebuttonActionPerformed
        // TODO add your handling code here:
        try{
            String achivementname=achivementnameinput.getText();
            String achivementdesc=achivementdescriptioninput.getText();
         

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resume?useSSL=false","root","pavan123");

                //search for aid
               Statement ps7 = con.createStatement();
               String query1="select * from achievements where achievementname='"+achivementname+"'";

               ResultSet rs5=ps7.executeQuery(query1);
               int achieveid=0;
               if(rs5.next()){
                    achieveid=rs5.getInt(1);
               }

                PreparedStatement ps3;
               // String query="update personal set(cvid,fname,lname,email,github,linkedln) values(?,?,?,?,?,?) where pid="+aid;
                String query="delete from achievements where achievementid="+achieveid;
                ps3=con.prepareStatement(query);
                int count1 =ps3.executeUpdate();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        achivementnameinput.setText(null);
        achivementdescriptioninput.setText(null);
    }//GEN-LAST:event_achivementdeletebuttonActionPerformed

    private void achivementaddonemorebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_achivementaddonemorebuttonActionPerformed
        // TODO add your handling code here:
        if(chk5){
        try{
            String achivementname=achivementnameinput.getText();
            String achivementdesc=achivementdescriptioninput.getText();
           

            Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resume?useSSL=false","root","pavan123");

           PreparedStatement ps7;
           String query="insert into achievements(cvid,achievementname,achievementdesc) values(?,?,?)";
           ps7=con.prepareStatement(query);
           ps7.setInt(1, cvid);
           ps7.setString(2, achivementname);
           ps7.setString(3, achivementdesc);


          int count =ps7.executeUpdate();

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e);
        }
        
        achivementnameinput.setText(null);
        achivementdescriptioninput.setText(null);
        }
        else{
              achivementnameinput.setText(null);
        achivementdescriptioninput.setText(null);
        chk5=true;
        }
    }//GEN-LAST:event_achivementaddonemorebuttonActionPerformed

    private void experienceupdatebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_experienceupdatebuttonActionPerformed
        // TODO add your handling code here:
        if(!companynameinput.getText().isEmpty()){
            try{
            String companyname=companynameinput.getText();
            String roledesc=roledescriptioninput.getText();
            String duration=experiencedurationdropdown.getSelectedItem().toString();
         

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resume?useSSL=false","root","pavan123");

                //search for aid
               Statement ps7 = con.createStatement();
               String query1="select * from experience where cvid="+cvid+" and companyname='"+companyname+"'";

               ResultSet rs5=ps7.executeQuery(query1);
               int exid=0;
               if(rs5.next()){
                    exid=rs5.getInt(1);
               }

                PreparedStatement ps3;
               // String query="update personal set(cvid,fname,lname,email,github,linkedln) values(?,?,?,?,?,?) where pid="+aid;
                String query="update experience set cvid=?,companyname=?,experiencedesc=?,experienceduration=? where exid="+exid;
                ps3=con.prepareStatement(query);
                ps3.setInt(1, cvid);
                ps3.setString(2, companyname);
                ps3.setString(3, roledesc);
                ps3.setString(4, duration);
          

                int count1 =ps3.executeUpdate();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        companynameinput.setText(null);
        roledescriptioninput.setText(null);
        experiencedurationdropdown.setSelectedItem(null);
    }//GEN-LAST:event_experienceupdatebuttonActionPerformed

    private void experiencesearchbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_experiencesearchbuttonActionPerformed
        // TODO add your handling code here:
        String searchinput=experiencesearchtextbox.getText();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resume?useSSL=false","root","pavan123");

           Statement ps8 = con.createStatement();
           String query2="select * from experience where cvid="+cvid+" and companyname='"+searchinput+"'";
           ResultSet rs8=ps8.executeQuery(query2);
           if(rs8.next()){
               companynameinput.setText(rs8.getString(3));
               roledescriptioninput.setText(rs8.getString(4));
               experiencedurationdropdown.setSelectedItem(rs8.getString(5));
           }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_experiencesearchbuttonActionPerformed

    private void experiencedeletebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_experiencedeletebuttonActionPerformed
        // TODO add your handling code here:
        try{
            String companyname=companynameinput.getText();
            String roledesc=roledescriptioninput.getText();
            String duration=experiencedurationdropdown.getSelectedItem().toString();
         

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resume?useSSL=false","root","pavan123");

                //search for aid
               Statement ps7 = con.createStatement();
               String query1="select * from experience where companyname='"+companyname+"'";

               ResultSet rs5=ps7.executeQuery(query1);
               int exid=0;
               if(rs5.next()){
                    exid=rs5.getInt(1);
               }

                PreparedStatement ps3;
               // String query="update personal set(cvid,fname,lname,email,github,linkedln) values(?,?,?,?,?,?) where pid="+aid;
                String query="delete from experience where exid="+exid;
                ps3=con.prepareStatement(query);
                int count1 =ps3.executeUpdate();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        companynameinput.setText(null);
        roledescriptioninput.setText(null);
        experiencedurationdropdown.setSelectedItem(null);
    }//GEN-LAST:event_experiencedeletebuttonActionPerformed

    private void experienceaddonemorebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_experienceaddonemorebuttonActionPerformed
        // TODO add your handling code here:
        if(chk6){
        try{
            String companyname=companynameinput.getText();
            String roledesc=roledescriptioninput.getText();
            String duration=experiencedurationdropdown.getSelectedItem().toString();
           

            Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resume?useSSL=false","root","pavan123");

           PreparedStatement ps7;
           String query="insert into experience(cvid,companyname,experiencedesc,experienceduration) values(?,?,?,?)";
           ps7=con.prepareStatement(query);
           ps7.setInt(1, cvid);
           ps7.setString(2, companyname);
           ps7.setString(3, roledesc);
           ps7.setString(4, duration);


          int count =ps7.executeUpdate();

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e);
        }
        
        companynameinput.setText(null);
        roledescriptioninput.setText(null);
        experiencedurationdropdown.setSelectedItem(null);
        }
        else{
            companynameinput.setText(null);
        roledescriptioninput.setText(null);
        experiencedurationdropdown.setSelectedItem(null);
        chk6=true;
        }
    }//GEN-LAST:event_experienceaddonemorebuttonActionPerformed

    private void experiencecontinuebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_experiencecontinuebuttonActionPerformed
        // TODO add your handling code here
        String companyname=companynameinput.getText();
            String roledesc=roledescriptioninput.getText();
            String duration=experiencedurationdropdown.getSelectedItem().toString();
           
        if(companyname==null && roledesc==null || duration==null){
            
        }
        else if(chk6){

        try{
           

            Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resume?useSSL=false","root","pavan123");

           PreparedStatement ps7;
           String query="insert into experience(cvid,companyname,experiencedesc,experienceduration) values(?,?,?,?)";
           ps7=con.prepareStatement(query);
           ps7.setInt(1, cvid);
           ps7.setString(2, companyname);
           ps7.setString(3, roledesc);
           ps7.setString(4, duration);


          int count =ps7.executeUpdate();

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e);
        }
        finally{
            chk6=false;
        }
        }


        else{


          try{
            

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resume?useSSL=false","root","pavan123");

                //search for aid
               Statement ps7 = con.createStatement();
               String query1="select * from experience where cvid="+cvid+" and companyname='"+companyname+"'";

               ResultSet rs5=ps7.executeQuery(query1);
               int exid=0;
               if(rs5.next()){
                    exid=rs5.getInt(1);
               }

                PreparedStatement ps3;
               // String query="update personal set(cvid,fname,lname,email,github,linkedln) values(?,?,?,?,?,?) where pid="+aid;
                String query="update achievements set cvid=?,,companyname=?,experiencedesc=?,experienceduration=? where exid="+exid;
                ps3=con.prepareStatement(query);
                ps3.setInt(1, cvid);
                ps3.setString(2, companyname);
           ps3.setString(3, roledesc);
           ps3.setString(4, duration);
          

                int count1 =ps3.executeUpdate();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        JOptionPane.showMessageDialog(this, "Saved Successfully");
    }//GEN-LAST:event_experiencecontinuebuttonActionPerformed

    private void emailinputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailinputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailinputActionPerformed

    private void SignoutbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignoutbuttonActionPerformed
        // TODO add your handling code here:
        dispose();
        Userprofile user=new Userprofile(id);
        user.show();
    }//GEN-LAST:event_SignoutbuttonActionPerformed

    private void createresumebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createresumebuttonActionPerformed
        // TODO add your handling code here:
        dispose();
        ResumeGenerator rg=new ResumeGenerator(id,cvid);
        rg.show();
    }//GEN-LAST:event_createresumebuttonActionPerformed

    private void firstnameinputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstnameinputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstnameinputActionPerformed

    private void experiencedurationdropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_experiencedurationdropdownActionPerformed
         // TODO add your handling code here:
    }//GEN-LAST:event_experiencedurationdropdownActionPerformed

    private void phoneinputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneinputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneinputActionPerformed
    
    
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
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
     
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Homepage().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AcademicContentPanel;
    private javax.swing.JLabel AcademicsLabel;
    private javax.swing.JPanel AcademicsPanel;
    private javax.swing.JPanel AchivementsContentPanel;
    private javax.swing.JLabel AchivementsLabel;
    private javax.swing.JPanel AchivementsPanel;
    private javax.swing.JPanel ExperienceContentPanel;
    private javax.swing.JLabel ExperienceLabel;
    private javax.swing.JPanel ExperiencePanel;
    private javax.swing.JPanel PersonalContentPanel;
    private javax.swing.JLabel PersonalLabel;
    private javax.swing.JPanel PersonalPanel;
    private javax.swing.JLabel PrajectsLabel;
    private javax.swing.JPanel ProjectsContentPanel;
    private javax.swing.JPanel ProjectsPanel;
    private javax.swing.JButton Projectsearchbutton;
    private javax.swing.JButton Signoutbutton;
    private javax.swing.JPanel SkillsContentPanel;
    private javax.swing.JLabel SkillsLabel;
    private javax.swing.JPanel SkillsPanel;
    private javax.swing.JButton academicscontinuebutton;
    private javax.swing.JButton achivementaddonemorebutton;
    private javax.swing.JButton achivementcontinuebutton;
    private javax.swing.JButton achivementdeletebutton;
    private javax.swing.JTextArea achivementdescriptioninput;
    private javax.swing.JTextField achivementnameinput;
    private javax.swing.JButton achivementssearchbutton;
    private javax.swing.JTextField achivementssearchtextbox;
    private javax.swing.JButton achivementupdatebutton;
    private java.awt.Canvas canvas1;
    private javax.swing.JTextField companynameinput;
    private javax.swing.JButton createresumebutton;
    private javax.swing.JTextField degreeboardinput;
    private javax.swing.JTextField degreecgpainput;
    private javax.swing.JTextField degreecollageinput;
    private javax.swing.JTextField degreecourseinput;
    private javax.swing.JTextField degreeyearinput;
    private javax.swing.JTextField emailinput;
    private javax.swing.JButton experienceaddonemorebutton;
    private javax.swing.JButton experiencecontinuebutton;
    private javax.swing.JButton experiencedeletebutton;
    private javax.swing.JComboBox<String> experiencedurationdropdown;
    private javax.swing.JPanel experiencelist;
    private javax.swing.JButton experiencesearchbutton;
    private javax.swing.JTextField experiencesearchtextbox;
    private javax.swing.JButton experienceupdatebutton;
    private javax.swing.JTextField firstnameinput;
    private javax.swing.JTextField githuburlinput;
    private javax.swing.JButton jButton12;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField lastnameinput;
    private javax.swing.JTextField linkdininput;
    private javax.swing.JButton personalcontinuebutton;
    private javax.swing.JTextField phoneinput;
    private javax.swing.JButton projectaddonemorebutton;
    private javax.swing.JButton projectcontinuebutton1;
    private javax.swing.JButton projectdeletebutton;
    private javax.swing.JTextArea projectdescriptioninput;
    private javax.swing.JTextField projectnameinput;
    private javax.swing.JTextField projectsearchtextfield;
    private javax.swing.JButton projectupdatebutton;
    private javax.swing.JTextField pucboardinput;
    private javax.swing.JTextField puccollagenameinput;
    private javax.swing.JTextField puccourseinput;
    private javax.swing.JTextField pucpercentageinput;
    private javax.swing.JTextField pucyearinput;
    private javax.swing.JTextArea roledescriptioninput;
    private javax.swing.JButton skilladdonemorebutton;
    private javax.swing.JButton skilldeletebutton;
    private javax.swing.JTextArea skilldescriptioninput;
    private javax.swing.JTextField skillnameinput;
    private javax.swing.JButton skillscontinuebutton;
    private javax.swing.JButton skillsearchbutton;
    private javax.swing.JTextField skillsearchtextbox;
    private javax.swing.JButton skillsupdatebutton;
    // End of variables declaration//GEN-END:variables
        
}
