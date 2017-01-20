package ua.alex.project.greeting;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.common.base.Preconditions;

public class Greeting {

	private final ApplicationContext context = new ClassPathXmlApplicationContext(
			"locale.xml");

	//List of Locale languages that is covered by App
	private static List<String> supportedLanguages = Arrays.asList("ru", "en");
	private static final Locale DEFAULT_LOCALE = Locale.US;
	
	private static Logger log = LoggerFactory.getLogger(Greeting.class);

	/**
	 * Determines if the Customer Locale language is covered by App
	 * @param data 
	 * @return true if language is covered
	 */
	public boolean localeQualifier(UserData data) {
		Preconditions.checkState(data.validate(),
				"Error occured during loading time and locale!");
		for(String lang: supportedLanguages){
			if(data.getLocale().getLanguage().equalsIgnoreCase(lang)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Finds the greeting based on Locale and time
	 * @param data
	 * @return
	 */
	public String greetingFinder(UserData data) {
		log.trace("Start finding griting based on User locale and time!");
		Preconditions.checkState(data.validate(),
				"Error occured during loading time and locale!");		
		if(!localeQualifier(data)){
			data.setLocale(DEFAULT_LOCALE);
		}
		if (data.getHour() > 6 & data.getHour() < 9) {
			log.info("Loading message for morning greeting!");
			return context.getMessage("greeting.morning", null,
					data.getLocale());
		} else if (data.getHour() > 8 & data.getHour() < 19) {
			log.info("Loading message for day greeting!");
			return context.getMessage("greeting.day", null, data.getLocale());
		} else if (data.getHour() > 18 & data.getHour() < 23) {
			log.info("Loading message for evening greeting!");
			return context.getMessage("greeting.evening", null,
					data.getLocale());
		}
		log.info("Loading message for night greeting!");
		return context.getMessage("greeting.night", null, data.getLocale());
	}

	public static void main(String[] args) {
		UserData userData = new UserData();
		log.trace("Create instance of Greeting object!");
		Greeting greet = new Greeting();		
		System.out.println(greet.greetingFinder(userData));
	}

}
