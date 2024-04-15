package Graphs;

import DataManagement.DataManager;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainGraph {
        //Print out a debug notice and start the main menu
        public static void StartGUI(boolean debug){
            if(debug) {
                System.out.println("starting Launch Page");
            }
            MainPage mainPage = new MainPage();
        }

        //LATER
        public static void GetData(ArrayList<Integer> Sales, boolean debug){
            float average = DataManager.BasicFormulae.Average(Sales, debug);
            double standard_deviation = DataManager.AdvancedFormulae.StandardDeviation(Sales, debug);
            ArrayList<Integer> CumFreq = DataManager.AdvancedFormulae.CumFreq(Sales, debug);


        }


}
