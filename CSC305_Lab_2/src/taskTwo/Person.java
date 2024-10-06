package taskTwo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Person {


    private String name;
    private ArrayList<String> knownFor;
    private ArrayList<Award> awards;

    @JsonCreator
    public Person(@JsonProperty("name") String name, @JsonProperty("knownFor") ArrayList<String> knownFor, @JsonProperty("awards") ArrayList<Award> awards){
        this.name = name;
        this.knownFor = (ArrayList<String>)knownFor.clone();
        this.awards = (ArrayList<Award>) awards.clone();
    }

    public static class Award {

        private String name;
        private int year;

        public String getName() {
            return name;
        }

        public int getYear() {
            return year;
        }

        @JsonCreator
        public Award(@JsonProperty("name") String name, @JsonProperty("year") int year){
            this.name = name;
            this.year = year;
        }


    }

    public String getName() {
        return name;
    }

    public ArrayList<Award> getAwards() {
        return awards;
    }

    public ArrayList<String> getKnownFor() {
        return knownFor;
    }
}
