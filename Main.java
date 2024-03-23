//imported code/java files
import FileManagement.FileManaging; //manage files module
import SalesManagement.SalesManaging; // manage sales management
import Basic.BasicFunc; // basic functions

//imported libs
import java.util.*;
public class Main{

    //global variables
    public static ArrayList<String> names_arr = new ArrayList<String>();
    public static ArrayList<Integer> sales_arr = new ArrayList<Integer>();
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        //startup file managing
        FileManaging.Startup(); //do startup tasks
        FileManaging.ReadToFile.ReadFileToStringArr("names.txt", names_arr); //Startup convert to array
        FileManaging.ReadToFile.ReadFileToIntegerArr("sales.txt", sales_arr); //Startup convert to array
    
        int mode = SalesManaging.GetMenuMode(input);

        if(mode==1){
            String name = BasicFunc.GetInput.getStringInput("Salesman Name: ", input);
            SalesManaging.ViewSalesman(names_arr, sales_arr, name);
        }
        if(mode==2){
            String Salesname = BasicFunc.GetInput.getStringInput("Salesman Name:", input);
            int Sales = BasicFunc.GetInput.getIntInput("Money Made:", input);
            SalesManaging.AddSalesman(names_arr, sales_arr, Salesname, Sales);
        }



        
        input.close();
        //todo IN ORDER OF IMPORTANCE:
        /*
         * ALLOW USER TO ENTER IF THEY WANT TO ADD A SALESMAN
         * ALLOW USER TO ENTER IF THEY WANT TO REMOVE A SALESMAN
         * ALLOW USER TO ENTER IF THEY WANT TO SEE THE MIN,AVG,MAX SALESMAN AND VALUES
         */
    }
}
