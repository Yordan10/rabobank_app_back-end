package com.example.projectbackend.Model.request;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserEditDetailsRequest {
    protected String email;
    protected String firstName;
    protected String lastName;
}
