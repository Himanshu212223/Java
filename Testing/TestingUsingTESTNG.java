/*
	Testing :-
	______________________
	
	- @Test annotation is used to make a method gets executed for Testing.
	- @Tag annotation is used to make it easy for tester or developer to under which method we are going to test.
		It is used to put the methods into some groups.
*/

package com.Testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestingUsingTESTNG {
	MethodsForTesting testObj1 = new MethodsForTesting();

	@Tag("TestingMethod-1")
	@Test
	public void TestingMethod_1_1() {
		int actual = testObj1.addNumbers(3, 5) ;
		int expected = 3+5 ;
		Assertions.assertEquals(expected, actual);
	}
	
	@Tag("TestingMethod-1")
	@Test
	public void TestingMethod_1_2() {
		int actual = testObj1.addNumbers(3, 5) ;
		int expected = 3+5 ;
		Assertions.assertNotEquals(expected, actual);
	}
	
	@Tag("TestingMethod-2")
	@Test
	public void TestingMethod_2_1() {
		boolean actual = testObj1.checkAge(5) ;
		Assertions.assertTrue(actual) ;
	}
	
	@Tag("TestingMethod-2")
	@Test
	public void TestingMethod_2_2() {
		boolean actual = testObj1.checkAge(5) ;
		Assertions.assertFalse(actual) ;
	}
	
	@Tag("TestingMethod-3")
	@Test
	public void TestingMethod_3_1() {
		String val = testObj1.nullAbleMethod() ;
		Assertions.assertNull(val);
	}
	
	@Tag("TestingMethod-3")
	@Test
	public void TestingMethod_3_2() {
		String val = testObj1.nullAbleMethod() ;
		Assertions.assertNotNull(val) ;
	}
	
	@Tag("TestingMethod-4")
	@Test
	public void TestingMethod_4_1() {
		//	checking whether got an exception or not.
		Exception actual = Assertions.assertThrows(Exception.class, () -> testObj1.numberTest()) ;
	}
	
	@Tag("TestingMethod-4")
	@Test
	public void TestingMethod_4_2() {
		Exception actual = Assertions.assertThrows(Exception.class, () -> testObj1.numberTest()) ;
		String expected = "Number is not same." ;
		Assertions.assertEquals(expected, actual.getMessage()) ;
	}
	
	//	PARAMETERIZED TESTING
	
	@Tag("TestingMethod-1")
	@ParameterizedTest
	@CsvSource(value = {"1,5,6", "5,6,11", "15,16,35"} )
	public void TestingMethod_1_3(int numb1, int numb2, int expected) {
		int actual = testObj1.addNumbers(numb1, numb2) ;
		Assertions.assertEquals(expected, actual) ;
	}
	
	@Tag("TestingMethod-2")
	@ParameterizedTest
	@CsvSource(value = {"10, true", "200, true", "5, true"} )
	public void TestingMethod_2_3(int age, boolean expected) {
		boolean actual = testObj1.checkAge(age) ;
		Assertions.assertEquals(expected, actual);
	}
}
