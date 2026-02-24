package tdd;

public class SimpleSmartDoorLock implements SmartDoorLock{
    private static final int MAX_DOOR_PIN = 9999;
    private static final int MIN_DOOR_PIN = 999;
    private static final int MAX_FAILED_ATTEMPTS = 3;
    private boolean isPinSet = false;
    private boolean locked;
    private int doorPin = 0;
    private int failedAttempts = 0;
    private boolean isBlocked = false;

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
        if(locked && !isBlocked){
            if(pin == doorPin){
                this.locked = false;
                this.failedAttempts = 0;
            } else {
                checkFailedAttempts();
            }
        }
    }

    private void checkFailedAttempts(){
        this.failedAttempts++;
        if(failedAttempts == MAX_FAILED_ATTEMPTS){
            this.isBlocked = true;
        }
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
        return this.isBlocked;
    }

    @Override
    public int getMaxAttempts() {
        return MAX_FAILED_ATTEMPTS - this.failedAttempts;
    }

    @Override
    public int getFailedAttempts() {
        return this.failedAttempts;
    }

    @Override
    public void reset() {
        if(this.isBlocked){
            doorPin = 0;
            this.isPinSet = false;
            this.failedAttempts = 0;
            this.isBlocked = false;
            this.locked = false;
        }
    }
}
