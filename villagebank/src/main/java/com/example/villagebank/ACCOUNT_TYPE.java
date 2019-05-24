package com.example.villagebank;

import ch.qos.logback.core.net.server.Client;
import org.apache.coyote.http11.filters.SavedRequestInputFilter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ACCOUNT_TYPE {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    public ACCOUNT_TYPE(String name){
        this.name = name;
    }

    @ManyToOne
    private Bank bank;

    @OneToMany(mappedBy = "account_type",
        cascade = CascadeType.ALL)
    private List<Clients> clients = new ArrayList<>();

    public Clients addClient(String name){
        Clients client = new Clients(name);
        clients.add(client);
        client.setAccount_type(this);
        return client;
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

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public List<Clients> getClients() {
        return clients;
    }

    public void setClients(List<Clients> clients) {
        this.clients = clients;
    }
}
