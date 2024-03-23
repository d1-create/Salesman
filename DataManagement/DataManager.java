package DataManagement;

import java.util.ArrayList;

public class DataManager {
    //do all functions
    public static void DoAll(ArrayList<Integer> sales, ArrayList<String> names){
        ArrayList<Integer> CumulativeFreqList = new ArrayList<Integer>();
        BasicFormulae.AllBasicForm(sales,names);
        AdvancedFormulae.AdvancedAll(sales, names);
        CumulativeFreqList = AdvancedFormulae.CumFreq(sales, true);
        System.out.println(CumulativeFreqList + " Is the cumulative frequency list");
    }
    //basic min,max,avg - range (not median) formulas
    public class BasicFormulae{
        //functino to do all of the basic formale class functions
        public static void AllBasicForm(ArrayList<Integer> sales, ArrayList<String> names){
            Average(sales);
            Smallest(names, sales);
            Highest(names, sales);
        }
        //function to get average of sales
        public static void Average(ArrayList<Integer> sales){
            int sum = 0;
            try{
                for(int i=0;i<sales.size();i++){
                    sum+=sales.get(i);
                }
            }
            catch(Exception e){
                System.out.println("Error occured during arithmetic loop operation");
                e.printStackTrace();
            }
            finally{
                System.out.println("Calculated Average For Sales People\n Average:£" + sum);
            }
        }

        //function to get smallest value and print the smallest earner
        public static void Smallest(ArrayList<String> names,ArrayList<Integer> sales){
            int lowest = 10000000;
            int lowest_index = 0;  
            try{

                for(int i=0;i<sales.size();i++){
                    int sales_value_temp_var = sales.get(i);
                    if(sales_value_temp_var < lowest){
                        lowest = sales_value_temp_var;
                        lowest_index = i;
                    }
                    else{
                        ;
                    }
                }

            }
            catch(Exception e){
                System.out.println("Error: function finding minimum value contains error, look below");
                e.printStackTrace();
            }
            finally{
                System.out.println("The Lowest Earner is: " + names.get(lowest_index) + ", They made:£" + lowest);
            }
        }
        //function to get the highest value and print the highest earner
        public static void Highest(ArrayList<String> names,ArrayList<Integer> sales){
            int highest = 0;
            int highest_index = 0;
            try{
                for(int i=0;i<sales.size();i++){
                    int efficency_var_sales = sales.get(i);
                    if(efficency_var_sales > highest){
                        highest = efficency_var_sales;
                        highest_index = i;
                    }
                    else{
                        ;
                    }
                }
            }
            catch(Exception e){
                System.out.println("Error in Function - Finding highest value, look below for details ");
                e.printStackTrace();
            }
            finally{
                System.out.println("The Highest money bringer is:" + names.get(highest_index) + ", who made:£" + highest);
            }
        }
    }
    //Advanced formulas such as spearmans rank and standard deviation
    public class AdvancedFormulae{
        //Do all Advanced Formulae formulas and prin all of it out
        public static void AdvancedAll(ArrayList<Integer> sales, ArrayList<String> names){
            CumFreq(sales, false);
        }

        public static ArrayList<Integer> CumFreq(ArrayList<Integer> sales, boolean ReturnOnly){
            ArrayList<Integer> SortedList = new ArrayList<Integer>();
            int sum = 0;
            try{
                for(int i=0;i<sales.size();i++){
                    sum+=sales.get(i);
                    SortedList.add(sum);
                }
            }
            catch(Exception e){
                System.out.println("Unexpected Error in Cumulative Frequency, see error stack below");
                e.printStackTrace();
            }
            finally{
                if(ReturnOnly == true){
                    System.out.println("Below will show you the cumulative frequency");
                    for(int i=0; i<SortedList.size();i++){
                        System.out.print(SortedList.get(i) +",");
                    }
                }
            }
            return SortedList;
        }
    }
    //make graphs and formulas to visualise them (GUI?)
    public class Graphs{

    }
}
