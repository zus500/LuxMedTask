package com.example.demo.JavaFXModul.ControlerJavaFX;

import com.example.demo.JavaFXModul.ModelFx.MetodyStatyczne;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ControlerMainScreen {

    @FXML
    private VBox MainScreemVbox;

    @FXML
    public void initialize(){

        loadMainScreen();


    }

    public void loadMainScreen() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/Fxml/MenuPage.fxml"));
        VBox vBox = null;
        try {
           vBox =  loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setScreen(vBox);
    }

    public void setScreen(VBox vBox) {
        MainScreemVbox.getChildren().clear();
        MainScreemVbox.getChildren().add(vBox);
    }

}
