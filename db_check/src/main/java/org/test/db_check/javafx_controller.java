package org.test.db_check;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

@Component
public class javafx_controller {

    @FXML
    public TextField ID;
    @FXML
    public TextField Name;
    @FXML
    public Label dialouge;

    @Autowired
    StudentServiceImppl serviceImppl;

    // Method to validate numeric input for the ID field
    @FXML
    public void validate(KeyEvent event) {
        // If the Id is not numeric then the data will be not shown
        String input = ID.getText();
        if (!input.matches("\\d*")) { // Ensure input consists only of digits
            if (!input.isEmpty()) {
                ID.setText(input.substring(0, input.length() - 1));
                ID.positionCaret(ID.getText().length());
            }
            // ID.setText(""); // Clear the field if input is not numeric

        }
    }

    public void insertData(ActionEvent event) {

        System.out.println("\n\nthe data : " + ID.getText() + "\n" + Name.getText());

        try {
            // Retriving the data from the textfeilds
            Integer id = Integer.valueOf(ID.getText());
            String name = Name.getText();

            // Making the student object
            Student dataStudent = new Student();
            dataStudent.setSid(id);
            dataStudent.setSName(name);
            // sending the data to the database
            serviceImppl.AddData(dataStudent);

            // Adding the sucessful message to the Ui
            dialouge.setText("Added Data Sucessfully");

        } catch (Exception e) {

            System.out.println(e);
            dialouge.setText("Data was not added");
        } finally {

            // Clearing the Textfeilds
            ID.clear();
            Name.clear();
        }
    }

}
