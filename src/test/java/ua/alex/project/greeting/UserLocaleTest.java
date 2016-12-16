package ua.alex.project.greeting;

import static org.junit.Assert.assertNotNull;

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

}
