package view;

import in_game.Account;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Loginmenu extends Application {
    static Stage welcomeStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        new AudioClip(getClass().getResource("/media/a.mp3").toString()).play();
        WebView webView = new WebView();
        VBox root = addContent(webView);
        Scene scene = new Scene(root, 900, 800);
        scene.getStylesheets().add(Loginmenu.class.getResource("static/welcome.css").toExternalForm());
        primaryStage.setTitle("Welcome!");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        welcomeStage = primaryStage;
    }

    private VBox addContent(WebView webView) {
        VBox box = new VBox();
        box.prefWidth(500);
        box.setAlignment(Pos.CENTER);
        box.setSpacing(50);
        Text title = new Text("Plants vs. Zombies");
        Button LoginButton = addLoginButton(webView);
        Button createAccountButton = addCreateAccountButton(webView);
        Button helpButton = addHelpButton();
        Button leaderBoardButton = addLeaderBoardButton(webView);
        title.setFont(Font.font("Verdana", 50));
        title.setId("fancytext");
        box.getChildren().addAll(title, LoginButton,createAccountButton
                , helpButton, leaderBoardButton);
        return box;
    }

    private Button addLoginButton(WebView webView) {
        Button startGameButton = new LoginButton("LoginMenu", webView);
        startGameButton.setOnAction(event -> {
            Login login = new Login();
            try {
                login.start(welcomeStage);
                AudioClip audioClip = new AudioClip(getClass().getResource("/png/shoot.wav").toString());
                audioClip.play();
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Can not initiate game");
            }
        });
        return startGameButton;
    }

    private class LoginButton extends Button {
        public LoginButton(String textOnButton, WebView webView) {
            setText(textOnButton);
            webView.getEngine().load(textOnButton);
        }
    }

    private Button addCreateAccountButton(WebView webView) {
        Button startGameButton = new CreateAccountButton("CreateAccount", webView);
        startGameButton.setOnAction(event -> {
            CreateAccount account=new CreateAccount();
            try {
                AudioClip audioClip = new AudioClip(getClass().getResource("/png/shoot.wav").toString());
                audioClip.play();
                account.start(welcomeStage);
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Can not initiate game");
            }
        });
        return startGameButton;
    }

    private class CreateAccountButton extends Button {
        public CreateAccountButton(String textOnButton, WebView webView) {
            setText(textOnButton);
            webView.getEngine().load(textOnButton);
        }
    }

    private Button addHelpButton() {
        Button helpButton = new Button("Help");
        helpButton.setOnAction(event -> {
            AudioClip audioClip = new AudioClip(getClass().getResource("/png/shoot.wav").toString());
            audioClip.play();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Plants vs. Zombies");
            alert.setHeaderText("Help");
            alert.setContentText("help : showing commands\n" +
                    "Create account : to create an account\n" +
                    "Login : to login\n" +
                    "Leader board : to show leader Board\n" +
                    "exit : to exit game");

            alert.showAndWait();
        });
        return helpButton;
    }

    private Button addLeaderBoardButton(WebView webView) {
        Button startGameButton = new LeaderBoard("LeaderBoard", webView);
        model.Shop.importPlant();
        model.Shop.importZombie();
        startGameButton.setOnAction(event -> {
            AudioClip audioClip = new AudioClip(getClass().getResource("/png/shoot.wav").toString());
            audioClip.play();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Plants vs. Zombies");
            alert.setHeaderText("LeaderBoard");
            alert.setContentText(Account.showLeaderBoard1());
            alert.showAndWait();
    });
        return startGameButton;
    }

    private class LeaderBoard extends Button {
        public LeaderBoard(String textOnButton, WebView webView) {
            setText(textOnButton);
            webView.getEngine().load(textOnButton);
        }
    }
}
