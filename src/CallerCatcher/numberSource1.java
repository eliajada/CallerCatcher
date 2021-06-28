package CallerCatcher;

public class numberSource1 {

	public static void source1(String phoneNumber) {
		source1: {

			String sourceUrl = "";
			boolean pageLoaded = false;
			try {

				// Visit Source's URL
				sourceUrl = "https://www.shouldianswer.com/";
				driver.get(sourceUrl);

				// Check if Source web page loaded
				if (driver.isDisplayed("//*[@title=\"Should I Answer?\"]")) {
					pageLoaded = true;
				}

				// Continue if the page loaded
				if (pageLoaded) {

					driver.sendKeys("//input[@type=\"text\"]", phoneNumber);

					driver.click("//button[@type=\"submit\"]");

					// Check if web page loaded
					if (!driver.isDisplayed("//*[contains(text(),\"Who called you from  " + phoneNumber + " ?\")]")) {
						break source1;
					}

					String numberElement = "(//*[contains(text(),'" + phoneNumber + "')])[3]";
					String mainRateElement = "(//*[contains(text(),'" + phoneNumber + "')])[3]/following::text()[1]";
					String positiveRateElement = "(//*[contains(text(),'" + phoneNumber
							+ "')])[3]/following::text()[2]";
					String negativeRateElement = "(//*[contains(text(),'" + phoneNumber
							+ "')])[3]/following::text()[6]";
					String neutralRateElement = "(//*[contains(text(),'" + phoneNumber
							+ "')])[3]/following::text()[10]";

					if (!driver.isDisplayed(numberElement)) {
						// Source Failed: number was not found
					} else {
						String rating = driver.getTextJS(mainRateElement);
						System.out.println("Rated: " + rating);
					}

					// (//*[contains(text(),'6156713047')])[3]/following::text()[1]

				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
