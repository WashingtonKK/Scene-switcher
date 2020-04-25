package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {
    Button Switch0;
    Button Switch1;

    Button Click;
    Button btnAdd;
    Button btnSubtract;

    Label lbl1;
    Label lbl2;

    int iCounter;
    int iCounter1;

    Stage stage;

    Scene scene;
    Scene scene1;

    //Nodes to create a dialog box

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        stage = primaryStage;
        Switch0 = new Button();
        Switch0.setText("Switch");
        Switch0.setOnAction(e -> switchMethod());

        Switch1 = new Button();
        Switch1.setText("Switch");
        Switch1.setOnAction(e -> switchMethod1());

        Click = new Button();
        Click.setText("Click me please");
        Click.setOnAction(e -> {
            iCounter++;
            lbl1.setText("You have clicked me " + iCounter + " times");
            if (iCounter == 1) {
                MessageBox.show("You have clicked once!" , "Click");
            } else
                MessageBox.show("You have clicked " +iCounter + " times", "Click!" );
        });

        btnSubtract = new Button();
        btnSubtract.setText("Subtract");
        btnSubtract.setOnAction(e -> Subtract());

        btnAdd = new Button();
        btnAdd.setText("Add");
        btnAdd.setOnAction(e -> Add() );

        lbl1 = new Label();
        lbl1.setText("You have not clicked the button");

        lbl2 = new Label();
        lbl2.setText(Integer.toString(iCounter1));

        HBox pane = new HBox(10);
        pane.getChildren().addAll(lbl2,btnAdd, btnSubtract,Switch0);
        scene = new Scene(pane, 400, 400);

        BorderPane pane1 = new BorderPane();
        pane1.setCenter(Click);
        pane1.setBottom(Switch1);
        pane1.setTop(lbl1);
        scene1 = new Scene(pane1, 400, 400);

        //Dialog box

        primaryStage.setTitle("Scene changer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void switchMethod1() {
        boolean proceed;
        proceed = ConfirmationBox.show("Are you sure you want to switch?", "Confirmation", "YES", "NO");

        if (proceed == true) {
            stage.setScene(scene);
            stage.setTitle("Add-subtract");
        } else
            MessageBox.show("Try again later, when you agree!!" , "Confirmation required");
    }

    private void Add() {
        iCounter1++;
        lbl2.setText(Integer.toString(iCounter1));
    }

    private void Subtract() {
        iCounter1--;
        lbl2.setText(Integer.toString(iCounter1));
    }

    private void switchMethod() {
        boolean proceed;
        proceed = ConfirmationBox.show("Are you sure you want to switch?", "Confirmation", "YES", "NO");

        if (proceed == true) {
            stage.setScene(scene1);
            stage.setTitle("Add-subtract");
        } else
            MessageBox.show("Try again later, when you agree!!" , "Confirmation required");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
