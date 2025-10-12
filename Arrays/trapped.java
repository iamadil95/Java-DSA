
class trapped {
    public static int rainwater(int height[]) {  // tc - O (n)
        //calculate left max boundary -array

        int left[] = new int[height.length];
        int[] right = new int[height.length];
        left[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(height[i], left[i - 1]);
        }
        //calculate right max boundary - array
        right[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = Math.max(height[i], right[i + 1]);
        }
        int trappedWater = 0;
        //loop
        for (int i = 0; i < height.length; i++) {
            int WaterLevel = Math.min(left[i], right[i]); //waterlevel = min(leftmax bound,rightmax bound)
            trappedWater = trappedWater + (WaterLevel - height[i]);  //trapped water = water level -height [i]
        }
        return trappedWater;
    }

public static void main(String args[])
{
    int height[] = { 4, 2, 0, 6, 3, 2, 5 };
    
    System.out.println(rainwater(height));
}  
}
