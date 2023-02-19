package codility.Lesson6;

import java.util.HashSet;
import java.util.Set;

public class Distinct {
    public static void main(String[] args) {
        Distinct distinct = new Distinct();
        System.out.println(distinct.solution(new int[]{2,1,1,2,3,1}));
    }

    public int solution(int[] A) {
        Set<Integer> distinct = new HashSet<>();
        for(int num : A) {
            distinct.add(num);
        }
        return distinct.size();
    }
}
