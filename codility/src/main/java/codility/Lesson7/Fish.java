package codility.Lesson7;

import java.util.Stack;

public class Fish {
    public static void main(String[] args) {
        Fish template = new Fish();
        System.out.println(template.solution(new int[]{4,3,2,1,5}, new int[] {0,1,0,0,0}));
        System.out.println(template.solution(new int[]{4,3,2,1,5}, new int[] {0,0,0,0,0}));
        System.out.println(template.solution(new int[]{4,3,2,1,5}, new int[] {0,1,1,0,1}));
    }

    public int solution(int[] A, int[] B) {
        int numberOfFishToSurvive = 0;

        if (A.length == 0) return numberOfFishToSurvive;

        Stack<Integer> river = new Stack<>();

        for (int i=0; i<A.length; i++) {
            //물고기 방향 확인
            int direction = B[i];

            if (direction == 1) {
                //하류로 흐르는 물고기 강 투입
                river.push(A[i]);
                continue;
            }

            //상류로 흐르는 물고기
            if(river.size() == 0) {
                //하류로 흐르는 물고기가 없으면 A[i] 물고기는 살아남음
                numberOfFishToSurvive++;
                continue;
            }

            while(river.size() > 0) {
                //하류로 흐르는 물고기
                int fish = river.peek();

                if (fish > A[i]) {
                    //하류로 흐르는 물고기가 상류로 흐르는 물고기를 잡아먹음
                    break;
                }

                //상류로 흐르는 물고기가 하류로 흐르는 물고기를 잡아먹음
                river.pop();

                if (river.size() == 0) {
                    //하류로 흐르는 물고기가 없으면 A[i] 물고기는 살아남음
                    numberOfFishToSurvive++;
                    break;
                }
            }
        }

        //하류로 흐르는 물고기 수 포함
        numberOfFishToSurvive += river.size();

        return numberOfFishToSurvive;
    }
}
