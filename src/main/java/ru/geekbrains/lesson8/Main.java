package ru.geekbrains.lesson8;

import ru.geekbrains.lesson6.notes.core.domain.Note;
import ru.geekbrains.lesson8.models.TableModel;
import ru.geekbrains.lesson8.presenters.BookingPresenter;
import ru.geekbrains.lesson8.presenters.Model;
import ru.geekbrains.lesson8.presenters.View;
import ru.geekbrains.lesson8.views.BookingView;

import java.util.Date;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    /**
     * TODO: ДОМАШНЕЕ ЗАДАНИЕ: Метод changeReservationTable ДОЛЖЕН ЗАРАБОТАТЬ!
     *
     * @param args
     */
    public static void main(String[] args) {

        View view = new BookingView();
        Model model = new TableModel();
        BookingPresenter presenter = new BookingPresenter(model, view);
        presenter.updateUIShowTables();

        boolean f = true;
        while (f) {
            System.out.println("*** СЕРВИС ПО БРОНИРОВАНИЮ СТОЛИКОВ В РЕСТОРАНЕ 'ИВА' ***");
            System.out.println("===========================================================");
            System.out.println("1. Отобразить все доступные столики");
            System.out.println("2. Забронировать столик");
            System.out.println("3. Изменить бронирование");
            System.out.println("4. Оменить бронирование");
            System.out.println("5. Показать все бронирования (для админов)");
            System.out.println("0. ЗАВЕРШЕНИЕ РАБОТЫ ПРИЛОЖЕНИЯ");
            System.out.print("Пожалуйста, выберите пункт меню: ");
            if (scanner.hasNextInt()) {
                int no = scanner.nextInt();
                scanner.nextLine();
                try {
                    switch (no) {
                        case 0 -> {
                            System.out.println("Завершение работы приложения");
                            f = false;
                        }
                        case 1 -> presenter.updateUIShowTables();
                        case 2 -> {
                            System.out.print("Укажите номер столика: ");
                            if (scanner.hasNextInt()) {
                                int tableNo = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Укажите на чье имя бронирование: ");
                                if (scanner.hasNextLine()) {
                                    String bookingName = scanner.nextLine();
                                    view.reservationTable(new Date(), tableNo, bookingName);
                                }
                            }
                        }
                        case 3 -> {
                            System.out.print("Укажите номер Вашей брони: ");
                            if (scanner.hasNextInt()) {
                                int bookingNo = scanner.nextInt();
                                System.out.print("Укажите новый номер столика: ");
                                if (scanner.hasNextInt()) {
                                    int tableNo = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.print("Укажите на чье имя новое бронирование: ");
                                    if (scanner.hasNextLine()) {
                                        String bookingName = scanner.nextLine();
                                        view.changeReservationTable(bookingNo, new Date(), tableNo, bookingName);
                                    }
                                }

                            }
                        }

                        case 4 -> {
                            System.out.print("Укажите номер бронирования: ");
                            if (scanner.hasNextInt()) {
                                int reservationNo = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Укажите на чье имя бронирование: ");
                                if (scanner.hasNextLine()) {
                                    String bookingName = scanner.nextLine();
                                    view.deleteReservationTable(reservationNo, bookingName);
                                }
                            }
                        }
                        case 5 -> {
                            presenter.onShowAllReserations();

                        }

                        default -> System.out.println("Укажите корректный пункт меню.");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Укажите корректный пункт меню.");
                scanner.nextLine();
            }
        }
    }

}
