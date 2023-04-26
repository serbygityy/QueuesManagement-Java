package logic;



import dataModel.Client;

import java.util.ArrayList;
import java.util.List;
import dataModel.ClientQueue;


public class ShortestTimeStrategy implements Strategy{


    @Override
    public void addTask(List<ClientQueue> servers, Client t) {
        int minimum=Integer.MAX_VALUE;
        int i=0;
        for(int index=0;index<servers.size();index++){
            if(servers.get(index).getWaitingTime().intValue()<minimum){
                minimum=servers.get(index).getWaitingTime().intValue();
                i=index;
            }
        }
        servers.get(i).addClient(t);

    }
}
