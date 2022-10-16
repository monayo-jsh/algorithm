package codility.Lesson4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MissingInteger {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 6, 4, 1, 2}));
        System.out.println(solution(new int[]{1, 2, 3}));
        System.out.println(solution(new int[]{-1, -3}));
        System.out.println(solution(new int[]{}));
        System.out.println(solution(new int[]{-1000000}));
        System.out.println(solution(new int[]{9}));
        System.out.println(solution(new int[]{8}));
        System.out.println(solution(new int[]{0}));
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
        List<Integer> positives = Arrays.stream(A).filter(num -> num > 0).sorted().boxed().collect(Collectors.toList());

        int result = 1;

        if(positives.isEmpty()) return result;

        for(Integer positive : positives) {
            if(positive == result) {
                result++;
            }
        }

        return result;
    }
}
