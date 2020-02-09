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

public class Shop extends Application {

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
        Text title = new Text("Play");
        Button DayButton = addDayButton(webView);
        Button WaterButton = addWaterButton(webView);
        Button RailButton = addRailButton(webView);
        Button ZombieButton = addZombieButton(webView);
        Button PvPButton = addPvPButton(webView);
        Button ExitButton = addExitButton(webView);
        title.setFont(Font.font("Verdana", 50));
        title.setId("fancytext");
        box.getChildren().addAll(title, DayButton, WaterButton, RailButton, ZombieButton, PvPButton, ExitButton);
        return box;
    }

    private Button addDayButton(WebView webView) {
        Button dayButton = new Show("Day", webView);
        dayButton.setOnAction(event -> {
            Login login = new Login();
            try {
                //todo
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Can not initiate game");
            }
        });
        return dayButton;
    }

    private class Show extends Button {
        public Show(String textOnButton, WebView webView) {
            setText(textOnButton);
            webView.getEngine().load(textOnButton);
        }
    }

    private Button addWaterButton(WebView webView) {
        Button waterButton = new Show("Water", webView);
        waterButton.setOnAction(event -> {
            Login login = new Login();
            try {
                //todo
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Can not initiate game");
            }
        });
        return waterButton;
    }

    private Button addRailButton(WebView webView) {
        Button railButton = new Show("Rail", webView);
        railButton.setOnAction(event -> {
            Login login = new Login();
            try {
                //todo
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Can not initiate game");
            }
        });
        return railButton;
    }


    private Button addZombieButton(WebView webView) {
        Button zombieButton = new Show("Zombie", webView);
        zombieButton.setOnAction(event -> {
            Login login = new Login();
            try {
                //todo
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Can not initiate game");
            }
        });
        return zombieButton;
    }


    private Button addPvPButton(WebView webView) {
        Button pvPButton = new Show("Day", webView);
        pvPButton.setOnAction(event -> {
            Login login = new Login();
            try {
                //todo
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Can not initiate game");
            }
        });
        return pvPButton;
    }


    private Button addExitButton(WebView webView) {
        Button ExitBotton = new Show("Exit", webView);
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

}
