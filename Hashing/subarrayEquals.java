import java.util.*;
public class subarrayEquals {
    public static void main(String[] args) {
        int[] arr = {10, 2, -2, -20, 10};
        int k = -10;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Initial prefix sum

        int sum = 0;
        int ans = 0;

        for (int j = 0; j < arr.length; j++) { //0)n
            sum += arr[j];
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        System.out.println("Number of subarrays with sum " + k + " = " + ans);
    }
}

//Leetcode Solution
// import java.util.*;
// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         HashMap<Integer,Integer> map = new HashMap<>();
//         //sum,count
//            map.put(0,1); 
//            int sum = 0;
//            int ans = 0;

//          for(int j=0;j<nums.length;j++) {
//             sum += nums[j]; //sum(j)
//                if(map.containsKey(sum-k)) { //j -k
//                 ans += map.get(sum-k);
//                }
//                map.put(sum, map.getOrDefault(sum,0)+1);
//          }
//         return ans;
//     }
// }