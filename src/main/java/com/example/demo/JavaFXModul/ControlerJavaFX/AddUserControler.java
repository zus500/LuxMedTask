package com.example.demo.JavaFXModul.ControlerJavaFX;

import com.example.demo.JavaFXModul.HttpMetod.ClientMetodHttp.HttpPostClient;
import com.example.demo.SpringModul.Models.Client;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddUserControler {

    private ControlerMenuPage controlerMenuPage;

    @FXML
    private Button ButtonBack;


    @FXML
    private Button AddUsers;

    @FXML
    private TextField Name;
    @FXML
    private TextField LastName;
    @FXML
    private TextField Birth;
    @FXML
    private TextField Pesel;
    @FXML
    private TextField Phone;
    @FXML
    private TextField Email;



    @FXML
    public void Back(){

        Stage stage = (Stage) ButtonBack.getScene().getWindow();
        stage.close();
    }
    @FXML
    public  void AddUser (){

        Client client = fillUser();
        HttpPostClient.postClient(client);
        Stage stage = (Stage) AddUsers.getScene().getWindow();
        this.controlerMenuPage.fillValue();
        stage.close();
    }


        public Client fillUser(){
            Client client = new Client();
            client.setName(Name.getText());
            client.setLastname(LastName.getText());
            client.setDateofBirth(Birth.getText());
            client.setPesel(Pesel.getText());
            client.setTelephone(Phone.getText());
            client.setEmail(Email.getText());
            return client;
        }


    public void setControlerMenuPage(ControlerMenuPage controlerMenuPage) {
        this.controlerMenuPage = controlerMenuPage;
    }
}
