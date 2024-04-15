package Graphs;

import DataManagement.DataManager;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class MainGraph {
        public static void SeeAllGraphs(ArrayList<Integer> Sales, boolean debug){
            float average = DataManager.BasicFormulae.Average(Sales, debug);
            double standard_deviation = DataManager.AdvancedFormulae.StandardDeviation(Sales, debug);
            ArrayList<Integer> CumFreq = DataManager.AdvancedFormulae.CumFreq(Sales, debug);

            //frame
            JFrame mainframe = new JFrame();
            mainframe.setVisible(true);
            mainframe.setResizable(true);
            mainframe.setSize(800,800);
            mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainframe.setLayout(null);
            mainframe.getContentPane().setBackground(Color.BLACK);
            //object
            JButton CumFreqButton = new JButton();
            //object properties
            StyleButtonBasic(Color.LIGHT_GRAY,"Cumulative Frequency Graph",10,10,240,40,CumFreqButton);
            CumFreqButton.addActionListener(Cumulativefreq -> System.out.println("Pressed Cumulative Frequency graph"));
            //add to frame
            mainframe.add(CumFreqButton);
        }

        public static void StyleButtonBasic(Color color,String text,int xco,int yco,int width,int height,JButton button){
            button.setText(text);
            button.setBounds(xco,yco,width,height);
            button.setVisible(true);
            button.setFocusable(false);
            button.setBackground(color);
        }
}
