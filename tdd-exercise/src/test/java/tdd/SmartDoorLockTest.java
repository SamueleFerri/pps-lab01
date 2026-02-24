package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {
    int doorPin = 1234;
    int wrongPin = 2345;
    SimpleSmartDoorLock smartDoor;

    @BeforeEach
    void beforeEach(){
        smartDoor = new SimpleSmartDoorLock();
    }

    @Test
    public void isTheDoorLocked() {
        assertFalse(smartDoor.isLocked());
    }

    @Test
    public void testTheDoorSetPin(){
        smartDoor.setPin(doorPin);
        smartDoor.lock();
        assertTrue(smartDoor.isLocked());
    }

    @Test
    public void doorCanBeUnlockedWithThePin(){
        smartDoor.setPin(doorPin);
        smartDoor.lock();
        smartDoor.unlock(doorPin);
        assertFalse(smartDoor.isLocked());
    }

    @Test
    public void doorCantBeUnlockedWithTheWrongPin(){
        smartDoor.setPin(doorPin);
        smartDoor.lock();
        smartDoor.unlock(wrongPin);
        assertTrue(smartDoor.isLocked());
    }

    @Test
    public void doorCanBeBlocked(){
        smartDoor.setPin(doorPin);
        smartDoor.lock();
        smartDoor.unlock(wrongPin);
        smartDoor.unlock(wrongPin);
        smartDoor.unlock(wrongPin);
        assertTrue(smartDoor.isBlocked());
    }

    @Test
    public void doorMaxAttemptsBeforeBlockStatement(){
        assertEquals(3, smartDoor.getMaxAttempts());
    }

    @Test
    public void theNumberOfFailedAttempts(){
        smartDoor.setPin(doorPin);
        smartDoor.lock();
        smartDoor.unlock(wrongPin);
        assertEquals(1, smartDoor.getFailedAttempts());
    }

    @Test
    public void theDoorCanBeResetAfterBlockStatement(){
        smartDoor.setPin(doorPin);
        smartDoor.lock();
        smartDoor.unlock(wrongPin);
        smartDoor.unlock(wrongPin);
        smartDoor.unlock(wrongPin);
        smartDoor.reset();
        assertFalse(smartDoor.isLocked());
        assertEquals(3, smartDoor.getMaxAttempts());
        assertEquals(0, smartDoor.getFailedAttempts());
    }

    @Test
    public void thePinCannotBeSetWithTheDoorClosed(){
        smartDoor.setPin(doorPin);
        smartDoor.lock();
        assertThrows(IllegalStateException.class, () -> smartDoor.setPin(doorPin));
    }
}
