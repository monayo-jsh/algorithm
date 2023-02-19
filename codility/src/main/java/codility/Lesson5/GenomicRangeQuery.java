package codility.Lesson5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GenomicRangeQuery {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6})));
    }

    public final static Map<Character, Integer> IMPACT_FACTOR_MAP = new HashMap<>() {
        {
            put('A', 0);
            put('C', 1);
            put('G', 2);
            put('T', 3);
        }
    };

    public static int[] solution(String S, int[] P, int[] Q) {
        char[] chars = S.toCharArray();
        int[] count = {0, 0, 0, 0};
        int[][] IMPACT_FACTOR_ARRAY = new int[chars.length][count.length];

        for(int i=0; i<chars.length; i++) {
            count[IMPACT_FACTOR_MAP.get(chars[i])]++;

            for(int j=0; j<count.length; j++) {
                IMPACT_FACTOR_ARRAY[i][j] = count[j];
            }
        }

        int[] result = new int[P.length];

        for(int i=0; i<result.length; i++) {
            for(int j=0; j<count.length; j++) {
                int second = IMPACT_FACTOR_ARRAY[Q[i]][j];
                int first = P[i] == 0 ? 0 : IMPACT_FACTOR_ARRAY[P[i]-1][j];

                if(second - first > 0) {
                    result[i] = j+1;
                    break;
                }
            }
        }

        return result;
    }

    //시간 복잡도 안나옴
//    private static Integer getImpactFactor(String s) {
//        char impactFactor = s.charAt(0);
//        if(s.length() == 1) return IMPACT_FACTOR_MAP.get(impactFactor);
//
//        for(int j=1; j<s.length(); j++) {
//            impactFactor = (char) Math.min(impactFactor, s.charAt(j));
//        }
//        return IMPACT_FACTOR_MAP.get(impactFactor);
//    }

    //OUT OF MEMORY.. >> 2차원 배열을 더 FIT하게 정의
    //다이나믹 프로그래밍으로 문자열의 IMPACT FACTOR를 미리 계산한 뒤 참조해서 결과를 반환한다.
    //00    01  02  03      04      05      06
    //C     CA  CAG CAGC    CAGCC   CAGCCT  CAGCCTA
    //11    12  13  14      15      16
    //A     AG  AGC AGCC    AGCCT   AGCCTA
    //22    23  24  25      26
    //G     GC  GCC GCCT    GCCTA
    //33    34  35  36
    //C     CC  CCT CCTA
    //44    45  46
    //C     CT  CTA
    //55    56
    //T     TA
    //66
    //A
//    public static int[] solution(String S, int[] P, int[] Q) {
//        int[][] IMPACT_FACTOR_ARRAY = new int[S.length()][];
//
//        for(int first=0; first<S.length(); first++) {
//
//            IMPACT_FACTOR_ARRAY[first] = new int[S.length()-first];
//            int second=0;
//            for(int j=first; j<S.length(); j++) {
//                IMPACT_FACTOR_ARRAY[first][second++] = getImpactFactor(S.substring(first, j+1));
//            }
//        }
//
//        int[] result = new int[P.length];
//        for(int i=0; i<result.length; i++) {
//            int first = P[i];
//            int second = Q[i] - P[i];
//
//            result[i] = IMPACT_FACTOR_ARRAY[first][second];
//        }
//        return result;
//    }

//   TIMEOUT..
//    public static int[] solution(String S, int[] P, int[] Q) {
//        int length = P.length;
//        int[] result = new int[length];
//
//        for(int i=0; i<length; i++) {
//            int startIndex = P[i];
//            int endIndex = Q[i] + 1;
//
//            String target = S.substring(startIndex, endIndex);
//            if(target.length() == 1) {
//                result[i] = convImpactFactor(target.charAt(0));
//                continue;
//            }
//
//            int impactFactor = target.charAt(0);
//            for(int j=1; j<target.length(); j++) {
//                impactFactor = Math.min(impactFactor, target.charAt(j));
//            }
//            result[i] = convImpactFactor(impactFactor);
//        }
//
//        return result;
//    }
}
