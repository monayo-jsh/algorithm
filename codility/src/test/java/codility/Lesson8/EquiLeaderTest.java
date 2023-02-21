package codility.Lesson8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class EquiLeaderTest {

    private EquiLeader equiLeader;

    @BeforeAll
    void setup() {
        equiLeader = new EquiLeader();
    }

    @Test
    public void test1() {;
        int actual = equiLeader.improveSolution(new int[]{4,3,4,4,4,2});

        assertEquals(2, actual);
    }

   @Test
   public void test2() {
       int actual = equiLeader.improveSolution(new int[]{1,1});

       assertEquals(1, actual);
   }

    @Test
    public void test3() {
        int actual = equiLeader.improveSolution(new int[]{1000});

        assertEquals(0, actual);
    }

    @Test
    public void test4() {
        int actual = equiLeader.improveSolution(new int[]{4, 4, 2, 5, 3, 4, 4, 4});

        assertEquals(3, actual);
    }

}