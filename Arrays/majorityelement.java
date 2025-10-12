/* class Solution {   // brute force basic check
    public int majorityElement(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }
            if (count > n / 2) {
                return nums[i];
            }
        }
        return -1; // This line will never be reached if the majority element exists.
    }
}
*/


/*import java.util.Arrays;

class Solution {
    public int majorityElement(int[] nums) {
        // Step 1: Sort the array
        Arrays.sort(nums);
        
        // Step 2: Return the middle element (guaranteed to be the majority)
        return nums[nums.length / 2];
    }
}
 */  
//optimized big O n log n