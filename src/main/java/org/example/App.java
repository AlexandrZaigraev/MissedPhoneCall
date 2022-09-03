package org.example;

public class App {
    public static void main(String[] args) throws InterruptedException {

        Phonebook ph1 = new Phonebook();
        ph1.addContact(new Contact("Max", "8999123456"));
        ph1.addContact(new Contact("Alex", "8994314556"));

        ph1.addMissedCall("123");
        Thread.sleep(1000);
        ph1.addMissedCall("8994314556");

        ph1.showMissedCalls();
    }
}
