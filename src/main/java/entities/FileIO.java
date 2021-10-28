package entities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileIO {

    public static ArrayList<Student> readData(String fileName) throws IOException {
        String studentData = "";
        studentData = new String(Files.readAllBytes(Paths.get(fileName)));
        String[] dataArr = studentData.split("\r\n");
        ArrayList<Student> listStudent = new ArrayList<>();

        for (int i = 1; i < dataArr.length; i++) {
            Student newStudent = new Student();
            String[] singleStudentData = dataArr[i].split(",");
            newStudent.addStudentToArrayList(singleStudentData);
            listStudent.add(newStudent);
        }
        return listStudent;
    }

// Chưa xong
//    private static void writeFile(List<String> data, String fileName ){
//        try{
//            File file = new File(fileName);
//            if(!file.exists()){
//                File fp = file .getParentFile().getCanonicalFile();
//                if (fp !=null){
//                    fp.mkdirs();
//                }
//                file.createNewFile();
//            }
//
//            try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))){
//                for (String val: data){
//                    bw.write;
//                    bw.write(LINE_BREAKE);
//                }
//            } catch (Exception e){
//                e.printStackTrace();
//            }
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//    }
}
