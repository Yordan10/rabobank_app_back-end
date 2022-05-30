package com.example.projectbackend.Controller;


import com.example.projectbackend.Model.FileInfo;
import com.example.projectbackend.Model.request.UserCreateRequest;
import com.example.projectbackend.Model.request.UserEditDetailsRequest;
import com.example.projectbackend.Repository.UserDalJDBC;
import com.example.projectbackend.Service.FileStorageService;
import com.example.projectbackend.Service.UserService;
import com.example.projectbackend.ServiceInterfaces.IAccount;
import com.example.projectbackend.ServiceInterfaces.IUserService;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/account")
public class  AccountController {

    //private IUserService userService = new UserService(new UserDalJDBC());

    @Autowired
    private IUserService userService = new UserService(new UserDalJDBC());

    @Autowired
    FileStorageService storageService;

    @GetMapping
    public CompletableFuture<ResponseEntity> GetAllAccounts()
    {
        return userService.getAllAccounts();

    }

    @GetMapping("/{id}")
    public  ResponseEntity<IAccount> getAccountById(@PathVariable(value = "id") int id)
    {
        return  userService.ReturnAccountById(id);
    }


    @GetMapping("/user")
    public ResponseEntity<IAccount> GetAccountByUsername()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        return userService.ReturnAccountByUsername(currentPrincipalName);
    }

    @PostMapping("/register")
    public ResponseEntity UserRegistration(@RequestBody UserCreateRequest userCreateRequest) {

        userService.UserRegistration(userCreateRequest);
        return ResponseEntity.ok().build();
    }





    @PostMapping("/edit-details")
    public ResponseEntity EditUserDetails(@RequestBody UserEditDetailsRequest userEditDetailsRequest){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        userService.EditUserDetails(currentPrincipalName, userEditDetailsRequest);
        return ResponseEntity.ok().build();
    }


}
