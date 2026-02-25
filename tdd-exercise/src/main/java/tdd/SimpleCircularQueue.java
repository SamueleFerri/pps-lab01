package tdd;

import java.util.ArrayList;
import java.util.List;

public class SimpleCircularQueue implements CircularQueue{
    List<Integer> circularQueue = new ArrayList<>(List.of(4,5,3));

    @Override
    public void add(int number) {
        circularQueue.add(number);
    }

    @Override
    public int lastElement() {
        return circularQueue.get(circularQueue.size()-1);
    }
}
