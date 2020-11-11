package com.example.demo;

import com.example.demo.SpringModul.Controler.ClientControler;
import com.example.demo.SpringModul.Models.Client;
import com.example.demo.SpringModul.Models.Policy;
import com.example.demo.SpringModul.Repository.ClientRepository;
import com.example.demo.SpringModul.Repository.PoliceRepository;
import com.example.demo.SpringModul.Service.ClientService;
import com.example.demo.SpringModul.Service.PoliceService;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ClientControlerTest {


    @Mock
    private ClientRepository clientRepository;
    @InjectMocks
    private ClientService clientService;

//
    @Test
    public void addClient(){

        //given
        Client client =new Client(0,"Marcin" , "ASDASD","PAWEŁ" , "ASDASD","PAWEŁ" , "ASDASD");
        given(clientRepository.save(client)).willAnswer(e -> e.getArgument(0));
        //when
        Client expect =  clientService.SaveClient(client);
        //then
        assertThat(expect).isNotNull();
        verify(clientRepository).save(any(Client.class));
    }


    @Test
    public void updateClient(){

//        //given
//        Client client =new Client(0,"Marcin" , "ASDASD","PAWEŁ" , "ASDASD","PAWEŁ" , "ASDASD");
//        given(clientRepository.save(client)).willReturn(client);
//        //when
//        Client expect =  clientService.(client);
//        //then
//        assertThat(expect).isNotNull();
//        verify(clientRepository).save(any(Client.class));
    }

    @Test
    public void deletClient(){

        clientRepository.deleteById(1);
        verify(clientRepository, times(1)).deleteById(1);
    }

}
