package view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
import sun.plugin2.main.client.WMozillaServiceDelegate;
import sun.rmi.runtime.Log;

public class Shop extends Application {

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
        primaryStage.setTitle("Shop");
        ArrayList<Plant> plants = model.Shop.getAllPlants();
        ImageView imageView;
        GridPane gridPane = new GridPane();
        gridPane.setVgap(1);
        gridPane.setHgap(1);
        ArrayList<Plant> toBeDeleted = new ArrayList<>();
        for (Plant plant : plants) {
            if (plant.getCardImage() == null) {
                toBeDeleted.add(plant);
            }
        }
        plants.removeAll(toBeDeleted);
        for (int i = 0; i < plants.size(); i++) {
            imageView = new ImageView(plants.get(i).getCardImage());
            Plant plant =plants.get(i) ;
            gridPane.add(imageView, i % 10 + 100, i / 10 + 10);
            imageView.setOnMouseClicked(event -> {
                     String s = model.Shop.BuyCard1(plant.getName(), Login.mainAccount);
                     if (s == null){
                         Alert alert = new Alert(Alert.AlertType.INFORMATION);
                         alert.setTitle("Bought");
                         alert.setHeaderText("Bought");
                         alert.setContentText("Bought");
                         alert.showAndWait();
                         System.out.println(Login.mainAccount.getMoney());
                     }
                     else if (s.contains("enough")){
                         Alert alert = new Alert(Alert.AlertType.INFORMATION);
                         alert.setTitle("not Bought");
                         alert.setHeaderText("buying not successful");
                         alert.setContentText("not enough money");
                         alert.showAndWait();
                     }
            });
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
        Text title = new Text("Shop");
        Text title1 = new Text(String.valueOf(Login.mainAccount.getMoney()));
        Button CollectionButton = addCollectionButton(webView);
        title.setFont(Font.font("Verdana", 50));
        title.setId("fancytext");
        title1.setFont(Font.font("Verdana", 50));
        title1.setId("fancytext");
        box.getChildren().addAll(title,title1, CollectionButton);
        return box;
    }

    private Button addCollectionButton(WebView webView) {
        Button startGameButton = new Show("Collection", webView);
        startGameButton.setOnAction(event -> {
            AudioClip audioClip = new AudioClip(getClass().getResource("/png/shoot.wav").toString());
            audioClip.play();
            ShowCollection showCollection=new ShowCollection();
            showCollection.start(welcomeStage);

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
