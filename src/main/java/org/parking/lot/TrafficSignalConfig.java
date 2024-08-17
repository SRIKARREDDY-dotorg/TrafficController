package org.parking.lot;

public class TrafficSignalConfig {
    private int redDuration;
    private int greenDuration;
    private int yellowDuration;
    private boolean emergencyPriority;

    public TrafficSignalConfig(int redDuration, int greenDuration, int yellowDuration, boolean emergencyPriority) {
        this.emergencyPriority = emergencyPriority;
        this.redDuration = redDuration;
        this.greenDuration = greenDuration;
        this.yellowDuration = yellowDuration;
    }

    public int getRedDuration() {
        return redDuration;
    }
    public int getGreenDuration() {
        return greenDuration;
    }
    public int getYellowDuration() {
        return yellowDuration;
    }
    public boolean isEmergencyPriority() {
        return emergencyPriority;
    }

    public void updateDurations(int redDuration, int greenDuration, int yellowDuration) {
        this.redDuration = redDuration;
        this.greenDuration = greenDuration;
        this.yellowDuration = yellowDuration;
    }
}
