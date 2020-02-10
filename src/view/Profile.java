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

public class Profile extends Application {

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
        Text title = new Text("Profile");
        Button ChangeButton = addChangeButton(webView);
        Button DeleteButton = addDeleteButton(webView);
        Button RenameButton = addRenameButton(webView);
        Button CreateButton = addCreateButton(webView);
        Button ShowButton = addShowButton(webView);
        Button ExitButton = addExitButton(webView);
        title.setFont(Font.font("Verdana", 50));
        title.setId("fancytext");
        box.getChildren().addAll(title, ChangeButton,DeleteButton, RenameButton, CreateButton, ShowButton, ExitButton);
        return box;
    }

    private Button addChangeButton(WebView webView) {
        Button changeButton = new Show("Change", webView);
        changeButton.setOnAction(event -> {
            Change change =new Change();
            try {
             change.start(welcomeStage);
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Can not initiate game");
            }
        });
        return changeButton;
    }

    private class Show extends Button {
        public Show(String textOnButton, WebView webView) {
            setText(textOnButton);
            webView.getEngine().load(textOnButton);
        }
    }

    private Button addDeleteButton(WebView webView) {
        Button waterButton = new Show("Delete", webView);
        waterButton.setOnAction(event -> {
            Delete delete = new Delete();
            try {
                delete.start(welcomeStage);
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Can not initiate game");
            }
        });
        return waterButton;
    }



    private Button addRenameButton(WebView webView) {
        Button zombieButton = new Show("Rename", webView);
        zombieButton.setOnAction(event -> {
            Rename rename =new Rename();
            try {
                rename.start(welcomeStage);
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Can not initiate game");
            }
        });
        return zombieButton;
    }


    private Button addCreateButton(WebView webView) {
        Button pvPButton = new Show("Create", webView);
        pvPButton.setOnAction(event -> {
            Create create =new Create();
            try {
                create.start(welcomeStage);
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Can not initiate game");
            }
        });
        return pvPButton;
    }

    private Button addShowButton (WebView webView) {
        Button pvPButton = new Show("Show", webView);
        pvPButton.setOnAction(event -> {

            try {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Plants vs. Zombies");
                alert.setHeaderText("you're account is");
                alert.setContentText(Login.mainAccount.getName());
                alert.showAndWait();
                Profile profile =new Profile();
                profile.start(welcomeStage);
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Can not initiate game");
            }
        });
        return pvPButton;
    }

    private Button addExitButton(WebView webView) {
        Button ExitBotton = new Show("Exit", webView);
        Mainmenu mainmenu =new Mainmenu();
        ExitBotton.setOnAction(event -> {
            try {
                mainmenu.start(welcomeStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return ExitBotton;
    }

}
