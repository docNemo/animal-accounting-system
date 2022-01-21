package jar;

import java.util.ArrayList;

public class Counter {
    public static int[] count(ArrayList<Rule[]> rules, ArrayList<String[]> animals) {
        int[] resultCounting = new int[rules.size()];

        for (String[] animal : animals) {
            int indexGroupRule = 0;
            for (Rule[] groupRule : rules) {
                boolean isRespond = true;

                for (Rule rule : groupRule) {
                    int i = 0;
                    while ((i < rule.getWords().length) && (!contains(animal, rule.getWords()[i]) ^ rule.isNeg()[i])) {
                        i++;
                    }
                    if (i >= rule.getWords().length) {
                        isRespond = false;
                        break;
                    }
                }
                if (isRespond) {
                    resultCounting[indexGroupRule]++;
                }
                indexGroupRule++;
            }
        }
        return resultCounting;
    }

    private static boolean contains(String[] strings, String string) {
        int i = 0;
        while (i < strings.length && !strings[i].equals(string)) {
            i++;
        }
        return i < strings.length;
    }

}
