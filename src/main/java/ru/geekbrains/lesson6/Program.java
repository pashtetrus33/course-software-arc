package ru.geekbrains.lesson6;


import ru.geekbrains.lesson6.database.NotesDatabase;
import ru.geekbrains.lesson6.notes.core.application.ConcreteNoteEditor;
import ru.geekbrains.lesson6.notes.core.domain.Note;
import ru.geekbrains.lesson6.notes.infrastructure.persistance.NotesDbContext;
import ru.geekbrains.lesson6.notes.presentation.queries.controllers.NotesController;
import ru.geekbrains.lesson6.notes.presentation.queries.views.NotesConsolePresenter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class Program {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        NotesController controller = new NotesController(
                new ConcreteNoteEditor(new NotesDbContext(new NotesDatabase()), new NotesConsolePresenter()));

        boolean f = true;
        while (f) {
            System.out.println("*** РЕДАКТОР ЗАМЕТОК ***");
            System.out.println("=======================");
            System.out.println("1. Отобразить все заметки");
            System.out.println("2. Добавить заметку");
            System.out.println("3. Удалить заметку");
            System.out.println("4. Редактировать заметку");
            System.out.println("0. ЗАВЕРШЕНИЕ РАБОТЫ ПРИЛОЖЕНИЯ");
            System.out.print("Пожалуйста, выберите пункт меню: ");
            if (scanner.hasNextInt()) {
                int no = scanner.nextInt();
                scanner.nextLine();
                try {
                    switch (no) {
                        case 0:
                            System.out.println("Завершение работы приложения");
                            f = false;
                            break;
                        case 1:
                            controller.routeGetAll();
                            break;
                        case 2:
                            System.out.print("Укажите заголовок заметки: ");
                            if (scanner.hasNextLine()) {
                                String noteTitle = scanner.nextLine();
                                System.out.print("Укажите описание заметки: ");
                                if (scanner.hasNextLine()) {
                                    String noteDetails = scanner.nextLine();
                                    controller.routeAddNote(new Note(noteTitle, noteDetails, new Date()));
                                    System.out.println("Заметка успешно добавлена");
                                }
                            }

                            break;
                        case 3:
                            System.out.print("Укажите номер заметки: ");
                            if (scanner.hasNextInt()) {
                                int noteId = scanner.nextInt();
                                if (controller.routeRemoveNote(noteId))
                                    System.out.println("Заметка успешно удалена.");
                                else
                                    System.out.println("Удаление заметки не произведено!");
                            } else {
                                System.out.println("Номер заметки указан некорректно.");
                            }
                            break;

                        case 4:
                            System.out.print("Укажите номер заметки для редактирования: ");
                            if (scanner.hasNextInt()) {
                                int noteId = scanner.nextInt();
                                System.out.print("Укажите отредактированный заголовок заметки: ");
                                scanner.nextLine();
                                if (scanner.hasNextLine()) {
                                    String noteTitle = scanner.nextLine();
                                    System.out.print("Укажите отредактированное описание заметки: ");
                                    if (scanner.hasNextLine()) {
                                        String noteDetails = scanner.nextLine();
                                        controller.routeEditNote(new Note(noteId, noteTitle, noteDetails, new Date()));
                                        System.out.println("Заметка успешно отредактирована.");
                                    }
                                } else
                                    System.out.println("Редактирование заметки не произведено!");
                            } else {
                                System.out.println("Номер заметки указан некорректно.");
                            }
                            break;

                        default:
                            System.out.println("Укажите корректный пункт меню.");
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
