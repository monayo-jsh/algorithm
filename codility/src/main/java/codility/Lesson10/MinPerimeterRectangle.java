package codility.Lesson10;

public class MinPerimeterRectangle {

    /**
     * representing the area of some rectangle
     *
     * formula : 2 * (A+B)
     *
     * N = 30
     *
     * 1 * 30 = 2 * (1 + 30) = 62
     * 2 * 15 = 2 * (2 + 15) = 34
     * 3 * 10 = 2 * (3 + 10) = 26
     * 5 * 6 = 2 * (5 + 6) = 22
     *
     * answer = 22
     *
     */

    //약수를 구해서 삼각형의 둘레를 공식에 대입해 구한다.
    //시간 복잡도 : O(sqrt(N))
    public int solution(int N) {
        int minimalPerimeter = Integer.MAX_VALUE;

        for(int i=1; i<=Math.sqrt(N); i++) {
            if (N % i != 0) continue;

            int perimeter = 2 * (i + (N/i));

            minimalPerimeter = Math.min(minimalPerimeter, perimeter);
        }

        return minimalPerimeter;
    }

}
