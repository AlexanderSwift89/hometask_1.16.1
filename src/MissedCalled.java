import java.util.TreeMap;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.time.LocalDateTime;
import java.util.*;

public class MissedCalled {
    Map<LocalDateTime, String> missedCalls = new TreeMap<>();
    Map<LocalDateTime, Contact> existContacts = new HashMap<>();

    public void addMissedCalled(String missedCall, Contacts contacts) {
        Contact contact = new Contact();
        LocalDateTime time = LocalDateTime.now();
        Iterator<String> iter = contacts.getKeyContacts().iterator();
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        while (iter.hasNext()) {
            String nameIt = iter.next();
            contact = contacts.getValueContacts(nameIt);
            if (missedCall.equals(contact.getPhone())) {
                existContacts.put(time, contact);
                check = false;
            }
        }
        if (check == true) {
            missedCalls.put(time, missedCall);
        }
    }

    public void getAllMissedCalled() {
        for (LocalDateTime keyMissedCalls : missedCalls.keySet()) {
            System.out.println("Time: " + keyMissedCalls + " телефон: " + missedCalls.get(keyMissedCalls));
        }
        for (LocalDateTime keyMissedCalls : existContacts.keySet()) {
            Contact missedContact = new Contact();
            missedContact = existContacts.get(keyMissedCalls);
            System.out.println("Время: " + keyMissedCalls + " телефон: " + missedContact.getPhone() + " " + missedContact.getName() + " " + missedContact.getSurname());
        }
    }

    public void clearAllMissedCalled() {
        missedCalls.clear();
        existContacts.clear();
    }
}