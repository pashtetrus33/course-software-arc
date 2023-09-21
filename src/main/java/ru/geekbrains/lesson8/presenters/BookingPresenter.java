package ru.geekbrains.lesson8.presenters;

import ru.geekbrains.lesson8.models.Reservation;
import ru.geekbrains.lesson8.models.Table;

import java.util.Date;
import java.util.List;

public class BookingPresenter implements ViewObserver {

    private final Model model;
    private final View view;

    public BookingPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.setObserver(this);
    }

    /**
     * Получение списка всех столиков
     */
    public List<Table> loadTables() {
        return model.loadTables();
    }

    public List<Reservation> getAllReservations() {
        return model.getAllReservations();
    }

    /**
     * Отобразить список столиков (на представлении)
     */
    public void updateUIShowTables() {
        view.showTables(loadTables());
    }

    public void updateUIShowReservationTableResult(int reservationNo, String name) {
        view.showReservationTableResult(reservationNo, name);
    }

    /**
     * Произошло событие, пользователь нажал на кнопку резерва столика
     *
     * @param orderDate дата резерва
     * @param tableNo   номер столика
     * @param name      имя клиента
     */
    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        try {
            int reservationNo = model.reservationTable(orderDate, tableNo, name);
            updateUIShowReservationTableResult(reservationNo, name);

        } catch (RuntimeException e) {
            updateUIShowReservationTableResult(-1, name);
        }
    }

    @Override
    public void onChangeReservationTable(int oldReservation, Date newOrderDate, int newTableNo, String newName) {
        try {
            int reservationNo = model.changeReservationTable(oldReservation, newOrderDate, newTableNo, newName);
            updateUIShowReservationTableResult(reservationNo, newName);

        } catch (RuntimeException e) {
            updateUIShowReservationTableResult(-1, newName);
        }
    }

    @Override
    public void onShowAllReserations() {

        view.showReservations(model.getAllReservations());
    }

    @Override
    public void onDeleteReservationTable(int reservationNo, String bookingName) {
        int reservation = model.deleteReservationTable(reservationNo, bookingName);
        updateUIShowReservationTableResult(reservation, bookingName);
    }
}
