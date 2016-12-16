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
	
	@Test
	public void greetingFinder_night_us() throws Exception {
		data.setLocale(Locale.US);
		data.setHour(23);
		assertEquals(greeting.greetingFinder(data), "Good night, World!");
	}
	
	@Test
	public void greetingFinder_day_ru() throws Exception {
		data.setLocale(Locale.ROOT);
		data.setHour(10);
		assertEquals(greeting.greetingFinder(data), "Добрый день, Мир!");
	}
	
	@Test
	public void greetingFinder_evening_ru() throws Exception {
		data.setLocale(Locale.ROOT);
		data.setHour(19);
		assertEquals(greeting.greetingFinder(data), "Добрый вечер, Мир!");
	}
	
	@Test (expected=IllegalStateException.class)
	public void greetingFinder_error_locale() throws Exception {
		data.setLocale(null);
		data.setHour(19);
		assertEquals(greeting.greetingFinder(data), "Добрый вечер, Мир!");
		
	}
	
	@Test (expected=IllegalStateException.class)
	public void greetingFinder_error_hour() throws Exception {
		data.setLocale(Locale.ROOT);
		data.setHour(24);
		assertEquals(greeting.greetingFinder(data), "Добрый вечер, Мир!");
	}

}
