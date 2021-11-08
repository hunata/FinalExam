package entities;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Student {
    private int id;
    private String name;
    private String email;
    private double bonus, report, app, lt, finalScore;
    private static final String PTGMAIL = "^[\\w]+@gmail.com";
    private static final String PTOUTLOOK = "^[\\w]+@outlook.com";


    public Student(int id, String name, String email, double bonus, double report, double app, double LT) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.bonus = bonus;
        this.report = report;
        this.app = app;
        this.lt = lt;
        this.finalScore = (this.bonus * 10) / 100 + (this.report * 30) / 100 + (this.app * 15) / 100 + (this.lt * 45) / 100;
    }

    public int getId() {
        return id;
    }

    public double getFinalScore() {


        return (this.bonus * 10) / 100 + (this.report * 30) / 100 + (this.app * 15) / 100 + (this.lt * 45) / 100;
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

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Student() {
    }


//    public double finalPoint() {
//        double finalPoint = (this.bonus * 10) / 100 + (this.report * 30) / 100 + (this.app * 15) / 100 + (this.lt * 45) / 100;
//        return finalPoint;
//    }

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
        sb.append(", finalScore=").append(getFinalScore());
        sb.append('}');
        return sb.toString();
    }

    public void addStudentToArrayList(String[] str) {
        for (int i = 0; i < str.length; i++) {
            if (i == 0) {
                this.id = Integer.parseInt(str[i]);
            } else if (i == 1) {
                this.name = str[i];
            } else if (i == 2) {
                this.email = str[i];
            } else if (i == 3) {
                this.bonus = Integer.parseInt(str[i]);
            } else if (i == 4) {
                this.report = Integer.parseInt(str[i]);
            } else if (i == 5) {
                this.app = Integer.parseInt(str[i]);
            } else if (i == 6) {
                this.lt = Integer.parseInt(str[i]);
            }
        }
    }

    public static ArrayList<Student> sortScoreDes(ArrayList<Student> listStudent) {
        Collections.sort(listStudent, new Comparator<Student>() {

            @Override
            public int compare(Student st1, Student st2) {
                if (st1.getLt() < st2.getLt()) {
                    return 1;
                } else {
                    if (st1.getLt() == st2.getLt()) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            }
        });
        return listStudent;
    }

    public static ArrayList<Student> sortFinalScoreInc(ArrayList<Student> listStudent) {
        Collections.sort(listStudent, new Comparator<Student>() {

            @Override
            public int compare(Student st1, Student st2) {
                if (st1.getFinalScore() < st2.getFinalScore()) {
                    return -1;
                } else {
                    if (st1.getFinalScore() == st2.getFinalScore()) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            }
        });
        return listStudent;
    }

    public boolean isGmail() {
        return this.email.matches(PTGMAIL);
    }

    public boolean isOutlook() {
        return this.email.matches(PTOUTLOOK);
    }

    public static ArrayList<Student> printListStudentGmail(ArrayList<Student> st) {
        ArrayList<Student> st1 = new ArrayList<>();
        for (Student tmpST : st) {
            if (tmpST.isGmail()) {
                st1.add(tmpST);
            }
        }
        for(Student rs : st1){
            System.out.println(rs);
        } return st1;
    }
    public static ArrayList<Student> printListStudentOutlook(ArrayList<Student> st) {
        ArrayList<Student> st1 = new ArrayList<>();
        for (Student tmpST : st) {
            if (tmpST.isGmail()) {
                st1.add(tmpST);
            }
        }
        for(Student rs : st1){
            System.out.println(rs);
        }return st1;
    }
}
