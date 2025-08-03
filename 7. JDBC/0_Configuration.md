# How to Install MySQL ..?

We can download the mysql server locally using link - https://dev.mysql.com/downloads/installer/

Now, find the MySQL server downloaded file from `C:\Program Files\MySQL\MySQL Server 8.0\bin` etc, copy the file location and store it on System Environment Variables path.

Now, to run the mysql server, open cmd and use the below command-

```
mysql -u root -p
```

If you want to run the mysql server on different port, open cmd and use below command-

```
mysql -u root -p --port=8624
```

## Configure the Jar file on Maven Project

Download the Jar file from - https://dev.mysql.com/downloads/connector/j/


Choose the Platform Independent ZIP version → Extract the downloaded file → look for mysql-connector-java-8.0.xx.jar

Add this on you Java-Maven Project (Right click on project → Build Path → Configure Build Path → Java Build Path → Select Classpath → Click `Add External Jar` → search that jar file and add it).


## Run the mySQL before executing the Java Code

Run the mysql server, open cmd and use the below command-

```
mysql -u root -p
```

If you want to run the mysql server on different port, open cmd and use below command-

```
mysql -u root -p --port=8624
```

In mysql terminal run the below queries to create Database → Create Table → Insert Data into it.

```
CREATE DATABASE testdb;

USE testdb;

CREATE TABLE students (
    roll_no INT PRIMARY KEY,
    name VARCHAR(100)
);

INSERT INTO students VALUES (1, 'Alice'), (2, 'Bob');

```


## Java Code to use JDBC

```
package learn.testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App 
{
    public static void main( String[] args )
    {
    	String url = "jdbc:mysql://localhost:3306/testdb"; // your DB URL
        String user = "root"; // your DB username
        String password = "root"; // your DB password

        try {
            // Step 1: Load JDBC Driver (optional in newer Java versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Create a Connection
            Connection conn = DriverManager.getConnection(url, user, password);

            // Step 3: Create and Execute a Query
            String sql = "SELECT * FROM students";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            // Step 4: Process the Result
            while (rs.next()) {
                int rollNo = rs.getInt("roll_no");
                String name = rs.getString("name");
                System.out.println("Roll No: " + rollNo + ", Name: " + name);
            }

            // Step 5: Close Resources
            rs.close();
            stmt.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database error");
            e.printStackTrace();
        }
    }
}

```