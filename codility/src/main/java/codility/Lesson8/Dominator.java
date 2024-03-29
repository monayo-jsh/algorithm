package codility.Lesson8;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public class Dominator {
    public static void main(String[] args) {
        Dominator dominator = new Dominator();
        System.out.println(dominator.solution(new int []{3, 4, 3, 2, 3, -1, 3, 3}));
        System.out.println(dominator.solution(new int []{2, 1, 1, 3}));

        System.out.println(dominator.otherSolution(new int []{3, 4, 3, 2, 3, -1, 3, 3}));
        System.out.println(dominator.otherSolution(new int []{2, 1, 1, 3}));
    }

    //시간복잡도 : O(N*log(N)) or O(N)
    public int solution(int[] A) {
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        Map<Integer, Integer> numCountMap = new HashMap<>();
        int dominatorNum = A.length / 2;

        for(int i=0; i<A.length; i++) {
            if (Objects.isNull(numCountMap.get(A[i]))) {
                numCountMap.put(A[i], 0);
            }
            numCountMap.put(A[i], numCountMap.get(A[i])+1);
            numIndexMap.put(A[i], i);
        }

        for(Entry<Integer, Integer> dominator : numCountMap.entrySet()) {
            if(dominator.getValue() > dominatorNum) return numIndexMap.get(dominator.getKey());
        }

        return -1;
    }

    //다른 사람 풀이 && 소스 조금 수정
    //시간 복잡도 : O(N*log(N)) or O(N)
    public int otherSolution(int[] A) {
        Map<Integer, Integer> count = new HashMap<>();

        int dominator = A.length/2;
        int index = 0;
        for (int a : A) {
            count.put(a, count.getOrDefault(a, 0) + 1);

            if (count.get(a) > dominator) return index;
            index++;
        }

        return -1;
    }
}
