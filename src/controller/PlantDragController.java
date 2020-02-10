package controller;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.StackPane;

/**
 * @author YanhanLyu, Lucy Wu
 * Class that controls the behavior of dragging plants
 */
public class PlantDragController implements EventHandler<MouseEvent> {
    private StackPane stackPane;
    private Image image;

    public PlantDragController (StackPane stackPane, Image image) {
        this.stackPane = stackPane;
        this.image = image;
    }
    @Override
    public void handle(MouseEvent event) {
        Dragboard drag = this.stackPane.startDragAndDrop(TransferMode.MOVE);
        ClipboardContent content = new ClipboardContent();
        content.putImage(this.image);
        content.putString(this.stackPane.getId());
        drag.setContent(content);

    }

}