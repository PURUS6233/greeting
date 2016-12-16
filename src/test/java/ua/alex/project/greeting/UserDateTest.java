package ua.alex.project.greeting;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ua.alex.project.greeting.UserDate;

public class UserDateTest {
	
	@Test
	public void test_type() throws Exception {
		assertNotNull(UserDate.class);
	}
	
	@Test
	public void test_instantiation() throws Exception {
		UserDate data = new UserDate();
		assertNotNull(data);
	}
	
	@Test
	public void test_validate_true() throws Exception {
		UserDate data = new UserDate();
		assertTrue(data.validate());
	}
	
	@Test
	public void test_validate_false_hour() throws Exception {
		UserDate data = new UserDate();
		data.setHour(24);
		assertFalse(data.validate());
	}
	
	@Test
	public void test_validate_false_locale() throws Exception {
		UserDate data = new UserDate();
		data.setLocale(null);
		assertFalse(data.validate());
	}

}
