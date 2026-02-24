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
}