
package or;

import config.config;
import static config.passwordHasher.hashPassword;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import javax.swing.JOptionPane;


public class forgotpass extends javax.swing.JFrame {

    
    public forgotpass() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Twofa_Authentication = new javax.swing.JTextField();
        Email = new javax.swing.JTextField();
        SecQuestion = new javax.swing.JTextField();
        SecAnswer = new javax.swing.JTextField();
        AdminRecCode = new javax.swing.JTextField();
        ConfirmNewPass = new javax.swing.JPasswordField();
        NewPass = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setText("Reset Password");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, 130, 30));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Back to login");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, -1, -1));

        Twofa_Authentication.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Twofa_AuthenticationActionPerformed(evt);
            }
        });
        jPanel1.add(Twofa_Authentication, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 250, 30));

        Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailActionPerformed(evt);
            }
        });
        jPanel1.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 250, 30));

        SecQuestion.setText("What is your gmail account?");
        SecQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SecQuestionActionPerformed(evt);
            }
        });
        jPanel1.add(SecQuestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 250, 30));

        SecAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SecAnswerActionPerformed(evt);
            }
        });
        jPanel1.add(SecAnswer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 250, 30));

        AdminRecCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminRecCodeActionPerformed(evt);
            }
        });
        jPanel1.add(AdminRecCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 250, 30));

        ConfirmNewPass.setText("jPasswordField1");
        jPanel1.add(ConfirmNewPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 150, 220, 30));

        NewPass.setText("jPasswordField1");
        jPanel1.add(NewPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, 220, 30));

        jLabel2.setText("Confirm New Password");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, -1, -1));

        jLabel3.setText("email");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel4.setText("Security question");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel5.setText("Security answer");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        jLabel6.setText("Admin request code");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, -1, -1));

        jLabel7.setText("Twofa_Authentication");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, -1, -1));

        jLabel8.setText("New Password");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setText("FORGOT PASSWORD");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel10.setText("FORGOT PASSWORD");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 210, 40));

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

    private void Twofa_AuthenticationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Twofa_AuthenticationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Twofa_AuthenticationActionPerformed

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailActionPerformed

    private void SecQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SecQuestionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SecQuestionActionPerformed

    private void SecAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SecAnswerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SecAnswerActionPerformed

    private void AdminRecCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminRecCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AdminRecCodeActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        String email = Email.getText();
            if (email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your email first.");
                return;
            }

            config cf = new config();
            String query = "SELECT * FROM customer WHERE email = ?";

            try (Connection conn = cf.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, email);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    String correctSecurityAnswer = rs.getString("cs_security_answer"); // Assuming you have a column for this
                    String generated2FACode = String.format("%06d", new Random().nextInt(999999)); // Random 6-digit

                    JOptionPane.showMessageDialog(this, "Your 2FA code is: " + generated2FACode);
                } else {
                    JOptionPane.showMessageDialog(this, "Email not found!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage());
            }
     

        // Confirm button to reset password
           confirmButton.addActionListener(evt -> {
           String email = emailField.getText();
           String securityAnswer = securityField.getText();
           String adminCode = adminCodeField.getText();
           String code2FA = code2FAField.getText();
           String newPassword = new String(newPasswordField.getPassword());


            if (email.isEmpty() || securityAnswer.isEmpty() || adminCode.isEmpty() || code2FA.isEmpty() || newPassword.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.");
                return;
            }
                Object correctSecurityAnswer = null; 
            if (!securityAnswer.equalsIgnoreCase((String) correctSecurityAnswer)) {
                JOptionPane.showMessageDialog(this, "Incorrect Security Answer.");
                return;
            }
                Object correctAdminCode = null;

            if (!adminCode.equals(correctAdminCode)) {
                JOptionPane.showMessageDialog(this, "Invalid Admin Reset Code.");
                return;
            }
                 Object generated2FACode = null;
            if (!code2FA.equals(generated2FACode)) {
                 "Incorrect 2FA Code.";
                return;
            }

            config cf = new config();
            String updateQuery = "UPDATE customer SET cs_pass = ? WHERE cs_email = ?";

            try (Connection conn = cf.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {
                pstmt.setString(1, hashPassword(newPassword));
                pstmt.setString(2, email);

                int rowsUpdated = pstmt.executeUpdate();
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(this, "Password reset successfully!");
                    new Login().setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Password reset failed. Try again.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage());
            }
        return null;
           }
                   
        
    

    }//GEN-LAST:event_jButton1MouseClicked

    
    public static void main(String args[]) {
       
     
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(forgotpass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(forgotpass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(forgotpass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(forgotpass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       

       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new forgotpass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AdminRecCode;
    private javax.swing.JPasswordField ConfirmNewPass;
    private javax.swing.JTextField Email;
    private javax.swing.JPasswordField NewPass;
    private javax.swing.JTextField SecAnswer;
    private javax.swing.JTextField SecQuestion;
    private javax.swing.JTextField Twofa_Authentication;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
