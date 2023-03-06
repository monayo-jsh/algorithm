package codility.Lesson10;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class PeaksTest {

    private Peaks peaks;

    @BeforeAll
    void beforeAll() {
        peaks = new Peaks();
    }

    @Test
    void test1() {
        int actual = peaks.solution(new int[]{1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2});

        assertEquals(3, actual);
    }

    @Test
    void test2() {
        int actual = peaks.solution(new int[]{0, 1, 0, 0, 1, 0, 0, 1, 0});

        assertEquals(3, actual);
    }
}