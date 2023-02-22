package codility.Lesson9;

public class MaxSliceSum {

    /**
     * A = [3, 2, -6, 4, 0]
     *
     * 0 ->  3, 5, -1, 3, 3
     * 1 ->  2, -4, 0, 0        // -3
     * 2 ->  -6, -2, -2         // -2
     * 3 ->  4, 4               // --6
     * 4 ->  0                  // -4
     *
     * P = 0,
     * Q = 0 : 3
     * Q = 1 : 3 + 2 = 5
     * Q = 2 : 3 + 2 - 6 = -1
     * Q = 3 : 3 + 2 - 6 + 4 = 3
     * Q = 4 : 3 + 2 - 6 + 4 + 0 = 3
     *
     * P = 1
     * Q = 1 : 2
     * Q = 2 : 2 - 6 = -4
     * Q = 3 : 2 - 6 + 4 = 0
     * Q = 4 : 2 - 6 + 4 + 0 = 0
     *
     * P = 2
     * Q = 2 : -6
     * Q = 3 : -6 + 4 = -2
     * Q = 4 : -6 + 4 + 0 = -2
     *
     * P = 3
     * Q = 3 : 4
     * Q = 4 : 4 + 0 = 4
     *
     * P = 4
     * Q = 4 : 0
     *
     */

    //Kadane’s Algorithm(카데인 알고리즘) 적용
    //시간 복잡도 : O(N)
    public int solution(int[] A) {
        int sliceSum = A[0];
        int maximumSum = A[0];

        for(int i=1; i<A.length; i++) {
            sliceSum = Math.max(A[i], sliceSum + A[i]);
            maximumSum = Math.max(sliceSum, maximumSum);
        }

        return maximumSum;
    }

    //시간 복잡도 : O(N) or O(N**3)
//    public int solution(int[] A) {
//        int maximumSum = A[0];
//
//        for (int i=0; i<A.length; i++) {
//            int sum = 0;
//
//            for (int j=i; j<A.length; j++) {
//                sum += A[j];
//
//                if (maximumSum < sum) {
//                    maximumSum = sum;
//                }
//            }
//        }
//
//        return maximumSum;
//    }

}
