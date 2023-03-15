package codility.Lesson12;

public class ChocolatesByNumbers {

    /**
     * N : 10, M : 4
     *
     * numbered : 0 ~ 9
     *
     * X 먹은 후 다음은 X + M 먹는다.
     *
     * start number : 0
     * 1 : 0
     * 2 : 0 + 4 = 4
     * 3 : 4 + 4 = 8
     * 4 : 8 + 4 = 12 / 10 = 2
     * 5 : 2 + 4 = 6
     * 6 : 6 + 4 = 10 / 10 = 0
     *
     * 정확도: 100%, 성능: 50%
     */
//    public int solution(int N, int M) {
//        int  countTheNumberOfChocolates = 0;
//
//        int ateNumberOfChocolate = 0;
//        while(true) {
//            //1.초콜릿 먹고
//            countTheNumberOfChocolates++;
//
//            //2.다음 초콜릿 조각 찾기
//            int nextEatTheChocolate = (ateNumberOfChocolate + M) % N;
//
//            //3.빈 포장지를 만나면 먹을게 없음
//            if (nextEatTheChocolate == 0) break;
//
//            ateNumberOfChocolate = nextEatTheChocolate;
//        }
//
//        return countTheNumberOfChocolates;
//    }

    //시간 복잡도 : O(log(N+M))
    public int solution(int N, int M) {
        int gcd = euclidean(N, M);
        return N / gcd;
    }

    /**
     * 유클레드 호제법 (Euclidean Algorithm)
     * 두 개의 수가 주어졌을 때, 최대 공약수를 구하는 알고리즘
     * => 10, 4
     * 1. 두 개의 수 중 큰 수를 기준으로 작은수로 나눠서 나머지를 구한다.
     * : 10 % 4 = 6
     * 2. 나머지를 가지고 앞에서 나눈 수를 다시 나눠서 나머지를 구한다.
     * : 6 % 4 = 2
     * 3. 2번 반복
     * : 4 % 2 = 2, 2 % 2 = 0
     */
    public int euclidean(int max, int min) {
        // 큰숫자를 작은숫자로 나눈 나머지를 계산
        int mod = max % min;
        // 나머지가 0이면 작은숫자가 최대공약수이므로 작은숫자 리턴
        if (mod == 0) {
            return min;
        } else {
            // 나머지가 0 이상이면 재귀형태로 호출
            // 이때 파라미터는 작은숫자와 나머지를 넣어줌
            return euclidean(min, mod);
        }
    }
}
