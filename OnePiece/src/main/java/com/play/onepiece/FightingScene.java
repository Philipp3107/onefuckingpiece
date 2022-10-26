package com.play.onepiece;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class FightingScene extends Application {
    private Character p1;
    private Character p2;
    Pane root = new Pane();

    private ArrayList<Label> labels = new ArrayList();
    private ArrayList<Button> buttons = new ArrayList();
    public FightingScene(Character p1, Character p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("One Piece the Game");
        Scene scene = new Scene(root, 1280, 720);

        labels.add(UiTemplates.placeLabel("P1 HP: " + p1.getLifePoints(), 200, 400));
        labels.add(UiTemplates.placeLabel("P2 HP: " + p2.getLifePoints(), 500, 400));
        buttons.add(UiTemplates.placeButton("P1 Attack", 200, 300));
        buttons.add(UiTemplates.placeButton("P2 Attack", 500, 300));
        buttons.add(UiTemplates.placeButton("P1 Special", 200, 350));
        buttons.add(UiTemplates.placeButton("P2 Special", 500, 350));

        buttons.get(0).setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                p1.startAttack(p2, 1, 0);
                refreshHpLabels();
            }
        });
        buttons.get(1).setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                p2.startAttack(p1, 1, 0);
                refreshHpLabels();
            }
        });
        buttons.get(2).setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                p1.startAttack(p2, 2, 15);
                refreshHpLabels();
                if(p1.stamina < 15) {
                    buttons.get(2).setDisable(true);
                }
            }
        });
        buttons.get(3).setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                p2.startAttack(p1, 2, 15);
                refreshHpLabels();
                if(p2.stamina < 15) {
                    buttons.get(3).setDisable(true);
                }
            }
        });
        doRooting("", labels);
        doRooting(buttons);

        stage.setScene(scene);
        stage.show();
    }

    private void refreshHpLabels() {
        labels.get(0).setText("P1 HP: " + p1.getLifePoints());
        labels.get(1).setText("P2 HP: " + p2.getLifePoints());
    }

    private void doRooting(ArrayList<Button> ob) {
        for (Button b: ob) {
            root.getChildren().add(b);
        }
    }
    private void doRooting(String label, ArrayList<Label> ob) {
        for (Label l: ob) {
            root.getChildren().add(l);
        }
    }
}
