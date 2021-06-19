package CallerCatcher;

public class console {

	public static void log(String method, boolean passed, Object item1) {
		switch (method) {
		case "randomWait":
			System.out.println("randomWait():");
			if (passed) {
				System.out.println("Waiting for " + item1 + " second(s)");
			} else if (!passed) {

			}
			break;
		}
	}

	public static void log(String method, boolean passed) {
		log(method, passed);
	}

}
