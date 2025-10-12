public class stocks {
    public static int buyAndSellSocks(int prices[]) {
        int bp = Integer.MAX_VALUE; // Initialize with the highest possible value to find the lowest buy price during iteration
        int maxProft = 0;

        for (int i = 0; i < prices.length; i++) {
            //case 1
            if (bp < prices[i]) {
                int profit = prices[i] - bp; // todays profit
                maxProft = Math.max(maxProft, profit); //checking the highest profit is todays or already assigned value in maxproft

                // profit
            } else {

                bp = prices[i];
            }
        }
        return maxProft;
    }
    public static void main(String[] args) {
        int prices[] = { 7, 9, 5, 3, 6, 1, 4 };
        System.out.println(buyAndSellSocks(prices));
    }
}