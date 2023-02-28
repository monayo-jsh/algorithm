package codility.Lesson10;

import java.util.ArrayList;
import java.util.List;

public class Flags {

    /**
     * A = [1,5,3,4,3,4,1,2,3,4,6,2]
     *
     * A peak is an array element which is larger than its neighbours.
     * More precisely, it is an index P such that 0 < P < N − 1 and A[P − 1] < A[P] > A[P + 1].
     *
     * Flags can only be set on peaks.
     * What's more, if you take K flags, then the distance between any two flags should be greater than or equal to K.
     * The distance between indices P and Q is the absolute value |P − Q|
     *
     * peak = [1, 3, 5, 10]
     * 깃발을 꽂기 위해서는 깃발 사이의 간격이 깃발의 수보다 커야한다.
     *
     * 깃발 2개
     * 1번 꽂고
     * 3번 확인 |1-3| = 2, 2는 2와 같으므로 꽂을 수 있음
     *
     * 깃발 3개
     * 1번 꽂고
     * 3번 확인 |1-3| = 2, 2는 3보다 작으므로 꽂을 수 없음
     * 5번 확인 |1-5| = 4, 3보다 크므로 꽂을 수 있음
     * 10번 확인 |5-10| = 5, 3보다 크므로 꽂을 수 있음
     *
     * 깃발 4개
     * 1번 꽂고
     * 3번 확인 |1-3| = 2, 2는 4보다 작으므로 꽂을 수 없음
     * 5번 확인 |1-5| = 4, 4는 4와 같으므로 꽂을 수 있음
     * 10번 확인 |5-10| = 5, 5는 4보다 크므로 꽂을 수 있음
     *
     * 더 이상 꽂을 수 있는 봉우리가 없으므로 깃발 4개 들고 갈 필요 없음
     */
    //시간 복잡도 : O(N^2)
    public int solution(int[] A) {

        List<Integer> peeks = new ArrayList<>();

        for(int i=1; i<A.length-1; i++) {
            if (A[i-1] >= A[i]) continue;
            if (A[i+1] >= A[i]) continue;

            peeks.add(i);
        }

        //봉우리가 1개 이하인 경우 봉우리 수만큼 깃발 필요
        if (peeks.size() <= 1) return peeks.size();

        int maximumFlags = 0;
        //봉우리가 2개 이상이면 깃발은 2개 ~ 봉우리 개수만큼 최대 꽂을 수 있는 수량을 확인
        for(int flagCount=2; flagCount<=peeks.size(); flagCount++) {

            //최초 봉우리에는 깃발을 꽂고 시작
            int AvailableFlags = flagCount - 1;
            int usedFlagsCount = 1;

            int flagIndex = 0; //이전 플래그 위치
            for(int j=1; j<peeks.size(); j++) {

                int distance = Math.abs(peeks.get(flagIndex) - peeks.get(j));
                if(distance >= flagCount) {
                    flagIndex = j;
                    usedFlagsCount++;
                    AvailableFlags--;
                }

                if (AvailableFlags == 0) break;
            }

            maximumFlags = Math.max(maximumFlags, usedFlagsCount);
        }

        return maximumFlags;
    }

}
