import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class NhapThongTin extends javax.swing.JFrame {
 
    public NhapThongTin() {
        initComponents();
        
        NganhMon nganhMon = new NganhMon(jbcNganh, jbcMon);
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
        jLabel10 = new javax.swing.JLabel();
        txtDiem = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jbcMon = new javax.swing.JComboBox<>();
        jbcNganh = new javax.swing.JComboBox<>();
        btnReset = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        meThongTin = new javax.swing.JMenu();
        meTraCuu = new javax.swing.JMenu();
        meXepHang = new javax.swing.JMenu();

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

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Điểm:");

        txtDiem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Môn học:");

        jbcMon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jbcNganh.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnReset.setBackground(new java.awt.Color(102, 153, 255));
        btnReset.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jMenuBar1.setMaximumSize(new java.awt.Dimension(385, 5000));

        meThongTin.setText("Thông tin sinh viên");
        meThongTin.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jMenuBar1.add(meThongTin);

        meTraCuu.setText("Tra cứu điểm thi");
        meTraCuu.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jMenuBar1.add(meTraCuu);

        meXepHang.setText("Xếp hạng sinh viên");
        meXepHang.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jMenuBar1.add(meXepHang);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel11))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMSSV, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                                    .addComponent(txtHoTen)
                                    .addComponent(txtNgaySinh))
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbcMon, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(118, 118, 118)
                                .addComponent(jLabel10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnReset)
                                .addGap(68, 68, 68)
                                .addComponent(btnLuu)
                                .addGap(49, 49, 49)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNoiSinh, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                                .addComponent(txtLop))
                            .addComponent(jbcNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(358, 358, 358)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jbcNganh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtMSSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txtNoiSinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(txtLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jbcMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuu)
                    .addComponent(btnReset))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        txtMSSV.setText("");
        txtHoTen.setText("");
        txtDiem.setText("");
        txtLop.setText("");
        txtNgaySinh.setText("");
        txtNoiSinh.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
        // Lấy dữ liệu từ các trường nhập
    // Lấy dữ liệu từ các trường nhập

        String hoTen = txtHoTen.getText();
        String mSSV = txtMSSV.getText();
        String diem = txtDiem.getText();
        String lop = txtLop.getText();
        String ngaySinhText = txtNgaySinh.getText(); // Lưu ngày tháng dưới dạng văn bản
        String noiSinh = txtNoiSinh.getText();
        String monHoc = (String) jbcMon.getSelectedItem();
        String nganh = (String) jbcNganh.getSelectedItem();

        if (!hoTen.isEmpty() && !mSSV.isEmpty() && !diem.isEmpty() && !lop.isEmpty() && !ngaySinhText.isEmpty() && !noiSinh.isEmpty() && monHoc != null && nganh != null) {
        try {
        // Tạo một đối tượng DBAccess để thực hiện kết nối và truy vấn cơ sở dữ liệu
        DBAccess dbAccess = new DBAccess();

        // Tạo câu truy vấn SQL để thêm dữ liệu vào cơ sở dữ liệu
        String sql = "INSERT INTO sinhvien (ho_ten, ma_sinh_vien, diem, lop, ngay_sinh, noi_sinh, mon_hoc, nganh_hoc) VALUES (?, ?, ?, ?, STR_TO_DATE(?, '%d-%m-%Y'), ?, ?, ?)";

        // Tạo một PreparedStatement để thực hiện câu truy vấn
        PreparedStatement pstmt = dbAccess.getConnection().prepareStatement(sql);

        // Đặt giá trị thay thế trong câu truy vấn
        pstmt.setString(1, hoTen);
        pstmt.setString(2, mSSV);
        pstmt.setString(3, diem);
        pstmt.setString(4, lop);
        pstmt.setString(5, ngaySinhText); // Sử dụng định dạng ngày tháng của bạn
        pstmt.setString(6, noiSinh);
        pstmt.setString(7, monHoc);
        pstmt.setString(8, nganh);

        // Thực hiện câu truy vấn để thêm dữ liệu
        int rowsAffected = pstmt.executeUpdate();

        // Đóng kết nối
        pstmt.close();

        // Kiểm tra xem dữ liệu đã được thêm thành công hay không
        if (rowsAffected > 0) {
            // Hiển thị thông báo thành công
            JOptionPane.showMessageDialog(this, "Lưu thông tin sinh viên thành công");

            // Xóa dữ liệu trong các trường nhập sau khi lưu thành công
            txtHoTen.setText("");
            txtMSSV.setText("");
            txtDiem.setText("");
            txtLop.setText("");
            txtNgaySinh.setText("");
            txtNoiSinh.setText("");
            jbcMon.setSelectedIndex(0);
            jbcNganh.setSelectedIndex(0);
        } else {
            // Hiển thị thông báo lỗi nếu không thành công
            JOptionPane.showMessageDialog(this, "Lỗi khi lưu dữ liệu vào cơ sở dữ liệu");
        }
    } catch (SQLException e) {
        // Xử lý lỗi nếu có
        JOptionPane.showMessageDialog(this, "Lỗi khi lưu dữ liệu vào cơ sở dữ liệu: " + e.getMessage());
    }
} else {
    // Nếu còn thiếu thông tin, hiển thị thông báo lỗi
    JOptionPane.showMessageDialog(this, "Nhập thiếu thông tin, vui lòng nhập lại");
}

    }//GEN-LAST:event_btnLuuActionPerformed

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
            java.util.logging.Logger.getLogger(NhapThongTin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhapThongTin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhapThongTin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhapThongTin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NhapThongTin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnReset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JComboBox<String> jbcMon;
    private javax.swing.JComboBox<String> jbcNganh;
    private javax.swing.JMenu meThongTin;
    private javax.swing.JMenu meTraCuu;
    private javax.swing.JMenu meXepHang;
    private javax.swing.JTextField txtDiem;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtLop;
    private javax.swing.JTextField txtMSSV;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtNoiSinh;
    // End of variables declaration//GEN-END:variables

}