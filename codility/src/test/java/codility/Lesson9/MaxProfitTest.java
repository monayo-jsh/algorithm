package codility.Lesson9;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class MaxProfitTest {
    private MaxProfit maxProfit;

    @BeforeAll
    void beforeAll() {
        maxProfit = new MaxProfit();
    }

    @Test
    void test1() {
        int actual = maxProfit.solution(new int[]{23171, 21011, 21123, 21366, 21013, 21367});

        assertEquals(356, actual);
    }
}