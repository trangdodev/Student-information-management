/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Information;

import ConnectDB.DBAccess;
import studentma.RequestSendToServer;
import studentma.Start;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author iammt
 */
public class FindStudent extends javax.swing.JFrame {

    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private Socket client;
    private static String mssvTemp;
    
    public FindStudent(Socket client) {
        initComponents();
        if (client != null) {
            this.client = client;
            try {
                // Tạo luồng ghi và đọc một lần và sử dụng chúng liên tục
                oos = new ObjectOutputStream(client.getOutputStream());
                ois = new ObjectInputStream(client.getInputStream());
            } catch (IOException e) {
                e.printStackTrace(); // Xử lý lỗi tại đây nếu cần thiết
            }
        } else {
            // Xử lý trường hợp client là null, ví dụ: hiển thị thông báo lỗi
            JOptionPane.showMessageDialog(this, "Không thể kết nối đến máy chủ. Vui lòng thử lại sau.");
            // Đóng cửa sổ hoặc thực hiện các hành động cần thiết nếu không thể kết nối đến máy chủ
            this.dispose(); // Đóng cửa sổ NhapThongTin nếu không thể kết nối đến máy chủ
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtMSSV = new javax.swing.JTextField();
        btnOK = new javax.swing.JButton();
        btnback = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Nhập Mã số sinh viên");

        txtMSSV.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        btnback.setText("<<Quay lại");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMSSV)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addComponent(btnOK)))
                .addContainerGap(306, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnback)
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(txtMSSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnOK)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                .addComponent(btnback)
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        this.dispose();
        new Start().setVisible(true);
    }//GEN-LAST:event_btnbackActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        // TODO add your handling code here:
        String mSSV = txtMSSV.getText();
        if (!mSSV.isEmpty()) {
            try {
                // Tạo một đối tượng DBAccess để thực hiện kết nối và truy vấn cơ sở dữ liệu
                DBAccess dbAccess = new DBAccess();

                // Kiểm tra xem sinh viên có tồn tại trong CSDL hay không
                PreparedStatement checkStmt = dbAccess.getConnection().prepareStatement("SELECT COUNT(*) FROM SinhVien WHERE MSSV = ?");
                checkStmt.setString(1, mSSV);
                ResultSet resultSet = checkStmt.executeQuery();
                resultSet.next();
                int count = resultSet.getInt(1);

                // Đóng tài nguyên (PreparedStatement, ResultSet) sau khi sử dụng
                checkStmt.close();
                resultSet.close();

                if (count > 0) {
                    // Nếu có sinh viên trong CSDL, hiển thị thông báo "Cập nhật sinh viên"
                    JOptionPane.showMessageDialog(this, "Cập nhật thông tin sinh viên");
                    // Chuyển hướng đến CapNhatSinhVien.java
                    StudentUpdate capNhatSinhVien = new StudentUpdate(mSSV);
                    capNhatSinhVien.setVisible(true);
                    this.dispose(); // Đóng cửa sổ hiện tại (Nhap1.java)

                } else {
                    // Nếu không có sinh viên trong CSDL, hiển thị thông báo "Nhập mới thông tin sinh viên"
                    JOptionPane.showMessageDialog(this, "Nhập mới thông tin sinh viên");
                    mssvTemp = mSSV;
                    SwingUtilities.invokeLater(() -> {
                        new NewInfo(client).setVisible(true);
                    });
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Lỗi khi truy vấn cơ sở dữ liệu: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nhập thiếu thông tin, vui lòng nhập lại");
        }

    }//GEN-LAST:event_btnOKActionPerformed

    /**
     * @param args the command line arguments
     */
    private static void initial() throws IOException {
        Socket client = new Socket("localhost", 9999);

        java.awt.EventQueue.invokeLater(() -> {
            new FindStudent(client).setVisible(true);
        });
    }
    public static String getMssvTemp(){
        return mssvTemp;
    }
    public static void openForm() throws IOException {
        initial();
    }

    public static void main(String args[]) throws IOException {
        initial();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnback;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtMSSV;
    // End of variables declaration//GEN-END:variables
}
