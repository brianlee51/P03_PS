package sg.edu.rp.c346.p03_ps;

import java.io.Serializable;

public class Details implements Serializable {
    private int week;
    private String grade;

    public Details(int week, String grade) {
        this.week = week;
        this.grade = grade;
    }
    public int getWeek() {
        return week;
    }
    public void setWeek(int week) {
        this.week = week;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
}
