package codility.Lesson10;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class FlagsTest {

    private Flags flags;

    @BeforeAll
    void beforeAll() {
        flags = new Flags();
    }

    @Test
    void test1() {
        int actual = flags.solution(new int[]{1,5,3,4,3,4,1,2,3,4,6,2});

        assertEquals(3, actual);
    }
}