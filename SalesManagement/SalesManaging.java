package SalesManagement;

import FileManagement.FileManaging;

import java.util.ArrayList;
import java.util.Scanner;

public class SalesManaging {
    //get the mode from this function
    public static int GetMenuMode(Scanner sc){
        try{
            System.out.println("1-View Salesman\n2-Add Salesman\n3-Remove Salesman\n4-Salesman Data Overview\n");
            int buffer_mode = 0;

            System.out.println("Mode must be above 0 and below 5, Enter below");
            if(sc.hasNextInt()){
                buffer_mode = sc.nextInt();
            }

            if(buffer_mode>4 || buffer_mode<1){
                System.out.println("MODE OUT OF BOUNDS, QUITTING APPLICATION");
                System.exit(0);
            }
            return buffer_mode;
        }
        finally{
            System.out.println("\nMode Captured\n");
        }
    }

    //view a salesman 
    public static void ViewSalesman(ArrayList<String> names_list,ArrayList<Integer> sales_list, String name){
        try{
            //create a string and parse through the for loop until the name is hit and print the data out while updating if it is found via the temp boolean
            String list_data_chosen = "";
            Boolean TEMP_VAR_found = false;
            for(int i=0;i<names_list.size();i++){

                list_data_chosen = names_list.get(i);

                if(list_data_chosen.equals(name)){
                    System.out.println("Salesman Name: " + names_list.get(i) + "\nSalesman Sales: " + sales_list.get(i));
                    TEMP_VAR_found = true;
                }
            }

            if(TEMP_VAR_found == false){
                System.out.println("\n\n ERROR: Salesman not found, Mabye you didn't use a capital letter?");
            }
            
        }
        finally{
            System.out.println("Viewed Salesman");
        }

    }

    //add a salesman by going through and adding a name and it's earning and amd adding it to the file
    public static void AddSalesman(ArrayList<String> names_list,ArrayList<Integer> sales_list, String Name, int Earnings){
        names_list.add(Name);
        sales_list.add(Earnings);
        FileManaging.AddToFile.AddToFileStr("names.txt",Name,true);
        FileManaging.AddToFile.AddToFileInt("sales.txt",Earnings,true);
    }


    
}
