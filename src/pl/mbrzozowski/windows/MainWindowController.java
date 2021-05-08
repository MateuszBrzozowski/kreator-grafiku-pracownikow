package pl.mbrzozowski.windows;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pl.mbrzozowski.shop.Shop;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MainWindowController {
    Shop shop;



    public void initialize(){
        shop = new Shop("Zara");
        addEmployeeFromFile();
    }

    @FXML
    private Button employeeAdd;

    @FXML
    private Button employeeRemove;

    @FXML
    void employeeAdd_clicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("addEmployee.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Dodaj pracownika");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();

    }

    @FXML
    void employeeRemove_clicked(MouseEvent event) {

    }

    /**
     * Dodaje testowych pracowników z pliku. Przy starcie programu żeby nie trzeba było dodawać
     * za każdym razem.
     */
    private void addEmployeeFromFile() {
        String path = "Z:\\PROJECTS_JAVA\\034_KreatorGrafikuPracownikowZara\\resources\\employee.txt";
        FileReader fileReader;
        Scanner scanner = null;
        try {
            fileReader = new FileReader(path);
            scanner = new Scanner(fileReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            int indexSeperatorStart=0;
            int indexSeperatorEnd=0;
            String[] data = new String[5];
            for (int i = 0; i < 5; i++) {
                for (int j = indexSeperatorStart; j < line.length(); j++) {
                    if(line.charAt(j)==';'){
                        indexSeperatorEnd=j;
                        break;
                    }
                }
                data[i] = line.substring(indexSeperatorStart,indexSeperatorEnd);

                indexSeperatorStart=indexSeperatorEnd+1;
            }
            int id = Integer.parseInt(data[0]);
            String name = data[1];
            String secName = data[2];
            int sizeTime = Integer.parseInt(data[3]);
            String position = data[4];
            shop.addEmployee(id,name,secName,sizeTime,position);
        }

    }
}
