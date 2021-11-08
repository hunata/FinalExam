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
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

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
    public static void writeFile(ArrayList<Student> data, String fileName) {
        FileWriter fileWriter = null;
        try {

            fileWriter = new FileWriter(fileName);

            // Write the CSV file header
            fileWriter.append("ID,Name,Email,Bonus,Report,App,LT,finalScore");

            // Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);

            // Write a new Country object list to the CSV file
            for (Student st : data) {
                fileWriter.append(String.valueOf(st.getId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(st.getName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(st.getEmail());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(st.getBonus()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(st.getReport()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(st.getApp()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(st.getLt()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(st.getFinalScore()));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
//            String.valueOf(st.getId())
            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }
}

