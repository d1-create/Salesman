//imported code/java files
import FileManagement.FileManaging; //manage files module
import SalesManagement.SalesManaging; // manage sales management
import Basic.BasicFunc; // basic functions

//imported libs
import java.util.*;
public class Main{

    //global variables
    public static ArrayList<String> names_arr = new ArrayList<String>(); //list of names updated from file
    public static ArrayList<Integer> sales_arr = new ArrayList<Integer>();//list of sales updated from file
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        //startup file managing
        FileManaging.Startup(); //do startup tasks
        FileManaging.ReadToFile.ReadFileToStringArr("names.txt", names_arr); //Startup convert to array
        FileManaging.ReadToFile.ReadFileToIntegerArr("sales.txt", sales_arr); //Startup convert to array
    
        int mode = SalesManaging.GetMenuMode(input);//show menu and get mode

        //view salesman mode via the arrays
        if(mode==1){
            String name = BasicFunc.GetInput.getStringInput("Salesman Name: ", input);
            SalesManaging.ViewSalesman(names_arr, sales_arr, name);
        }
        //Add salesman to file and list
        else if(mode==2){
            String Salesname = BasicFunc.GetInput.getStringInput("Salesman Name:", input);
            int Sales = BasicFunc.GetInput.getIntInput("Money Made:", input);
            SalesManaging.AddSalesman(names_arr, sales_arr, Salesname, Sales);
        }
        //Remove salesman to file and list
        if(mode==3){
            FileManaging.RemoveFromFile.RemoveIntFromFile(sales_arr, 1512, "sales.txt");
        }


        
        input.close();
        //todo IN ORDER OF IMPORTANCE:
        /*
         * ALLOW USER TO ENTER IF THEY WANT TO SEE THE MIN,AVG,MAX SALESMAN AND VALUES
         */
    }
}
