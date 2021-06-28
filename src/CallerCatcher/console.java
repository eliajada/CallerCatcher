package CallerCatcher;

public class console {

	public static void log(String method, boolean passed, Object item1, Object item2) {
		switch (method) {
		// driver.randomWait()
		case "randomWait":
			if (passed) {
				System.out.println("Waiting for " + item1 + " second(s)");
			} else if (!passed) {

			}
			break;
		// driver.sendKeys()
		case "sendKeys":
			if (passed) {
				System.out.println("Sending [" + item2 + "] from (" + item1 + ")");
			} else if (!passed) {

			}
			break;
		// driver.sendKeys()
		case "click":
			if (passed) {
				System.out.println("Clicking [" + item2 + "]");
			} else if (!passed) {
				System.out.println("Clicking [" + item2 + "] Failed.");
			}
			break;
		}
	}

	public static void log(String method, boolean passed) {
		log(method, passed, "", "");
	}

	public static void log(String method, boolean passed, Object item1) {
		log(method, passed, item1, "");
	}

}
