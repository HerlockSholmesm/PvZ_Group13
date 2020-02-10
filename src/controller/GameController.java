package controller;

import in_game.DynamicDay;
import in_game.Game;
import in_game.GameCondition;
import in_game.GameDay;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.*;
import view.EndGame;
//import view.EndGame;
import java.util.*;


public class GameController{
    final private double FRAMES_PER_SECOND = 60.0;
    private DayYard dayYard;
    private GameDay gameDay;
    private Stage stage;
    private Timer timer;
    private Group root;
    private DynamicDay dynamicDay;
    public GameController(DayYard dayYard, Stage initStage, Group root,DynamicDay dynamicDay) {
        this.dayYard = dayYard;
        this.gameDay = (GameDay)dayYard.getGame();
        this.stage = initStage;
        this.root = root;
        this.dynamicDay = dynamicDay;
    }


    public void initialize() {
        this.startTimer();

    }

    private void startTimer() {
        this.timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        updateAnimation();
                    }
                });
            }
        };

        long frameTimeInMilliseconds = (long)(1);
        this.timer.schedule(timerTask,0,frameTimeInMilliseconds);
    }


    private void updateAnimation() {
        StackPane stackPane = new StackPane();
        for (Plant plant:gameDay.getPlants()){
            stackPane.getChildren().add(plant.getStackPane());
            stackPane.setTranslateX(dayYard.whichPixelAmI(plant.getCell())[0]);
            stackPane.setTranslateY(dayYard.whichPixelAmI(plant.getCell())[1]);
            root.getChildren().add(stackPane);
        }
        System.out.println(gameDay.getPlants().size() +  " is size");
        for (Plant plant:gameDay.getPlants()){
            plant.action(gameDay);
        }


        if(dynamicDay.canIStartTheNextAttack()){
            dynamicDay.attack();
            StackPane stackPane1 = new StackPane();
            for (Zombie zombie:gameDay.getZombies()){
                stackPane1.getChildren().add(zombie.getStackPane());
                stackPane1.setTranslateX(dayYard.whichPixelAmI(zombie.getCell())[0]);
                stackPane1.setTranslateY(dayYard.whichPixelAmI(zombie.getCell())[1]);
                root.getChildren().add(stackPane1);
            }

        }



        for (Zombie zombie:gameDay.getZombies()){
            zombie.action(gameDay);
        }
        for(Chamanzan chamanzan:gameDay.getChamanzans()){
            chamanzan.action(gameDay);
        }
        ArrayList<Plant> listOfPlants = dayYard.getGame().getPlants();
        ArrayList<shootingPlant> shootingPlants = new ArrayList<>();
        for (Plant plant: listOfPlants){
            if (plant instanceof shootingPlant){
                shootingPlants.add((shootingPlant)plant);
            }
        }

        ArrayList<PeaBullet> listOfPeas = new ArrayList<>();
        for (shootingPlant shootingPlant: shootingPlants){
            listOfPeas.addAll(shootingPlant.getPeaBullets());
        }

        for(PeaBullet peaBullet:listOfPeas){
            peaBullet.action(gameDay);
        }

        for (Plant plant:listOfPlants){
            if (plant.getLife() <= 0){
                gameDay.getPlants().remove(plant);
            }
        }
        ArrayList<Zombie> listOfZombies = gameDay.getZombies();
        for(Zombie zombie:listOfZombies){
            if(zombie.getLife() <= 0){
                gameDay.getZombies().remove(zombie);
            }
        }
        ArrayList<Chamanzan> chamanzanArrayList = gameDay.getChamanzans();
        for (Chamanzan chamanzan:chamanzanArrayList){
            if (chamanzan.isDead()){
                gameDay.getChamanzans().remove(chamanzan);
            }
        }
        if(dynamicDay.hasGameEnded()){
            //this.endGame();
        }
        else{
             dynamicDay.endTurn();
        }


    }


  public void endGame(){
        if (gameDay.getGameCondition() == GameCondition.WINNER) {
            EndGame endGameShow = new EndGame(gameDay.getGameCondition());
            try {
                this.timer.cancel();
                endGameShow.start(endGameShow.getEndStage());
                this.stage.close();
            } catch (Exception ignored) {

            }
        }
        if (gameDay.getGameCondition() == GameCondition.LOSER){
            EndGame endGameShow = new EndGame(gameDay.getGameCondition());
            try{
                this.timer.cancel();
                endGameShow.start(endGameShow.getEndStage());
                this.stage.close();
            } catch (Exception ignored){

            }

        }
    }

}