/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package or;

import config.config;
import static config.passwordHasher.hashPassword;
import config.session;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author janin
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }

  public static boolean login(String username, String password) {
    config cf = new config();
    String query = "SELECT * FROM customer WHERE cs_user = ? AND cs_status = 'active'";

    try (Connection conn = cf.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(query)) {

        pstmt.setString(1, username);
        ResultSet resultSet = pstmt.executeQuery();

        if (resultSet.next()) {
            String storedPassword = resultSet.getString("cs_pass");
            String userType = resultSet.getString("cs_type");
            String hashedInputPassword = hashPassword(password);

            // If stored password is plaintext, hash and update it
            if (!storedPassword.matches("[a-fA-F0-9]{64}")) {
                System.out.println("Rehashing old plaintext password...");
                String newHashedPassword = hashPassword(storedPassword);

                try (PreparedStatement updateStmt = conn.prepareStatement(
                        "UPDATE customer SET cs_pass = ? WHERE cs_user = ?")) {
                    updateStmt.setString(1, newHashedPassword);
                    updateStmt.setString(2, username);
                    updateStmt.executeUpdate();
                }

                storedPassword = newHashedPassword;
            }

            // Validate password
            if (hashedInputPassword.equals(storedPassword)) {
                JOptionPane.showMessageDialog(null, "Login Successful!");

                // ✅ Store the logged-in username in dbconnect for later use
                config.loggedInUsername = username;  // Store the username after successful login

                // ✅ Load user details into Session class
                session ses = session.getInstance();
                ses.setUid(resultSet.getString("id"));
                ses.setFname(resultSet.getString("cs_fname"));
                ses.setLname(resultSet.getString("cs_lname"));
                ses.setEmail(resultSet.getString("cs_email"));
                ses.setContact(resultSet.getString("cs_contact"));
                ses.setAddress(resultSet.getString("cs_address"));
                ses.setUser(username);
                ses.setType(userType);
                ses.setStatus(resultSet.getString("cs_status"));
                                
                
                // ✅ Redirect user based on their type
                if ("customer".equalsIgnoreCase(userType)) {
                    new Customer().setVisible(true);
                } else if ("manager".equalsIgnoreCase(userType)) {
                    new Receptionist().setVisible(true);
//                } else if ("admin".equalsIgnoreCase(userType)) {
//                    new Dashboard().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Unknown user type!", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
             
              
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Wrong Username or Password!", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "User not found or inactive!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        Password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setText("LOG IN");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 37, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Email");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Password");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 237, 89, -1));

        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setText("CONFIRM");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 313, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Don't have an account? Register Here");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, -1, -1));

        username.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        jPanel1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 162, 33));

        Password.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel1.add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 162, 32));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         
    String url = "jdbc:mysql://localhost:3306/binsbites";
String user = "root";
String password = "";

String query = "SELECT cpass, type FROM customer WHERE email = ? AND status = 'active'";

try (Connection conn = DriverManager.getConnection(url, user, password);
     PreparedStatement pstmt = conn.prepareStatement(query)) {

    pstmt.setString(1, username.getText());
    ResultSet rs = pstmt.executeQuery();

    if (rs.next()) {
        String storedPassword = rs.getString("cpass");
        String userType = rs.getString("type"); 

        if (Password.getText().equals(storedPassword)) {
            JOptionPane.showMessageDialog(null, "Login Successful!");

            // Redirect based on user type
            if ("customer".equalsIgnoreCase(userType)) {
                Customer cs = new Customer();
                this.dispose();
                cs.setVisible(true);
            } else if ("Receptionist".equalsIgnoreCase(userType)) {
                Receptionist rc = new Receptionist();
                this.dispose();
                rc.setVisible(true);
            } else if ("admin".equalsIgnoreCase(userType)) {
                Admin ad = new Admin();
                this.dispose();
                ad.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Unknown user type!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Wrong Username or Password!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(null, "User not found or inactive!", "Error", JOptionPane.ERROR_MESSAGE);
    }
} catch (SQLException e) {
    JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
} 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        Register regis;
        regis = new Register();

        regis.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Password;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
