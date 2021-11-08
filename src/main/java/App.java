import entities.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;


public class App {

    private static final String FILENAME = "C:\\Users\\ADMIN\\IdeaProjects\\FinalExam\\StudenList.CSV";
    private static final String FILENAME_OUTLOOK = "C:\\Users\\ADMIN\\IdeaProjects\\FinalExam\\StudenListOutlook.CSV";
    private static final String LINE_BREAKE = "\n";


    public static void main(String[] args) throws Exception {
//        1.1.Đọc danh sách sinh viên từ tập tin data.csv được cung cấp
        ArrayList<Student> listStudent = FileIO.readData(FILENAME);

//       1.2. Liệt kê danh sách 10 sinh viên có điểm thi lý thuyết cao nhất
//       1.3. Tính điểm tổng kết cho từng sinh viên theo công thức: bonus 10%,
//       report 30%, app 15%, lý thuyết 45%; điểm tổng kết được làm tròn đến
//        0.5 (ví dụ: 7.37 -> 7.5, 6.2 -> 6.0)

        Student.sortScoreDes(listStudent);
        for (int f = 0; f < 10; f++) {
            System.out.println("Student " + (f + 1) + "\n " + listStudent.get(f).toString());
        }

//        1.4. Liệt kê danh sách 10 sinh viên có điểm tổng kết thấp nhất lên giao diện
//        console.

        Student.sortFinalScoreInc(listStudent);
        for (int f = 0; f < 10; f++) {
            System.out.println("Student " + (f + 1) + "\n " + listStudent.get(f).toString());
        }

//1.5. Xuất danh sách sinh viên gồm đầy đủ thông tin, bao gồm cả điểm tổng
//    kết vào tập tin output.csv, cột tổng kết được chèn vào phía cuối
        FileIO.writeFile(listStudent, FILENAME);


        //    Câu 2.1: 1. Cho biết chuỗi regular-expression để capture được các địa chỉ gmail và
// outlook
        String pantternGmail = "^[\\w]+@gmail.com";
        String pantternOutlook = "^[\\w]+@gmail.com";

//      Câu 2.2. Xây dựng hàm liệt kê thông tin các sinh viên có email là gmail
        ArrayList<Student> lisGmail = Student.printListStudentGmail(listStudent);
        ArrayList<Student> lisOutlook = Student.printListStudentOutlook(listStudent);

//        Câu 2.3. Chuyển thông tin các sinh viên có email là outlook (II.2) vào tập
//        tin outlook.bin, sử dụng kỹ thuật Serialization.
        FileIO.writeFile(listStudent, FILENAME_OUTLOOK);


//        Câu 2.4. Xây dựng hàm đọc thông tin các sinh viên ở II.3 lên màn hình console
        ArrayList<Student> listStudentOutlook = FileIO.readData(FILENAME_OUTLOOK);
        for (int k = 0; k < 10; k++) {
            System.out.println("Student " + (k + 1) + "\n " + listStudent.get(k).toString());
        }
    }
}



