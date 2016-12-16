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
		assertEquals("Good morning, World!", greeting.greetingFinder(data));
	}
	
	@Test
	public void greetingFinder_night_us() throws Exception {
		data.setLocale(Locale.US);
		data.setHour(23);
		assertEquals("Good night, World!", greeting.greetingFinder(data));
	}
	
	private static final Locale dLocale = new Locale.Builder().setLanguage("ru").setScript("Ru").build();
	
	@Test
	public void greetingFinder_day_ru() throws Exception {
		data.setLocale(dLocale);
		data.setHour(10);
		assertEquals("Добрый день, Мир!", greeting.greetingFinder(data));
	}
	
	@Test
	public void greetingFinder_evening_ru() throws Exception {
		data.setLocale(dLocale);
		data.setHour(19);
		assertEquals("Добрый вечер, Мир!", greeting.greetingFinder(data));
	}
	
	@Test (expected=IllegalStateException.class)
	public void greetingFinder_error_locale() throws Exception {
		data.setLocale(null);
		data.setHour(19);
		assertEquals("Добрый вечер, Мир!", greeting.greetingFinder(data));
		
	}
	
	@Test (expected=IllegalStateException.class)
	public void greetingFinder_error_hour() throws Exception {
		data.setLocale(Locale.ROOT);
		data.setHour(24);
		assertEquals("Добрый вечер, Мир!", greeting.greetingFinder(data));
	}

}
