package ua.alex.project.greeting;

public class Greeting {
	
	public String greetingBasedOnHourFinder(UserData data) throws Exception{
		if(!data.validate()){
			throw new Exception("Error occured during loading time and locale!");
		}
		if (data.getHour() > 6 & data.getHour() < 9) {
			return "Good morning, World!";
		} else if (data.getHour() > 8 & data.getHour() < 19) {
			return "Good day, World!";
		} else if (data.getHour() > 18 & data.getHour() < 23) {
			return "Good evening, World!";
		}
		return "Good night, World!";
	}
	
	public static void main(String[] args) throws Exception{
		UserData userData = new UserData();
		Greeting greet = new Greeting();
		System.out.println(greet.greetingBasedOnHourFinder(userData));
	}

}
