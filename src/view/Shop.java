package view;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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
        model.Shop.importZombie();
        model.Shop.importPlant();
        ArrayList<Plant> plants = model.Shop.getAllPlants();
        ImageView imageView;
        GridPane gridPane = new GridPane();
        gridPane.setVgap(30);
        gridPane.setHgap(30);
        System.out.println(plants.size());
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
            gridPane.add(imageView, i % 6 + 1, i / 6 + 5);
        }
        Group root = new Group();
        Scene scene = new Scene(root, 1000, 900);
        root.getChildren().add(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
