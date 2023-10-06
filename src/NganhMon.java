
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
public class NganhMon {
    private JComboBox<String> jbcNganh;
    private JComboBox<String> jbcMon;
    private HashMap<String, ArrayList<String>> nganhMonMapping;

    public NganhMon(JComboBox<String> jbcNganh, JComboBox<String> jbcMon) {
        this.jbcNganh = jbcNganh;
        this.jbcMon = jbcMon;
        
        // Khởi tạo nganhMonMapping và điền dữ liệu
        nganhMonMapping = new HashMap<>();
        
        // Công nghệ thông tin
        ArrayList<String> monHocCNTT = new ArrayList<>();
        monHocCNTT.add("Java");
        monHocCNTT.add("C++");
        monHocCNTT.add("Python");
        monHocCNTT.add("Web Development");
        monHocCNTT.add("Mobile App Development");
        monHocCNTT.add("Database Management");
        monHocCNTT.add("Artificial Intelligence");
        monHocCNTT.add("Computer Networks");
        monHocCNTT.add("Software Engineering");
        monHocCNTT.add("Cybersecurity");
        nganhMonMapping.put("Công nghệ thông tin", monHocCNTT);
        
        // Quản trị kinh doanh
        ArrayList<String> monHocQuanTriKinhDoanh = new ArrayList<>();
        monHocQuanTriKinhDoanh.add("Quản trị doanh nghiệp");
        monHocQuanTriKinhDoanh.add("Marketing");
        monHocQuanTriKinhDoanh.add("Kế hoạch kinh doanh");
        monHocQuanTriKinhDoanh.add("Tài chính doanh nghiệp");
        monHocQuanTriKinhDoanh.add("Quản lý nhân sự");
        monHocQuanTriKinhDoanh.add("Phân tích thị trường");
        monHocQuanTriKinhDoanh.add("Quản lý sản phẩm");
        monHocQuanTriKinhDoanh.add("Luật kinh doanh");
        monHocQuanTriKinhDoanh.add("Quản lý dự án");
        monHocQuanTriKinhDoanh.add("Quản trị rủi ro");
        nganhMonMapping.put("Quản trị kinh doanh", monHocQuanTriKinhDoanh);
        
        // Kế toán
        ArrayList<String> monHocKeToan = new ArrayList<>();
        monHocKeToan.add("Kế toán tài chính");
        monHocKeToan.add("Kế toán quản trị");
        monHocKeToan.add("Kiểm toán");
        monHocKeToan.add("Thuế và quyết toán thuế");
        monHocKeToan.add("Học phân tích tài chính");
        monHocKeToan.add("Kế toán ngân hàng");
        monHocKeToan.add("Kế toán chi phí");
        monHocKeToan.add("Kế toán hành chính sự nghiệp");
        monHocKeToan.add("Kế toán quốc tế");
        monHocKeToan.add("Luật kế toán");
        nganhMonMapping.put("Kế toán", monHocKeToan);
        
        // Tài chính-Ngân hàng
        ArrayList<String> monHocTaiChinhNganHang = new ArrayList<>();
        monHocTaiChinhNganHang.add("Tài chính doanh nghiệp");
        monHocTaiChinhNganHang.add("Ngân hàng và chứng khoán");
        monHocTaiChinhNganHang.add("Quản lý tài chính");
        monHocTaiChinhNganHang.add("Bảo hiểm");
        monHocTaiChinhNganHang.add("Kinh tế quốc tế");
        monHocTaiChinhNganHang.add("Tài chính đầu tư");
        monHocTaiChinhNganHang.add("Quản trị rủi ro tài chính");
        monHocTaiChinhNganHang.add("Quản lý tài sản");
        monHocTaiChinhNganHang.add("Quản trị dự án tài chính");
        monHocTaiChinhNganHang.add("Luật tài chính");
        nganhMonMapping.put("Tài chính-Ngân hàng", monHocTaiChinhNganHang);
        
        // Logistic
        ArrayList<String> monHocLogistic = new ArrayList<>();
        monHocLogistic.add("Quản lý chuỗi cung ứng");
        monHocLogistic.add("Logistics vận tải");
        monHocLogistic.add("Quản lý kho vận");
        monHocLogistic.add("Quản trị dịch vụ logistics");
        monHocLogistic.add("Quản lý lưu trữ");
        monHocLogistic.add("Quản lý dự án logistics");
        monHocLogistic.add("Logistics quốc tế");
        monHocLogistic.add("Quản lý mua hàng và cung cấp");
        monHocLogistic.add("Kế toán logistics");
        monHocLogistic.add("Luật logistics");
        nganhMonMapping.put("Logistic", monHocLogistic);

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
            ArrayList<String> monHocList = nganhMonMapping.get(selectedNganh);
            DefaultComboBoxModel model = new DefaultComboBoxModel(monHocList.toArray());
            jbcMon.setModel(model);
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

        NganhMon nganhMon = new NganhMon(jbcNganh, jbcMon);

        JPanel panel = new JPanel();
        panel.add(jbcNganh);
        panel.add(jbcMon);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
