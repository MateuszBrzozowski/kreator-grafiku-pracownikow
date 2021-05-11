package pl.mbrzozowski.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class DBConnector {
    private static String url ="jdbc:mysql://localhost/kreator_grafiku_sklep";
    private static String user ="root";
    private static String pass = "";
    protected static final Logger logger = LoggerFactory.getLogger(DBConnector.class);
    private static Connection connection = null;

    public static Connection connect() {
        try {
            connection = DriverManager.getConnection(url,user,pass);
            logger.info("Połączono z bazą danych");
        } catch (SQLException throwables) {
            logger.error("Połączenie z bazą danych nie udane.");
            throwables.printStackTrace();
        }
        return connection;
    }

    public ResultSet executeSelect(String selectQuery){
        connection=connect();
        try {
            Statement statement = connection.createStatement();
            logger.info("Zapytanie do bazy danych zakończone powodzeniem");
            return statement.executeQuery(selectQuery);
        } catch (SQLException throwables) {
            logger.error("Zapytanie do bazy danych zakończone niepowodzeniem");
            throw new RuntimeException(throwables.getMessage());
        }
    }

    public void executeQuery(String query){
        connection=connect();
        try {
            Statement statement = connection.createStatement();
            logger.info("Zapytanie do bazy danych zakończone powodzeniem");
            statement.execute(query);
        } catch (SQLException throwables) {
            logger.error("Zapytanie do bazy danych zakończone niepowodzeniem");
            throw new RuntimeException(throwables.getMessage());
        }
    }
}
