package org.parking.lot;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // configuring the traffic light durations
        TrafficSignalConfig config = new TrafficSignalConfig(10, 7, 3, true);
        SignalController signalController = new SignalController(config);

        List<Sensor> sensors = new ArrayList<>();
        sensors.add(new Sensor(SensorType.TRAFFIC, "Intersection A"));
        sensors.add(new Sensor(SensorType.EMERGENCY, "Intersection A"));

        EmergencyHandler emergencyHandler = new EmergencyHandler(sensors);
        TrafficSignalSystem system =  TrafficSignalSystem.getInstance();
        system.setEmergencyHandler(emergencyHandler);
        system.setSensors(sensors);
        system.setSignalController(signalController);

        system.startSystem();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                system.stopSystem();
            }
        }, 60000);
    }
}