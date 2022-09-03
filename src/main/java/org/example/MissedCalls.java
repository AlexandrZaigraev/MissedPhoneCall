package org.example;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class MissedCalls {
    private HashMap<String, Contact> contacts;
    private TreeMap<LocalDateTime, String> missedCalls;

    public MissedCalls(HashMap<String, Contact> contacts) {
        this.missedCalls = new TreeMap<>();
        this.contacts = contacts;
    }

    public void addMissedCall(String phoneNumber) {
        missedCalls.put(LocalDateTime.now(), phoneNumber);
    }

    public void showMissedCalls() {
        for (Map.Entry<LocalDateTime, String> entry : missedCalls.entrySet()) { // итерация по парам ключ/значение пропущенные вызовы
            LocalDateTime time = entry.getKey();
            String missedPhone = entry.getValue();

            // Stream API
//            Optional<Map.Entry<String, Contact>> optional = this.contacts.entrySet().stream()
//                    .filter((item) -> item.getValue().getPhoneNumber().equals(missedPhone))
//                    .findFirst();
//            if (optional.isEmpty()) {
//                System.out.println(time + " : " + missedPhone + " : неизвестный");
//            } else {
//                System.out.println(time + " : " + missedPhone + " : " + optional.get().getValue().getName());
//            }


            String result = null;
            for (Map.Entry<String, Contact> stringContactEntry : this.contacts.entrySet()) {
                if (stringContactEntry.getValue().getPhoneNumber().equals(missedPhone)) {
                    result = time + " : " + missedPhone + " : " + stringContactEntry.getValue().getName();
                    break;
                } else {
                    result = time + " : " + missedPhone + " : неизвестный";
                }
            }
            System.out.println(result);

        }


    }
}

