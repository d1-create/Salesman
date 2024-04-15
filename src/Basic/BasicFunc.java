package Basic;

import java.util.Scanner;

//BUG-FIXED CODE: TRUE
//get input with an input string and message
public class BasicFunc {
    //class to Get input with a scanner - multiple types
    public class GetInput{
        public static String getStringInput(String message, Scanner sc, boolean debug){
            String TempString = "";
            try {
                System.out.print(message);

                TempString = sc.next();
            } 
            catch (Exception e) {
                System.out.println("Something wen't wrong while handling the input!");
                e.printStackTrace();
            }
            finally{
                if(debug == true){
                    System.out.println("Printed");
                }
            }
            return TempString;
        }


        public static int getIntInput(String message, Scanner sc, boolean debug){
            int TempVar = 0;
            try {
                System.out.print(message);

                TempVar = sc.nextInt();
            } 
            catch (Exception e) {
                System.out.println("Something wen't wrong while handling the input!");
                e.printStackTrace();
            }
            finally{
                if(debug ==true){
                    System.out.println("Printed");
                }
            }
            return TempVar;
        }
    }
}