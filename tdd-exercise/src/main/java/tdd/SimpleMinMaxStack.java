package tdd;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SimpleMinMaxStack implements MinMaxStack{
    List<Integer> stack = new ArrayList<>(List.of(1,2,3));

    public void push(int value) {
        stack.add(value);
    }

    @Override
    public int pop() {
        if(stack.isEmpty()){
            throw new IllegalStateException("The stack is empty");
        }
        int removedElement = stack.remove(stack.size()-1);
        return removedElement;
    }

    @Override
    public int peek() {
        if(stack.isEmpty()){
            throw new IllegalStateException("The stack is empty");
        }
        return stack.get(stack.size()-1);
    }

    @Override
    public int getMin() {
        return 0;
    }

    @Override
    public int getMax() {
        return stack.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow();
    }

    @Override
    public boolean isEmpty() {
        return stack.size() == 0;
    }

    @Override
    public int size() {
        return stack.size();
    }
}
