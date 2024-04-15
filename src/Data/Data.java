package Data;

import java.util.ArrayList;

public class Data {
    //store variables and get data from this method
        //global variables
        public static ArrayList<String> names_arr = new ArrayList<String>(); //list of names updated from file
        public static ArrayList<Integer> sales_arr = new ArrayList<Integer>();//list of sales updated from file
        public static boolean debug = false;
        public static ArrayList<Integer> GetSales(){
            return sales_arr;
        }

        public static ArrayList<String> GetNames() {
            return names_arr;
        }

        public static boolean GetDebug(){
            return debug;
        }
    }
