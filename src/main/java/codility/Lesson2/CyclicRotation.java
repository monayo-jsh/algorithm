package codility.Lesson2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CyclicRotation {

    //https://app.codility.com/programmers/lessons/2-arrays/

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{3, 8, 9, 7, 6}, 3)));
        System.out.println(Arrays.toString(solution(new int[]{0, 0, 0}, 1)));
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4}, 4)));
        System.out.println(Arrays.toString(solution(new int[]{}, 1)));
    }

    public static int[] solution(int[] A, int K) {
        if(A.length == 0) return A;

        List<Integer> array = makeList(A);
        rotateArray(array, K);
        return makeResult(array);
    }

    private static int[] makeResult(List<Integer> array) {
        int[] result = new int[array.size()];
        for(int i=0; i<array.size(); i++){
            result[i] = array.get(i);
        }
        return result;
    }

    private static void rotateArray(List<Integer> cycle, int k) {
        for(int i=0; i<k; i++) {
            int last = cycle.remove(cycle.size()-1);
            cycle.add(0, last);
        }
    }

    public static List<Integer> makeList(int[] intArray) {
        return IntStream.of(intArray).boxed().collect(Collectors.toList());
    }

}
