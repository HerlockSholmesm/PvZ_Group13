package view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
            Login login = new Login();
            try {

                login.start(welcomeStage);
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
            CreateAccount account=new CreateAccount();
            try {

                account.start(welcomeStage);
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
            alert.setContentText("In this game you will fight against zombies by plant different plants on your plant.\n" +
                    "Each plant has their own special skill:\n" +
                    "-Peashooter: attacks zombies by continuously shoot out peas once you put it down\n" +
                    "-Sunflower: produce one star at intervals. You can click on the plant to collect the stars. Each star worth 50 value, which you would use to buy more plants.\n" +
                    "-Wallnut: put it on the ground to slow down zombie's movement.\n" +
                    "Good luck and have fun!");

            alert.showAndWait();
        });

        return helpButton;
    }

    private Button addShopButton(WebView webView) {
        Button ShopButton = new Shopmenu("Shop menu", webView);
        ShopButton.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Plants vs. Zombies");
            alert.setHeaderText("LeaderBoard");
            Login account =new Login();
            alert.showAndWait();
        });
        return ShopButton;
    }

    private class Shopmenu extends Button {
        public Shopmenu(String textOnButton, WebView webView) {
            setText(textOnButton);
            webView.getEngine().load(textOnButton);
        }
    }
    private Button addExitButton(WebView webView) {
        Button ExitBotton = new Exit("Shopmenu", webView);
        Loginmenu loginmenu = new Loginmenu();
        ExitBotton.setOnAction(event -> {
            try {
                loginmenu.start(welcomeStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return ExitBotton;
    }

    private class Exit extends Button {
        public Exit(String textOnButton, WebView webView) {
            setText(textOnButton);
            webView.getEngine().load(textOnButton);
        }
    }
}
