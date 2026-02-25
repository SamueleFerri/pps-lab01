package tdd;

/**
 *  Task 3 - TDD for Circular Queue
 *  A simple CircularQueue that stores integers with a **fixed** capacity.
 *  When full, new elements overwrite the oldest ones.
 *  <br>
 *  When removing elements, the oldest ones are removed first.
 *  Therefore, giving [4, 5, 3], the first element to be removed is 4, then 5, and finally 3.
 *  <br>
 *  For the exercise: 
 *   - Think about the test cases you need to write.
 *   - Introduce methods in the interface in order to make the tests pass.
 *   - Refactor
 */
public interface CircularQueue {

    /**
     * Add new number in CircularQueue
     * If CircularQueue is full, first remove the oldest number, than add the new one
     * @param number The number to add
     */
    void add(int number);

    /**
     * Get last element of the CircularQueue
     * @return the last element
     */
    int lastElement();

    /**
     * Remove the oldest number if CircularQueue is not empty
     * If empty throw EmptyStackException
     */
    void remove();

    /**
     * Get the first element of the CircularQueue
     * @return the first element
     */
    int getFirst();

    /**
     * Get the size of the CircularQueue
     * @return the size
     */
    int size();
}