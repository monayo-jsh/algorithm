package codility.Lesson11;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class CountSemiprimesTest {

    private CountSemiprimes countSemiprimes;

    @BeforeAll
    void beforeAll() {
        countSemiprimes = new CountSemiprimes();
    }

    @Test
    void test1() {
        int[] actual = countSemiprimes.solution(26, new int[]{1,4,16}, new int[]{26,10,20});

        assertArrayEquals(new int[]{10,4,0}, actual);
    }
}