package pl.mbrzozowski.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.mbrzozowski.shop.Employee;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class ShowEmployeeController {

    protected final Logger logger = LoggerFactory.getLogger(getClass().getName());
    private static final String ADD_EMPLOYEE = "/fxml/addEmployee.fxml";
    private static Stage stageAddEmployee;

    @FXML
    private  TableView<Employee> tableView;

    @FXML
    private  TableColumn<Employee,Integer> tableViewID;

    @FXML
    private  TableColumn<Employee,String> tableViewImie;

    @FXML
    private  TableColumn<Employee,String> tableViewNazwisko;

    @FXML
    private  TableColumn<Employee,Integer> tableViewWielkoscEtatu;

    @FXML
    private  TableColumn<Employee,String> tableViewStanowisko;

    @FXML
    public void initialize() {
        updateTableView();
        logger.info("Okno Pokaż/Edytuj/Usuń zostalo otwarte.");
    }


    public void updateTableView(){
        //TODO wyświetlanie tabeli z bazy dancyh
        tableViewID.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("id"));
        tableViewImie.setCellValueFactory(new PropertyValueFactory<Employee,String>("name"));
        tableViewNazwisko.setCellValueFactory(new PropertyValueFactory<Employee,String>("secendName"));
        tableViewWielkoscEtatu.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("sizeTime"));
        tableViewStanowisko.setCellValueFactory(new PropertyValueFactory<Employee,String>("position"));
        for (Employee employee: MainWindowController.getShop().getEmployees()) {
            tableView.getItems().add(employee);
        }
    }

    @FXML
    public void buttonAddEmployee_Clicked() throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(ADD_EMPLOYEE));
        stageAddEmployee = new Stage();
        ResourceBundle bundle = ResourceBundle.getBundle("bundles.messages");
        loader.setResources(bundle);
        stageAddEmployee.setTitle(bundle.getString("title.addEmployee"));
        Parent root =loader.load();
        Scene scene = new Scene(root);
        stageAddEmployee.setScene(scene);
        stageAddEmployee.initModality(Modality.APPLICATION_MODAL);
        stageAddEmployee.show();
    }

    public static Stage getStageAddEmployee() {
        return stageAddEmployee;
    }

    public ShowEmployeeController getShowEmployeeController(){
        return this;
    }

    @FXML
    public void buttonRefresh_Clicked(MouseEvent event) {
        updateTableView();
    }
}
