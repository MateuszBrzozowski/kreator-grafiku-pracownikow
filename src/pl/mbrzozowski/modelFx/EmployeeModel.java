package pl.mbrzozowski.modelFx;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.mbrzozowski.database.DBConnector;
import pl.mbrzozowski.shop.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class EmployeeModel {

    protected final Logger logger = LoggerFactory.getLogger(getClass().getName());

    private ObservableList<EmployeeFX> employeeList = FXCollections.observableArrayList();
    private ObjectProperty<EmployeeFX> employeeSelected = new SimpleObjectProperty<>(new EmployeeFX());

    public void init(){
        ResultSet resultSet = getAllEmployeeFromDataBase();
        List<Employee> employeeLinkedList = new LinkedList<>();
        this.employeeList.clear();

        if (resultSet!=null){
            while (true){
                try {
                    if (!resultSet.next()) break;
                    else {
                        int id = resultSet.getInt("ID");
                        String name = resultSet.getString("employee.name");
                        String surname = resultSet.getString("employee.surname");
                        int sizeTime = resultSet.getInt("sizeTime");
                        String position = resultSet.getString("position");
                        Employee employee = new Employee(id,name,surname,sizeTime,position);
                        employeeLinkedList.add(employee);
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            employeeLinkedList.forEach(e -> {
                EmployeeFX employeeFX = new EmployeeFX(e.getId(),e.getName(),e.getSurname(),e.getSizeTime(),e.getPosition());
                this.employeeList.add(employeeFX);
            });
        }

    }

    public void addEmployeeToDatabase(String name, String surname, int sizeTime, String position){
        String query = "INSERT INTO `employee`(`name`, `surname`, `sizeTime`, `position`) VALUES ('%s','%s','%d','%s')";
        DBConnector connector = new DBConnector();
        connector.executeQuery(String.format(query,name,surname,sizeTime,position));
    }

    public void updateEmployeDataBase(int id, String name, String surname, int sizeTime, String position){
        String query = "UPDATE `employee` SET `name`='%s',`surname`='%s',`sizeTime`='%d',`position`='%s' WHERE id=%d";
        DBConnector connector = new DBConnector();
        connector.executeQuery(String.format(query,name,surname,sizeTime,position,id));
    }

    public ResultSet getAllEmployeeFromDataBase(){
        String query = "SELECT * FROM `employee`";
        DBConnector dbConnector = new DBConnector();
        ResultSet resultSet = null;
        try{
           resultSet = dbConnector.executeSelect(query);
        }catch (Exception e){
            logger.error("Brak tabeli employee w bazie danych. -> Tworze tabele");
            String queryCreate ="CREATE TABLE employee(" +
                    "id INT(5)  UNSIGNED AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(30) NOT NULL," +
                    "surname VARCHAR(30) NOT NULL," +
                    "sizeTime INT(5)," +
                    "position VARCHAR(30))";
            dbConnector.executeQuery(queryCreate);
        }
        return resultSet;
    }

    public void deleteByID(Integer id){
        String query = "DELETE FROM `employee` WHERE id=%d";
        DBConnector connector = new DBConnector();
        connector.executeQuery(String.format(query,id));
    }

    public ObservableList<EmployeeFX> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(ObservableList<EmployeeFX> employeeList) {
        this.employeeList = employeeList;
    }

    public EmployeeFX getEmployeeSelected() {
        return employeeSelected.get();
    }

    public ObjectProperty<EmployeeFX> employeeSelectedProperty() {
        return employeeSelected;
    }

    public void setEmployeeSelected(EmployeeFX employeeSelected) {
        this.employeeSelected.set(employeeSelected);
    }
}
