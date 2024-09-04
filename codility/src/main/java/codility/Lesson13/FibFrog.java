package codility.Lesson13;

public class FibFrog {

    /**
     * Count the minimum number of jumps required for a frog to get to the other side of a river.
     *
     * river = [0,0,0,1,1,0,1,0,0,0,0]
     *
     * fibonacci numbers, F(0) = 0, F(1) = 1, F(M) = F(M-1) + F(M-2) if M >= 2
     */

    public int solution(int[] A) {

        int[] fibinacciNumbers = new int[A.length];
        fibinacciNumbers[0] = 0;
        fibinacciNumbers[1] = 1;

        for(int i=2; i<fibinacciNumbers.length; i++) {
            fibinacciNumbers[i] = fibinacciNumbers[i-1] + fibinacciNumbers[i-2];
        }



        return 0;
    }

}
