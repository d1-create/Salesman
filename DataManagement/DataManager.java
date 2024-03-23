package DataManagement;

import java.util.ArrayList;

public class DataManager {
    public class BasicFormulae{
        //functino to do all of the basic formale class functions
        public static void AllBasicForm(ArrayList<Integer> sales, ArrayList<String> names){
            Average(sales);
            Smallest(names, sales);
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
                    if(sales.get(i) < lowest){
                        lowest = sales.get(i);
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
    }
}
