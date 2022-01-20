package jar;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class CreatorListAnimals {
    public static ArrayList<Animal> creatorListAnimals(String pathToAnimalsFile, ArrayList<Property> properties) {
        ArrayList<Animal> animals = new ArrayList<Animal>();
        try (Scanner input = new Scanner(new FileReader(new File(pathToAnimalsFile)))) {
            String animalProperties;
            while (input.hasNextLine()) {
                animalProperties = input.nextLine();
                String[] arrAnimalProperties = animalProperties.split(",");
                boolean isGoodAnimalStr = true;
                for (int i = 0; i < arrAnimalProperties.length; i++) {
                    isGoodAnimalStr &= properties.get(i).getAvailableValues().contains(arrAnimalProperties[i]);
                }
                if (isGoodAnimalStr) {
                    animals.add(new Animal(arrAnimalProperties));
                }
            }
        } catch (Exception ex) {

            System.out.println(ex.getMessage() + ex.getStackTrace());
        }
        return animals;
    }


}
