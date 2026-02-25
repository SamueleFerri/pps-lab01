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
    public void testRemoveFromTheCircularQueue(){
        int numRemoved = 5;
        circularQueue.remove();
        assertEquals(numRemoved, circularQueue.getFirst());
    }

    @Test
    public void testAddToTheCircularQueueNotFull(){
        circularQueue.remove();
        int numAdded = 6;
        circularQueue.add(numAdded);
        assertEquals(numAdded, circularQueue.lastElement());
    }

}
