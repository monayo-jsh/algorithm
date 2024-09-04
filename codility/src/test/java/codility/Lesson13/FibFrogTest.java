package codility.Lesson13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class FibFrogTest {

    private FibFrog fibFrog;

    @BeforeEach
    void setUp() {
        fibFrog = new FibFrog();
    }

    @Test
    void test1() {
        int actual = fibFrog.solution(new int[]{0,0,0,1,1,0,1,0,0,0,0});

        assertEquals(3, actual);
    }
}