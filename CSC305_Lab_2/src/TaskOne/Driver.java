package TaskOne;


import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Driver {

    public static void main(String[] args) throws IOException, JSONException {
        ArrayList<String> jsonFile = new ArrayList<>(Arrays.asList("CSC305_Lab_2/input1.json", "CSC305_Lab_2/input2.json", "CSC305_Lab_2/input3.json"));
        ArrayList<Person> parsedList = Processor.processFile(jsonFile);
        Processor.printResult(parsedList);
    }
}
