package ua.alex.project.greeting;

import java.time.LocalDateTime;
import java.util.Locale;

import com.google.common.base.Preconditions;

public class UserData {
	
	private Locale locale;
	private int hour;
	
	public UserData(){
		this.locale = Locale.getDefault();
		this.hour = LocalDateTime.now().getHour();
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
	
	public boolean validate(){
		Preconditions.checkState(!(locale == null),
				"The locale can not be null!");
		Preconditions.checkState(!(hour > 23 || hour < 0),
				"The customer hour must be in range from 0 to 23 hours!");
		return true;
	}
	
	@Override
	public String toString() {
		return "UserLocale [locale=" + locale + ", hour=" + hour + "]";
	}
}
