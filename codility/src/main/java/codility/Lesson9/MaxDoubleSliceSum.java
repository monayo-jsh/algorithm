package codility.Lesson9;

public class MaxDoubleSliceSum {

    /**
     * I = [0, 1, 2, 3, 4, 5, 6, 7]
     * A = [3, 2, 6,-1, 4, 5,-1, 2]
     *
     * A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.
     * The sum of double slice (X, Y, Z) is the total of A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1]
     *
     * X=0, Y=3, Z=6
     * X => A[1], Y => A[2] + A[4], Z => A[5]
     * S => 2 + 6 + 4 + 5 = 17
     *
     * X=0, Y=3, Z=7
     * X => A[1], Y => A[2] + A[4] + A[5], Z => A[6]
     * S => 2 + 6 + 4 + 5 - 1 = 16
     *
     * X=3, Y=4, Z=5
     * X => 0, Y => 0, Z => 0
     *
     * 0 <= X(0) < Y(1) < Z(2) < N(8)
     *
     * X+1 부터 시작되므로 X가 0일지라도 0번째 인덱스는 사용되지 않음
     * Z-1 이므로 Z는 N-1인 7이 최대 값이지만 7을 사용하지 않음 => 7번째 인덱스 2는 참조되지 않음
     *
     * I = [0, 1, 2, 3, 4, 5, 6, 7]
     * A = [X, 2, 6,-1, 4, 5,-1, X]
     *
     * 최대 범위 : 0 <= X(5) < Y(6) < Z(7) < N(8)
     * X 범위 : 0 ~ 5
     * Y 범위 : 1 ~ 6
     * Z 범위 : 2 ~ 7
     *
     * X Y 부분합 -> 1 ~ 6
     * Y Z 부분합 -> 2 ~ 7
     *
     * 다른 사람 풀이 참고해서 내용 이해 -> 다시 학습 필요
     */

    public int solution(int[] A) {

        int[] xySliceSum = new int[A.length];
        int[] yzSliceSum = new int[A.length];

        for(int i=1; i<A.length-1; i++) {
            xySliceSum[i] = Math.max(0, xySliceSum[i-1] + A[i]);
        }

        for(int i=A.length-2; i>0; i--) {
            yzSliceSum[i] = Math.max(0, yzSliceSum[i+1] + A[i]);
        }

        int maxDoubleSliceSum = 0;
        for(int i=1; i<A.length-1; i++) {
            maxDoubleSliceSum = Math.max(maxDoubleSliceSum, xySliceSum[i-1] + yzSliceSum[i+1]);
        }

        return maxDoubleSliceSum;
    }

}
