package Basic;

import java.util.Scanner;

//get input with an input string and message
public class BasicFunc {
    public class GetInput{
        public static String getStringInput(String message, Scanner sc){
            System.out.print(message);
            String inputString = "";

            inputString = sc.next();

            return inputString;
        }

        public static int getIntInput(String message, Scanner sc){
            System.out.print(message);
            int TempVar = 0;

            TempVar = sc.nextInt();

            return TempVar;
        }
    }
}
