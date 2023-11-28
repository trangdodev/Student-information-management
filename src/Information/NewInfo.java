package Information;

import ConnectDB.DBAccess;
import studentma.Start;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class NewInfo extends javax.swing.JFrame {

    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private Socket client;

    public NewInfo(Socket client) {
        initComponents();
        txtMSSV.setText(FindStudent.getMssvTemp());
        if (client != null) {
            this.client = client;
            try {
                // Tạo luồng ghi và đọc
                oos = new ObjectOutputStream(client.getOutputStream());
                ois = new ObjectInputStream(client.getInputStream());
            } catch (IOException e) {}
        } else {
            JOptionPane.showMessageDialog(this, "Không thể kết nối đến máy chủ. Vui lòng thử lại sau.");
            this.dispose();
        }
        jbcNganh.addItem("Công nghệ thông tin");
        jbcNganh.addItem("Quản trị kinh doanh");
        jbcNganh.addItem("Tài chính-Ngân hàng");
        jbcNganh.addItem("Logistic");
        jbcNganh.addItem("Kế toán");

    }

    private DBAccess dbAccess;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMSSV = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNoiSinh = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtLop = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnLuu = new javax.swing.JButton();
        jbcNganh = new javax.swing.JComboBox<>();
        btnReset = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtPhai = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("THÔNG TIN SINH VIÊN");

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        jLabel2.setText("Vui lòng nhập các thông tin sau");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Mã số sinh viên: ");

        txtMSSV.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Họ và tên:");

        txtHoTen.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Ngày sinh:");

        txtNgaySinh.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Nơi sinh:");

        txtNoiSinh.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Lớp:");

        txtLop.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Ngành:");

        btnLuu.setBackground(new java.awt.Color(102, 153, 255));
        btnLuu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        jbcNganh.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnReset.setBackground(new java.awt.Color(102, 153, 255));
        btnReset.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Phái:");

        txtPhai.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnBack.setBackground(new java.awt.Color(204, 204, 255));
        btnBack.setText("<<Quay lại");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jMenuBar1.setMaximumSize(new java.awt.Dimension(385, 5000));
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(358, 358, 358)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMSSV)
                            .addComponent(txtHoTen)
                            .addComponent(txtNgaySinh)
                            .addComponent(txtPhai, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8))
                                        .addGap(29, 29, 29)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jbcNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtLop, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNoiSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(3, 3, 3)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(btnReset)
                                    .addGap(68, 68, 68)
                                    .addComponent(btnLuu)
                                    .addGap(40, 40, 40)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(293, 293, 293)
                                .addComponent(btnBack)))))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtMSSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txtPhai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtNoiSinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jbcNganh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLuu)
                            .addComponent(btnReset))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        txtMSSV.setText("");
        txtHoTen.setText("");
        txtLop.setText("");
        txtNgaySinh.setText("");
        txtNoiSinh.setText("");
        txtPhai.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // Lấy dữ liệu từ các trường nhập
        String hoTen = txtHoTen.getText();
        String mSSV = txtMSSV.getText();
        String lop = txtLop.getText();
        String phai = txtPhai.getText();
        String ngaySinhText = txtNgaySinh.getText();
        String noiSinh = txtNoiSinh.getText();

        String nganh = (String) jbcNganh.getSelectedItem();

        if (!hoTen.isEmpty() && !mSSV.isEmpty() && !lop.isEmpty() && !phai.isEmpty() && !ngaySinhText.isEmpty() && !noiSinh.isEmpty() && nganh != null) {
            try {
                // Tạo một đối tượng DBAccess để thực hiện kết nối và truy vấn cơ sở dữ liệu
                DBAccess dbAccess = new DBAccess();

                // Kiểm tra xem sinh viên có tồn tại trong CSDL hay không
                PreparedStatement checkStmt = dbAccess.getConnection().prepareStatement("SELECT COUNT(*) FROM SinhVien WHERE MSSV = ?");
                checkStmt.setString(1, mSSV);
                ResultSet resultSet = checkStmt.executeQuery();
                resultSet.next();
                int count = resultSet.getInt(1);
                checkStmt.close();

                if (count > 0) {
                    // Nếu sinh viên tồn tại, cập nhật thông tin cho sinh viên đó
                    String updateSql = "UPDATE SinhVien SET HoTen = ?,  Lop = ?,Phai =?, NgaySinh = CONVERT(DATETIME, ?, 105), NoiSinh = ?, Nganh = ? WHERE MSSV = ?";
                    PreparedStatement updateStmt = dbAccess.getConnection().prepareStatement(updateSql);
                    updateStmt.setString(1, hoTen);
                    updateStmt.setString(2, phai);
                    updateStmt.setString(3, lop);
                    updateStmt.setString(4, ngaySinhText);
                    updateStmt.setString(5, noiSinh);
                    updateStmt.setString(6, nganh);
                    updateStmt.setString(7, mSSV);

                    int rowsAffected = updateStmt.executeUpdate();
                    updateStmt.close();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(this, "Cập nhật thông tin sinh viên thành công");
                    } else {
                        JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật dữ liệu sinh viên");
                    }
                } else {
                    // Nếu sinh viên không tồn tại, thực hiện việc chèn mới
                    String insertSql = "INSERT INTO SinhVien (HoTen, MSSV, Lop,Phai, NgaySinh, NoiSinh, Nganh) VALUES (?, ?, ?,?, CONVERT(DATETIME, ?, 105), ?, ?)";
                    PreparedStatement insertStmt = dbAccess.getConnection().prepareStatement(insertSql);
                    insertStmt.setString(1, hoTen);
                    insertStmt.setString(2, mSSV);
                    insertStmt.setString(3, lop);
                    insertStmt.setString(4, phai);
                    insertStmt.setString(5, ngaySinhText);
                    insertStmt.setString(6, noiSinh);
                    insertStmt.setString(7, nganh);

                    int rowsAffected = insertStmt.executeUpdate();
                    insertStmt.close();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(this, "Thêm thông tin sinh viên thành công");
                    } else {
                        JOptionPane.showMessageDialog(this, "Lỗi khi thêm dữ liệu sinh viên");
                    }
                }
                this.dispose();
                new Start().setVisible(true);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Lỗi khi truy vấn cơ sở dữ liệu: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nhập thiếu thông tin, vui lòng nhập lại");
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
        new Start().setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed
    private static void initial() throws IOException {
        Socket client = new Socket("localhost", 9999);
        java.awt.EventQueue.invokeLater(() -> {
            new NewInfo(client).setVisible(true);
        });
    }

    public static void openForm() throws IOException {
        initial();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
        initial();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnReset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JComboBox<String> jbcNganh;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtLop;
    private javax.swing.JTextField txtMSSV;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtNoiSinh;
    private javax.swing.JTextField txtPhai;
    // End of variables declaration//GEN-END:variables

}
