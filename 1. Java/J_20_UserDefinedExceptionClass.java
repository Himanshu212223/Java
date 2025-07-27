package learning;

class UserDefinedException extends Exception{
	public UserDefinedException(String message) {
		super(message);
	}
}

class InvalidString extends Exception{
	public InvalidString(String message) {
		super(message);
	}
}