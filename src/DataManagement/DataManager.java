package DataManagement;

import java.util.ArrayList;

public class DataManager {
    //do all functions except for graphs and GUI
    public static void DoAll(ArrayList<Integer> sales, ArrayList<String> names, boolean debug){
        BasicFormulae.AllBasicForm(sales,names,debug);
        AdvancedFormulae.AdvancedAll(sales, names,debug);
    }
    //basic min,max,avg - range (not median) formulas
    public static class BasicFormulae{
        //functino to do all of the basic formale class functions
        public static void AllBasicForm(ArrayList<Integer> sales, ArrayList<String> names, boolean debug){
            Average(sales,debug);
            Smallest(names, sales);
            Highest(names, sales);
            Range(sales);
        }
        //function to get average of sales
        public static float Average(ArrayList<Integer> sales, boolean debug){
            int sum = 0;
            float average = 0;
            try{
                for(int i=0;i<sales.size();i++){
                    sum+=sales.get(i);
                }
                average = ((float) sum /sales.size());
            }
            catch(Exception e){
                System.out.println("Error occured during arithmetic loop operation");
                e.printStackTrace();
            }
            finally{
                if(debug){
                    System.out.println("Calculated Average Sales");
                }
                System.out.println("\n Average:£" + sum);
            }
            return average;
        }
        

        //function to get the smallest value and print the smallest earner
        public static int Smallest(ArrayList<String> names,ArrayList<Integer> sales){
            int lowest = 10000000;
            int lowest_index = 0;  
            try{

                for(int i=0;i<sales.size();i++){
                    int sales_value_temp_var = sales.get(i);
                    if(sales_value_temp_var < lowest){
                        lowest = sales_value_temp_var;
                        lowest_index = i;
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
            return lowest;
        }
        //function to get the highest value and print the highest earner
        public static int Highest(ArrayList<String> names,ArrayList<Integer> sales){
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
            return highest;
        }
        //get the range of values and print it out
        public static int Range(ArrayList<Integer> sales){
            int highest = 0;
            int lowest = 100000000;
            try{
                int temp_value_storage;
                for(int i=0;i<sales.size();i++){
                    temp_value_storage = sales.get(i);
                    if(temp_value_storage > highest){
                        highest = temp_value_storage;
                    }
                    if(temp_value_storage < lowest){
                        lowest = temp_value_storage;
                    }
                }
            }
            catch(Exception e){
                    System.out.println("Error happened in Range - Data Analyst ");
                    e.printStackTrace();
            }
                finally{
                    System.out.println("The Range of values is:£" + (highest-lowest));
            }
            return (highest-lowest);
        
        }
    }
    //Advanced formulas such as spearmans rank and standard deviation
    public static class AdvancedFormulae{
        //Do all Advanced Formulae formulas and prin all of it out
        public static void AdvancedAll(ArrayList<Integer> sales, ArrayList<String> names, boolean debug){
            CumFreq(sales, debug);
            StandardDeviation(sales,debug);
        }

        public static ArrayList<Integer> CumFreq(ArrayList<Integer> sales, boolean debug){
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
                if(debug){
                    System.out.println("Below will show you the cumulative frequency");
                    for(int i=0; i<SortedList.size();i++){
                        System.out.print(SortedList.get(i) +",");
                    }
                }
            }
            return SortedList;
        }

        //Checked and tested standard Deviation Function
        public static float StandardDeviation(ArrayList<Integer> sales,boolean debug){
            float standard_deviation = 0.0F;
            float mean = 0.0F;
            try{
                //create average
                float num_values = sales.size();
                float sum = 0F;
                for(int i=0;i<sales.size();i++){
                    sum+=sales.get(i);
                }
                mean = (sum/num_values);
                //get variance
                float variance = 0.0F;
                float variance_sum_var = 0.0F;
                for(int i=0;i<sales.size();i++){
                    float a = (sales.get(i) - mean);
                    a = (float) Math.pow(a, 2);
                    variance_sum_var+=a;
                }
                variance = (variance_sum_var/num_values);
                standard_deviation = (float) Math.sqrt(variance);
            }
            catch(Exception e){
                System.out.println("Below find an error relatedf to the standard deviation formula");
                e.printStackTrace();
            }
            finally{
                mean = Math.round(mean);
                standard_deviation = Math.round(standard_deviation);
                System.out.println("The Standard Deviation approximately is: " + standard_deviation + " And the mean is around: " + mean);
                if(debug==true){
                    System.out.println(". This means that 68% of all values lie between " + (mean-standard_deviation) + " and " + (mean+standard_deviation));
                }
            }
            return standard_deviation;
        }
    }

    }