package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class ConfirmationBox {
    static Stage stage;
    static boolean buttonYesClicked;

    public static boolean show (String message, String title, String textYes, String textNo) {
        buttonYesClicked = false;

        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);
        stage.setMinWidth(250);

        Label lbl = new Label();
        lbl.setText(message);

        Button buttonYes = new Button();
        buttonYes.setText(textYes);
        buttonYes.setOnAction(e -> btnYes_Clicked());

        Button buttonNO = new Button();
        buttonNO.setText(textNo);
        buttonNO.setOnAction(e -> btnNo_Clicked());

        HBox paneBtn = new HBox(20);
        paneBtn.getChildren().addAll(buttonYes, buttonNO);

        VBox pane = new VBox(20);
        pane.getChildren().addAll(lbl, paneBtn);
        pane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(pane);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.showAndWait();
        return buttonYesClicked;

    }

    private static void btnNo_Clicked() {
        stage.close();
        buttonYesClicked = false;
    }

    private static void btnYes_Clicked() {
        stage.close();
        buttonYesClicked = true;
    }
}
