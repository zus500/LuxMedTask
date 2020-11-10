package com.example.demo.JavaFXModul.ModelFx;

import com.example.demo.JavaFXModul.ControlerJavaFX.AddPolceControler;
import com.example.demo.JavaFXModul.ControlerJavaFX.ControlerMainScreen;
import com.example.demo.JavaFXModul.ControlerJavaFX.ControlerMenuPage;
import com.example.demo.JavaFXModul.HttpMetod.ClientMetodHttp.HttpDeletedClient;
import com.example.demo.JavaFXModul.HttpMetod.PoliceMetodHttp.HttpDeletePolice;
import com.example.demo.SpringModul.Models.Client;
import com.example.demo.SpringModul.Models.Police;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

public class MetodyStatyczne {

     private ControlerMenuPage controlerMenuPage;

    public MetodyStatyczne(ControlerMenuPage controlerMenuPage) {
        this.controlerMenuPage = controlerMenuPage;
    }

    public  Callback<TableColumn<Client, String>, TableCell<Client, String>> creatDeletButton(TableView<Client> tableView ){

        Callback<TableColumn<Client, String>, TableCell<Client, String>> cellFactory1
                =
                new Callback<TableColumn<Client, String>, TableCell<Client, String>>() {
                    @Override
                    public TableCell call(final TableColumn<Client, String> param) {
                        final TableCell<Client, String> cell = new TableCell<Client, String>() {

                            Button btn = new Button("Usuń");
                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {

                                    setGraphic(null);
                                    setText(null);
                                } else {

                                    btn.setOnAction( event -> {
                                        Client client = tableView.getItems().get(getIndex());
                                        HttpDeletedClient.deletClientById(new Long(client.getId()));
                                        controlerMenuPage.fillValue();
                                    });
                                    setGraphic(btn);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };
        return cellFactory1;
    }

    public  Callback<TableColumn<Client, String>, TableCell<Client, String>> creatAddPoliceButton(TableView<Client> tableView){

        Callback<TableColumn<Client, String>, TableCell<Client, String>> cellFactory
                =
                new Callback<TableColumn<Client, String>, TableCell<Client, String>>() {
                    @Override
                    public TableCell call(final TableColumn<Client, String> param) {
                        final TableCell<Client, String> cell = new TableCell<Client, String>() {

                            Button btn = new Button("Dodaj Polise");
                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {

                                    setGraphic(null);
                                    setText(null);
                                } else {
                                    btn.setOnAction(event -> {
                                        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/Fxml/AddPolice.fxml"));
                                        Client client = tableView.getItems().get(getIndex());
                                        controlerMenuPage.showNewScene(loader);
                                        AddPolceControler addPolceControler = loader.getController();
                                        addPolceControler.setControlerMenuPage(getControlerMenuPage());
                                        addPolceControler.setClient(client);
                                        addPolceControler.setIfedit(false);

                                    });
                                    setGraphic(btn);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };
        return cellFactory;
    }

    public  Callback<TableColumn<Police, String>, TableCell<Police, String>> crearDeletButtonPolicy(TableView<Police> tableView ){

        Callback<TableColumn<Police, String>, TableCell<Police, String>> cellFactory1
                =
                new Callback<TableColumn<Police, String>, TableCell<Police, String>>() {
                    @Override
                    public TableCell call(final TableColumn<Police, String> param) {
                        final TableCell<Client, String> cell = new TableCell<Client, String>() {

                            Button btn = new Button("Usuń");
                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {

                                    setGraphic(null);
                                    setText(null);
                                } else {

                                    btn.setOnAction( event -> {
                                        Police police = tableView.getItems().get(getIndex());
                                        HttpDeletePolice.deletPoliceById(new Long(police.getId()));
                                        controlerMenuPage.fillBotTable(police.getClient());

                                    });
                                    setGraphic(btn);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };
        return cellFactory1;
    }

    public  Callback<TableColumn<Police, String>, TableCell<Police, String>> creatEditButtonPolicy(TableView<Police> tableView ){

        Callback<TableColumn<Police, String>, TableCell<Police, String>> cellFactory1
                =
                new Callback<TableColumn<Police, String>, TableCell<Police, String>>() {
                    @Override
                    public TableCell call(final TableColumn<Police, String> param) {
                        final TableCell<Client, String> cell = new TableCell<Client, String>() {

                            Button btn = new Button("Edytuj");
                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {

                                    setGraphic(null);
                                    setText(null);
                                } else {

                                    btn.setOnAction( event -> {
                                        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/Fxml/AddPolice.fxml"));
                                        Police police = tableView.getItems().get(getIndex());
                                        controlerMenuPage.showNewScene(loader);
                                        AddPolceControler addPolceControler = loader.getController();
                                        addPolceControler.setControlerMenuPage(getControlerMenuPage());
                                        addPolceControler.setClient(police.getClient());
                                        addPolceControler.fillPolice(police);
                                    });
                                    setGraphic(btn);
                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };
        return cellFactory1;
    }


    public ControlerMenuPage getControlerMenuPage() {
        return controlerMenuPage;
    }

}
