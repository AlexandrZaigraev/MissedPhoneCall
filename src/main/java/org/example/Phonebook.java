package org.example;

import java.util.HashMap;
import java.util.Map;

public class Phonebook {
    private Map<String, Contact> contacts = new HashMap<>(); /* в качестве ключа использовать номер телефона,
    а в качестве значения хранить контактные данные*/

    public void addContact(Contact contact) {//добавление контакта
        contacts.put(contact.getPhone(), contact);
    }

    public String showContactList() {//показать список контактов
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Contact> contact : contacts.entrySet()) {
            sb
                    .append(contact.getValue())
                    .append("\t\t")
                    .append(contact.getKey())
                    .append("\n");
        }
        return sb.toString();
    }

    public void deleteContact(String phone) {//удалить контакт из списка контактов
        if (contacts.get(phone) != null) {
            contacts.remove(phone);
        }
    }

    public Contact findContactBySurname(String surname) {//поиск контакта по фамилии
        for (Map.Entry<String, Contact> item : contacts.entrySet()) {
            if (item.getValue().getSurname().equalsIgnoreCase(surname)) {
                return item.getValue();
            }
        }
        return null;
    }

    public Contact findContactByPhone(String phone) {//поиск контакта по телефону
        return contacts.get(phone);
    }
}

