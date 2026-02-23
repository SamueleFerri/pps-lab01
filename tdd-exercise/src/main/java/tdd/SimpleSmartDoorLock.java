package tdd;

public class SimpleSmartDoorLock implements SmartDoorLock{
    private static final int MAX_DOOR_PIN = 9999;
    private static final int MIN_DOOR_PIN = 999;
    private boolean isPinSet = false;
    private boolean locked;
    private int doorPin;

    @Override
    public void setPin(int pin) {
        if(!isLocked()){
            if(pin > MIN_DOOR_PIN && pin < MAX_DOOR_PIN){
                this.doorPin = pin;
                this.isPinSet = true;
            }
        }
    }

    @Override
    public void unlock(int pin) {

    }

    @Override
    public void lock() {
        if(isPinSet) {
            this.locked = true;
        }else {
            throw new IllegalStateException("PIN not set");
        }
    }

    @Override
    public boolean isLocked() {
        return this.locked;
    }

    @Override
    public boolean isBlocked() {
        return false;
    }

    @Override
    public int getMaxAttempts() {
        return 0;
    }

    @Override
    public int getFailedAttempts() {
        return 0;
    }

    @Override
    public void reset() {

    }
}
