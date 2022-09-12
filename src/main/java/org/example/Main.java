package org.example;

import java.util.Scanner;

public class Main {
    /*Совсем недавно мы с вами создавали программу для хранения номеров телефонов.
    Следующая программа будет будет немного схожа по тематике.
    Нужно написать программу для хранения пропущенных звонков, используя уже изученные коллекции,
    в том числе коллекцию TreeMap. Программа должна хранить список пропущенных вызовов
    в формате: дата и время звонка и, конечно, имя контакта.*/
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MissedCalls missedCall = new MissedCalls();
        Phonebook contactsBook = new Phonebook();

        fillContacts(contactsBook);//добавляем контактов для демонстрации

        System.out.println("Программа: пропущенные вызовы.");
        System.out.println("Меню:\n" +
                "1. Добавить контакт\n" +
                "2. Добавить пропущенный вызов\n" +
                "3. Вывести все пропущенные вызовы\n" +
                "4. Очистить пропущенные вызовы\n" +
                "5. Удалить контакт\n" +
                "6. Показать все контакты\n" +
                "7. Найти контакт\n" +
                "8. Выход\n");
        while (true) {
            System.out.println("Выберите пункт из меню (1-7):");
            String selectedMenu = scanner.nextLine();
            switch (selectedMenu) {//меню
                case "1"://добавить контакт
                    System.out.println("Добавить контакт");
                    boolean groupExists = false; //для проверки пользовательского ввода и enum
                    while (true) {
                        System.out.println("Введите через запятую: фамилия, имя, номер, группа. " +
                                "(Введите end/нет или пустую строку для отмены)");
                        String inputNewContactData = scanner.nextLine();
                        String[] newContactDataList = inputNewContactData.split(", ", 4);
                        if (newContactDataList.length == 0
                                || "end".equalsIgnoreCase(newContactDataList[0])
                                || "нет".equalsIgnoreCase(newContactDataList[0])) {
                            break;
                        } else if (newContactDataList.length != 4) {
                            System.out.println("Нужно ввести 4 атрибута: ");
                        } else {
                            for (Enum group : Group.values()) { //сравниваю ввод пользователя и заданные enum'ы
                                if (newContactDataList[3].equalsIgnoreCase(group.name())) {
                                    groupExists = true;
                                    break;
                                }
                            }
                            if (!groupExists) { //если на выходе не обнаружился подходящий enum - кричим об ошибке
                                System.err.println("Не могу найти группу " + newContactDataList[3]);
                            } else {
                                Contact newContact = new Contact(
                                        newContactDataList[0],//фамилия
                                        newContactDataList[1],//имя
                                        newContactDataList[2],//номер
                                        Group.valueOf(newContactDataList[3]));//группа
                                contactsBook.addContact(newContact);
                            }
                        }
                    }
                    break;
                case "2":
                    System.out.println("Добавить пропущенный вызов? " +
                            "(введите номер или введите end/нет или пустую строку для отмены)");
                    while (true) {
                        String newMissedCall = scanner.nextLine();
                        if ("end".equalsIgnoreCase(newMissedCall)
                                || "нет".equalsIgnoreCase(newMissedCall)
                                || "".equalsIgnoreCase(newMissedCall)) {
                            break;
                        } else {
                            //добавляем в дерево
                            missedCall.addMissedCall(newMissedCall);//добавить пропущенный
                        }
                    }
                    break;
                case "3":
                    System.out.println(missedCall.showAllMissedCalls(contactsBook));//показать все пропущенные
                    break;
                case "4"://удалить все пропущенные
                    System.out.println("Удалить все пропущенные вызовы? (да для выбора, end/пустая строка для выхода)");
                    String acceptToClear = scanner.nextLine();
                    if ("end".equalsIgnoreCase(acceptToClear)
                            || "".equalsIgnoreCase(acceptToClear)
                            || "нет".equalsIgnoreCase(acceptToClear)) {
                        break;
                    } else if ("да".equalsIgnoreCase(acceptToClear)) {
                        missedCall.deleteAllMissedCalls();
                        System.out.println("Список пропущенных вызовов очищен");
                        break;
                    }
                case "5"://удалить контакт из списка контактов
                    contactsBook.showContactList();
                    System.out.println("Вы хотите удалить контакт из списка? " +
                            "(введите номер телефона для удаления. введите нет/end для выхода)");
                    String inputPhone = scanner.nextLine();
                    if (!"end".equalsIgnoreCase(inputPhone)
                            && !"нет".equalsIgnoreCase(inputPhone)
                            && !"".equalsIgnoreCase(inputPhone)) {
                        contactsBook.deleteContact(inputPhone);
                    }
                    break;
                case "6"://показать список контактов
                    System.out.println("Список контактов:");
                    System.out.println(contactsBook.showContactList());
                    break;
                case "7"://найти контакт
                    System.out.println("Найти контакт по фамилии? (ведите нет/end для выхода)");
                    String inputSurname = scanner.nextLine();
                    if (!"end".equalsIgnoreCase(inputSurname)
                            && !"нет".equalsIgnoreCase(inputSurname)
                            && !"".equalsIgnoreCase(inputSurname)) {
                        System.out.println(contactsBook.findContactBySurname(inputSurname).getSurname()
                                + " " + contactsBook.findContactBySurname(inputSurname).getName()
                                + " " + contactsBook.findContactBySurname(inputSurname).getPhone());
                    }
                    break;
                case "8":
                    exitFromProgram();//выход
                    break;
                default:
                    System.out.println("Выберите пункт меню (1-7)");
                    break;
            }
        }
    }

    public static void fillContacts(Phonebook contacts) {//используется для демонстрации
        contacts.addContact(new Contact("Маланин", "Артур", "1234567890", Group.WORK));
        contacts.addContact(new Contact("Галеса", "Евгений", "1234", Group.WORK));
        contacts.addContact(new Contact("Лоскутникова", "Анастасия", "111", Group.WORK));
        contacts.addContact(new Contact("Громак", "Максим", "111222", Group.FRIENDS));
    }

    static void exitFromProgram() {
        System.out.println("Завершить работу программы? (да/нет для выбора)");
        while (true) {
            String confirmExit = scanner.nextLine();
            switch (confirmExit) {
                case "да":
                    System.out.println("Завершение...");
                    System.exit(0);
                    break;
                case "нет":
                    break;
                default:
                    System.out.println("Введите да/нет");
            }
        }
    }
}
