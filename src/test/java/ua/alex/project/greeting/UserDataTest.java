package ua.alex.project.greeting;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ua.alex.project.greeting.UserData;

public class UserDataTest {
	
	@Test
	public void test_type() throws Exception {
		assertNotNull(UserData.class);
	}
	
	@Test
	public void test_instantiation() throws Exception {
		UserData data = new UserData();
		assertNotNull(data);
	}
	
	@Test
	public void test_validate_true() throws Exception {
		UserData data = new UserData();
		assertTrue(data.validate());
	}
	
	@Test (expected = IllegalStateException.class)
	public void test_validation_error() throws Exception {
		UserData data = new UserData();
		data.setHour(24);
		assertFalse(data.validate());
	}

}
