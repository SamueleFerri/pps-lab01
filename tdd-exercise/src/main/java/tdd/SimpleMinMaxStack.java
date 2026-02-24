package tdd;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SimpleMinMaxStack implements MinMaxStack{
    int[] stack = new int[]{1,2,3};

    public void push(int value) {

    }

    @Override
    public int pop() {
        return 0;
    }

    @Override
    public int peek() {
        return 0;
    }

    @Override
    public int getMin() {
        return 0;
    }

    @Override
    public int getMax() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return stack.length;
    }
}
