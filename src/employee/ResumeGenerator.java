/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package employee;

/**
 *
 * @author prax
 */
public class ResumeGenerator extends javax.swing.JFrame {

    /**
     * Creates new form ResumeGenerator
     */
    public ResumeGenerator() {
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Lnamelabel = new javax.swing.JLabel();
        Fnamelabel1 = new javax.swing.JLabel();
        githuburllabel = new javax.swing.JLabel();
        Linkedinurllabel = new javax.swing.JLabel();
        Phonelabel = new javax.swing.JLabel();
        Phonelabel1 = new javax.swing.JLabel();
        Lnamelabel1 = new javax.swing.JLabel();
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
        AcademicList = new javax.swing.JList<>();
        ProjectList = new javax.swing.JList<>();
        ExperienceList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(17, 71, 124));

        Lnamelabel.setFont(new java.awt.Font("Noto Sans Mono", 1, 36)); // NOI18N
        Lnamelabel.setForeground(new java.awt.Color(255, 255, 255));
        Lnamelabel.setText("lname");

        Fnamelabel1.setFont(new java.awt.Font("Noto Sans Mono", 1, 36)); // NOI18N
        Fnamelabel1.setForeground(new java.awt.Color(255, 255, 255));
        Fnamelabel1.setText("fname");

        githuburllabel.setForeground(new java.awt.Color(255, 255, 255));
        githuburllabel.setText("githuburllabel");

        Linkedinurllabel.setForeground(new java.awt.Color(255, 255, 255));
        Linkedinurllabel.setText("linkedinurl");

        Phonelabel.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        Phonelabel.setForeground(new java.awt.Color(255, 255, 255));
        Phonelabel.setText("Phone");

        Phonelabel1.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        Phonelabel1.setForeground(new java.awt.Color(255, 255, 255));
        Phonelabel1.setText("mail");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Phonelabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(githuburllabel))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Phonelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Linkedinurllabel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(47, 47, 47))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Fnamelabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Lnamelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(415, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Linkedinurllabel)
                    .addComponent(Phonelabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(githuburllabel)
                    .addComponent(Phonelabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lnamelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Fnamelabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 170));

        Lnamelabel1.setFont(new java.awt.Font("Noto Sans Mono", 1, 24)); // NOI18N
        Lnamelabel1.setForeground(new java.awt.Color(0, 51, 102));
        Lnamelabel1.setText("Skills");
        jPanel1.add(Lnamelabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 94, 40));

        underlinepanel.setBackground(new java.awt.Color(102, 102, 102));
        underlinepanel.setPreferredSize(new java.awt.Dimension(730, 2));

        javax.swing.GroupLayout underlinepanelLayout = new javax.swing.GroupLayout(underlinepanel);
        underlinepanel.setLayout(underlinepanelLayout);
        underlinepanelLayout.setHorizontalGroup(
            underlinepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        underlinepanelLayout.setVerticalGroup(
            underlinepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel1.add(underlinepanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 202, 350, -1));

        Lnamelabel4.setFont(new java.awt.Font("Noto Sans Mono", 1, 24)); // NOI18N
        Lnamelabel4.setForeground(new java.awt.Color(0, 51, 102));
        Lnamelabel4.setText("Achievements");
        jPanel1.add(Lnamelabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 730, 170, -1));

        underlinepanel1.setBackground(new java.awt.Color(102, 102, 102));
        underlinepanel1.setPreferredSize(new java.awt.Dimension(730, 2));

        javax.swing.GroupLayout underlinepanel1Layout = new javax.swing.GroupLayout(underlinepanel1);
        underlinepanel1.setLayout(underlinepanel1Layout);
        underlinepanel1Layout.setHorizontalGroup(
            underlinepanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        underlinepanel1Layout.setVerticalGroup(
            underlinepanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel1.add(underlinepanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 360, -1));

        Lnamelabel5.setFont(new java.awt.Font("Noto Sans Mono", 1, 24)); // NOI18N
        Lnamelabel5.setForeground(new java.awt.Color(0, 51, 102));
        Lnamelabel5.setText("Academics");
        jPanel1.add(Lnamelabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 130, 30));

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

        jPanel1.add(underlinepanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 350, -1));

        Lnamelabel6.setFont(new java.awt.Font("Noto Sans Mono", 1, 24)); // NOI18N
        Lnamelabel6.setForeground(new java.awt.Color(0, 51, 102));
        Lnamelabel6.setText("Projects");
        jPanel1.add(Lnamelabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 200, -1));

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

        jPanel1.add(underlinepanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 480, 360, -1));

        Lnamelabel7.setFont(new java.awt.Font("Noto Sans Mono", 1, 24)); // NOI18N
        Lnamelabel7.setForeground(new java.awt.Color(0, 51, 102));
        Lnamelabel7.setText("Experience");
        jPanel1.add(Lnamelabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 450, 140, -1));

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

        jPanel1.add(underlinepanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 760, 740, -1));

        AchivementList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jPanel1.add(AchivementList, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 770, 740, 210));

        SkillsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jPanel1.add(SkillsList, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 350, 230));

        AcademicList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jPanel1.add(AcademicList, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 350, 230));

        ProjectList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jPanel1.add(ProjectList, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 350, 230));

        ExperienceList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jPanel1.add(ExperienceList, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 490, 350, 230));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, -1, 1000));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JList<String> AcademicList;
    private javax.swing.JList<String> AchivementList;
    private javax.swing.JList<String> ExperienceList;
    private javax.swing.JLabel Fnamelabel1;
    private javax.swing.JLabel Linkedinurllabel;
    private javax.swing.JLabel Lnamelabel;
    private javax.swing.JLabel Lnamelabel1;
    private javax.swing.JLabel Lnamelabel4;
    private javax.swing.JLabel Lnamelabel5;
    private javax.swing.JLabel Lnamelabel6;
    private javax.swing.JLabel Lnamelabel7;
    private javax.swing.JLabel Phonelabel;
    private javax.swing.JLabel Phonelabel1;
    private javax.swing.JList<String> ProjectList;
    private javax.swing.JList<String> SkillsList;
    private javax.swing.JLabel githuburllabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel underlinepanel;
    private javax.swing.JPanel underlinepanel1;
    private javax.swing.JPanel underlinepanel2;
    private javax.swing.JPanel underlinepanel3;
    private javax.swing.JPanel underlinepanel5;
    // End of variables declaration//GEN-END:variables
}