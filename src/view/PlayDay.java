package view;

import controller.*;
import in_game.GameDay;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Chamanzan;
import model.DayYard;
import model.Plant;
import model.Yard;

import java.util.ArrayList;

class PlayDay extends Application {
    private Group root;
    private Yard dayYard;
    static Stage initialStage = new Stage();

    public static Stage getInitialStage() {
        return initialStage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Platform.exit();
                System.exit(0);
            }
        });

        primaryStage.setTitle("Plants VS Zombies");
        this.root = new Group();
        Scene scene = new Scene(root,1116, 602);
        Image background = new Image("/png/wallp.png");
        ImageView backgroundView = new ImageView(background);
        root.getChildren().add(backgroundView);
        GameDay gameDay = GameDay.getGame();
        DayYard dayYard = new DayYard(gameDay);
        ArrayList<StackPane> stackPanes = new ArrayList<>();
        StackPane bar = new StackPane();
        for (int i = 0; i < gameDay.getCards().size(); i++){
            Plant plant  = (Plant) gameDay.getCards().get(i);
            stackPanes.add(plant.getStackPane());
            bar.getChildren().add(stackPanes.get(i));
            stackPanes.get(i).setTranslateY(90*i);
            stackPanes.get(i).setId(plant.getName());
            stackPanes.get(i).setOnDragDetected(new PlantDragController(stackPanes.get(i), plant.getImage()));
        }

        for (int i = 0; i < 6; i++){
            Chamanzan chamanzan = gameDay.getChamanzans().get(i);
            StackPane stackPane = new StackPane(chamanzan.getImageView());
            bar.getChildren().add(stackPane);
            stackPane.setTranslateX(270 - 5);
            stackPane.setTranslateY(20 + DayYard.getDelta_y()*i);
        }
        Label sunNumber = new Label("Sun Numbers\n" + 2);
        sunNumber.setFont(new Font(20));
        bar.getChildren().add(sunNumber);
        sunNumber.setTranslateX(90);
        sunNumber.setTranslateY(110);

        Image barImage = new Image("/png/bar.png");
        ImageView barView = new ImageView();
        barView.setImage(barImage);
        BorderPane sun = new BorderPane();
        bar.getChildren().add(sun);
        root.getChildren().add(bar);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        scene.setOnDragOver(new PlantDragOverController());
        scene.setOnDragDropped(new PlantDragDropController(root, gameDay,dayYard));
        scene.setOnMouseClicked(new SunController(dayYard,gameDay, root, sunNumber));
        initialStage = primaryStage;
        GameController controller = new GameController(dayYard, initialStage,root);
        controller.initialize();
    }

}
