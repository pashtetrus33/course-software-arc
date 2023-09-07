package ru.geekbrains.lesson4.task3;

import java.util.Date;

/**
 * Билет
 */
class Ticket {

    private int id;
    private static int counter;

    private int customerId;

    private Date date;

    private String qrcode;

    private boolean enable = true;

    {
        id = ++counter;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Ticket(String qrcode) {
        this.qrcode = qrcode;
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getDate() {
        return date;
    }

    public String getQrcode() {
        return qrcode;
    }

    public boolean isEnable() {
        return enable;
    }
}
