package pl.mbrzozowski.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShowEmployeeController {

    protected final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> tableViewID;

    @FXML
    private TableColumn<?, ?> tableViewImie;

    @FXML
    private TableColumn<?, ?> tableViewNazwisko;

    @FXML
    private TableColumn<?, ?> tableViewWielkoscEtatu;

    @FXML
    private TableColumn<?, ?> tableViewStanowisko;

    public void initialize() {

        logger.info("Okno Pokaż/Edytuj/Usuń zostalo otwarte.");
    }
}
