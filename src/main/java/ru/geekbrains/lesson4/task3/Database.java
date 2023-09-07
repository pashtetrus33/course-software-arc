package ru.geekbrains.lesson4.task3;

import java.util.ArrayList;
import java.util.Collection;

/**
 * База данных
 */
public class Database{

    private static int counter;
    private Collection<Ticket> tickets = new ArrayList<>();
    private Collection<Customer> customers = new ArrayList<>();

    public void setTickets(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Database() {
        tickets.add(new Ticket("grCode1"));
        tickets.add(new Ticket("grCode2"));
        tickets.add(new Ticket("grCode3"));


        customers.add(new Customer("user", "password"));
        customers.add(new Customer("admin", "qwerty"));
        customers.add(new Customer("ivan", "12345"));
    }

    public Collection<Ticket> getTickets() {

        return tickets;
    }

    public Collection<Customer> getCustomers() {
        return customers;
    }

    /**
     * Получить актуальную стоимость билета
     * @return
     */
    public double getTicketAmount(){
        return 45;
    }

    /**
     * Получить идентификатор заявки на покупку билета
     * @return
     */
    public int createTicketOrder(int clientId){
        return ++counter;
    }

}