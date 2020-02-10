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
        ArrayList<Plant> plants = model.Shop.getAllPlants();
        ImageView imageView ;
        GridPane gridPane = new GridPane();
        gridPane.setVgap(30);
        gridPane.setHgap(30);
        System.out.println(plants.size());
        for (int i=0;i<plants.size() ;i++){
            imageView=new ImageView(plants.get(i).getCardImage());
            gridPane.add(imageView,i,i);

        }
        Group root = new Group();
        Scene scene = new Scene(root, 900, 800);
        //Image image = new Image("Plants vs Zombies/Snow Pea/Snow-Pea.webp");
        Image image2 = new Image("Plants vs Zombies/Snow Pea/Snow-Pea.webp");
       // ImageView imageView = new ImageView(image);
        int money = 100;
        //ImageView imageView2=new ImageView(image2);
        Plant plant = new shootingPlant("Repeater", 3, 2, 3, 4, 4,
                new Image("Plants vs Zombies/Repeater/1769829-plant_peashooter_thumb.webp"));
        ImageView imageView2 = new ImageView(plant.getImage());
        //gridPane.add(imageView, 1, 1);
        gridPane.add(imageView2, 1, 2);
      //  Text title1=toText(imageView2,100,20);
     /*   imageView.setOnMouseClicked(event -> {
            Text text = new Text(String.valueOf(money - plant.getPrice()));
            text.setFont(Font.font("Verdana", 50));
            text.setTranslateX(20);
            text.setTranslateY(40);
            text.setId("fancytext");
            root.getChildren().add(text);
        });*/
        root.getChildren().add(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
