package codility.Lesson10;

public class Peaks {


    /**
     *
     * A peak is an array element which is larger than its neighbors.
     *
     * More precisely,
     * it is an index P such that 0 < P < N − 1,  A[P − 1] < A[P] and A[P] > A[P + 1]
     *
     * A = [1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2]
     *
     * 시간 복잡도 : O(N * log(log(N)))
     */
    public int solution(int[] A) {

        boolean[] peaks = new boolean[A.length];

        //1. 피크 체크
        int peakCount = 0;
        for (int i=1; i<A.length-1; i++) {
            if (A[i-1] < A[i] && A[i] > A[i+1]) {
                peaks[i] = true;
                peakCount++;
            }
        }

        //2. 피크가 1개 이하인 경우 블록을 나눌 의미가 없음
        if (peakCount <= 1) return peakCount;

        //3. 유효한 블록 수 구하기
        int maximumNumberOfBlocks = 1;
        for(int divied=1; divied<A.length/2; divied++) {
            //나눌 수 있는지 검증
            boolean isNotDividedBlock = isNotDividedBlocks(peaks, divied+1);
            if(isNotDividedBlock) continue;

            //나눌 수 있는 블록 수 갱신
            maximumNumberOfBlocks = divied+1;
        }

        return maximumNumberOfBlocks;
    }

    private boolean isNotDividedBlocks(boolean[] peaks, int dividedNumber) {
        //1.동일한 요소의 수로 나눌 수 없으면 검증하지 않음
        if (peaks.length % dividedNumber != 0) return true;

        //2.블록 별 사이즈
        int groupSize = peaks.length / dividedNumber;

        //3.블록 수만큼 반복하며 블록 내 피크가 있는지 확인
        for(int i=0; i<dividedNumber; i++) {

            //4.블록의 시작 인덱스 설정
            int groupStartIdx = i * groupSize;

            //5.블록 내 피크가 있는지 검증
            boolean isNotPeakInBlock = true;
            for(int j=0; j<groupSize; j++) {
                if(peaks[groupStartIdx++]) {
                    isNotPeakInBlock = false;
                    break;
                }
            }

            //6.블록 내 피크 없으면 나눌 수 없음
            if(isNotPeakInBlock) return true;
        }

        return false;
    }

}
