package FileManagement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.management.MXBean;

//BUGFIXED-CODE: TRUE
public class FileManaging {
    
    //on startup check for files and make them if not there
    public static void Startup(){

        try{
            File Names = new File("names.txt");
            File Sales = new File("sales.txt");
            if(Names.createNewFile()){
                System.out.println("Created names.txt");
            }
            else if(Sales.createNewFile()){
                System.out.println("Created sales.txt");
            }
            else{
                System.out.println("All necessary Files Exist - EXITING STARTUP TO MAIN PROGRAM");
            }
        }
        
        catch(IOException e){
            System.out.println("An Input/Output error occured");
            e.printStackTrace();
        }
        finally{
            System.out.println("System Startup Completed Sucessfully");
        }
    }
    //class with both functions to read a file into a list
    public class ReadToFile{
        //read file to an arraylist of strings
        public static void ReadFileToStringArr(String path, ArrayList<String> StringList){
            try{
                File Data = new File(path);

                Scanner FileScanner = new Scanner(Data);
                while (FileScanner.hasNextLine()) {
                    String buffer = FileScanner.nextLine();
                    StringList.add(buffer);
                }
                FileScanner.close();
            }
            catch (IOException e){
                System.out.println("File Error");
                e.printStackTrace();
            }
            finally{
                System.out.println("Read file to Arraylist (type string)");
            }
        }

        //read file to arraylist of integers
        public static void ReadFileToIntegerArr(String path, ArrayList<Integer> IntList){
        try{
            File Data = new File(path);

            Scanner FileScanner = new Scanner(Data);
            while (FileScanner.hasNextLine()) {
                String buffer = FileScanner.nextLine();
                IntList.add(Integer.parseInt(buffer));
            }
            FileScanner.close();
        }
        catch (IOException e){
            System.out.println("File Error");
            e.printStackTrace();
        }
        finally{
            System.out.println("Read file to Arraylist (type integer)");
        }
    }

}
    //add to file class with 2 types
    public class AddToFile{
    //add some sort of message to a file (append not overwrite file)
        public static void AddToFileStr(String path, String message, boolean ShouldAppend){
            try{
                File New_File = new File(path);
                FileWriter Writer = new FileWriter(New_File, ShouldAppend);
                Writer.append(message + "\n");
                Writer.close();
            }
            catch(IOException e){
                System.out.println("File error found!");
                e.printStackTrace();
            }
            finally{
                System.out.println("added to file");
            }
        }
        //add integer value to file
        public static void AddToFileInt(String path, int message, boolean ShouldAppend){
            try{
                File New_File = new File(path);
                FileWriter Writer = new FileWriter(New_File, ShouldAppend);
                Writer.append(message + "\n");
                Writer.close();
            }
            catch(IOException e){
                System.out.println("File error found!");
                e.printStackTrace();
            }
            finally{
                System.out.println("added to file");
            }
        }
}

    //remove a value from a file
    public class RemoveFromFile{
        //remove a string value from a file - TESTED WORKING
        public static void RemoveStrFromFile(ArrayList<String> arraystr, String name, String path){
            try{
                System.out.println("Starting File Insertion Removal");
                File file = new File(path);
                FileWriter Writer = new FileWriter(file, false);
                Writer.append("");
                Writer.close();
                FileWriter NewWriter = new FileWriter(file,true);
                String temp_buffer = "";
                for(int i=0;i<arraystr.size();i++){
                    temp_buffer = arraystr.get(i);
                    if(temp_buffer.equals(name)){
                        ;
                    }
                    else{
                        NewWriter.append(temp_buffer + "\n");
                    }
                }
                NewWriter.close();

            }
            catch(Exception e){
                System.out.println("Something went wrong - most likely an IOException");
                e.printStackTrace();
            }
            finally{
                System.out.println("Ended File Removal Insertion");
            }
        }

        public static void RemoveIntFromFile(ArrayList<Integer> arrayint, int value, String path){
            try{
                System.out.println("Starting File Insertion Removal");
                File file = new File(path);
                FileWriter Writer = new FileWriter(file, false);
                Writer.append("");
                Writer.close();
                FileWriter NewWriter = new FileWriter(file,true);
                int temp_buffer = 0;
                for(int i=0;i<arrayint.size();i++){
                    temp_buffer = arrayint.get(i);
                    if(temp_buffer == value){
                        ;
                    }
                    else{
                        NewWriter.append(temp_buffer + "\n");
                    }
                }
                NewWriter.close();

            }
            catch(Exception e){
                System.out.println("Something went wrong - most likely an IOException");
                e.printStackTrace();
            }
            finally{
                System.out.println("Ended File Removal Insertion");
            }
        }
    }
}
