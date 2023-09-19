/*
	Log4j :-
	_____________________
	
	- Log4j is open source framework that help us to store logs on storage 
		medium in particular readable format.
		
	- Components of Log4j are :-
	 	Logger Class		//	Help to send logs in logger file.
	 	Appender Class		//	Tells the source of the file where to store logs.
	 	Layout Class		//	tells the pattern of logging, it is inside the appender.
	 	
	How to configure the Log4j2 ....?
	___________________________________________
	
	To configure the Log4j2 with eclipse, first of all, we have to add the jar files of logger.
	
	Follow the following steps to add the external Jars :-
	RightClick on Project -> Build Path -> Configure BuildPath -> Libraries Tab -> ClassPath (if available) -> Add External Jars

	To change the properties and working of Logger, we have to define its properties in Log4j2.properties file, follow these steps :-
	RightClick on Project -> New -> Source Folder -> (give name as) resource.
	RightClick on resource folder -> New -> file -> (give name as) Log4j2.properties.
	
	- The log4j.properties file is a log4j configuration file which stores properties in key-value pairs.
	- It contains the entire runtime configuration used by log4j.
	- By default, the LogManager searches for a file named log4j.properties in 
		the CLASSPATH, that's why, we define the properties file in classPath.
	- Write the log4j2.properties file by provided code.
	
	
*/


package PracticeFiles ;
import org.apache.logging.log4j.*;

public class LoggingWithLog4j{
	
	public static Logger log = LogManager.getLogger(LoggingWithLog4j.class);
	
	public static void main(String [] args) throws Exception {
		log.trace("This has 1st priority.");
		log.debug("This has 2nd priority.");
		log.info("This has 3rd priority.");
		log.warn("This has 4th priority.");
		log.error("This has 5th priority.");
		log.fatal("This has 6th priority.");
		
 	}
}