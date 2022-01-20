package jar;

import java.util.ArrayList;

public class Request {
    private String type;
    private ArrayList<Property> neededProperties;

    public Request() {
    }

    public Request(String type, ArrayList<Property> neededProperties) {
        this.type = type;
        this.neededProperties = neededProperties;
    }

    public String getType() {
        return type;
    }

    public ArrayList<Property> getNeededProperties() {
        return neededProperties;
    }
}
