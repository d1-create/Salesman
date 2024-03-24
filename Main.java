//imported code/java files
import FileManagement.FileManaging; //manage files module
import SalesManagement.SalesManaging; // manage sales management
import Basic.BasicFunc; // basic functions
import DataManagement.DataManager;

//imported libs
import java.util.*;
public class Main{
    //debug
    public static boolean debug = false;
    //global variables
    public static ArrayList<String> names_arr = new ArrayList<String>(); //list of names updated from file
    public static ArrayList<Integer> sales_arr = new ArrayList<Integer>();//list of sales updated from file
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        //startup file managing
        FileManaging.Startup(debug); //do startup tasks
        FileManaging.ReadToFile.ReadFileToStringArr("names.txt", names_arr,debug); //Startup convert to array
        FileManaging.ReadToFile.ReadFileToIntegerArr("sales.txt", sales_arr,debug); //Startup convert to array
    
        int mode = SalesManaging.GetMenuMode(input,debug);//show menu and get mode

        //view salesman mode via the arrays
        if(mode==1){
            String name = BasicFunc.GetInput.getStringInput("Salesman Name: ", input,debug);
            SalesManaging.ViewSalesman(names_arr, sales_arr, name,debug);
        }
        //Add salesman to file and list
        else if(mode==2){
            String Salesname = BasicFunc.GetInput.getStringInput("Salesman Name:", input,debug);
            int Sales = BasicFunc.GetInput.getIntInput("Money Made:", input,debug);
            SalesManaging.AddSalesman(names_arr, sales_arr, Salesname, Sales,debug);
        }
        //Remove salesman to file and list and then reconstruct the lists with new information
        else if(mode==3){
            String Salesman = BasicFunc.GetInput.getStringInput("What salesman to remove from the list?", input,debug);
            int index = FileManaging.RemoveFromFile.GetIndexStrArr(Salesman, names_arr);
            SalesManaging.RemoveSalesman(names_arr, sales_arr, Salesman, mode,debug);
            FileManaging.RemoveFromFile.RemoveIntFromFileUIndex(sales_arr, index, "sales.txt",debug);


            System.out.println("Reconstructing Database...");
            FileManaging.Startup(debug);
        }
        //get data and graphs from the whole of the sales database
        else if(mode==4){
            DataManager.DoAll(sales_arr, names_arr,debug);
        }
        
        input.close();
        //todo IN ORDER OF IMPORTANCE:
        /*
         * ALLOW USER TO ENTER IF THEY WANT TO SEE THE MIN,AVG,MAX SALESMAN AND VALUES (BEING DONE)
         * COMMENTS
         * READABILITY
         */
    }
}