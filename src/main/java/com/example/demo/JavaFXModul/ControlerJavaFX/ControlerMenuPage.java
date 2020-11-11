package com.example.demo.JavaFXModul.ControlerJavaFX;


import com.example.demo.JavaFXModul.HttpMetod.ClientMetodHttp.HttpGetAllClient;
import com.example.demo.JavaFXModul.HttpMetod.PoliceMetodHttp.HttpGetAllPolice;
import com.example.demo.JavaFXModul.ButtonForScreen.CreatButton;
import com.example.demo.SpringModul.Models.Client;
import com.example.demo.SpringModul.Models.Policy;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControlerMenuPage {


    @FXML
    private TableColumn<Client , String> Name;   // Values for top Table
    @FXML
    private TableColumn<Client , String> LastName;
    @FXML
    private TableColumn<Client , String> Pesel;
    @FXML
    private TableColumn<Client , String> Birth;
    @FXML
    private TableColumn<Client , String> Phone;
    @FXML
    private TableColumn<Client , String> Email;
    @FXML
    private TableColumn<Client, String> DeleUser; //Button
    @FXML
    private TableColumn<Client, String> AddPolice;
    @FXML
    private TableColumn<Client, String> EditClient;


    @FXML
    private TableColumn<Policy, String>  NrPolice; // Values for top Bot
    @FXML
    private TableColumn<Policy, String>  Mark;
    @FXML
    private TableColumn<Policy, String>  Model;
    @FXML
    private TableColumn<Policy, String>  Vin;
    @FXML
    private TableColumn<Policy, String>  Reg;
    @FXML
    private TableColumn<Policy, String> Tread;
    @FXML
    private TableColumn<Policy, String> DeletePolicy; // Button
    @FXML
    private TableColumn<Policy, String> EditPolicy;



    @FXML
    TableView<Client> tableViewTop;
    @FXML
    TableView<Policy>  TableViewBot;

    private  Client client;

    @FXML
    public void AddUsers ()
    {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/Fxml/AddClient.fxml"));
        showNewScene(loader);
        AddUserControler add = loader.getController();
        add.setIsedit(false);
        add.setControlerMenuPage(this);
    }
    @FXML
    public void initialize()  {
        fillValue(); //set tables top and bot values
        this.client =  tableViewTop.getItems().get(1);
        fillBotTable(this.client);
    }

    public   void  fillValue(){ //set tables top and bot values
        List<Client> list = new ArrayList<Client>();
        list.clear();
        list.addAll(HttpGetAllClient.getAllClient());
        ObservableList<Client> observableList = FXCollections.observableArrayList(list);
        this.tableViewTop.setItems(observableList);
        this.Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.LastName.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        this.Pesel.setCellValueFactory(new PropertyValueFactory<>("pesel"));
        this.Birth.setCellValueFactory(new PropertyValueFactory<>("dateofBirth"));
        this.Phone.setCellValueFactory(new PropertyValueFactory<>("Telephone"));
        this.Email.setCellValueFactory(new PropertyValueFactory<>("Email"));

        CreatButton creatButton = new CreatButton(this);

        this.DeleUser.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));
        Callback<TableColumn<Client, String>, TableCell<Client, String>> cellFactory1 = creatButton.creatDeletButton(tableViewTop);
        this.DeleUser.setCellFactory(cellFactory1);

        this.AddPolice.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));
        Callback<TableColumn<Client, String>, TableCell<Client, String>> cellFactory2 = creatButton.creatAddPoliceButton(tableViewTop);
        this.AddPolice.setCellFactory(cellFactory2);

        this.EditClient.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));
        Callback<TableColumn<Client, String>, TableCell<Client, String>> cellFactory3 = creatButton.creatEditClientButton(tableViewTop);
        this.EditClient.setCellFactory(cellFactory3);




        this.DeletePolicy.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));
        Callback<TableColumn<Policy, String>, TableCell<Policy, String>> cellFactory4 = creatButton.crearDeletButtonPolicy(TableViewBot);
        this.DeletePolicy.setCellFactory(cellFactory4);

        this.EditPolicy.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));
        Callback<TableColumn<Policy, String>, TableCell<Policy, String>> cellFactory5 = creatButton.creatEditButtonPolicy(TableViewBot);
        this.EditPolicy.setCellFactory(cellFactory5);
    }



    @FXML
    public void ShowPolice() {
       Client clienttable = tableViewTop.getSelectionModel().getSelectedItem();
       if(clienttable  != null){
           fillBotTable(clienttable);
       }else {
           fillBotTable(this.client);
       }

    }
    public void showNewScene(FXMLLoader loader  ){
        VBox vBox = null;
        try {
            vBox = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(vBox);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    public void fillBotTable (Client client){
        List<Policy> list = new ArrayList<Policy>();
        list.clear();
        this.TableViewBot.getItems().clear();
        list.addAll(HttpGetAllPolice.getAllClient(client));
        ObservableList<Policy> observableList = FXCollections.observableArrayList(list);
        this.TableViewBot.setItems(observableList);
        this.NrPolice.setCellValueFactory(new PropertyValueFactory<>("NrPolice"));
        this.Mark.setCellValueFactory(new PropertyValueFactory<>("Mark"));
        this.Model.setCellValueFactory(new PropertyValueFactory<>("Model"));
        this.Vin.setCellValueFactory(new PropertyValueFactory<>("Vin"));
        this.Reg.setCellValueFactory(new PropertyValueFactory<>("Reg"));
        this.Tread.setCellValueFactory(new PropertyValueFactory<>("Tread"));
    }
}








