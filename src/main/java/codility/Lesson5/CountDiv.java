package codility.Lesson5;

public class CountDiv {
    public static void main(String[] args) {
        System.out.println(solution(6, 11, 2));
        System.out.println(solution(11, 345, 17));
        System.out.println(solution(0, 0, 11));
        System.out.println(solution(1, 1, 11));
    }

    public static int solution(int A, int B, int K) {
        //수학 공식...
        //A와 B사이에 K로 나눌 수 있는 수 구하는 공식
        //(B/K) - (A/K)
        if(A % K == 0) {
            return B/K - A/K + 1;
        }

        return B/K - A/K;
    }

    //TIMOUT
//    public static int solution(int A, int B, int K) {
//        int modCount = 0;
//
//        for(int i=A; i<=B; i++) {
//            if(i % K == 0) {
//                modCount++;
//            }
//        }
//
//        return modCount;
//    }
}
