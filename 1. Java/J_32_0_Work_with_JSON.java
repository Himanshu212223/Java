/*
    JSON in Java -
    ___________________________________________________________________________________________

    Java doesn’t have built-in JSON handling, but there are popular libraries:

    1. Jackson (most widely used, very fast)
    2. Gson (by Google, simple & lightweight)
    3. org.json (basic but less powerful)

    1. Jackson library -
    -------------------------------------
    Dependency -
    ------------
    <!-- Jackson Dependency -->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-core</artifactId>
            <version>2.15.0</version>
        </dependency>

        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-annotations</artifactId>
            <version>2.15.0</version>
        </dependency>

        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.15.0</version>
        </dependency>

        
*/



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;




public class J_32_0_Work_with_JSON {
    public static void main(String[] args) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        // Convert Object to JSON String

        Student s1 = new Student("Alice", 22);
        String json = mapper.writeValueAsString(s1);
        System.out.println("Object to JSON: " + json);

        // Convert JSON String back to Object

        String jsonData = "{\"name\":\"Bob\",\"age\":25}";
        Student s2 = mapper.readValue(jsonData, Student.class);
        System.out.println("JSON to Object: " + s2.name + ", " + s2.age);

    }
}