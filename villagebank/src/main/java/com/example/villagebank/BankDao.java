package com.example.villagebank;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Repository
public class BankDao {

    @PersistenceUnit
    EntityManagerFactory emf;

    public void addBank(String name){
        EntityManager em = emf.createEntityManager();
        Bank bank = new Bank(name);
        em.getTransaction().begin();
        em.persist(bank);
        em.getTransaction().commit();
        em.close();
    }

    public void saveBank(Bank bank){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(bank);
        em.getTransaction().commit();
        em.close();
    }

    public Bank getBank(int id){
        EntityManager em = emf.createEntityManager();
        Bank bank = em.find(Bank.class, id);
        em.close();
        return bank;
    }

    public void printBank(int id){
        EntityManager em = emf.createEntityManager();
        Bank bank = em.find(Bank.class, id);
        System.out.println(bank);
        em.close();
    }
}
