/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import DataModel.Module;
import gui.StudentFrame;

/**
 *
 * @author ste
 */
public class SuccessFrame extends javax.swing.JFrame {

    /**
     * Creates new form SuccessFrame
     */
    StartFrame startFrame;
    private String title;
    private String num;

    /**constructor for a new success frame initialises its properties
     *
     * @param startFrame startframe to open
     */
    public SuccessFrame(StartFrame startFrame) {
        initComponents();
        this.setSize(360, 260);
        this.setResizable(false);
        this.startFrame = startFrame;
        this.setLocationRelativeTo(null);
    }

    /**alters text on success frame based on passed parameters and sets visibility
     *
     * @param title sets title of module
     * @param code sets code of module
     */
    public void setTextModuleInfo(String title, int code) {
        this.title = title;

        this.jLabelStudentNO.setText("Module Title: " + title);

        this.jLabelfirst.setText("Module Code: " + code);
        this.jLabelM_S_BLANK.setText("Module");
        this.jLabelfpart.setVisible(false);

    }

    /**
     *alters text on success frame based on passed parameters and sets visibility
     * @param num sets student number
     * @param name sets student name
     * @param fpart sets full or part time
     * 
     */
    public void setTextStudentInfo(String num, String name, String fpart) {
        this.num = num;
        this.jLabelStudentNO.setText("Student Number: " + num);
        name.toUpperCase();
        this.jLabelfirst.setText("Name: " + name);

        this.jLabelfpart.setText("Full/Part Time: " + fpart);
        this.jLabelM_S_BLANK.setText("Student");
    }

    /**changes text of a frame  if item is added
     *
     */
    public void setTextAdd() {
        this.jLabelADDREM.setText("Added");
    }

    /**changes text of a frame if item is deleted
     *
     */
    public void setTextRem() {
        this.jLabelADDREM.setText("Deleted");
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
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelHome = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabelM_S_BLANK = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelM_S_BLANK2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelADDREM = new javax.swing.JLabel();
        jLabelfirst = new javax.swing.JLabel();
        jLabelfpart = new javax.swing.JLabel();
        jLabelStudentNO = new javax.swing.JLabel();
        jLabelfirst1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(45, 118, 232));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("SUCCESS!");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Checked_64px.png"))); // NOI18N

        jLabelHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Exit_32px.png"))); // NOI18N
        jLabelHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelHomeMousePressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 7)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("HOME");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel8MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelHome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(8, 8, 8))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabelHome)
                            .addGap(0, 0, 0)
                            .addComponent(jLabel8))
                        .addComponent(jLabel1)))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(45, 118, 232));
        jLabel2.setText("You Have");

        jLabelM_S_BLANK.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jLabelM_S_BLANK.setForeground(new java.awt.Color(45, 118, 232));
        jLabelM_S_BLANK.setText("    ");

        jLabel4.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(45, 118, 232));
        jLabel4.setText("a");

        jLabelM_S_BLANK2.setForeground(new java.awt.Color(45, 118, 232));
        jLabelM_S_BLANK2.setText("          ");

        jLabel6.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(45, 118, 232));
        jLabel6.setText(":");

        jLabelADDREM.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jLabelADDREM.setForeground(new java.awt.Color(45, 118, 232));
        jLabelADDREM.setText("         ");

        jLabelfirst.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jLabelfirst.setForeground(new java.awt.Color(45, 118, 232));
        jLabelfirst.setText("Name: ");

        jLabelfpart.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jLabelfpart.setForeground(new java.awt.Color(45, 118, 232));
        jLabelfpart.setText("Full/Part Time:");

        jLabelStudentNO.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jLabelStudentNO.setForeground(new java.awt.Color(45, 118, 232));
        jLabelStudentNO.setText("Student Number: ");

        jLabelfirst1.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        jLabelfirst1.setForeground(new java.awt.Color(45, 118, 232));
        jLabelfirst1.setText("CONTINUE>");
        jLabelfirst1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelfirst1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelfirst)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelADDREM)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelM_S_BLANK)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6)))
                                .addGap(44, 44, 44)
                                .addComponent(jLabelM_S_BLANK2))
                            .addComponent(jLabelStudentNO))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelfpart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelfirst1))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabelM_S_BLANK, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabelM_S_BLANK2)
                    .addComponent(jLabel6)
                    .addComponent(jLabelADDREM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelfirst)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelStudentNO)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelfpart)
                        .addContainerGap(27, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelfirst1))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     *
     */
    public void switchIfAdded() {
        switch (jLabelM_S_BLANK.getText()) {

            case "Student":
                StudentFrame sf = new StudentFrame(startFrame);
                sf.setVisible(true);
                this.setVisible(false);
                break;
            case "Module":
                ModuleFrame mf = new ModuleFrame(startFrame);
                mf.setVisible(true);
                this.setVisible(false);
                break;

            default:
                StartFrame strf = new StartFrame();
                strf.setVisible(true);
                this.setVisible(false);
                break;
        }
    }

    private void switchIfDeleted() {
        switch (jLabelM_S_BLANK.getText()) {

            case "Student":
                DeleteStudentFrame dsf = new DeleteStudentFrame(startFrame);
                dsf.setVisible(true);
                this.setVisible(false);

                break;
            case "Module":
                DeleteModuleFrame dmf = new DeleteModuleFrame(startFrame);
                dmf.setVisible(true);
                this.setVisible(false);
                break;
            default:
                StartFrame strf = new StartFrame();
                strf.setVisible(true);
                this.setVisible(false);
                break;
        }
    }


    private void jLabelfirst1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelfirst1MousePressed
        // TODO add your handling code here:

    this.setVisible(false);


    }//GEN-LAST:event_jLabelfirst1MousePressed

    private void jLabelHomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHomeMousePressed
        // TODO add your handling code here:
        this.setVisible(false);
    


    }//GEN-LAST:event_jLabelHomeMousePressed

    private void jLabel8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MousePressed


//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(SuccessFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(SuccessFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(SuccessFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(SuccessFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new SuccessFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelADDREM;
    private javax.swing.JLabel jLabelHome;
    private javax.swing.JLabel jLabelM_S_BLANK;
    private javax.swing.JLabel jLabelM_S_BLANK2;
    private javax.swing.JLabel jLabelStudentNO;
    private javax.swing.JLabel jLabelfirst;
    private javax.swing.JLabel jLabelfirst1;
    private javax.swing.JLabel jLabelfpart;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
