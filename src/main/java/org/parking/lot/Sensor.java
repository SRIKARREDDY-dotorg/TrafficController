package org.parking.lot;

public class Sensor {
    private String location;
    private SensorType type;

    Sensor(SensorType sensorType, String location) {
        this.location = location;
        this.type = sensorType;
    }

    public int detectTraffic() {
        // simulate the logic to detect traffic based on sensor type and location
        return (int) (Math.random() * 100);
    }

    public boolean detectEmergency() {
        // simulate the logic to detect emergency based on sensor type and location
        return Math.random() < 0.1;
    }
}
