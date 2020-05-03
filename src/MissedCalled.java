import java.util.TreeMap;
import java.util.Map;
import java.time.*;

public class MissedCalled {
    Map<LocalDateTime, String> missedCalls = new TreeMap<>();

    public void addMissedCalled(String missedCall) {
        LocalDateTime localDateTime;
        localDateTime = LocalDateTime.now();
        missedCalls.put(localDateTime, missedCall);
    }

    public void getAllMissedCalled(Contacts contacts) {
        for (LocalDateTime keyMissedCalls : missedCalls.keySet()) {
            if (contacts.findContacts(missedCalls.get(keyMissedCalls))) {
                //empty
            } else {
                System.out.println("Time: " + keyMissedCalls + " телефон: " + missedCalls.get(keyMissedCalls));
            }
        }
    }

    public void clearAllMissedCalled() {
        missedCalls.clear();
    }
}