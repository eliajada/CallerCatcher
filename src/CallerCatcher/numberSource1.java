package CallerCatcher;

public class numberSource1 {

	public static void source1() {
		try {

			driver.get("https://www.usphonebook.com/");
			
			driver.randomWait();
			
			driver.sendKeys("//input[@type=\"tel\"]", "12345");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
