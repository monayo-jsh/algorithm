package codility.Lesson9;

public class MaxProfit {

    public int solution(int[] A) {
        int maxProfit = 0;

        int minPrice = A[0];
        for(int dailyPrice : A) {
            if (dailyPrice < minPrice) {
                minPrice = dailyPrice;
            }

            int profit = dailyPrice - minPrice;
            if (maxProfit < profit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }

    /**
     * 시간 복잡도 : O(N**2)
     * 결과 : TIMEOUT ERROR
    public int solution(int[] A) {
        int maxProfit = 0;

        for(int i=0; i<A.length; i++) {
            int price = A[i];

            for(int j=i+1; j<A.length; j++) {
                if(maxProfit < A[j] - price) {
                    maxProfit = A[j] - price;
                }
            }
        }

        return maxProfit;
    }
     */

}
