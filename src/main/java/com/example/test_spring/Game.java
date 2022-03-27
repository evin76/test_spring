package com.example.test_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//field injection
@Component
public class Game {
    @Autowired
    private Account account;

    public Game(Account account){
        this.account = account;
    }

    public String startGame(){
        return account.createAccount();
    }
}
