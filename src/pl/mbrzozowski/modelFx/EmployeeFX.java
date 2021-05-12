package pl.mbrzozowski.modelFx;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EmployeeFX {
    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty name = new SimpleStringProperty();
    private StringProperty surname = new SimpleStringProperty();
    private IntegerProperty sizeTime = new SimpleIntegerProperty(); // 1 - pelny etat; 2 - polowa etatu itd.
    private StringProperty position = new SimpleStringProperty();

    public EmployeeFX(int id, String name, String surname, int sizeTime, String position) {
        IntegerProperty idProperty = new SimpleIntegerProperty(id);
        this.id = idProperty;
        StringProperty nameProperty = new SimpleStringProperty(name);
        this.name = nameProperty;
        StringProperty surnameProperty = new SimpleStringProperty(surname);
        this.surname = surnameProperty;
        IntegerProperty sizeTimeProperty = new SimpleIntegerProperty(sizeTime);
        this.sizeTime = sizeTimeProperty;
        StringProperty positionProperty = new SimpleStringProperty(position);
        this.position = positionProperty;
    }

    public EmployeeFX() {
    }


    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSurname() {
        return surname.get();
    }

    public StringProperty surnameProperty() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public int getSizeTime() {
        return sizeTime.get();
    }

    public IntegerProperty sizeTimeProperty() {
        return sizeTime;
    }

    public void setSizeTime(int sizeTime) {
        this.sizeTime.set(sizeTime);
    }

    public String getPosition() {
        return position.get();
    }

    public StringProperty positionProperty() {
        return position;
    }

    public void setPosition(String position) {
        this.position.set(position);
    }
}
