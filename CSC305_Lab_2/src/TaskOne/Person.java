package TaskOne;

import java.util.ArrayList;
import java.util.List;

class Person {

    private String name;
    private ArrayList<Award> awards;
    private ArrayList<String> knownFor;

    Person(String name, ArrayList<Award> awards, ArrayList<String> knownFor){
        this.name = name;
        this.awards = (ArrayList<Award>) awards.clone();
        this.knownFor = (ArrayList<String>)knownFor.clone();
    }

    public String getName() {
        return name;
    }

    public List<Award> getAwards() {
        return (List<Award>) awards.clone();
    }

    public List<String> getKnownFor() {
        return (List<String>) knownFor.clone();
    }

}

