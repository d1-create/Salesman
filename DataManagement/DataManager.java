package DataManagement;

import java.util.ArrayList;

public class DataManager {
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
}
