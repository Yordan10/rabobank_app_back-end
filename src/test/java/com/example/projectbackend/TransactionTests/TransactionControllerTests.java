package com.example.projectbackend.TransactionTests;

import com.example.projectbackend.Controller.TransactionController;
import com.example.projectbackend.Model.Transaction;
import com.example.projectbackend.Model.UserAccount;
import com.example.projectbackend.Repository.TransactionDalJDBC;
import com.example.projectbackend.Service.TransactionService;
import com.example.projectbackend.ServiceInterfaces.IAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class TransactionControllerTests {

    @Autowired
    TransactionService transactionService;

    @MockBean
    TransactionDalJDBC transactionDalJDBC;

    @MockBean
    TransactionController transactionController;

    @Test
    public void contextLoads() throws Exception {
        Assertions.assertNotNull(transactionController);
    }


//    @Test
//    //@WithMockUser(username="user", roles={"USER"})
//    public void GetSentTransactions(){
//        List<Transaction> transactions = new ArrayList<>();
//        //Transaction transaction = new Transaction();
//        Transaction transaction = new Transaction();
//        transaction.setAmount(5.5);
//        transaction.setDescription("test");
//        transaction.setId(1);
//        transaction.setDate(null);
//        transaction.setReceiverId(2);
//        transaction.setSenderId(3);
//        transaction.setIban("asd123");
//        transactions.add(transaction);
//
//        int user_id=3;
//
//        //Transaction transaction = new Transaction(1, 1, 1, 4.4, "test ", null, "asd123");
//        when(transactionDalJDBC.getAllSentTransactions(user_id)).thenReturn(Stream.of(transaction).collect(Collectors.toList()));
//        Assertions.assertEquals(new ResponseEntity(transactions, HttpStatus.OK),transactionController.GetSentTransactions());
//    }

//    @Test
//    public void GetSentTransactionsFail(){
//        List<Transaction> transactions = new ArrayList<>();
//
//        Transaction transaction = new Transaction();
//        transaction.setAmount(5.5);
//        transaction.setDescription("test");
//        transaction.setId(1);
//        transaction.setDate(null);
//        transaction.setReceiverId(2);
//        transaction.setSenderId(3);
//        transaction.setIban("asd123");
//        transactions.add(transaction);
//        int user_id=3;
//
//        when(transactionService.ReturnAllSentTransactions(user_id)).thenReturn(Stream.of(transaction).collect(Collectors.toList()));
//        Assertions.assertEquals(new ResponseEntity(transactions, HttpStatus.NOT_FOUND),transactionController.GetSentTransactions());
//    }
//    @Test
//    public void GetReceivedTransactions(){
//
//    }
//    @Test
//    public void GetAllTransactionsByUser(){
//
//    }
//    @Test
//    public void GetRecentTransactionsByUser(){
//
//    }
//    @Test
//    public void SendTransaction(){
//
//    }
}
