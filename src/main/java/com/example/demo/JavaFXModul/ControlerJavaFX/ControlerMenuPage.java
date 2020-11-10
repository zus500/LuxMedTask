package com.example.demo.JavaFXModul.ControlerJavaFX;


import com.example.demo.JavaFXModul.HttpMetod.ClientMetodHttp.HttpDeletedClient;
import com.example.demo.JavaFXModul.HttpMetod.ClientMetodHttp.HttpGetAllClient;
import com.example.demo.JavaFXModul.HttpMetod.PoliceMetodHttp.HttpGetAllPolice;
import com.example.demo.JavaFXModul.ModelFx.MetodyStatyczne;
import com.example.demo.SpringModul.Models.Client;
import com.example.demo.SpringModul.Models.Police;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
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
    private TableColumn<Client , String> Name;
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
    private TableColumn<Client, String> DeleUser;
    @FXML
    private TableColumn<Client, String> AddPolice;


    @FXML
    private TableColumn<Police, String>  NrPolice;

    @FXML
    private TableColumn<Police, String>  Mark;

    @FXML
    private TableColumn<Police, String>  Model;

    @FXML
    private TableColumn<Police, String>  Vin;

    @FXML
    private TableColumn<Police, String>  Reg;

    @FXML
    private TableColumn<Police, String> Tread;


    @FXML
    private TableColumn<Police, String> DeletePolicy;

    @FXML
    private TableColumn<Police, String> EditPolicy;


    @FXML
    TableView<Client>  tableView;

    @FXML
    TableView<Police>  TableViewBot;



    @FXML
    public void AddUsers (){

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/Fxml/AddUser.fxml"));
        showNewScene(loader);
        AddUserControler add = loader.getController();
        add.setControlerMenuPage(this);
    }
    @FXML
    public void initialize()  {
        fillValue();

    }

    public   void  fillValue(){
        List<Client> list = new ArrayList<Client>();
        list.clear();
        list.addAll(HttpGetAllClient.getAllClient());
        ObservableList<Client> observableList = FXCollections.observableArrayList(list);
        this.tableView.setItems(observableList);
        this.Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.LastName.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        this.Pesel.setCellValueFactory(new PropertyValueFactory<>("pesel"));
        this.Birth.setCellValueFactory(new PropertyValueFactory<>("DateofBirth"));
        this.Phone.setCellValueFactory(new PropertyValueFactory<>("Telephone"));
        this.Email.setCellValueFactory(new PropertyValueFactory<>("Email"));

        MetodyStatyczne metodyStatyczne = new MetodyStatyczne(this);

        this.DeleUser.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));
        Callback<TableColumn<Client, String>, TableCell<Client, String>> cellFactory1 = metodyStatyczne.creatDeletButton(tableView );
        this.DeleUser.setCellFactory(cellFactory1);

        this.AddPolice.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));
        Callback<TableColumn<Client, String>, TableCell<Client, String>> cellFactory2 = metodyStatyczne.creatAddPoliceButton(tableView);
        this.AddPolice.setCellFactory(cellFactory2);

        this.DeletePolicy.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));
        Callback<TableColumn<Police, String>, TableCell<Police, String>> cellFactory3 = metodyStatyczne.crearDeletButtonPolicy(TableViewBot);
        this.DeletePolicy.setCellFactory(cellFactory3);

        this.EditPolicy.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));
        Callback<TableColumn<Police, String>, TableCell<Police, String>> cellFactory4 = metodyStatyczne.creatEditButtonPolicy(TableViewBot);
        this.EditPolicy.setCellFactory(cellFactory4);
    }



    @FXML
    public void ShowPolice(Event event  ) {
       Client client = tableView.getSelectionModel().getSelectedItem();
       if(client.equals(null)){
       }else {
           fillBotTable(client);
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
        List<Police> list = new ArrayList<Police>();
        list.clear();
        this.TableViewBot.getItems().clear();
        list.addAll(HttpGetAllPolice.getAllClient(client));
        ObservableList<Police> observableList = FXCollections.observableArrayList(list);
        this.TableViewBot.setItems(observableList);
        this.NrPolice.setCellValueFactory(new PropertyValueFactory<>("NrPolice"));
        this.Mark.setCellValueFactory(new PropertyValueFactory<>("Mark"));
        this.Model.setCellValueFactory(new PropertyValueFactory<>("Model"));
        this.Vin.setCellValueFactory(new PropertyValueFactory<>("Vin"));
        this.Reg.setCellValueFactory(new PropertyValueFactory<>("Reg"));
        this.Tread.setCellValueFactory(new PropertyValueFactory<>("Tread"));
    }
}







