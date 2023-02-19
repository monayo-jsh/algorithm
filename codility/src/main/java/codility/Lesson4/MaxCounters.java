package codility.Lesson4;

import java.util.Arrays;

public class MaxCounters {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{3, 4, 4, 6, 1, 4, 4})));
        System.out.println(Arrays.toString(solution(5, new int[]{3, 4, 4, 6, 1, 4, 6, 4})));
    }

    public static int[] solution(int N, int[] A) {
        int[] result = new int[N];

        int maxCounter = 0, max = 0;
        for(int num : A) {

            if(num > N) {
                maxCounter = max;
                continue;
            }

            int targetIndex = num - 1;

            if(result[targetIndex] < maxCounter) {
                result[targetIndex] = maxCounter;
            }

            result[targetIndex]++;

            max = Math.max(max, result[targetIndex]);
        }

        for(int i=0; i<result.length; i++) {
            if(result[i] < maxCounter) {
                result[i] = maxCounter;
            }
        }

        return result;
    }

    //Timeout
//    public static int[] solution(int N, int[] A) {
//        int[] result = new int[N];
//
//        int maxCounter = N+1;
//        int sum = 0;
//        int max = 0;
//        for(int num : A) {
//            if(num == maxCounter) {
//                Arrays.fill(result, max);
//                continue;
//            }
//
//            int targetIndex = num - 1;
//            result[targetIndex]++;
//
//            max = Math.max(max, result[targetIndex]);
//        }
//
//        return result;
//    }
}
