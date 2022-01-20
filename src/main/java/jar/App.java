package jar;

import java.util.ArrayList;

/**
 *
 */
public class App {

    private final static String PATH_TO_DESCRIPTOR = "descriptors/descriptor1.txt";
    private final static String PATH_TO_ANIMAL_FILE = "animals/animals1.csv";
    private final static String PATH_TO_REQUEST_FILE = "requests/requests1.txt";

    public static void main(String[] args) {
        System.out.println("Hello World!");

        ArrayList<Property> properties = CreatorListProperties.createProperties(PATH_TO_DESCRIPTOR);

        ArrayList<Animal> animals = CreatorListAnimals.creatorListAnimals(PATH_TO_ANIMAL_FILE, properties);

        ArrayList<Request> requests = CreatorListRequests.createListRequest(PATH_TO_REQUEST_FILE, properties);

        int[] resultCounting = Counter.count(requests, animals);

        display(resultCounting, requests);
    }

    private static void display(int[] resultCounting, ArrayList<Request> requests) {
        for (int i = 0; i < resultCounting.length; i++) {
            StringBuilder str = new StringBuilder("");
            str.append(requests.get(i).getType())
                    .append("с параметрами - ");

            for (Property property : requests.get(i).getNeededProperties()) {
                str.append(property.getName()).append(property.getAvailableValues());
            }
            str.append(" = ").append(resultCounting[i]);
            System.out.println(str);
        }
    }
}
