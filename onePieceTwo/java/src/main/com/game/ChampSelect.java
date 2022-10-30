package main.com.game;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class ChampSelect extends Application {
			//Character stats
			 String[] characters = {"Ruffy", "Nami", "Zorro", "Robin"};
			 int[] lifepoint = {1000, 1000, 1000, 500};
			 int[] attacksStat = {200, 300, 500, 500};
			 int[] defenseStat = {5, 3, 2, 5};
			 int[] stamina = {30, 30, 30, 30};



			private Character[] allCharacters = new Character[4];
			private Character[] picked = new Character[2];
			HashMap<String, Integer> character_index = new HashMap<>();
			private int characterQuantity = 0;

			private Stage stage = null;

			private Pane pane = new Pane();

			//@Override
			public void start(Stage stage) throws Exception {


						///MARK:Setting Window
						this.stage = stage;
						Scene scene = new Scene(pane, 1280, 720);

						///MARK:setting Background
						pane.setId("pane");
						scene.getStylesheets().addAll(this.getClass().getResource("test.css").toExternalForm());

						///MARK: setting buttons and charactors
						List<Button> buttonslist = setButtons();
						doRooting(buttonslist);
						set_characers();

						//acting for all buttons
						for(Button b : buttonslist){
									b.setOnMousePressed(new EventHandler<MouseEvent>() {
												@Override
												public void handle(MouseEvent mouseEvent) {
												picked[characterQuantity] = allCharacters[character_index.get(b.getText())];
												champSelect(b);
												}
									});
						}
						stage.setScene(scene);
						stage.show();

			}

			//Creating all Buttons, Relocated X and Y in UITemplates
			public int i = 0;
			Button[] theButtons = new Button[characters.length];

			public List<Button> setButtons(){
						if (i == characters.length){
									return List.of(theButtons);
						}
						theButtons[i] = UITemplates.createButton(characters[i], "00FFFF");
						i++;
						return setButtons();
			}

			private void doRooting(List<Button> buttonList) {
						for(Button b : buttonList) {
									pane.getChildren().add(b);
						}
			}

			private void champSelect(Button b) {
						characterQuantity += 1;
						b.setDisable(true);
						if (characterQuantity == 2) {
									startUpFight(picked[0], picked[1]);
						}
			}

			private void startUpFight(Character one, Character two) {
						FightingScene fightScene = new FightingScene(one, two);
						try {
									fightScene.start(stage);
						} catch (IOException e) {
									e.printStackTrace();
						}
			}

			public void set_characers(){
						for(int i = 0; i<4; i++){
							allCharacters[i] = new Character(characters[i],lifepoint[i] ,attacksStat[i], defenseStat[i], stamina[i]);
									character_index.put(allCharacters[i].getName(), i);
						}
			}


}
