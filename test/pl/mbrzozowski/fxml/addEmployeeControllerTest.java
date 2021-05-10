package pl.mbrzozowski.fxml;

import javafx.scene.control.TextField;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.mbrzozowski.controller.AddEmployeeController;

class addEmployeeControllerTest {
    AddEmployeeController addEmployeeController = new AddEmployeeController();

    @Test
    void validationName_OnlyString_True(){
        //given
        String text = "Mateusz";
        TextField textField = new TextField();
        textField.setText("Test");
        //when then
        Assertions.assertTrue(addEmployeeController.validationString(textField,text));

    }

    @Test
    void validationName_OnlyStringWithOneDigit_False(){
        //given
        String text = "Mateusz1";
        TextField textField = new TextField();
        textField.setText("Test");
        //when then
        Assertions.assertFalse(addEmployeeController.validationString(textField,text));

    }

    @Test
    void validationName_OnlyStringWithOneDigit2_False(){
        //given
        String text = "1Mateusz";
        TextField textField = new TextField();
        textField.setText("Test");
        //when then
        Assertions.assertFalse(addEmployeeController.validationString(textField,text));

    }

    @Test
    void validationId_OnlyInteger_True(){
        //given
        String text = "531";
        //when then
        Assertions.assertTrue(addEmployeeController.validationId(text));
    }

    @Test
    void validationId_IntWithString_False(){
        //given
        String text = "1234M";
        //when then
        Assertions.assertFalse(addEmployeeController.validationId(text));
    }

    @Test
    void validationPosition_StringStanowisko_False() {
        //given
        String text = "Stanowisko";
        //when then
        Assertions.assertFalse(addEmployeeController.validationPosition(text));
    }

    @Test
    void validationPosition_StringStanowiskoWith_True() {
        //given
        String text = "StanowiskoDyrektor";
        //when then
        Assertions.assertTrue(addEmployeeController.validationPosition(text));
    }

    @Test
    void validationPosition_StringDyrektor_True() {
        //given
        String text = "Dyrektor";
        //when then
        Assertions.assertTrue(addEmployeeController.validationPosition(text));
    }
}