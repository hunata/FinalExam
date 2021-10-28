import entities.Student;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class App {

    private static final String FILENAME = "C:\\Users\\ADMIN\\IdeaProjects\\FinalExam\\StudenList.CSV";
    private static final String LINE_BREAKE= "\n";
    public static void main(String[] args) throws Exception {
        //1.Đọc danh sách sinh viên từ tập tin data.csv được cung cấp
        String data = readFile(FILENAME);
        String[] dataArr = data.split("\r\n");

        ArrayList<Student> listStudent = new ArrayList<>();


        for (int i = 1; i < dataArr.length; i++) {
            Student newStudent = new Student();
            String[] singleStudentData = dataArr[i].split(",");
            newStudent.addStudentToArrayList(singleStudentData);
            listStudent.add(newStudent);
//            System.out.println("listStudent : " + listStudent.get(i-1).toString());
        }
//        for (int j = 0; j < listStudent.size(); j++) {
//            System.out.println("Student " + (j +1) +"\n "+ listStudent.get(j).toString());
//        }

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
//       2. Liệt kê danh sách 10 sinh viên có điểm thi lý thuyết cao nhất
//       3. Tính điểm tổng kết cho từng sinh viên theo công thức: bonus 10%,
//       report 30%, app 15%, lý thuyết 45%; điểm tổng kết được làm tròn đến
//        0.5 (ví dụ: 7.37 -> 7.5, 6.2 -> 6.0)
        for (int f = 0; f < 10; f++) {
            System.out.println("Student " + (f +1) +"\n "+ listStudent.get(f).toString());
        }

//        4. Liệt kê danh sách 10 sinh viên có điểm tổng kết thấp nhất lên giao diện
//        console.
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
        for (int k = 0; k < 10; k++) {
            System.out.println("Student " + (k +1) +"\n "+ listStudent.get(k).toString());
        }



    }

    public static String readFile(String fileName) throws Exception {
        String studentData = "";
        studentData = new String(Files.readAllBytes(Paths.get(fileName)));
        return studentData;
    }

//5. Xuất danh sách sinh viên gồm đầy đủ thông tin, bao gồm cả điểm tổng
//    kết vào tập tin output.csv, cột tổng kết được chèn vào phía cuối

    private static void writeFile(List<String> data, String fileName ){
        try{
            File file = new File(fileName);
            if(!file.exists()){
                File fp = file .getParentFile().getCanonicalFile();
                if (fp !=null){
                    fp.mkdirs();
                }
                file.createNewFile();
            }

            try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))){
                for (String val: data){
                    bw.write;
                    bw.write(LINE_BREAKE);
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


}




