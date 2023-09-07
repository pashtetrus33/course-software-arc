package ru.geekbrains.lesson4.task3;

import java.util.Collection;
import java.util.Date;

/**
 * Мобильное приложение
 */
class MobileApp {

    private final Customer customer;
    private final TicketProvider ticketProvider;
    private final CustomerProvider customerProvider;


    public MobileApp(TicketProvider ticketProvider, CustomerProvider customerProvider) {
        this.ticketProvider = ticketProvider;
        this.customerProvider = customerProvider;
        customer = customerProvider.getCustomer("admin", "qwerty");

    }

    public Collection<Ticket> getTickets() {
        return customer.getTickets();
    }

    public void searchTicket(Date date) {

        customer.setTickets(ticketProvider.searchTicket(customer.getId(), new Date()));
    }

    public boolean buyTicket(String cardNo) {
        if (customer == null) {
            return false;
        }

        return ticketProvider.buyTicket(customer.getId(), cardNo);
    }

}