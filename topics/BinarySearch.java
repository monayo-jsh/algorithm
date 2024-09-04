public class BinarySearch {
    // 이진 탐색
    // 정렬된 배열이나 리스트에서 원하는 값을 효율적으로 찾기 위한 알고리즘
    // 탐색 범위를 절반씩 줄여가며 목표값을 찾기때문에 매우 빠르고, 시간 복잡도는 O(log n)
    //
    // 1. 배열이 정렬되어있어야 함.
    // 2. 중간 값 선택 -> 중간 인덱스 = (시작 인덱스 + 끝 인덱스) / 2
    // 3.
    //  - 목표 값이 중간 값과 같으면 인덱스 반환
    //  - 목표 값이 중간 값보다 크다면 오른쪽에 있으므로, 시작 인덱스를 중간 인덱스 + 1로 변경
    //  - 목표 값이 중간 값보다 작다면 왼쪽에 있으므로, 끝 인덱스를 중간 인덱스 - 1로 변경
    // 4. 반복
    // 5. 종료 조건
    //  - 값을 찾았을 때 (중간 값이 목표 값과 동일)
    //  - 탐색 범위가 더이상 존재하지 않을 때 (시작 인덱스가 끝 인덱스를 초과할 때)

    public static int binarySearch(int[] arr, int target) {
        int start = 0; // 시작 인덱스
        int end = arr.length - 1; // 끝 인덱스

        while (start <= end) {
            // 중간 인덱스 계산
            int mid = start + (end - start) / 2; // (매우 큰 값을 가질 때 오버플로우 발생 방지 계산)

            if (arr[mid] == target) return mid; // 인덱스 반환

            if (arr[mid] < target) { // 목표 값이 중간 값보다 크면 오른쪽
                start = mid + 1;
            }
            if (arr[mid] > target) { // 목표 값이 중간 값보다 작으면 왼쪽
                end = mid - 1;
            }
        }

        return -1; //목표 값을 찾지 못하면 -1 반환
    }

    public static int binarySearchRecursive(int[] arr, int target, int start, int end) {
        //중간 인덱스 계산
        int mid = start + (end - start) / 2;

        // 시작 인덱스가 종료 인덱스를 넘어서면 찾는 값 없으므로 -1 반환
        if (start > end) return -1;

        if (arr[mid] == target) return mid;

        if (arr[mid] < target) {
            // 목표 값이 중간 값보다 크면 오른쪽
            start = mid + 1;
        }
        if (arr[mid] > target) {
            // 목표 값이 중간 값보다 작으면 왼쪽
            end = mid - 1;
        }

        return binarySearchRecursive(arr, target, start, end);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15};  // 정렬된 배열

        for (int target : arr) {
            // 찾고자 하는 값이 있는 테스트
            testBinarySearchForExistsIndex(arr, target);
        }

        // 없는 값 테스트
        testBinarySearchForExistsIndex(arr, 0);
        testBinarySearchForExistsIndex(arr, 100);
    }

    private static void testBinarySearchForExistsIndex(int[] arr, int target) {
        int result = binarySearch(arr, target);
        System.out.println("찾은 값의 인덱스: " + result);  // 목표 값의 인덱스 출력

        int findIndex = binarySearchRecursive(arr, target, 0, arr.length - 1);
        System.out.println("찾은 값의 인덱스: " + findIndex); // 목표 값의 인덱스 출력

        System.out.println("--");
    }


}
