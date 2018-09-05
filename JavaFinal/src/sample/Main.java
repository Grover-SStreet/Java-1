/**
 * @Author Austin Grover
 * @Version 1.0
 *
 * Main Class for JavaFX Form Application
 */
package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Main
        extends Application {

    // values stored from form
    private int scoreCount = 0;
    private double totalScore = 0.0;
    private double average = 0.0;
    //labels that are updates based on user input
    private Label total = new Label(String.valueOf(totalScore));
    private Label count = new Label(String.valueOf(scoreCount));
    private Label avg = new Label(String.valueOf(average));
    //buttons that provide functionality to application
    private Button addB = new Button("Add");
    private Button clearB = new Button("Clear Scores");
    private Button exitB = new Button("Exit");
    //Text field for user input and error message
    private TextField scoreInput = new TextField();
    private Label errorLabel = new Label("Please enter a valid number greater then 0");


    /**
     * Used when the Add button has an action event.
     *
     * Responsible for calculating average, taking user input and adding to total score, and incrementing score count.
     * This also contains the logic for invalid user inputs.
     *
     * @throws IllegalArgumentException when the input is less then 0, null, or an invalid number
     */
    private class addButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {

            String output = scoreInput.getCharacters().toString();
            try {
                double inputValue = Double.valueOf(output);
                if (inputValue < 0) {
                    throw new IllegalArgumentException();
                }
                totalScore += inputValue;
                errorLabel.setVisible(false);
                scoreCount++;
                count.setText(String.valueOf(scoreCount));
                total.setText(String.valueOf(totalScore));
                scoreInput.setText("");
                average = (totalScore / scoreCount);
                avg.setText(String.valueOf(average));


            } catch (Exception e) {
                errorLabel.setVisible(true);
                scoreInput.setText("");
            }
        }


    }


    /**
     * Used when the clear button has an action event
     * Changes the form values back to the default.
     *
     */
    private class clearButtonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

             scoreCount = 0;
             totalScore = 0.0;
             average = 0.0;


            count.setText(String.valueOf(scoreCount));
            total.setText(String.valueOf(totalScore));
            scoreInput.setText("");
            avg.setText(String.valueOf(average));
            errorLabel.setVisible(false);

        }
    }

    /**
     * Used when the exit button has an action event.
     * Exits the program with exit code 0
     */
    private class exitButtonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Score Calculator");

        GridPane mainLayout = new GridPane();
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.setHgap(10.0);
        mainLayout.setVgap(10.0);
        mainLayout.setPadding(new Insets(25, 25, 25, 25));


        Label scorePrompt = new Label("Score:");
        Label totalPrompt = new Label("Score Total:");
        Label countPrompt = new Label("Score count:");
        Label avgPrompt = new Label("Average:");


        mainLayout.add(scorePrompt, 0, 0, 4, 1);
        mainLayout.add(totalPrompt, 0, 1, 4, 1);
        mainLayout.add(countPrompt, 0, 2, 4, 1);
        mainLayout.add(avgPrompt, 0, 3, 4, 1);
        mainLayout.add(count, 5, 2, 1, 1);
        mainLayout.add(total, 5, 1, 1, 1);
        mainLayout.add(avg, 5, 3, 1, 1);
        mainLayout.add(errorLabel, 0, 12, 6, 1);

        errorLabel.setVisible(false);

        addB.setOnAction(new addButtonHandler());
        clearB.setOnAction(new clearButtonHandler());
        exitB.setOnAction(new exitButtonHandler());


        mainLayout.add(scoreInput, 5, 0, 1, 1);
        mainLayout.add(addB, 6, 0, 1, 1);
        mainLayout.add(clearB, 0, 7, 1, 1);
        mainLayout.add(exitB, 1, 7, 1, 1);


        primaryStage.setScene(new Scene(mainLayout, 500, 500));
        primaryStage.show();


    }
}
