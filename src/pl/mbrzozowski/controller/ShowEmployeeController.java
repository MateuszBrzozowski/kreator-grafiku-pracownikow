package pl.mbrzozowski.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
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
    private EmployeeFX selectedEmployeeFX;
    private ResourceBundle bundle = ResourceBundle.getBundle("bundles.messages");

    @FXML
    private  TableView<EmployeeFX> tableView;
    @FXML
    private  TableColumn<EmployeeFX,Number> tableViewID;
    @FXML
    private  TableColumn<EmployeeFX,String> tableViewImie;
    @FXML
    private  TableColumn<EmployeeFX,String> tableViewNazwisko;
    @FXML
    private  TableColumn<EmployeeFX,Number> tableViewWielkoscEtatu;
    @FXML
    private  TableColumn<EmployeeFX,String> tableViewStanowisko;

    public static Stage getStageEditEmployee() {
        return stageEditEmployee;
    }

    @FXML
    public void initialize() {
        this.employeeModel = MainWindowController.getEmployeeModel();
        initTableView();
        logger.info("Okno Pracownicy zostalo otwarte.");
    }

    @FXML
    public void tableView_Clicked(){
        TablePosition pos = tableView.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();

        selectedEmployeeFX = tableView.getItems().get(row);
        employeeModel.setEmployeeSelected(selectedEmployeeFX);

        logger.info("Wybrano [{}] - {} {}",selectedEmployeeFX.getId(),selectedEmployeeFX.getName(),selectedEmployeeFX.getSurname());
    }


    public void initTableView(){
        ObservableList<EmployeeFX> employees = FXCollections.observableArrayList();
        employees = employeeModel.getEmployeeList();

        tableView.setItems(employees);
        this.tableViewID.setCellValueFactory(employeeFXIntegerCellDataFeatures -> employeeFXIntegerCellDataFeatures.getValue().idProperty());
        this.tableViewImie.setCellValueFactory(employeeFXStringCellDataFeatures -> employeeFXStringCellDataFeatures.getValue().nameProperty());
        this.tableViewNazwisko.setCellValueFactory(employeeFXStringCellDataFeatures -> employeeFXStringCellDataFeatures.getValue().surnameProperty());
        this.tableViewStanowisko.setCellValueFactory(employeeFXStringCellDataFeatures -> employeeFXStringCellDataFeatures.getValue().positionProperty());
        this.tableViewWielkoscEtatu.setCellValueFactory(employeeFXIntegerCellDataFeatures -> employeeFXIntegerCellDataFeatures.getValue().sizeTimeProperty());
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
        //TODO jeżli jest zaznaczony wiersz w Table View to otwórz editable Employee
        try {
            if (selectedEmployeeFX.getName()!=null){
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
        }catch (NullPointerException e){
            logger.info("Nie wybrano pracownika do edycji.");
        }


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
