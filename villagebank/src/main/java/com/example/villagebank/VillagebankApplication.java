package com.example.villagebank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VillagebankApplication {
    @Autowired
    BankDao bankDao1;

    @Bean
    public BankDao bankDao1(){
        return new BankDao();
    }


    public void run(String... args) throws Exception{
        Bank bank = new Bank("VILLAGEBANK");
        ACCOUNT_TYPE debit = bank.addAccount("DEBIT");
        ACCOUNT_TYPE credit = bank.addAccount("CREDIT");
        Clients client1 = debit.addClient("Ivan");
        Clients client2 = debit.addClient("Nikolay");
        Clients client3 = credit.addClient("Vasiliy");
        Clients client4 = credit.addClient("Pyotr");
        bankDao1.saveBank(bank);
        bankDao1.printBank(bank.getId());
    }

    public static void main(String[] args) {
        SpringApplication.run(VillagebankApplication.class, args);
    }

}
