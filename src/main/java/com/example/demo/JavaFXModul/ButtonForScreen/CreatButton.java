package com.example.demo.JavaFXModul.ButtonForScreen;

import com.example.demo.JavaFXModul.ControlerJavaFX.AddPolceControler;
import com.example.demo.JavaFXModul.ControlerJavaFX.AddUserControler;
import com.example.demo.JavaFXModul.ControlerJavaFX.ControlerMenuPage;
import com.example.demo.JavaFXModul.HttpMetod.ClientMetodHttp.HttpDeletedClient;
import com.example.demo.JavaFXModul.HttpMetod.PoliceMetodHttp.HttpDeletePolice;
import com.example.demo.SpringModul.Models.Client;
import com.example.demo.SpringModul.Models.Policy;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

public class CreatButton {

     private ControlerMenuPage controlerMenuPage;

    public CreatButton(ControlerMenuPage controlerMenuPage) {
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

    public  Callback<TableColumn<Policy, String>, TableCell<Policy, String>> crearDeletButtonPolicy(TableView<Policy> tableView ){

        Callback<TableColumn<Policy, String>, TableCell<Policy, String>> cellFactory1
                =
                new Callback<TableColumn<Policy, String>, TableCell<Policy, String>>() {
                    @Override
                    public TableCell call(final TableColumn<Policy, String> param) {
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
                                        Policy policy = tableView.getItems().get(getIndex());
                                        HttpDeletePolice.deletPoliceById(new Long(policy.getId()));
                                        controlerMenuPage.fillBotTable(policy.getClient());
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

    public  Callback<TableColumn<Policy, String>, TableCell<Policy, String>> creatEditButtonPolicy(TableView<Policy> tableView ){

        Callback<TableColumn<Policy, String>, TableCell<Policy, String>> cellFactory1
                =
                new Callback<TableColumn<Policy, String>, TableCell<Policy, String>>() {
                    @Override
                    public TableCell call(final TableColumn<Policy, String> param) {
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
                                        Policy policy = tableView.getItems().get(getIndex());
                                        controlerMenuPage.showNewScene(loader);
                                        AddPolceControler addPolceControler = loader.getController();
                                        addPolceControler.setControlerMenuPage(getControlerMenuPage());
                                        addPolceControler.setClient(policy.getClient());
                                        addPolceControler.fillPolice(policy);
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

    public  Callback<TableColumn<Client, String>, TableCell<Client, String>> creatEditClientButton(TableView<Client> tableView){

        Callback<TableColumn<Client, String>, TableCell<Client, String>> cellFactory
                =
                new Callback<TableColumn<Client, String>, TableCell<Client, String>>() {
                    @Override
                    public TableCell call(final TableColumn<Client, String> param) {
                        final TableCell<Client, String> cell = new TableCell<Client, String>() {

                            Button btn = new Button("Edycja");
                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {

                                    setGraphic(null);
                                    setText(null);
                                } else {
                                    btn.setOnAction(event -> {
                                        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/Fxml/AddClient.fxml"));
                                        Client client = tableView.getItems().get(getIndex());
                                        controlerMenuPage.showNewScene(loader);
                                        AddUserControler addUserControler = loader.getController();
                                        addUserControler.setControlerMenuPage(getControlerMenuPage());
                                        addUserControler.fillClient(client);
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
    public ControlerMenuPage getControlerMenuPage() {
        return controlerMenuPage;
    }

}
