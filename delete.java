/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dbms_task2;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;


public class delete extends javax.swing.JFrame {
    public delete() {
        initComponents();
         jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                   student_page admin=new student_page();
                   admin.setVisible(true);
                   dispose();
                   
            }
        });
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteLibrarian();
            }
        });
    }
      
    private void deleteLibrarian() {
        String passwordToDelete = jTextField1.getText();

        if (passwordToDelete.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the student's usn.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Connection connection = DB.getConnection(); // Replace with your actual database connection code

            // Execute DELETE query
            String deleteQuery = "DELETE FROM student WHERE usn= ?";
            try (PreparedStatement pst = connection.prepareStatement(deleteQuery)) {
                pst.setString(1, passwordToDelete);
                int rowsAffected = pst.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "student deleted successfully.");

                    // If you have a reference to the ViewLibrarian instance, you can call a method to refresh the view
                    // For example, if you have a method named refreshView() in ViewLibrarian:
                    // viewLibrarianInstance.refreshView();

                    // If you don't have a reference to the ViewLibrarian instance, you can create a new instance:
                    view viewLibrarian = new view();
                    viewLibrarian.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "student deletion failed. student not found.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jButton1.setText("DELETE");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 317, -1, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jButton2.setText("BACK");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 317, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 152, 106, 35));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("USN");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 149, 73, 35));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setText("DELETE STUDENT");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 20, 337, 59));

        jLabel3.setBackground(new java.awt.Color(255, 204, 204));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dbms_task2/bck.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, -4, 510, 410));

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
            java.util.logging.Logger.getLogger(delete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(delete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(delete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(delete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new delete().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
