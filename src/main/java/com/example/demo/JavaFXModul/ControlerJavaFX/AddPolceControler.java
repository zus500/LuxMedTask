package com.example.demo.JavaFXModul.ControlerJavaFX;

import com.example.demo.JavaFXModul.HttpMetod.PoliceMetodHttp.HttpPostPolicy;
import com.example.demo.JavaFXModul.HttpMetod.PoliceMetodHttp.HttpPutPolicy;
import com.example.demo.SpringModul.Models.Client;
import com.example.demo.SpringModul.Models.Policy;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class AddPolceControler {

    private Client client ;
    private Policy policyMain;
    private Boolean ifedit ;
    private ControlerMenuPage controlerMenuPage;

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
        controlerMenuPage.fillValue();
        controlerMenuPage.fillBotTable(getPolice().getClient());
    }
    @FXML
  public  void AddPolice() {
        initPolice();
        Stage stage = (Stage) AddUsers.getScene().getWindow();
        stage.close();
        controlerMenuPage.fillValue();
        controlerMenuPage.fillBotTable(getPolice().getClient());

    }

    public void initPolice(){

        Policy policy = new Policy();
        policy.setNrPolice(NumberPolicy.getText());
        policy.setMark(Mark.getText());
        policy.setModel(Model.getText());
        policy.setVin(Vin.getText());
        policy.setReg(Registration.getText());
        policy.setTread(Tread.getText());
        policy.setClient(client);
        if(ifedit) {
            policy.setId(policyMain.getId());
            HttpPutPolicy.putPolice(policy);
        }else {
            setPolice(policy);
            HttpPostPolicy.postPolicy(policy);
        }
    }
    public void setClient(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public Policy getPolice() {
        return policyMain;
    }

    public void setPolice(Policy policy) {
        this.policyMain = policy;
    }


    public void setControlerMenuPage(ControlerMenuPage controlerMenuPage) {
        this.controlerMenuPage = controlerMenuPage;
    }

    public void setIfedit(Boolean ifedit) {
        this.ifedit = ifedit;
    }

    public void fillPolice(Policy policy){

        setPolice(policy);
        this.NumberPolicy.setText(policy.getNrPolice());
        this.Mark.setText(policy.getMark());
        this.Model.setText(policy.getModel());
        this.Vin.setText(policy.getVin());
        this.Registration.setText(policy.getReg());
        this.Tread.setText(policy.getTread());
        setIfedit(true);
    }

}
