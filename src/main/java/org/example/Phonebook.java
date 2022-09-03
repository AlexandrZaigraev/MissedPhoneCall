package org.example;

import java.util.HashMap;

public class Phonebook {

    private HashMap<String, Contact> contacts;
    private MissedCalls missedCalls;

    public Phonebook() {
        this.contacts = new HashMap<>();
        this.missedCalls = new MissedCalls(this.contacts);
    }

    public void addContact(Contact contact) {
        this.contacts.put(contact.getPhoneNumber() ,contact);
    }

    public void addMissedCall(String phoneNumber) {
        missedCalls.addMissedCall(phoneNumber);
    }

    public void showMissedCalls(){
        this.missedCalls.showMissedCalls();
    }

}
