module main.com.game {
			requires javafx.controls;
			requires javafx.fxml;

			opens main.com.game to javafx.fxml;
			exports main.com.game;
}