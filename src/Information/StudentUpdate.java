/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Information;

import ConnectDB.DBAccess;
import ConnectDB.SubjectField;
import studentma.Start;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author iammt
 */
public class StudentUpdate extends javax.swing.JFrame {

    /**
     * Creates new form CapNhatSinhVien
     */
    private String mSSV;

    public StudentUpdate() {

    }

    public StudentUpdate(String mSSV) {
        initComponents();
        this.mSSV = mSSV;
        SubjectField nganhMon = new SubjectField(jbcNganh, jbcMon);
        jbcNganh.addItem("Công nghệ thông tin");
        jbcNganh.addItem("Quản trị kinh doanh");
        jbcNganh.addItem("Tài chính-Ngân hàng");
        jbcNganh.addItem("Logistic");
        jbcNganh.addItem("Kế toán");
        fillData(); // Gọi hàm fillData() để fill dữ liệu
        setVisible(true); // Hiển thị form sau khi fill dữ liệu

    }

    private void fillData() {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:8081;Database=qlsv;user=trang;password=123456")) {
            String sql = "SELECT * FROM SinhVien WHERE MSSV = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, mSSV);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        // Lấy dữ liệu từ ResultSet và gán lên các trường trên form
                        String mssv = resultSet.getString("MSSV");
                        String hoTen = resultSet.getString("HoTen");
                        String ngaySinh = resultSet.getString("NgaySinh");
                        String phai = resultSet.getString("Phai");
                        String noiSinh = resultSet.getString("NoiSinh");
                        String lop = resultSet.getString("Lop");
                        String nganh = resultSet.getString("nganh");

                        txtMSSV.setText(mssv);
                        txtHoTen.setText(hoTen);
                        txtNgaySinh.setText(ngaySinh);
                        txtPhai.setText(phai);
                        txtNoiSinh.setText(noiSinh);
                        txtLop.setText(lop);

                        // Set giá trị cho các combobox tương ứng
                        jbcNganh.setSelectedItem(nganh);

                    } else {
                        // Nếu không tìm thấy sinh viên với MSSV tương ứng
                        JOptionPane.showMessageDialog(this, "Không tìm thấy sinh viên có MSSV: " + mSSV);
                        // Đóng cửa sổ hiện tại
                        this.dispose();
                    }

                }
            }
        } catch (SQLException e) {
            // Xử lý các lỗi kết nối hoặc truy vấn CSDL
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi truy vấn dữ liệu từ CSDL.");
            // Đóng cửa sổ hiện tại
            this.dispose();
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

        txtHoTen = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jbcMon = new javax.swing.JComboBox<>();
        txtNgaySinh = new javax.swing.JTextField();
        jbcNganh = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtNoiSinh = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPhai = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtLop = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnLuu = new javax.swing.JButton();
        txtMSSV = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDiem = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtHoTen.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Môn học:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Ngày sinh:");

        jbcMon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtNgaySinh.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jbcNganh.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Nơi sinh:");

        txtNoiSinh.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Phái:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Lớp:");

        txtPhai.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("CẬP NHẬT THÔNG TIN SINH VIÊN");

        txtLop.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        jLabel2.setText("Vui lòng nhập các thông tin sau");

        btnBack.setText("<<Quay lại");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Ngành:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Mã số sinh viên: ");

        btnLuu.setBackground(new java.awt.Color(102, 153, 255));
        btnLuu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        txtMSSV.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Điểm:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Họ và tên:");

        txtDiem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(358, 358, 358)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(439, 439, 439)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(421, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(65, 65, 65))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addComponent(jLabel6))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNoiSinh)
                    .addComponent(txtMSSV)
                    .addComponent(txtHoTen)
                    .addComponent(txtNgaySinh)
                    .addComponent(txtPhai, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbcNganh, 0, 239, Short.MAX_VALUE)
                            .addComponent(txtLop)
                            .addComponent(txtDiem)
                            .addComponent(jbcMon, 0, 239, Short.MAX_VALUE))
                        .addGap(185, 185, 185))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLuu)
                        .addGap(273, 273, 273))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMSSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jbcNganh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbcMon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txtPhai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNoiSinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLuu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBack)
                .addGap(141, 141, 141))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
        new Start().setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        try (Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:8081;Database=qlsv;user=trang;password=123456")) {
            String tenMonHoc = jbcMon.getSelectedItem().toString();

            String maMonHoc = "";
            String getMaMonHocQuery = "SELECT MaMon FROM MonHoc WHERE TenMon = ?";
            try (PreparedStatement getMaMonHocStatement = connection.prepareStatement(getMaMonHocQuery)) {
                getMaMonHocStatement.setString(1, tenMonHoc);
                try (ResultSet resultSet = getMaMonHocStatement.executeQuery()) {
                    if (resultSet.next()) {
                        maMonHoc = resultSet.getString("MaMon");
                    }
                }
            }

            float diem = Float.parseFloat(txtDiem.getText());

            String checkDiemQuery = "SELECT * FROM Diem WHERE MSSV = ? AND MaMon = ?";
            try (PreparedStatement checkDiemStatement = connection.prepareStatement(checkDiemQuery)) {
                checkDiemStatement.setString(1, mSSV);
                checkDiemStatement.setString(2, maMonHoc);
                try (ResultSet resultSet = checkDiemStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // Môn học đã có điểm, cập nhật điểm
                        String updateDiemQuery = "UPDATE Diem SET Diem = ? WHERE MSSV = ? AND MaMon = ?";
                        try (PreparedStatement updateDiemStatement = connection.prepareStatement(updateDiemQuery)) {
                            updateDiemStatement.setFloat(1, diem);
                            updateDiemStatement.setString(2, mSSV);
                            updateDiemStatement.setString(3, maMonHoc);
                            updateDiemStatement.executeUpdate();
                        }
                    } else {
                        // Môn học chưa có điểm, thêm mới điểm
                        String addDiemQuery = "INSERT INTO Diem (MSSV, MaMon, Diem, TenMon) VALUES (?, ?, ?, ?)";
                        try (PreparedStatement addDiemStatement = connection.prepareStatement(addDiemQuery)) {
                            addDiemStatement.setString(1, mSSV);
                            addDiemStatement.setString(2, maMonHoc);
                            addDiemStatement.setFloat(3, diem);
                            addDiemStatement.setString(4, tenMonHoc);
                            addDiemStatement.executeUpdate();
                        }
                    }
                    JOptionPane.showMessageDialog(this, "Lưu thông tin sinh viên và điểm thành công.");
                    // Xóa dữ liệu trong các trường nhập sau khi cập nhật hoặc thêm mới thành công
                    jbcMon.setSelectedIndex(0);
                    txtDiem.setText("");
                }
            }
        } catch (SQLException e) {
            // Xử lý các lỗi kết nối hoặc truy vấn CSDL
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi khi lưu dữ liệu xuống CSDL.");
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
            java.util.logging.Logger.getLogger(StudentUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentUpdate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnLuu;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> jbcMon;
    private javax.swing.JComboBox<String> jbcNganh;
    private javax.swing.JTextField txtDiem;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtLop;
    private javax.swing.JTextField txtMSSV;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtNoiSinh;
    private javax.swing.JTextField txtPhai;
    // End of variables declaration//GEN-END:variables
}