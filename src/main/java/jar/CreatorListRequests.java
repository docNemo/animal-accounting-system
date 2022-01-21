package jar;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CreatorListRequests {
    private final static byte INDEX_TYPE_REQUEST = 0;
    private final static byte INDEX_NAME_PROPERTY = 0;
    private final static byte INDEX_BEGIN_PROPERTIES = 1;

    public static ArrayList<Rule[]> createListRules(String pathToFileRequest) {
        ArrayList<Rule[]> rules = new ArrayList<>();
        try (BufferedReader reader =  new BufferedReader(new InputStreamReader(new FileInputStream(pathToFileRequest)))) {
            while (reader.ready()) {
                String groupRuleString = reader.readLine();
                String[] groupRules = groupRuleString.split("\\|");
                Rule[] readyGroupsRule = new Rule[groupRules.length];

                for (int indexGroup = 0; indexGroup < groupRules.length; indexGroup++) {
                    String[] ruleStrings = groupRules[indexGroup].split(",");

                    boolean[] isNeg = new boolean[ruleStrings.length];
                    for (int indexRule = 0; indexRule < ruleStrings.length; indexRule++) {
                        if (ruleStrings[indexRule].startsWith("НЕ ")) {
                            isNeg[indexRule] = true;
                            ruleStrings[indexRule] = ruleStrings[indexRule].replace("НЕ ", "");
                        }
                    }
                    readyGroupsRule[indexGroup] = new Rule(isNeg, ruleStrings);
                }
                rules.add(readyGroupsRule);
            }
        } catch (Exception ex) {
            System.err.println("Ошибка при считывании правила");
        }
        return rules;
    }
}
