package jar;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreatorListRequests {
    private final static byte INDEX_TYPE_REQUEST = 0;
    private final static byte INDEX_NAME_PROPERTY = 0;
    private final static byte INDEX_BEGIN_PROPERTIES = 1;

    public static ArrayList<Request> createListRequest(String pathToFileRequest, ArrayList<Property> properties) {
        ArrayList<Request> requests = new ArrayList<Request>();
        try (Scanner input = new Scanner(new FileReader(new File(pathToFileRequest)))) {
            String requestString;
            while (input.hasNextLine()) {
                requestString = input.nextLine();

                String[] blocksRequest = requestString.split("\\|");//First block is type request, others - properties
                ArrayList<Property> requestProperties = null;
                ArrayList<String> availableParameters = new ArrayList<String>();
                for (int i = INDEX_BEGIN_PROPERTIES; i < blocksRequest.length; i++) {
                    requestProperties = new ArrayList<Property>();
                    String[] blocksProperties = blocksRequest[i].split(":");//First block is name property, others - parameters of property

                    boolean isFirstModSetProperties = true;
                    for (String parameter : blocksProperties[1].split(",")) {
                        if (!parameter.startsWith("НЕ")) {
                            availableParameters.add(parameter);
                        } else {
                            if (isFirstModSetProperties) {
                                availableParameters = (ArrayList<String>) properties.clone();
                                isFirstModSetProperties = false;
                            }
                            availableParameters.remove(parameter);
                        }
                    }

                    requestProperties.add(new Property(blocksProperties[INDEX_NAME_PROPERTY],
                            availableParameters));

                }
                requests.add(new Request(blocksRequest[INDEX_TYPE_REQUEST], requestProperties));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + ex.getLocalizedMessage());
        }
        return requests;
    }
}
