package TaskOne;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Processor {

    public static void printResult(ArrayList<Person> people){
        for (Person person : people){
            System.out.println(person.getName() + "\n\n" + "Known For:\n\t" + String.join("\n\t", person.getKnownFor()) + "\n\nAwards:\n");
            for (int i = 0; i < person.getAwards().toArray().length; i++){
                System.out.println("\t" + person.getAwards().get(i).getName() + ", " + person.getAwards().get(i).getYear());
            }
            System.out.println("\n");
        }
    }

   public static ArrayList<Person> processFile(List<String> fileNames) throws IOException, JSONException {
        ArrayList<Person> personList = new ArrayList<>();
        for (String files: fileNames){
            String data = Files.readString(Path.of(files));
            JSONObject jsonData = new JSONObject(data);
            personList.add(processPerson(jsonData, processKnownFor(jsonData), processAwards(jsonData)));
        }
        return personList;
    }

    private static ArrayList<Award> processAwards(JSONObject data) throws JSONException {
        JSONArray arrayList = data.getJSONArray("awards");
        ArrayList<Award> storeAward = new ArrayList<>();
        for (int i = 0; i < arrayList.length(); i++){
            Award createAward = new Award(arrayList.getJSONObject(i).getString("name"), arrayList.getJSONObject(i).getInt("year"));
            storeAward.add(createAward);
        }
        return storeAward;
    }

    private static ArrayList<String> processKnownFor(JSONObject data) throws JSONException {
        JSONArray knownFor = data.getJSONArray("knownFor");
        ArrayList<String> knownForList = new ArrayList<>();
        for (int i = 0; i < knownFor.length(); i++){
            knownForList.add(knownFor.getString(i));
        }
        return knownForList;

    }

    private static Person processPerson(JSONObject data, ArrayList<String> knownFor, ArrayList<Award> awards) throws JSONException{
       return new Person(data.getString("name"), awards, knownFor);
    }


}
