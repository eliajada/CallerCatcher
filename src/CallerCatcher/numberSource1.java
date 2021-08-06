package CallerCatcher;

import java.io.FileWriter;
import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;

public class numberSource1 {

	public static void source1(String phoneNumber) {
		source1: {

			String sourceUrl = "";
			boolean pageLoaded = false;
			try {

				// Visit Source's URL
				sourceUrl = "https://www.shouldianswer.com/";
				Driver.get(sourceUrl);

				// Check if Source web page loaded
				if (Driver.isDisplayed("//*[@title=\"Should I Answer?\"]")) {
					pageLoaded = true;
				}

				// Continue if the page loaded
				if (pageLoaded) {

					Driver.sendKeys("//input[@type=\"text\"]", phoneNumber);

					Driver.click("//button[@type=\"submit\"]");

					// Check if web page loaded
					if (!Driver.isDisplayed("(//*[contains(text(),'Who called you from')])[2]")) {

						System.out.println("Source 1 failed to load");

						break source1;
					}

					//Caller ID xPath //*[@class="number"]/span[2]
					String numberElement = "(//*[contains(text(),'" + phoneNumber + "')])[3]";
					String callerIDElement = "//*[@class=\"number\"]/span[2]";
					String mainRateElement = "(//*[contains(text(),'" + phoneNumber + "')])[3]/following::text()[1]";
					String positiveRateElement = "(//*[contains(text(),'" + phoneNumber
							+ "')])[3]/following::text()[2]";
					String negativeRateElement = "(//*[contains(text(),'" + phoneNumber
							+ "')])[3]/following::text()[6]";
					String neutralRateElement = "(//*[contains(text(),'" + phoneNumber
							+ "')])[3]/following::text()[10]";

					String rating = "";
					if (!Driver.isDisplayed(numberElement)) {
						// Source Failed: number was not found
					} else {
						rating = Driver.getTextJS(mainRateElement);
						System.out.println("Rated: " + rating);
					}

					System.out.println("Overall Rating: " + Driver.getTextJS(mainRateElement));
					System.out.println("Positive Rating: " + Driver.getTextJS(positiveRateElement));
					System.out.println("Negative Rating: " + Driver.getTextJS(negativeRateElement));
					System.out.println("Neutral Rating: " + Driver.getTextJS(neutralRateElement));

					try {
						HashMap<String, HashMap<String, String>> sourceMap = new HashMap<String, HashMap<String, String>>();
						HashMap<String, String> detailMap = new HashMap<String, String>();
						detailMap.put("callerID", Driver.getText(callerIDElement));
						detailMap.put("overallRating", Driver.getTextJS(mainRateElement));
						detailMap.put("positiveRating", Driver.getTextJS(positiveRateElement));
						detailMap.put("negativeRating", Driver.getTextJS(negativeRateElement));
						detailMap.put("neutralRating", Driver.getTextJS(neutralRateElement));
						sourceMap.put("source1", detailMap);
						Driver.writeToJson(sourceMap);
					} catch (Exception c) {

					}

					
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
