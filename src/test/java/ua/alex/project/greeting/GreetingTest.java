package ua.alex.project.greeting;

import static org.junit.Assert.*;

import org.junit.Test;

public class GreetingTest {

	@Test
	public void test_type() throws Exception {
		assertNotNull(Greeting.class);
	}
	
	@Test
	public void test_instantiation() throws Exception {
		Greeting greeting = new Greeting();
		assertNotNull(greeting);
	}
	
	@Test
	public void test_greetingBasedOnHourFinder() throws Exception {
		UserData data = new UserData();
		Greeting greeting = new Greeting();
		assertNotNull(greeting.greetingBasedOnHourFinder(data));
	}

}
