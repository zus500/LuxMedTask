package com.example.demo;

import com.example.demo.SpringModul.Controler.ClientControler;
import com.example.demo.SpringModul.Models.Client;
import com.example.demo.SpringModul.Repository.ClientRepository;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class ClientControlerTest {

    @Mock
    private ClientRepository clientRepository;

    @Test
    public void getALLClient(){
        //given
        ClientControler clientControler = mock(ClientControler.class);
        given(clientControler.getAllClients()).willReturn(fillClient());
        //when
        List<Client>  clients = (List<Client>) clientControler.getAllClients();
        //then
        Assert.assertThat(clients , Matchers.hasSize(3));
    }


    private  Iterable<Client> fillClient(){
        List<Client> clients = new ArrayList<>();
        clients.add(new Client("Paweł" , "ASDASD","PAWEŁ" , "ASDASD","PAWEŁ" , "ASDASD"));
        clients.add(new Client("Marcin" , "ASDASD","PAWEŁ" , "ASDASD","PAWEŁ" , "ASDASD"));
        clients.add(new Client("Michał" , "ASDASD","PAWEŁ" , "ASDASD","PAWEŁ" , "ASDASD"));
        return clients;
    }

    @Test
    public void addClient(){
        //given
        ClientControler clientControler = mock(ClientControler.class);
        given(clientControler.creatClient(Mockito.any(Client.class))).willReturn(new Client("Marcin" , "ASDASD"));
        //when
        Client client =  clientControler.creatClient(new Client());
        //then
        Assert.assertEquals(client.getName() , "Marcin");
        Assert.assertEquals(client.getLastname() , "ASDASD");
    }

    @Test
    public void deletClient(){
        //given
        ClientControler clientControler = mock(ClientControler.class);
        Client client = new Client();
        client.setId((long) 1);
        given(clientControler.creatClient(Mockito.any(Client.class))).willReturn(client);
        //when
        clientControler.deletUsers((long) 1);
        //then

    }

}
