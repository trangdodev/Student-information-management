package Lookup;

import java.io.Serializable;

public class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    private String monHoc; 
    private double diem;
    private int tinChi;

    // Constructors, getters, setters

    public Course(String monHoc, double diem) {
        this.monHoc = monHoc;
        this.diem = diem;
        this.tinChi = tinChi;
    }

    public String getCourseName() {
        return monHoc;
    }

    public double getGrade() {
        return diem;
    }
    
    public double gettinChi() {
        return tinChi;
    }
}