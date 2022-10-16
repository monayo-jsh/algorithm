package codility.Lesson4;

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{1,3,1,4,2,3,5,4}));
        System.out.println(solution(5, new int[]{1,3,1,0,2,3,5,4}));
        System.out.println(solution(3, new int[]{1,3}));
        System.out.println(solution(2, new int[]{1,1,1,1}));
    }

    public static int solution(int X, int[] A) {
        Set<Integer> leaves = new HashSet<>();

        for(int i=0; i<A.length; i++) {
            leaves.add(A[i]);

            if(leaves.size() == X) return i;
        }

        return -1;
    }
}
