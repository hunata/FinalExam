package entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Student {
    private int id;
    private String name;
    private String email;
    private double bonus, report, app, lt, finalScore;

    public Student(int id, String name, String email, double bonus, double report, double app, double LT) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.bonus = bonus;
        this.report = report;
        this.app = app;
        this.lt = lt;
    }

    public int getId() {
        return id;
    }

    public double getFinalScore() {
        return finalScore;
    }

    public double getBonus() {
        return bonus;
    }

    public double getReport() {
        return report;
    }

    public double getApp() {
        return app;
    }

    public double getLt() {
        return lt;
    }

    public Student() {
    }


    public double finalPoint() {
        double finalPoint = (this.bonus * 10) / 100 + (this.report * 30) / 100 + (this.app * 15) / 100 + (this.lt * 45) / 100;
        return finalPoint;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SinhVien{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", Email='").append(email).append('\'');
        sb.append(", bonus=").append(bonus);
        sb.append(", report=").append(report);
        sb.append(", app=").append(app);
        sb.append(", lt=").append(lt);
        sb.append(", finalScore=").append(finalPoint());
        sb.append('}');
        return sb.toString();
    }

    public void addStudentToArrayList(String[] str){
        for (int i =0; i<str.length; i++){
            if(i==0){
                this.id = Integer.parseInt(str[i]);
            } else if (i==1){
                this.name = str[i];
            } else if (i ==2){
                this.email = str[i];
            }else if (i ==3){
                this.bonus = Integer.parseInt(str[i]);
            }else if (i ==4){
                this.report = Integer.parseInt(str[i]);
            }else if (i ==5){
                this.app = Integer.parseInt(str[i]);
            }else if (i ==6){
                this.lt = Integer.parseInt(str[i]);
            }
        }
    }

}
