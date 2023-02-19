package codility.Lesson3;

public class TapeEquilibrium {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,1,2,4,3}));
    }

    public static int solution(int[] A) {
        int[] sumArray = new int[A.length];

        sumArray[0] = A[0];
        for(int i=1 ; i<A.length ; i++) {
            sumArray[i] = sumArray[i-1] + A[i];
        }

        int result = Integer.MAX_VALUE;
        for(int i=1; i<A.length; i++) {
            int leftSum = sumArray[i-1];
            int rightSum = sumArray[A.length-1] - leftSum;

            int gap = Math.abs(leftSum - rightSum);
            result = Math.min(result, gap);
        }

        return result;
    }

    //TIMEOUT..
//    public static int solution(int[] A) {
//        int maxP = A.length - 1;
//
//        int result = Integer.MAX_VALUE;
//        for(int p=1; p<=maxP; p++) {
//
//            int firstSum = 0;
//            int secondSum = 0;
//
//            for(int first=0; first<=p-1; first++) {
//                firstSum += A[first];
//            }
//
//            for(int second=p; second<=A.length-1; second++) {
//                secondSum += A[second];
//            }
//
//            int gap = Math.abs(firstSum - secondSum);
//            if(result > gap) {
//                result = gap;
//            }
//        }
//
//        return result;
//    }
}
