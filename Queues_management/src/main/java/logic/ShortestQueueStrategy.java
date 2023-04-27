package logic;

import dataModel.Client;
import dataModel.ClientQueue;

import java.util.ArrayList;
import java.util.List;

public class ShortestQueueStrategy implements Strategy{



    @Override
    public void addTask(List<ClientQueue> servers, Client t) {
        int minimum=Integer.MAX_VALUE;
        int i=0;
        for(int index=0;index<servers.size();index++){
            if(servers.get(index).getClients().size()<minimum){
                minimum=servers.get(index).getClients().size();
                i=index;
            }
        }
        servers.get(i).addClient(t);
    }
}
