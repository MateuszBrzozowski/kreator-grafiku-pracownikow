package pl.mbrzozowski.modelFx;

import pl.mbrzozowski.database.DBConnector;

import java.sql.ResultSet;

public class EmployeeModel {

    public void addEmployeeToDatabase(String name, String surname, int sizeTime, String position){
        String query = "INSERT INTO `employee`(`name`, `surname`, `sizeTime`, `position`) VALUES ('%s','%s','%d','%s')";
        DBConnector connector = new DBConnector();
        connector.executeQuery(String.format(query,name,surname,sizeTime,position));
    }

    public ResultSet getAllEmployeeFromDataBase(){
        String query = "SELECT * FROM `employee`";
        DBConnector dbConnector = new DBConnector();
        ResultSet resultSet = dbConnector.executeSelect(query);
        return resultSet;
    }
}
