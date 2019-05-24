package com.example.villagebank;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @OneToMany(mappedBy = "bank",
            cascade = CascadeType.PERSIST)
    private List<ACCOUNT_TYPE> account_types = new ArrayList<>();

    public Bank(String name){
        this.name = name;
    }

    public ACCOUNT_TYPE addAccount(String name){
        ACCOUNT_TYPE account_type = new ACCOUNT_TYPE(name);
        account_types.add(account_type);
        account_type.setBank(this);
        return account_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ACCOUNT_TYPE> getAccount_types() {
        return account_types;
    }

    public void setAccount_types(List<ACCOUNT_TYPE> account_type) {
        this.account_types = account_type;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n Bank name: ");
        stringBuilder.append(name);
        if (account_types != null){
            account_types.forEach(stringBuilder::append);
        }
        return stringBuilder.toString();
    }
}
