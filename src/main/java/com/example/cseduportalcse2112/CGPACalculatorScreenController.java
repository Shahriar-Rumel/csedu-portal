package com.example.cseduportalcse2112;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CGPACalculatorScreenController extends CGPACalculator implements Initializable {
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
    private ImageView cgpaCalculatorIcon;
    @FXML
    private Label cgpacalculated;

    @FXML
    private Text coursecode1;
    @FXML
    private Text coursecode2;
    @FXML
    private Text coursecode3;
    @FXML
    private Text coursecode4;
    @FXML
    private Text coursecode5;

    @FXML
    private Text coursecredit1;
    @FXML
    private Text coursecredit2;
    @FXML
    private Text coursecredit3;
    @FXML
    private Text coursecredit4;
    @FXML
    private Text coursecredit5;
    //Navigation
    @FXML
    private Text home;
    @FXML
    private Text classroom;
    @FXML
    private Text attendance;
    @FXML
    private Text booklet;
    @FXML
    private Text cgpa;
    @FXML
    private Text logout;
    @FXML
    private ImageView LogoutImage;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        NavigationHandler.HandleNavigation(home,classroom,attendance,booklet,cgpa,logout);

        LogoutImage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                CSEDUPORTALUtils.changeScenceforMouseEvent(mouseEvent,"LoginScreen.fxml","Log in",null);
            }
        });
        cgpaCalculatorIcon.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                CSEDUPORTALUtils.changeScenceforMouseEvent(mouseEvent,"CGPACalculatorScreen.fxml","CGPA Calculator",null);
            }
        });
//        studentName.setText(getStudentName());
//        upcomingclassname1.setText(getUpcomingList());
//        upcomingclassteachername1.setText(getTeacherName());

        ArrayList<String>CourseCode = new ArrayList<>();
        ArrayList<String>CourseCredit = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            CourseCode.add(DBDATAGETTER.getCourseCode().get(i));

            CourseCredit.add(DBDATAGETTER.getCourseCredit().get(i));
        }
        coursecode1.setText(CourseCode.get(0));
        coursecode2.setText(CourseCode.get(1));
        coursecode3.setText(CourseCode.get(2));
        coursecode4.setText(CourseCode.get(3));
        coursecode5.setText(CourseCode.get(4));

        coursecredit1.setText(CourseCredit.get(0));
        coursecredit2.setText(CourseCredit.get(1));
        coursecredit3.setText(CourseCredit.get(2));
        coursecredit4.setText(CourseCredit.get(3));
        coursecredit5.setText(CourseCredit.get(4));




    }


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
