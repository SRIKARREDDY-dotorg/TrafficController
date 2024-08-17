package org.parking.lot;

import java.util.Timer;
import java.util.TimerTask;

public class SignalController {
    private Signal currentSignal;
    private Timer timer;
    private TrafficSignalConfig config;

    public SignalController(TrafficSignalConfig config) {
        this.currentSignal = Signal.RED;
        this.config = config;
        this.timer = new Timer();
    }

    public void startSignalCycle() {
        changeSignal();
    }

    private void changeSignal() {
        System.out.println("Signal " + currentSignal);
        int duration = 0;
        switch (currentSignal) {
            case RED:
                duration = config.getRedDuration();
                currentSignal = Signal.GREEN;
                break;
            case GREEN:
                duration = config.getGreenDuration();
                currentSignal = Signal.YELLOW;
                break;
            case YELLOW:
                duration = config.getYellowDuration();
                currentSignal = Signal.RED;
                break;
        }

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                changeSignal();
            }
        }, duration*1000);
    }

    public void stopSignalCycle() {
        timer.cancel();
    }

    public void adjustTimings(int red, int yellow, int green) {
        this.config.updateDurations(red, green, yellow);
    }

    public void handleEmergency() {
        System.out.println("Emergency mode activated all signals are in red");
        stopSignalCycle();
        currentSignal = Signal.RED;
        System.out.println("Signal " + currentSignal);
        try {
            Thread.sleep(config.getRedDuration()*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.timer = new Timer();
        startSignalCycle();
    }
}
