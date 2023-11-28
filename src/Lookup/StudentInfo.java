package Lookup;

import java.io.Serializable;
import java.sql.Date;

public class StudentInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String hoTen;
    private String phai;
    private String noiSinh;
    private Date ngaySinh;
    private String nganh;
    private String lop;
    

    public StudentInfo(String name, String noiSinh, Date ngaySinh,String phai, String nganh, String lop) {
        this.hoTen = name;
        this.phai = phai;
        this.noiSinh = noiSinh;
        this.ngaySinh = ngaySinh;
        this.nganh = nganh;
        this.lop = lop;  
    }

    public String getName() {
        return hoTen;
    }

    public String getSex() {
        return phai;
    }
    
    public String getPlaceofbirth() {
        return noiSinh;
    }
    
    public Date getDate() {
        return ngaySinh;
    }
    
    public String getMajor() {
        return nganh;
    }
    
    public String getClasses() {
        return lop;
    }
}
