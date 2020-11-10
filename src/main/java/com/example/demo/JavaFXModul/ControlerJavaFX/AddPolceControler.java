package com.example.demo.JavaFXModul.ControlerJavaFX;

import com.example.demo.JavaFXModul.HttpMetod.PoliceMetodHttp.HttpPostPolice;
import com.example.demo.JavaFXModul.HttpMetod.PoliceMetodHttp.HttpPatchPolice;
import com.example.demo.SpringModul.Models.Client;
import com.example.demo.SpringModul.Models.Police;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class AddPolceControler {

    private Client client ;
    private Police policeMain ;
    private Boolean ifedit ;

    @FXML
    private TextField NumberPolicy;

    @FXML
    private TextField Mark;

    @FXML
    private TextField Model;

    @FXML
    private TextField Vin;

    @FXML
    private TextField Registration;

    @FXML
    private TextField Tread;



    @FXML
    private Button AddUsers;

    @FXML
    private Button ButtonBack;
    @FXML
    public void Back(){
        Stage stage = (Stage) ButtonBack.getScene().getWindow();
        stage.close();

    }
    @FXML
  public  void AddUser() {
        initPolice();
        Stage stage = (Stage) AddUsers.getScene().getWindow();
        stage.close();
    }

    public void initPolice(){

        Police police = new Police();
        police.setNrPolice(NumberPolicy.getText());
        police.setMark(Mark.getText());
        police.setModel(Model.getText());
        police.setVin(Vin.getText());
        police.setReg(Registration.getText());
        police.setTread(Tread.getText());
        police.setClient(client);


        if(ifedit) {
            HttpPatchPolice.sendPatch(police);
            System.out.println("pierwsze=a");
        }else {
            HttpPostPolice.sendPOST(police);
            System.out.println("druga=a");
        }
    }
    @FXML
    public  void initialize( ){


    }


    public void setClient(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public Police getPolice() {
        return policeMain;
    }

    public void setPolice(Police police) {
        this.policeMain = police;
    }

    public Boolean getIfedit() {
        return ifedit;
    }

    public void setIfedit(Boolean ifedit) {
        this.ifedit = ifedit;
    }

    public void fillPolice(Police police ){
        this.NumberPolicy.setText(police.getNrPolice());
        this.Mark.setText(police.getMark());
        this.Model.setText(police.getModel());
        this.Vin.setText(police.getVin());
        this.Registration.setText(police.getReg());
        this.Tread.setText(police.getTread());
        setIfedit(true);
    }

}
