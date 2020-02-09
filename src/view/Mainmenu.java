package view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Mainmenu extends Application {
    static Stage welcomeStage;
    @Override
    public void start(Stage primaryStage) throws Exception {
        WebView webView = new WebView();
        VBox root = addContent(webView);
        Scene scene = new Scene(root, 900, 800);
        scene.getStylesheets().add(Mainmenu.class.getResource("static/welcome.css").toExternalForm());
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
        Text title= new Text("Plants vs. Zombies");
        Button LoginButton = addLoginButton(webView);
      //  Button mainButton = addMainButton();
        //Button leaderBoardButton = addLeaderBoardButton();
        title.setFont(Font.font ("Verdana", 50));
        title.setId("fancytext");
        box.getChildren().addAll(title,LoginButton);
                //mainButton, leaderBoardButton);
        return box;
    }
    private Button addLoginButton(WebView webView) {
        Button startGameButton = new LoginButton("LoginMenu", webView);
        startGameButton.setOnAction(event -> {
            Login login = new Login();
            try{

                login.start(login.getInitiateStage());
            } catch (Exception e){
                e.printStackTrace();
                System.err.println("Can not initiate game");
            }
            welcomeStage.close();
        });
        return startGameButton;
    }
    private class LoginButton extends Button {
        public LoginButton(String textOnButton, WebView webView) {
            setText(textOnButton);
            webView.getEngine().load(textOnButton);
        }
    }
}
