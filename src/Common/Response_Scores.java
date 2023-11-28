package Common;

import Lookup.Scores;
import Lookup.StudentInfo;
import java.io.Serializable;
public class Response_Scores implements Serializable {
    private static final long serialVersionUID = 1L;
    private String responseType;
    private StudentInfo studentInfo;
    private Scores scores;
    private int totalCredits;
    private double cgpa;
    private double gpa;
    public Response_Scores(String responseType, StudentInfo studentInfo, Scores scores, int totalCredits, double cgpa, double gpa) {
        this.responseType = responseType;
        this.studentInfo = studentInfo;
        this.scores = scores;
        this.totalCredits = totalCredits;
        this.cgpa = cgpa;
        this.gpa = gpa;
    }

    public String getResponseType() {
        return responseType;
    }

    public StudentInfo getStudentInfo() {
        return studentInfo;
    }

    public Scores getScores() {
        return scores;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public double getCGPA() {
        return cgpa;
    }

    public double getGPA() {
        return gpa;
    }
}