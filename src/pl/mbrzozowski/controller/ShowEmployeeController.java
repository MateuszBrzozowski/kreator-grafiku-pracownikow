package pl.mbrzozowski.controller;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.mbrzozowski.shop.Employee;
import pl.mbrzozowski.shop.Shop;

import java.util.LinkedList;
import java.util.List;

public class ShowEmployeeController {

    protected final Logger logger = LoggerFactory.getLogger(getClass().getName());
    private List<Employee> employeesCopy = new LinkedList<>();

    @FXML
    private TableView<Employee> tableView;

    @FXML
    private TableColumn<Employee,Integer> tableViewID;

    @FXML
    private TableColumn<Employee,String> tableViewImie;

    @FXML
    private TableColumn<Employee,String> tableViewNazwisko;

    @FXML
    private TableColumn<Employee,Integer> tableViewWielkoscEtatu;

    @FXML
    private TableColumn<Employee,String> tableViewStanowisko;


    public void initialize() {
        employeesCopy = MainWindowController.shop.getEmployees();
        tableViewID.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("id"));
        tableViewImie.setCellValueFactory(new PropertyValueFactory<Employee,String>("name"));
        tableViewNazwisko.setCellValueFactory(new PropertyValueFactory<Employee,String>("secendName"));
        tableViewWielkoscEtatu.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("sizeTime"));
        tableViewStanowisko.setCellValueFactory(new PropertyValueFactory<Employee,String>("position"));
        for (Employee employee: employeesCopy) {
            tableView.getItems().add(employee);
        }
        logger.info("Okno Pokaż/Edytuj/Usuń zostalo otwarte.");
    }
}
