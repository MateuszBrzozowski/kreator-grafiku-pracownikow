package pl.mbrzozowski.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import pl.mbrzozowski.modelFx.EmployeeFX;
import pl.mbrzozowski.modelFx.EmployeeModel;
import pl.mbrzozowski.shop.Employee;

import java.io.IOException;
import java.util.ResourceBundle;

public class ShowEmployeeController {
    protected final Logger logger = LoggerFactory.getLogger(getClass().getName());

    private static final String EDIT_EMPLOYEE = "/fxml/editEmployee.fxml";
    private static final String ADD_EMPLOYEE = "/fxml/addEmployee.fxml";
    private static Stage stageAddEmployee;
    private static Stage stageEditEmployee;
    private EmployeeModel employeeModel;
    private ResourceBundle bundle = ResourceBundle.getBundle("bundles.messages");

    @FXML
    private  TableView<EmployeeFX> tableView;
    @FXML
    private  TableColumn<EmployeeFX,Integer> tableViewID;
    @FXML
    private  TableColumn<EmployeeFX,String> tableViewImie;
    @FXML
    private  TableColumn<EmployeeFX,String> tableViewNazwisko;
    @FXML
    private  TableColumn<EmployeeFX,Integer> tableViewWielkoscEtatu;
    @FXML
    private  TableColumn<EmployeeFX,String> tableViewStanowisko;

    public static Stage getStageEditEmployee() {
        return stageEditEmployee;
    }

    @FXML
    public void initialize() {
        this.employeeModel = MainWindowController.getEmployeeModel();
        initTableView();
        tableView.setEditable(true);
        logger.info("Okno Pracownicy zostalo otwarte.");
    }

    @FXML
    public void tableView_Clicked(){
        int id = 0;
        String name = null;
        String surname = null;
        int sizeTime = 0;
        String position = null;
        Employee employee = new Employee(id,name,surname,sizeTime,position);
    }


    public void initTableView(){
        ObservableList<EmployeeFX> employees = FXCollections.observableArrayList();
        employees = employeeModel.getEmployeeList();

        tableViewID.setCellValueFactory(new PropertyValueFactory<EmployeeFX,Integer>("id"));
        tableViewImie.setCellValueFactory(new PropertyValueFactory<EmployeeFX,String>("name"));
        tableViewNazwisko.setCellValueFactory(new PropertyValueFactory<EmployeeFX,String>("surname"));
        tableViewWielkoscEtatu.setCellValueFactory(new PropertyValueFactory<EmployeeFX,Integer>("sizeTime"));
        tableViewStanowisko.setCellValueFactory(new PropertyValueFactory<EmployeeFX,String>("position"));

        tableView.setItems(employees);
    }

    @FXML
    public void buttonAddEmployee_Clicked() throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(ADD_EMPLOYEE));
        stageAddEmployee = new Stage();
        loader.setResources(bundle);
        stageAddEmployee.setTitle(bundle.getString("title.addEmployee"));
        Parent root =loader.load();
        Scene scene = new Scene(root);
        stageAddEmployee.setScene(scene);
        stageAddEmployee.initModality(Modality.APPLICATION_MODAL);
        stageAddEmployee.show();
    }

    @FXML
    public void buttonRefresh_Clicked(MouseEvent event) {
        //TODO odswiezanie tabeli
    }

    @FXML
    public void buttonEditEmployee_Clicked(MouseEvent event) throws IOException {
        //TODO Edytowanie pracownika - stage scena taka  jak dodawanie pracownikow z tym ze tu juz bedzie usupelniona.
        //Pobierany dane z zaznaczonego wiersza w TableView
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(EDIT_EMPLOYEE));
        stageEditEmployee = new Stage();
        loader.setResources(bundle);
        stageEditEmployee.setTitle(bundle.getString("title.editEmployee"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stageEditEmployee.setScene(scene);
        stageEditEmployee.initModality(Modality.APPLICATION_MODAL);
        stageEditEmployee.show();
    }

    public static Stage getStageAddEmployee() {
        return stageAddEmployee;
    }

    @FXML
    public void buttonDeleteEmployee_Clicked() {
        //TODO Usuwanie pracownika - pobiera dane pracownika z zaznaczonego z TableView - pyta czy na pewno usunac
        //i usuwa pracownika z EmployeModel a potem z bazy danych
    }
}
