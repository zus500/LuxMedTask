package com.example.demo.JavaFXModul.ControlerJavaFX;

import com.example.demo.JavaFXModul.HttpMetod.ClientMetodHttp.HttpPostClient;
import com.example.demo.JavaFXModul.HttpMetod.ClientMetodHttp.HttpPutClient;
import com.example.demo.SpringModul.Models.Client;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddUserControler {

    private ControlerMenuPage controlerMenuPage;
    private Client client;
    private boolean isedit;

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
    public  void AddClient(){

        Client client = fillUser();
        if(isedit) {
            client.setId(this.client.getId());
            HttpPutClient.putClient(client);
        } else {
            HttpPostClient.postClient(client);
        }
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    public void setIsedit(boolean isedit) {
        this.isedit = isedit;
    }

    public void fillClient (Client client){
        setClient(client);
        this.Name.setText(client.getName());
        this.Birth.setText(client.getDateofBirth());
        this.Email.setText(client.getEmail());
        this.LastName.setText(client.getLastname());
        this.Pesel.setText(client.getPesel());
        this.Phone.setText(client.getTelephone());
        setIsedit(true);
    }
}
