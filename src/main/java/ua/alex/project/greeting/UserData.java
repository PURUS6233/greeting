package ua.alex.project.greeting;

import java.time.LocalDateTime;
import java.util.Locale;

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
		if((locale == null) || (hour > 23 || hour < 0)){
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "UserLocale [locale=" + locale + ", hour=" + hour + "]";
	}
}
