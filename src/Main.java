//imported code/java files
import FileManagement.FileManaging; //manage files module
import SalesManagement.SalesManaging; // manage sales management
import Basic.BasicFunc; // basic functions
import DataManagement.DataManager;
import Graphs.*;
import Data.Data.*;
//imported libs
import java.util.*;
public class Main{
    public static void main(String[] args){
        //create first variables
        Scanner input = new Scanner(System.in);
        boolean debug = Data.Data.GetDebug();
        //startup file managing
        FileManaging.Startup(Data.Data.GetDebug()); //do startup tasks
        FileManaging.ReadToFile.ReadFileToStringArr("names.txt", Data.Data.names_arr,debug); //Startup convert to array
        FileManaging.ReadToFile.ReadFileToIntegerArr("sales.txt", Data.Data.sales_arr,debug); //Startup convert to array
    
        int mode = SalesManaging.GetMenuMode(input,debug);//show menu and get mode

        //view salesman mode via the arrays
        if(mode==1){
            String name = BasicFunc.GetInput.getStringInput("Salesman Name: ", input,debug);
            SalesManaging.ViewSalesman(Data.Data.GetNames(), Data.Data.GetSales(), name,debug);
        }
        //Add salesman to file and list
        else if(mode==2){
            String Salesname = BasicFunc.GetInput.getStringInput("Salesman Name:", input,debug);
            int Sales = BasicFunc.GetInput.getIntInput("Money Made:", input,debug);
            SalesManaging.AddSalesman(Data.Data.GetNames(), Data.Data.GetSales(), Salesname, Sales,debug);
        }
        //Remove salesman to file and list and then reconstruct the lists with new information
        else if(mode==3){
            String Salesman = BasicFunc.GetInput.getStringInput("What salesman to remove from the list?", input,debug);
            int index = FileManaging.RemoveFromFile.GetIndexStrArr(Salesman, Data.Data.GetNames());
            SalesManaging.RemoveSalesman(Data.Data.GetNames(), Data.Data.GetSales(), Salesman, mode,debug);
            FileManaging.RemoveFromFile.RemoveIntFromFileUIndex(Data.Data.GetSales(), index, "sales.txt",debug);


            System.out.println("Reconstructing Database...");
            FileManaging.Startup(debug);
        }
        //get data and graphs from the whole of the sales database
        else if(mode==4){
            DataManager.DoAll(Data.Data.GetSales(), Data.Data.GetNames(),debug);
        }
        else if(mode==5){
            MainGraph.StartGUI(true);
        }
        
        input.close();
    }


}

