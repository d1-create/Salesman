package Graphs;

import DataManagement.DataManager;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//main page generated with edited intellij code from it's gui builder
public class MainPage implements ActionListener {

    public JFrame mainframe = new JFrame();
    public JButton StandardDeviation;
    public JButton AveragesGraphButton;
    public JButton CumulativeFrequency;
    public JButton TODO;

    MainPage(){
        mainframe.setVisible(true);
        mainframe.setLayout(null);
        mainframe.setSize(600,600);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setResizable(true);
        mainframe.setLayout(new GridBagLayout());
        mainframe.getContentPane().setBackground(Color.DARK_GRAY);
        StandardDeviation = new JButton();
        StandardDeviation.setText("Standard Deviation Graph");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainframe.add(StandardDeviation, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainframe.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        mainframe.add(spacer2, gbc);
        AveragesGraphButton = new JButton();
        AveragesGraphButton.setText("Average Data Graph");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainframe.add(AveragesGraphButton, gbc);
        CumulativeFrequency = new JButton();
        CumulativeFrequency.setText("Cumulative Frequency Graph");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainframe.add(CumulativeFrequency, gbc);
        TODO = new JButton();
        TODO.setText("TODO");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainframe.add(TODO, gbc);
    }

    //TODO
    //create new windows if the buttons are pressed, with the text on them showing what button to press
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == StandardDeviation){
            StandardGraph standardGraph = new StandardGraph(DataManager.AdvancedFormulae.StandardDeviation(Data.Data.GetSales(),Data.Data.GetDebug()),Data.Data.GetSales());
        }
        if(event.getSource() == AveragesGraphButton){
            AveragesGraph averagesGraph = new AveragesGraph();
        }
        if(event.getSource() == CumulativeFrequency){
            CumulativeGraph cumulativeGraph = new CumulativeGraph();
        }
    }
}
