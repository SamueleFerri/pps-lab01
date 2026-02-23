package tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {
    @Test
    public void isTheDoorLocked() {
        SimpleSmartDoorLock smartDoor = new SimpleSmartDoorLock();
        assertTrue(smartDoor.isLocked());
    }
}
