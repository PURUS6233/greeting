package ua.alex.project.greeting;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ua.alex.project.greeting.UserLocale;

public class UserLocaleTest {
	
	@Test
	public void test_type() throws Exception {
		assertNotNull(UserLocale.class);
	}
	
	@Test
	public void test_instantiation() throws Exception {
		UserLocale data = new UserLocale();
		assertNotNull(data);
	}
	
	@Test
	public void test_validate_true() throws Exception {
		UserLocale data = new UserLocale();
		assertTrue(data.validate());
	}
	
	@Test
	public void test_validate_false_hour() throws Exception {
		UserLocale data = new UserLocale();
		data.setHour(24);
		assertFalse(data.validate());
	}
	
	@Test
	public void test_validate_false_locale() throws Exception {
		UserLocale data = new UserLocale();
		data.setLocale(null);
		assertFalse(data.validate());
	}

}
