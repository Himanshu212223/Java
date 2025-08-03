# Configuration on Eclipse to use Records

Since Records in Java was introduced as a preview feature in Java 14 and finalized in Java 16, are a concise way to declare data classes hence you should have atleast Java 16 as minimum version.

## 1. Make sure Java 16 is installed

In the Start menu search for `Command Prompt` and open it.

Then execute the below command - 
```
java -version
```

## 2. Ensure Eclipse knows about Java 16

In the Eclipse Go to: Window → Preferences → Java → Installed JREs

If Java 16 is not listed, click Add → select Standard VM → and point it to your JDK 16 install directory or above.

<!-- ![Eclipse](Screenshots/pic1.png)

![Eclipse](Screenshots/pic2.png)

![Eclipse](Screenshots/pic3.png) -->

## 3. Update your project settings

Right-click your project → Properties → Java Compiler

<!-- ![Eclipse](Screenshots/pic4.png) -->

Check "Enable project specific settings"

<!-- ![Eclipse](Screenshots/pic5.png) -->

And Set Compiler compliance level to 16

Hence Go to Java Build Path → Libraries and ensure your JRE System Library is Java 16

<!-- ![Eclipse](Screenshots/pic6.png)

![Eclipse](Screenshots/pic7.png)

![Eclipse](Screenshots/pic8.png) -->



A sample of `pom.xml` file will look like below - 

```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>learn</groupId>
  <artifactId>testing</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <packaging>jar</packaging>

  <name>testing</name>
  <url>http://maven.apache.org</url>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <!-- This is for maven compiler 16 or above 	-->
    <maven.compiler.source>16</maven.compiler.source>
    <maven.compiler.target>16</maven.compiler.target>
  </properties>

  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
  
  <!-- This is for Build -->
  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.8.1</version>
        <configuration>
          <source>16</source>
          <target>16</target>
        </configuration>
      </plugin>
    </plugins>
  </build>
  
</project>

```