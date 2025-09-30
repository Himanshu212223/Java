# CRUD on JSON File using Jackson

We are using `Jackson` Library here.

Add Dependency on the `pom.xml` file.

```
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
```

Suppose we have the json file like below - 
```
[
  {
    "name" : "test1",
    "age" : 21
  },
  {
    "name" : "test2",
    "age" : 22
  }
]
```

## Read JSON File

We wants to read the json file and store it on Java like below - 
```
[{name=test1, age=21}, {name=test2, age=22}]
```

Hence, we need List of Lists where each List will have map <String, String> as key-value pair.

We can refer the below code -

```
String filePath = System.getProperty("user.dir") + "\\jsonData.json" ;

ObjectMapper mapper = new ObjectMapper() ;

List<Map<String, Object>> readJsonData = mapper.readValue(new File(filePath), new TypeReference<List<Map<String, Object>>>() {
});

System.out.println(readJsonData);
```



## Write JSON File

```
String filePath = System.getProperty("user.dir") + "\\jsonData.json" ;

ObjectMapper mapper = new ObjectMapper() ;

// Read the Existing File
List<Map<String, Object>> readJsonData = mapper.readValue(new File(filePath), new TypeReference<List<Map<String, Object>>>() {
});

System.out.println(readJsonData);

//  Write the content in the Existing File
Map<String, Object> newEntry = new HashMap<>() ;
newEntry.put("name", "test3") ;
newEntry.put("age" , 23) ;

readJsonData.add(newEntry) ;

mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), readJsonData);
```