package com.example.projectbackend.SubscriptionTests;

import com.example.projectbackend.Controller.SubscriptionController;
import com.example.projectbackend.Model.UserAccount;
import com.example.projectbackend.Model.request.SubscribeRequest;
import com.example.projectbackend.Service.SubscriptionService;
import com.example.projectbackend.Service.UserService;
import com.example.projectbackend.ServiceInterfaces.IAccount;
import com.example.projectbackend.ServiceInterfaces.ISubscription;
import com.example.projectbackend.ServiceInterfaces.ISubscriptionService;
import com.example.projectbackend.ServiceInterfaces.IUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@WithMockUser(username = "testuser", roles = {"USER"})
public class SubscriptionControllerTests {
    @Autowired
    SubscriptionController controller;

    @MockBean
    SubscriptionService service;

    @MockBean
    UserService userService;

    @Test
    public void getSubscriptionsById(){
        int id = 1;
        List<ISubscription> subscriptions = new ArrayList<>();
        IAccount account = new UserAccount();

        when(userService.GetAccountByUsername("testuser")).thenReturn(account);

        Assertions.assertEquals(null, controller.GetSubscriptionsById());
    }



}
