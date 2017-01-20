package ua.alex.project.greeting;

import java.time.LocalDateTime;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;

public class UserData {
	
	private Locale locale;
	private int hour;
	private static Logger log = LoggerFactory.getLogger(UserData.class);

	public UserData() {
		this.locale = Locale.getDefault();
		this.hour = LocalDateTime.now().getHour();
		log.info("Created UserData instance with locale:" + locale
				+ " and local time: " + hour + "!");
	}

	public boolean validate() {
		log.trace("Start validating UserData object.");
		Preconditions.checkState(!(locale == null),
				"The locale can not be null!");
		Preconditions.checkState(!(hour > 23 | hour < 0),
				"The customer hour must be in range from 0 to 23 hours!");
		log.trace("UserData object validated.");
		return true;
	}

	public Locale getLocale() {
		return locale;
	}
	
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	
	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	@Override
	public String toString() {
		return "Greeting [locale=" + locale + ", hours=" + hour + "]";
	}
}
