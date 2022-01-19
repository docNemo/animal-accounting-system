package jar;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{

    private final static String PATH_TO_DESCRIPTOR = "descriptors/descriptor1.txt";
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        ArrayList<Property> properties = CreatorProperties.createProperties(PATH_TO_DESCRIPTOR);


    }
}
