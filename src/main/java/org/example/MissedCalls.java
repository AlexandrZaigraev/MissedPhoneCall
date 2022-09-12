package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

public class MissedCalls {
    private Map<LocalDateTime, String> missedCalls = new TreeMap<>(); /*ключ — время пропущенного вызова,
    значение — номер телефона*/

    public void addMissedCall(String phone) {//добавить пропущенный
        missedCalls.put(LocalDateTime.now(), phone);
    }

    public String showAllMissedCalls(Phonebook contactsBook) { // показать все пропущенные вызовы
        StringBuilder sb = new StringBuilder();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");//преобразуем дату в другой формат
        for (Map.Entry<LocalDateTime, String> entry : missedCalls.entrySet()) {
            Contact contactInBook = contactsBook.findContactByPhone(entry.getValue());
            sb
                    .append(dtf.format(entry.getKey()))
                    .append("\t\t")
                    .append((contactInBook == null) ? entry.getValue() : contactInBook)//вывести контакт
                    .append("\n");
        }
        return sb.toString();
    }

    public void deleteAllMissedCalls() {//удаление списка пропущенных
        missedCalls.clear();
    }
}

