package codility.Lesson6;

import java.util.Arrays;

public class Triangle {
    public static void main(String[] args) {
        Triangle Triangle = new Triangle();
        System.out.println(Triangle.solution(new int[]{10,2,5,1,8,20}));
        System.out.println(Triangle.solution(new int[]{10,50,5,1}));
    }

    public int solution(int[] A) {
        Arrays.sort(A);
        for(int i=0; i<A.length-2; i++) {
            if(A[i+1] + A[i+2] > A[i]) return 1;
        }
        return 0;
    }
}
