package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class Popup {
    private String info;

    public Popup(String info) {
        this.info = info;
        display();
    }

    public void display() {
        Stage popupwindow = new Stage();
        VBox layout = new VBox(10);
        Button okBtn = new Button("OK");
        Label labelInfo = new Label(info);
        labelInfo.setWrapText(true);
        layout.getChildren().addAll(labelInfo, okBtn);
        okBtn.setOnAction(e -> popupwindow.close());
        layout.setAlignment(Pos.CENTER);
        labelInfo.setPadding(new Insets(10, 10, 10, 10));
        Scene scene1 = new Scene(layout, 300, 200);
        popupwindow.setScene(scene1);
        popupwindow.show();
    }
}

