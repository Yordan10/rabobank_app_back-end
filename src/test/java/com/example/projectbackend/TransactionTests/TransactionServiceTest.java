package com.example.projectbackend.TransactionTests;

import com.example.projectbackend.Controller.TransactionController;
import com.example.projectbackend.Model.Transaction;
import com.example.projectbackend.Repository.DonationDalJDBC;
import com.example.projectbackend.Repository.TransactionDalJDBC;
import com.example.projectbackend.Service.DonationService;
import com.example.projectbackend.Service.TransactionService;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class TransactionServiceTest {

    @Autowired
    TransactionService transactionService;

    @MockBean
    TransactionDalJDBC transactionDalJDBC;

    @Autowired
    TransactionController transactionController;

    @Test
    public void contextLoads() throws Exception {
        Assertions.assertNotNull(transactionController);
    }


    @Test
    public void returnAllSent(){
        List<Transaction> transactions = new ArrayList<>();
        Transaction transaction = new Transaction(1, 1, 1, 4.4, "test ", null, "asd123");
        transactions.add(transaction);
        int user_id = 10;

        when(transactionDalJDBC.getAllSentTransactions(user_id)).thenReturn(Stream.of(transaction)
                .collect(Collectors.toList()));
        Assertions.assertEquals(new ResponseEntity(transactions, HttpStatus.OK),transactionService.ReturnAllSentTransactions(user_id));

    }
    @Test
    public void returnAllSentFail(){
        int user_id =1;
        when(transactionDalJDBC.getAllSentTransactions(user_id)).thenReturn(null);
        Assertions.assertEquals(new ResponseEntity(HttpStatus.NOT_FOUND),transactionService.ReturnAllSentTransactions(user_id));

    }
    @Test
    public void returnAllReceived(){
        List<Transaction> transactions = new ArrayList<>();
        Transaction transaction = new Transaction(1, 1, 1, 4.4, "test ", null, "asd123");
        transactions.add(transaction);
        int user_id = 10;

        when(transactionDalJDBC.getAllReceivedTransactions(user_id)).thenReturn(Stream.of(transaction)
                .collect(Collectors.toList()));
        Assertions.assertEquals(new ResponseEntity(transactions, HttpStatus.OK),transactionService.ReturnAllReceivedTransactions(user_id));

    }

    @Test
    public void returnAllReceivedFail(){
        int user_id =1;
        when(transactionDalJDBC.getAllReceivedTransactions(user_id)).thenReturn(null);
        Assertions.assertEquals(new ResponseEntity(HttpStatus.NOT_FOUND),transactionService.ReturnAllReceivedTransactions(user_id));
    }

    @Test
    public void returnRecentTransactions(){
        List<Transaction> transactions = new ArrayList<>();
        Transaction transaction = new Transaction(1, 1, 1, 4.4, "test ", null, "asd123");
        transactions.add(transaction);
        int user_id = 10;

        when(transactionDalJDBC.getRecentTransactionsByUser(user_id)).thenReturn(Stream.of(transaction)
                .collect(Collectors.toList()));
        Assertions.assertEquals(new ResponseEntity(transactions, HttpStatus.OK),transactionService.ReturnRecentTransactionsByUser(user_id));
    }
    @Test
    public void returnRecentTransactionsFail(){
        int user_id =1;
        when(transactionDalJDBC.getRecentTransactionsByUser(user_id)).thenReturn(null);
        Assertions.assertEquals(new ResponseEntity(HttpStatus.NOT_FOUND),transactionService.ReturnRecentTransactionsByUser(user_id));
    }

    @Test
    public void returnAllTransactionsByUser(){
        List<Transaction> transactions = new ArrayList<>();
        Transaction transaction = new Transaction(1, 1, 1, 4.4, "test ", null, "asd123");
        Transaction transaction2 = new Transaction(1, 1, 1, 4.4, "test ", null);
        transaction.getAmount();
        transaction.getDate();
        transaction.getIban();
        transaction.getDescription();
        transaction.getId();
        transaction.getSenderId();
        transaction.getSenderId();

        Date date = new Date(2020-12-12);
        transaction.setAmount(10.2);
        transaction.setDate(date);
        transaction.setIban("iadas");
        transaction.setDescription("ads");
        transaction.setId(1);
        transaction.setSenderId(22);
        transaction.setSenderId(32);


        transactions.add(transaction);
        int user_id = 10;

        when(transactionDalJDBC.getAllTransactionsByUser(user_id)).thenReturn(Stream.of(transaction)
                .collect(Collectors.toList()));
        Assertions.assertEquals(new ResponseEntity(transactions, HttpStatus.OK),transactionService.ReturnAllTransactionsByUser(user_id));

    }

    @Test
    public void returnAllTransactionsByUserFail(){
        int user_id =1;
        when(transactionDalJDBC.getAllTransactionsByUser(user_id)).thenReturn(null);
        Assertions.assertEquals(new ResponseEntity(HttpStatus.NOT_FOUND),transactionService.ReturnAllTransactionsByUser(user_id));

    }
}
