package CallerCatcher;

import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Driver {

	public static ChromeDriver driver;

	public static void initializeDriver() {
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\Code\\Desktop\\CallerCatcherProject\\CallerCatcher\\driver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "driver\\patched\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();

		options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		options.addArguments("--disable-blink-features=AutomationControlled");
		options.addArguments("--incognito");
		// options.addArguments("--headless");
//		options.addArguments("--remote-debugging-port=9222");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-application-cache");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-extensions");
		options.addArguments("--test-type");
		options.addArguments("start-maximized");
		options.addArguments("disable-infobars");
		options.addArguments("--disable-blink-features");
		options.addArguments("--window-size=1920,1080");
		// randomize languages
		// options.addArguments("--lang=en-US");

		options.addArguments(
				"user-agent=Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.50 Safari/537.36");
		// System.out.println(driver.executeScript("return navigator.userAgent;"));
		options.addArguments("--disable-impl-side-painting");
		options.addArguments("--disable-setuid-sandbox");
		options.addArguments("--disable-seccomp-filter-sandbox");
		options.addArguments("--disable-breakpad");
		options.addArguments("--disable-client-side-phishing-detection");
		options.addArguments("--disable-cast");
		options.addArguments("--disable-cast-streaming-hw-encoding");
		options.addArguments("--disable-cloud-import");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("--disable-session-crashed-bubble");
		options.addArguments("--disable-ipv6");
		options.addArguments("--allow-http-screen-capture");
		// options.addArguments("user-data-dir=C:\\apps\\selenium\\chrome\\data");
//		options.addArguments("start-maximized");
//		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
//		options.setExperimentalOption("useAutomationExtension", false);
//		options.addArguments("--disable-blink-features");
//		options.addArguments("--disable-blink-features=AutomationControlled");
//		options.addArguments(
//				"user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36");
//
//		LoggingPreferences logPrefs = new LoggingPreferences();
//		logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
//		options.setCapability("goog:loggingPrefs", logPrefs);
//		// options.addArguments("--remote-debugging-host=127.0.0.1");

		// Randomize this
		// options.addArguments("user-agent=1wqfevwds3");
		// Can be used to get user-agent.

		// add Network logging
//	    LoggingPreferences logPrefs = new LoggingPreferences();
//	    logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
//	    options.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
//	    Map<String, Object> perfLogPrefs = new HashMap<String, Object>();
//	    perfLogPrefs.put("enableNetwork", true);
//	    perfLogPrefs.put("traceCategories", "devtools.network");
//	    options.setExperimentalOption("perfLoggingPrefs", perfLogPrefs);

		// options.setExperimentalOption("excludeSwitches",
		// Collections.singleton("disable-client-side-phishing-detection"));
//		options.setExperimentalOption("excludeSwitches", "safebrowsing-disable-download-protection");
//		options.setExperimentalOption("excludeSwitches", "safebrowsing-disable-auto-update");
//		options.setExperimentalOption("excludeSwitches", "disable-client-side-phishing-detection");

		// new options
		driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("source", "Object.defineProperty(navigator, 'webdriver', { get: () => undefined })");
//		driver.executeCdpCommand("Page.addScriptToEvaluateOnNewDocument", params);
		driver.executeScript("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})");

		// driver.get("https://www.google.com/");
		// driver.get("https://nowsecure.nl");

	}
	// Running Python script
//	try {
//		ProcessBuilder pb = new ProcessBuilder("C:\\Users\\Code\\AppData\\Local\\Programs\\Python\\Python39\\python.exe", "C:\\Users\\Code\\Desktop\\Project\\test.py");
//		pb.redirectOutput(Redirect.INHERIT);
//		Process p = pb.start();
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		System.out.println("Failed");
//		e.printStackTrace();
//	}

	/**
	 * Clicks web element
	 * 
	 * @param xPath
	 * @category Selenium
	 */
	public static void click(String xPath) {
		String methodName = new Throwable().getStackTrace()[0].getMethodName();
		try {

			// ---wait---
			randomWait();
			// ---wait---

			driver.findElement(By.xpath(xPath)).click();

			console.log(methodName, true, xPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Checks if web element is displayed
	 * 
	 * @param xPath
	 * @return isDisplayed
	 * @category Selenium
	 */
	public static boolean isDisplayed(String xPath) {
		boolean isDisplayed = false;
		try {

			// ---wait---
			randomWait();
			// ---wait---
			System.out.println(String.valueOf(driver.findElement(By.xpath(xPath)).isDisplayed()));
			isDisplayed = driver.findElement(By.xpath(xPath)).isDisplayed();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDisplayed;
	}

	/**
	 * Visit URL
	 * 
	 * @category Selenium
	 */
	public static void get(String url) {
		try {

			// ---wait---
			randomWait();

			driver.get(url);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getText(String xPath) {
		String text = "";
		try {

			text = driver.findElement(By.xpath(xPath)).getText();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return text;
	}

	public static String getTextJS(String xPath) {
		String text = "";
		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			Object load = js.executeScript("var value = document.evaluate(\"" + xPath
					+ "\",document, null, XPathResult.STRING_TYPE, null ); return value.stringValue;");
			text = String.valueOf(load);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return text;
	}

	public static void quit() {
		try {

			driver.quit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Send keys to a web element text field one character at a time split by a
	 * random wait
	 * 
	 * @param xPath
	 * @param keys
	 */
	public static void sendKeys(String xPath, String keys) {
		String methodName = new Throwable().getStackTrace()[0].getMethodName();
		try {

			String splitKey = "";
			for (int index = 0; index < keys.length(); index++) {

				splitKey = String.valueOf(keys.charAt(index));

				// random wait
				randomWait();
				// ----------

				driver.findElement(By.xpath(xPath)).sendKeys(splitKey);

				console.log(methodName, true, keys, splitKey);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Wait a random amount of seconds
	 * 
	 * @category Other
	 */
	public static void randomWait() {
		String methodName = new Throwable().getStackTrace()[0].getMethodName();
		try {

			int max = 6;
			int min = 1;
			int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
			TimeUnit.SECONDS.sleep(randomNum);

			console.log(methodName, true, randomNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void writeToJson(Object detailsMap) {
		String methodName = new Throwable().getStackTrace()[0].getMethodName();
		try {

			ObjectMapper mapper = new ObjectMapper();
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			mapper.writerWithDefaultPrettyPrinter().writeValue(Paths.get("json\\results.json").toFile(), detailsMap);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String readFromJson(String source, String key) {
		String methodName = new Throwable().getStackTrace()[0].getMethodName();
		String detail = "";
		try {

			JSONObject jsonObject = (JSONObject) new JSONParser().parse(new FileReader("json\\results.json"));
			JSONObject jsonObject2 = (JSONObject) jsonObject.get(source);
			detail = jsonObject2.get(key).toString();

			System.out.println("Getting '" + key + "' value from [" + source + "]");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return detail;
	}

}
