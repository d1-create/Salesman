package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//get input with an input string and message
public class BasicFunc {
    public static String getStringInput(String message){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(message);
        String inputString = "";
        try {
            inputString = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputString;
    }
}
