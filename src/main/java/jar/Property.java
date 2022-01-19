package jar;

import java.util.ArrayList;

public class Property {
    String name;
    String pathToDescriptor;
    ArrayList<String> availableValues;

    public Property() {
    }

    public Property(String name, String pathToDescriptor, ArrayList<String> availableValues) {
        this.name = name;
        this.pathToDescriptor = pathToDescriptor;
        this.availableValues = availableValues;
    }
}
