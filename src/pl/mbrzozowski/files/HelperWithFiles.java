package pl.mbrzozowski.helpers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HelperWithFiles {
    private static String pathOLD = "Z:\\PROJECTS_JAVA\\034_KreatorGrafikuPracownikowZara\\resources\\employeeOLD.txt";
    private static String path = "Z:\\PROJECTS_JAVA\\034_KreatorGrafikuPracownikowZara\\resources\\employee.txt";
    static Scanner scanner;

    public static void main(String[] args) {
//        convertFile();
    }

    public static void convertFile(){
        try {
            FileReader fileReader = new FileReader(pathOLD);
            scanner = new Scanner(fileReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i=1;
        while (scanner.hasNextLine()){
            String line=scanner.nextLine();
            line=i+";"+line.replace(" ",";")+";1;Sprzedawca;\n";
            try {
                fileWriter.write(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        i++;
        }

        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
