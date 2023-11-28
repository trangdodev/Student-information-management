package Lookup;

import java.io.Serializable;
import java.util.List;

public class Scores implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Course> courses;
    
    
    public Scores (List<Course> courses) {
        this.courses = courses;
    }
    
    public List<Course> getCourses() {
        return courses;
    }
}
