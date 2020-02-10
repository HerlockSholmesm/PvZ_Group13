package view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Card;
import model.Plant;

import java.util.ArrayList;

import javafx.scene.web.WebView;

public class Hand extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    static Stage welcomeStage;

    @Override
    public void start(Stage primaryStage) {
        WebView webView = new WebView();
        VBox root = addContent(webView);
        Scene scene = new Scene(root, 900, 800);
        scene.getStylesheets().add(Shop.class.getResource("static/welcome1.css").toExternalForm());
        primaryStage.setTitle("Hand");
        ArrayList<Card> cards = Login.mainAccount.getCollection().getHand();
        ImageView imageView;
        GridPane gridPane = new GridPane();
        gridPane.setVgap(1);
        gridPane.setHgap(1);
        for (int i = 0; i < cards.size(); i++) {
            if(cards.get(i)!=null)
                if (cards.get(i) instanceof Plant) {
                    imageView = new ImageView(((Plant) cards.get(i)).getCardImage());
                    gridPane.add(imageView, i % 10 + 100, i / 10 + 10);
                }
        }
        root.getChildren().addAll(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
        welcomeStage = primaryStage;
    }

    private VBox addContent(WebView webView) {
        VBox box = new VBox();
        box.prefWidth(500);
        box.setAlignment(Pos.CENTER);
        box.setSpacing(50);
        Text title = new Text("Collection");
        Button CollectionButton = addCollectionButton(webView);
        Button showHandButton = addShowHandButton(webView);
        Button ExitButton = addExitButton(webView);
        title.setFont(Font.font("Verdana", 50));
        title.setId("fancyText");
        box.getChildren().addAll(title, CollectionButton, ExitButton);
        return box;
    }

    private Button addCollectionButton(WebView webView) {
        Button startGameButton = new Show("Play", webView);
        startGameButton.setOnAction(event -> {
            AudioClip audioClip = new AudioClip(getClass().getResource("/png/shoot.wav").toString());
            audioClip.play();
            Play play =new Play();
            try {
                play.start(welcomeStage);
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        return startGameButton;
    }
    private Button addShowHandButton(WebView webView) {
        Button startGameButton = new Show("Play", webView);
        startGameButton.setOnAction(event -> {
            AudioClip audioClip = new AudioClip(getClass().getResource("/png/shoot.wav").toString());
            audioClip.play();
            Play play =new Play();
            try {
                play.start(welcomeStage);
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        return startGameButton;
    }
    private Button addExitButton(WebView webView) {
        Button startGameButton = new Show("Exit", webView);
        startGameButton.setOnAction(event -> {
            AudioClip audioClip = new AudioClip(getClass().getResource("/png/shoot.wav").toString());
            audioClip.play();
            Shop shop =new Shop();
            shop.start(welcomeStage);

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