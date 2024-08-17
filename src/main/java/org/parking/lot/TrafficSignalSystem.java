package org.parking.lot;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TrafficSignalSystem {
    private static final TrafficSignalSystem instance = new TrafficSignalSystem();
    private SignalController signalController;
    private List<Sensor> sensors;
    private EmergencyHandler emergencyHandler;

    private TrafficSignalSystem() {
        // Private constructor to prevent instantiation from outside the class
    }

    public static TrafficSignalSystem getInstance() {
        return instance;
    }

    public void setSignalController(SignalController signalController) {
        this.signalController = signalController;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    public void setEmergencyHandler(EmergencyHandler emergencyHandler) {
        this.emergencyHandler = emergencyHandler;
    }

    public void startSystem() {
        signalController.startSignalCycle();
        monitorEmergency();
    }

    public void stopSystem() {
        signalController.stopSignalCycle();
    }

    private void monitorEmergency() {
        Timer emergencyTimer = new Timer();
        emergencyTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(emergencyHandler.isEmergencyDetected()) {
                    signalController.handleEmergency();
                }
            }
        }, 0, 10000);
    }
}
