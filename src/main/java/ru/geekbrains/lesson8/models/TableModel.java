package ru.geekbrains.lesson8.models;

import ru.geekbrains.lesson8.presenters.Model;

import java.util.*;

public class TableModel implements Model {


    private List<Table> tables;

    /**
     * Получение списка всех столиков
     */
    public List<Table> loadTables() {

        if (tables == null) {
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }

        return tables;
    }

    /**
     * Бронирование столика
     *
     * @param reservationDate Дата бронирования
     * @param tableNo         Номер столика
     * @param name            Имя
     */
    @Override
    public int reservationTable(Date reservationDate, int tableNo, String name) {
        for (Table table : tables) {
            if (table.getNo() == tableNo) {
                List<Reservation> tabelReservationList = table.getReservations();
                if (tabelReservationList.size() > 0) {
                    for (Reservation reservation : tabelReservationList) {
                        if (isTableBusy(reservation, reservationDate)) {
                            return -2;
                        }
                    }
                }
                Reservation reservation = new Reservation(table, reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        throw new RuntimeException("Ошибка бронирования столика. Повторите попытку позже.");
    }

    private boolean isTableBusy(Reservation reservation, Date reservationDate) {
        return reservation.getDate().getHours() - reservationDate.getHours() <= 3;
    }

    /**
     * TODO: Доработать самостоятельнов рамках домашней работы
     *
     * @param oldReservation     номер старой брони
     * @param newReservationDate новая дата бронирования
     * @param newTableNo         новый номер столика
     * @param newName            новое имя бронирования
     * @return номер новой брони
     */
    @Override
    public int changeReservationTable(int oldReservation, Date newReservationDate, int newTableNo, String newName) {

        List<Reservation> allReservation = getAllReservations();

        if (allReservation != null) {
            Optional<Reservation> reservation = allReservation.stream().filter(p -> p.getId() == oldReservation).findFirst();
            if (reservation.isPresent()) {
                if (isTableBusy(reservation.get(), newReservationDate)) {
                    return -2;
                }

                reservation.get().getTable().getReservations().remove(reservation.get());
                Reservation newReservation = new Reservation(tables.get(newTableNo - 1), newReservationDate, newName);
                newReservation.getTable().getReservations().add(newReservation);
                return newReservation.getId();
            }
        }
        return -3;

    }

    @Override
    public int deleteReservationTable(int reservationId, String name) {

        List<Reservation> allReservation = getAllReservations();

        if (allReservation != null) {
            Optional<Reservation> reservation = allReservation.stream().filter(p -> p.getId() == reservationId).findFirst();
            if (reservation.isPresent()) {
                if (reservation.get().getName().equals(name)) {
                    reservation.get().getTable().getReservations().remove(reservation.get());
                    return -4;
                } else {
                    return -5;
                }
            }
        }
        return -3;

    }

    @Override
    public List<Reservation> getAllReservations() {
        List<Reservation> allReservation = new ArrayList<>();
        if (tables != null) {

            for (Table table : tables) {
                allReservation.addAll(table.getReservations());
            }
            return allReservation;
        } else
            return null;
    }
}
