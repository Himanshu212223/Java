# We will try to read JSON File data and store it in class object.

Suppose we have a json file at path - `C:\Users\<user>\eclipse-workspace\project\Data\User.json`

Below is the data on the json file - 
```
[
    {
        "email" : "user1@gmail.com",
        "password" : "akjerlkwer",
        "name" : "user1"
    },
    {
        "email" : "user2@gmail.com",
        "password" : "akjerlkwer",
        "name" : "user2"
    },
    {
        "email" : "user3@gmail.com",
        "password" : "akjerlkwer",
        "name" : "user3"
    },
    {
        "email" : "user4@gmail.com",
        "password" : "akjerlkwer",
        "name" : "user4"
    }
]
```

Below is the code will help - 

```
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.io.FileInputStream;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;




//	-------- Class to store JSON Data into its objects ----------------
class User {
	private String email ;
	private String password ;
	private String name ;
	
	public String getEmail() {
		return this.email ;
	}
	
	public void setEmail(String email) {
		this.email = email ;
	}
	
	public String getPassword() {
		return this.password ;
	}
	
	public void setPassword(String password) {
		this.password = password ;
	}
	
	public String getName() {
		return this.name ;
	}
	
	public void setName(String name) {
		this.name = name ;
	}
	
	public String getUser() {
		return "name : " + this.name + ", email : " + this.email + ", password : " + this.password ;
	}
}








//	----------------- Main Class ----------------------

public class Main {
	
		
	public static void main(String args[]) throws Exception {
		
		//	Json File path
		final String path = System.getProperty("user.dir") + "\\Data\\User.json" ;
		
		System.out.println(path);
		
		//	InputStream to read file
		InputStream inputStream = new FileInputStream(path);
		
        //  Object Mapper to map(convert) json to object or object to json.
		ObjectMapper objMapper = new ObjectMapper();
		
        //  Store object mapper or null in optional
		Optional<List<User>> optUserList = Optional.ofNullable(objMapper.readValue(inputStream, new TypeReference<List<User>>() {})) ;
		
		if(optUserList.isPresent()) {
			List<User> userList = (List<User>) optUserList.get();
			System.out.println(userList.get(2).getUser());			
		}
		else {
			throw new Exception("null found");
		}
		
	}
	
}

```