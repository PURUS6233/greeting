package ua.alex.project.greeting;

import static org.junit.Assert.*;

import java.util.Locale;

import org.junit.Test;

public class GreetingTest {

	@Test
	public void test_type() throws Exception {
		assertNotNull(Greeting.class);
	}
	
	private static final Greeting greeting = new Greeting();;
	
	@Test
	public void test_instantiation() throws Exception {
		assertNotNull(greeting);
	}
	
	private static final UserData data = new UserData();
	
	@Test
	public void greetingFinder_morning_us() throws Exception {
		data.setLocale(Locale.US);
		data.setHour(8);
		assertEquals(greeting.greetingFinder(data), "Good morning, World!");
	}

}
