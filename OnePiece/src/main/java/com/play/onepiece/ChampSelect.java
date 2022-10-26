package com.play.onepiece;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class ChampSelect extends Application {

    private int characterQuantity = 0;
    private Stage stage = null;
    private Character[] picked = new Character[2];
    private int buttonVar1 = 100;
    private int buttonVar2 = 100;
    private Pane root = new Pane();

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        stage.setTitle("OnePiece the Game");
        Scene scene = new Scene(root, 1280, 720);
        List<Button> buttonList= makeButtons();

        buttonList.get(0).setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                picked[characterQuantity] = new Character(1000, 200, 5, 30);
                champSelect(buttonList.get(0));
            }
        });
        buttonList.get(1).setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                picked[characterQuantity] = new Character(1000,300,3,30);
                champSelect(buttonList.get(1));
            }
        });
        buttonList.get(2).setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                picked[characterQuantity] = new Character(1000,500,2,30);
                champSelect(buttonList.get(2));
            }
        });
        buttonList.get(3).setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                picked[characterQuantity] = new Character(500, 500, 5, 30);
                champSelect(buttonList.get(3));
            }
        });

        doRooting(buttonList);

        stage.setScene(scene);
        stage.show();
    }

    private void doRooting(List<Button> buttonList) {
        for(Button b : buttonList) {
            root.getChildren().add(b);
        }
    }

    String[] chars = {"Ruffy", "Nami", "Zorro", "Robin"};
    int i = 0;
    Button[] theButtons = new Button[chars.length];
    private List<Button> makeButtons() {
        if(i == chars.length)
            return List.of(theButtons);
        if(buttonVar2 == 300) {
            buttonVar2 = 100;
            buttonVar1 += 300;
        }
        theButtons[i] = UiTemplates.createButton(chars[i], buttonVar1, buttonVar2, "#00FFFF;");
        buttonVar2 += 100;
        i++;
        return makeButtons();
    }

    private void champSelect(Button b) {
        characterQuantity += 1;
        b.setDisable(true);
        if (characterQuantity == 2) {
            startUpFight();
        }
    }

    private void startUpFight() {
        FightingScene fightScene = new FightingScene(picked[0], picked[1]);
        try {
            fightScene.start(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}