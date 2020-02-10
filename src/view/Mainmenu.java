package view;

import commands.Menu.LoginMenu;
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

import model.*;
import in_game.*;
import commands.*;

public class Mainmenu extends Application {

    static Stage welcomeStage;


    @Override
    public void start(Stage primaryStage) throws Exception {
        AudioClip audioClip = new AudioClip(getClass().getResource("/media/b.mp3").toString());
        audioClip.play(100, 13, 434, 34, 1);
        WebView webView = new WebView();
        VBox root = addContent(webView);
        Scene scene = new Scene(root, 900, 800);
        scene.getStylesheets().add(Loginmenu.class.getResource("static/welcome.css").toExternalForm());
        primaryStage.setTitle("Mainmenu");
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
        Text title = new Text("MainMenu");
        Button PlayButton = addPlayButton(webView);
        Button ProfileButton = addProfileButton(webView);
        Button helpButton = addHelpButton();
        Button ShopButton = addShopButton(webView);
        Button ExitButton = addExitButton(webView);
        title.setFont(Font.font("Verdana", 50));
        title.setId("fancytext");
        box.getChildren().addAll(title, PlayButton,ProfileButton,helpButton,ShopButton,ExitButton);
        return box;
    }

    private Button addPlayButton(WebView webView) {
        Button playButton = new PlayBotton("PlayMenu", webView);
        playButton.setOnAction(event -> {
            Play play = new Play();
            try {

                play.start(welcomeStage);
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Can not initiate game");
            }
        });
        return playButton;
    }

    private class PlayBotton extends Button {
        public PlayBotton(String textOnButton, WebView webView) {
            setText(textOnButton);
            webView.getEngine().load(textOnButton);
        }
    }

    private Button addProfileButton(WebView webView) {
        Button ProfileButton = new ProfileButton("Profile", webView);
        ProfileButton.setOnAction(event -> {
           Profile profile =new Profile();
            try {

                profile.start(welcomeStage);
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Can not initiate game");
            }
        });
        return ProfileButton;
    }

    private class ProfileButton extends Button {
        public ProfileButton(String textOnButton, WebView webView) {
            setText(textOnButton);
            webView.getEngine().load(textOnButton);
        }
    }

    private Button addHelpButton() {
        Button helpButton = new Button("Help");
        helpButton.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Plants vs. Zombies");
            alert.setHeaderText("Help");
            alert.setContentText("go to play mode to play");

            alert.showAndWait();
        });

        return helpButton;
    }

    private Button addShopButton(WebView webView) {
        Button ShopButton = new Show("Shop menu", webView);
        ShopButton.setOnAction(event -> {
          Shop shop =new Shop();
          shop.start(welcomeStage);
        });
        return ShopButton;
    }

    private class Show extends Button {
        public Show(String textOnButton, WebView webView) {
            setText(textOnButton);
            webView.getEngine().load(textOnButton);
        }
    }
    private Button addExitButton(WebView webView) {
        Button ExitBotton = new Show("Exit", webView);
        Loginmenu login =new Loginmenu();
        ExitBotton.setOnAction(event -> {
            try {
                login.start(welcomeStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return ExitBotton;
    }
    }
