/*package view;

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

public class Shop2 extends Application {
    static Stage welcomeStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        AudioClip audioClip = new AudioClip(getClass().getResource("/media/a.mp3").toString());
        audioClip.play();
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
        // leaderBoardButton);
        return box;
    }

    private Button addLeaderBoardButton(WebView webView) {
        Button startGameButton = new Show("LeaderBoard", webView);
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

    private class Show extends Button {
        public Show(String textOnButton, WebView webView) {
            setText(textOnButton);
            webView.getEngine().load(textOnButton);
        }
    }
}
*/