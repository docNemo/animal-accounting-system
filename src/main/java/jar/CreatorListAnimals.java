package jar;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CreatorListAnimals {
    public static List<String[]> creatorListAnimals(String pathToAnimalsFile) {
        ArrayList<String[]> animals = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(pathToAnimalsFile)))) {
            String animalProperties;
            while (reader.ready()) {
                animalProperties = reader.readLine();
                String[] animal = animalProperties.split(",");
                animals.add(animal);
            }
        } catch (IOException ex) {
            System.err.println("Ошибка при считывании животного: " + ex);
        }
        return animals;
    }
}
