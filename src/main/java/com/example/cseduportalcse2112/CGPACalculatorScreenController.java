package com.example.cseduportalcse2112;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CGPACalculatorScreenController extends CGPACalculator{
    @FXML
    private TextField Textfield1;
    @FXML
    private TextField Textfield2;
    @FXML
    private TextField Textfield3;
    @FXML
    private TextField Textfield4;
    @FXML
    private TextField Textfield5;

    @FXML
    private Label cgpacalculated;




    public void CalculateCgpa(ActionEvent actionEvent) {

        String t1 = Textfield1.getText();
        String t2 = Textfield2.getText();
        String t3 = Textfield3.getText();
        String t4 = Textfield4.getText();
        String t5 = Textfield5.getText();

        double mark1 = Double.parseDouble(t1);
        double mark2 = Double.parseDouble(t2);
        double mark3 = Double.parseDouble(t3);
        double mark4 = Double.parseDouble(t4);
        double mark5 = Double.parseDouble(t5);
        super.MarkToGpaConverter(mark1,mark2,mark3,mark4,mark5);


        super.CgpaCalculator();






    }

    public void Reset(ActionEvent actionEvent) {
        Textfield1.setText(null);
        Textfield2.setText(null);
        Textfield3.setText(null);
        Textfield4.setText(null);
        Textfield5.setText(null);

        super.MarkToGpaConverter(0,0,0,0,0);
        super.reset();
    }
}
