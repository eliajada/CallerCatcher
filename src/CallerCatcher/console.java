package CallerCatcher;

public class console {

	public static void log(String className, int lineNumber, String methodName, boolean passed, Object item1,
			Object item2, Object item3) {

		// Get rid of "CallerCatcher" from full class name
		className = className.substring(className.lastIndexOf(".") + 1);
		// println("--> "+className + "." + methodName + "(): ln:" + lineNumber);
		println("\n--> " + className + "." + methodName + "():\n");

		String action = "";
		switch (methodName) {
//		// Driver.randomWait()
//		case "randomWait":
//			action = "Wait for [" + item1 + "] second(s)";
//			break;
		// Driver.click()
		case "click":
			action = "Click [" + item1 + "]";
			break;
		// Driver.isDisplayed()
		case "isDisplayed":
			action = "Check if [" + item1 + "] is displayed";
			break;
		// Driver.get()
		case "get":
			action = "Visit website [" + item1 + "]";
			break;
		// Driver.getText()
		case "getText":
			action = "Get text from [" + item1 + "] \nText: (" + item2 + ")";
			break;
		// Driver.getTextJS()
		case "getTextJS":
			action = "Get text from [" + item1 + "] -JavaScript \nText: (" + item2 + ")";
			break;
		// Driver.quit()
		case "quit":
			action = "Quitting Webdriver";
			break;
		// Driver.sendKeys()
		case "sendKeys":
			action = "Send Keys to [" + item1 + "] \nKeys: (" + item2 + ")";
			break;
		// Driver.writeToJson()
		case "writeToJson":
			action = "Write to JSON [" + item1 + "]";
			break;
		// Driver.readFromJson()
		case "readFromJson":
			action = "Read JSON for [" + item2 + "] in [" + item1 + "] \nDetails: " + item3;
			break;
		// Driver.writeToLabel()
		case "writeToLabel":
			action = "Write [" + item2 + "] to Label [" + item1 + "]";
			break;
		// CallerCatcher.sourceWriting()
		case "sourceWriting":
			action = "sourceWriting for [" + item1 + "]";
			break;
		// CallerCatcher.writeToScene()
		case "writeToScene":
			action = "writeToScene completed";
			break;
		}

		if (passed) {
			println("~ [Pass]: " + action);
		} else if (!passed) {
			println("~ {Fail}: " + action);
		}
	}

	// item1, item2
	public static void log(String className, int lineNumber, String methodName, boolean passed, Object item1,
			Object item2) {
		log(className, lineNumber, methodName, passed, item1, item2, "");
	}

	// item1
	public static void log(String className, int lineNumber, String methodName, boolean passed, Object item1) {
		log(className, lineNumber, methodName, passed, item1, "", "");
	}

	// no items
	public static void log(String className, int lineNumber, String methodName, boolean passed) {
		log(className, lineNumber, methodName, passed, "", "", "");
	}

	static void println(Object line) {
		System.out.println(line);
	}

}
