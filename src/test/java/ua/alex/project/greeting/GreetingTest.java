package ua.alex.project.greeting;

import static org.junit.Assert.*;

import java.util.Locale;

import org.junit.Before;
import org.junit.Test;

public class GreetingTest {

	@Test
	public void test_type() throws Exception {
		assertNotNull(Greeting.class);
	}
	
	private static final Greeting greeting = new Greeting();
	private UserData data;
	
	@Test
	public void test_instantiation() throws Exception {
		assertNotNull(greeting);
	}
	
	
	@Before
	public void set_up(){
		data = new UserData();
	}
	
	
	@Test
	public void test_greetingFinder_morning_us() throws Exception {
		data.setLocale(Locale.US);
		data.setHour(8);
		assertEquals("Good morning, World!", greeting.greetingFinder(data));
	}
	
	@Test
	public void test_greetingFinder_night_us() throws Exception {
		data.setLocale(Locale.US);
		data.setHour(23);
		assertEquals("Good night, World!", greeting.greetingFinder(data));
	}
	
	private static final Locale dLocale = new Locale("ru", "RU");;
	
	@Test
	public void test_greetingFinder_day_ru() throws Exception {
		data.setLocale(dLocale);
		data.setHour(10);
		assertEquals("Добрый день, Мир!", greeting.greetingFinder(data));
	}
	
	@Test
	public void test_greetingFinder_evening_ru() throws Exception {
		data.setLocale(dLocale);
		data.setHour(19);
		assertEquals("Добрый вечер, Мир!", greeting.greetingFinder(data));
	}
	
	@Test
	public void test_greetingFinder_fallback() throws Exception {
		data.setLocale(Locale.CHINA);
		assertEquals("Good day, World!", greeting.greetingFinder(data));
	}
	
	@Test (expected=IllegalStateException.class)
	public void test_greetingFinder_error_locale() throws Exception {
		data.setLocale(null);
		data.setHour(19);
		assertEquals("Добрый вечер, Мир!", greeting.greetingFinder(data));
		
	}
	
	@Test (expected=IllegalStateException.class)
	public void test_greetingFinder_error_hour() throws Exception {
		data.setLocale(dLocale);
		data.setHour(24);
		assertEquals("Добрый вечер, Мир!", greeting.greetingFinder(data));
	}
	
	@Test
	public void test_localeQualifier() throws Exception {
		data.setLocale(dLocale);
		assertTrue(greeting.localeQualifier(data));
		data.setLocale(Locale.US);
		assertTrue(greeting.localeQualifier(data));
	}
	
	@Test
	public void test_localeQualifier_error() throws Exception {
		data.setLocale(Locale.GERMAN);
		assertFalse(greeting.localeQualifier(data));
	}

}
