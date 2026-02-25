package tdd;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class SimpleCircularQueue implements CircularQueue{
    List<Integer> circularQueue = new ArrayList<>(List.of(4,5,3));
    private final static int START_INDEX_OF_CIRCULAR_QUEUE = 0;

    @Override
    public void add(int number) {
        circularQueue.add(number);
    }

    @Override
    public int lastElement() {
        return circularQueue.get(circularQueue.size()-1);
    }

    @Override
    public void remove() {
        if(circularQueue.isEmpty()){
            throw new EmptyStackException();
        }
        circularQueue.remove(START_INDEX_OF_CIRCULAR_QUEUE);
    }

    @Override
    public int getFirst() {
        return circularQueue.get(START_INDEX_OF_CIRCULAR_QUEUE);
    }
}
