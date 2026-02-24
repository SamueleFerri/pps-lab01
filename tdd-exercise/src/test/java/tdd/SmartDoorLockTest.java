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

    private void setPinAndLockTheDoor(){
        smartDoor.setPin(doorPin);
        smartDoor.lock();
    }

    @Test
    public void testTheDoorSetPin(){
        setPinAndLockTheDoor();
        assertTrue(smartDoor.isLocked());
    }

    @Test
    public void doorCanBeUnlockedWithThePin(){
        setPinAndLockTheDoor();
        smartDoor.unlock(doorPin);
        assertFalse(smartDoor.isLocked());
    }

    @Test
    public void doorCantBeUnlockedWithTheWrongPin(){
        setPinAndLockTheDoor();
        smartDoor.unlock(wrongPin);
        assertTrue(smartDoor.isLocked());
    }

    private void blockTheDoor(){
        int maxAttempts = smartDoor.getMaxAttempts();
        for (int i = 0; i < maxAttempts; i++) {
            smartDoor.unlock(wrongPin);
        }
    }

    @Test
    public void doorCanBeBlocked(){
        setPinAndLockTheDoor();
        blockTheDoor();
        assertTrue(smartDoor.isBlocked());
    }

    @Test
    public void doorMaxAttemptsBeforeBlockStatement(){
        assertEquals(3, smartDoor.getMaxAttempts());
    }

    @Test
    public void theNumberOfFailedAttempts(){
        setPinAndLockTheDoor();
        smartDoor.unlock(wrongPin);
        assertEquals(1, smartDoor.getFailedAttempts());
    }

    @Test
    public void theDoorCanBeResetAfterBlockStatement(){
        setPinAndLockTheDoor();
        blockTheDoor();
        smartDoor.reset();
        assertFalse(smartDoor.isLocked());
        assertEquals(3, smartDoor.getMaxAttempts());
        assertEquals(0, smartDoor.getFailedAttempts());
    }

    @Test
    public void thePinCannotBeSetWithTheDoorClosed(){
        setPinAndLockTheDoor();
        assertThrows(IllegalStateException.class, () -> smartDoor.setPin(doorPin));
    }

    @Test
    public void inTheBlockStatementTheDoorCannotBeOpened(){
        setPinAndLockTheDoor();
        blockTheDoor();
        assertThrows(IllegalStateException.class, () -> smartDoor.unlock(doorPin));
    }
}
