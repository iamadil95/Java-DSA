import java.util.*;

public class hashMapIterate {
    public static void main(String[] args) {
        // Create
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 140);
        hm.put("China", 150);
        hm.put("Canada", 10);
        hm.put("Egypt", 15);
        hm.put("UK", 40);
       

        //Iterate  - Indirectly iterate on keys using for each
        //hm.entrySet()
        Set<String> keys = hm.keySet();
        System.out.println(keys);

        //FOR EACH LOOP
        for (String k : keys) {  //keys pe loop lagaya hai
          System.out.println("the keys="+k + "," + "value="+hm.get(k));
                
            }
        }
    }
