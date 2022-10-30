package main.com.game;

import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class UITemplates {
			private static int buttonX = 100;
			private static int buttonY = 100;
			public static Button createButton(String name, String color) {

						Button b = new Button(name);

						if(buttonY == 300) {
									buttonY = 100;
									buttonX += 300;
						}
						b.setLayoutX(buttonX);
						b.setLayoutY(buttonY);
						b.setStyle("-fx-background-color: #" + color);
						buttonY += 100;
						return b;
			}

			public static Label placeLabel(String text, int x, int y) {
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
