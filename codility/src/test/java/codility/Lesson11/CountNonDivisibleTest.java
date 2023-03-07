package codility.Lesson11;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class CountNonDivisibleTest {

    private CountNonDivisible countNonDivisible;

    @BeforeAll
    void beforeAll() {
        countNonDivisible = new CountNonDivisible();
    }

    @Test
    void test1() {
        int[] actual = countNonDivisible.solution(new int[]{3,1,2,3,6});

        System.out.println("actual = " + Arrays.toString(actual));

        assertArrayEquals(new int[]{2,4,3,2,0}, actual);
    }
}