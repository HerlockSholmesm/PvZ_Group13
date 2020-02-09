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

public class Login extends Application {
    static Stage initiateStage;
    public static void main(String[] args) {
        launch(args);
    }
    static Account[] mainAccount = {null};

    public static Account[] getMainAccount() {
        return mainAccount;
    }

    public static void setMainAccount(Account[] mainAccount) {
        Login.mainAccount = mainAccount;
    }

    @Override
    public void start(Stage myStage) {
        myStage.setTitle("Login");
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
        rootNode.add(new Label("Login Account"), 0, 2);
        Button aButton = new Button("Login Account");
        Button bButton = new Button("Create Account");
        rootNode.add(aButton, 1, 2);
        rootNode.add(bButton, 1, 3);
        GridPane.setHalignment(aButton, HPos.LEFT);
        GridPane.setHalignment(bButton, HPos.LEFT);
        aButton.setOnAction(e -> {
                    String s = Account.findAccount(firstValue.getText(), secondValue.getText());
                    if (s.equals("find")) {
                        mainAccount[0] = new Account(firstValue.getText(), secondValue.getText());
                    } else if (s.equals("invalid password")) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Plants vs. Zombies");
                        alert.setHeaderText("eror:(");
                        alert.setContentText("invalid password");
                        System.out.println(s);
                        alert.showAndWait();
                    } else if (s.equals("no account found!")) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Plants vs. Zombies");
                        alert.setHeaderText("Help");
                        alert.setContentText("no account found!");
                        alert.showAndWait();
                    }
                    Mainmenu mainmenu =new Mainmenu();
            try {
                mainmenu.start(myStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        bButton.setOnAction(e -> {
            CreateAccount account=new CreateAccount();

                account.start(myStage);
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
