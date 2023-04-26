package logic;


import dataModel.Client;
import dataModel.ClientQueue;




import java.util.ArrayList;
import java.util.List;


public class Scheduler {

    private final List<ClientQueue> servers=new ArrayList<>();
    private final List<Thread> threads=new ArrayList<>();


    Strategy strategy;


    public Scheduler(int maxNoServers)  {
        System.out.println(maxNoServers);
        for(int i=1;i<=maxNoServers;i++){
            ClientQueue queue=new ClientQueue(i);
            servers.add(queue);
            Thread thread=new Thread(queue);
            threads.add(thread);
            thread.start();

                }
            }



    public void changeStrategy(SelectionPolicy policy, Client t){

        if(policy==SelectionPolicy.SHORTEST_TIME){
            strategy=new ShortestTimeStrategy();
            strategy.addTask(servers,t);
        }
        if(policy==SelectionPolicy.SHORTEST_QUEUE){
            strategy=new ShortestQueueStrategy();
            strategy.addTask(servers,t);
        }



    }

    @Override
    public String toString() {
        String printed = "";
        for(ClientQueue cq : servers){
            printed += cq.toString() + '\n';
        }
        printed += "\n";
        return printed;
    }

    public List<ClientQueue> getServers(){
        return servers;
    }

}
