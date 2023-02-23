package codility.Lesson10;

public class CountFactors {

    /**
     * ex) 10
     *
     * 1 * 10
     * 2 * 5
     * 5 * 2
     * 10 * 1
     *
     * ex) 24
     * 1 * 24
     * 2 * 12
     * 3 * 8
     * 4 * 6
     *
     * 6 * 4
     * 8 * 3
     * 12 * 2
     * 24 * 1
     *
     * ex) 100
     * 1 * 100
     * 2 * 50
     * 4 * 25
     * 5 * 20
     *
     * 10 * 10
     *
     * 20 * 5
     * 25 * 4
     * 50 * 2
     * 100 * 1
     */
    public int solution(int N) {
        int countFactors = 0;

        int sqrt = (int) Math.sqrt(N);

        for (int i=1; i<=sqrt; i++) {
            if (N % i == 0) countFactors++;
        }

        countFactors *= 2;
        if(sqrt * sqrt == N) countFactors--;

        return countFactors;
    }

}
