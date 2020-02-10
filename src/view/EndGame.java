package view;

import in_game.GameCondition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.util.*;



public class EndGame extends Application {
    private GameCondition gameCondition;
    public static Stage endStage = new Stage();


    public EndGame(GameCondition gameCondition) {
        this.gameCondition = gameCondition;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        WebView webView = new WebView();
        VBox root = addContent(webView);
        Scene scene = new Scene(root, 900, 800);
        scene.getStylesheets().add(Loginmenu.class.getResource("static/welcome.css").toExternalForm());
        primaryStage.setTitle("End!");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        endStage = primaryStage;
    }

    private VBox addContent(WebView webView) {
        VBox box = new VBox();
        box.prefWidth(500);
        box.setAlignment(Pos.CENTER);
        box.setSpacing(50);
        Text title = new Text();
        if (this.gameCondition == GameCondition.WINNER){
             title = new Text("YOU FUCKING WON");
        }
        else{
            title = new Text("YOU PIECE OF SHIT LOST");
        }
        Button startGameButton = addStart(webView);
        Button helpButton = addHelp();
        title.setFont(Font.font("Verdana", 50));
        title.setId("fancytext");
        box.getChildren().addAll(title, startGameButton, helpButton);
        return box;
    }

    private Button addStart(WebView webView) {
        Button startGameButton = new EndGame.StartButton("START A NEW GAME AND TRY TO WIN", webView);
        startGameButton.setOnAction(event -> {
            Mainmenu mainmenu = new Mainmenu();
            try {

                mainmenu.start(endStage);
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Can not initiate game");
            }
            endStage.close();
        });
        return startGameButton;
    }

    private class StartButton extends Button {
        public StartButton(String textOnButton, WebView webView) {
            setText(textOnButton);
            webView.getEngine().load(textOnButton);
        }
    }

    private Button addHelp() {
        Button helpButton = new Button("HOW TO PLAY");
        helpButton.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Plants vs. Zombies");
            alert.setHeaderText("How to Play");
            alert.setContentText("You Should Start Over");

            alert.showAndWait();
        });

        return helpButton;
    }



    public Stage getEndStage() {
        return endStage;
    }


}