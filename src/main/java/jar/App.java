package jar;

import java.util.ArrayList;

/**
 *
 */
public class App {

    private final static String PATH_TO_ANIMAL_FILE = "src/animals/animals.1000000.csv";
    private final static String PATH_TO_REQUEST_FILE = "src/rules/rules1.txt";

    public static void main(String[] args) {
        long timeStart = System.nanoTime();

        ArrayList<String[]> animals = CreatorListAnimals.creatorListAnimals(PATH_TO_ANIMAL_FILE);

        ArrayList<Rule[]> rules = CreatorListRequests.createListRules(PATH_TO_REQUEST_FILE);

        int[] resultCounting = Counter.count(rules, animals);

        display(resultCounting, rules);

        long timeFinish = System.nanoTime();

        System.out.println("Время выполения " + ((timeFinish) - timeStart) / 1000 + " нс");
    }

    private static void display(int[] resultCounting, ArrayList<Rule[]> rules) {
        for (int i = 0; i < resultCounting.length; i++) {
            Rule[] group = rules.get(i);

            StringBuilder str = new StringBuilder();

            for (Rule rule : group) {
                for (int indexWord = 0; indexWord < rule.getWords().length; indexWord++) {
                    if (indexWord != 0) {
                        str.append(",");
                    }
                    if (rule.isNeg()[indexWord]) {
                        str.append("НЕ ");
                    }
                    str.append(rule.getWords()[indexWord]);
                }
                if (group.length > 1) {
                    str.append("|");
                }
            }

            str.append(" = ").append(resultCounting[i]);
            System.out.println(str);
        }
    }
}
