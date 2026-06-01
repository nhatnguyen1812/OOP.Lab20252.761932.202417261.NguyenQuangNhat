package hust.soict.ep.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton penRadioButton;

    @FXML
    private RadioButton eraserRadioButton;

    @FXML
    public void initialize() {
        // Tao clip hinh chu nhat de gioi han net ve
        Rectangle clip = new Rectangle();
        clip.widthProperty().bind(drawingAreaPane.widthProperty());
        clip.heightProperty().bind(drawingAreaPane.heightProperty());
        drawingAreaPane.setClip(clip);
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();

        // Chi ve khi con tro chuot nam trong drawingAreaPane
        if (x >= 0 && x <= drawingAreaPane.getWidth() && y >= 0 && y <= drawingAreaPane.getHeight()) {
            Color drawColor = Color.BLACK;
            double radius = 4.0;

            if (eraserRadioButton != null && eraserRadioButton.isSelected()) {
                drawColor = Color.WHITE;
                radius = 8.0; // Tang kich thuoc tay de de xoa
            }

            Circle newCircle = new Circle(x, y, radius, drawColor);
            drawingAreaPane.getChildren().add(newCircle);
        }
    }
}