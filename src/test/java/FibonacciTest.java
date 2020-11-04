import org.junit.AfterClass;
import org.junit.BeforeClass;

import static org.junit.Assert.*;

public class FibonacciTest {

    private Fibonacci fibonacci;
    int fiboLength = 11;
    private int[] arrayFiboSequence = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89};

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before FibonacciTest.class");
    }

    @AfterClass
    public  static void afterClass() {
        System.out.println("After FibonacciTest.class");
    }

    @org.junit.Before
    public void initTest(){
        this.fibonacci = new Fibonacci(fiboLength);
    }

    @org.junit.After
    public void afterTest() {
        this.fibonacci = null;
    }

    @org.junit.Test
    public void getN() {
        assertEquals(89, this.fibonacci.getN(11));
    }

    @org.junit.Test
    public void generateSequence() {
        assertArrayEquals(arrayFiboSequence, this.fibonacci.generateSequence());
    }
}