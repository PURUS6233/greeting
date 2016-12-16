package ua.alex.project.greeting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;

public class Greeting {
	
	private static Logger log = LoggerFactory.getLogger(Greeting.class);
	
	public String greetingBasedOnHourFinder(UserData data) throws Exception{
		log.trace("Start finding griting based on User locale and time!");
		Preconditions.checkState(data.validate(),
				"Error occured during loading time and locale!");
		if (data.getHour() > 6 & data.getHour() < 9) {
			log.info("Loading message for morning greeting!");
			return "Good morning, World!";
		} else if (data.getHour() > 8 & data.getHour() < 19) {
			log.info("Loading message for day greeting!");
			return "Good day, World!";
		} else if (data.getHour() > 18 & data.getHour() < 23) {
			log.info("Loading message for evening greeting!");
			return "Good evening, World!";
		}
		log.info("Loading message for night greeting!");
		return "Good night, World!";
	}
	
	public static void main(String[] args) throws Exception{
		UserData userData = new UserData();
		log.trace("Create instance of Greeting object!");
		Greeting greet = new Greeting();
		System.out.println(greet.greetingBasedOnHourFinder(userData));
	}

}
