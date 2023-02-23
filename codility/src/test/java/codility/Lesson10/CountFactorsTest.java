package codility.Lesson10;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class CountFactorsTest {

    private CountFactors countFactors;

    @BeforeAll
    void init() {
        countFactors = new CountFactors();
    }

    @Test
    @DisplayName("test1")
    void test1() {
        int actual = countFactors.solution(24);

        assertEquals(8 ,actual);
    }

    @Test
    @DisplayName("test2")
    void test2() {
        int actual = countFactors.solution(10);

        assertEquals(4 ,actual);
    }

    @Test
    @DisplayName("test3")
    void test3() {
        int actual = countFactors.solution(100);

        assertEquals(9 ,actual);
    }
}