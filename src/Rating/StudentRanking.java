package Rating;

import Client.Client;
import studentma.RequestSendToServer_Rating;
import studentma.RequestSendToServer;
import studentma.Start;
import java.io.IOException;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Client.ObserverNotify;
import Common.Response_Rating;

public class StudentRanking extends javax.swing.JFrame implements ObserverNotify {


    
 
    public StudentRanking() {
        initializeClient();

    }

    @Override
    public void fetchData(Response_Rating response) {
        displaySinhVienList((ArrayList<Student>) response.data);
        JOptionPane.showMessageDialog(this, "Lấy danh sách thành công");

    }

    private void initializeClient() {
            Client.getInstance().attach((StudentRanking)this);
            initComponents();
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnOK = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jbcNganh = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jbcHangMuc = new javax.swing.JComboBox<>();
        btnBack = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("XẾP HẠNG SINH VIÊN");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Hạng mục: ");

        btnOK.setBackground(new java.awt.Color(102, 153, 255));
        btnOK.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Chọn ngành:");

        jbcNganh.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbcNganh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Công nghệ thông tin", "Quản trị kinh doanh", "Kế toán", "Tài chính-Ngân hàng ", "Logistic", " " }));

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "MSSV", "Họ và tên", "Điểm"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jbcHangMuc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbcHangMuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Xếp hạng theo ngành học" }));

        btnBack.setBackground(new java.awt.Color(204, 204, 255));
        btnBack.setText("<<Quay lại");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(347, 347, 347))
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBack)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(jbcHangMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(34, 34, 34)
                            .addComponent(jLabel3)
                            .addGap(25, 25, 25)
                            .addComponent(jbcNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnOK))))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnOK)
                    .addComponent(jLabel3)
                    .addComponent(jbcNganh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbcHangMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnOKActionPerformed
        if (jbcHangMuc != null && jbcNganh != null ) {
            String hangMuc = jbcHangMuc.getSelectedItem() != null ? jbcHangMuc.getSelectedItem().toString() : "";
            String nganh = jbcNganh.getSelectedItem() != null ? jbcNganh.getSelectedItem().toString() : "";
            if (!hangMuc.isEmpty() && !nganh.isEmpty()) {
                RequestSendToServer_Rating requestdata = new RequestSendToServer_Rating("XepHangSinhVienTheoNganhHoc",
                        "some_value", nganh, hangMuc);
                RequestSendToServer request = new RequestSendToServer("XepHangSinhVienTheoNganhHoc", requestdata);
                Client.getInstance().sendRequest(request);
            } else {
                JOptionPane.showMessageDialog(this, "Hãy chọn hạng mục và ngành học trước khi nhấn OK.", "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "Đối tượng không được khởi tạo đúng. Vui lòng kiểm tra lại kết nối với server.", "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Phương thức hiển thị danh sách sinh viên lên bảng
    private void displaySinhVienList(ArrayList<Student> sinhVienList) {
        Object[][] data = new Object[sinhVienList.size()][4];
        for (int i = 0; i < sinhVienList.size(); i++) {
            Student sinhVien = sinhVienList.get(i);
            data[i][0] = i + 1;
            data[i][1] = sinhVien.getMSSV();
            data[i][2] = sinhVien.getHoTen();
            data[i][3] = sinhVien.getDiem();
        }

        String[] columnNames = {"STT", "MSSV", "Họ và tên", "Điểm"};
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        jTable1.setModel(model);
    }// GEN-LAST:event_btnOKActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
         Client.getInstance().detach(this);
        this.dispose();
        new Start().setVisible(true);

    }// GEN-LAST:event_btnBackActionPerformed

    private static void initial() throws IOException {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentRanking().setVisible(true);
            }
        });
    }

    public static void openForm() throws IOException {
        initial();
    }

    public static void main(String args[]) {
        System.out.println("runnn");
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentRanking.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentRanking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> jbcHangMuc;
    private javax.swing.JComboBox<String> jbcNganh;
    // End of variables declaration//GEN-END:variables
}
