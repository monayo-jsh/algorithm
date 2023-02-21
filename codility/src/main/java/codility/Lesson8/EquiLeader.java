package codility.Lesson8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EquiLeader {

    //Map 접근에 시간이 소요되는 것으로 보여 leader count를 계산하여 배열에 담아 참조하는 방식의 해결책을 보고 개선.
    //시간 복잡도 : O(N)
    public int improveSolution(int[] A) {

        int equiLeader = 0;

        int[] sequence = makeSequence(A);

        if (sequence.length == 0) return equiLeader;

        for(int i=0; i<sequence.length; i++) {
            int firstSequenceLeaderCount = sequence[i];
            int secondSequenceLeaderCount = sequence[sequence.length-1] - firstSequenceLeaderCount;

            int firstLeaderCondition = (i + 1) / 2;
            if (firstSequenceLeaderCount <= firstLeaderCondition) continue;

            int secondLeaderCondition = (sequence.length - (i + 1)) / 2;
            if (secondSequenceLeaderCount <= secondLeaderCondition) continue;

            equiLeader++;
        }

        return equiLeader;
    }

    private int[] makeSequence(int[] candidates) {
        int leader = getLeader(candidates);

        //leader not found
        if (Integer.MIN_VALUE == leader) return new int[0];

        int[] sequence = new int[candidates.length];
        int leaderCount = 0;
        for(int i=0; i<candidates.length; i++) {
            if (candidates[i] == leader) {
                leaderCount++;
            }
            sequence[i] = leaderCount;
        }

        return sequence;
    }

    private int getLeader(int[] candidates) {
        int leaderCondition = candidates.length/2;
        Map<Integer, Integer> leaderMap = new HashMap<>();
        for(int candidate : candidates) {
            int numberOfOccurs = leaderMap.getOrDefault(candidate, 0);
            leaderMap.put(candidate, ++numberOfOccurs);

            if (numberOfOccurs > leaderCondition) return candidate;
        }
        return Integer.MIN_VALUE;
    }


    //solution is time error..
    public int failImproveSolution(int[] A) {

        int equiLeader = 0;

        Map<Integer, Integer> rightSequenceMap = new HashMap<>();
        int half = A.length/2;
        Integer leader = null;
        for(int candidate : A) {
            Integer occurCount = rightSequenceMap.get(candidate);
            if(occurCount == null) occurCount = 0;

            rightSequenceMap.put(candidate, ++occurCount);

            if(occurCount > half) {
                leader = candidate; //this is leader
            }
        }

        //leader not found
        if (leader == null) { return equiLeader; }

        //find equiLeader
        Map<Integer, Integer> leftSequenceMap = new HashMap<>();
        for(int i=0; i<A.length; i++) {

            int candidate = A[i];

            //left sequence +1
            Integer leftCandidateOccurCount = leftSequenceMap.get(candidate);
            if(leftCandidateOccurCount == null) leftCandidateOccurCount = 0;
            leftSequenceMap.put(candidate, ++leftCandidateOccurCount);

            //right sequence -1
            Integer rightCandidateOccurCount = rightSequenceMap.get(candidate);
            if(rightCandidateOccurCount == null) rightCandidateOccurCount = 0;
            rightSequenceMap.put(candidate, --rightCandidateOccurCount);

            int leftSequenceSize = i + 1;
            int rightSequenceSize = A.length - leftSequenceSize;

            //leader is left leader
            if (leftSequenceMap.get(leader) == null || leftSequenceMap.get(leader) <= (leftSequenceSize / 2)) { continue; }

            //leader is right leader
            if (rightSequenceMap.get(leader) == null || rightSequenceMap.get(leader) <= (rightSequenceSize / 2)) { continue; }

            //leader is equiLeader
            equiLeader++;
        }

        return equiLeader;
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
