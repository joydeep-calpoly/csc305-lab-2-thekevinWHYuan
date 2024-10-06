package taskTwo;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Driver {

    public static void main(String[] args) throws JsonProcessingException, IOException {
       final ObjectMapper mapper = new ObjectMapper();
       ArrayList<String> jsonFile = new ArrayList<>(Arrays.asList("CSC305_Lab_2/input1.json", "CSC305_Lab_2/input2.json", "CSC305_Lab_2/input3.json"));

       for (String files : jsonFile){
          Person value = mapper.readValue(new File(files), Person.class);
           System.out.println(value.getName() + "\n\n" + "Known For:\n\t" + String.join("\n\t", value.getKnownFor()) + "\n\nAwards:\n");
           for (int i = 0; i < value.getAwards().toArray().length; i++){
               System.out.println("\t" + value.getAwards().get(i).getName() + ", " + value.getAwards().get(i).getYear());
           }
           System.out.println("\n");
       }
    }
}
