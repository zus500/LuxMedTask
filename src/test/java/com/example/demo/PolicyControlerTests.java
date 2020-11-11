package com.example.demo;

import com.example.demo.SpringModul.Models.Client;
import com.example.demo.SpringModul.Models.Policy;
import com.example.demo.SpringModul.Repository.ClientRepository;
import com.example.demo.SpringModul.Repository.PoliceRepository;
import com.example.demo.SpringModul.Service.ClientService;

import com.example.demo.SpringModul.Service.PoliceService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import java.beans.Transient;
import java.util.Optional;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class PolicyControlerTests {


    @Mock
    private PoliceRepository policeRepository;
    @InjectMocks
    private PoliceService policeService;


    @Test
    public void deletePolicy() {
        policeService.DeletPolicy(1);
        verify(policeRepository , times(1)).deleteById(1);
    }

    @Test
    public void updatePolicy(){
        Policy policy = new Policy(1 , "123545" , "asdasdd" ,"123545" , "asdasdd" ,"123545" , "asdasdd");

        given(policeRepository.save(policy)).willReturn(policy);

        Policy expect = policeService.UpdatePolice(policy);

        assertThat(expect).isNotNull();
        verify(policeRepository).save(any(Policy.class));
    }

    @Test
    public void savePolicy(){
        Policy policy = new Policy(1 , "123545" , "asdasdd" ,"123545" , "asdasdd" ,"123545" , "asdasdd");

        given(policeRepository.save(policy)).willAnswer(e -> e.getArgument(0));

        Policy expect = policeService.SavePolice(policy);

        assertThat(expect).isNotNull();
        verify(policeRepository).save(any(Policy.class));
    }


}
