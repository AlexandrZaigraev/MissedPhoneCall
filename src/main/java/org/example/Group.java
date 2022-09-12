package org.example;

public enum Group {
    WORK("Работа"),
    FRIENDS("Друзья"),
    FAMILY("Семья");

    String name;

    Group(String name) {
        this.name = name;
    }

}