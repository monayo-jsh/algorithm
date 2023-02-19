package codility.Lesson6;

import java.util.Arrays;

public class MaxProductOfThree {
    public static void main(String[] args) {
        MaxProductOfThree maxProductOfThree = new MaxProductOfThree();
        System.out.println(maxProductOfThree.solution(new int[]{-3,1,2,-2,5,6}));
    }

    public int solution(int[] A) {
        Arrays.sort(A);

        int n = A.length;

        int a = A[n-1] * A[n-2] * A[n-3];
        int b = A[0] * A[1] * A[n-1];

        return Math.max(a, b);
    }
}
