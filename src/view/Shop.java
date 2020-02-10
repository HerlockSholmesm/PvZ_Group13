package view;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Plant;
import model.shootingPlant;

import java.awt.*;
import java.util.ArrayList;

public class Shop extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 1000, 900);
        scene.getStylesheets().add(Shop.class.getResource("static/welcome.css").toExternalForm());
        model.Shop.importZombie();
        model.Shop.importPlant();
        ArrayList<Plant> plants = model.Shop.getAllPlants();
        ImageView imageView;
        GridPane gridPane = new GridPane();
        gridPane.setVgap(1);
        gridPane.setHgap(1);
        Text title = new Text("Plants vs. Zombies");
        title.setTranslateX(159);
        title.setTranslateY(559);
        title.setFont(Font.font("Verdana", 50));
        title.setId("fancytext");
       // Button LoginButton = addCollectionButton(webView);
        ArrayList<Plant> toBeDeleted = new ArrayList<>();
        for (Plant plant : plants) {
            if (plant.getCardImage() == null) {
                toBeDeleted.add(plant);
            }
        }
        plants.removeAll(toBeDeleted);
        System.out.println(toBeDeleted.size());
        for (int i = 0; i < plants.size(); i++) {
            imageView = new ImageView(plants.get(i).getCardImage());
            gridPane.add(imageView, i % 10 + 100, i / 10 + 10);
            imageView.setOnMouseClicked(event->{
                System.out.println("%");
            });
        }
        root.getChildren().addAll(gridPane,title);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
