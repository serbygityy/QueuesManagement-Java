package logic;

import dataModel.Client;
import dataModel.ClientQueue;
import gui.SimulationFrame;
import java.lang.Math;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import static java.lang.Thread.sleep;

public class SimulationManager implements Runnable{
    private Scheduler scheduler;
    private Integer simulationTime = 0;
    private Integer nbClients = 0;
    private Integer nbQueues = 0;
    private int minArrival = 0;
    private int maxArrival = 0;
    private int minService = 0;
    private int maxService = 0;
    private AtomicInteger time = new AtomicInteger(0);
    private SimulationFrame simulationFrame;
    private ArrayList<Client> newClients = new ArrayList<>();
    private BufferedWriter writer;
    private int totalService = 0;
    SelectionPolicy policy = null;



    public SimulationManager(){
        try{
            File file = createFile();
            writer = new BufferedWriter(new FileWriter(file.getName()));
        }catch(IOException e){
            e.printStackTrace();
        }
       simulationFrame=new SimulationFrame();
        simulationFrame.addButtonAction(new ButtonPressed());


    }


    public Integer getNbClients() {
        return nbClients;
    }

    public void setValues(ArrayList<Integer> inputs){
        this.nbClients = inputs.get(0);
        this.nbQueues = inputs.get(1);
        this.simulationTime = inputs.get(2);
        this.minArrival = inputs.get(3);
        this.maxArrival = inputs.get(4);
        this.minService = inputs.get(5);
        this.maxService = inputs.get(6);
        scheduler = new Scheduler(nbQueues);
        String strategy = simulationFrame.getStrategy();

        if (strategy.equals("Shortest Queue")) {
            policy = SelectionPolicy.SHORTEST_QUEUE;

        } else if (strategy.equals("Shortest Time")) {
            policy = SelectionPolicy.SHORTEST_TIME;
        }

    }

    public void generateClients() {

        int minA = minArrival;
        int maxA = maxArrival;
        int minS = minService;
        int maxS = maxService;

        for(int i = 1; i <= nbClients; i++) {
            int arrival = (int) (Math.random()*(maxA-minA)+minA);
            System.out.println(arrival);
            int service = (int) (Math.random()*(maxS-minS)+minS);
            System.out.println(service);
            newClients.add(new Client(i, arrival, service));
            totalService += service;
        }
    }

    public int calculateAverageWaiting(){
        int waiting = 0;
        for(ClientQueue cq : scheduler.getServers()){
            waiting += cq.getTotalWaiting().intValue();
        }
        return waiting / nbQueues;
    }

    public File createFile() throws IOException {
        File file = new File("Test3.txt");
        boolean created = file.createNewFile();
        if(created){
            System.out.println("File created");
        }else{
            System.out.println("File already exists");
        }
        return file;
    }

    public void writeFile(String string){
        try{
            writer.write(string);
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println(string);
        simulationFrame.setTotalValueField(string);
    }

    public void writeSimDetails(int peakHour){
        String string;
        string = "Average waiting time: " + calculateAverageWaiting() + "\n";
        writeFile(string);
        string = "Average service time: " + totalService / nbClients + "\n";
        writeFile(string);
        string = "Peak hour: " + peakHour;
        writeFile(string);
    }

    public void closeWriter(){
        try {
            writer.flush();
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void printWaitingClients(){
        String string;
        if(newClients.size() > 0){
            string = "Waiting clients: ";
            writeFile(string);
        }

        for(int i = 0; i < newClients.size(); i++){
            if(newClients.get(i).getArrival() <= time.intValue()){

                System.out.println(policy);
                scheduler.changeStrategy(policy,newClients.get(i));
                newClients.remove(newClients.get(i));
            }
        }

        for(Client c : newClients){
            string = c.toString() + ", ";
            writeFile(string);
        }
        writeFile("\n");
    }

    @Override
    public void run() {
        generateClients();
        String string;
        int peakHour = 0, maxNbActiveClients = 0, currentClients = 0;
        while(time.intValue() < simulationTime){

            string = "\nTime: " + time.toString() + "\n";
            writeFile(string);
            printWaitingClients();

            for(ClientQueue cq : scheduler.getServers()){
                currentClients += cq.currentClients();
            }
            if(currentClients > maxNbActiveClients){
                maxNbActiveClients = currentClients;
                peakHour = time.intValue();
            }
            currentClients = 0;

            writeFile(scheduler.toString());

            try{
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time.getAndIncrement();
        }
        if(newClients.isEmpty() || time.intValue() > simulationTime){
            writeSimDetails(peakHour);
        }
        closeWriter();
        System.exit(0);
    }

    public class ButtonPressed implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Starting simulation...");
            ArrayList<Integer> inputs =simulationFrame.getInput();
            setValues(inputs);
        }
    }

}