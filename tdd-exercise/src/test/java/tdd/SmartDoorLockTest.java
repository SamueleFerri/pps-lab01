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
}
