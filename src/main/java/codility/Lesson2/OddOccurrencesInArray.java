package codility.Lesson2;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public class OddOccurrencesInArray {

    //https://app.codility.com/programmers/lessons/2-arrays/

    public static void main(String[] args) {
        System.out.println(solution(new int[]{9,3,9,3,9,7,9}));
    }

    public static int solution(int[] A) {
        Map<Integer, Integer> pair = makeSummaryPair(A);

        int result = 0;
        for(Entry<Integer, Integer> entry : pair.entrySet()) {
            if(entry.getValue() % 2 == 1) {
                result = entry.getKey();
                break;
            }
        }
        return result;
    }

    private static Map<Integer, Integer> makeSummaryPair(int[] array) {
        Map<Integer, Integer> pair = new HashMap<>();
        for(int i=0; i<array.length; i++) {
            int key = array[i];

            Integer pairCount = pair.get(key);

            if(Objects.isNull(pairCount)) {
                pair.put(key, 1);
                continue;
            }

            pair.put(key, pairCount+1);
        }
        return pair;
    }
}
