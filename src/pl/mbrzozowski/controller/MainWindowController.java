package pl.mbrzozowski.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.mbrzozowski.modelFx.EmployeeModel;
import pl.mbrzozowski.shop.Shop;

import javafx.fxml.FXML;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainWindowController {

    private static EmployeeModel employeeModel;
    private static Shop shop;
    protected final Logger logger = LoggerFactory.getLogger(getClass().getName());
    private static Stage stageShowEmployee;
    private static Stage stageScheduleEmployeeGenerator;
    private static final String SHOW_EMPLOYEE = "/fxml/showEmployee.fxml";
    private static final String SCHEDULE_EMPLOYEE_GENERATOR = "/fxml/scheduleEmployeeGenerator.fxml";
    private ResourceBundle bundle = ResourceBundle.getBundle("bundles.messages");


    @FXML
    public void initialize(){
        shop = new Shop("Zara");
//        getAllEmployeFromDatabase();
        this.employeeModel = new EmployeeModel();
        this.employeeModel.init();
        logger.info("Aplikacja uruchomiona poprawnie");
    }

    @FXML
    void buttonWyswietlClicked(MouseEvent event) throws IOException {
        employeeModel.init();
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(SHOW_EMPLOYEE));
        stageShowEmployee = new Stage();
        stageShowEmployee.setTitle(bundle.getString("title.application"));
        loader.setResources(bundle);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stageShowEmployee.setScene(scene);
        stageShowEmployee.initModality(Modality.APPLICATION_MODAL);
        stageShowEmployee.show();
    }

    @FXML
    public void buttonCreateSchedule_Clicked(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(SCHEDULE_EMPLOYEE_GENERATOR));
        stageScheduleEmployeeGenerator = new Stage();
        stageScheduleEmployeeGenerator.setTitle(bundle.getString("title.application"));
        loader.setResources(bundle);
        Parent root = loader.load();
        Scene scene =  new Scene(root);
        stageScheduleEmployeeGenerator.setScene(scene);
        stageScheduleEmployeeGenerator.initModality(Modality.APPLICATION_MODAL);
        stageScheduleEmployeeGenerator.show();
    }
    
    public static Stage getStageScheduleEmployeeGenerator(){ return stageScheduleEmployeeGenerator;}

    public static EmployeeModel getEmployeeModel() {
        return employeeModel;
    }

    public static Shop getShop() {
        return shop;
    }

    public static Stage getStageShowEmployee(){
        return stageShowEmployee;
    }


}
