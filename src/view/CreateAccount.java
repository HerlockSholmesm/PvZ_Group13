package view;

import in_game.Account;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicReference;

public class CreateAccount extends Application {
    static Stage initiateStage;
    public static Account mainAccount;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage myStage) {
        myStage.setTitle("CreateAccount");

        GridPane rootNode = new GridPane();
        rootNode.setPadding(new Insets(15));
        rootNode.setHgap(5);
        rootNode.setVgap(5);
        rootNode.setAlignment(Pos.CENTER);

        Scene myScene = new Scene(rootNode, 300, 200);

        rootNode.add(new Label("userName"), 0, 0);
        TextField firstValue = new TextField();
        rootNode.add(firstValue, 1, 0);
        rootNode.add(new Label("password"), 0, 1);
        TextField secondValue = new TextField();
        rootNode.add(secondValue, 1, 1);
        rootNode.add(new Label("createAccount"), 0, 2);
        Button aButton = new Button("createAccount");
        rootNode.add(aButton, 1, 2);
        GridPane.setHalignment(aButton, HPos.LEFT);

        aButton.setOnAction(e -> {
            String s = Account.findAccount2(firstValue.getText(), secondValue.getText());
            if (s.equals("find") || s.equals("invalid password")){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Plants vs. Zombies");
                alert.setHeaderText("error:(");
                alert.setContentText("this account already existed");
                System.out.println(s);
                alert.showAndWait();
                Loginmenu loginmenu = new Loginmenu();
                try {
                    loginmenu.start(myStage);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                mainAccount = new Account(firstValue.getText(), secondValue.getText());
            }
            Loginmenu mainmenu = new Loginmenu();
            try {
                mainmenu.start(myStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });

        myStage.setScene(myScene);
        myStage.setResizable(false);
        Stage initiateStage = myStage;
        myStage.show();
    }

    public Stage getInitiateStage() {
        return initiateStage;
    }
}
