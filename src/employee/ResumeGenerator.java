/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package employee;

import java.awt.AWTException;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.List;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author prax an pavan
 */
public class ResumeGenerator extends javax.swing.JFrame {

    /**
     * Creates new form ResumeGenerator
     */
    private int cvid;
    private int rid;
    private int redirect=0;
    String []strings=null;
    DefaultListModel  skillmodel=new DefaultListModel ();
    JList skillList;
    
     public ResumeGenerator(int rid,int cvid,int redirect) {
        this.redirect=redirect;
        this.cvid=cvid;
        this.rid=rid;
      
        initComponents();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resume?useSSL=false","root","pavan123");

           Statement ps1 = con.createStatement();
           Statement ps2=con.createStatement();
           Statement ps3=con.createStatement();
           Statement ps4=con.createStatement();
           Statement ps5=con.createStatement();
           Statement ps6=con.createStatement();
           Statement ps7=con.createStatement();
           
           String query1="select * from personal where cvid="+cvid;
           String query2="select * from academics where cvid="+cvid;
           String query3="select * from skills where cvid="+cvid;
           String query4="select * from projects where cvid="+cvid;
           String query5="select * from achievements where cvid="+cvid;
           String query6="select * from experience where cvid="+cvid;
           String query7="select * from register where rid="+rid;

           ResultSet rs1=ps1.executeQuery(query1);
           ResultSet rs2=ps2.executeQuery(query2);
           ResultSet rs3=ps3.executeQuery(query3);
           ResultSet rs4=ps4.executeQuery(query4);
           ResultSet rs5=ps5.executeQuery(query5);
           ResultSet rs6=ps6.executeQuery(query6);
           ResultSet rs7=ps7.executeQuery(query7);
           
           
           //fetch personal content
           if(rs1.next()){
               Fnamelabel1.setText(rs1.getString(3));
               Lnamelabel.setText(rs1.getString(4));
               email.setText(rs1.getString(5));
               Githuburllabel.setText(rs1.getString(6));
               Linkedinurllabel.setText(rs1.getString(7));
           }
           if(rs7.next()){
               phone.setText(rs7.getString(4));
           }
           
           //fetch academics content
           if(rs2.next()){
               pcname.setText(rs2.getString(3));
               pcboard.setText(rs2.getString(4));
               pcpercentage.setText(rs2.getString(5));
               pccourse.setText(rs2.getString(6));
               pcyear.setText(rs2.getString(7));
               dcname.setText(rs2.getString(8));
               dcboard.setText(rs2.getString(9));
               dccgpa.setText(rs2.getString(10));
               dccourse.setText(rs2.getString(11));
               dcyear.setText(rs2.getString(12));
               
           }
           
           
           
           
          //fetch skills contents
        ArrayList<String> skillList = new ArrayList<String>();
        
        while(rs3.next()){
            String s1=rs3.getString(3);
            
            String s2=rs3.getString(4);
            String s3="<html>&bull;<b>"+s1+"</b><br>&nbsp;&nbsp;"+s2+"</html>";
            skillList.add(s3);
        }
        
        SkillsList.setModel(new javax.swing.AbstractListModel<String>() {
            
            public int getSize() { return skillList.size(); }
            public String getElementAt(int i) { return skillList.get(i); }
        });
        
        
        
        
        //fetch projects contents
        ArrayList<String> projectList = new ArrayList<String>();
        
        while(rs4.next()){
            String s1=rs4.getString(3);
            String s2=rs4.getString(4);
            String s3="<html>&bull;<b>"+s1+"</b><br>&nbsp;&nbsp;"+s2+"</html>";
            projectList.add(s3);
        }
        ProjectList.setModel(new javax.swing.AbstractListModel<String>() {
            public int getSize() { return projectList.size(); }
            public String getElementAt(int i) { return projectList.get(i); }
        });
        
        
        
        //fetch achievements contents
        ArrayList<String> achievementList = new ArrayList<String>();
        
        while(rs5.next()){
            String s1=rs5.getString(3);
            String s2=rs5.getString(4);
            String s3="<html>&bull;<b>"+s1+"</b><br>&nbsp;&nbsp;"+s2+"</html>";
            achievementList.add(s3);
        }
        AchivementList.setModel(new javax.swing.AbstractListModel<String>() {
            public int getSize() { return achievementList.size(); }
            public String getElementAt(int i) { return achievementList.get(i); }
        });
        
        
        
        //fetch experience contents
        ArrayList<String> experinceList = new ArrayList<String>();
        
        while(rs6.next()){
            String s1=rs6.getString(3);
            String s2=rs6.getString(4);
            String s3="<html>&bull;<b>"+s1+"</b><br>&nbsp;&nbsp;"+s2+"</html>";
            experinceList.add(s3);
        }
        ExperienceList.setModel(new javax.swing.AbstractListModel<String>() {
            public int getSize() { return experinceList.size(); }
            public String getElementAt(int i) { return experinceList.get(i); }
        });
        
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
    public ResumeGenerator(int rid,int cvid) {
        this.cvid=cvid;
        this.rid=rid;
      
        initComponents();
       
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/resume?useSSL=false","root","pavan123");

           Statement ps1 = con.createStatement();
           Statement ps2=con.createStatement();
           Statement ps3=con.createStatement();
           Statement ps4=con.createStatement();
           Statement ps5=con.createStatement();
           Statement ps6=con.createStatement();
           Statement ps7=con.createStatement();
           
           String query1="select * from personal where cvid="+cvid;
           String query2="select * from academics where cvid="+cvid;
           String query3="select * from skills where cvid="+cvid;
           String query4="select * from projects where cvid="+cvid;
           String query5="select * from achievements where cvid="+cvid;
           String query6="select * from experience where cvid="+cvid;
           String query7="select * from register where rid="+rid;

           ResultSet rs1=ps1.executeQuery(query1);
           ResultSet rs2=ps2.executeQuery(query2);
           ResultSet rs3=ps3.executeQuery(query3);
           ResultSet rs4=ps4.executeQuery(query4);
           ResultSet rs5=ps5.executeQuery(query5);
           ResultSet rs6=ps6.executeQuery(query6);
           ResultSet rs7=ps7.executeQuery(query7);
           
           
           //fetch personal content
           if(rs1.next()){
               Fnamelabel1.setText(rs1.getString(3));
               Lnamelabel.setText(rs1.getString(4));
               email.setText(rs1.getString(5));
               Githuburllabel.setText(rs1.getString(6));
               Linkedinurllabel.setText(rs1.getString(7));
           }
           if(rs7.next()){
               phone.setText(rs7.getString(4));
           }
           
           //fetch academics content
           if(rs2.next()){
               pcname.setText(rs2.getString(3));
               pcboard.setText(rs2.getString(4));
               pcpercentage.setText(rs2.getString(5));
               pccourse.setText(rs2.getString(6));
               pcyear.setText(rs2.getString(7));
               dcname.setText(rs2.getString(8));
               dcboard.setText(rs2.getString(9));
               dccgpa.setText(rs2.getString(10));
               dccourse.setText(rs2.getString(11));
               dcyear.setText(rs2.getString(12));
               
           }
           
           
           
           
          //fetch skills contents
        ArrayList<String> skillList = new ArrayList<String>();
        
        while(rs3.next()){
            String s1=rs3.getString(3);
            
            String s2=rs3.getString(4);
            String s3="<html>&bull;<b>"+s1+"</b><br>&nbsp;&nbsp;"+s2+"</html>";
            skillList.add(s3);
        }
        
        SkillsList.setModel(new javax.swing.AbstractListModel<String>() {
            
            public int getSize() { return skillList.size(); }
            public String getElementAt(int i) { return skillList.get(i); }
        });
        
        
        
        
        //fetch projects contents
        ArrayList<String> projectList = new ArrayList<String>();
        
        while(rs4.next()){
            String s1=rs4.getString(3);
            String s2=rs4.getString(4);
            String s3="<html>&bull;<b>"+s1+"</b><br>&nbsp;&nbsp;"+s2+"</html>";
            projectList.add(s3);
        }
        ProjectList.setModel(new javax.swing.AbstractListModel<String>() {
            public int getSize() { return projectList.size(); }
            public String getElementAt(int i) { return projectList.get(i); }
        });
        
        
        
        //fetch achievements contents
        ArrayList<String> achievementList = new ArrayList<String>();
        
        while(rs5.next()){
            String s1=rs5.getString(3);
            String s2=rs5.getString(4);
            String s3="<html>&bull;<b>"+s1+"</b><br>&nbsp;&nbsp;"+s2+"</html>";
            achievementList.add(s3);
        }
        AchivementList.setModel(new javax.swing.AbstractListModel<String>() {
            public int getSize() { return achievementList.size(); }
            public String getElementAt(int i) { return achievementList.get(i); }
        });
        
        
        
        //fetch experience contents
        ArrayList<String> experinceList = new ArrayList<String>();
        
        while(rs6.next()){
            String s1=rs6.getString(3);
            String s2=rs6.getString(4);
            String s3="<html>&bull;<b>"+s1+"</b><br>&nbsp;&nbsp;"+s2+"</html>";
            experinceList.add(s3);
        }
        ExperienceList.setModel(new javax.swing.AbstractListModel<String>() {
            public int getSize() { return experinceList.size(); }
            public String getElementAt(int i) { return experinceList.get(i); }
        });
        
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }

    
    public ResumeGenerator() {
    }
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        resumePanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Lnamelabel = new javax.swing.JLabel();
        Fnamelabel1 = new javax.swing.JLabel();
        githuburllabel1 = new javax.swing.JLabel();
        Linkedinurllabel = new javax.swing.JLabel();
        phone = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        Linkedinurllabel2 = new javax.swing.JLabel();
        Githuburllabel = new javax.swing.JLabel();
        Phonelabel2 = new javax.swing.JLabel();
        email2 = new javax.swing.JLabel();
        skillsLabel = new javax.swing.JLabel();
        underlinepanel = new javax.swing.JPanel();
        Lnamelabel4 = new javax.swing.JLabel();
        underlinepanel1 = new javax.swing.JPanel();
        Lnamelabel5 = new javax.swing.JLabel();
        underlinepanel2 = new javax.swing.JPanel();
        Lnamelabel6 = new javax.swing.JLabel();
        underlinepanel3 = new javax.swing.JPanel();
        Lnamelabel7 = new javax.swing.JLabel();
        underlinepanel5 = new javax.swing.JPanel();
        AchivementList = new javax.swing.JList<>();
        SkillsList = new javax.swing.JList<>();
        ProjectList = new javax.swing.JList<>();
        ExperienceList = new javax.swing.JList<>();
        dccourse = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        dcname = new javax.swing.JLabel();
        dcyear = new javax.swing.JLabel();
        dccgpa = new javax.swing.JLabel();
        dccgpa2 = new javax.swing.JLabel();
        pcpercentage = new javax.swing.JLabel();
        dccgpa4 = new javax.swing.JLabel();
        dcstd1 = new javax.swing.JLabel();
        pcname = new javax.swing.JLabel();
        pcyear = new javax.swing.JLabel();
        pccourse = new javax.swing.JLabel();
        dccgpa5 = new javax.swing.JLabel();
        dcstd2 = new javax.swing.JLabel();
        dcboard = new javax.swing.JLabel();
        pcboard = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        print = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1920, 1400));
        setPreferredSize(new java.awt.Dimension(1920, 1400));

        resumePanel.setBackground(new java.awt.Color(255, 255, 255));
        resumePanel.setMaximumSize(new java.awt.Dimension(790, 980));
        resumePanel.setPreferredSize(new java.awt.Dimension(790, 1080));
        resumePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(17, 71, 124));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lnamelabel.setFont(new java.awt.Font("Noto Sans Mono", 1, 36)); // NOI18N
        Lnamelabel.setForeground(new java.awt.Color(255, 255, 255));
        Lnamelabel.setText("lname");
        jPanel3.add(Lnamelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 260, 67));

        Fnamelabel1.setFont(new java.awt.Font("Noto Sans Mono", 1, 36)); // NOI18N
        Fnamelabel1.setForeground(new java.awt.Color(255, 255, 255));
        Fnamelabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        Fnamelabel1.setText("fname");
        jPanel3.add(Fnamelabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 220, 67));

        githuburllabel1.setForeground(new java.awt.Color(255, 255, 255));
        githuburllabel1.setText("Github :");
        jPanel3.add(githuburllabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 43, -1, -1));

        Linkedinurllabel.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(Linkedinurllabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 21, 215, 16));

        phone.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        phone.setForeground(new java.awt.Color(255, 255, 255));
        phone.setText("7349156554");
        jPanel3.add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 267, 24));

        email.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        email.setForeground(new java.awt.Color(255, 255, 255));
        email.setText("pavannaik2205@gmail.com");
        jPanel3.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 51, 267, 24));

        Linkedinurllabel2.setForeground(new java.awt.Color(255, 255, 255));
        Linkedinurllabel2.setText("LinkedLn :");
        jPanel3.add(Linkedinurllabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 21, -1, -1));

        Githuburllabel.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(Githuburllabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 43, 215, 16));

        Phonelabel2.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        Phonelabel2.setForeground(new java.awt.Color(255, 255, 255));
        Phonelabel2.setText("Phone :");
        jPanel3.add(Phonelabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 21, -1, -1));

        email2.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        email2.setForeground(new java.awt.Color(255, 255, 255));
        email2.setText("Email :");
        jPanel3.add(email2, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 51, 62, -1));

        resumePanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 170));

        skillsLabel.setFont(new java.awt.Font("Noto Sans Mono", 1, 24)); // NOI18N
        skillsLabel.setForeground(new java.awt.Color(0, 51, 102));
        skillsLabel.setText("Skills");
        resumePanel.add(skillsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 94, 40));

        underlinepanel.setBackground(new java.awt.Color(102, 102, 102));
        underlinepanel.setPreferredSize(new java.awt.Dimension(730, 1));

        javax.swing.GroupLayout underlinepanelLayout = new javax.swing.GroupLayout(underlinepanel);
        underlinepanel.setLayout(underlinepanelLayout);
        underlinepanelLayout.setHorizontalGroup(
            underlinepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        underlinepanelLayout.setVerticalGroup(
            underlinepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        resumePanel.add(underlinepanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 202, 350, -1));

        Lnamelabel4.setFont(new java.awt.Font("Noto Sans Mono", 1, 24)); // NOI18N
        Lnamelabel4.setForeground(new java.awt.Color(0, 51, 102));
        Lnamelabel4.setText("Achievements");
        resumePanel.add(Lnamelabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 730, 170, -1));

        underlinepanel1.setBackground(new java.awt.Color(102, 102, 102));
        underlinepanel1.setPreferredSize(new java.awt.Dimension(730, 1));

        javax.swing.GroupLayout underlinepanel1Layout = new javax.swing.GroupLayout(underlinepanel1);
        underlinepanel1.setLayout(underlinepanel1Layout);
        underlinepanel1Layout.setHorizontalGroup(
            underlinepanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        underlinepanel1Layout.setVerticalGroup(
            underlinepanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        resumePanel.add(underlinepanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 202, 360, -1));

        Lnamelabel5.setFont(new java.awt.Font("Noto Sans Mono", 1, 24)); // NOI18N
        Lnamelabel5.setForeground(new java.awt.Color(0, 51, 102));
        Lnamelabel5.setText("Academics");
        resumePanel.add(Lnamelabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 130, 30));

        underlinepanel2.setBackground(new java.awt.Color(102, 102, 102));
        underlinepanel2.setPreferredSize(new java.awt.Dimension(730, 2));

        javax.swing.GroupLayout underlinepanel2Layout = new javax.swing.GroupLayout(underlinepanel2);
        underlinepanel2.setLayout(underlinepanel2Layout);
        underlinepanel2Layout.setHorizontalGroup(
            underlinepanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        underlinepanel2Layout.setVerticalGroup(
            underlinepanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        resumePanel.add(underlinepanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 350, -1));

        Lnamelabel6.setFont(new java.awt.Font("Noto Sans Mono", 1, 24)); // NOI18N
        Lnamelabel6.setForeground(new java.awt.Color(0, 51, 102));
        Lnamelabel6.setText("Projects");
        resumePanel.add(Lnamelabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 200, -1));

        underlinepanel3.setBackground(new java.awt.Color(102, 102, 102));
        underlinepanel3.setPreferredSize(new java.awt.Dimension(730, 2));

        javax.swing.GroupLayout underlinepanel3Layout = new javax.swing.GroupLayout(underlinepanel3);
        underlinepanel3.setLayout(underlinepanel3Layout);
        underlinepanel3Layout.setHorizontalGroup(
            underlinepanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        underlinepanel3Layout.setVerticalGroup(
            underlinepanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        resumePanel.add(underlinepanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 480, 360, -1));

        Lnamelabel7.setFont(new java.awt.Font("Noto Sans Mono", 1, 24)); // NOI18N
        Lnamelabel7.setForeground(new java.awt.Color(0, 51, 102));
        Lnamelabel7.setText("Experience");
        resumePanel.add(Lnamelabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 450, 140, -1));

        underlinepanel5.setBackground(new java.awt.Color(102, 102, 102));
        underlinepanel5.setPreferredSize(new java.awt.Dimension(730, 2));

        javax.swing.GroupLayout underlinepanel5Layout = new javax.swing.GroupLayout(underlinepanel5);
        underlinepanel5.setLayout(underlinepanel5Layout);
        underlinepanel5Layout.setHorizontalGroup(
            underlinepanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 740, Short.MAX_VALUE)
        );
        underlinepanel5Layout.setVerticalGroup(
            underlinepanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        resumePanel.add(underlinepanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 760, 740, -1));

        AchivementList.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        AchivementList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        resumePanel.add(AchivementList, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 770, 740, 160));

        SkillsList.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SkillsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        resumePanel.add(SkillsList, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 350, 230));

        ProjectList.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ProjectList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        resumePanel.add(ProjectList, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 350, 230));

        ExperienceList.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ExperienceList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        resumePanel.add(ExperienceList, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 490, 350, 230));

        dccourse.setText("Data structures, Operating Systems, DBMS. Networking");
        resumePanel.add(dccourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, 310, 20));

        label2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        label2.setText("Courses :");
        resumePanel.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, 50, 20));

        dcname.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dcname.setText("Sahyadri college of engineering and management");
        resumePanel.add(dcname, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 370, 20));

        dcyear.setText("2020 - 2024");
        resumePanel.add(dcyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 280, 90, 20));

        dccgpa.setText("10");
        resumePanel.add(dccgpa, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, 60, 20));

        dccgpa2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dccgpa2.setText("CGPA :");
        resumePanel.add(dccgpa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 40, 20));

        pcpercentage.setText("95");
        resumePanel.add(pcpercentage, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 390, 30, 20));

        dccgpa4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dccgpa4.setText("Courses :");
        resumePanel.add(dccgpa4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 370, 50, 20));

        dcstd1.setText("12th Board");
        resumePanel.add(dcstd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 350, 60, 20));

        pcname.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pcname.setText("Kendriya Vidhyalaya NO.2 Naval Base");
        resumePanel.add(pcname, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 330, 370, 20));

        pcyear.setText("2018 - 2020");
        resumePanel.add(pcyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 390, 90, 20));

        pccourse.setText("Physics, Chemistry, Biology, Mathematics");
        resumePanel.add(pccourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 370, 310, 20));

        dccgpa5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dccgpa5.setText("Percentage :");
        resumePanel.add(dccgpa5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 390, 70, 20));

        dcstd2.setText("Bachelor of Engineering");
        resumePanel.add(dcstd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 130, 20));

        dcboard.setText("2020 - 2024");
        resumePanel.add(dcboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 240, 90, 20));

        pcboard.setText("2018 - 2020");
        resumePanel.add(pcboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 350, 90, 20));

        back.setBackground(new java.awt.Color(204, 255, 255));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        print.setBackground(new java.awt.Color(255, 204, 204));
        print.setText("PRINT");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(389, 389, 389)
                .addComponent(resumePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(print, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(resumePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 948, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(138, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        
        if(redirect!=1){
            dispose();
            Homepage home=new Homepage(rid);
            home.show();
        }
        else{
            Userprofile userpage= new Userprofile(rid);
            userpage.show();
        }
    }//GEN-LAST:event_backActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        try {
            // TODO add your handling code here:
            saveImage(resumePanel);
            PDFGenerator pdf=new PDFGenerator();
            pdf.CreatePdf(cvid);
        } catch (Exception ex) {
            Logger.getLogger(ResumeGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_printActionPerformed

    private void saveImage(JPanel panel){ 
    BufferedImage imagebuf=null;
    try {
        imagebuf = new Robot().createScreenCapture(panel.bounds());
    } catch (AWTException e1) {
        e1.printStackTrace();
    }  
     Graphics2D graphics2D = imagebuf.createGraphics();
     panel.paint(graphics2D);
     try {
        String path = System.getProperty("user.home") + File.separator +"Desktop";
        
        ImageIO.write(imagebuf,"jpeg", new File(path+File.separator+"resume"+cvid+".jpeg"));
        System.out.print(path);
    } catch (Exception e) {
        System.out.println("error");
    }
     JOptionPane.showMessageDialog(rootPane, "pdf saved");
    }
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
            java.util.logging.Logger.getLogger(ResumeGenerator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResumeGenerator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResumeGenerator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResumeGenerator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResumeGenerator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> AchivementList;
    private javax.swing.JList<String> ExperienceList;
    private javax.swing.JLabel Fnamelabel1;
    private javax.swing.JLabel Githuburllabel;
    private javax.swing.JLabel Linkedinurllabel;
    private javax.swing.JLabel Linkedinurllabel2;
    private javax.swing.JLabel Lnamelabel;
    private javax.swing.JLabel Lnamelabel4;
    private javax.swing.JLabel Lnamelabel5;
    private javax.swing.JLabel Lnamelabel6;
    private javax.swing.JLabel Lnamelabel7;
    private javax.swing.JLabel Phonelabel2;
    private javax.swing.JList<String> ProjectList;
    private javax.swing.JList<String> SkillsList;
    private javax.swing.JButton back;
    private javax.swing.JLabel dcboard;
    private javax.swing.JLabel dccgpa;
    private javax.swing.JLabel dccgpa2;
    private javax.swing.JLabel dccgpa4;
    private javax.swing.JLabel dccgpa5;
    private javax.swing.JLabel dccourse;
    private javax.swing.JLabel dcname;
    private javax.swing.JLabel dcstd1;
    private javax.swing.JLabel dcstd2;
    private javax.swing.JLabel dcyear;
    private javax.swing.JLabel email;
    private javax.swing.JLabel email2;
    private javax.swing.JLabel githuburllabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel pcboard;
    private javax.swing.JLabel pccourse;
    private javax.swing.JLabel pcname;
    private javax.swing.JLabel pcpercentage;
    private javax.swing.JLabel pcyear;
    private javax.swing.JLabel phone;
    private javax.swing.JButton print;
    private javax.swing.JPanel resumePanel;
    private javax.swing.JLabel skillsLabel;
    private javax.swing.JPanel underlinepanel;
    private javax.swing.JPanel underlinepanel1;
    private javax.swing.JPanel underlinepanel2;
    private javax.swing.JPanel underlinepanel3;
    private javax.swing.JPanel underlinepanel5;
    // End of variables declaration//GEN-END:variables
}
