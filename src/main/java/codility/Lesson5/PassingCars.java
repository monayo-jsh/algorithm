package codility.Lesson5;

public class PassingCars {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{0,1,0,1,1}));
        System.out.println(solution(new int[]{0,0,0}));
    }

    public static int solution(int[] A) {
        int east = 0;
        int passing = 0;

        final int EXCEED_PASSING_CARS = 1000000000;
        for(int car : A) {

            if(car == 0) {
                //동쪽으로 가는 차
                east++;
                continue;
            }

            //서쪽으로 가면 동쪽으로 간 차만큼 짝이 될 수 있으니 서쪽에 더해줌
            passing += east;

            //지나간 차가 초과한 경우
            if(passing > EXCEED_PASSING_CARS) return -1;
        }

        return passing;
    }

    //TIMEOUT..
//    public static int solution(int[] A) {
//        List<Pair> cars = new ArrayList<>();
//
//        for(int i=0; i<A.length-1; i++) {
//
//            if(A[i] == 1) continue;
//
//            for(int j=i+1; j<A.length; j++) {
//
//                if(A[j] == 0) continue;
//
//                cars.add(new Pair(i, j));
//            }
//        }
//
//        final int EXCEED_CARS_COUNT = 1000000000;
//        if(cars.size() > EXCEED_CARS_COUNT) {
//            return -1;
//        }
//
//        return cars.size();
//    }

//    static class Pair {
//        private int x;
//        private int y;
//
//        Pair(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
}
