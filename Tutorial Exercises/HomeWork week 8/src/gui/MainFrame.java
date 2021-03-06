/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import components.Module;
import components.Student;

/**
 *
 * @author ste
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    private Module module; 
    private MainFrame mainFrame;
    public MainFrame() {
        initComponents();
        mainFrame = this;
    }

   
    
    public void addModule(Module newModule)
    {
        module = newModule;
    }
    
    public void addStudent (Student student)
            
    {
        if(null!= module)
        {
            module.addStudent(student);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonAddModule = new javax.swing.JButton();
        jButtonAddStudent = new javax.swing.JButton();
        jButtonPrintInfo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonAddModule.setText("Add Module");
        jButtonAddModule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddModuleActionPerformed(evt);
            }
        });

        jButtonAddStudent.setText("Add Student");
        jButtonAddStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddStudentActionPerformed(evt);
            }
        });

        jButtonPrintInfo.setText("Print Module Info");
        jButtonPrintInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrintInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButtonAddStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButtonAddModule, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
            .addComponent(jButtonPrintInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButtonAddStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAddModule, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonPrintInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPrintInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrintInfoActionPerformed
        // TODO add your handling code here:
        
        if ( null != module)
        {
            module.printModule();
            
        }
    }//GEN-LAST:event_jButtonPrintInfoActionPerformed

    private void jButtonAddModuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddModuleActionPerformed
        // TODO add your handling code here:
        ModuleFrame mf = new ModuleFrame(mainFrame);
        mf.setVisible(true);
    }//GEN-LAST:event_jButtonAddModuleActionPerformed

    private void jButtonAddStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddStudentActionPerformed
        // TODO add your handling code here:
        StudentFrame sf = new StudentFrame(mainFrame);
        sf.setVisible(true);
    }//GEN-LAST:event_jButtonAddStudentActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddModule;
    private javax.swing.JButton jButtonAddStudent;
    private javax.swing.JButton jButtonPrintInfo;
    // End of variables declaration//GEN-END:variables
}
