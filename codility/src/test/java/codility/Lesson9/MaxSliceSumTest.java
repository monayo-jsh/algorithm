package codility.Lesson9;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class MaxSliceSumTest {

    private MaxSliceSum maxSliceSum;

    @BeforeAll
    void init() {
        maxSliceSum = new MaxSliceSum();
    }

    @Test
    @DisplayName("test-1")
    void test1() {
        int actual = maxSliceSum.solution(new int[]{3,2,-6,4,0});
        assertEquals(5, actual);
    }

   @Test
   @DisplayName("test-2")
   void test2() {
       int actual = maxSliceSum.solution(new int[]{-10});
       assertEquals(-10, actual);
   }

    @Test
    @DisplayName("test-3")
    void test3() {
        int actual = maxSliceSum.solution(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        assertEquals(6, actual);
    }
}