package ua.alex.project.greeting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.common.base.Preconditions;

public class Greeting {

	private final ApplicationContext context = new ClassPathXmlApplicationContext(
			"locale.xml");

	private static Logger log = LoggerFactory.getLogger(Greeting.class);

	public String greetingFinder(UserData data) {
		log.trace("Start finding griting based on User locale and time!");
		Preconditions.checkState(data.validate(),
				"Error occured during loading time and locale!");
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
