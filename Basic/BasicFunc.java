package Basic;

import java.util.Scanner;

//get input with an input string and message
public class BasicFunc {
    public static String getStringInput(String message, Scanner sc){
        System.out.print(message);
        String inputString = "";

        inputString = sc.next();

        return inputString;
    }
}
