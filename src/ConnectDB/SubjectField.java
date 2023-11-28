package ConnectDB;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author iammt
 */
public class SubjectField {
    private JComboBox<String> jbcNganh;
    private JComboBox<String> jbcMon;
    private HashMap<String, HashMap<String, String>> nganhMonMapping;


    public SubjectField(JComboBox<String> jbcNganh, JComboBox<String> jbcMon) {
        this.jbcNganh = jbcNganh;
        this.jbcMon = jbcMon;
        
        // Khởi tạo nganhMonMapping và điền dữ liệu
        nganhMonMapping = new HashMap<>();
        
        // Công nghệ thông tin
        HashMap<String, String> monHocCNTT = new HashMap<>();
        monHocCNTT.put("Java","IT1");
        monHocCNTT.put("C++","IT2");
        monHocCNTT.put("Python", "IT3");
        monHocCNTT.put("Web Development","IT4");
        monHocCNTT.put("Mobile App Development","IT5");
        monHocCNTT.put("Database Management","IT6");
        monHocCNTT.put("Artificial Intelligence","IT7");
        monHocCNTT.put("Computer Networks", "IT8");
        monHocCNTT.put("Software Engineering","IT9");
        monHocCNTT.put("Cybersecurity","IT10");
        nganhMonMapping.put("Công nghệ thông tin", monHocCNTT);
        
        // Quản trị kinh doanh
        HashMap<String, String> monHocQuanTriKinhDoanh = new HashMap<>();
        monHocQuanTriKinhDoanh.put("Quản trị doanh nghiệp","KD1");
        monHocQuanTriKinhDoanh.put("Marketing","KD2");
        monHocQuanTriKinhDoanh.put("Kế hoạch kinh doanh","KD3");
        monHocQuanTriKinhDoanh.put("Tài chính doanh nghiệp","KD4");
        monHocQuanTriKinhDoanh.put("Quản lý nhân sự","KD5");
        monHocQuanTriKinhDoanh.put("Phân tích thị trường","KD6");
        monHocQuanTriKinhDoanh.put("Quản lý sản phẩm","KD7");
        monHocQuanTriKinhDoanh.put("Luật kinh doanh","KD8");
        monHocQuanTriKinhDoanh.put("Quản lý dự án","KD9");
        monHocQuanTriKinhDoanh.put("Quản trị rủi ro","KD10");
        nganhMonMapping.put("Quản trị kinh doanh", monHocQuanTriKinhDoanh);
        
        // Kế toán
        HashMap<String, String> monHocKeToan = new HashMap<>();
        monHocKeToan.put("Kế toán tài chính","KT1");
        monHocKeToan.put("Kế toán quản trị","KT2");
        monHocKeToan.put("Kiểm toán","KT3");
        monHocKeToan.put("Thuế và quyết toán thuế","KT4");
        monHocKeToan.put("Học phân tích tài chính","KT5");
        monHocKeToan.put("Kế toán ngân hàng","KT6");
        monHocKeToan.put("Kế toán chi phí","KT7");
        monHocKeToan.put("Kế toán hành chính sự nghiệp","KT8");
        monHocKeToan.put("Kế toán quốc tế","KT9");
        monHocKeToan.put("Luật kế toán","KT10");
        nganhMonMapping.put("Kế toán", monHocKeToan);
        
        // Tài chính-Ngân hàng
        HashMap<String, String> monHocTaiChinhNganHang = new HashMap<>();
        monHocTaiChinhNganHang.put("Tài chính doanh nghiệp","NH1");
        monHocTaiChinhNganHang.put("Ngân hàng và chứng khoán","NH2");
        monHocTaiChinhNganHang.put("Quản lý tài chính","NH3");
        monHocTaiChinhNganHang.put("Bảo hiểm","NH4");
        monHocTaiChinhNganHang.put("Kinh tế quốc tế","NH5");
        monHocTaiChinhNganHang.put("Tài chính đầu tư","NH6");
        monHocTaiChinhNganHang.put("Quản trị rủi ro tài chính","NH7");
        monHocTaiChinhNganHang.put("Quản lý tài sản","NH8");
        monHocTaiChinhNganHang.put("Quản trị dự án tài chính","NH9");
        monHocTaiChinhNganHang.put("Luật tài chính","NH10");
        nganhMonMapping.put("Tài chính-Ngân hàng", monHocTaiChinhNganHang);
        
        // Logistic
        HashMap<String, String> monHocLogistic = new HashMap<>();
        monHocLogistic.put("Quản lý chuỗi cung ứng","LG1");
        monHocLogistic.put("Logistics vận tải","LG2");
        monHocLogistic.put("Quản lý kho vận","LG3");
        monHocLogistic.put("Quản trị dịch vụ logistics","LG4");
        monHocLogistic.put("Quản lý lưu trữ","LG5");
        monHocLogistic.put("Quản lý dự án logistics","LG6");
        monHocLogistic.put("Logistics quốc tế","LG7");
        monHocLogistic.put("Quản lý mua hàng và cung cấp","LG8");
        monHocLogistic.put("Kế toán logistics","LG9");
        monHocLogistic.put("Luật logistics","LG10");
        nganhMonMapping.put("Logistic", monHocLogistic);
        
        // Đặt sự kiện cho jbcMon khi khởi tạo nganhMonMapping
        jbcMon.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedMonHoc = (String) jbcMon.getSelectedItem();
            String selectedNganh = (String) jbcNganh.getSelectedItem();
            if (nganhMonMapping.containsKey(selectedNganh)) {
                HashMap<String, String> monHocMap = nganhMonMapping.get(selectedNganh);
                String maMonHoc = monHocMap.get(selectedMonHoc);
                // Ở đây bạn có thể sử dụng mã môn học (maMonHoc) khi cần thiết
            }
        }
    });
        
        // Đặt sự kiện cho jbcNganh
        jbcNganh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateMonHocList();
            }
        });
    }

    public void updateMonHocList() {
        // Lấy ngành được chọn
    String selectedNganh = (String) jbcNganh.getSelectedItem();

    // Kiểm tra xem ngành có trong nganhMonMapping không
    if (nganhMonMapping.containsKey(selectedNganh)) {
        // Nếu có, cập nhật danh sách môn học trong jbcMon
        HashMap<String, String> monHocMap = nganhMonMapping.get(selectedNganh);
        DefaultComboBoxModel model = new DefaultComboBoxModel(monHocMap.keySet().toArray());
        jbcMon.setModel(model);

        // Lấy mã môn học khi một môn học được chọn
        jbcMon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedMonHoc = (String) jbcMon.getSelectedItem();
                String maMonHoc = monHocMap.get(selectedMonHoc);
                // Ở đây bạn có thể sử dụng mã môn học (maMonHoc) khi cần thiết
            }
        });
    } else {
        // Nếu không, đặt jbcMon là trống
        jbcMon.setModel(new DefaultComboBoxModel());
    }
    }
    
    public static void main(String[] args) {
        // Tạo và hiển thị giao diện
        JFrame frame = new JFrame("NganhMon Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComboBox<String> jbcNganh = new JComboBox<>();
        JComboBox<String> jbcMon = new JComboBox<>();

        SubjectField nganhMon = new SubjectField(jbcNganh, jbcMon);

        JPanel panel = new JPanel();
        panel.add(jbcNganh);
        panel.add(jbcMon);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
