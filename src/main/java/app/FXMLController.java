package app;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import engine.Painting;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.awt.Color;

public class FXMLController implements Initializable {
	
	@FXML
	private Button startButton, quitButton;
	@FXML
	private ImageView mapImage;
	@FXML
	private TextField guessField;
	@FXML
	private Label progressLabel;
	
	static Image image;
	static ArrayList <Country> lista;
	
	@Override
	public void initialize(URL location, ResourceBundle arg1) {
		lista = new ArrayList<Country> ();
		lista.add(new Country("suomi", 350, 200));
		lista.add(new Country("ruotsi", 153, 242));
		lista.add(new Country("norja", 91, 161));
	}
	
	@FXML
	public void handleStartGameButton (ActionEvent event) {
		try {
			Stage gameStage = new Stage();
			Parent root1 = FXMLLoader.load(getClass().getResource("/GameCanvas.fxml"));
			Scene gameScene = new Scene(root1);
			gameStage.setScene(gameScene);
	        gameStage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	public void handleCloseButton(ActionEvent e) {
		Platform.exit();
		System.exit(0);
	}
	
	
	@FXML
	public void guessCountry(KeyEvent e) {
		String guess = guessField.getText(); 
		
		if (e.getCode() == KeyCode.ENTER) {
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).getName().equals(guess) && lista.get(i).getIsGuessed() == false) {
					image = mapImage.getImage();
					mapImage.setImage(Painting.floodFillImage(image, lista.get(i).getXcoord(), lista.get(i).getYcoord(), Color.green));	
					lista.get(i).setIsGuessed();
					refreshProgression();
				}
				guessField.setText("");
			}
		}
	}
	
	@FXML
	public void refreshProgression() {
		int guessed = 0;
		for (Country c : lista) {
			if (c.getIsGuessed() == true) {
				guessed++;
			}
		}
		progressLabel.setText(guessed + "/" + lista.size());
	}
	
	@FXML
	public void katsoKoodrinaatit(MouseEvent e) {
		int x = (int) e.getX(); int y = (int) e.getY();
		System.out.println("X= " + x + " Y= " + y
				);
		
	}


}
