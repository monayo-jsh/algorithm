package codility.Lesson7;

import java.util.Stack;

public class StoneWall {
    public static void main(String[] args) {
        StoneWall template = new StoneWall();
        System.out.println(template.solution(new int[]{8,8,5,7,9,8,7,4,8}));
    }

    public int solution(int[] H) {
        //0 8 -> [] -- [8] 8 in stone +1 ==> 1
        //1 8 -> [8] -- [8] 8 keep stone +0 ==> 1
        //2 5 -> [8] -- [5] 8 out, 5 in stone +1 ==> 2
        //3 7 -> [5] -- [5, 2] 2 in stone +1 ==> 3
        //4 9 -> [5, 2] -- [5, 2, 2] 2 in stone +1 ==> 4
        //5 8 -> [5, 2, 2] -- [5, 2, 1] 2 out, 1 in stone +1 ==> 5
        //6 7 -> [5, 2, 1] -- [5, 2] 1 out stone +0 ==> 5
        //7 4 -> [5, 2] -- [4] 2 out, 5 out, 4 in stone +1 ==> 6
        //8 8 -> [4] -- [4, 4] 4 in stone +1 ==> 7

        int numberOfBricks = 0;
        int currentBrickHeight = 0;
        Stack<Integer> brickStack = new Stack<>();

        for(int brickHeight : H) {

            if (brickStack.isEmpty()) {
                //재사용할 수 있는 벽돌이 없음
                brickStack.push(brickHeight);
                numberOfBricks++; //벽돌 1개 추가
                currentBrickHeight += brickHeight;
                continue;
            }

            
        }

        return numberOfBricks;
    }

}
