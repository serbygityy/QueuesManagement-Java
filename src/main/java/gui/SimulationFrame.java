/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;



import java.awt.event.ActionListener;
import java.util.ArrayList;


public class SimulationFrame extends javax.swing.JFrame {


    public SimulationFrame() {
        initComponents();
    }


    @SuppressWarnings("unchecked")

    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        NrClientstxt = new javax.swing.JLabel();
        NrQueuestxt = new javax.swing.JLabel();
        SimulationTimetxt = new javax.swing.JLabel();
        MinMaxArrtxt = new javax.swing.JLabel();
        MinMaxSertxt = new javax.swing.JLabel();
        NrClients = new javax.swing.JTextField();
        NrQueues = new javax.swing.JTextField();
        SimTime = new javax.swing.JTextField();
        MinMaxArr = new javax.swing.JTextField();
        MinMaxSer = new javax.swing.JTextField();
        Result = new javax.swing.JTextField();
        StartButton = new javax.swing.JButton();
        Strategytxt = new javax.swing.JLabel();
        Strategy = new javax.swing.JComboBox<>();


        NrClientstxt.setText("Number of clients: ");
        NrQueuestxt.setText("Number of queues:");
        SimulationTimetxt.setText("Simulation time:");
        MinMaxArrtxt.setText("Min and max arrival time:");
        MinMaxSertxt.setText("Min and max service time:");
        StartButton.setText("START");
        Strategytxt.setText("Strategy: ");
        Strategy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Shortest Time", "Shortest Queue"}));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);









        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(Strategytxt, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(89, 89, 89)
                                                .addComponent(Strategy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(MinMaxSertxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(SimulationTimetxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(NrClientstxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(NrQueuestxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(MinMaxArrtxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(NrClients, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(NrQueues, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(SimTime, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(MinMaxArr, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(MinMaxSer, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addComponent(Result, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(25, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(StartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(103, 103, 103))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(70, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Result, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(NrClientstxt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(NrClients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(50, 50, 50)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(NrQueuestxt)
                                                        .addComponent(NrQueues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(36, 36, 36)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(SimulationTimetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(SimTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(30, 30, 30)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(MinMaxArrtxt)
                                                        .addComponent(MinMaxArr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(49, 49, 49)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(MinMaxSertxt)
                                                        .addComponent(MinMaxSer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(StartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Strategytxt)
                                        .addComponent(Strategy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19))
        );

        pack();

        this.setVisible(true);
    }
    public void addButtonAction(ActionListener actionListener){
        StartButton.addActionListener(actionListener);
    }



    public String getStrategy(){return this.Strategy.getSelectedItem().toString();}

    public void setTotalValueField(String resultField1) {
        this.Result.setText(resultField1);
    }



    String arrivalTime;
    String[] arrival;


    String serviceTime;
    String[] service;



    public ArrayList<Integer> getInput(){
        ArrayList<Integer> inputs = new ArrayList<>();
        inputs.add(Integer.parseInt(NrClients.getText()));
        inputs.add(Integer.parseInt(NrQueues.getText()));
        inputs.add(Integer.parseInt(SimTime.getText()));
        arrivalTime=MinMaxArr.getText();
        arrival=arrivalTime.split(",");
        inputs.add(Integer.parseInt(arrival[0]));
        inputs.add(Integer.parseInt(arrival[1]));
        serviceTime=MinMaxSer.getText();
        service=serviceTime.split(",");
        inputs.add(Integer.parseInt(service[0]));
        inputs.add(Integer.parseInt(service[1]));

        return inputs;
    }




    private javax.swing.JTextField MinMaxArr;
    private javax.swing.JLabel MinMaxArrtxt;
    private javax.swing.JTextField MinMaxSer;
    private javax.swing.JLabel MinMaxSertxt;
    private javax.swing.JTextField NrClients;
    private javax.swing.JLabel NrClientstxt;
    private javax.swing.JTextField NrQueues;
    private javax.swing.JLabel NrQueuestxt;
    private javax.swing.JTextField Result;
    private javax.swing.JTextField SimTime;
    private javax.swing.JLabel SimulationTimetxt;
    private javax.swing.JButton StartButton;
    private javax.swing.JComboBox<String> Strategy;
    private javax.swing.JLabel Strategytxt;
    private javax.swing.JTextField jTextField3;

}
