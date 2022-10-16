package codility.Lesson3;

public class FrogJump {
    public static void main(String[] args) {
        FrogJump frogJmp = new FrogJump();
        System.out.println(frogJmp.solution(10, 85, 30));
        System.out.println(frogJmp.solution(1, 1000, 1));
    }

    //시간복잡도 O(1)
    public int solution(int X, int Y, int D) {
        int gap = Y - X;

        if(gap == 0) return 0;

        int division = gap / D;
        int mod = gap % D;

        if(mod > 0) {
            division++;
        }

        return division;
    }

    //Timeout..
//    public int solution(int X, int Y, int D) {
//        Frog frog = new Frog(X, D);
//
//        while(frog.getPosition() < Y) {
//            frog.jump();
//        }
//
//        return frog.getJumpCount();
//    }

//    class Frog {
//        private int position;
//        private final int jumpAbility;
//        private int jumpCount;
//
//        Frog(int position, int jumpAbility) {
//            this.position = position;
//            this.jumpAbility = jumpAbility;
//            this.jumpCount = 0;
//        }
//
//        public int getPosition() {
//            return this.position;
//        }
//
//        public int getJumpCount() {
//            return this.jumpCount;
//        }
//
//        public void jump() {
//            this.position += this.jumpAbility;
//            jumpCount++;
//        }
//    }
}
