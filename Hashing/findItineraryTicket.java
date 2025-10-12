import java.util.*;

public class findItineraryTicket {

    public static String getStart(HashMap<String, String> tickets) {
        HashMap<String, String> revMap = new HashMap<>();

        for (String key : tickets.keySet()) {
            revMap.put(tickets.get(key), key); // Flip ticket direction: store arrival as key, departure as value for reverse 
        }
        for (String key : tickets.keySet()) {
            if (!revMap.containsKey(key)) {
                return key; // starting point
            }
        }
        return null; //assume to remove errors
    }

    public static void main(String[] args) { // 0(n)
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Benglore");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String start = getStart(tickets);
        System.out.print(start);

        for (String key : tickets.keySet()) {
            System.out.print(" ->" + tickets.get(start));
            start = tickets.get(start);
        }
        System.out.println();
    }
}
