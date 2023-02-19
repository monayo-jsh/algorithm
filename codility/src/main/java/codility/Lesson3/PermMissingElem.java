package codility.Lesson3;

public class PermMissingElem {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,3,1,5}));
        System.out.println(solution(new int[]{2,3,1,4,5,7}));
    }

    //시간복잡도 O(N) or O(N * log(N))
    public static int solution(int[] A) {
        int[] array = new int[A.length+1];

        for(int num : A) {
            int targetIndex = num - 1;
            array[targetIndex]++;
        }

        int result = 0;
        for(int i=0; i<array.length; i++) {
            if(array[i] == 0) {
                result = i+1;
                break;
            }
        }
        return result;
    }
}
