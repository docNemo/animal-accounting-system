package jar;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class CreatorListProperties {
    private final static byte INDEX_NAME = 1;
    private final static byte INDEX_PATH_TO_DESCRIPTOR = 2;

    public static ArrayList<Property> createProperties(String pathToDescriptor) {
        ArrayList<Property> properties = new ArrayList<>();
        try (Scanner input = new Scanner(new File(pathToDescriptor))) {
            String strParametersOfProperty;
            while (input.hasNextLine()) {
                strParametersOfProperty = input.nextLine();
                String[] parametersOfPropery = strParametersOfProperty.split("\\s");
                Property property = new Property(parametersOfPropery[INDEX_NAME],
                                                 parametersOfPropery[INDEX_PATH_TO_DESCRIPTOR],
                                                 readAvailableValues(parametersOfPropery[INDEX_PATH_TO_DESCRIPTOR]));
                properties.add(property);
            }
        } catch (Exception ex) {
            //TODO Logger
        }
        return properties;
    }

    private static ArrayList<String> readAvailableValues(String pathToFileAvailableValues) {
        ArrayList<String> values = new ArrayList<String>();
        try (Scanner input = new Scanner(new File(pathToFileAvailableValues))) {
            while (input.hasNextLine()) {
                values.add(input.nextLine());
            }
        } catch (Exception ex) {
            //TODO Logger
        }
        return values;
    }
}
