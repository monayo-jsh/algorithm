package codility.Lesson9;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class MaxDoubleSliceSumTest {

    private MaxDoubleSliceSum maxDoubleSliceSum;

    @BeforeAll
    void init() {
        maxDoubleSliceSum = new MaxDoubleSliceSum();
    }

    @Test
    @DisplayName("test1")
    void test1() {
          int actual = maxDoubleSliceSum.solution(new int[]{ 3, 2, 6, -1, 4, 5, -1, 2 });
          assertEquals(17, actual);
    }

    @Test
    @DisplayName("test2")
    void test2() {
        int actual = maxDoubleSliceSum.solution(new int[]{ -2 -3, 4, -1, -2, 1, 5, -3 });
        assertEquals(9, actual);
    }

    @Test
    @DisplayName("test3")
    void test3() {
        int actual = maxDoubleSliceSum.solution(new int[]{ 1, 2, 3 });
        assertEquals(0, actual);
    }
}