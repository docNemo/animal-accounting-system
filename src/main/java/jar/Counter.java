package jar;

import java.util.ArrayList;

public class Counter {
    public static int[] count(ArrayList<Request> requests, ArrayList<Animal> animals) {
        int[] resultCounting = new int[requests.size()];
        int i;
        for (Animal animal : animals) {
            i = 0;
            for (Request request : requests) {
                boolean isRespond = true;
                for (Property property : request.getNeededProperties()) {
                    boolean isContains = false;
                    for (String parameter : animal.getProperties()) {
                        isContains |= property.getAvailableValues().contains(parameter);
                    }
                    if (!isContains) {
                        isRespond = false;
                        break;
                    }
                }
                if (isRespond) {
                    resultCounting[i]++;
                }
                i++;
            }
        }
        return resultCounting;
    }

}
