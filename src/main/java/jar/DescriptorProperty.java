package jar;

import java.util.ArrayList;

public class DescriptorProperty extends Property {

    private String pathToDescriptor;

    public DescriptorProperty() {
    }

    public DescriptorProperty(String name, String pathToDescriptor, ArrayList<String> availableValues) {
        super(name, availableValues);
        this.pathToDescriptor = pathToDescriptor;
    }

    public String getPathToDescriptor() {
        return this.pathToDescriptor;
    }
}
