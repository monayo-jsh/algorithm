package codility.Lesson8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EquiLeader {

    public static void main(String[] ars) {
        EquiLeader equiLeader = new EquiLeader();
        System.out.println(equiLeader.solution(new int[]{4,3,4,4,4,2}));
        System.out.println(equiLeader.solution(new int[]{1,1}));
        System.out.println(equiLeader.solution(new int[]{1000}));
        System.out.println(equiLeader.solution(new int[]{0}));
    }
    /**
     * 배열 A : 4, 3, 4, 4, 4, 2
     *
     * 이 배열의 리더는 A 요소의 절반 이상에서 발생하는 값
     *
     * S such that 0 <= S < N - 1
     *
     * two sequences
     *
     * 1: A[0], A[1]... A[S]
     * 2: A[S+1], A[S+2],.. , A[N-1]
     *
     *
     * 배열 A : 4, 3, 4, 4, 4, 2
     *
     * case: S=0 [EquiLeader]
     *
     * 1: 4				leader: 4
     * 2: 3, 4, 4, 4, 2	leader: 4
     *
     * case: S=1
     *
     * 1: 4, 3				leader: X
     * 2: 4, 4, 4, 2 		leader: 4
     *
     * case: S=2 [EquiLeader]
     *
     * 1: 4, 3, 4			leader: 4
     * 2: 4, 4, 2			leader: 4
     *
     * case: S=3
     *
     * 1: 4, 3, 4, 4		leader: 4
     * 2: 4, 2				leader: X
     *
     * case: S=4
     *
     * 1: 4, 3, 4, 4, 4	leader: 4
     * 2: 2				leader: X
     * <br>
     * <span style="color:red;">시간 복잡도 : O(N ** 2) 개선 필요</span>
     */
    public int solution(int[] A) {

        List<Integer> candidates = Arrays.stream(A).boxed().collect(Collectors.toList());
        int leader = getLeader(candidates);

        //not found leader
        if (leader == Integer.MIN_VALUE) return 0;

        //find Equi Leader
        //0 <= S < N - 1
        //1: A[0], A[1], .., A[S]
        //2: A[S+1], A[S+2], .., A[N-1]
        int equiLeaderCount = 0;
        for(int S=0; S<A.length-1; S++) {
            int firstLeader = getLeader(candidates.subList(0, S+1));
            if (firstLeader == Integer.MIN_VALUE) continue; //not found leader

            int secondLeader = getLeader(candidates.subList(S+1, candidates.size()));
            if (secondLeader == Integer.MIN_VALUE) continue; //not found leader

            if (firstLeader == secondLeader) {
                equiLeaderCount++;
            }
        }

        return equiLeaderCount;
    }

    private int getLeader(List<Integer> candidates) {
        int half = candidates.size()/2;
        Map<Integer, Integer> leaderMap = new HashMap<>();
        for(int candidate : candidates) {
            int numberOfOccurs = leaderMap.getOrDefault(candidate, 0) + 1;

            if (numberOfOccurs > half) return candidate;

            leaderMap.put(candidate, numberOfOccurs);
        }

        return Integer.MIN_VALUE;
    }
}
