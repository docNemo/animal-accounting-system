package jar;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CreatorListAnimals {
    public static ArrayList<String[]> creatorListAnimals(String pathToAnimalsFile) {
        ArrayList<String[]> animals = new ArrayList<>();
        try (BufferedReader reader =  new BufferedReader(new InputStreamReader(new FileInputStream(pathToAnimalsFile)))) {
            String animalProperties;
            while (reader.ready()) {
                animalProperties = reader.readLine();
                String[] animal = animalProperties.split(",");
                animals.add(animal);
            }
        } catch (Exception ex) {
            System.err.println("Ошибка при считывании животного");
        }
        return animals;
    }


}
