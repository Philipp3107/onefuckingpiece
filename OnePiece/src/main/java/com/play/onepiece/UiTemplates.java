package com.play.onepiece;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class UiTemplates {

    public static Button createButton(String name, int x, int y, String color) {

        Button b = new Button(name);
        b.setLayoutX(x);
        b.setLayoutY(y);
        b.setStyle("-fx-background-color: " + color);

        return b;
    }

    public static Label placeLabel(String text, int x,int y) {
        Label l = new Label(text);
        l.setLayoutX(x);
        l.setLayoutY(y);
        return l;
    }
    public static Button placeButton(String text, int x,int y) {
        Button b = new Button(text);
        b.setLayoutX(x);
        b.setLayoutY(y);
        return b;
    }
}
