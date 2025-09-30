# CRUD on JSON File using Simple JSON

We are using `SimpleJSON` Library here.

Add Dependency on the `pom.xml` file.

```
<dependency>
    <groupId>com.googlecode.json-simple</groupId>
    <artifactId>json-simple</artifactId>
    <version>1.1</version>
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
List<Map<String, Object>> jsonFileDataList = new LinkedList<>() ;

        //  File Path
        String filePath = System.getProperty("user.dir") + "\\jsonData.json" ;

        FileReader file = new FileReader(filePath) ;

        JSONParser parser = new JSONParser() ;

        //  Read the JSON File
        Object obj = parser.parse(file) ;

        //  Since the current JSON content is an Array of Object, so store it on JSONArray
        JSONArray jsonArray = (JSONArray) obj;

        for(Object object : jsonArray){
            JSONObject jsonObject = (JSONObject) object;

            Map<String, Object> tempMap = new HashMap<>() ;

            for(Object key : jsonObject.keySet()){
                tempMap.put((String) key, jsonObject.get(key)) ;
            }

            jsonFileDataList.add(tempMap) ;
        }



        System.out.println(jsonFileDataList);

```



## Write JSON File

```
        List<Map<String, Object>> jsonFileDataList = new LinkedList<>() ;

        //  File Path
        String filePath = System.getProperty("user.dir") + "\\jsonData.json" ;

        FileReader file = new FileReader(filePath) ;

        JSONParser parser = new JSONParser() ;

        //  Read the JSON File
        Object obj = parser.parse(file) ;

        //  Since the current JSON content is an Array of Object, so store it on JSONArray
        JSONArray jsonArray = (JSONArray) obj;

        for(Object object : jsonArray){
            JSONObject jsonObject = (JSONObject) object;

            Map<String, Object> tempMap = new HashMap<>() ;

            for(Object key : jsonObject.keySet()){
                tempMap.put((String) key, jsonObject.get(key)) ;
            }

            jsonFileDataList.add(tempMap) ;
        }


        //  ------------------ Add Data on the same JSON File --------------------------------
        /*
            Since we have read the json file in jsonFileDataList, lets add new data on the map.
        */

        Map<String, Object> tempObj = new HashMap<>() ;

        tempObj.put("name", "test3") ;
        tempObj.put("age", 23) ;

        jsonFileDataList.add(tempObj) ;

        //  Create an array for JSON
        JSONArray newJSONArray = new JSONArray() ;

        //  now iterate on the jsonDataList and convert it into JSON Object and add it into Json Array.
        for(Map<String, Object> tempMap : jsonFileDataList){
            //  Store the Map data into JSON Object
            JSONObject newJSONObject = new JSONObject();
            newJSONObject.putAll(tempMap);

            //  add the JSON Object into JSON Array
            newJSONArray.add(newJSONObject);
        }

        FileWriter fileWriter = new FileWriter(filePath) ;

        fileWriter.write(newJSONArray.toJSONString());

        fileWriter.flush();
```