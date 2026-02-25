package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {
    SimpleCircularQueue circularQueue;

    @BeforeEach
    void beforeEach(){
        circularQueue = new SimpleCircularQueue();
    }

    @Test
    public void testAddToTheCircularQueue(){
        int num = 6;
        circularQueue.add(num);
        assertEquals(num, circularQueue.lastElement());
    }
}
