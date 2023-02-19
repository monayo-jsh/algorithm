package codility.Lesson4;

import java.util.Arrays;

public class PermCheck {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4,1,3,2}));
        System.out.println(solution(new int[]{4,1,3}));
    }

    public static int solution(int[] A) {
        Arrays.sort(A);

        for(int i=0; i<A.length; i++) {
            if(A[i] != i+1) return 0;
        }

        return 1;
    }

    //Timeout
//    public static int solution(int[] A) {
//        List<Integer> permutations = IntStream.of(A).boxed().sorted().collect(Collectors.toList());
//
//        int seq = 1;
//        for(int num : permutations) {
//           if(num != seq) return 0;
//           seq++;
//        }
//
//        return 1;
//    }

}
