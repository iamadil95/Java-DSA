import java.util.*;

public class majorityElement {

    public static void main(String[] args) {
        int arr[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            // if (map.containsKey(arr[i])) {
            // map.put(arr[i], map.get(arr[i]) + 1);
            // } else {
            // map.put(arr[i], 1);
            // }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

        }

        // Set<Integer> keySet = map.keySet();
        for (Integer key : map.keySet()) {
            if (map.get(key) > arr.length / 3) {
                System.out.println(key);
            }
        }
    }
}

// 1st leetcode solution for this
// import java.util.Arrays;
// class Solution {
//     public int majorityElement(int[] nums) {
//         Arrays.sort(nums);
//         return nums[nums.length/2] ;

//     }
// }


//2nd leetcode solution using hashmao
// import java.util.HashMap;

// class Solution {
//     public int majorityElement(int[] nums) {
//         HashMap<Integer, Integer> map = new HashMap<>();
//         int majorityCount = nums.length / 2;

//         for (int num : nums) {
//             map.put(num, map.getOrDefault(num, 0) + 1);

//             // Early return if majority element is found
//             if (map.get(num) > majorityCount) {
//                 return num;
//             }
//         }

//         // Problem guarantees majority element always exists
//         return -1;  // Just a fallback, won't be reached
//     }
// }
