package SalesManagement;

import FileManagement.FileManaging;

import java.util.ArrayList;
import java.util.Scanner;

//BUG-FIXED CODE: TRUE
public class SalesManaging {
    //get the menu mode from this function
    public static int GetMenuMode(Scanner sc, boolean debug){
        try{
            System.out.println("1-View Salesman\n2-Add Salesman\n3-Remove Salesman\n4-Salesman Data Overview\n5-See Graph(GUI)");
            int buffer_mode = 0;

            System.out.println("Mode must be above 0 and below 6, Enter below");
            if(sc.hasNextInt()){
                buffer_mode = sc.nextInt();
            }

            if(buffer_mode>5 || buffer_mode<1){
                System.out.println("MODE OUT OF BOUNDS, QUITTING APPLICATION");
                System.exit(0);
            }
            return buffer_mode;
        }
        finally{
            if(debug==true){
            System.out.println("\nMode Captured\n");
            }
        }
    }

    //view a salesman 
    public static void ViewSalesman(ArrayList<String> names_list,ArrayList<Integer> sales_list, String name, boolean debug){
        try{
            //create a string and parse through the for loop until the name is hit and print the data out while updating if it is found via the temp boolean
            String list_data_chosen = "";
            Boolean TEMP_VAR_found = false;
            for(int i=0;i<names_list.size();i++){

                list_data_chosen = names_list.get(i);

                if(list_data_chosen.equals(name)){
                    System.out.println("Salesman Name: " + names_list.get(i) + "\nSalesman Sales:£" + sales_list.get(i));
                    TEMP_VAR_found = true;
                }
            }

            if(TEMP_VAR_found == false){
                System.out.println("\n\n ERROR: Salesman not found, Mabye you didn't use a capital letter?");
            }
            
        }
        finally{
            if(debug==true){
                System.out.println("Viewed Salesman");
            }
        }

    }

    //add a salesman by going through and adding a name and it's earning and amd adding it to the file
    public static void AddSalesman(ArrayList<String> names_list,ArrayList<Integer> sales_list, String Name, int Earnings,boolean debug){
        try{
            names_list.add(Name);
            sales_list.add(Earnings);
            FileManaging.AddToFile.AddToFileStr("names.txt",Name,true);
            FileManaging.AddToFile.AddToFileInt("sales.txt",Earnings,true);
        }
        catch(Exception e){
            System.out.println("Error occured when Adding Salesman: Most likely file error");
            e.printStackTrace();
        }
        finally{
            if(debug==true){
            System.out.println("Added New SalesPerson!");
            }
        }
    }

    //remove a salesman by going to the Remove from file function
    public static void RemoveSalesman(ArrayList<String> names, ArrayList<Integer> sales, String name, int Earnings,boolean debug){
        try{
            for(int i=0;i<names.size();i++){
                FileManaging.RemoveFromFile.RemoveStrFromFile(names, name, "names.txt",debug);
                FileManaging.RemoveFromFile.RemoveIntFromFile(sales,Earnings,"sales.txt",debug);
            }
        }
        catch(Exception e){
            System.out.println("ERROR occured when removing a salesman, please look at the stack trace below");
            e.printStackTrace();
        }
        finally{
            if(debug==true){
                System.out.println("Removed a salesman");
            }
        }
    }
    
}
