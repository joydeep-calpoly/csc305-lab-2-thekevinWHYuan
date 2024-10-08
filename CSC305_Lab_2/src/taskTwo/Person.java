package taskTwo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

class Person {


    private String name;
    private ArrayList<String> knownFor;
    private ArrayList<Award> awards;

    @JsonCreator
    private Person(@JsonProperty("name") String name, @JsonProperty("knownFor") ArrayList<String> knownFor, @JsonProperty("awards") ArrayList<Award> awards){
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
        private Award(@JsonProperty("name") String name, @JsonProperty("year") int year){
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
