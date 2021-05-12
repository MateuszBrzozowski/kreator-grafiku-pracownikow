package pl.mbrzozowski.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.mbrzozowski.shop.Employee;

import java.io.IOException;
import java.util.ResourceBundle;

public class ShowEmployeeController {

    protected final Logger logger = LoggerFactory.getLogger(getClass().getName());
    private static final String ADD_EMPLOYEE = "/fxml/addEmployee.fxml";
    private static Stage stageAddEmployee;
    private ObservableList<Employee> employees = FXCollections.observableArrayList();

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
        initTableView();
        tableView.setEditable(true);
        logger.info("Okno Pokaż/Edytuj/Usuń zostalo otwarte.");
    }

    @FXML
    public void tableView_Clicked(){
        int id = 0;
        String name = null;
        String surname = null;
        int sizeTime = 0;
        String position = null;



//        TablePosition tablePosition = tableView.getSelectionModel().getSelectedCells().get(0);
//        int row = tablePosition.getRow();
//        Employee e = tableView.getSelectionModel().getSelectedItem();
//        TableColumn column = tablePosition.getTableColumn();
//
//        String data = (String) column.getCellObservableValue(e).getValue();

//        logger.info(data);


        Employee employee = new Employee(id,name,surname,sizeTime,position);
    }


    public void initTableView(){
        //TODO wyświetlanie tabeli z bazy dancyh
        //TODO odswiezanie

        tableViewID.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("id"));
        tableViewImie.setCellValueFactory(new PropertyValueFactory<Employee,String>("name"));
        tableViewNazwisko.setCellValueFactory(new PropertyValueFactory<Employee,String>("surname"));
        tableViewWielkoscEtatu.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("sizeTime"));
        tableViewStanowisko.setCellValueFactory(new PropertyValueFactory<Employee,String>("position"));
        for (Employee employee: MainWindowController.getShop().getEmployees()) {
            employees.add(employee);
        }
        tableView.setItems(employees);
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

    @FXML
    public void buttonRefresh_Clicked(MouseEvent event) {
        //TODO odswiezanie tabeli
    }
}
