package F3_Arrays.F2_Medium;

public class P6_StockBuy {

    public static int maxProfit(int[] prices) {

        int min = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];

            if (price < min)
                min = price;
            else {
                int diff = price - min;
                if (diff > profit) {
                    profit = diff;
                }
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices={7,1,4,6,5,3};
        System.out.println(maxProfit(prices));
    }
}
