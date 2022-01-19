package jar;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class CreatorListAnimals {
    public static ArrayList<Animal> creatorListAnimals(String pathToAnimalsFile, ArrayList<Property> properties) {
        ArrayList<Animal> animals = new ArrayList<Animal>();
        try (Scanner input = new Scanner(new File(pathToAnimalsFile))) {
            String animalProperties;
            while(input.hasNextLine()) {
                animalProperties = input.nextLine();
                String[] arrAnimalProperties = animalProperties.split("\\s");
                for (int i = 0; i  <arrAnimalProperties.length; i++) {
                    if (!properties.get(i).getAvailableValues().contains(arrAnimalProperties[i])) {
                        throw new Exception("Bad animal properties string");
                    }
                    animals.add(new Animal(arrAnimalProperties));
                }
            }
        }
        catch (Exception ex) {

        }
        return animals;
    }
}
