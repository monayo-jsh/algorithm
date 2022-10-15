package codility.Lesson1;

public class BinaryGap {
    public static void main(String[] args) {
        System.out.println(solution(9));
        System.out.println(solution(529));
        System.out.println(solution(20));
        System.out.println(solution(15));
        System.out.println(solution(32));
        System.out.println(solution(2147483647));
        System.out.println(solution(6));
        System.out.println(solution(328));
    }

    public static int solution(int N) {
        String binary = Integer.toBinaryString(N);

        int result = 0;

        int gap = 0;
        for(int i=0; i<binary.length(); i++) {

            if('0' == binary.charAt(i)) {
                gap++;
                continue;
            }

            if('1' == binary.charAt(i)) {
                if(gap > 0) {
                    if(gap > result) result = gap;

                    gap = 0;
                }
            }

        }

        return result;
    }
}
