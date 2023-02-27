package codility.Lesson10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class MinPerimeterRectangleTest {

    private MinPerimeterRectangle perimeterRectangle;

    @BeforeAll
    void beforeAll() {
        perimeterRectangle = new MinPerimeterRectangle();
    }

    @Test
    void test1() {
        int actual = perimeterRectangle.solution(30);

        assertEquals(22, actual);
    }

    @Test
    void test2() {
        int actual = perimeterRectangle.solution(1);

        assertEquals(4, actual);
    }

    @Test
    void test3() {
        int actual = perimeterRectangle.solution(36);

        assertEquals(24, actual);
    }

    @Test
    void test4() {
        int actual = perimeterRectangle.solution(100000000);

        assertEquals(40000, actual);
    }
}