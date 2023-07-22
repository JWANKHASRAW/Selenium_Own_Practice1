package com.cydeo.utlilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {


    /*
in this class we will be creating the re-usable logic to read from configuration.properties file
 */

    //1- Create the Properties object (create object)
    // make it "private" so we are limiting access to the object.
    //"static" is to make sure its created and loaded before everything else, and it belongs to the class.

    private static Properties properties = new Properties();


    static {
        // we used static block so this will be the first one to run
        try { // we used the try catch to get rid of  IOException exception
            //2-open file using FileInputStream (open file)
            FileInputStream file = new FileInputStream("configuration.properties");
            //3- Load the "properties" object with "file" (load properties)

            // we can close the file in memory

            properties.load(file);
            file.close();

        } catch (IOException e) { //IO exception is an exception occur while reading or accessing file.
            e.printStackTrace();
            System.out.println("FILE NOT FOUND WITH GIVEN PATH!!!!");
        }



    }

    // create a utility method to use the object to read
    // 4- Use "properties" object to read from the file

    public static String getProperty(String keyword){

        return properties.getProperty(keyword);
    }

}
