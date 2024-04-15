package Graphs;

//TODO


import Data.Data;
import DataManagement.DataManager;

import org.knowm.xchart.*;

import java.util.ArrayList;


public class StandardGraph {
    public static void main_graph() {
        ArrayList<Integer> Localsales = Data.GetSales();
        ArrayList<String> Localnames = Data.GetNames();
        int needed_size = Localsales.size();
        double[] xseries = new double[needed_size];
        double[] yseries = new double[needed_size];
        for(int i : Localsales){
            xseries[i] = Localsales.get(i);
        }
        int cumulative_freq = 0;
        for(int i = 0;i<Localnames.size();i++){
            cumulative_freq++;
            yseries[i] = cumulative_freq;
        }



        float standard_deviation = DataManager.AdvancedFormulae.StandardDeviation(Data.GetSales(), Data.GetDebug());
        float mean = DataManager.BasicFormulae.Average(Data.GetSales(),Data.GetDebug());
        XYChart standard_chart = new XYChartBuilder().width(600).height(500).title("Standard Deviation Of Sales").xAxisTitle("Sales").yAxisTitle("Cumulative Frequency").build();
        standard_chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);
        standard_chart.addSeries("sales", xseries,yseries);
        new SwingWrapper(standard_chart).displayChart();
    }
}
