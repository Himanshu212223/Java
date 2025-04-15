package com.Testing;

public class MethodsForTesting {
	// Method-1
	public int addNumbers(int numb1, int numb2) {
		int result = numb1 + numb2;
		return result;
	}

	// Method-2
	public boolean checkAge(int age) {
		if (age > 0 && age < 120) {
			return true;
		} else {
			return false;
		}
	}

	// Method-3
	public String nullAbleMethod() {
		return "This is statement.";
	}

	// Method-4
	public void numberTest() throws Exception {

		int a = 5;
		if (a != 6) {
			throw new Exception("Number is not same.");
		}
	}
}
