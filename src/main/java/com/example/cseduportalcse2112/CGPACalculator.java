package com.example.cseduportalcse2112;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CGPACalculator extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(CSEDUPORTAL.class.getResource("CGPACalculatorScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1100, 680);
        stage.setTitle("CGPA Calculator");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }

    private double[] marks = new double[5];
    private double[] gpa = new double [5];
    private double[] credits = new double[5];
    static double total_credit;
    double cgpa;



    @FXML
    private Label cgpacalculated;

    public void MarkToGpaConverter(double mark1, double mark2, double mark3, double mark4, double mark5) {
        marks[0] = mark1;
        marks[1] = mark2;
        marks[2] = mark3;
        marks[3] = mark4;
        marks[4] = mark5;

        for(int i = 0; i < 5; i++){
            if(marks[i] >= 80 && marks[i] <= 100){
                gpa[i] = 4.00;
            }
            else if(marks[i] < 80 && marks[i] >= 75){
                gpa[i] = 3.75;
            }
            else if(marks[i] < 75 && marks[i] >= 70){
                gpa[i] = 3.50;
            }
            else if(marks[i] < 70 && marks[i] >= 65){
                gpa[i] = 3.25;
            }
            else if(marks[i] < 65 && marks[i] >= 60){
                gpa[i] = 3.00;
            }
            else if(marks[i] < 60 && marks[i] >= 55){
                gpa[i] = 2.75;
            }
            else if(marks[i] < 55 && marks[i] >= 50){
                gpa[i] = 2.50;
            }
            else if(marks[i] < 50 && marks[i] >= 45){
                gpa[i] = 2.25;
            }
            else if(marks[i] < 45 && marks[i] >= 40){
                gpa[i] = 2.00;
            }
            else if(marks[i] < 40 && marks[i] >= 0){
                gpa[i] = 0.00;
            }
            else{
                cgpacalculated.setText("invalid input");
            }


        }

    }
    public void getCredit(){
        credits[0] = 3;
        credits[1] = 3;
        credits[2] = 3;
        credits[3] = 2;
        credits[4] = 3;


    }
    public double getTotal_credit(){
        total_credit = 0;
        for (int i = 0; i < 5; i++) {

            total_credit += credits[i];
        }
        return total_credit;
    }
    public void CgpaCalculator() {

        getCredit();
        double totalcredit = getTotal_credit();
        cgpa = (gpa[0] * credits[0] + gpa[1] * credits[1] + gpa[2] * credits[2] + gpa[3] * credits[3] + gpa[4] * credits[4])/totalcredit;

        String Cgpa = String.valueOf(String.format("%.2f",cgpa));
        cgpacalculated.setText(Cgpa);
    }
    public void reset(){
        cgpa = 0.0;
        String Cgpa = String.valueOf(String.format("%.2f",cgpa));
        cgpacalculated.setText(Cgpa);
    }
}
