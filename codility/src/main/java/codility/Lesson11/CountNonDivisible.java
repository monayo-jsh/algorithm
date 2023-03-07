package codility.Lesson11;

public class CountNonDivisible {

    /**
     * 시간 복잡도 : O (N ** 2)
     */
    public int[] solution(int[] A) {

        int[] nonDivisors = new int[50001];

        int[] result = new int[A.length];
        for(int i=0; i<A.length; i++) {

            int number = A[i];

            //계산된 값이 있으면 참조
            if (nonDivisors[number] == -1) {
                result[i] = 0;
                continue;
            }

            //계산된 값이 있으면 참조
            if (nonDivisors[number] > 0) {
                result[i] = nonDivisors[number];
                continue;
            }

            //calc non-divisors
            for(int j=0; j<A.length; j++) {

                if(i == j) continue;

                if(number % A[j] != 0) {
                    nonDivisors[number]++;
                }
            }

            //계산 결과 설정
            result[i] = nonDivisors[number];

            //값이 없으면 -1 설정
            if(nonDivisors[number] == 0) {
                nonDivisors[number] = -1;
            }
        }

        return result;
    }

}
