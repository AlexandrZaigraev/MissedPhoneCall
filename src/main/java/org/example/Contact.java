package org.example;

import java.util.Objects;

public class Contact {

    private final String name;
    private final String surname;
    private final String phone;
    private final Enum group;

    public Contact(String surname, String name, String phone, Enum group) {
        this.surname = surname;
        this.name = name;
        this.phone = phone;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public Enum getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "Имя: " + name + " " + surname + " " + this.getGroup();
    }
}
