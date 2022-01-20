package jar;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class CreatorListProperties {
    private final static byte INDEX_NAME = 0;
    private final static byte INDEX_PATH_TO_DESCRIPTOR = 1;

    public static ArrayList<Property> createProperties(String pathToDescriptor) {
        ArrayList<Property> properties = new ArrayList<>();
        try (Scanner input = new Scanner(new FileReader(new File(pathToDescriptor)))) {
            String strParametersOfProperty;
            while (input.hasNextLine()) {
                strParametersOfProperty = input.nextLine();
                String[] parametersOfProperty = strParametersOfProperty.split("\\s");
                DescriptorProperty property = new DescriptorProperty(parametersOfProperty[INDEX_NAME],
                                                                     parametersOfProperty[INDEX_PATH_TO_DESCRIPTOR],
                                                                     readAvailableValues(parametersOfProperty[INDEX_PATH_TO_DESCRIPTOR]));
                properties.add(property);
            }
        } catch (Exception ex) {
            //TODO Logger
            System.out.println(ex.getMessage() + ex.getStackTrace());
        }
        return properties;
    }

    private static ArrayList<String> readAvailableValues(String pathToFileAvailableValues) {
        ArrayList<String> values = new ArrayList<String>();
        try (Scanner input = new Scanner(new FileReader(new File(pathToFileAvailableValues)))) {
            while (input.hasNextLine()) {
                values.add(input.nextLine());
            }
        } catch (Exception ex) {
            //TODO Logger

            System.out.println(ex.getMessage() + ex.getStackTrace());
        }
        return values;
    }
}
