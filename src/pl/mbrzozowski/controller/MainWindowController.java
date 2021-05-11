package pl.mbrzozowski.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.mbrzozowski.database.DBConnector;
import pl.mbrzozowski.shop.Shop;

import javafx.fxml.FXML;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class MainWindowController {
    public static Shop shop;
    public static Stage stageAddEmployee;
    protected final Logger logger = LoggerFactory.getLogger(getClass().getName());
    private static Stage stageShowEmployee;
    public static final String ADD_EMPLOYEE = "/fxml/addEmployee.fxml";
    public static final String SHOW_EMPLOYEE = "/fxml/showEmployee.fxml";
    private ResourceBundle bundle = ResourceBundle.getBundle("bundles.messages");


    public void initialize(){
        shop = new Shop("Zara");
        getAllEmployeFromDatabase();
    }

    @FXML
    void employeeAdd_clicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(ADD_EMPLOYEE));
        stageAddEmployee = new Stage();
        stageAddEmployee.setTitle("Dodaj pracownika");
        Scene scene = new Scene(root);
        stageAddEmployee.setScene(scene);
        stageAddEmployee.initModality(Modality.APPLICATION_MODAL);
        stageAddEmployee.show();

    }

    @FXML
    void employeeRemove_clicked(MouseEvent event) {

    }

    @FXML
    void buttonWyswietlClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(SHOW_EMPLOYEE));
        stageShowEmployee = new Stage();
        stageShowEmployee.setTitle(bundle.getString("title.application"));
        Scene scene = new Scene(root);
        stageShowEmployee.setScene(scene);
        stageShowEmployee.initModality(Modality.APPLICATION_MODAL);
        stageShowEmployee.show();
    }

    /**
     * Pobniera z bazy danych wszystkie rekordy i dodaje do listy w klasie Shop
     */
    private void getAllEmployeFromDatabase() {
        String query = "SELECT * FROM `employee`";
        DBConnector dbConnector = new DBConnector();
        ResultSet resultSet = dbConnector.executeSelect(query);

        while (true){
            try {
                if (!resultSet.next()) break;
                else {
                    int id = resultSet.getInt("ID");
                    String name = resultSet.getString("name");
                    String surname = resultSet.getString("surname");
                    int sizeTime = resultSet.getInt("sizeTime");
                    String position = resultSet.getString("position");
                    shop.addEmployee(id,name,surname,sizeTime,position);

                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        logger.info("Zakończono dodawanie wszystkich pracowników z bazy danych");
        shop.showAllEmployee();
    }

    /**
     * Dodaje testowych pracowników z pliku. Przy starcie programu żeby nie trzeba było dodawać
     * za każdym razem. Używane przed Bazą danych //TODO usunąć to. zbędne
     */
    /*
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
            shop.addEmployeeFromFileInitApp(id,name,secName,sizeTime,position);

        }
        logger.info("Dodano pracowników z pliku [{}]",path);
    }

     */


}
