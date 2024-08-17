package org.parking.lot;

import java.util.List;

public class EmergencyHandler {
    private List<Sensor> sensors;

    EmergencyHandler(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    public boolean isEmergencyDetected() {
        for (Sensor sensor : sensors) {
            if (sensor.detectEmergency()) {
                return true;
            }
        }
        return false;
    }
}
