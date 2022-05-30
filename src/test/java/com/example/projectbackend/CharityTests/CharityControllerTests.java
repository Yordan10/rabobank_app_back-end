package com.example.projectbackend.CharityTests;

import com.example.projectbackend.Controller.CharityController;
import com.example.projectbackend.Model.Charity;
import com.example.projectbackend.Model.Video;
import com.example.projectbackend.ServiceInterfaces.ICharity;
import com.example.projectbackend.ServiceInterfaces.ICharityService;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CharityControllerTests {

    @Autowired
    CharityController controller;

    @MockBean
    ICharityService service;

    @Test
    public void getCharityById(){
        ICharity charity = new Charity();
        int id = 1;

        when(service.ReturnCharityByID(id)).thenReturn(new ResponseEntity(charity, HttpStatus.OK));

        Assertions.assertEquals(new ResponseEntity(charity, HttpStatus.OK), controller.GetCharityById(id));
    }

    @Test
    public void getCharityVideosById(){
        List<Video> videos = new ArrayList<>();
        int id = 1;

        when(service.ReturnVideosOfCharityByID(id)).thenReturn(new ResponseEntity(videos, HttpStatus.OK));

        Assertions.assertEquals(new ResponseEntity(videos, HttpStatus.OK), controller.GetVideoCharityById(id));
    }

    //ADD TEST FOR getAllCharities (Async)

//    @Test
//    public void getAllCharities() throws ExecutionException, InterruptedException {
////        List<I>
////        when(service.ReturnAllCharities()).thenReturn();
//
//        CompletableFuture<ResponseEntity> result = controller.GetAllCharities();
//        await().atMost(1000, TimeUnit.MILLISECONDS).until(result::isDone);
//
//        Assertions.assertEquals((HttpStatus.OK), controller.GetAllCharities().get().getStatusCode());
//    }

}
