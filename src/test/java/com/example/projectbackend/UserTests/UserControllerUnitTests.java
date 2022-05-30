package com.example.projectbackend.UserTests;
import com.example.projectbackend.Controller.AccountController;
import com.example.projectbackend.Model.User;
import com.example.projectbackend.Model.UserAccount;
import com.example.projectbackend.Model.request.UserCreateRequest;
import com.example.projectbackend.Model.request.UserEditDetailsRequest;
import com.example.projectbackend.Service.UserService;
import com.example.projectbackend.ServiceInterfaces.IAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;

import static org.mockito.Mockito.*;

@SpringBootTest
public class UserControllerUnitTests {

    @Autowired
    AccountController accountController;

    @MockBean
    UserService userService;

    @Test
    void getAccountByIdTest(){
        int id = 10;
        IAccount user = new UserAccount(10,"nz","asd","asd","asd","aSD",10.2,"ASD");
        user.getId();
        user.getEmail();
        user.getFirstName();
        user.getUsername();
        user.getPassword();
        user.getLastName();

        user.setEmail("asd");
        user.setUsername("asd");
        user.setPassword("ahjfd");
        user.setLastName("asd");
        user.setId(1);
        user.setFirstName("aj");

        when(userService.ReturnAccountById(id)).thenReturn(new ResponseEntity(user, HttpStatus.OK));

        Assertions.assertEquals(new ResponseEntity(user,HttpStatus.OK),accountController.getAccountById(id));
    }
    @Test
    @WithMockUser(username = "name",roles={"USER"})
    void getAccountByUsernameTest(){

        UserAccount userAccount = new UserAccount();
        User user2 =  new UserAccount();
        user2.setIban("ajs");
        user2.setBalance(12.2);
        user2.getBalance();
        user2.getIban();
        IAccount user = new UserAccount(10,"nz","asd","asd","asd","aSD",10.2,"ASD");
        when(userService.ReturnAccountByUsername("name")).thenReturn(new ResponseEntity(user, HttpStatus.OK));

        Assertions.assertEquals(new ResponseEntity(user,HttpStatus.OK),accountController.GetAccountByUsername());
    }

    @Test
    void userRegistrationTest(){
        UserCreateRequest userCreateRequest = new UserCreateRequest();
        userCreateRequest.setUsername("secret");
        userCreateRequest.setPassword("taina");
        userCreateRequest.setEmail("com");
        userCreateRequest.setLastName("yo");
        userCreateRequest.setId(1);
       userCreateRequest.setBalance(0.0);
       userCreateRequest.setIban("ad");

       userCreateRequest.getUsername();
       userCreateRequest.getEmail();
       userCreateRequest.getFirstName();
       userCreateRequest.getId();
       userCreateRequest.getIban();
       userCreateRequest.getBalance();
       userCreateRequest.getLastName();

        when(userService.UserRegistration(userCreateRequest)).thenReturn(true);


        Assertions.assertEquals(new ResponseEntity(HttpStatus.OK),accountController.UserRegistration(userCreateRequest));

    }

    @Test
    @WithMockUser(username = "name",roles={"USER"})
    void editUserDetailsTest(){

        IAccount user = new UserAccount(10,"nz","asd","asd","asd","aSD",10.2,"ASD");
        UserEditDetailsRequest userEditDetailsRequest = new UserEditDetailsRequest();

        userEditDetailsRequest.setEmail("asd");
        userEditDetailsRequest.setLastName("ad");
        userEditDetailsRequest.setFirstName("are");
        userEditDetailsRequest.getEmail();
        userEditDetailsRequest.getLastName();
        userEditDetailsRequest.getFirstName();

        when(userService.ReturnAccountByUsername("name")).thenReturn(new ResponseEntity(user, HttpStatus.OK));

        when(userService.EditUserDetails("name",userEditDetailsRequest)).thenReturn(true);

        Assertions.assertEquals(new ResponseEntity(HttpStatus.OK),accountController.EditUserDetails(userEditDetailsRequest));
    }

}
