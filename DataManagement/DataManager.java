package DataManagement;

import java.util.ArrayList;

public class DataManager {
    public class BasicFormulae{
        public static void AllBasicForm(ArrayList<Integer> sales){
            Average(sales);
        }
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
                System.out.println("Calculated Average For SalesPeople\n Average:£" + sum);
            }
        }
    }
}
