package logic;

import dataModel.Client;
import dataModel.ClientQueue;


import java.util.List;

public interface Strategy {
    public void addTask(List<ClientQueue>servers, Client t);

}
