package tylerhayes.tools;

public class TestDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Log log = new Log("/home/tgh/workspace/JavaTools/test.log");
		log.logHeader("START");
		log.logGeneralMessage("Nothing to report.", 0, false);
		log.enableStdoutForAll();
		log.logData("speed = FULL", 0, false);
		log.logError("Oops.", 0, false);
		log.disableStdoutForAll();
		log.enableStdoutForErrorsOnly();
		log.logWarning("Warning. Iceberg ahead.", 0, false);
		log.logFatalError("We're dead.", 0, false);
		log.close("END");
	}

}
