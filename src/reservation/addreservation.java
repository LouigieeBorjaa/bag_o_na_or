/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation;

import config.config;
import static config.config.loggedInUsername;
import config.session;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import or.Customer;
import or.Login;

/**
 *
 * @author SCC-COLLEGE
 */
public class addreservation extends javax.swing.JFrame {

    /**
     * Creates new form addreservation
     */
    public addreservation() {
        initComponents();
        displayData();
    }

    public void displayData() {
        try {
            config dbc = new config();
            ResultSet rs = dbc.getData("SELECT * FROM seating ");
            seating.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Errors: " + ex.getMessage());

        }

    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        today = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tbl_id = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        seating = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 153, 153));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("WELCOME TO BINSBITES!");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Please fill in the blanks.");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        today.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todayActionPerformed(evt);
            }
        });
        jPanel1.add(today, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 170, 40));
        jPanel1.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 170, 40));

        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, -1, -1));

        jButton2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton2.setText("Confirm");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, -1, -1));

        jLabel3.setText("Reservation Date.");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, -1, -1));

        jLabel4.setText("Address.");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        tbl_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbl_idActionPerformed(evt);
            }
        });
        jPanel1.add(tbl_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 170, 40));

        jScrollPane1.setViewportView(seating);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 430, 150));

        jLabel5.setText("Table Id.");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
  String tableId = tbl_id.getText();
String reservationDate = today.getText();
String reservationAddress = address.getText();

config conf = new config(); // Your existing config class

int userId = conf.loggedInUserId; // Should be set properly at login

if (tableId.isEmpty() || reservationDate.isEmpty() || reservationAddress.isEmpty()) {
    JOptionPane.showMessageDialog(null, "Please fill in all required fields.");
} else {
    try {
        Connection conn = conf.getConnection();

        String sql = "INSERT INTO reservation (u_id, t_id, reservation_date, address, status) " +
                     "VALUES (?, ?, ?, ?, ?)";

        PreparedStatement pst = conn.prepareStatement(sql);
      
    
        pst.setInt(1, userId); // Foreign key to customer table
        pst.setInt(2, Integer.parseInt(tableId));
        pst.setString(3, reservationDate);
        pst.setString(4, reservationAddress);
        pst.setString(5, "Pending");

        int rowsInserted = pst.executeUpdate();

        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(null, "Table Reservation is Successful!");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to reserve table. Please try again.");
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "Invalid input format. " + ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
    }
}

    Customer cs = new Customer();
    cs.dispose();
    cs.setVisible(true);




    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
    
    }//GEN-LAST:event_jButton2MouseClicked

    private void todayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todayActionPerformed
        
    String inputDateStr = today.getText().trim();

if (inputDateStr.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Reservation date cannot be empty!", "Validation Error", JOptionPane.WARNING_MESSAGE);
    return;
}

try {
    // Strictly parse input date in yyyy-MM-dd format
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    sdf.setLenient(false);
    Date inputDate = (Date) sdf.parse(inputDateStr); // Converts to java.util.Date

    // Convert both input and today to LocalDate (no time portion)
    LocalDate inputLocalDate = inputDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    LocalDate todayLocalDate = LocalDate.now();

    // Reject past dates
    if (inputLocalDate.isBefore(todayLocalDate)) {
        JOptionPane.showMessageDialog(this, "Reservation date cannot be in the past!", "Validation Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Date is valid
    JOptionPane.showMessageDialog(this, "Valid reservation date selected: " + inputDateStr);

    // Proceed with reservation logic here...

} catch (ParseException e) {
    JOptionPane.showMessageDialog(this, "Invalid date format. Use yyyy-MM-dd (e.g., 2025-05-20)", "Validation Error", JOptionPane.WARNING_MESSAGE);
}

    }//GEN-LAST:event_todayActionPerformed

    private void tbl_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbl_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_idActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(addreservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addreservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addreservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addreservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addreservation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable seating;
    private javax.swing.JTextField tbl_id;
    private javax.swing.JTextField today;
    // End of variables declaration//GEN-END:variables
}
