package Rating;

import java.io.Serializable;

public class Student implements Serializable {

    private String mssv;
    private String hoTen;
    private float diem;

    public Student(String mssv, String hoTen, float diem) {
        this.mssv = mssv;
        this.hoTen = hoTen;
        this.diem = diem;
    }

    public String getMSSV() {
        return mssv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public float getDiem() {
        return diem;
    }
}
