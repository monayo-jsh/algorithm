package codility.Lesson12;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class ChocolatesByNumbersTest {

    private ChocolatesByNumbers chocolatesByNumbers;

    @BeforeAll
    void beforeAll() {
        chocolatesByNumbers = new ChocolatesByNumbers();
    }

    @Test
    void test1() {
        int actual = chocolatesByNumbers.solution(10, 4);

        assertEquals(5, actual);
    }
}