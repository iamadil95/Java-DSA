import java.util.*;

public class hashMapOperations {

    public static void main(String[] args) {
        // Create
        HashMap<String, Integer> hm = new HashMap<>();

        // Insert - O(1)
        // put - add
        hm.put("India", 140);
        hm.put("China", 150);
        hm.put("Canada", 10);

        System.out.println(hm); // Unordered Map - Undefined random

        // Get - O(1)
        int population = hm.get("India");
        System.out.println(population);

        // ContainsKey - O(1) Checks Exists or not
        System.out.println(hm.containsKey("India")); // True
        System.out.println(hm.containsKey("Indianapolis")); // False

        //Remove - O(1)
        System.out.println(hm.remove("China"));
        System.out.println(hm);

        //Size
        System.out.println(hm.size());

        //isEmpty
        System.out.println(hm.isEmpty());

        // clear func
        hm.clear();
        System.out.println(hm.isEmpty());
    }
}