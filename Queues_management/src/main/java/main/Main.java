package main;

import gui.SimulationFrame;
import logic.SimulationManager;

public class Main {
    public static void main(String[]args){
       SimulationManager manager=new SimulationManager();
        while(manager.getNbClients() == 0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Thread thread = new Thread(manager);
        thread.start();
    }
}

