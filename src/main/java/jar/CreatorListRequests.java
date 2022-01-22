package jar;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CreatorListRequests {
    private final static String NEGATE = "НЕ ";

    public static List<Rule[]> createListRules(String pathToFileRequest) {
        ArrayList<Rule[]> rules = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(pathToFileRequest)))) {
            while (reader.ready()) {
                String groupRuleString = reader.readLine();
                String[] groupRules = groupRuleString.split("\\|");
                Rule[] readyGroupsRule = new Rule[groupRules.length];

                for (int indexGroup = 0; indexGroup < groupRules.length; indexGroup++) {
                    String[] ruleStrings = groupRules[indexGroup].split(",");

                    boolean[] isNeg = new boolean[ruleStrings.length];
                    for (int indexRule = 0; indexRule < ruleStrings.length; indexRule++) {
                        if (ruleStrings[indexRule].startsWith(NEGATE)) {
                            isNeg[indexRule] = true;
                            ruleStrings[indexRule] = ruleStrings[indexRule].replace(NEGATE, "");
                        }
                    }
                    readyGroupsRule[indexGroup] = new Rule(isNeg, ruleStrings);
                }
                rules.add(readyGroupsRule);
            }
        } catch (IOException ex) {
            System.err.println("Ошибка при считывании правила: " + ex);
        }
        return rules;
    }
}
