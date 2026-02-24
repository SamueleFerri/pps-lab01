package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {
    SimpleMinMaxStack stack;

    @BeforeEach
    void beforeEach(){
        stack = new SimpleMinMaxStack();
    }

    @Test
    public void checkIfTheStackHasThreeElements(){
        assertEquals(3, stack.size());
    }

    @Test
    public void pushInTheStack(){
        int num = 4;
        stack.push(num);
        assertEquals(num, stack.peek());
    }

    @Test
    public void popFromTheStack(){
        assertEquals(3, stack.pop());
    }

    private void removeAllElementsFromTheStack(){
        int stackSize = stack.size();
        for(int i = 0; i < stackSize; i++){
            stack.pop();
        }
    }

    @Test
    public void stackShouldBeEmpty(){
        removeAllElementsFromTheStack();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void cannotPeekFromEmptyStack(){
        removeAllElementsFromTheStack();
        assertThrows(IllegalStateException.class, () -> stack.peek());
    }

    @Test
    public void cannotPopFromEmptyStack(){
        removeAllElementsFromTheStack();
        assertThrows(IllegalStateException.class, () -> stack.pop());
    }

    @Test
    public void shouldGetMaxOfTheStack(){
        int max = 999;
        stack.push(max);
        assertEquals(max, stack.getMax());
    }
}