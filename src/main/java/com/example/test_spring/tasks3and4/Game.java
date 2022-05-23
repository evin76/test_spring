package com.example.test_spring.tasks3and4;

import com.example.test_spring.tasks3and4.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
@ConfigurationProperties("prod")
public class Game {

    @Value("${prod.address}")
    private String address;

    @Autowired
    private Account account;

    public Game(Account account){
        this.account = account;
    }

    public String startGame(){
        return account.createAccount();
    }
}
