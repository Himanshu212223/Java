/*
	Reading Configuration Properties file :-
	_________________________________________________
	
	- Configuration Properties file stores all the data or messages (which can be error or success 
		message) which are going to used in the java program.
		These messages are stored in configuration properties files and are used whenever needed.
		
	How to make Configuration file and read its properties :-
	_______________________________________________________________
	
	- First of all, download the Jar files provided.
	
	Follow the following steps to add the external Jars :-
	RightClick on Project -> Build Path -> Configure BuildPath -> Libraries Tab -> ClassPath (if available) -> Add External Jars
	
	- Now, make the Configuration.properties file :-
	
	Follow the following steps to make the configuration file.
	
	RightClick on Project -> New -> Source Folder -> (give name as) resource.
	RightClick on resource folder -> New -> file -> (give name as) Configuration.properties.
	
	Now, in Configuration.properties file, give data  in key-value pair form.
*/

package PracticeFiles;

import java.util.Iterator;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;

public class ConfigurationWithProperties {
	public static void main(String [] args) throws Exception {

		Configurations configurations = new Configurations();
		PropertiesConfiguration config = configurations.properties("configuration.properties");
		
		System.out.println( config.getProperty("name") ) ;
		System.out.println( config.getProperty("password") ) ;
		System.out.println( config.getProperty("statement") ) ;
		
		//	to get all the keys present in configuration properties file.
		Iterator<String> keys = config.getKeys() ;
		while(keys.hasNext()) {
			System.out.println( keys.next() ) ;
		}
		
	}
	
}
