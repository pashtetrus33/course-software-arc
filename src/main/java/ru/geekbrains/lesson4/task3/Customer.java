package ru.geekbrains.lesson4.task3;

import java.util.Collection;

/**
 * Покупатель
 */
public class Customer{
    public Customer(String login, String password) {
        this.login = login;
        this.password = password;
    }


    private static int counter;

    private final int id;

    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    private Collection<Ticket> tickets;

    {
        id = ++counter;
    }

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }

    public int getId() {
        return id;
    }

}