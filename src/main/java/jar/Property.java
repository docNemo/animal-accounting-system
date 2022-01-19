package jar;

import java.util.ArrayList;

public class Property {
    private String name;
    private String pathToDescriptor;
    private ArrayList<String> availableValues;

    public Property() {
    }

    public Property(String name, String pathToDescriptor, ArrayList<String> availableValues) {
        this.name = name;
        this.pathToDescriptor = pathToDescriptor;
        this.availableValues = availableValues;
    }

    public String getName() {
        return this.name;
    }

    public String getPathToDescriptor() {
        return this.pathToDescriptor;
    }

    public ArrayList<String> getAvailableValues() {
        return availableValues;
    }
}
