package ru.geekbrains.lesson4.task3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

class TicketProvider {

    private final Database database;
    private final PaymentProvider paymentProvider;

    public TicketProvider(Database database, PaymentProvider paymentProvider) {
        this.database = database;
        this.paymentProvider = paymentProvider;
    }

    public Collection<Ticket> searchTicket(int clientId, Date date) {

        Collection<Ticket> tickets = new ArrayList<>();
        for (Ticket ticket : database.getTickets()) {
            if (ticket.getCustomerId() == clientId){
                if(ticket.getDate().getDay() == date.getDay()) {
                    tickets.add(ticket);
                }
            }

        }
        return tickets;

    }

    public boolean buyTicket(int clientId, String cardNo) {

        int orderId = database.createTicketOrder(clientId);
        double amount = database.getTicketAmount();
        if (paymentProvider.buyTicket(orderId, cardNo, amount)) {
            for (Ticket ticket : database.getTickets()) {
                if (ticket.getCustomerId() == 0) {
                    ticket.setCustomerId(clientId);
                    ticket.setDate(new Date());
                    return true;
                }
            }
            System.out.println("В базе данных нет свободных билетов");
            return false;

        }
        return false;

    }

    public boolean checkTicket(String qrcode) {
        for (Ticket ticket : database.getTickets()) {
            if (ticket.getQrcode().equals(qrcode)) {
                ticket.setEnable(false);
                // Save database ...
                return true;
            }
        }
        return false;
    }
}