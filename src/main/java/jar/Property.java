package jar;

import java.util.ArrayList;

public class Property {
    private String name;
    private ArrayList<String> availableValues;

    public Property() {
    }

    public Property(String name, ArrayList<String> availableValues) {
        this.name = name;
        this.availableValues = availableValues;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<String> getAvailableValues() {
        return availableValues;
    }
}
