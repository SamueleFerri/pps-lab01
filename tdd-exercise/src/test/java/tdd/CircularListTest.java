package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {
    SimpleCircularQueue circularQueue;
    private final static int MAX_LENGTH = 3;

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

    @Test
    public void testAddToTheFullCircularQueue(){
        int numAdded = 6;
        circularQueue.add(numAdded);
        assertEquals(numAdded, circularQueue.lastElement());
        assertEquals(MAX_LENGTH, circularQueue.size());
    }
}
