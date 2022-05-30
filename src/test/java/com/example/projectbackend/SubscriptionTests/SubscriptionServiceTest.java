package com.example.projectbackend.SubscriptionTests;

import com.example.projectbackend.DALInterfaces.ISubscriptionDAL;
import com.example.projectbackend.Model.Subscription;
import com.example.projectbackend.Model.Video;
import com.example.projectbackend.Model.request.SubscribeRequest;
import com.example.projectbackend.Repository.SubscriptionDalJDBC;
import com.example.projectbackend.Service.SubscriptionService;
import com.example.projectbackend.ServiceInterfaces.ISubscription;
import com.example.projectbackend.ServiceInterfaces.ISubscriptionService;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SubscriptionServiceTest {
    @Autowired
    ISubscriptionService service;

    @MockBean
    SubscriptionDalJDBC dal;

    @Test
    public void returnSubscriptionsById(){
        int id = 1;
        List<ISubscription> subscriptions = new ArrayList<>();

        when(dal.getSubscriptionsByUserID(id)).thenReturn(subscriptions);

        Assertions.assertEquals(new ResponseEntity(subscriptions, HttpStatus.OK), service.ReturnSubscriptionByID(id));
    }

    @Test
    public void returnSubscriptionsByIdFail(){
        int id = 1;
        List<ISubscription> subscriptions = null;

        when(dal.getSubscriptionsByUserID(id)).thenReturn(subscriptions);

        Assertions.assertEquals(new ResponseEntity(subscriptions, HttpStatus.NOT_FOUND), service.ReturnSubscriptionByID(id));
    }

    @Test
    public void subscribe(){
        int charityId = 1;
        int userId = 2;
        int videoId = 3;
        String description = "asd";

        Assertions.assertEquals(true, service.Subscribe(charityId, userId, videoId, description));
    }

    @Test
    public void requestTest(){
        SubscribeRequest request = new SubscribeRequest();
        request.setDescription("asd");
        request.getDescription();
        request.setCharityID(1);
        request.getCharityID();
        request.setVideoID(2);
        request.getVideoID();
    }

    @Test
    public void modelTest(){
        Subscription subscription = new Subscription();
        subscription.setID(1);
        subscription.getID();
        subscription.setCharity_id(2);
        subscription.getCharity_id();
        subscription.setUser_id(3);
        subscription.getUser_id();
        subscription.setDescription("asd");
        subscription.getDescription();
        subscription.setVideoLink("asd");
        subscription.getVideoLink();

        Subscription subscription1 = new Subscription();

        Video video = new Video();
        video.setID(1);
        video.getID();
        video.setCharityID(2);
        video.getCharityID();
        video.setVideoLink("asd");
        video.getVideoLink();
        video.setDescription("asdads");
        video.getDescription();

        Video video1 = new Video(1, 2, "asd", "asd");
    }
}
