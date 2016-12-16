package ua.alex.project.greeting;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class UserLocale {
	
	private Locale locale;
	private int hour;
	
	public UserLocale(){
		this.locale = Locale.getDefault();
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(new Date());
		this.hour = calendar.get(Calendar.HOUR);
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
