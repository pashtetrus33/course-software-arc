package ru.geekbrains.lesson8.views;

import ru.geekbrains.lesson8.models.Reservation;
import ru.geekbrains.lesson8.models.Table;
import ru.geekbrains.lesson8.presenters.View;
import ru.geekbrains.lesson8.presenters.ViewObserver;

import java.util.Date;
import java.util.List;

public class BookingView implements View {


    private ViewObserver observer;

    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    @Override
    public void showTables(List<Table> tables) {
        for (Table table : tables) {
            System.out.println(table);
        }
    }

    public void showReservations(List<Reservation> reservations) {
        if (reservations.size() == 0){
            System.out.println("===========================================================");
            System.out.println("Все столики свободны.");
            System.out.println("===========================================================");
        }

        else {
            System.out.println("===========================================================");
            for (Reservation reservation : reservations) {
                System.out.println(reservation);
            }
            System.out.println("===========================================================");
        }
    }


    @Override
    public void showReservationTableResult(int reservationNo, String name) {
        switch (reservationNo) {
            case -1 -> {
                System.out.println(name + ", что-то пошло не так, попробуйте повторить попытку позже.");
            }

            case -2 -> {
                System.out.println(name + ", столик занят.");
            }


            case -3 -> {
                System.out.println(name + ", номер бронирования не найден.");
            }
            case -4 -> {
                System.out.println(name + ", бронирование успешно отменено.");
            }
            case -5 -> {
                System.out.println(name + ", неверно указано имя бронирования.");
            }

            default ->
                    System.out.printf(name + ", столик успешно забронирован. Номер вашей брони: #%d\n", reservationNo);
        }
    }

    /**
     * Действие клиента (пользователь нажал на кнопку бронирования), бронирование столика
     *
     * @param orderDate дата бронирования
     * @param tableNo   номер столика
     * @param name      Имя
     */
    public void reservationTable(Date orderDate, int tableNo, String name) {
        if (observer != null)
            observer.onReservationTable(orderDate, tableNo, name);
    }

    /**
     * TODO: Доработать самостоятельнов рамках домашней работы
     * Действие клиента (пользователь нажал на кнопку изменения резерва)
     *
     * @param oldReservation идентификатор бронирования (старый)
     * @param newOrderDate   дата бронирования
     * @param newTableNo     номер столика
     * @param newName        Имя
     */
    public void changeReservationTable(int oldReservation, Date newOrderDate, int newTableNo, String newName) {
        if (observer != null)
            observer.onChangeReservationTable(oldReservation, newOrderDate, newTableNo, newName);
    }

    @Override
    public void deleteReservationTable(int reservationNo, String bookingName) {
        if (observer != null)
            observer.onDeleteReservationTable(reservationNo, bookingName);
    }
}
