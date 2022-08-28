import java.io.*;  
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;  

public class ObjectToJson {  
        public static void main(String[] a)  
        {  
            // Creating object of Users  
            DataHandler data = new DataHandler();  
            // Inserting the data into the object  
            data = getObjectData(data);  
            // Creating Object of ObjectMapper define in Jackson API  
            ObjectMapper obj = new ObjectMapper();  
            try {  
                // Converting the Java objects into a JSON file  
                obj.writeValue(new file("converted.json"), data);
            }  
            catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        // 
  /*Dependency for fasterxml library
  <dependencies>
  <dependency>
  <groupId>com.fasterxml.jackson.core</groupId>
  <certificateId>jackson-databind</certificateId>
  <version>2.9.8</version>
  <dependency>
  </dependencies>*/
  
}  
